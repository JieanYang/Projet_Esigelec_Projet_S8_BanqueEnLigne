package dao;

import java.util.*;
import java.util.Date;

import Class.User;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * 
 */
public class UserDao {
    /**
     * Parameter for connection with the database, URL, LOGIN and PASSWORD are constant
     */
    final static String URL = "jdbc:mysql://localhost/projet_s8_banque?useSLL=false"; // disable SSL
    final static String username = "root";
    final static String password ="";
    
    /**
     * Tools for connection and operation with the BDD
     */
    private  Connection connection;
    private  PreparedStatement ps;
    private  ResultSet rs;
    

    /**
     * Default constructor
     */
    public UserDao() {
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
     * @param Class User -> user 
     * @return Class User -> retour
     */
    public User addUser(User user) {
        User retour = null;
        int success = 0;
        this.connection();
        
        try {
            String sql ="INSERT INTO User(categorie_user, nom, prenom, email, adresse, telephone,"+
            			" ville, pays, password, dateNaissance) "+
            			"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getCategorie_user());
            ps.setString(2, user.getNom());
            ps.setString(3, user.getPrenom());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getAdresse());
            ps.setString(6, user.getTelephone());
            ps.setString(7, user.getVille());
            ps.setString(8, user.getPays());
            ps.setString(9, user.getPassword());
            ps.setDate(10, (java.sql.Date) user.getDateNaissance());
            
            /*
             * Execute the sql to add a new user
             * If everything work, return int 1
             */
            success = ps.executeUpdate();
            
            /**
             * After success to add User
             * we will find the User we added by the field id_user, categorie_user and date_create
             * 
             */
            if (success == 1) {
                
                sql = "SELECT id_user FROM User WHERE email=?";
                ps = connection.prepareStatement(sql);
                ps.setString(1, user.getEmail());
                
                rs = ps.executeQuery();

                if(rs.next()) {
                    int id_user = rs.getInt("id_user");
                    retour = this.getUser(id_user);
                }
            }else if (success == 0) {
                retour = null;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.disconnection();
        }
        
        return retour; // return an instance of Class User
    }

    /**
     * @param Class User -> user 
     * @return Class User -> retour
     */
    public User updateUser(User user) {
    	User retour = null;
    	int success = 0;
    	this.connection();
        
    	try {
        	String sql ="UPDATE User SET categorie_user=?, nom=?, prenom=?, email=?, adresse=?,"+
        				" telephone=?, ville=?, pays=?, password=?, dateNaissance=? WHERE id_user=?";
        	ps = connection.prepareStatement(sql);
        	ps.setString(1, user.getCategorie_user());
        	ps.setString(2, user.getNom());
        	ps.setString(3, user.getPrenom());
        	ps.setString(4, user.getEmail());
        	ps.setString(5, user.getAdresse());
        	ps.setString(6, user.getTelephone());
        	ps.setString(7, user.getVille());
        	ps.setString(8, user.getPays());
        	ps.setString(9, user.getPassword());
//        	Timestamp stamp = new Timestamp(System.currentTimeMillis());
//    		java.sql.Date date = new java.sql.Date(stamp.getTime());
        	ps.setDate(10, (java.sql.Date) user.getDateNaissance());
        	ps.setInt(11, user.getId_user());
        	
        	/*
        	 * Execute the sql to add a new user
        	 * If everything work, return int 1
        	 */
        	success = ps.executeUpdate(); // if everything good work, retourn integer 1
        	
        	/**
        	 * After success to update User
        	 * we will find the User we updated by the field id_user
        	 * Because the field id_user is unique in the BDD
        	 * we use the method .getUser(int id) to find the user in BDD
        	 * 
        	 */
        	if (success == 1 ) {
        		retour = this.getUser(user.getId_user());
        	} else if(success == 0) {
        		retour = null;
        	}
        	
        } catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.disconnection();
		}
    	
        return retour; // return an instance of Class User
    }

    /**
     * @param int -> id
     * @return Class User -> retour
     */
    public User getUser(int id) {
    	User retour = null;
        this.connection();
        
        try {
            String sql ="SELECT * FROM User WHERE id_user = ?";
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
                retour = new User(rs.getInt("id_user"), rs.getString("categorie_user"), rs.getString("nom"),
                		rs.getString("prenom"), rs.getString("email"), rs.getString("adresse"), 
                        rs.getString("telephone"),  rs.getString("ville"), rs.getString("pays"), 
                        rs.getString("password"), rs.getDate("dateNaissance"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.disconnection();
        }
        
        return retour;
    }
    public boolean getCredentials(String email, String password) {
		this.connection();
    	

		String sql = "SELECT * FROM user WHERE (categorie_user = 'client') and (email = ?) and (password = ?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// https://stackoverflow.com/questions/65035/does-finally-always-execute-in-java
			this.disconnection();
		}
		return false;
	}
    
    
    public int getIdUser(String email, String password) {
		this.connection();
    	int retour = 0;

		String sql = "SELECT id_user FROM user WHERE (categorie_user = 'client') and (email = ?) and (password = ?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				rs.getInt("id_user");
				return retour;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// https://stackoverflow.com/questions/65035/does-finally-always-execute-in-java
			this.disconnection();
		}
		return retour ;
	}
    
    /**
     * @param void
     * @return List<User> -> retour
     */
    public List<User> getListUser() {
		List<User> retour = new ArrayList<User>();
        this.connection();
        
        try {
            String sql ="SELECT * FROM User ORDER BY id_user";
            ps = connection.prepareStatement(sql);
            
            /**
             * We take out all the user in the BDD
             * 
             */
            rs = ps.executeQuery();
            // passe a la premiere (et unique) ligne retournee
            while(rs.next()) {
                /*
                 * We create a new instance of User and 
                 * then use method List.add() to add into the retour
                 */
                retour.add(new User(rs.getInt("id_user"), rs.getString("categorie_user"), rs.getString("nom"),
                        rs.getString("prenom"), rs.getString("email"), rs.getString("adresse"), 
                        rs.getString("telephone"),  rs.getString("ville"), rs.getString("pays"), 
                        rs.getString("password"), rs.getDate("dateNaissance")));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.disconnection();
        }
        
        return retour; // return a list User
        
    }

    /**
     * @param Class User -> user
     * @return int -> retour
     */
    public int deleteUser(User user) {
        int retour = 0;
        this.connection();
        
        try {
            String sql ="DELETE FROM User WHERE id_user = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, user.getId_user());
            /*
             * We find the user by id_user
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