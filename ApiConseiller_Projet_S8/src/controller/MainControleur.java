package controller;

import java.awt.Component;

import dto.Transaction;
import dto.User;
import vue.InformationsClient;
import vue.ListeClient;
import vue.Login;
import vue.MainFrame;
import vue.Menu;
import vue.Virement;

public class MainControleur {
	
	// the frame
	private static MainFrame mFrame = new MainFrame();
	
	// the panels
	private Login loginPanel = new Login();
	private static Menu menuPanel;
	private static ListeClient listeClient = new ListeClient();
	private static InformationsClient informationClientPanel;
	private static Virement virementPanel;
	
	public static Component frame;
	
	// the controler
	private ControleurLogin cLogin = new ControleurLogin();
	private static ControleurInfoClient cInfoClient = new ControleurInfoClient();
	
	// Conseiller
	public static User conseiller = new User();
	
	public MainControleur() {
			mFrame.setPanel(loginPanel);
	}
	
	public static void menuPanel() {
		menuPanel = new Menu();
			mFrame.setPanel(menuPanel);
	}
	
	public static void listeClientPanel() {
		mFrame.setPanel(listeClient);
	}
	
	public static void informationsClientPanel(int clientID) {
		User client = cInfoClient.getDataClient(clientID);
		informationClientPanel = new InformationsClient(client);
		mFrame.setPanel(informationClientPanel);
	}
	
	public static void virementPanel(int clientID) {
		User client = cInfoClient.getDataClient(clientID);
		virementPanel = new Virement(client);
		mFrame.setPanel(virementPanel);
	}

}
