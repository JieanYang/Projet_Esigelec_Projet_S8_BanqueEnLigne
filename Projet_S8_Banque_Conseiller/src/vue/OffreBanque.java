package vue;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controleur.ControleurOffre;
import controleur.MainControleur;

public class OffreBanque extends JPanel {

	private static final long serialVersionUID = 1L;
	private ControleurOffre cOffre = new ControleurOffre();
	private Component frame;

	public OffreBanque() {
		this.setSize(600, 600);
		this.setLayout(null);

		JLabel lbltitre = new JLabel("Titre :");
		lbltitre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbltitre.setBounds(268, 81, 64, 32);
		add(lbltitre);

		JTextField tFieldtitre = new JTextField();
		tFieldtitre.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tFieldtitre.setBounds(165, 126, 270, 32);
		add(tFieldtitre);
		tFieldtitre.setColumns(10);

		JLabel lbldesc = new JLabel("Description :");
		lbldesc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbldesc.setBounds(243, 190, 113, 32);
		add(lbldesc);

		JTextArea tFielddesc = new JTextArea(5, 30);
		tFielddesc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tFielddesc.setBounds(82, 235, 436, 151);
		add(tFielddesc);
		tFielddesc.setColumns(10);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAjouter.setBounds(348, 435, 170, 32);
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cOffre.addOffre(tFieldtitre.getText(), tFielddesc.getText());
				JOptionPane.showMessageDialog(frame, "Offre ajouté");
				MainControleur.menuPanel();
			}
		});
		add(btnAjouter);

		JButton btnRetour = new JButton("Retour");
		btnRetour.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRetour.setBounds(82, 435, 141, 32);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainControleur.menuPanel();
			}
		});
		add(btnRetour);
	}

}
