package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Class.Compte;
import Class.Transaction;

/**
 * 
 */
public class TransactionDao {
	
	private static ConnexionBDD connectionAccess = new ConnexionBDD();
	private String sql;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	
	private Compte compteDebite;
	private Compte compteCredite;

    public TransactionDao() {

    }
    /**
     * Default constructor
     */
    public TransactionDao(Compte compteDebite, Compte compteCredite) {
    	this.compteDebite = compteDebite;
    	this.compteCredite = compteCredite;
    }

    /**
     * maybe make this method boolean ? or make it so that it return 1 if the table modification is done ?
     * 
     * @param idCompteDebite
     * @param idCompteCredite
     * @param somme
     * @param description
     */
    public boolean addTransaction(String categorie, int idCompteDebite, int idCompteCredite,Date date, float somme, String description) {
    	// put the sql statement here
    	try {
    		
        sql = "INSERT INTO transaction ('categorie_transaction' , 'id_compte_emetteur' , 'id_compte_recepteur' , 'date' , 'somme' , 'description') VALUES (?,?,?,?,?,?) ";
			
			preparedStatement = connectionAccess.connection().prepareStatement(sql);
			
			preparedStatement.setString(1, categorie);
			preparedStatement.setInt(2, idCompteDebite);
		    preparedStatement.setInt(3, idCompteCredite);
			preparedStatement.setDate(4, date);
			preparedStatement.setFloat(5, somme);
			preparedStatement.setString(6, description);
			
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			connectionAccess.disconnection();
		}
		return false;
    }

    /**
     * this method will allow someone to cancel a transaction ?
     * 
     * @param transaction 
     * @return
     */
    public Transaction updateTransaction(Transaction transaction) {
        // TODO implement here
        return null;
    }

    /**
     * @param id 
     * @return
     */
    public Transaction getTransaction(int id) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public List<Transaction> getListTransaction() {
        // TODO implement here
        return null;
    }

    /**
     * @param transaction 
     * @return
     */
    public int deleteTransaction(Transaction transaction) {
        // TODO implement here
        return 0;
    }

}