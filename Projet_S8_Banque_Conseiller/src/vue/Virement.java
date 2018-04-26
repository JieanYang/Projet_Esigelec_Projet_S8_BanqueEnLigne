package vue;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import controleur.MainControleur;
import controleur.ControleurVirement;
import dto.Compte;
import dto.User;

public class Virement extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ControleurVirement cVirement = new ControleurVirement();
	private Vector<Compte> listCompte = new Vector<Compte>();
	
	Component frame;
	
	public Vector<Compte> getClientListCompte(int clientID){
		return cVirement.getClientAccount(clientID);
	}

	/**
	 * Create the panel.
	 */
	public Virement(User client) {
		this.setSize(600, 600);
		this.setBorder(new TitledBorder(null, "Virement", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.setLayout(null);

		JLabel lblCompteCrditer = new JLabel("Compte à créditer");
		lblCompteCrditer.setBounds(38, 93, 133, 16);
		this.add(lblCompteCrditer);
		
		listCompte = this.getClientListCompte(client.getId_user());
		DefaultComboBoxModel<String> cbm = new DefaultComboBoxModel<String>();
		for(Compte unCompte : listCompte) {
			cbm.addElement(unCompte.getId_compte()+" "+unCompte.getCategorie_compte()+" "+unCompte.getEtat()+" "+unCompte.getSolde()+"€");
		}
		JComboBox<String> cBoxCompteCrediteur = new JComboBox<String>(cbm);
		cBoxCompteCrediteur.setBounds(192, 90, 344, 22);
		this.add(cBoxCompteCrediteur);

		JLabel lblCompteDbiter = new JLabel("Numéro de chèque");
		lblCompteDbiter.setBounds(38, 166, 133, 16);
		this.add(lblCompteDbiter);

		JTextField tFieldCompteDebiter = new JTextField();
		tFieldCompteDebiter.setBounds(282, 163, 254, 22);
		this.add(tFieldCompteDebiter);

		JLabel lblMontantDuVirement = new JLabel("Montant du virement en Euros");
		lblMontantDuVirement.setBounds(38, 217, 172, 16);
		this.add(lblMontantDuVirement);

		JTextField tFieldMotant = new JTextField();
		tFieldMotant.setBounds(367, 214, 139, 22);
		this.add(tFieldMotant);
		tFieldMotant.setColumns(10);

		JLabel euro = new JLabel("€");
		euro.setBounds(518, 217, 18, 16);
		this.add(euro);

		JLabel lblUnMessagefacultatif = new JLabel("Un message (facultatif)");
		lblUnMessagefacultatif.setBounds(38, 321, 133, 16);
		this.add(lblUnMessagefacultatif);

		JTextPane message = new JTextPane();
		message.setBounds(189, 321, 347, 120);
		this.add(message);

		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cVirement.checkInput(tFieldCompteDebiter.getText(), tFieldMotant.getText())) {
					cVirement.addTransac(Integer.parseInt(tFieldCompteDebiter.getText()), listCompte.get(cBoxCompteCrediteur.getSelectedIndex()).getId_compte(), Float.parseFloat(tFieldMotant.getText()), message.getText());
					JOptionPane.showMessageDialog(frame,"Virement effectué");
					MainControleur.menuPanel();
				}else {
					JOptionPane.showMessageDialog(frame,cVirement.getMessage());
				}
			}
		});
		btnValider.setBounds(317, 478, 139, 25);
		this.add(btnValider);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(120, 478, 139, 25);
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame,"Transaction annulé","Inane error",JOptionPane.ERROR_MESSAGE);
				MainControleur.listeClientPanel();
			}
		});
		this.add(btnAnnuler);
	}

}
