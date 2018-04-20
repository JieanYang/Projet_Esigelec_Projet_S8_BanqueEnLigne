package Class;
import java.util.*;

/**
 * 
 */
public class Compte {
	
	
	/**
     * Default constructor
     */
    public Compte(int id_compte, int id_user, String categorie_compte, String etat, float solde, Date date_create, Date date_delete) {
    	this.id_compte = id_compte;
    	this.id_user = id_user;
    	this.categorie_compte = categorie_compte;
    	this.etat = etat;
    	this.solde = solde;
    	this.date_create = date_create;
    	this.date_delete = date_delete;
    }
    
    public Compte() {
		
	}

    public int getId_compte() {
		return id_compte;
	}

	public void setId_compte(int id_compte) {
		this.id_compte = id_compte;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getCategorie_compte() {
		return categorie_compte;
	}

	public void setCategorie_compte(String categorie_compte) {
		this.categorie_compte = categorie_compte;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public Date getDate_create() {
		return date_create;
	}

	public void setDate_create(Date date_create) {
		this.date_create = date_create;
	}

	public Date getDate_delete() {
		return date_delete;
	}

	public void setDate_delete(Date date_delete) {
		this.date_delete = date_delete;
	}


    /**
     * 
     */
    private int id_compte;

    /**
     * 
     */
    private int id_user;

    /**
     * 
     */
    private String categorie_compte;

    /**
     * 
     */
    private String etat;

    /**
     * 
     */
    private float solde;

    /**
     * 
     */
    private Date date_create;

    /**
     * 
     */
    private Date date_delete;

}