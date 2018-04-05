package vue;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import controller.ControleurInfoClient;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;

public class PanelInformationClient extends JPanel {

	private ControleurInfoClient infoClients = new ControleurInfoClient();
//	private ArrayList<String> clientData = new ArrayList<String>();
	
	/**
	 * Create the panel.
	 */
	public PanelInformationClient() {
		// must make the client data dynamic !!!!!!!!
		infoClients.getDataClient(1);
		
		setBorder(new TitledBorder(null, "Informations client", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.setSize(550, 550);
		setLayout(null);
		
		JLabel lblPrenom = new JLabel("Prenom :" , SwingConstants.RIGHT);
		lblPrenom.setBounds(189, 83, 56, 16);
		add(lblPrenom);
		
		JLabel lblAbdoul = new JLabel("Abdoul");
		lblAbdoul.setBounds(276, 83, 213, 16);
		add(lblAbdoul);
		
		JLabel lblNom = new JLabel("Nom :" , SwingConstants.RIGHT);
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNom.setBounds(189, 127, 56, 16);
		add(lblNom);
		
		JLabel lblMohamed = new JLabel("Mohamed");
		lblMohamed.setBounds(276, 127, 213, 16);
		add(lblMohamed);
		
		JLabel lblDateDeNaissance = new JLabel("Date de naissance :" , SwingConstants.RIGHT);
		lblDateDeNaissance.setBounds(91, 164, 154, 16);
		add(lblDateDeNaissance);
		
		JLabel label_1 = new JLabel("09/09/09");
		label_1.setBounds(276, 164, 213, 16);
		add(label_1);
		
		JLabel lblNewLabel = new JLabel("Email :" , SwingConstants.RIGHT);
		lblNewLabel.setBounds(189, 206, 56, 16);
		add(lblNewLabel);
		
		JLabel lblAbdoulmailcom = new JLabel("abdoul@mail.com");
		lblAbdoulmailcom.setBounds(276, 206, 213, 16);
		add(lblAbdoulmailcom);
		
		JLabel lblTelephone = new JLabel("Telephone :" , SwingConstants.RIGHT);
		lblTelephone.setBounds(135, 249, 110, 16);
		add(lblTelephone);
		
		JLabel label = new JLabel("0909090909");
		label.setBounds(276, 249, 213, 16);
		add(label);
		
		JLabel lblAdresse = new JLabel("Adresse :" , SwingConstants.RIGHT);
		lblAdresse.setBounds(189, 294, 56, 16);
		add(lblAdresse);
		
		JLabel lblBoefoezkjflKzqnjae = new JLabel("154 boefoezkjfl kzqnjae");
		lblBoefoezkjflKzqnjae.setBounds(276, 294, 213, 16);
		add(lblBoefoezkjflKzqnjae);
		
		JLabel lblVille = new JLabel("Ville :" , SwingConstants.RIGHT);
		lblVille.setBounds(189, 340, 56, 16);
		add(lblVille);
		
		JLabel lblRouen = new JLabel("76100 Rouen");
		lblRouen.setBounds(276, 340, 213, 16);
		add(lblRouen);
		
		JLabel lblPays = new JLabel("Pays :" , SwingConstants.RIGHT);
		lblPays.setBounds(189, 384, 56, 16);
		add(lblPays);
		
		JLabel lblFrance = new JLabel("France");
		lblFrance.setBounds(276, 384, 56, 16);
		add(lblFrance);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(148, 462, 97, 25);
		add(btnRetour);
		
		JButton btnEditerInformations = new JButton("Consulter les comptes");
		btnEditerInformations.setBounds(276, 462, 179, 25);
		add(btnEditerInformations);
	}

}


//JLabel lblAdresse = new JLabel("Adresse:" , SwingConstants.RIGHT);
//lblAdresse.setBounds(224, 235, 56, 16);
//add(lblAdresse);
//
//JLabel lblLqjdnckjaebaevbaennaelfknalfnafakeclkf = new JLabel("153 boulevard de l'europe");
//lblLqjdnckjaebaevbaennaelfknalfnafakeclkf.setBounds(311, 235, 261, 16);
//add(lblLqjdnckjaebaevbaennaelfknalfnafakeclkf);