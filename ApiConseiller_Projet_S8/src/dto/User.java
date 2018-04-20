package dto;
import java.util.*;

/**
 * User object created when we log in
 */
public class User {
	
	private int id_user;
    private String categorie_user;
    private String nom;
    private String prenom;
    private String email;
    private String adresse;
    private String telephone;
    private String ville;
    private String pays;
    private String password;
    private String StringNaissance;
    
    // default consrtructor
    public User() {
    	
    }

    public User(int id_user, String categorie_user, String nom, String prenom, String email, String adresse,
			String telephone, String ville, String pays, String password, String StringNaissance) {
		this.id_user = id_user;
		this.categorie_user = categorie_user;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.telephone = telephone;
		this.ville = ville;
		this.pays = pays;
		this.password = password;
		this.StringNaissance = StringNaissance;
	}

    /**
     * 	
     * @return
     */
	public int getId_user() {
		return id_user;
	}

	/**
	 * I dont think we should be able to change the user ID !!!!
	 * @param id_user
	 */
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	/**
	 * get the user category (client, advisor, manager)
	 * @return the category of the user
	 */
	public String getCategorie_user() {
		return categorie_user;
	}

	/**
	 * I dont think we should be able to change the user category !!!!
	 * @param categorie_user
	 */
	public void setCategorie_user(String categorie_user) {
		this.categorie_user = categorie_user;
	}

	/**
	 * get the user's last name
	 * @return the user's last name
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * change the user's last name
	 * @param new user's last name
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * get the user's first name
	 * @return the user's first name
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * change the user's first name
	 * @param new user's first name
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * get the user's email
	 * @return the user's email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * change the user's email
	 * @param new user's email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * get the user's address
	 * @return the user's address
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * change the user's address
	 * @param new user's address
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * get the user's phone number
	 * @return the user's phone number
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * change the user's phone number
	 * @param new user's phone number
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * get the user's city
	 * @return the user's city
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * change the user's city
	 * @param new user's city
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * get the user's country
	 * @return the user's country
	 */
	public String getPays() {
		return pays;
	}

	/**
	 * change the user's country
	 * @param new user's country
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}

	/**This method may be useful if we set a "forgot password" option on our app ?
	 * get the user's password
	 * @return the user's password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * change the user's password
	 * @param new user's password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * get the user's birth String
	 * @return the user's birth String
	 */
	public String getStringNaissance() {
		return StringNaissance;
	}

	/**
	 * I dont think we should be able to change the user birthday !!!!
	 * @param StringNaissance
	 */
	public void setStringNaissance(String StringNaissance) {
		this.StringNaissance = StringNaissance;
	}

}