package dao;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
/**
 * This class allows to manage interactions between the database
 * 
 * @author
 * @version 1.0
 */
public class OffresDAO {

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
			System.out.println("Connexion effective");
		} catch (SQLException e) {
			System.out.println("Connexion non effective");
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
	public boolean addOffre(String title, String description) {
		this.connection();
		try {
			String sql = "INSERT INTO servicesdelabanque (`nom_service`, `prix` ,`description`) VALUES ( ?, ?, ?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, title);
			preparedStatement.setFloat(2, 0);
		    preparedStatement.setString(3, description);
			
			
			//System.out.println("requete "+sql);
			preparedStatement.executeUpdate();
			this.disconnection();
			return true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;
	}
	
	//Méthode qui récupère les 4 dernière actu
	//public ResultSet getfourLastOffres() {
		//this.connection();
		//try {
		//	String sql = "SELECT * from servicesdelabanque ORDER BY id_service DESC limit 4";
			
			//PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			//System.out.println("requete "+sql);
			//ResultSet result = preparedStatement.executeQuery();// on met le resultat obtenu dans "result"
			//this.disconnection();
			//return result;// après avoir récupérer retourne result
		//} catch (SQLException e1) {
		//	e1.printStackTrace();
		//}
		//return null;
	//}
	


}
	
