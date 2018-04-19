package dao;

import java.util.*;
import java.util.Date;

import dto.Compte;
import dto.User;

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
public class CompteDao {

	
	private static String sql;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet = null;

     /**
     * @param Class Compte -> compte 
     * @return Class Compte -> retour
     * id_compte, date_create produce automatically
     */
    public Compte addCompte(Compte compte) {
        Compte retour = null;
        int success = 0;
        
        try {
            String sql ="INSERT INTO Compte(id_user, categorie_compte, etat, solde, date_create, date_delete) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
            preparedStatement.setInt(1, compte.getId_user());
            preparedStatement.setString(2, "xxxx");
            preparedStatement.setString(3, compte.getEtat());
            preparedStatement.setFloat(4, compte.getSolde());
            
            long millis=System.currentTimeMillis();  
            java.sql.Date date=new java.sql.Date(millis); 
            preparedStatement.setDate(5, (java.sql.Date) date);
            preparedStatement.setString(6, null);
            
            /*
             * Execute the sql to add a new compte
             * If everything work, return int 1
             */
            success = preparedStatement.executeUpdate();
            

            
            /**
             * After success to add Compte
             * we will find the Compte we added by the field id_user, categorie_compte and date_create
             * 
             */
            if (success == 1) {
                
                sql = "SELECT id_compte FROM Compte WHERE categorie_compte='xxxx' AND id_user=?";
                preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
//                preparedStatement.setString(1, compte.getCategorie_compte());
                preparedStatement.setInt(1, compte.getId_user());
//              preparedStatement.setString(3, date.toString());
                
                resultSet = preparedStatement.executeQuery();

                if(resultSet.next()) {
                    int id_compte = resultSet.getInt("id_compte");
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
        	ConnectionBDD.closeConnection();
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
        
        String sql ="UPDATE `compte` SET `solde` = ? WHERE `compte`.`id_compte` = ?";
        try {
            preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
            preparedStatement.setFloat(1, compte.getSolde());
            preparedStatement.setInt(2, compte.getId_compte());
            success = preparedStatement.executeUpdate(); // if everything good work, retourn integer 1
            
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
        	ConnectionBDD.closeConnection();
        }
        
        return retour; // return an instance of Class Compte
    }

    /**
     * @param int -> id 
     * @return Class Compte -> retour
     */
    public Compte getCompte(int id) {
        Compte retour = null;
        
        String sql ="SELECT * FROM Compte WHERE id_compte = ?";
        try {
            preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            // passe a la premiere (et unique) ligne retournee
            if (resultSet.next()) {
                retour = new Compte(resultSet.getInt("id_compte"), resultSet.getInt("id_user"), resultSet.getString("categorie_compte"),
                        resultSet.getString("etat"), resultSet.getFloat("solde"), resultSet.getDate("date_create"),
                        resultSet.getDate("date_delete"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        	ConnectionBDD.closeConnection();
        }
        return retour;
    }

    /**
     * @param void
     * @return List<Compte> -> retour
     */
    public List<Compte> getListCompte() {
        List<Compte> retour = new ArrayList<Compte>();
        
        try {
            String sql ="SELECT * FROM Compte ORDER BY date_create DESC";
            preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
            
            /**
             * We take out all the compte in the BDD
             * 
             */
            resultSet = preparedStatement.executeQuery();
            // passe a la premiere (et unique) ligne retournee
            while(resultSet.next()) {
                /*
                 * We create a new instance of Compte and 
                 * then use method List.add() to add into the retour
                 */
                retour.add(new Compte(resultSet.getInt("id_compte"), resultSet.getInt("id_user"), resultSet.getString("categorie_compte"),
                        resultSet.getString("etat"), resultSet.getFloat("solde"), resultSet.getDate("date_create"),
                        resultSet.getDate("date_delete")));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        	ConnectionBDD.closeConnection();
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
        
        try {
            String sql ="DELETE FROM Compte WHERE id_compte = ?";
            preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
            preparedStatement.setInt(1, compte.getId_compte());
            /*
             * We find the compte by id_compte
             * If everything good work, retourn integer 1
             */
            retour = preparedStatement.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        	ConnectionBDD.closeConnection();
        }
        
        return retour; // return 1 -> success or return 0 -> fail
    }
    
    /**
     * @param int -> id_client 
     * @return List<Compte> -> retour
     */
    public Vector<Compte> getListCompteById_lient(int id_client){
    	Vector<Compte> retour = new Vector<Compte>();
        
        try {
            String sql ="SELECT * FROM Compte WHERE id_user =?";
            preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id_client);
            
            /**
             * We take out all the compte in the BDD
             * 
             */
            resultSet = preparedStatement.executeQuery();
            // passe a la premiere (et unique) ligne retournee
            while(resultSet.next()) {
                /*
                 * We create a new instance of Compte and 
                 * then use method List.add() to add into the retour
                 */
                retour.add(new Compte(resultSet.getInt("id_compte"), resultSet.getInt("id_user"), resultSet.getString("categorie_compte"),
                        resultSet.getString("etat"), resultSet.getFloat("solde"), resultSet.getDate("date_create"),
                        resultSet.getDate("date_delete")));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        	ConnectionBDD.closeConnection();
        }
        
        return retour; // return a list Compte by id_client
    }
    
    public boolean creerCompteBancaire(String nom, String prenom,int telephone, String email ,String adresse, String date, String ville ,String pays,String code, String categorie) {

		try {
			String sql = "INSERT INTO user (`nom`, `prenom`, `email`, `adresse`, `telephone`, `dateNaissance`, `ville`, `pays`,`code`,`categorie_user`) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?)";
			preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
			preparedStatement.setString(1, nom);
			preparedStatement.setString(2, prenom);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, adresse);
			preparedStatement.setInt(5, telephone);
			preparedStatement.setString(6, date);
			preparedStatement.setString(7, ville);
			preparedStatement.setString(8, pays);
			preparedStatement.setString(9, code);
			preparedStatement.setString(10, categorie);
			
			preparedStatement.executeUpdate();
		 		} catch (Exception e) {
	            e.printStackTrace();
	        }finally {
	        	ConnectionBDD.closeConnection();
	        }
		return false;
	}
    
    
    public String recupererCode(String email) {
    	String retour = null;
        
        try {
            String sql ="SELECT code FROM User WHERE email = ?";
            preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
            preparedStatement.setString(1, email);
            
            /**
             * on execute la requete
             * resultSet contient un pointeur situe juste avant la premiere ligne retournee
             * 
             */
            resultSet = preparedStatement.executeQuery();
            // passe a la premiere (et unique) ligne retournee
            if (resultSet.next()) {
                retour = resultSet.getString("code");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        	ConnectionBDD.closeConnection();
        }
        
        return retour;
    }
}