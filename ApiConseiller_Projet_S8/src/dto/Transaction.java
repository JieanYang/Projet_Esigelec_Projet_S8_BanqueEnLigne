package dto;

import java.sql.Timestamp;
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

    
    
    public Transaction(int id_transaction, String categorie_transaction, int id_compte_emetteur,
			int id_compte_recepteur, Timestamp date_transaction, Timestamp date_create, float somme,
			String description) {
		super();
		this.id_transaction = id_transaction;
		this.categorie_transaction = categorie_transaction;
		this.id_compte_emetteur = id_compte_emetteur;
		this.id_compte_recepteur = id_compte_recepteur;
		this.date_transaction = date_transaction;
		this.date_create = date_create;
		this.somme = somme;
		this.description = description;
	}



	public int getId_transaction() {
		return id_transaction;
	}

	public String getCategorie_transaction() {
		return categorie_transaction;
	}

	public int getId_compte_emetteur() {
		return id_compte_emetteur;
	}

	public int getId_compte_recepteur() {
		return id_compte_recepteur;
	}

	public Timestamp getDate_transaction() {
		return date_transaction;
	}

	public Timestamp getDate_create() {
		return date_create;
	}

	public float getSomme() {
		return somme;
	}

	public String getDescription() {
		return description;
	}

	public void setId_transaction(int id_transaction) {
		this.id_transaction = id_transaction;
	}

	public void setCategorie_transaction(String categorie_transaction) {
		this.categorie_transaction = categorie_transaction;
	}

	public void setId_compte_emetteur(int id_compte_emetteur) {
		this.id_compte_emetteur = id_compte_emetteur;
	}

	public void setId_compte_recepteur(int id_compte_recepteur) {
		this.id_compte_recepteur = id_compte_recepteur;
	}

	public void setDate_transaction(Timestamp date_transaction) {
		this.date_transaction = date_transaction;
	}

	public void setDate_create(Timestamp date_create) {
		this.date_create = date_create;
	}

	public void setSomme(float somme) {
		this.somme = somme;
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
    private Timestamp date_transaction;

    /**
     * 
     */
    private Timestamp date_create;

    /**
     * 
     */
    private float somme;

    /**
     * 
     */
    private String description;

}