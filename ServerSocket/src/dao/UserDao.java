package dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

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
			ConnectionBDD.closeConnection();
		}
		return false;
	}

	/**
	 * @param int
	 *            -> id
	 * @return User object that contain the current user info
	 */
	public static String getCurrentUser(String email) {
		String currentUser = null;
		sql = "SELECT * FROM User WHERE email = ?";
		try {
			preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				// user.setId_user(resultSet.getInt("id_user"));
				currentUser = resultSet.getString("nom") + "/" + resultSet.getString("prenom");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionBDD.closeConnection();
		}
		return currentUser;
	}

	/**
	 * @return
	 */
	public static String getListUser() {
		String listUser = null;
		sql = "SELECT * FROM `user` WHERE categorie_user = 'client' ORDER BY `user`.`nom` ASC";
		try {
			preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String user = resultSet.getInt("id_user") + "/" + resultSet.getString("nom") + "/"
						+ resultSet.getString("prenom") + "/" + resultSet.getString("email") + "/"
						+ resultSet.getString("adresse") + "/" + resultSet.getString("telephone") + "/"
						+ resultSet.getString("ville") + "/" + resultSet.getString("pays") + "/"
						+ resultSet.getString("dateNaissance");
				listUser = listUser + ";" + user;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionBDD.closeConnection();
		}
		return listUser; // return a list Message
	}

	public static String getClientInfo(int clientID) {
		String user = null;
		sql = "SELECT * FROM `user` WHERE id_user = ? ";
		try {
			preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
			preparedStatement.setInt(1, clientID);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				user = resultSet.getInt("id_user") + "/" + resultSet.getString("nom") + "/"
						+ resultSet.getString("prenom") + "/" + resultSet.getString("email") + "/"
						+ resultSet.getString("adresse") + "/" + resultSet.getString("telephone") + "/"
						+ resultSet.getString("ville") + "/" + resultSet.getString("pays") + "/"
						+ resultSet.getString("dateNaissance");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionBDD.closeConnection();
		}
		return user;
	}

}