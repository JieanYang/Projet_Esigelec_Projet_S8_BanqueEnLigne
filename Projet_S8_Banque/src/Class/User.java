package Class;
import java.util.*;

/**
 * 
 */
public class User {

    /**
     * Default constructor
     */
    public User() {
    }
    
    public User(int id_user, String categorie_user, String nom, String prenom, String email, String adresse,
			String telephone, String ville, String pays, String password, Date dateNaissance) {
		super();
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
		this.dateNaissance = dateNaissance;
	}


	public int getId_user() {
		return id_user;
	}

	public String getCategorie_user() {
		return categorie_user;
	}

	public void setCategorie_user(String categorie_user) {
		this.categorie_user = categorie_user;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
    
    /**
     * 
     */
    private int id_user;

    /**
     * 
     */
    private String categorie_user;

    /**
     * 
     */
    private String nom;

    /**
     * 
     */
    private String prenom;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String adresse;

    /**
     * 
     */
    private String telephone;

	/**
     * 
     */
    private String ville;

    /**
     * 
     */
    private String pays;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private Date dateNaissance;

}