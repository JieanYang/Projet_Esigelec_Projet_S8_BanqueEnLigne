package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class ConnexionBDD manages the connection with database
 * @author yja85
 *
 */

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
	private static String url = "jdbc:mysql://localhost/projet_s8_banque?useSSL=false"; // add '?useSSL=false' to disable
																					// Warning message
	private static String username = "root";
	private static String password = "";
	private static Connection connection;

	/**
	 * Connecting to database
	 */
	public static Connection connection() {
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * Closing connection
	 */
	public static void disconnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public PreparedStatement prepareStatement(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
}
