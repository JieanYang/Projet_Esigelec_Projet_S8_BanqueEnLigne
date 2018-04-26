package controleur;

import java.awt.Component;

import dto.Message;
import dto.User;

import vue.InformationsClient;
import vue.ListeClient;
import vue.ListeMessage;
import vue.Login;
import vue.MainFrame;
import vue.Menu;
import vue.OffreBanque;
import vue.ReponseMessage;
import vue.Virement;

public class MainControleur {
	
	// The frame
	private static MainFrame mFrame = new MainFrame();
	
	// The panels
	private Login loginPanel = new Login();
	private static Menu menuPanel;
	private static InformationsClient informationClientPanel;
	private static Virement virementPanel;
	private static ReponseMessage reponseMessagePanel;
	private static OffreBanque oBanque = new OffreBanque();
	
	public static Component frame;
	
	// The controler
	private static ControleurInfoClient cInfoClient = new ControleurInfoClient();
	private static ControleurReponseMessage cReponseMessage = new ControleurReponseMessage();
	
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
		ListeClient.getListOfClient();
		mFrame.setPanel(new ListeClient());
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
	
	public static void listeMessagePanel() {
		ListeMessage.getListOfMessage();
		mFrame.setPanel(new ListeMessage());
	}
	
	public static void reponseMessagePanel(int messageID) {
		Message message = cReponseMessage.getDataMessage(messageID);
		reponseMessagePanel = new ReponseMessage(message);
		mFrame.setPanel(reponseMessagePanel);
	}
	
	public static void offreBanquePanel() {
		mFrame.setPanel(oBanque);
	}

}
