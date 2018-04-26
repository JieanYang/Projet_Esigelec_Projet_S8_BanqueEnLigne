package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 
 */
public class TransactionDao {

	private static String sql;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet = null;

	/**
	 * Default constructor
	 */
	public TransactionDao() {

	}

	public static String addTransaction(int idCompteDebiteur, int idCompteCrediteur, float somme, String description,
			String catTransac) {
		String retour = null;
		sql = "INSERT INTO Transaction(categorie_transaction, id_compte_emetteur, id_compte_recepteur, date_transaction, date_create, somme, description)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
			preparedStatement.setString(1, catTransac);
			preparedStatement.setInt(2, idCompteDebiteur);
			preparedStatement.setInt(3, idCompteCrediteur);
			// date_create is created automatically
			Date utildate = new Date();
			Timestamp sqldate = new Timestamp(utildate.getTime());
			preparedStatement.setTimestamp(4, sqldate);
			preparedStatement.setTimestamp(5, sqldate);
			preparedStatement.setFloat(6, somme);
			preparedStatement.setString(7, description);
			preparedStatement.executeUpdate();
			retour = "Added Transaction";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionBDD.closeConnection();
		}
		return retour;
	}

	/**
	 * @return
	 */
	public static String getListTransac(int compteID) {
		String listTransac = null;
		sql = "SELECT * FROM Transaction WHERE id_compte_emetteur=? OR id_compte_recepteur=? ORDER BY date_transaction DESC";
		try {
			preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
			preparedStatement.executeQuery();
			while (resultSet.next()) {
				String transac = resultSet.getInt("id_transaction") + "/" + resultSet.getString("categorie_transaction")
						+ "/" + resultSet.getInt("id_compte_emetteur") + "/" + resultSet.getInt("id_compte_recepteur")
						+ "/" + resultSet.getTimestamp("date_transaction") + "/" + resultSet.getFloat("somme") + "/"
						+ resultSet.getString("description");
				listTransac = listTransac + ";" + transac;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionBDD.closeConnection();
		}
		return listTransac;
	}
}