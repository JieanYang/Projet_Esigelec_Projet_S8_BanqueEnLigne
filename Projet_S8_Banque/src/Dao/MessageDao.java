package Dao;

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
	final static String URL = "jdbc:mysql://localhost/projet_s8_banque?useSLL=false"; // disable SSL
	final static String username = "root";
	final static String password ="";
	
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	
    /**
     * Default constructor
     */
    public MessageDao() {
    	try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
     * @param message 
     * @return
     */
    public Message addMessage(Message message) {
        Message retour = null;
        int success = 0;
    	this.connection();
        
    	try {
        	String sql ="INSERT INTO Message(nom, prenom, numphone, email, problem, reponse, date) "
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
        	    	
        	success = ps.executeUpdate(); // if everything work, return int 1
        	
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
    	
        return retour;
    }

    /**
     * @param message 
     * @return
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
        	
        	success = ps.executeUpdate(); // if everything good work, retourn integer 1
        	
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
    	
        return retour;
    }

    /**
     * @param id 
     * @return
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
        	 * rs contient un pointeur situe juste avant la premiere ligne
        	 * retournee
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
     * @return
     */
    public List<Message> getListMessage() {
    	List<Message> retour = new ArrayList<Message>();
    	this.connection();
        
    	try {
        	String sql ="SELECT * FROM Message";
        	ps = connection.prepareStatement(sql);
        	
        	/**
        	 * on execute la requete
        	 * rs contient un pointeur situe juste avant la premiere ligne
        	 * retournee
        	 */
        	rs = ps.executeQuery();
        	// passe a la premiere (et unique) ligne retournee
        	while(rs.next()) {
        		retour.add(new Message(rs.getInt("id_message"), rs.getString("nom"), rs.getString("prenom"),
        				rs.getString("numphone"), rs.getString("email"), rs.getString("problem"),
        				rs.getString("reponse"), rs.getTimestamp("date")));
        	}
        	
        } catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.disconnection();
		}
    	
        return retour;
    }

    /**
     * @param message 
     * @return
     */
    public int deleteMessage(Message message) {
    	int retour = 0;
    	this.connection();
        
    	try {
        	String sql ="DELETE FROM Message WHERE id_message = ?";
        	ps = connection.prepareStatement(sql);
        	ps.setInt(1, message.getId_message());
        	
        	retour = ps.executeUpdate(); // if everything good work, retourn integer 1
        	
        } catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.disconnection();
		}
    	
        return retour;
    }

}