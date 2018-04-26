package Interface_conseiller;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Class.Compte;
import Class.Transaction;
import dao.CompteDao;
import dao.TransactionDao;

public class PanelConseiller_transactionsUnCompte extends JPanel {		
		
	protected static Fenetre fenetre;
	// Data for page PanelConseiller_transactionsUnCompte
	protected List<Transaction> list_transactionsOneCompte = new ArrayList<Transaction>();
	protected Compte compte;
	
	private String[] titles = {"id_transaction", "categorie", "emetteur", "recepteur", "date of transaction", "somme", "description"};
	
	// Constructor
	PanelConseiller_transactionsUnCompte() {}
	PanelConseiller_transactionsUnCompte(Fenetre fenetre){
		this.fenetre = fenetre;
		// data acces
		this.initiate_Data(fenetre.getId_compte());
		// vue
		this.initiate_panel_transactinsUnCompte();
	}
	private void initiate_panel_transactinsUnCompte() {
		// Create Layout and constraints
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints layoutConstraints = new GridBagConstraints();
		
		// Background color and Border
		this.setBackground(Color.white);
		this.setBorder(new TitledBorder(null, "History of trsaction of Compte " + compte.getCategorie_compte(), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		// Panel solde
		JPanel Panel_solde = new JPanel();
		JLabel label_solde = new JLabel("Solde:  " + compte.getSolde());
		Panel_solde.add(label_solde);
		
		// Panel table of transactions
		// Initiate table
		String[][] data = generateDataTable();
		DefaultTableModel model = new DefaultTableModel(data, this.titles);
		JTable table = new JTable(model);
		// create scrollPane
		JScrollPane scrollPane = new JScrollPane(table);
		
		
		// Panel button for return 
		JButton button_return = new JButton("return");
		MousePolice_PanelConseiller_transactionsUnCompte police = new MousePolice_PanelConseiller_transactionsUnCompte();
		button_return.addMouseListener(police);
		
		// Add components into Page
		this.add(Panel_solde);
		this.add(scrollPane);
		this.add(button_return);
		
		// Apply layout
		this.setLayout(layout);
		// parameters -> position x, position y, width, height, strech x, strech y, margin 
		this.setConstraints_regulation(0, 0, 1, 1, 0, 0, 10, layoutConstraints);
		layoutConstraints.fill = GridBagConstraints.NONE;
		layoutConstraints.anchor = GridBagConstraints.WEST;
		layout.setConstraints(Panel_solde, layoutConstraints);
		this.setConstraints_regulation(0, 1, 1, 1, 1, 1, 10, layoutConstraints);
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layout.setConstraints(scrollPane, layoutConstraints);
		this.setConstraints_regulation(0, 2, 1, 1, 0, 0, 10, layoutConstraints);
		layoutConstraints.fill = GridBagConstraints.NONE;
		layoutConstraints.anchor = GridBagConstraints.EAST;
		layout.setConstraints(button_return, layoutConstraints);
	}
	
	// Constraints
	private void setConstraints_regulation(int gridx, int gridy, int width, int height,
			int weightx, int weighty, int insets,
			GridBagConstraints layoutConstraints) {
		layoutConstraints.anchor = GridBagConstraints.CENTER;
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.gridx = gridx;
		layoutConstraints.gridy = gridy;
		layoutConstraints.gridwidth = width;
		layoutConstraints.gridheight = height;
		layoutConstraints.weightx = weightx;
		layoutConstraints.weighty = weighty;
		layoutConstraints.insets = new Insets(insets, insets, insets, insets); // margin
	}
	

	private void initiate_Data(int id_compte) {
		CompteDao compteDao = new CompteDao();
		compte = compteDao.getCompte(id_compte);
		TransactionDao transactionDao = new TransactionDao();
		this.list_transactionsOneCompte = transactionDao.getListTransactionById_compte(id_compte);
	}
	
	private String[][] generateDataTable() {
		String[][] data = new String[this.list_transactionsOneCompte.size()][titles.length];

		for (int i = 0; i < this.list_transactionsOneCompte.size(); i++) {
			for (int j = 0 ; j < titles.length; j++ )
				switch (j) {
				case 0: data[i][j] = String.valueOf(this.list_transactionsOneCompte.get(i).getId_transaction());break;
				case 1: data[i][j] = this.list_transactionsOneCompte.get(i).getCategorie_transaction();break;
				case 2: data[i][j] = String.valueOf(this.list_transactionsOneCompte.get(i).getId_compte_emetteur());break;
				case 3: data[i][j] = String.valueOf(this.list_transactionsOneCompte.get(i).getId_compte_recepteur());break;
				case 4: data[i][j] = this.list_transactionsOneCompte.get(i).getDate_transaction().toString();break;
				case 5: 
					if (this.list_transactionsOneCompte.get(i).getId_compte_recepteur() == this.fenetre.getId_compte()) {
						data[i][j] = "+" + String.valueOf(this.list_transactionsOneCompte.get(i).getSomme());
					}else {
						data[i][j] = "-" + String.valueOf(this.list_transactionsOneCompte.get(i).getSomme());
					}
					break;
				case 6: data[i][j] = this.list_transactionsOneCompte.get(i).getDescription();break;
				}
		}
		
		return data;
	}
}


class MousePolice_PanelConseiller_transactionsUnCompte extends PanelConseiller_transactionsUnCompte implements MouseListener {

	/**
	 *  version 
	 */
	private static final long serialVersionUID = 1L;

	public MousePolice_PanelConseiller_transactionsUnCompte() {

	}

	public String getText(String source) {
		String retour = "";
		
		String[] sourceSplit = source.split(",");
		retour = sourceSplit[25].split("=")[1];
		return retour;
	}
	
	public void mouseClicked(MouseEvent arg0) {
		String text = this.getText(arg0.getSource().toString());
		
		if(text.equals("return")) {
			super.fenetre.setPanel(new PanelConseiller_comptesClient(super.fenetre));
		}
		
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
