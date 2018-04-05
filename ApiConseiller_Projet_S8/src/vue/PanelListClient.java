package vue;

import javax.swing.JPanel;
import javax.swing.JList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PanelListClient extends JPanel implements ActionListener{
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PanelListClient() {
		this.setSize(550,550);
		setLayout(null);
		
		JList list = new JList();
		list.setBorder(BorderFactory.createTitledBorder("Liste des clients"));
		list.setBounds(49, 76, 457, 415);
		add(list);
		
		JButton btnAfficherLesInformations = new JButton("Afficher les informations");
		btnAfficherLesInformations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAfficherLesInformations.setBounds(158, 504, 205, 25);
		add(btnAfficherLesInformations);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(49, 504, 97, 25);
		add(btnRetour);
		
		JButton btnNewButton = new JButton("Faire virement");
		btnNewButton.setBounds(375, 504, 131, 25);
		add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(262, 49, 116, 22);
		add(textField);
		textField.setColumns(10);
		
		JButton btnRechercher = new JButton("Rechercher ?");
		btnRechercher.setBounds(390, 48, 116, 25);
		add(btnRechercher);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
