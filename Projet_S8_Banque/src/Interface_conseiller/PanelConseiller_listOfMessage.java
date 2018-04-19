package Interface_conseiller;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import Class.Message;
import dao.MessageDao;

public class PanelConseiller_listOfMessage extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
	protected static Fenetre fenetre;
	// data
	private List<Message> list_allMessage;
	
	// Constructor
	PanelConseiller_listOfMessage() {}
	PanelConseiller_listOfMessage(Fenetre fenetre) {
		PanelConseiller_listOfMessage.fenetre = fenetre;
		this.initiate_data();
		this.initiate_panel_listOfMessage();
	}
	
	private void initiate_panel_listOfMessage() {
		// Set title of frame
//		PanelConseiller_listOfMessage.fenetre.setTitle("Frame");
		
		// Create Layout and constraints
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints layoutConstraints = new GridBagConstraints();
		
		// Background color and Border
		this.setBackground(Color.white);
		// this.setBorder((Border) new TitledBorder(null, "List of message:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				
		// Create list and components then add into mainPanel
		Vector<String> vector = new Vector<String>();
		vector.add("id        nom        prenom        problem        date");
		for(int i = 0;i<this.list_allMessage.size();i++) {
			vector.add(this.formatMessage(this.list_allMessage.get(i)));
		}
		JList<String> listMessage = new JList<String>(vector);
		listMessage.setBorder(BorderFactory.createTitledBorder("List of message"));
		JScrollPane scrollPane = new JScrollPane(listMessage);
		this.add(scrollPane);
		
		// Create buttons and add listener then add into mainPanel
		JButton response = new JButton("response");
		JButton No = new JButton("return");
		MousePolice_PanelConseiller_listOfMessage police = new MousePolice_PanelConseiller_listOfMessage(listMessage);
		response.addMouseListener(police);
		No.addMouseListener(police);
		this.add(response);
		this.add(No);
		
		
		
		/**
		 * Apply layout
		 * position x, position y, width, height, strech x, strech y, margin 
		 */ 
		/*layoutConstraints.anchor = GridBagConstraints.CENTER;
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;*/
		this.setLayout(layout);
		// regulations
		this.setConstraints(0, 0, 2, 1, 1, 1, 10, layoutConstraints);
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layout.setConstraints(scrollPane, layoutConstraints);
		this.setConstraints(0, 1, 1, 1, 1, 0, 10, layoutConstraints);
		layout.setConstraints(response, layoutConstraints);
		this.setConstraints(1, 1, 1, 1, 1, 0, 10, layoutConstraints);
		layout.setConstraints(No, layoutConstraints);
	}
	private void initiate_data() {
		MessageDao messageDao = new MessageDao();
		this.list_allMessage = messageDao.getListMessage();
	}
	
	/**
	 * Other useful functions
	 */
	// Format message
	public String formatMessage(Message message) {
		String retour = new String();
		String id = String.valueOf(message.getId_message());
		String nom = message.getNom();
		String prenom = message.getPrenom();
		String problem = message.getPrenom();
		String date = message.getDate().toString();
		if(message.getReponse() == null || message.getReponse().equals(" ") || message.getReponse().equals("")) {
			retour = id + "    " + nom + "    " + prenom + "    " + problem + "    " + date + "    non lu";
		}else {
			retour = id + "    " + nom + "    " + prenom + "    " + problem + "    " + date;
		}
			
		return retour;
	}
	// Constraints
	public void setConstraints(int gridx, int gridy, int width, int height,
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
}

class MousePolice_PanelConseiller_listOfMessage extends PanelConseiller_listOfMessage implements MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JList<String> listMessage;
	
	MousePolice_PanelConseiller_listOfMessage(JList<String> listMessage) {
		this.listMessage = listMessage;
	}

	@SuppressWarnings("static-access")
	public void mouseClicked(MouseEvent arg0) {
		String text = this.getText(arg0.getSource().toString());
		// System.out.println(text);
		if (text.equals("response")) {
			System.out.println("response_listOfMessage");
			// return the id of item selected
			String selected_text = (String) this.listMessage.getSelectedValue();
			int id = Integer.valueOf(selected_text.split(" ")[0]);
			super.fenetre.setId_message(id);
			// System.out.println(super.fenetre.getId_message());
			super.fenetre.setPanel(new PanelConseiller_responseOfMessage(super.fenetre));
		}else if (text.equals("return")) {
			super.fenetre.setPanel(new JPanel());
		}
	}
	
	public String getText(String source) {
		String retour = "";
		
		String[] sourceSplit = source.split(",");
		retour = sourceSplit[25].split("=")[1];
		return retour;
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
