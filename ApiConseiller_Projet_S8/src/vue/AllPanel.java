package vue;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

import javax.swing.JTextArea;

import javax.swing.JTable;


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
import javax.swing.table.DefaultTableModel;

import controller.ControleurInfoClient;
import controller.ControleurListeClient;
import controller.ControleurLogin;
import controller.ControleurMenu;
import dao.OffresDAO;
import dto.Offres;
import dto.User;

public class AllPanel {

	// the controlers
	ControleurLogin cLogin = new ControleurLogin();
	ControleurMenu cMenu = new ControleurMenu();
	ControleurListeClient cListeClient = new ControleurListeClient();

	
	//DAO's
	OffresDAO offreDAO = new OffresDAO();

	ControleurInfoClient cInfoClient = new ControleurInfoClient();


	// the main frame
	protected MainFrame mainFrame;

	// the panels
	protected JPanel loginPanel = new JPanel();
	protected JPanel offrePanel = new JPanel();
	protected JPanel menuPanel = new JPanel();
	protected JPanel listeClientPanel = new JPanel();
	protected JPanel informationsClientPanel = new JPanel();
	protected JPanel informationsCompteClientPanel = new JPanel();
	protected JPanel transactionPanel = new JPanel();

	// Conseiller
	private User conseiller = new User();
	
