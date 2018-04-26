package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 
 */
public class MessageDao {

	private static String sql;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet = null;

	/**
	 * Default constructor
	 */
	public MessageDao() {

	}

	/**
	 * @param void
	 * @return List<Message> -> retour
	 */
	public static String getListMessage() {
		String listMessage = null;
		sql = "SELECT * FROM Message WHERE reponse is null ORDER BY date DESC";

		try {
			preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String message = resultSet.getInt("id_message") + "/" + resultSet.getString("nom") + "/"
						+ resultSet.getString("prenom") + "/" + resultSet.getString("numphone") + "/"
						+ resultSet.getString("email") + "/" + resultSet.getString("problem");
				listMessage = listMessage + ";" + message;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionBDD.closeConnection();
		}
		return listMessage;
	}

	/**
	 * @param int
	 *            -> id
	 * @return Class Message -> retour
	 */
	public static String getMessage(int messageID) {
		String message = null;
		sql = "SELECT * FROM Message WHERE id_message = ?";
		try {
			preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
			preparedStatement.setInt(1, messageID);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				message = resultSet.getInt("id_message") + "/" + resultSet.getString("nom") + "/"
						+ resultSet.getString("prenom") + "/" + resultSet.getString("numphone") + "/"
						+ resultSet.getString("email") + "/" + resultSet.getString("problem");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionBDD.closeConnection();
		}
		return message;
	}

	/**
	 * @param Class
	 *            Message -> message
	 * @return Class Message -> retour
	 */
	public static String updateMessage(int messageID, String reponse) {
		String retour = null;
		sql = "UPDATE message SET reponse=? WHERE id_message = ?";
		try {
			preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
			preparedStatement.setString(1, reponse);
			preparedStatement.setInt(2, messageID);
			preparedStatement.executeUpdate();
			retour = "reponse envoye";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionBDD.closeConnection();
		}
		return retour;
	}

	// ------------------------------------unused
	// under----------------------------------------------------

	// /**
	// * @param Class Message -> message
	// * @return Class Message -> retour
	// */
	// public Message addMessage(Message message) {
	// Message retour = null;
	// int success = 0;
	// this.connection();
	//
	// try {
	// String sql ="INSERT INTO Message(nom, prenom, numphone, email, problem,
	// reponse, date) "
	// + "VALUES (?, ?, ?, ?, ?, ?, ?)";
	// preparedStatement = connection.prepareStatement(sql);
	// preparedStatement.setString(1, message.getNom());
	// preparedStatement.setString(2, message.getPrenom());
	// preparedStatement.setString(3, message.getNumphone());
	// preparedStatement.setString(4, message.getEmail());
	// preparedStatement.setString(5, message.getProblem());
	// preparedStatement.setString(6, message.getReponse());
	// Date utildate = new Date();
	// Timestamp sqldate = new Timestamp(utildate.getTime());
	// preparedStatement.setTimestamp(7, sqldate);
	// /*java.util.Date utilDate1 = new java.util.Date();
	// SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
	// java.util.Date utilDate = new java.util.Date();
	// java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());*/
	//
	// /*
	// * Execute the sql to add a new message
	// * If everything work, return int 1
	// */
	// success = preparedStatement.executeUpdate();
	//
	//
	// /**
	// * After success to add Message
	// * we will find the Message we added by the field problem
	// * Because the field problem is unique in the BDD
	// *
	// */
	// if (success == 1) {
	// sql = "SELECT id_message FROM Message WHERE problem=?";
	// preparedStatement = connection.prepareStatement(sql);
	// preparedStatement.setString(1, message.getProblem());
	// resultSet = preparedStatement.executeQuery();
	//
	// if(resultSet.next()) {
	// int id_message = resultSet.getInt("id_message");
	// retour = this.getMessage(id_message);
	// }
	// }else if (success == 0) {
	// retour = null;
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }finally {
	// this.disconnection();
	// }
	//
	// return retour; // return an instance of Class Message
	// }
	//
	//
	//
	// /**
	// * @param Class Message -> message
	// * @return int -> retour
	// */
	// public int deleteMessage(Message message) {
	// int retour = 0;
	// this.connection();
	//
	// try {
	// String sql ="DELETE FROM Message WHERE id_message = ?";
	// preparedStatement = connection.prepareStatement(sql);
	// preparedStatement.setInt(1, message.getId_message());
	// /*
	// * We find the message by id_message
	// * If everything good work, retourn integer 1
	// */
	// retour = preparedStatement.executeUpdate();
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }finally {
	// this.disconnection();
	// }
	//
	// return retour; // return 1 -> success or return 0 -> fail
	// }

	// ------------------------------------unused
	// above----------------------------------------------------

}