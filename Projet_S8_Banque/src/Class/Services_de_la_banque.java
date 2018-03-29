package Class;
import java.util.*;

/**
 * 
 */
public class Services_de_la_banque {

    /**
     * Default constructor
     */
    public Services_de_la_banque() {
    }

    public int getId_service() {
		return id_service;
	}

	public void setId_service(int id_service) {
		this.id_service = id_service;
	}

	public String getNom_service() {
		return nom_service;
	}

	public void setNom_service(String nom_service) {
		this.nom_service = nom_service;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
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
    private int id_service;

    /**
     * 
     */
    private String nom_service;

    /**
     * 
     */
    private float prix;

    /**
     * 
     */
    private String description;

}