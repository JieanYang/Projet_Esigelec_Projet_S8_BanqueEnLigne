package dto;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

import dao.ConnectionBDD;

/**
 * 
 */
public class Transaction {
	
    private int id_transaction;
    private String categorie_transaction;
    private int id_compte_emetteur;
    private int id_compte_recepteur;
    private Timestamp date;
    private float somme;
    private String description;

    public Transaction(int id_transaction, String categorie_transaction, int id_compte_emetteur,
			int id_compte_recepteur, Timestamp date, float somme, String description) {
		this.id_transaction = id_transaction;
		this.categorie_transaction = categorie_transaction;
		this.id_compte_emetteur = id_compte_emetteur;
		this.id_compte_recepteur = id_compte_recepteur;
		this.date = date;
		this.somme = somme;
		this.description = description;
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

	public void setDate(Timestamp date) {
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

}