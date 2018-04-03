package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import dto.User;

/**
 * 
 */
public class UserDao {

	private static String sql;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet = null;

	/**
	 * Check the 'user_categorie' and the credentials when he try to connect
	 * @param email
	 * @param password
	 * @return
	 */
	public static boolean getCredentials(String email, String password) {
			sql = "SELECT * FROM user WHERE (categorie_user = 'conseiller') and (email = ?) and (password = ?)";
			try {
				preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
				preparedStatement.setString(1, email);
				preparedStatement.setString(2, password);
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				// https://stackoverflow.com/questions/65035/does-finally-always-execute-in-java
				ConnectionBDD.closeConnection();
			}
		return false;
	}

	/**
	 * Default constructor
	 */
	public UserDao() {
	}

	/**
	 * @param user
	 * @return
	 */
	public User addUser(User user) {
		// TODO implement here
		return null;
	}

	/**
	 * @param user
	 * @return
	 */
	public User updateUser(User user) {
		// TODO implement here
		return null;
	}

	/**
	 * @param id
	 * @return
	 */
	public User getUser(int id) {
		// TODO implement here
		return null;
	}

	/**
	 * @return
	 */
	public List<User> getListUser() {
		// TODO implement here
		return null;
	}

	/**
	 * @param user
	 * @return
	 */
	public int deleteUser(User user) {
		// TODO implement here
		return 0;
	}

}