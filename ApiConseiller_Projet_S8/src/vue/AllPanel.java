package vue;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import controller.ControleurListeClient;
import controller.ControleurLogin;
import controller.ControleurMenu;
import dto.User;

public class AllPanel {
	
	// the controlers
	ControleurLogin cLogin = new ControleurLogin();
	ControleurMenu cMenu = new ControleurMenu();
	ControleurListeClient cListeClient = new ControleurListeClient();

	// the main frame
	protected MainFrame mainFrame;

	// the panels
	protected JPanel loginPanel = new JPanel();
	protected JPanel menuPanel = new JPanel();
	protected JPanel listeClientPanel = new JPanel();
	protected JPanel informationsClientPanel = new JPanel();
	protected JPanel informationsCompteClientPanel = new JPanel();
	protected JPanel transactionPanel = new JPanel();
	
	// Conseiller
	private User conseiller = new User();

	/**
	 * Create the panel.
	 */
	public AllPanel(MainFrame mFrame) {
		this.mainFrame = mFrame;
	}

	public JPanel loginPanel() {

		mainFrame.setTitle("Login");

		this.loginPanel.setLayout(null);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(185, 172, 116, 32);
		loginPanel.add(lblEmail);

		JTextField tFieldEmail = new JTextField();
		tFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tFieldEmail.setBounds(185, 217, 232, 32);
		loginPanel.add(tFieldEmail);
		tFieldEmail.setColumns(10);

		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMotDePasse.setBounds(185, 281, 170, 32);
		loginPanel.add(lblMotDePasse);

		JPasswordField tFieldPassword = new JPasswordField();
		tFieldPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tFieldPassword.setBounds(185, 326, 232, 32);
		loginPanel.add(tFieldPassword);
		tFieldPassword.setColumns(10);

		JButton btnConnecxion = new JButton("Connexion");
		btnConnecxion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnConnecxion.setBounds(216, 392, 170, 32);
		btnConnecxion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cLogin.checkCredentials(tFieldEmail.getText(), new String(tFieldPassword.getPassword()))) {
					conseiller = cMenu.getConseillerInfo(tFieldEmail.getText());
					mainFrame.setPanel(menuPanel());
				}
			}
		});
		this.loginPanel.add(btnConnecxion);

		return this.loginPanel;
	}

	public JPanel menuPanel() {
		mainFrame.setTitle("Menu");

		menuPanel.setLayout(null);

		JLabel lblConnecteSous = new JLabel("Connecté sous :");
		lblConnecteSous.setBounds(74, 67, 100, 16);
		menuPanel.add(lblConnecteSous);

		JLabel lblNomConseiller = new JLabel(conseiller.getNom()+" "+conseiller.getPrenom());
		lblNomConseiller.setBounds(186, 67, 225, 16);
		menuPanel.add(lblNomConseiller);

		JButton btnAfficherListeClient = new JButton("Afficher la liste des clients");
		btnAfficherListeClient.setBounds(177, 169, 246, 25);
		btnAfficherListeClient.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				mainFrame.setPanel(listeClientPanel());
			}
		});
		menuPanel.add(btnAfficherListeClient);

		JButton btnAfficherMessage = new JButton("Voir les messages clients");
		btnAfficherMessage.setBounds(177, 235, 246, 25);
		// btnAfficherMessage.addActionListener(new ActionListener() {
		//
		// public void actionPerformed(ActionEvent e) {
		// mainFrame.setPanel(messagePanel());
		// }
		// });
		menuPanel.add(btnAfficherMessage);

		return menuPanel;
	}

	public JPanel listeClientPanel() {

		mainFrame.setTitle("Liste des Clients");

		listeClientPanel.setLayout(null);
		
		Vector<User> userList = cListeClient.getListClient();
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		for(User aUser : userList) {
			dlm.addElement(aUser.getId_user()+" "+aUser.getNom()+" "+aUser.getPrenom()+" "+aUser.getEmail()+" "+aUser.getTelephone());
		}
		
		JList<String> list = new JList<String>(dlm);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBorder(BorderFactory.createTitledBorder("Liste des clients"));
		JScrollPane scrollPane = new JScrollPane(list);
		listeClientPanel.add(scrollPane);
		list.setBounds(71, 76, 457, 415);
		listeClientPanel.add(list);

		JButton btnAfficherLesInformations = new JButton("Afficher les informations");
		btnAfficherLesInformations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.setPanel(informationsClient());
			}
		});
		btnAfficherLesInformations.setBounds(180, 504, 205, 25);
		listeClientPanel.add(btnAfficherLesInformations);

		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(71, 504, 97, 25);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.setPanel(menuPanel());
			}
		});
		listeClientPanel.add(btnRetour);

		JButton btnVirement = new JButton("Faire virement");
		btnVirement.setBounds(397, 504, 131, 25);
		btnVirement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.setPanel(transactionPanel());
			}
		});
		listeClientPanel.add(btnVirement);

		JTextField recherche = new JTextField();
		recherche.setBounds(284, 49, 116, 22);
		listeClientPanel.add(recherche);
		recherche.setColumns(10);

		JButton btnRechercher = new JButton("Rechercher ?");
		btnRechercher.setBounds(412, 48, 116, 25);
		listeClientPanel.add(btnRechercher);

		return listeClientPanel;
	}

	public JPanel informationsClient() {

		mainFrame.setTitle("Informations Client");

		// must make the client data dynamic !!!!!!!!
		// infoClients.getDataClient(1);

		informationsClientPanel.setBorder(
				new TitledBorder(null, "Informations client", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		informationsClientPanel.setLayout(null);

		JLabel lblPrenom = new JLabel("Prenom :", SwingConstants.RIGHT);
		lblPrenom.setBounds(204, 83, 56, 16);
		informationsClientPanel.add(lblPrenom);

		JLabel lblClientPrenom = new JLabel("Abdoul");
		lblClientPrenom.setBounds(291, 83, 213, 16);
		informationsClientPanel.add(lblClientPrenom);

		JLabel lblNom = new JLabel("Nom :", SwingConstants.RIGHT);
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNom.setBounds(204, 127, 56, 16);
		informationsClientPanel.add(lblNom);

		JLabel lblClientNom = new JLabel("Mohamed");
		lblClientNom.setBounds(291, 127, 213, 16);
		informationsClientPanel.add(lblClientNom);

		JLabel lblDateDeNaissance = new JLabel("Date de naissance :", SwingConstants.RIGHT);
		lblDateDeNaissance.setBounds(106, 164, 154, 16);
		informationsClientPanel.add(lblDateDeNaissance);

		JLabel lblDateNaissanceClient = new JLabel("09/09/09");
		lblDateNaissanceClient.setBounds(291, 164, 213, 16);
		informationsClientPanel.add(lblDateNaissanceClient);

		JLabel lblNewLabel = new JLabel("Email :", SwingConstants.RIGHT);
		lblNewLabel.setBounds(204, 206, 56, 16);
		informationsClientPanel.add(lblNewLabel);

		JLabel lblEmailClient = new JLabel("abdoul@mail.com");
		lblEmailClient.setBounds(291, 206, 213, 16);
		informationsClientPanel.add(lblEmailClient);

		JLabel lblTelephone = new JLabel("Telephone :", SwingConstants.RIGHT);
		lblTelephone.setBounds(150, 249, 110, 16);
		informationsClientPanel.add(lblTelephone);

		JLabel lblNumTelClient = new JLabel("0909090909");
		lblNumTelClient.setBounds(291, 249, 213, 16);
		informationsClientPanel.add(lblNumTelClient);

		JLabel lblAdresse = new JLabel("Adresse :", SwingConstants.RIGHT);
		lblAdresse.setBounds(204, 294, 56, 16);
		informationsClientPanel.add(lblAdresse);

		JLabel lblAdresseClient = new JLabel("154 boefoezkjfl kzqnjae");
		lblAdresseClient.setBounds(291, 294, 213, 16);
		informationsClientPanel.add(lblAdresseClient);

		JLabel lblVille = new JLabel("Ville :", SwingConstants.RIGHT);
		lblVille.setBounds(204, 340, 56, 16);
		informationsClientPanel.add(lblVille);

		JLabel lblVilleClient = new JLabel("76100 Rouen");
		lblVilleClient.setBounds(291, 340, 213, 16);
		informationsClientPanel.add(lblVilleClient);

		JLabel lblPays = new JLabel("Pays :", SwingConstants.RIGHT);
		lblPays.setBounds(204, 384, 56, 16);
		informationsClientPanel.add(lblPays);

		JLabel lblPaysClient = new JLabel("France");
		lblPaysClient.setBounds(291, 384, 56, 16);
		informationsClientPanel.add(lblPaysClient);

		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(106, 462, 97, 25);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.setPanel(listeClientPanel());
			}
		});
		informationsClientPanel.add(btnRetour);

		JButton btnEditer = new JButton("Editer");
		btnEditer.setBounds(215, 462, 97, 25);
		btnEditer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// create the edit panel and add it here
			}
		});
		informationsClientPanel.add(btnEditer);

		JButton btnEditerInformations = new JButton("Consulter les comptes");
		btnEditerInformations.setBounds(325, 462, 179, 25);
		btnEditerInformations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.setPanel(informationsCompteClientPanel());
			}
		});
		informationsClientPanel.add(btnEditerInformations);

		return informationsClientPanel;
	}

	public JPanel informationsCompteClientPanel() {

		mainFrame.setTitle("Comptes Client");

		informationsCompteClientPanel.setBorder(new TitledBorder(null, "Informations des compte Client",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		informationsCompteClientPanel.setLayout(null);

		JLabel lblSlectionnezLeCompte = new JLabel("Sélectionnez le compte");
		lblSlectionnezLeCompte.setBounds(66, 56, 199, 16);
		informationsCompteClientPanel.add(lblSlectionnezLeCompte);

		JComboBox cBoxSelectionCompte = new JComboBox();
		cBoxSelectionCompte.setBounds(82, 85, 385, 22);
		informationsCompteClientPanel.add(cBoxSelectionCompte);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Informations du compte", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(34, 139, 482, 147);
		informationsCompteClientPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JList listCompte = new JList();
		panel.add(listCompte, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(null, "Historique du compte", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(34, 326, 482, 147);
		informationsCompteClientPanel.add(panel_1);
		panel_1.setLayout(null);

		JList listHistorique = new JList();
		listHistorique.setBounds(6, 18, 470, 122);
		panel_1.add(listHistorique);

		JButton btnInformationsClient = new JButton("Informations Client");
		btnInformationsClient.setBounds(309, 486, 148, 25);
		btnInformationsClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.setPanel(informationsClient());
			}
		});
		informationsCompteClientPanel.add(btnInformationsClient);

		JButton btnMenu = new JButton("Retour Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.setPanel(menuPanel());
			}
		});
		btnMenu.setBounds(102, 486, 132, 25);
		informationsCompteClientPanel.add(btnMenu);

		return informationsCompteClientPanel;
	}

	public JPanel transactionPanel() {

		mainFrame.setTitle("Réaliser une transaction");

		transactionPanel
				.setBorder(new TitledBorder(null, "Virement", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		transactionPanel.setLayout(null);

		JLabel lblCompteDbiter = new JLabel("Compte à débiter");
		lblCompteDbiter.setBounds(38, 93, 99, 16);
		transactionPanel.add(lblCompteDbiter);

		JComboBox cBoxCompteDebiteur = new JComboBox();
		cBoxCompteDebiteur.setBounds(162, 90, 344, 22);
		transactionPanel.add(cBoxCompteDebiteur);

		JLabel lblAvoirDisponible = new JLabel("Avoir disponible : 18 8867 €");
		lblAvoirDisponible.setBounds(401, 125, 160, 16);
		transactionPanel.add(lblAvoirDisponible);

		JLabel lblCompteCrditer = new JLabel("Compte à créditer");
		lblCompteCrditer.setBounds(38, 166, 103, 16);
		transactionPanel.add(lblCompteCrditer);

		JTextField tFieldCompteCrediter = new JTextField();
		tFieldCompteCrediter.setBounds(252, 163, 254, 22);
		transactionPanel.add(tFieldCompteCrediter);

		JLabel lblMontantDuVirement = new JLabel("Montant du virement en Euros");
		lblMontantDuVirement.setBounds(38, 217, 172, 16);
		transactionPanel.add(lblMontantDuVirement);

		JTextField tFieldMotant = new JTextField();
		tFieldMotant.setBounds(367, 214, 139, 22);
		transactionPanel.add(tFieldMotant);
		tFieldMotant.setColumns(10);

		JLabel euro = new JLabel("€");
		euro.setBounds(509, 217, 27, 16);
		transactionPanel.add(euro);

		JLabel lblDateVirement = new JLabel("Date de votre virement");
		lblDateVirement.setBounds(38, 276, 131, 16);
		transactionPanel.add(lblDateVirement);

		JButton btnNewButton = new JButton("Ajouter Datapicker ici");
		btnNewButton.setBounds(346, 272, 160, 25);
		transactionPanel.add(btnNewButton);

		JLabel lblUnMessagefacultatif = new JLabel("Un message (facultatif)");
		lblUnMessagefacultatif.setBounds(38, 352, 133, 16);
		transactionPanel.add(lblUnMessagefacultatif);

		JTextPane message = new JTextPane();
		message.setBounds(189, 376, 317, 120);
		transactionPanel.add(message);

		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// add popup message here
				mainFrame.setPanel(menuPanel());
			}
		});
		btnValider.setBounds(317, 511, 139, 25);
		transactionPanel.add(btnValider);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(120, 511, 139, 25);
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// add Popup message here
				mainFrame.setPanel(menuPanel());
			}
		});
		transactionPanel.add(btnAnnuler);

		return transactionPanel;
	}

}
