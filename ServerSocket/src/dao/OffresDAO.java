package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OffresDAO {

	private static String sql;
	private static PreparedStatement preparedStatement;
	
	public static String addOffre(String title, String description) {
		String retour = null;
		sql = "INSERT INTO servicesdelabanque (`nom_service`, `prix` ,`description`) VALUES ( ?, ?, ?)";
		try {
			preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
			preparedStatement.setString(1, title);
			preparedStatement.setFloat(2, 0);
		    preparedStatement.setString(3, description);
			preparedStatement.executeUpdate();
			retour = "offre ajoute";
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			ConnectionBDD.closeConnection();
		}
		return retour;
	}
}
	
