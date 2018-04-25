package dao;

import java.util.*;
import java.util.Date;

import Class.Compte;
import Class.Transaction;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


/**
 * Manages the table Transaction in the database 
 */
public class TransactionDao {

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
    public TransactionDao() {
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
     * @param Class Transaction -> transaction 
     * @return Class Transaction -> retour
     * 
     */
    public Transaction addTransaction(Transaction transaction) {
        Transaction retour = null;
        int success = 0;
        this.connection();
        
        try {
            String sql ="INSERT INTO Transaction(categorie_transaction, id_compte_emetteur, id_compte_recepteur, date_transaction, date_create, somme, description)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, "xxxx");
            ps.setInt(2, transaction.getId_compte_emetteur());
            ps.setInt(3, transaction.getId_compte_recepteur());
            
            ps.setTimestamp(4, transaction.getDate_transaction());
            // date_create is created automatically
            Date utildate = new Date();         
        	Timestamp sqldate = new Timestamp(utildate.getTime());  
            ps.setTimestamp(5, sqldate);
            
            ps.setFloat(6, transaction.getSomme());
            ps.setString(7, transaction.getDescription());
            
            /*
             * Execute the sql to add a new transaction
             * If everything work, return int 1
             */
            success = ps.executeUpdate();
            

            
            /**
             * After success to add Transaction
             * we will find the Transaction we added by categorie_transaction='xxxx', 
             * id_compte_emetteur and id_compte_recepteur
             * 
             */
            if (success == 1) {
                
                sql = "SELECT id_transaction FROM Transaction WHERE categorie_transaction='xxxx' AND id_compte_emetteur=? AND id_compte_recepteur=?";
                ps = connection.prepareStatement(sql);
                ps.setInt(1, transaction.getId_compte_emetteur());
                ps.setInt(2, transaction.getId_compte_recepteur());
                
                rs = ps.executeQuery();

                if(rs.next()) {
                    int id_transaction = rs.getInt("id_transaction");
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
            this.disconnection();
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
        this.connection();
        
        try {
            String sql ="UPDATE Transaction SET categorie_transaction=?, id_compte_emetteur=?, id_compte_recepteur=?," +
            			" date_transaction=?, date_create=?, somme=?, description=? WHERE id_transaction=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, transaction.getCategorie_transaction());
            
            ps.setInt(2, transaction.getId_compte_emetteur());
            ps.setInt(3, transaction.getId_compte_recepteur());
            
            ps.setTimestamp(4, transaction.getDate_transaction());
            ps.setTimestamp(5, transaction.getDate_create());
            
            ps.setFloat(6, transaction.getSomme());
            ps.setString(7, transaction.getDescription());
            
            ps.setInt(8, transaction.getId_transaction());
            
            /*
             * Execute the sql to add a new transaction
             * If everything work, return int 1
             */
            success = ps.executeUpdate(); // if everything good work, retourn integer 1
            
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
            this.disconnection();
        }
        
        return retour; // return an instance of Class Transaction
    }

    /**
     * @param int -> id
     * @return Class Transaction -> retour
     */
    public Transaction getTransaction(int id) {
    	Transaction retour = null;
        this.connection();
        
        try {
            String sql ="SELECT * FROM Transaction WHERE id_transaction = ?";
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
                retour = new Transaction(rs.getInt("id_transaction"), rs.getString("categorie_transaction"), rs.getInt("id_compte_emetteur"),
                        rs.getInt("id_compte_recepteur"), rs.getTimestamp("date_transaction"), rs.getTimestamp("date_create"),
                        rs.getFloat("somme"), rs.getString("description"));
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
     * @return List<Transaction> -> retour
     */
    public List<Transaction> getListTransaction() {
        List<Transaction> retour = new ArrayList<Transaction>();
        this.connection();
        
        try {
            String sql ="SELECT * FROM Transaction ORDER BY date_create DESC";
            ps = connection.prepareStatement(sql);
            
            /**
             * We take out all the compte in the BDD
             * 
             */
            rs = ps.executeQuery();
            // passe a la premiere (et unique) ligne retournee
            while(rs.next()) {
                /*
                 * We create a new instance of Transaction and 
                 * then use method List.add() to add into the retour
                 */
                retour.add(new Transaction(rs.getInt("id_transaction"), rs.getString("categorie_transaction"), rs.getInt("id_compte_emetteur"),
                        rs.getInt("id_compte_recepteur"), rs.getTimestamp("date_transaction"), rs.getTimestamp("date_create"),
                        rs.getFloat("somme"), rs.getString("description")));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.disconnection();
        }
        
        return retour; // return a list Transaction
    }

    /**
     * @param Class Transaction -> ransaction 
     * @return int -> retour
     */
    public int deleteTransaction(Transaction transaction) {
    	int retour = 0;
    	this.connection();
        
    	try {
        	String sql ="DELETE FROM Transaction WHERE id_transaction = ?";
        	ps = connection.prepareStatement(sql);
        	ps.setInt(1, transaction.getId_transaction());
        	/*
        	 * We find the transaction by id_transaction
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
     * @param int -> id_compte
     * @return List<Transaction> -> retour
     */
    public List<Transaction> getListTransactionById_compte(int id_compte) {
        List<Transaction> retour = new ArrayList<Transaction>();
        this.connection();
        
        try {
            String sql ="SELECT * FROM Transaction WHERE id_compte_emetteur=? OR id_compte_recepteur=? ORDER BY date_transaction DESC";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id_compte);
            ps.setInt(2, id_compte);
            
            /**
             * We take out all the compte in the BDD
             * 
             */
            rs = ps.executeQuery();
            // passe a la premiere (et unique) ligne retournee
            while(rs.next()) {
                /*
                 * We create a new instance of Transaction and 
                 * then use method List.add() to add into the retour
                 */
                retour.add(new Transaction(rs.getInt("id_transaction"), rs.getString("categorie_transaction"), rs.getInt("id_compte_emetteur"),
                        rs.getInt("id_compte_recepteur"), rs.getTimestamp("date_transaction"), rs.getTimestamp("date_create"),
                        rs.getFloat("somme"), rs.getString("description")));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.disconnection();
        }
        
        return retour; // return a list Transaction
    }
    
    public int getNumberTransactionById_compte(int id_compte) {
    	List<Transaction> list_transactionOneCompte = this.getListTransactionById_compte(id_compte);
    	return list_transactionOneCompte.size();
    }

}