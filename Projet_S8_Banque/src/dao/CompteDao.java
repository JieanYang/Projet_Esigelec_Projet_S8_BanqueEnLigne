package dao;

import java.util.*;
import java.util.Date;

import Class.Compte;
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
 * Class CompteDao manages the table Compte in the database
 * 
 */
public class CompteDao {

	
	ConnexionBDD accesBDD = new ConnexionBDD();

    /**
     * Parameter for connection with the database, URL, LOGIN and PASSWORD are constant
     */
    final static String URL = "jdbc:mysql://localhost/projet_s8_banque?useSLL=false"; // disable SSL
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
    public CompteDao() {
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
     * @param Class Compte -> compte 
     * @return Class Compte -> retour
     * id_compte, date_create produce automatically
     */
    public Compte addCompte(Compte compte) {
        Compte retour = null;
        int success = 0;
        this.connection();
        
        try {
            String sql ="INSERT INTO Compte(id_user, categorie_compte, etat, solde, date_create, date_delete) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, compte.getId_user());
            ps.setString(2, "xxxx");
            ps.setString(3, compte.getEtat());
            ps.setFloat(4, compte.getSolde());
            
            long millis=System.currentTimeMillis();  
            java.sql.Date date=new java.sql.Date(millis); 
            ps.setDate(5, (java.sql.Date) date);
            ps.setString(6, null);
            
            /*
             * Execute the sql to add a new compte
             * If everything work, return int 1
             */
            success = ps.executeUpdate();
            

            
            /**
             * After success to add Compte
             * we will find the Compte we added by the field id_user, categorie_compte and date_create
             * 
             */
            if (success == 1) {
                
                sql = "SELECT id_compte FROM Compte WHERE categorie_compte='xxxx' AND id_user=?";
                ps = connection.prepareStatement(sql);
//                ps.setString(1, compte.getCategorie_compte());
                ps.setInt(1, compte.getId_user());
//              ps.setString(3, date.toString());
                
                rs = ps.executeQuery();

                if(rs.next()) {
                    int id_compte = rs.getInt("id_compte");
                    retour = this.getCompte(id_compte);
                    // retour avec categorie_compte = 'xxxx', reset categorie_compte
                    retour.setCategorie_compte(compte.getCategorie_compte());
                    retour = this.updateCompte(retour);
                }
            }else if (success == 0) {
                retour = null;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.disconnection();
        }
        
        return retour; // return an instance of Class Compte
    }

    /**
     * @param Class Compte -> compte 
     * @return Class Compte -> retour
     */
    public Compte updateCompte(Compte compte) {
        Compte retour = null;
        int success = 0;
        this.connection();
        
        try {
            String sql ="UPDATE Compte SET id_user=?, categorie_compte=?, etat=?, solde=?, date_create=?, date_delete=? WHERE id_compte=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, compte.getId_user());
            ps.setString(2, compte.getCategorie_compte());
            ps.setString(3, compte.getEtat());
            ps.setFloat(4, compte.getSolde());
            ps.setDate(5, (java.sql.Date) compte.getDate_create());
            ps.setDate(6, (java.sql.Date) compte.getDate_delete());
            ps.setInt(7, compte.getId_compte());
            
            /*
             * Execute the sql to add a new compte
             * If everything work, return int 1
             */
            success = ps.executeUpdate(); // if everything good work, retourn integer 1
            
            /**
             * After success to update Compte
             * we will find the Compte we updated by the field id_compte
             * Because the field id_compte is unique in the BDD
             * we use the method .getCompte(int id) to find the compte in BDD
             * 
             */
            if (success == 1 ) {
                retour = this.getCompte(compte.getId_compte());
            } else if(success == 0) {
                retour = null;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.disconnection();
        }
        
        return retour; // return an instance of Class Compte
    }

    /**
     * @param int -> id 
     * @return Class Compte -> retour
     */
    public Compte getCompte(int id) {
        Compte retour = null;
        this.connection();
        
        try {
            String sql ="SELECT * FROM Compte WHERE id_compte = ?";
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
                retour = new Compte(rs.getInt("id_compte"), rs.getInt("id_user"), rs.getString("categorie_compte"),
                        rs.getString("etat"), rs.getFloat("solde"), rs.getDate("date_create"),
                        rs.getDate("date_delete"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.disconnection();
        }
        return retour;
    }
    
    public Compte getCompteCourant(int id) {
    	Compte retour = null;
        accesBDD.connection();
        
        try {
            String sql ="SELECT id_compte FROM compte WHERE categorie_compte='courant'AND id_user =?";
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
                retour = new Compte(rs.getInt("id_compte"), rs.getInt("id_user"), rs.getString("categorie_compte"),
                        rs.getString("etat"), rs.getFloat("solde"), rs.getDate("date_create"),
                        rs.getDate("date_delete"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            accesBDD.disconnection();
        }
        return retour;
    }

    /**
     * @param void
     * @return List<Compte> -> retour
     */
    public List<Compte> getListCompte() {
        List<Compte> retour = new ArrayList<Compte>();
        this.connection();
        
        try {
            String sql ="SELECT * FROM Compte ORDER BY date_create DESC";
            ps = connection.prepareStatement(sql);
            
            /**
             * We take out all the compte in the BDD
             * 
             */
            rs = ps.executeQuery();
            // passe a la premiere (et unique) ligne retournee
            while(rs.next()) {
                /*
                 * We create a new instance of Compte and 
                 * then use method List.add() to add into the retour
                 */
                retour.add(new Compte(rs.getInt("id_compte"), rs.getInt("id_user"), rs.getString("categorie_compte"),
                        rs.getString("etat"), rs.getFloat("solde"), rs.getDate("date_create"),
                        rs.getDate("date_delete")));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.disconnection();
        }
        
        return retour; // return a list Compte
    }

    /**
     * @param Class Compte -> compte 
     * @return int -> retour
     * Delete by id in the compte
     */
    public int deleteCompte(Compte compte) {
        int retour = 0;
        this.connection();
        
        try {
            String sql ="DELETE FROM Compte WHERE id_compte = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, compte.getId_compte());
            /*
             * We find the compte by id_compte
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
    
    /**
     * @param int -> id_client 
     * @return List<Compte> -> retour
     */
    public List<Compte> getListCompteById_lient(int id_client){
    	List<Compte> retour = new ArrayList<Compte>();
        this.connection();
        
        try {
            String sql ="SELECT * FROM Compte WHERE id_user =?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id_client);
            
            /**
             * We take out all the compte in the BDD
             * 
             */
            rs = ps.executeQuery();
            // passe a la premiere (et unique) ligne retournee
            while(rs.next()) {
                /*
                 * We create a new instance of Compte and 
                 * then use method List.add() to add into the retour
                 */
                retour.add(new Compte(rs.getInt("id_compte"), rs.getInt("id_user"), rs.getString("categorie_compte"),
                        rs.getString("etat"), rs.getFloat("solde"), rs.getDate("date_create"),
                        rs.getDate("date_delete")));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.disconnection();
        }
        
        return retour; // return a list Compte by id_client
    }
    
    public boolean creerCompteBancaire(String nom, String prenom,int telephone, String email ,String adresse, String date, String ville ,String pays,String code, String categorie) {
		this.connection();
    	accesBDD.connection();
		// write the code here DONT FORGET TO DISCONNECT AFTER CREATING THE ACCOUNT
		try {
			String sql = "INSERT INTO user (`nom`, `prenom`, `email`, `adresse`, `telephone`, `dateNaissance`, `ville`, `pays`,`code`,`categorie_user`) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?)";
			ps = connection.prepareStatement(sql);
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ps.setString(3, email);
			ps.setString(4, adresse);
			ps.setInt(5, telephone);
			ps.setString(6, date);
			ps.setString(7, ville);
			ps.setString(8, pays);
			ps.setString(9, code);
			ps.setString(10, categorie);
			
			ps.executeUpdate();
		 		} catch (Exception e) {
	            e.printStackTrace();
	        }finally {
	            this.disconnection();
	        }
		return false;
	}
    
    
    public boolean recupererCode(String code) {
    	boolean retour = false;
        this.connection();
        
        try {
            String sql ="SELECT code FROM User WHERE code = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, code);
            
            /**
             * on execute la requete
             * rs contient un pointeur situe juste avant la premiere ligne retournee
             * 
             */
            rs = ps.executeQuery();
            // passe a la premiere (et unique) ligne retournee
            if (rs.next()) {
                retour = true;
                return retour ;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.disconnection();
        }
        
        return false;
    }
    
    
    public float soldeEpargne(int id_user) {
    	float retour = 0;
        this.connection();
        
        try {
            String sql ="SELECT solde FROM compte WHERE id_compte=2 AND id_user = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id_user);
            
            /**
             * on execute la requete
             * rs contient un pointeur situe juste avant la premiere ligne retournee
             * 
             */
            rs = ps.executeQuery();
            // passe a la premiere (et unique) ligne retournee
            if (rs.next()) {
                retour = rs.getFloat("solde");
                return retour ;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.disconnection();
        }
        
        return 0;
    }
    
    public float soldeCourant(int id_user) {
    	float retour = 0;
        this.connection();
        
        try {
            String sql ="SELECT solde FROM compte WHERE categorie_compte='courant' AND id_user = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id_user);
            
            /**
             * on execute la requete
             * rs contient un pointeur situe juste avant la premiere ligne retournee
             * 
             */
            rs = ps.executeQuery();
            // passe a la premiere (et unique) ligne retournee
            if (rs.next()) {
                retour = rs.getFloat("solde");
                return retour ;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.disconnection();
        }
        
        return 0;
    }
    
    
    public boolean modifierSolde(float solde) {
		this.connection();
    	accesBDD.connection();
		// write the code here DONT FORGET TO DISCONNECT AFTER CREATING THE ACCOUNT
		try {
			String sql = "UPDATE compte SET solde=? WHERE id_compte=2 ";
			ps = connection.prepareStatement(sql);
			ps.setFloat(1, solde);
		
			
			ps.executeUpdate();
		 		} catch (Exception e) {
	            e.printStackTrace();
	        }finally {
	            this.disconnection();
	        }
		return false;
	}
    
    
    
    
    
}