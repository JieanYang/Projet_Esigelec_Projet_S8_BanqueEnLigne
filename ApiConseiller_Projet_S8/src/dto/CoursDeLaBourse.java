package dto;

import java.util.*;

/**
 * 
 */
public class CoursDeLaBourse {

    private int id_entreprise;
    private String entreprise;
    private float prix;
    public Date date;

    public CoursDeLaBourse(int id_entreprise, String entreprise, float prix, Date date) {
		this.id_entreprise = id_entreprise;
		this.entreprise = entreprise;
		this.prix = prix;
		this.date = date;
	}

	public int getId_entreprise() {
		return id_entreprise;
	}

	public void setId_entreprise(int id_entreprise) {
		this.id_entreprise = id_entreprise;
	}

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}