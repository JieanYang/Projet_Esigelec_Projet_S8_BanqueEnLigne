package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import Class.Actions;
import Class.User;

public class ActionsDAO {

	private String sql;
	private PreparedStatement preparedStatemact;

	public ArrayList<Actions> getact(String id_user) {
		ArrayList<Actions> actList = new ArrayList<Actions>();
		sql = "SELECT * FROM actions WHERE id_user=?";
		try {
			preparedStatemact = ConnexionBDD.connection().prepareStatement(sql);
			preparedStatemact.setString(1, id_user);
			ResultSet resultSet = preparedStatemact.executeQuery();
			while (resultSet.next()) {
				Actions act = new Actions();
				act.setid_user(resultSet.getInt("id_user"));
				act.setentreprise(resultSet.getString("entreprise"));
				act.setprixachat(resultSet.getFloat("prixachat"));
				act.setdate(resultSet.getDate("date"));	
				act.setnombre(resultSet.getInt("nombre"));
				actList.add(act);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnexionBDD.disconnection();
		}
		return actList;
	}
	
	public void ajout(int id_user, String entreprise, float prixachat, Date sqlDate, int nombre){
		ConnexionBDD accesBDD = new ConnexionBDD();
		accesBDD.connection();
		try {
			String sql = "INSERT INTO actions (id_user, entreprise ,prixachat, date, nombre) VALUES ( ?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStatement = ConnexionBDD.connection().prepareStatement(sql);
			
			preparedStatement.setInt(1, id_user);
			preparedStatement.setString(2, entreprise);
		    preparedStatement.setFloat(3, prixachat);
			preparedStatement.setDate(4, sqlDate);
			preparedStatement.setInt(5, nombre);
			
			System.out.println("yes "+preparedStatement);
			preparedStatement.executeUpdate();
			} 
			catch (SQLException e1) {
				e1.printStackTrace();
				System.out.println("non"+sql);
			}
		finally {
			ConnexionBDD.disconnection();
		}
	}

	
}


