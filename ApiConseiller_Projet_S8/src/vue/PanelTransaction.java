package vue;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class PanelTransaction extends JPanel {
	private JTextField textField;

	
	public PanelTransaction() {
		setBorder(new TitledBorder(null, "Virement", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.setSize(600, 600);
		setLayout(null);
		
		JLabel lblCompteDbiter = new JLabel("Compte à débiter");
		lblCompteDbiter.setBounds(38, 93, 99, 16);
		add(lblCompteDbiter);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(162, 90, 344, 22);
		add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Avoir disponible : 18 8867 €");
		lblNewLabel.setBounds(401, 125, 160, 16);
		add(lblNewLabel);
		
		JLabel lblCompteCrditer = new JLabel("Compte à créditer");
		lblCompteCrditer.setBounds(38, 166, 103, 16);
		add(lblCompteCrditer);
		
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(252, 163, 254, 22);
		add(textField_1);
		
		JLabel lblMontantDuVirement = new JLabel("Montant du virement en Euros");
		lblMontantDuVirement.setBounds(38, 217, 172, 16);
		add(lblMontantDuVirement);
		
		textField = new JTextField();
		textField.setBounds(367, 214, 139, 22);
		add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u20AC");
		label.setBounds(509, 217, 27, 16);
		add(label);
		
		JLabel lblDateDeVotre = new JLabel("Date de votre virement");
		lblDateDeVotre.setBounds(38, 311, 131, 16);
		add(lblDateDeVotre);
		
		JButton btnNewButton = new JButton("Add datepicker here");
		btnNewButton.setBounds(346, 307, 160, 25);
		add(btnNewButton);
		
		JLabel lblUnMessagefacultatif = new JLabel("Un message (facultatif)");
		lblUnMessagefacultatif.setBounds(38, 387, 133, 16);
		add(lblUnMessagefacultatif);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(189, 386, 317, 120);
		add(textPane);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnValider.setBounds(317, 546, 139, 25);
		add(btnValider);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.setBounds(120, 546, 139, 25);
		add(btnNewButton_1);

	}

}
