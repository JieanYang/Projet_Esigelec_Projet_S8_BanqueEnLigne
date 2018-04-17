package Interface_conseiller;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Class.Compte;
import dao.CompteDao;

public class PanelConseiller_comptesClient extends JPanel {
	/**
	 * version
	 */
	private static final long serialVersionUID = 1L;	

	// Fenetre
	protected static Fenetre fenetre;
	
	// initiate_Data
	protected static Map<String, Compte> list_compteMap = new HashMap<String, Compte>();
	
	// Panel afficher information of compte
	protected String nameCompte;
	protected JPanel Panel_Compte = new JPanel();
	
	
	// Constructor
	PanelConseiller_comptesClient() { }
	// Constructor
	PanelConseiller_comptesClient(Fenetre fenetre) {
		PanelConseiller_comptesClient.fenetre = fenetre;
		this.initiate_Data(fenetre.getId_client());
		this.initiate_panel_banlanceSolde_and_history();
	}
	
	
	
	private void initiate_panel_banlanceSolde_and_history() {
		// Create Layout and constraints
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints layoutConstraints = new GridBagConstraints();
		
		// Background color and Border
		this.setBackground(Color.white);
		this.setBorder(new TitledBorder(null, "Informations des compte Client", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		
		// Create buttons for compte and add them into Panel_Buttons
		JPanel Panel_Buttons = new JPanel();
		Panel_Buttons.setBorder(new TitledBorder(null, "S¨¦lectionnez le compte", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Panel_Buttons.setBackground(Color.white);
		JButton button_courant = new JButton("Compte courant");
		JButton button_epargne = new JButton("Compte epargne");
		JButton button_titre = new JButton("Compte titre");
		MousePolice_PanelConseiller_comptesClient police = new MousePolice_PanelConseiller_comptesClient();
		button_courant.addMouseListener(police);
		button_epargne.addMouseListener(police);
		button_titre.addMouseListener(police);
		Panel_Buttons.add(button_courant);
		Panel_Buttons.add(button_epargne);
		Panel_Buttons.add(button_titre);
		
		// Create label and add them into Panel_Compte
		this.Panel_Compte.setBorder(new TitledBorder(null, "Informations de compte " + this.nameCompte,TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.Panel_Compte.setBackground(Color.white);
		// Label for the information of compte
		JLabel label_etat = new JLabel("<html><p>etat:</p><p>" + PanelConseiller_comptesClient.list_compteMap.get(this.nameCompte).getEtat() + "</p></html>");
		JLabel label_solde = new JLabel("<html><p>solde:</p><p>" + PanelConseiller_comptesClient.list_compteMap.get(this.nameCompte).getSolde() + "</p></html>");
		JLabel label_dateCreate = new JLabel("<html><p>date create:</p><p>" + PanelConseiller_comptesClient.list_compteMap.get(this.nameCompte).getDate_create() + "</p></html>");
		JLabel label_dateDelete = new JLabel("");
		if (PanelConseiller_comptesClient.list_compteMap.get(this.nameCompte).getDate_delete() != null) {
			label_dateDelete.setText("<html><p>date delete:</p><p>" + PanelConseiller_comptesClient.list_compteMap.get(this.nameCompte).getDate_delete() + "</p></html>");
		} 
		
		// Add labels into the page
		this.Panel_Compte.add(label_etat);
		this.Panel_Compte.add(label_solde);
		this.Panel_Compte.add(label_dateCreate);
		this.Panel_Compte.add(label_dateDelete);
		// Set layout
		this.Panel_Compte.setLayout(layout);
		// Set the position of label
		// position x, position y, width, height, strech x, strech y, margin
		this.setConstraints_regulation(0,0,1,1,1,1,10,layoutConstraints);
		layout.setConstraints(label_etat,layoutConstraints);
		this.setConstraints_regulation(1,0,1,1,1,1,10,layoutConstraints);
		layout.setConstraints(label_solde,layoutConstraints);
		this.setConstraints_regulation(0,1,1,1,1,1,10,layoutConstraints);
		layout.setConstraints(label_dateCreate,layoutConstraints);
		this.setConstraints_regulation(1,1,1,1,1,1,10,layoutConstraints);
		layout.setConstraints(label_dateDelete,layoutConstraints);
		
		
		// create Button and add them into Panel_ConsulteTransaction
		JPanel Panel_bottom = new JPanel();
		Panel_bottom.setBackground(Color.white);
		JButton button_consulter = new JButton("Consulter");
		JButton button_return = new JButton("return");
		button_consulter.addMouseListener(police);
		button_return.addMouseListener(police);
		Panel_bottom.add(button_consulter);
		Panel_bottom.add(button_return);
		
		// Add components into mainPanel
		this.add(Panel_Buttons);
		this.add(this.Panel_Compte);
		this.add(Panel_bottom);
		
		
		// Set layout to main Panel
		this.setLayout(layout);
		
		// Apply layout
		// position x, position y, width, height, strech x, strech y, margin 
		this.setConstraints_regulation(0,0,1,1,0,0,10,layoutConstraints);
		layout.setConstraints(Panel_Buttons,layoutConstraints);
		this.setConstraints_regulation(0,1,1,1,1,1,10,layoutConstraints);
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layout.setConstraints(this.Panel_Compte,layoutConstraints);
		this.setConstraints_regulation(0,2,1,1,0,0,10,layoutConstraints);
		layoutConstraints.fill = GridBagConstraints.NONE;
		layoutConstraints.anchor = GridBagConstraints.EAST;
		layout.setConstraints(Panel_bottom,layoutConstraints);
		
		
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
		// layoutConstraints.ipadx = ipadx; Padding
		// layoutConstraints.ipady = ipady; Padding
	}
	

	
	private void initiate_Data(int id_client) {
		// preparation for compte
		List<Compte> list_compte = new ArrayList<Compte>();
		CompteDao compteDao = new CompteDao();
		
		// list of compte, fill list
		list_compte = compteDao.getListCompteById_lient(id_client);
		
		for(Compte item: list_compte){
			if(item.getCategorie_compte().equals("courant")){
					PanelConseiller_comptesClient.list_compteMap.put("courant", compteDao.getCompte(item.getId_compte()));
				// System.out.println(	this.list_compteMap.get("courant"));
			}
			if(item.getCategorie_compte().equals("epargne")){
					PanelConseiller_comptesClient.list_compteMap.put("epargne", compteDao.getCompte(item.getId_compte()));
				// System.out.println(	this.list_compteMap.get("epargne"));
			}
			if(item.getCategorie_compte().equals("titre")){
					PanelConseiller_comptesClient.list_compteMap.put("titre", compteDao.getCompte(item.getId_compte()));
				// System.out.println(	this.list_compteMap.get("titre"));
			}
			
		}
		
		// Detect value in the fenetre
		if(PanelConseiller_comptesClient.fenetre.getId_compte() == 0) {
			PanelConseiller_comptesClient.fenetre.setId_compte(list_compteMap.get("courant").getId_compte());
			this.nameCompte = "courant";
		} else {
			this.nameCompte = compteDao.getCompte(PanelConseiller_comptesClient.fenetre.getId_compte()).getCategorie_compte();
		}
		
	}

}

class MousePolice_PanelConseiller_comptesClient extends PanelConseiller_comptesClient implements MouseListener {

	/**
	 *  version 
	 */
	private static final long serialVersionUID = 1L;


	public MousePolice_PanelConseiller_comptesClient() {
		
	}

	public String getText(String source) {
		String retour = "";
		
		String[] sourceSplit = source.split(",");
		retour = sourceSplit[25].split("=")[1];
		return retour;
	}
	
	
	
	@SuppressWarnings("static-access")
	public void mouseClicked(MouseEvent arg0) {
		String text = this.getText(arg0.getSource().toString());
		
		if(text.equals("return")) {
			System.out.println("return");
			super.fenetre.setPanel(new JPanel());
		} else if (text.equals("Consulter")){
			super.fenetre.setPanel(new PanelConseiller_transactionsUnCompte(super.fenetre));
		} else {
			if (text.equals("Compte courant")) {
				super.nameCompte = "courant";
				super.fenetre.setId_compte(super.list_compteMap.get("courant").getId_compte());
			} else if(text.equals("Compte epargne")) {
				super.nameCompte = "epargne";
				super.fenetre.setId_compte(super.list_compteMap.get("epargne").getId_compte());
			} else if(text.equals("Compte titre")) {
				super.nameCompte = "titre";
				super.fenetre.setId_compte(super.list_compteMap.get("titre").getId_compte());
			}
			
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
