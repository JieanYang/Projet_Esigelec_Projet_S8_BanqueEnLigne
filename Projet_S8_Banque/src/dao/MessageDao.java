package dao;

import java.util.*;
import java.util.Date;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;


import Class.Message;

/**
 * 
 */
public class MessageDao {

	
	
	/**
	 * Parameter for connection with the database, URL, LOGIN and PASSWORD are constant
	 */
	final static String URL = "jdbc:mysql://localhost/projet_s8?useSLL=false"; // disable SSL
	final static String username = "root";
	final static String password ="";
	
	/**
	 * Tools for connection and operation with the BDD
	 */
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	
    /**
     * Default constructor
     */
    public MessageDao() {
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    /**
	 * Connecting to database
	 */
	public void connection() {
		try {
			connection = DriverManager.getConnection(URL, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Closing connection
	 */
	public void disconnection() {
		// fermeture du ResultSet, du PreparedStatement et de la Connexion
		try {
			if (rs != null)
				rs.close();
		} catch (Exception ignore) {
		}
		try {
			if (ps != null)
				ps.close();
		} catch (Exception ignore) {
		}
		try {
			if (connection != null)
				connection.close();
		} catch (Exception ignore) {
		}
	}

    /**
     * @param Class Message -> message 
     * @return Class Message -> retour
     */
    public Message addMessage(Message message) {
        Message retour = null;
        int success = 0;
    	this.connection();
        
    	try {
        	String sql ="INSERT INTO Message(nom, prenon, numphone, email, problem, reponse, date) "
        			+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
        	ps = connection.prepareStatement(sql);
        	ps.setString(1, message.getNom());
        	ps.setString(2, message.getPrenom());
        	ps.setString(3, message.getNumphone());
        	ps.setString(4, message.getEmail());
        	ps.setString(5, message.getProblem());
        	ps.setString(6, message.getReponse());
        	Date utildate = new Date();         
        	Timestamp sqldate = new Timestamp(utildate.getTime());   
        	ps.setTimestamp(7, sqldate);  
        	/*java.util.Date utilDate1 = new java.util.Date();
        	SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        	java.util.Date utilDate = new java.util.Date();
        	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());*/
        	
        	/*
        	 * Execute the sql to add a new message
        	 * If everything work, return int 1
        	 */
        	success = ps.executeUpdate();
        	
        	
        	/**
        	 * After success to add Message
        	 * we will find the Message we added by the field problem
        	 * Because the field problem is unique in the BDD
        	 * 
        	 */
        	if (success == 1) {
        		sql = "SELECT id_message FROM Message WHERE problem=?";
        		ps = connection.prepareStatement(sql);
        		ps.setString(1, message.getProblem());
        		rs = ps.executeQuery();
        		
        		if(rs.next()) {
        			int id_message = rs.getInt("id_message");
        			retour = this.getMessage(id_message);
        		}
        	}else if (success == 0) {
        		retour = null;
        	}
        	
        } catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.disconnection();
		}
    	
        return retour; // return an instance of Class Message
    }

    /**
     * @param Class Message -> message 
     * @return Class Message -> retour
     */
    public Message updateMessage(Message message) {
    	Message retour = null;
    	int success = 0;
    	this.connection();
        
    	try {
        	String sql ="UPDATE Message SET nom=?, prenom=?, numphone=?, email=?, problem=?, reponse=? WHERE id_message=?";
        	ps = connection.prepareStatement(sql);
        	ps.setString(1, message.getNom());
        	ps.setString(2, message.getPrenom());
        	ps.setString(3, message.getNumphone());
        	ps.setString(4, message.getEmail());
        	ps.setString(5, message.getProblem());
        	ps.setString(6, message.getReponse());
        	ps.setInt(7, message.getId_message());
        	
        	/*
        	 * Execute the sql to add a new message
        	 * If everything work, return int 1
        	 */
        	success = ps.executeUpdate(); // if everything good work, retourn integer 1
        	
        	/**
        	 * After success to update Message
        	 * we will find the Message we updated by the field id_message
        	 * Because the field id_message is unique in the BDD
        	 * we use the method .getMessage(int id) to find the message in BDD
        	 * 
        	 */
        	if (success == 1 ) {
        		retour = this.getMessage(message.getId_message());
        	} else if(success == 0) {
        		retour = null;
        	}
        	
        } catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.disconnection();
		}
    	
        return retour; // return an instance of Class Message
    }

    /**
     * @param int -> id 
     * @return Class Message -> retour
     */
    public Message getMessage(int id) {
    	Message retour = null;
    	this.connection();
        
    	try {
        	String sql ="SELECT * FROM Message WHERE id_message = ?";
        	ps = connection.prepareStatement(sql);
        	ps.setInt(1, id);
        	
        	/**
        	 * on execute la requete
        	 * rs contient un pointeur situe juste avant la premiere ligne retournee
        	 * 
        	 */
        	rs = ps.executeQuery();
        	// passe a la premiere (et unique) ligne retournee
        	if (rs.next()) {
        		retour = new Message(rs.getInt("id_message"), rs.getString("nom"), rs.getString("prenom"),
        				rs.getString("numphone"), rs.getString("email"), rs.getString("problem"),
        				rs.getString("reponse"), rs.getTimestamp("date"));
        	}
        	
        } catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.disconnection();
		}
    	
        return retour;
    }

    /**
     * @param void
     * @return List<Message> -> retour
     */
    public List<Message> getListMessage() {
    	List<Message> retour = new ArrayList<Message>();
    	this.connection();
        
    	try {
        	String sql ="SELECT * FROM Message ORDER BY date DESC";
        	ps = connection.prepareStatement(sql);
        	
        	/**
        	 * We take out all the message in the BDD
        	 * 
        	 */
        	rs = ps.executeQuery();
        	// passe a la premiere (et unique) ligne retournee
        	while(rs.next()) {
        		/*
        		 * We create a new instance of Message and 
        		 * then use method List.add() to add into the retour
        		 */
        		retour.add(new Message(rs.getInt("id_message"), rs.getString("nom"), rs.getString("prenom"),
        				rs.getString("numphone"), rs.getString("email"), rs.getString("problem"),
        				rs.getString("reponse"), rs.getTimestamp("date")));
        	}
        	
        } catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.disconnection();
		}
    	
        return retour; // return a list Message
    }

    /**
     * @param Class Message -> message 
     * @return int -> retour
     */
    public int deleteMessage(Message message) {
    	int retour = 0;
    	this.connection();
        
    	try {
        	String sql ="DELETE FROM Message WHERE id_message = ?";
        	ps = connection.prepareStatement(sql);
        	ps.setInt(1, message.getId_message());
        	/*
        	 * We find the message by id_message
        	 * If everything good work, retourn integer 1
        	 */
        	retour = ps.executeUpdate();
        	
        } catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.disconnection();
		}
    	
        return retour; // return 1 -> success or return 0 -> fail
    }

}