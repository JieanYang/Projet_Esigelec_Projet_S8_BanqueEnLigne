package Interface_conseiller;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame{
	private String titre_fenetre;
	private JPanel p;
	private int id_client;
	private int id_compte;
	private int id_message;

	public Fenetre() {
		this.init();
		this.setSize(600,600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setBackground(Color.WHITE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void init() {

	}
	
	public void setPanel(JPanel p) {
		this.p = p;
		this.setContentPane(this.p);
		// this.revalidate();
		this.validate();
		this.repaint();
	}
	
	public String getTitre_fenetre() {
		return titre_fenetre;
	}

	public void setTitre_fenetre(String titre_fenetre) {
		this.titre_fenetre = titre_fenetre;
		this.setTitle(this.titre_fenetre);
	}

	public int getId_client() {
		return id_client;
	}
	
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	
	public int getId_compte() {
		return id_compte;
	}

	public void setId_compte(int id_compte) {
		this.id_compte = id_compte;
	}
	
	public int getId_message() {
		return id_message;
	}

	public void setId_message(int id_message) {
		this.id_message = id_message;
	}
	

}
