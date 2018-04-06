package bean;
import java.sql.Timestamp;
import java.util.*;

/**
 * It doesn't have methods setId_message() and setProblem()
 * The reason for setProblem() is that Problem in the Class doesn't change after enter
 * In the BDD, field Problem is unique
 */
public class MessageBean {

    /**
     * Default constructor
     */
    public MessageBean(int id, String nom, String prenom, String numphone, String email, String problem, String reponse, Timestamp date) {
    	this.id_message = id;
    	this.nom = nom;
    	this.prenom = prenom;
    	this.numphone = numphone;
    	this.email = email;
    	this.problem = problem;
    	this.reponse = reponse;
    	this.date = date;
    }

    public MessageBean() {
		// TODO Auto-generated constructor stub
	}

	public int getId_message() {
		return id_message;
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

	public String getNumphone() {
		return numphone;
	}

	public void setNumphone(String numphone) {
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

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
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
    private String numphone;

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
    private Timestamp date;

}