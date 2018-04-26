package dao;


import java.sql.*;

public class ConnectionBDD {
	
	/** 
	 * Setup connection parameters to the database
	 */
	private static String url = "jdbc:mysql://localhost/projet_s8_banque?useSSL=false"; // add'?useSSL=false' to disable Warning message
	private static String username = "root";
	private static String password = "";
	private static Connection connection;

	/**
	 * Static initialization block: Runs once (when the class is initialized). Allow us to load the mysql Driver
	 */
	static {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Impossible to load the database driver, don't forget to import the mysql-connector-java-XXXX.jar in the project");
		}
	}

	/**
	 * Setup the connection to the database
	 * @return a connection to the url
	 */
	public static Connection setConnection() {
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * Close the connection to the database
	 * @return	a realesed connection
	 */
	public static Connection closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}