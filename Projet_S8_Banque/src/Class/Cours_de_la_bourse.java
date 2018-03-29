package Class;
import java.util.*;

/**
 * 
 */
public class Cours_de_la_bourse {

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
     * Default constructor
     */
    public Cours_de_la_bourse() {
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