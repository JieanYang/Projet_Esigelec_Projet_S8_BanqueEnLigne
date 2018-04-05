package vue;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JList;

public class PanelInformationsCompteClients extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelInformationsCompteClients() {
		setBorder(new TitledBorder(null, "Informations des compte Client", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.setSize(550, 550);
		setLayout(null);
		
		JLabel lblSlectionnezLeCompte = new JLabel("S\u00E9lectionnez le compte");
		lblSlectionnezLeCompte.setBounds(66, 56, 199, 16);
		add(lblSlectionnezLeCompte);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(82, 85, 385, 22);
		add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informations du compte", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(34, 139, 482, 147);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JList list_1 = new JList();
		panel.add(list_1, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Historique du compte", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(34, 326, 482, 147);
		add(panel_1);
		panel_1.setLayout(null);
		
		JList list = new JList();
		list.setBounds(6, 18, 470, 122);
		panel_1.add(list);
		
		JButton btnInformationsClient = new JButton("Informations Client");
		btnInformationsClient.setBounds(309, 486, 148, 25);
		add(btnInformationsClient);
		
		JButton btnMenu = new JButton("Retour Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnMenu.setBounds(102, 486, 132, 25);
		add(btnMenu);

	}
}
