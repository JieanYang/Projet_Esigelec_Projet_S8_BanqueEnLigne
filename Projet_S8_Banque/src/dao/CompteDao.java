package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import Class.Compte;

/**
 * 
 */
public class CompteDao {

	
	private Connection connection;
	ConnexionBDD accesBDD = new ConnexionBDD();
	
    /**
     * Default constructor
     */
    public CompteDao() {
    }

    /**
     * @param compte 
     * @return
     */
    
   
    public Compte addCompte(Compte compte) {
        // TODO implement here
        return null;
    }

    /**
     * @param compte 
     * @return
     */
    public Compte updateCompte(Compte compte) {
        // TODO implement here
        return null;
    }

    /**
     * @param id 
     * @return
     */
    public Compte getCompte(int id) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public List<Compte> getListCompte() {
        // TODO implement here
        return null;
    }

    /**
     * @param compte 
     * @return
     */
    public int deleteCompte(Compte compte) {
        // TODO implement here
        return 0;
    }
    
    public boolean creerCompteBancaire(String nom, String prenom,int telephone, String email ,String adresse, String date, String ville ,String pays) {
		accesBDD.connection();
		// write the code here DONT FORGET TO DISCONNECT AFTER CREATING THE ACCOUNT
		try {
			String sql = "INSERT INTO user (`nom`, `prenom`, `email`, `adresse`, `telephone`, `date`, `ville`, `pays`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, nom);
			preparedStatement.setString(2, prenom);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, adresse);
			preparedStatement.setInt(5, telephone);
			preparedStatement.setString(6, date);
			preparedStatement.setString(7, ville);
			preparedStatement.setString(8, pays);
			
			preparedStatement.executeUpdate();
				accesBDD.disconnection();
			return true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;
	}
}