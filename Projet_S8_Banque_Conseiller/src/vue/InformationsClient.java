package vue;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import controleur.MainControleur;
import dto.User;

public class InformationsClient extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public InformationsClient(User client) {

		this.setSize(600, 600);
		this.setBorder(
				new TitledBorder(null, "Informations client", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.setLayout(null);

		JLabel lblPrenom = new JLabel("Prenom :", SwingConstants.RIGHT);
		lblPrenom.setBounds(204, 83, 56, 16);
		this.add(lblPrenom);

		JLabel lblClientPrenom = new JLabel(client.getPrenom());
		lblClientPrenom.setBounds(291, 83, 213, 16);
		this.add(lblClientPrenom);

		JLabel lblNom = new JLabel("Nom :", SwingConstants.RIGHT);
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNom.setBounds(204, 127, 56, 16);
		this.add(lblNom);

		JLabel lblClientNom = new JLabel(client.getNom());
		lblClientNom.setBounds(291, 127, 213, 16);
		this.add(lblClientNom);

		JLabel lblDateDeNaissance = new JLabel("Date de naissance :", SwingConstants.RIGHT);
		lblDateDeNaissance.setBounds(106, 164, 154, 16);
		this.add(lblDateDeNaissance);

		JLabel lblDateNaissanceClient = new JLabel(client.getStringNaissance());
		lblDateNaissanceClient.setBounds(291, 164, 213, 16);
		this.add(lblDateNaissanceClient);

		JLabel lblNewLabel = new JLabel("Email :", SwingConstants.RIGHT);
		lblNewLabel.setBounds(204, 206, 56, 16);
		this.add(lblNewLabel);

		JLabel lblEmailClient = new JLabel(client.getEmail());
		lblEmailClient.setBounds(291, 206, 213, 16);
		this.add(lblEmailClient);

		JLabel lblTelephone = new JLabel("Telephone :", SwingConstants.RIGHT);
		lblTelephone.setBounds(150, 249, 110, 16);
		this.add(lblTelephone);

		JLabel lblNumTelClient = new JLabel(client.getTelephone());
		lblNumTelClient.setBounds(291, 249, 213, 16);
		this.add(lblNumTelClient);

		JLabel lblAdresse = new JLabel("Adresse :", SwingConstants.RIGHT);
		lblAdresse.setBounds(204, 294, 56, 16);
		this.add(lblAdresse);

		JLabel lblAdresseClient = new JLabel(client.getAdresse());
		lblAdresseClient.setBounds(291, 294, 213, 16);
		this.add(lblAdresseClient);

		JLabel lblVille = new JLabel("Ville :", SwingConstants.RIGHT);
		lblVille.setBounds(204, 340, 56, 16);
		this.add(lblVille);

		JLabel lblVilleClient = new JLabel(client.getVille());
		lblVilleClient.setBounds(291, 340, 213, 16);
		this.add(lblVilleClient);

		JLabel lblPays = new JLabel("Pays :", SwingConstants.RIGHT);
		lblPays.setBounds(204, 384, 56, 16);
		this.add(lblPays);

		JLabel lblPaysClient = new JLabel(client.getPays());
		lblPaysClient.setBounds(291, 384, 56, 16);
		this.add(lblPaysClient);

		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(106, 462, 97, 25);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainControleur.listeClientPanel();
			}
		});
		this.add(btnRetour);

		JButton btnEditerInformations = new JButton("Consulter les comptes");
		btnEditerInformations.setBounds(325, 462, 179, 25);
		btnEditerInformations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				mainFrame.setPanel(informationsCompteClientPanel());
			}
		});
		this.add(btnEditerInformations);
	}

}
