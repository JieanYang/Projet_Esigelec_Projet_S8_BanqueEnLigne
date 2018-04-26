package vue;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import controleur.ControleurReponseMessage;
import controleur.MainControleur;
import dto.Message;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ReponseMessage extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ControleurReponseMessage cReponseMessage = new ControleurReponseMessage();
	private Component frame;

	/**
	 * Create the panel.
	 */
	public ReponseMessage(Message message) {
		this.setSize(600, 600);
		setLayout(null);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(103, 34, 56, 16);
		add(lblNom);
		
		JLabel lblNomusr = new JLabel(message.getNom());
		lblNomusr.setBounds(189, 34, 120, 16);
		add(lblNomusr);
		
		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setBounds(332, 34, 56, 16);
		add(lblPrenom);
		
		JLabel lblPrenomusr = new JLabel(message.getPrenom());
		lblPrenomusr.setBounds(410, 34, 120, 16);
		add(lblPrenomusr);
		
		JLabel lblTlphone = new JLabel("Téléphone :");
		lblTlphone.setBounds(103, 83, 82, 16);
		add(lblTlphone);
		
		JLabel lblPhoneusr = new JLabel(message.getNumphone());
		lblPhoneusr.setBounds(189, 83, 120, 16);
		add(lblPhoneusr);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(332, 83, 56, 16);
		add(lblEmail);
		
		JLabel lblEmailusr = new JLabel(message.getEmail());
		lblEmailusr.setBounds(410, 83, 120, 16);
		add(lblEmailusr);
		
		JLabel lblIdMessage = new JLabel("Id Message :");
		lblIdMessage.setBounds(103, 138, 82, 16);
		add(lblIdMessage);
		
		JLabel lblIdmessage = new JLabel(String.valueOf(message.getId_message()));
		lblIdmessage.setBounds(189, 138, 82, 16);
		add(lblIdmessage);
		
		JLabel lblMessage = new JLabel("Message :");
		lblMessage.setBounds(103, 194, 82, 16);
		add(lblMessage);

		JLabel lblMessageClient = new JLabel(message.getProblem());
		lblMessageClient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMessageClient.setBounds(56, 223, 487, 36);
		add(lblMessageClient);
		
		JLabel lblRpondre = new JLabel("Répondre :");
		lblRpondre.setBounds(103, 278, 103, 16);
		add(lblRpondre);
		
		JTextArea textFieldMessage = new JTextArea(5, 30);
		textFieldMessage.setBounds(46,307,500,129);
		add(textFieldMessage);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(103, 466, 97, 25);
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainControleur.listeMessagePanel();
			}
		});
		add(btnAnnuler);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(386, 466, 97, 25);
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cReponseMessage.envoyerReponse(message.getId_message(), textFieldMessage.getText());
				JOptionPane.showMessageDialog(frame,"Message Envoyé");
				MainControleur.listeMessagePanel();
			}
		});
		add(btnValider);

	}
}
