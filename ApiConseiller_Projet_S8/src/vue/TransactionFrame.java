package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class TransactionFrame extends JPanel{
	
	// all panel
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	JPanel panel6 = new JPanel();
	JPanel panel7 = new JPanel();
	
	// panel1 content
	JLabel compteDebiter = new JLabel("Compte à débiter");
	JComboBox idCompteDebiter = new JComboBox(); // must get a list of all client account
	JLabel avoirDisponible = new JLabel("//must get compte solde here");
	JLabel compteCredite = new JLabel("Compte à créditer");
	JTextField idCompteCrediter = new JTextField(); // input for the other account ID
	
	// panel2 content
	JLabel montantEu = new JLabel("Montant de votre virement en Euros");
	JTextField fMontant = new JTextField();
	JLabel signeEuro = new JLabel("€");
	
	// panel3 content
	JLabel dateVirement = new JLabel("Date de votre virement");
	// snippet from http://www.codejava.net/java-se/swing/how-to-use-jdatepicker-to-display-calendar-component
	UtilDateModel model = new UtilDateModel();
	JDatePanelImpl datePanel = new JDatePanelImpl(model);
	JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
	
	// panel4
	JLabel message = new JLabel("Un message eventuel");
	JTextField messageField = new JTextField();
	
	// panel5
	JButton valider = new JButton("Valider");
	JButton annuler = new JButton("Annuler");

	public TransactionFrame() {
		
		// panel1 Layout and content
		GridLayout gl = new GridLayout(2, 3);
//		gl.setHgap(100);
//		gl.setVgap(10);
		//panel1.setSize(new Dimension(1000, 1000));
		panel1.setLayout(gl);
		panel1.setPreferredSize(new Dimension(850, 100));
		panel1.setBorder(BorderFactory.createTitledBorder("Caractéristiques du virement"));
		panel1.add(compteDebiter);
		idCompteCrediter.setPreferredSize(new Dimension(10, 10));
		panel1.add(idCompteDebiter);
		panel1.add(avoirDisponible);
		panel1.add(compteCredite);
		panel1.add(idCompteCrediter);
		
		// panel2 Layout and content
		panel2.setLayout(new BorderLayout());
		panel2.setPreferredSize(new Dimension(850, 50));
		panel2.setBorder(BorderFactory.createTitledBorder("Caractéristiques du virement"));
		panel2.add(montantEu, BorderLayout.LINE_START);
		panel2.add(fMontant, BorderLayout.CENTER);
		panel2.add(signeEuro, BorderLayout.LINE_END);
		
		
		
		
		
		// add all panel to the object panel
		this.add(panel1);
		this.add(panel2);

	}






























}
