package vue;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controleur.ControleurListeMessage;
import controleur.MainControleur;
import dto.Message;

import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class ListeMessage extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private static ControleurListeMessage cListeMessage = new ControleurListeMessage();
	private Vector<Message> messageList = new Vector<>(ListeMessage.getListOfMessage());
	
	public static Vector<Message> getListOfMessage() {
		return cListeMessage.getListMessage();
	}

	/**
	 * Create the panel.
	 */
	public ListeMessage() {
		this.setSize(600, 600);
		this.setLayout(null);
		
		String title[] = { "ID", "Nom", "Prenom", "Message" };
		Object[][] data = {};
 
		DefaultTableModel model = new DefaultTableModel(data, title);
		setLayout(null);
		JTable table = new JTable(model); 
		for (Message aMessage : messageList) {
			model.addRow(new Object[]{aMessage.getId_message(), aMessage.getNom(), aMessage.getPrenom(), aMessage.getProblem()});
		}

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(79, 33, 442, 441);
		this.add(scrollPane);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainControleur.menuPanel();
			}
		});
		btnRetour.setBounds(79, 502, 214, 25);
		add(btnRetour);
		
		JButton btnRepondre = new JButton("Répondre");
		btnRepondre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainControleur.reponseMessagePanel(messageList.get(table.getSelectedRow()).getId_message());
			}
		});
		btnRepondre.setBounds(305, 502, 214, 25);
		add(btnRepondre);

	}
}