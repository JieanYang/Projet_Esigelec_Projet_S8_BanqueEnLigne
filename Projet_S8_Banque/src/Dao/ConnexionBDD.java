package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBDD {

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
	
	
	
	
}
