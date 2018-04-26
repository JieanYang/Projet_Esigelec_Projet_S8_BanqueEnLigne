package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 
 */
public class CompteDao {

	private static String sql;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet = null;

	/**
	 * @param int
	 *            -> id_client
	 * @return List<Compte> -> retour
	 */
	public static String getListCompteById_lient(int id_client) {
		String listCompte = null;

		sql = "SELECT * FROM Compte WHERE id_user =?";
		try {
			preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
			preparedStatement.setInt(1, id_client);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String compte = resultSet.getInt("id_compte") + "/" + resultSet.getInt("id_user") + "/"
						+ resultSet.getString("categorie_compte") + "/" + resultSet.getString("etat") + "/"
						+ resultSet.getFloat("solde") + "/" + resultSet.getDate("date_create") + "/"
						+ resultSet.getDate("date_delete");
				listCompte = listCompte + ";" + compte;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionBDD.closeConnection();
		}
		return listCompte;
	}

	/**
	 * @param int
	 *            -> id
	 * @return Class Compte -> retour
	 */
	public static String getCompte(int compteID) {
		String compte = null;

		String sql = "SELECT * FROM Compte WHERE id_compte = ?";
		try {
			preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
			preparedStatement.setInt(1, compteID);
			resultSet = preparedStatement.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (resultSet.next()) {
				compte = resultSet.getInt("id_compte") + "/" + resultSet.getInt("id_user") + "/"
						+ resultSet.getString("categorie_compte") + "/" + resultSet.getString("etat") + "/"
						+ resultSet.getFloat("solde") + "/" + resultSet.getDate("date_create") + "/"
						+ resultSet.getDate("date_delete");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionBDD.closeConnection();
		}
		return compte;
	}

	/**
	 * @param Class
	 *            Compte -> compte
	 * @return Class Compte -> retour
	 */
	public static String updateCompte(int compteID, float newSolde) {
		String update = null;
		
		String sql = "UPDATE `compte` SET `solde` = ? WHERE `compte`.`id_compte` = ?";
		try {
			preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
			preparedStatement.setFloat(1, newSolde);
			preparedStatement.setInt(2, compteID);
			preparedStatement.executeUpdate();
			update = "updated";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionBDD.closeConnection();
		}
		return update;
	}

	// ---------------------------------------Unused
	// under------------------------------------------------------------------------

	// /**
	// * @param Class Compte -> compte
	// * @return Class Compte -> retour
	// * id_compte, date_create produce automatically
	// */
	// public Compte addCompte(Compte compte) {
	// Compte retour = null;
	// int success = 0;
	//
	// try {
	// String sql ="INSERT INTO Compte(id_user, categorie_compte, etat, solde,
	// date_create, date_delete) "
	// + "VALUES (?, ?, ?, ?, ?, ?)";
	// preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
	// preparedStatement.setInt(1, compte.getId_user());
	// preparedStatement.setString(2, "xxxx");
	// preparedStatement.setString(3, compte.getEtat());
	// preparedStatement.setFloat(4, compte.getSolde());
	//
	// long millis=System.currentTimeMillis();
	// java.sql.Date date=new java.sql.Date(millis);
	// preparedStatement.setDate(5, (java.sql.Date) date);
	// preparedStatement.setString(6, null);
	//
	// /*
	// * Execute the sql to add a new compte
	// * If everything work, return int 1
	// */
	// success = preparedStatement.executeUpdate();
	//
	//
	//
	// /**
	// * After success to add Compte
	// * we will find the Compte we added by the field id_user, categorie_compte and
	// date_create
	// *
	// */
	// if (success == 1) {
	//
	// sql = "SELECT id_compte FROM Compte WHERE categorie_compte='xxxx' AND
	// id_user=?";
	// preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
	//// preparedStatement.setString(1, compte.getCategorie_compte());
	// preparedStatement.setInt(1, compte.getId_user());
	//// preparedStatement.setString(3, date.toString());
	//
	// resultSet = preparedStatement.executeQuery();
	//
	// if(resultSet.next()) {
	// int id_compte = resultSet.getInt("id_compte");
	// retour = this.getCompte(id_compte);
	// // retour avec categorie_compte = 'xxxx', reset categorie_compte
	// retour.setCategorie_compte(compte.getCategorie_compte());
	// retour = this.updateCompte(retour);
	// }
	// }else if (success == 0) {
	// retour = null;
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }finally {
	// ConnectionBDD.closeConnection();
	// }
	//
	// return retour; // return an instance of Class Compte
	// }
	//
	//
	//
	// /**
	// * @param void
	// * @return List<Compte> -> retour
	// */
	// public List<Compte> getListCompte() {
	// List<Compte> retour = new ArrayList<Compte>();
	//
	// try {
	// String sql ="SELECT * FROM Compte ORDER BY date_create DESC";
	// preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
	//
	// /**
	// * We take out all the compte in the BDD
	// *
	// */
	// resultSet = preparedStatement.executeQuery();
	// // passe a la premiere (et unique) ligne retournee
	// while(resultSet.next()) {
	// /*
	// * We create a new instance of Compte and
	// * then use method List.add() to add into the retour
	// */
	// retour.add(new Compte(resultSet.getInt("id_compte"),
	// resultSet.getInt("id_user"), resultSet.getString("categorie_compte"),
	// resultSet.getString("etat"), resultSet.getFloat("solde"),
	// resultSet.getDate("date_create"),
	// resultSet.getDate("date_delete")));
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }finally {
	// ConnectionBDD.closeConnection();
	// }
	//
	// return retour; // return a list Compte
	// }
	//
	// /**
	// * @param Class Compte -> compte
	// * @return int -> retour
	// * Delete by id in the compte
	// */
	// public int deleteCompte(Compte compte) {
	// int retour = 0;
	//
	// try {
	// String sql ="DELETE FROM Compte WHERE id_compte = ?";
	// preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
	// preparedStatement.setInt(1, compte.getId_compte());
	// /*
	// * We find the compte by id_compte
	// * If everything good work, retourn integer 1
	// */
	// retour = preparedStatement.executeUpdate();
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }finally {
	// ConnectionBDD.closeConnection();
	// }
	//
	// return retour; // return 1 -> success or return 0 -> fail
	// }
	//
	// public boolean creerCompteBancaire(String nom, String prenom,int telephone,
	// String email ,String adresse, String date, String ville ,String pays,String
	// code, String categorie) {
	//
	// try {
	// String sql = "INSERT INTO user (`nom`, `prenom`, `email`, `adresse`,
	// `telephone`, `dateNaissance`, `ville`, `pays`,`code`,`categorie_user`) VALUES
	// (?, ?, ?, ?, ?, ?, ?, ?,?,?)";
	// preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
	// preparedStatement.setString(1, nom);
	// preparedStatement.setString(2, prenom);
	// preparedStatement.setString(3, email);
	// preparedStatement.setString(4, adresse);
	// preparedStatement.setInt(5, telephone);
	// preparedStatement.setString(6, date);
	// preparedStatement.setString(7, ville);
	// preparedStatement.setString(8, pays);
	// preparedStatement.setString(9, code);
	// preparedStatement.setString(10, categorie);
	//
	// preparedStatement.executeUpdate();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }finally {
	// ConnectionBDD.closeConnection();
	// }
	// return false;
	// }
	//
	//
	// public String recupererCode(String email) {
	// String retour = null;
	//
	// try {
	// String sql ="SELECT code FROM User WHERE email = ?";
	// preparedStatement = ConnectionBDD.setConnection().prepareStatement(sql);
	// preparedStatement.setString(1, email);
	//
	// /**
	// * on execute la requete
	// * resultSet contient un pointeur situe juste avant la premiere ligne
	// retournee
	// *
	// */
	// resultSet = preparedStatement.executeQuery();
	// // passe a la premiere (et unique) ligne retournee
	// if (resultSet.next()) {
	// retour = resultSet.getString("code");
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }finally {
	// ConnectionBDD.closeConnection();
	// }
	//
	// return retour;
	// }

	// ---------------------------------------Unused
	// above------------------------------------------------------------------------
}