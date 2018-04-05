package vue;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;

public class PanelMenu extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelMenu() {
		this.setSize(550, 550);
		setLayout(null);
		
		JLabel lblBienvenue = new JLabel("Connect\u00E9 sous :");
		lblBienvenue.setBounds(74, 67, 100, 16);
		add(lblBienvenue);
		
		JLabel lblNomConseill = new JLabel("Nom Conseill\u00E9");
		lblNomConseill.setBounds(186, 67, 225, 16);
		add(lblNomConseill);
		
		JButton btnNewButton = new JButton("Afficher la liste des clients");
		btnNewButton.setBounds(177, 169, 246, 25);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voir les messages clients");
		btnNewButton_1.setBounds(177, 235, 246, 25);
		add(btnNewButton_1);
		

	}
}
