package dto;

/**
 * 
 */
public class ServicesDeLaBanque {
	
	private int id_service;
    private String nom_service;
    private float prix;
    private String description;

    public ServicesDeLaBanque(int id_service, String nom_service, float prix, String description) {
		this.id_service = id_service;
		this.nom_service = nom_service;
		this.prix = prix;
		this.description = description;
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

}