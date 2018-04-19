package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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

	public Transaction addTransaction(Transaction transaction) {
        Transaction retour = null;
        int success = 0;
        String sql ="INSERT INTO Transaction(categorie_transaction, id_compte_emetteur, id_compte_recepteur, date_transaction, date_create, somme, description)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
            preparedStatement.setString(1, "xxxx");
            preparedStatement.setInt(2, transaction.getId_compte_emetteur());
            preparedStatement.setInt(3, transaction.getId_compte_recepteur());
            
            preparedStatement.setTimestamp(4, transaction.getDate_transaction());
            // date_create is created automatically
            Date utildate = new Date();         
        	Timestamp sqldate = new Timestamp(utildate.getTime());  
            preparedStatement.setTimestamp(5, sqldate);
            
            preparedStatement.setFloat(6, transaction.getSomme());
            preparedStatement.setString(7, transaction.getDescription());
            
            /*
             * Execute the sql to add a new transaction
             * If everything work, return int 1
             */
            success = preparedStatement.executeUpdate();
            
            /**
             * After success to add Transaction
             * we will find the Transaction we added by categorie_transaction='xxxx', 
             * id_compte_emetteur and id_compte_recepteur
             * 
             */
            if (success == 1) {
                
                sql = "SELECT id_transaction FROM Transaction WHERE categorie_transaction='xxxx' AND id_compte_emetteur=? AND id_compte_recepteur=?";
                preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
                preparedStatement.setInt(1, transaction.getId_compte_emetteur());
                preparedStatement.setInt(2, transaction.getId_compte_recepteur());
                
                resultSet = preparedStatement.executeQuery();

                if(resultSet.next()) {
                    int id_transaction = resultSet.getInt("id_transaction");
                    retour = this.getTransaction(id_transaction);
                    // retour avec categorie_transaction = 'xxxx', reset categorie_transaction
                    retour.setCategorie_transaction(transaction.getCategorie_transaction());
                    retour = this.updateTransaction(retour);
                }
            }else if (success == 0) {
                retour = null;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        	ConnectionBDD.closeConnection();
        }
        
        return retour; // return an instance of Class Transaction
    }
	
	/**
     * @param Class Transaction -> transaction 
     * @return Class Transaction -> retour
     */
    public Transaction updateTransaction(Transaction transaction) {
        Transaction retour = null;
        int success = 0;
        String sql ="UPDATE Transaction SET categorie_transaction=?, id_compte_emetteur=?, id_compte_recepteur=?," +
    			" date_transaction=?, date_create=?, somme=?, description=? WHERE id_transaction=?";
        try {
        	preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
            preparedStatement.setString(1, transaction.getCategorie_transaction());
            
            preparedStatement.setInt(2, transaction.getId_compte_emetteur());
            preparedStatement.setInt(3, transaction.getId_compte_recepteur());
            
            preparedStatement.setTimestamp(4, transaction.getDate_transaction());
            preparedStatement.setTimestamp(5, transaction.getDate_create());
            
            preparedStatement.setFloat(6, transaction.getSomme());
            preparedStatement.setString(7, transaction.getDescription());
            
            preparedStatement.setInt(8, transaction.getId_transaction());
            
            /*
             * Execute the sql to add a new transaction
             * If everything work, return int 1
             */
            success = preparedStatement.executeUpdate(); // if everything good work, retourn integer 1
            
            /**
             * After success to update Transaction
             * we will find the Transaction we updated by the field id_transaction
             * Because the field id_transaction is unique in the BDD
             * we use the method .getTransaction(int id) to find the transaction in BDD
             * 
             */
            if (success == 1 ) {
                retour = this.getTransaction(transaction.getId_transaction());
            } else if(success == 0) {
                retour = null;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        	ConnectionBDD.closeConnection();
        }
        
        return retour; // return an instance of Class Transaction
    }
    
    /**
     * @param int -> id
     * @return Class Transaction -> retour
     */
    public Transaction getTransaction(int id) {
    	Transaction retour = null;
    	String sql ="SELECT * FROM Transaction WHERE id_transaction = ?";
        
        try {
            preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            
            /**
             * on execute la requete
             * resultSet contient un pointeur situe juste avant la premiere ligne retournee
             * 
             */
            resultSet = preparedStatement.executeQuery();
            // passe a la premiere (et unique) ligne retournee
            if (resultSet.next()) {
                retour = new Transaction(resultSet.getInt("id_transaction"), resultSet.getString("categorie_transaction"), resultSet.getInt("id_compte_emetteur"),
                        resultSet.getInt("id_compte_recepteur"), resultSet.getTimestamp("date_transaction"), resultSet.getTimestamp("date_create"),
                        resultSet.getFloat("somme"), resultSet.getString("description"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        	ConnectionBDD.closeConnection();
        }
        return retour;
    }

}