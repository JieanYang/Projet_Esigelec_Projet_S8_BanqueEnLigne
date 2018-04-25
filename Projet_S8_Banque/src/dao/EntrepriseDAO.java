package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Class.Entreprise;

/**
 * Class EntrepriseDao manages the table EntrCac40 in the database
 * @author yja85
 *
 */

public class EntrepriseDAO {

	private String sql;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	public ArrayList<Entreprise> getEnt() {
		ArrayList<Entreprise> entList = new ArrayList<Entreprise>();
		sql = "SELECT * FROM entcac40";
		try {
			preparedStatement = ConnexionBDD.connection().prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Entreprise ent = new Entreprise();
				ent.setNom(resultSet.getString("nom"));
				ent.setOuverture(resultSet.getFloat("ouverture"));
				ent.setHaut(resultSet.getFloat("haut"));
				ent.setBas(resultSet.getFloat("bas"));
				ent.setVolume(resultSet.getInt("volume"));
				ent.setVeille(resultSet.getFloat("veille"));
				ent.setDernier(resultSet.getFloat("dernier"));
				ent.setVar(resultSet.getFloat("var"));
				
				entList.add(ent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnexionBDD.disconnection();
		}
		return entList;
	}

}
