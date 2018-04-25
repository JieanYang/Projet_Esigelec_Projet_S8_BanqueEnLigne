package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import Class.CoursDeLaBourse;
import Class.User;

/**
 * Class CoursDeLaBourseDao manages the table CoursDeLaBourse in the database
 * 
 */
public class CoursDeLaBourseDao {

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
    public CoursDeLaBourse addCoursDeLaBourse(CoursDeLaBourse action) {
        // TODO implement here
        return null;
    }

    /**
     * @param action 
     * @return
     */
    public CoursDeLaBourse updateCoursDeLaBourse(CoursDeLaBourse action) {
        // TODO implement here
        return null;
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
			String sql = "SELECT prix from coursdelabourse WHERE (entreprise=?)";
			PreparedStatement preparedStatement = accesBDD.connection().prepareStatement(sql);
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
    	accesBDD.connection();
    	List<CoursDeLaBourse> Cours = new ArrayList<CoursDeLaBourse>();
        
        try {
            String sql ="SELECT prix, entreprise FROM coursdelabourse";
            PreparedStatement ps = accesBDD.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                //Cours.add(new ListeCours(rs.getInt("prix"),rs.getString("entreprise")));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            accesBDD.disconnection();
        }
        return Cours;
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