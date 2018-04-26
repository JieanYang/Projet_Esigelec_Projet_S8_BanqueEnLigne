package vue;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controleur.ControleurInfoCompteClient;
import dto.Compte;
import dto.Transaction;
import dto.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class InformationsCompteClient extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private static ControleurInfoCompteClient cInfoCompteClient = new ControleurInfoCompteClient();
	private Compte unCompte;
//	private Vector<Transaction> transacList = new Vector<>(InformationsCompteClient.getListOfTransac(unCompte.getId_compte()));
	
	public static Vector<Transaction> getListOfTransac(int compteID) {
		return cInfoCompteClient.getListTransac(compteID);
	}

	/**
	 * Create the panel.
	 */
	public InformationsCompteClient(Compte compte) {
		this.setSize(600, 600);
		setLayout(null);
		
		this.unCompte = compte;
		Vector<Transaction> transacList = new Vector<>(InformationsCompteClient.getListOfTransac(unCompte.getId_compte()));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Sélectionnez un compte", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(27, 56, 546, 79);
		add(panel);
		panel.setLayout(null);
		
		JButton btnCompteCourant = new JButton("Compte courant");
		btnCompteCourant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCompteCourant.setBounds(54, 30, 138, 25);
		panel.add(btnCompteCourant);
		
		JButton btnCompteEpargne = new JButton("Compte epargne");
		btnCompteEpargne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCompteEpargne.setBounds(204, 30, 138, 25);
		panel.add(btnCompteEpargne);
		
		JButton btnCompteTitre = new JButton("Compte titre");
		btnCompteTitre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCompteTitre.setBounds(354, 30, 138, 25);
		panel.add(btnCompteTitre);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Informations du compte", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(27, 160, 546, 62);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEtat = new JLabel("Etat :");
		lblEtat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEtat.setBounds(24, 33, 47, 16);
		panel_1.add(lblEtat);
		
		JLabel lblActif = new JLabel(compte.getEtat());
		lblActif.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblActif.setBounds(72, 33, 47, 16);
		panel_1.add(lblActif);
		
		JLabel lblSolde = new JLabel("Solde :");
		lblSolde.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSolde.setBounds(150, 33, 47, 16);
		panel_1.add(lblSolde);
		
		JLabel lblMontant = new JLabel(String.valueOf(compte.getSolde()));
		lblMontant.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMontant.setBounds(201, 33, 94, 16);
		panel_1.add(lblMontant);
		
		JLabel lblDateDeCration = new JLabel("Date de création :");
		lblDateDeCration.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDateDeCration.setBounds(320, 33, 130, 16);
		panel_1.add(lblDateDeCration);
		
		JLabel lblDate = new JLabel(String.valueOf(compte.getDate_create()));
		lblDate.setBounds(450, 33, 84, 16);
		panel_1.add(lblDate);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		String title[] = { "ID Transac", "Type", "Emetteur", "Recepteur", "Date", "Description" };
		Object[][] data = {};
 
		DefaultTableModel model = new DefaultTableModel(data, title);
		JTable table = new JTable(model); 
//		for (User aUser : userList) {
//			model.addRow(new Object[]{aUser.getId_user(), aUser.getNom(), aUser.getPrenom(), aUser.getEmail(), aUser.getTelephone()});
//		}

		JScrollPane scrollPane = new JScrollPane(table);
		this.add(scrollPane);
		scrollPane.setBounds(27, 235, 546, 265);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRetour.setBounds(78, 513, 97, 25);
		add(btnRetour);
		
	}
}
