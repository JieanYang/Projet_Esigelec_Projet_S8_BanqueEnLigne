package vue;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	// all panel
	private JPanel mainPanel = new JPanel(); 
	private PanelLogin login = new PanelLogin();
	private PanelMenu menu = new PanelMenu();
	private PanelListClient listeClient = new PanelListClient();
	private PanelInformationClient infoClient = new PanelInformationClient(); // put id_user in ?
	private PanelInformationsCompteClients infoCompteClient = new PanelInformationsCompteClients();

	private PanelTransaction transaction = new PanelTransaction();
	
	public MainFrame() {
		this.setTitle("Main Frame");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void setPanel(String nomPage) {
		if (nomPage.equals("login")) {
			this.mainPanel = login;
		} else if (nomPage.equals("menu")) {
			this.mainPanel = menu;
		} else if (nomPage.equals("listeClient")) {
			this.mainPanel = listeClient;
		} else if (nomPage.equals("infoClient")) {
			this.mainPanel = infoClient;
		} else if (nomPage.equals("infoCompteClient")) {
			this.mainPanel = infoCompteClient;
		} else if (nomPage.equals("transaction")) {
			this.mainPanel = transaction;
		}
		this.setContentPane(this.mainPanel);
		this.validate();
		this.repaint();
	}

}
