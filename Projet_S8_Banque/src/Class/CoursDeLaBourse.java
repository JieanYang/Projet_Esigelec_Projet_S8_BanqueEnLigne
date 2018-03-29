package Class;

import java.util.*;

/**
 * 
 */
public class CoursDeLaBourse {

    /**
     * Default constructor
     */
    public CoursDeLaBourse() {
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

	/**
     * 
     */
    private int id_entreprise;

    /**
     * 
     */
    private String entreprise;

    /**
     * 
     */
    private float prix;

    /**
     * 
     */
    public Date date;

}