package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import Class.Actions;
import Class.Compte;
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

	public int verif(int id_user, String entreprise){
		ConnexionBDD accesBDD = new ConnexionBDD();
		accesBDD.connection();
		int retour=0;
		try {
			String sql = "SELECT nombre FROM actions WHERE id_user=? AND entreprise =?";
			
			PreparedStatement preparedStatement = ConnexionBDD.connection().prepareStatement(sql);
			
			preparedStatement.setInt(1, id_user);
			preparedStatement.setString(2, entreprise);
			
			System.out.println("yes "+preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
                retour = rs.getInt("nombre");
                return retour ;
            }
			} 
			catch (SQLException e1) {
				e1.printStackTrace();
				System.out.println("non"+sql);
			}
		finally {
			accesBDD.disconnection();
		}
		return retour;
	}
	
	public void updatenombre(Actions action) {
		ConnexionBDD accesBDD = new ConnexionBDD();
        accesBDD.connection();
        try {
            String sql ="UPDATE actions SET  nombre=? WHERE id_user=? AND entreprise=?";
            PreparedStatement preparedStatement = ConnexionBDD.connection().prepareStatement(sql);
			preparedStatement.setInt(2, action.getid_user());
			preparedStatement.setString(3, action.getentreprise());
			preparedStatement.setInt(1, action.getnombre());
			
            System.out.println(preparedStatement);
            /*
             * Execute the sql to add a new compte
             * If everything work, return int 1
             */
            preparedStatement.executeUpdate(); // if everything good work, retourn integer 1
            
            /**
             * After success to update Compte
             * we will find the Compte we updated by the field id_compte
             * Because the field id_compte is unique in the BDD
             * we use the method .getCompte(int id) to find the compte in BDD
             * 
             */            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            accesBDD.disconnection();
        }
    }
	
	 public Actions getAction(int id_user, String entreprise) {
	        Actions retour = new Actions();
	        ConnexionBDD accesBDD = new ConnexionBDD();
	        accesBDD.connection();
	        try {
	            String sql ="SELECT * FROM actions WHERE id_user=? AND entreprise =?";//test sans AND et juste,
	            PreparedStatement preparedStatement = ConnexionBDD.connection().prepareStatement(sql);
				
				preparedStatement.setInt(1, id_user);
				preparedStatement.setString(2, entreprise);
				
				System.out.println("yes "+preparedStatement);
	            /**
	             * on execute la requete
	             * rs contient un pointeur situe juste avant la premiere ligne retournee
	             * 
	             */
	            ResultSet rs = preparedStatement.executeQuery();
	            // passe a la premiere (et unique) ligne retournee
	            if (rs.next()) {
	                retour = new Actions(rs.getInt("id_user"), rs.getString("entreprise"), rs.getInt("prixachat"),
	                        rs.getDate("date"), rs.getInt("nombre"));
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally {
	            accesBDD.disconnection();
	        }
	        return retour;
	    }
	 
	 public void delete() {
			ConnexionBDD accesBDD = new ConnexionBDD();
	        accesBDD.connection();
	        try {
	            String sql ="DELETE FROM actions WHERE nombre=0";
	            PreparedStatement preparedStatement = ConnexionBDD.connection().prepareStatement(sql);
	            preparedStatement.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally {
	            accesBDD.disconnection();
	        }
	    }
	    
	
	
}


