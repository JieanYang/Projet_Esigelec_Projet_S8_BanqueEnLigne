package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.ControleurListeClient;
import controller.MainControleur;
import dto.User;

public class ListeClient extends JPanel {
	
	private ControleurListeClient cListeClient = new ControleurListeClient();
	private Vector<User> userList = new Vector<>();

	/**
	 * Create the panel.
	 */
	public ListeClient() {

		this.setSize(600, 600);
		this.setLayout(null);

		userList = cListeClient.getListClient();

		String title[] = { "ID", "Nom", "Prenom", "Email", "NumTel" };
		Object[][] data = {};
 
		DefaultTableModel model = new DefaultTableModel(data, title);
		JTable table = new JTable(model); 
		for (User aUser : userList) {
			model.addRow(new Object[]{aUser.getId_user(), aUser.getNom(), aUser.getPrenom(), aUser.getEmail(), aUser.getTelephone()});
		}

		JScrollPane scrollPane = new JScrollPane(table);
		this.add(scrollPane);
		scrollPane.setBounds(71, 76, 457, 415);

		JButton btnAfficherLesInformations = new JButton("Afficher les informations");
		btnAfficherLesInformations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainControleur.informationsClientPanel(userList.get(table.getSelectedRow()).getId_user());
			}
		});
		btnAfficherLesInformations.setBounds(180, 504, 205, 25);
		this.add(btnAfficherLesInformations);

		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(71, 504, 97, 25);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainControleur.menuPanel();
			}
		});
		this.add(btnRetour);

		JButton btnVirement = new JButton("Faire virement");
		btnVirement.setBounds(397, 504, 131, 25);
		btnVirement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainControleur.virementPanel(userList.get(table.getSelectedRow()).getId_user());
			}
		});
		this.add(btnVirement);
	}

}
