package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Compte;
import dto.Transaction;

/**
 * 
 */
public class TransactionDao {
	
	private static ConnectionBDD connectionAccess = new ConnectionBDD();
	private String sql;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	
	private Compte compteDebite;
	private Compte compteCredite;

    /**
     * Default constructor
     */
    public TransactionDao(Compte compteDebite, Compte compteCredite) {
    	this.compteDebite = compteDebite;
    	this.compteCredite = compteCredite;
    }
    public TransactionDao() {
    	
    }
    
    /**Used for TransactionFrame/TransactionDAO
	 * Get all account of a client
	 * @param user
	 */
	public ArrayList<String> getCompteEmetteur(int id_user) {
		ArrayList<String> listAccount = new ArrayList<String>();
		String compteParam, prenom = null, nom = null;
		
		sql = "SELECT nom,prenon FROM user WHERE id_user = ?";
		try {
			preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
			preparedStatement.setInt(1, id_user);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			nom = resultSet.getString("nom");
			prenom = resultSet.getString("prenon");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionBDD.closeConnection();
		}
		
		sql = "SELECT * FROM compte WHERE id_user = ?";
		try {
			preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
			preparedStatement.setInt(1, id_user);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
					compteParam = (resultSet.getString("categorie_compte") +"/"+ resultSet.getInt("id_compte") +"/"+ prenom +"/"+nom);
					listAccount.add(compteParam);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionBDD.closeConnection();
		}
		return listAccount;
	}

    /**
     * maybe make this method boolean ? or make it so that it return 1 if the table modification is done ?
     * 
     * @param idCompteDebite
     * @param idCompteCredite
     * @param somme
     * @param description
     */
    public void addTransaction(int idCompteDebite, int idCompteCredite, float somme, String description) {
    	// put the sql statement here
        sql = "Put the sql statement here";
		try {
			preparedStatement = connectionAccess.setConnection().prepareStatement(sql);
			// add sql parameter here
			preparedStatement.setInt(1, idCompteDebite);
			ResultSet resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			connectionAccess.closeConnection();
		}
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