	//Offre
	private Offres offre = new Offres();

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

//				if (cLogin.checkCredentials(tFieldEmail.getText(), new String(tFieldPassword.getPassword()))) {// appel la fonction checkCredentials pour v閞ifier le User dans la BDD
					conseiller = cMenu.getConseillerInfo(tFieldEmail.getText());//Si le User existe, recup鑢e les informations correspondantes en fonction de l'email utilis�
					mainFrame.setPanel(menuPanel());//appelle directement la m閠hode menuPanel()
//				}

			}
		});
		this.loginPanel.add(btnConnecxion);//Ajoute le bouton au panel

		return this.loginPanel; //Return
	}

	public JPanel menuPanel() {
		mainFrame.setTitle("Menu");

		menuPanel.setLayout(null);

		JLabel lblConnecteSous = new JLabel("Connect� sous :");
		lblConnecteSous.setBounds(74, 67, 100, 16);
		menuPanel.add(lblConnecteSous);


		JLabel lblNomConseiller = new JLabel(conseiller.getNom()+" "+conseiller.getPrenom());//Recup鑢e le nom et le pr閚om de via l'objet Conseiller

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

		
		JButton btnAfficherMessage = new JButton("Voir les messages client");
		btnAfficherMessage.setBounds(177, 235, 246, 25);
		// btnAfficherMessage.addActionListener(new ActionListener() {
		//
		// public void actionPerformed(ActionEvent e) {
		// mainFrame.setPanel(messagePanel());
		// }
		// });
		menuPanel.add(btnAfficherMessage);

		/*
		 * BUTTON AJOUTER OFFRES
		 */
		
		JButton btnAjouterOffre = new JButton("Ajouter les offres");
		btnAjouterOffre.setBounds(177, 300, 246, 25);
		btnAjouterOffre.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				mainFrame.setPanel(offrePanel());// redirige sur offre panel
			}
		});
		menuPanel.add(btnAjouterOffre);// ajouter le bouton cr閑r au menu

		return menuPanel;// return l'ensemble du menu
	}
	
	
	
	/*
	 * OFFRES
	 */
	public JPanel offrePanel() {

		mainFrame.setTitle("Offres");

		this.offrePanel.setLayout(null);

		JLabel lbltitre = new JLabel("Titre :");// ecrit le label titre
		lbltitre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbltitre.setBounds(185, 172, 116, 32);
		offrePanel.add(lbltitre);

		JTextField tFieldtitre = new JTextField();// ZONE DE TEXT
		tFieldtitre.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tFieldtitre.setBounds(185, 217, 270, 32);
		offrePanel.add(tFieldtitre);
		tFieldtitre.setColumns(10);

		JLabel lbldesc = new JLabel("Description :");
		lbldesc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbldesc.setBounds(185, 281, 170, 32);
		offrePanel.add(lbldesc);

		JTextArea tFielddesc = new JTextArea(2, 10);
		tFielddesc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tFielddesc.setBounds(185, 326, 232, 32);
		offrePanel.add(tFielddesc);
		tFielddesc.setColumns(10);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAjouter.setBounds(216, 392, 170, 32);
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (offreDAO.addOffre(tFieldtitre.getText(), tFielddesc.getText())) {// appel la fonction addoffres pour ajouter les offres dans la BDD, envoi V si ajouter et F si c'est pas le cas
					//offre = cMenu.getConseillerInfo(tFieldEmail.getText());//Si le User existe, recup�re les informations correspondantes en fonction de l'email utilis�
					mainFrame.setPanel(menuPanel());//appelle directement la m�thode loginPanel() apr�s qu'on ai ajouter dans la BDD
				}
			}
		});
		this.offrePanel.add(btnAjouter);//Ajoute le bouton au panel

		return this.offrePanel; //Return
	}

	public JPanel listeClientPanel() {

		mainFrame.setTitle("Liste des Clients");

		listeClientPanel.setLayout(null);

		Vector<User> userList = cListeClient.getListClient();

		String title[] = { "ID", "Nom", "Prenom", "Email", "NumTel" };
		Object[][] data = {};
 
		DefaultTableModel model = new DefaultTableModel(data, title);
		JTable table = new JTable(model); 
		for (User aUser : userList) {
			model.addRow(new Object[]{aUser.getId_user(), aUser.getNom(), aUser.getPrenom(), aUser.getEmail(), aUser.getTelephone()});
		}

		JScrollPane scrollPane = new JScrollPane(table);
		listeClientPanel.add(scrollPane);
		scrollPane.setBounds(71, 76, 457, 415);

		JButton btnAfficherLesInformations = new JButton("Afficher les informations");
		btnAfficherLesInformations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(userList.get(table.getSelectedRow()).getId_user());
				mainFrame.setPanel(informationsClient(userList.get(table.getSelectedRow()).getId_user()));
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

	public JPanel informationsClient(int clientID) {

		mainFrame.setTitle("Informations Client");
		
		User client = new User();
//		client = cInfoClient.getDataClient(clientID);
		System.out.println(client.getNom());

		informationsClientPanel.setBorder(
				new TitledBorder(null, "Informations client", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		informationsClientPanel.setLayout(null);

		JLabel lblPrenom = new JLabel("Prenom :", SwingConstants.RIGHT);
		lblPrenom.setBounds(204, 83, 56, 16);
		informationsClientPanel.add(lblPrenom);

		JLabel lblClientPrenom = new JLabel(client.getPrenom());
		lblClientPrenom.setBounds(291, 83, 213, 16);
		informationsClientPanel.add(lblClientPrenom);

		JLabel lblNom = new JLabel("Nom :", SwingConstants.RIGHT);
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNom.setBounds(204, 127, 56, 16);
		informationsClientPanel.add(lblNom);

		JLabel lblClientNom = new JLabel(client.getNom());
		lblClientNom.setBounds(291, 127, 213, 16);
		informationsClientPanel.add(lblClientNom);

		JLabel lblDateDeNaissance = new JLabel("Date de naissance :", SwingConstants.RIGHT);
		lblDateDeNaissance.setBounds(106, 164, 154, 16);
		informationsClientPanel.add(lblDateDeNaissance);

		JLabel lblDateNaissanceClient = new JLabel(client.getStringNaissance().toString());
		lblDateNaissanceClient.setBounds(291, 164, 213, 16);
		informationsClientPanel.add(lblDateNaissanceClient);

		JLabel lblNewLabel = new JLabel("Email :", SwingConstants.RIGHT);
		lblNewLabel.setBounds(204, 206, 56, 16);
		informationsClientPanel.add(lblNewLabel);

		JLabel lblEmailClient = new JLabel(client.getEmail());
		lblEmailClient.setBounds(291, 206, 213, 16);
		informationsClientPanel.add(lblEmailClient);

		JLabel lblTelephone = new JLabel("Telephone :", SwingConstants.RIGHT);
		lblTelephone.setBounds(150, 249, 110, 16);
		informationsClientPanel.add(lblTelephone);

		JLabel lblNumTelClient = new JLabel(client.getTelephone());
		lblNumTelClient.setBounds(291, 249, 213, 16);
		informationsClientPanel.add(lblNumTelClient);

		JLabel lblAdresse = new JLabel("Adresse :", SwingConstants.RIGHT);
		lblAdresse.setBounds(204, 294, 56, 16);
		informationsClientPanel.add(lblAdresse);

		JLabel lblAdresseClient = new JLabel(client.getAdresse());
		lblAdresseClient.setBounds(291, 294, 213, 16);
		informationsClientPanel.add(lblAdresseClient);

		JLabel lblVille = new JLabel("Ville :", SwingConstants.RIGHT);
		lblVille.setBounds(204, 340, 56, 16);
		informationsClientPanel.add(lblVille);

		JLabel lblVilleClient = new JLabel(client.getVille());
		lblVilleClient.setBounds(291, 340, 213, 16);
		informationsClientPanel.add(lblVilleClient);

		JLabel lblPays = new JLabel("Pays :", SwingConstants.RIGHT);
		lblPays.setBounds(204, 384, 56, 16);
		informationsClientPanel.add(lblPays);

		JLabel lblPaysClient = new JLabel(client.getPays());
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

		JLabel lblSlectionnezLeCompte = new JLabel("S閘ectionnez le compte");
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
//				mainFrame.setPanel(informationsClient());
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

		mainFrame.setTitle("R閍liser une transaction");

		transactionPanel
				.setBorder(new TitledBorder(null, "Virement", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		transactionPanel.setLayout(null);

		JLabel lblCompteCrditer = new JLabel("Compte � cr閐iter");
		lblCompteCrditer.setBounds(38, 93, 99, 16);
		transactionPanel.add(lblCompteCrditer);

		JComboBox cBoxCompteCrediteur = new JComboBox();
		cBoxCompteCrediteur.setBounds(162, 90, 344, 22);
		transactionPanel.add(cBoxCompteCrediteur);

		JLabel lblAvoirDisponible = new JLabel("Avoir disponible : 18 8867 �");
		lblAvoirDisponible.setBounds(401, 125, 160, 16);
		transactionPanel.add(lblAvoirDisponible);

		JLabel lblCompteDbiter = new JLabel("Compte � d閎iter");
		lblCompteDbiter.setBounds(38, 166, 103, 16);
		transactionPanel.add(lblCompteDbiter);

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

		JLabel euro = new JLabel("�");
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
