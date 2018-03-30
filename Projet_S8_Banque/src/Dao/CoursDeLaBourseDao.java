package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import Class.CoursDeLaBourse;

/**
 * 
 */
public class CoursDeLaBourseDao {

	private Connection connection;
	ConnexionBDD accesBDD = new ConnexionBDD();
	
    /**
     * Default constructor
     */
    public CoursDeLaBourseDao() {
    }

    /**
     * @param action 
     * @return
     */
    public int addCoursDeLaBourse(CoursDeLaBourse action) {
        // TODO implement here
        return 0;
    }

    /**
     * @param action 
     * @return
     */
    public int updateCoursDeLaBourse(CoursDeLaBourse action) {
        // TODO implement here
        return 0;
    }

    /**
     * @param id 
     * @return
     */
    public CoursDeLaBourse getCoursDeLaBourse(int id) {
        // TODO implement here
        return null;
    }
    
    public int prixcours(String nomentreprise) {
		accesBDD.connection();
		try {
			int monprix=0;
			String sql = "SELECT prix from cours_de_la_bourse WHERE (entreprise=?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, nomentreprise);
			ResultSet resultset=preparedStatement.executeQuery();
			if (resultset.next()) {
			monprix=resultset.getInt("prix");
			}
			return monprix;
		} catch (SQLException e1) {
			e1.printStackTrace();
					return 0 ;
		}
		finally
		{
			accesBDD.disconnection();
		}
	}

    /**
     * @return
     */
    public List<CoursDeLaBourse> getListCoursDeLaBourse() {
        // TODO implement here
        return null;
    }

    /**
     * @param action 
     * @return
     */
    public int deleteCoursDeLaBourse(CoursDeLaBourse action) {
        // TODO implement here
        return 0;
    }

}