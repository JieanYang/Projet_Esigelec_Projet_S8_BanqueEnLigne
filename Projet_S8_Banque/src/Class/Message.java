package Class;
import java.util.*;

/**
 * 
 */
public class Message {

    /**
     * Default constructor
     */
    public Message(int id, String nom, String prenom, int numphone, String email, String problem, String reponse, Date date) {
    	this.id_message = id;
    	this.nom = nom;
    	this.prenom = prenom;
    	this.numphone = numphone;
    	this.email = email;
    	this.problem = problem;
    	this.reponse = reponse;
    	this.date = date;
    }

    public int getId_message() {
		return id_message;
	}

	public void setId_message(int id_message) {
		this.id_message = id_message;
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

	public int getNumphone() {
		return numphone;
	}

	public void setNumphone(int numphone) {
		this.numphone = numphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	/**
     * 
     */
    private int id_message;

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
    private int numphone;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String problem;

    /**
     * 
     */
    private String reponse;

    /**
     * 
     */
    private Date date;

}