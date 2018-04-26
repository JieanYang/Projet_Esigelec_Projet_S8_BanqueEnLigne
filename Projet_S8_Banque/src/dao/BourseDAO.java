package dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Class BourseDao manages the table Bourse in the database
 * @author yja85
 *
 */
public class BourseDAO {
	
	private String sql;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public ArrayList<Date> getDate(){
		ArrayList<Date> listeDate = new ArrayList<Date>();
		sql = "SELECT date FROM coursdelabourse ORDER BY coursdelabourse.date ASC";
		try {
			preparedStatement = ConnexionBDD.connection().prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				listeDate.add(resultSet.getDate("date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnexionBDD.disconnection();
		}
		return listeDate;
	}

	public ArrayList<Float> getCours() {
		ArrayList<Float> listeCour = new ArrayList<Float>();
		sql = "SELECT * FROM coursdelabourse ORDER BY coursdelabourse.date ASC";
		try {
			preparedStatement = ConnexionBDD.connection().prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				listeCour.add(resultSet.getFloat("courcac40"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnexionBDD.disconnection();
		}
		return listeCour;
	}
	
	public static void main(String[] args) throws IOException {
//		BourseDAO bourseDAO = new BourseDAO();
//		System.out.println(bourseDAO.getDate());
//		System.out.println(bourseDAO.getCours("courcac40"));
	}
}
