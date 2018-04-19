package dto;



import java.util.List;

public class Offres {
	 private String nom_service;
		
		private String description;
		/**
	     * Default constructor
	     */
	    public Offres() {
	    }

	    public String getNom_service() {
			return nom_service;
		}

		public void setNom_service(String nom_service) {
			this.nom_service = nom_service;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		/**
	     * @param actualite 
	     * @return
	     */
	    public Offres addOffres(Offres offres) {
	        // TODO implement here
	        return null;
	    }

	    /**
	     * @param actualite 
	     * @return
	     */
	    public Offres updateOffres(Offres offres) {
	        // TODO implement here
	        return null;
	    }

	    /**
	     * @param id 
	     * @return
	     */
	    public Offres getOffres(int id) {
	        // TODO implement here
	        return null;
	    }

	    /**
	     * @return
	     */
	    public List<Offres> getListOffres() {
	        // TODO implement here
	        return null;
	    }

	    /**
	     * @param actualite 
	     * @return
	     */
	    public int deleteOffres(Offres offres) {
	        // TODO implement here
	        return 0;
	    }
	    
	    
	    	/*constructeur*/

	    	public Offres (String nom_service, String description){
	    		this.nom_service = nom_service;

	    		this.description = description;

	    	  }
	    	
	    	

	
}

