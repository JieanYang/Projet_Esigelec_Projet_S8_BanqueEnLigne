package Class;

import java.sql.Date;

public class Actions {
	
	private int id_user;
	private String entreprise;
	private float prixachat;
	private Date date;
	private int nombre;
	
	public int getid_user() {
		return id_user;
	}
	public void setid_user(int id_user) {
		this.id_user= id_user;
	}
	public String getentreprise() {
		return entreprise;
	}
	public void setentreprise(String entreprise) {
		this.entreprise = entreprise;
	}
	public float getprixachat() {
		return prixachat;
	}
	public void setprixachat(float prixachat) {
		this.prixachat = prixachat;
	}
	public Date getdate() {
		return date;
	}
	public void setdate(Date date) {
		this.date = date;
	}	
	public int getnombre() {
		return nombre;
	}
	public void setnombre(int  nombre) {
		this.nombre = nombre;
	}	
}
