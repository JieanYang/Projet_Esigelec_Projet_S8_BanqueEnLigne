package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SommeDao {

	ConnexionBDD accesBDD = new ConnexionBDD();
	
	
	  public int benef(String beneficiaire) {
			accesBDD.connection();
			try {
				int solde=0;
				String sql = "SELECT solde from compte WHERE (id_compte=?)";
				PreparedStatement preparedStatement = accesBDD.connection().prepareStatement(sql);
				preparedStatement.setString(1, beneficiaire);
				ResultSet resultset=preparedStatement.executeQuery();
				if (resultset.next()) {
				solde=resultset.getInt("prix");
				}
				return solde;
			} catch (SQLException e1) {
				e1.printStackTrace();
						return 0 ;
			}
			finally
			{
				accesBDD.disconnection();
			}
		}
	  
	  
	  
	  public int emetteur(String emetteur) {
			accesBDD.connection();
			try {
				int solde2=0;
				String sql = "SELECT solde from compte WHERE (id_compte=?)";
				PreparedStatement preparedStatement = accesBDD.connection().prepareStatement(sql);
				preparedStatement.setString(1, emetteur);
				ResultSet resultset=preparedStatement.executeQuery();
				if (resultset.next()) {
				solde2=resultset.getInt("prix");
				}
				return solde2;
			} catch (SQLException e1) {
				e1.printStackTrace();
						return 0 ;
			}
			finally
			{
				accesBDD.disconnection();
			}
		}
}
