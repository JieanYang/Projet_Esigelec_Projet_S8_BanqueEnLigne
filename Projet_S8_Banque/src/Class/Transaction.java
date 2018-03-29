package Class;
import java.util.*;

/**
 * 
 */
public class Transaction {

    /**
     * Default constructor
     */
    public Transaction() {
    }

    public int getId_transaction() {
		return id_transaction;
	}

	public void setId_transaction(int id_transaction) {
		this.id_transaction = id_transaction;
	}

	public String getCategorie_transaction() {
		return categorie_transaction;
	}

	public void setCategorie_transaction(String categorie_transaction) {
		this.categorie_transaction = categorie_transaction;
	}

	public int getId_compte_emetteur() {
		return id_compte_emetteur;
	}

	public void setId_compte_emetteur(int id_compte_emetteur) {
		this.id_compte_emetteur = id_compte_emetteur;
	}

	public int getId_compte_recepteur() {
		return id_compte_recepteur;
	}

	public void setId_compte_recepteur(int id_compte_recepteur) {
		this.id_compte_recepteur = id_compte_recepteur;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getSomme() {
		return somme;
	}

	public void setSomme(float somme) {
		this.somme = somme;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
     * 
     */
    private int id_transaction;

    /**
     * 
     */
    private String categorie_transaction;

    /**
     * 
     */
    private int id_compte_emetteur;

    /**
     * 
     */
    private int id_compte_recepteur;

    /**
     * 
     */
    private Date date;

    /**
     * 
     */
    private float somme;

    /**
     * 
     */
    private String description;

}