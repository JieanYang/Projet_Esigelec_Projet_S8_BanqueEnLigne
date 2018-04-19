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
	 * Default constructor
	 */
	public UserDao() {

	}

	/**
	 * Used for Login/Login Check the 'user_categorie' and the credentials when he
	 * try to connect
	 * 
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
	 * @param int
	 *            -> id
	 * @return User object that contain the current user info
	 */
	public User getCurrentUser(String email) {
		User user = new User();
		sql = "SELECT * FROM User WHERE email = ?";
		try {
			preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				// user.setId_user(resultSet.getInt("id_user"));
				user.setNom(resultSet.getString("nom"));
				user.setPrenom(resultSet.getString("prenom"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionBDD.closeConnection();
		}
		return user;
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
	 * @return
	 */
	public Vector<User> getListUser() {
		Vector<User> listUser = new Vector<User>();
		sql = "SELECT * FROM `user` WHERE categorie_user = 'client' ORDER BY `user`.`nom` ASC";
		try {
			preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.setId_user(resultSet.getInt("id_user"));
				user.setNom(resultSet.getString("nom"));
				user.setPrenom(resultSet.getString("prenom"));
				user.setEmail(resultSet.getString("email"));
				user.setAdresse(resultSet.getString("adresse"));
				user.setTelephone(resultSet.getString("telephone"));
				user.setVille(resultSet.getString("ville"));
				user.setPays(resultSet.getString("pays"));
				user.setDateNaissance(resultSet.getDate("dateNaissance"));

				listUser.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionBDD.closeConnection();
		}
		return listUser; // return a list Message
	}

	public User getClientInfo(int clientID) {
		User user = new User();
		sql = "SELECT * FROM `user` WHERE id_user = ? ";
		try {
			preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
			preparedStatement.setInt(1, clientID);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
			user.setId_user(resultSet.getInt("id_user"));
			user.setNom(resultSet.getString("nom"));
			user.setPrenom(resultSet.getString("prenom"));
			user.setEmail(resultSet.getString("email"));
			user.setAdresse(resultSet.getString("adresse"));
			user.setTelephone(resultSet.getString("telephone"));
			user.setVille(resultSet.getString("ville"));
			user.setPays(resultSet.getString("pays"));
			user.setDateNaissance(resultSet.getDate("dateNaissance"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionBDD.closeConnection();
		}
		return user;
	}

}