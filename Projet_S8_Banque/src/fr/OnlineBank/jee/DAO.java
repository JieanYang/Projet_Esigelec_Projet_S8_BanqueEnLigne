package fr.OnlineBank.jee;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class allows to manage interactions between the database
 * 
 * @author
 * @version 1.0
 */
public class DAO {

	/**
	 * Static initialization block: Runs once (when the class is initialized)
	 */
	static {
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
	 * Setup connection parameters to the database
	 */
	private String url = "jdbc:mysql://localhost/projet_s8_banque?useSSL=false"; // add '?useSSL=false' to disable
																					// Warning message
	private String username = "root";
	private String password = "";
	private Connection connection;

	/**
	 * Connecting to database
	 */
	public void connection() {
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Closing connection
	 */
	public void disconnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param email
	 *            represent the email of the user
	 * @param password
	 *            represent the password of the user
	 * 
	 * @return must return true of false is the input parameters are valid
	 */
	public boolean login(String email, String password) {
		this.connection();
		// check if the parameters are empty
		if (email.equals("") && password.equals("")) {
			this.disconnection();
			return false;
		} else {
			// if its not empty we check if they are in the database
			try {
				String sql = "SELECT * FROM user WHERE (email = ?) and (password = ?)";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, email);
				preparedStatement.setString(2, password);
				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					this.disconnection();;
					return true;
				} else {
					this.disconnection();;
					return false;
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		this.disconnection();
		return false;
	}
	
	/**
	 * Create a new user
	 */
	public boolean addUser(String username, String email, String password) {
		this.connection();
		try {
			String sql = "INSERT INTO user (`name`, `password`, `email`) VALUES (?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, email);
			preparedStatement.executeUpdate();
			this.disconnection();
			return true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Create a new Bank Account
	 */
	public void newBankAcc() {
		this.connection();
		// write the code here DONT FORGET TO DISCONNECT AFTER CREATING THE ACCOUNT
	}
	
	/**
	 * Create a new Bank Account
	 */
	public void coursBrouse(String nomEnt) {
		this.connection();
		
		// requetes sql
		
		this.disconnection();
		// write the code here DONT FORGET TO DISCONNECT AFTER CREATING THE ACCOUNT
	}
	
}
