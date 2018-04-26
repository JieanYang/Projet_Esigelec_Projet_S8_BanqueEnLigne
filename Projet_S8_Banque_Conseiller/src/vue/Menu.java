package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.MainControleur;

public class Menu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static MainFrame mainFrame;

	/**
	 * Create the panel.
	 */
	public Menu() {

		this.setSize(600, 600);
		this.setLayout(null);

		JLabel lblConnecteSous = new JLabel("Connecté sous :");
		lblConnecteSous.setBounds(74, 67, 100, 16);
		this.add(lblConnecteSous);

		JLabel lblNomConseiller = new JLabel(
				MainControleur.conseiller.getNom() + " " + MainControleur.conseiller.getPrenom());
		lblNomConseiller.setBounds(186, 67, 225, 16);
		this.add(lblNomConseiller);

		JButton btnAfficherListeClient = new JButton("Afficher la liste des clients");
		btnAfficherListeClient.setBounds(177, 169, 246, 25);
		btnAfficherListeClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainControleur.listeClientPanel();
			}
		});
		this.add(btnAfficherListeClient);

		JButton btnAfficherMessage = new JButton("Voir les messages clients");
		btnAfficherMessage.setBounds(177, 235, 246, 25);
		btnAfficherMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainControleur.listeMessagePanel();
			}
		});
		this.add(btnAfficherMessage);

		JButton btnAjouterOffre = new JButton("Ajouter des offres");
		btnAjouterOffre.setBounds(177, 300, 246, 25);
		btnAjouterOffre.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				MainControleur.offreBanquePanel();
			}
		});
		this.add(btnAjouterOffre);

	}

}
