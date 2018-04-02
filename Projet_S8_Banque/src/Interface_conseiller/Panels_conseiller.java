package Interface_conseiller;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Class.Message;
import Dao.MessageDao;

public class Panels_conseiller {
	protected Fenetre fenetre;
	protected JPanel p_listOfMessage = new JPanel();
	protected JPanel p_responseOfMessage = new JPanel();
	protected List<Message> listOfMessage;
	protected Message messageResponse;
	protected static Vector<String> vector = new Vector<String>();
	protected static JList listComponent;
	
	// Constructor
	public Panels_conseiller(Fenetre fenetre) {
		this.fenetre = fenetre;
	}
	
	// Panel for list of message
	public JPanel get_P_listOfMessage() {
		this.init_p_listOfMessage();
		return this.p_listOfMessage;
	}
	// Format message
	public String formatMessage(Message message) {
		String retour = new String();
		String id = String.valueOf(message.getId_message());
		String nom = message.getNom();
		String prenom = message.getPrenom();
		String problem = message.getPrenom();
		String date = message.getDate().toString();
		retour = id+"    "+nom+"    "+prenom+"    "+prenom+"    "+
		problem+"    "+date;
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
	
	public Vector updateVector(Vector vector) {
		for(int i = 0;i<this.listOfMessage.size();i++) {
			vector.add(this.formatMessage(this.listOfMessage.get(i)));
		}
		return vector;
	}
	
	public void init_p_listOfMessage() {
		// Create panel
		this.p_listOfMessage.setBackground(Color.white);
		
		//Layout and constraints
		GridBagLayout layout = new GridBagLayout();
		this.p_listOfMessage.setLayout(layout);
		GridBagConstraints layoutConstraints = new GridBagConstraints();
		
		// Components
		this.listComponent = new JList(this.vector);
		this.listComponent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.listComponent.setBorder(BorderFactory.createTitledBorder("List of message"));
		JScrollPane scrollPane = new JScrollPane(listComponent);
		JButton update = new JButton("update");
		JButton response = new JButton("response");
		JButton No = new JButton("return");
		
		// Add Listener
		MousePolice police = new MousePolice(this.fenetre);
		update.addMouseListener(police);
		response.addMouseListener(police);
		No.addMouseListener(police);
		
		// Add components
		this.p_listOfMessage.add(scrollPane);
		this.p_listOfMessage.add(update);
		this.p_listOfMessage.add(response);
		this.p_listOfMessage.add(No);
		
		// Apply layout
		this.setConstraints(0, 0, 2, 1, 1, 1, 10, layoutConstraints);
		layout.setConstraints(update, layoutConstraints);
		this.setConstraints(0, 1, 2, 1, 1, 1, 10, layoutConstraints);
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layout.setConstraints(scrollPane, layoutConstraints);
		this.setConstraints(0, 2, 1, 1, 1, 0, 10, layoutConstraints);
		layout.setConstraints(response, layoutConstraints);
		this.setConstraints(1, 2, 1, 1, 1, 0, 10, layoutConstraints);
		layout.setConstraints(No, layoutConstraints);
		
	}
	
	
	
	// Panel for response of message
	public JPanel get_p_responseOfMessage() {
		this.init_p_responseOfMessage();
		return this.p_responseOfMessage;
	}
	
	public void init_p_responseOfMessage() {
		
	}
	
}

class MousePolice extends Panels_conseiller implements MouseListener {

	public MousePolice(Fenetre fenetre) {
		super(fenetre);
	}

	public String getText(String source) {
		String retour = "";
		
		String[] sourceSplit = source.split(",");
		retour = sourceSplit[25].split("=")[1];
		return retour;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		String text = this.getText(arg0.getSource().toString());
		// System.out.println(text);
		if (text.equals("update")) {
			System.out.println("update");
			MessageDao messageDao = new MessageDao();
			super.listOfMessage = messageDao.getListMessage();
			// update list of messages
			super.vector.clear();
			super.vector = super.updateVector(super.vector);
			super.listComponent.setListData(super.vector);
		}else if (text.equals("response")) {
			System.out.println("response");
			// return the id of item selected
			String selected_text = (String) super.listComponent.getSelectedValue();
			int id = Integer.valueOf(selected_text.split(" ")[0]);
			
			MessageDao messageDao = new MessageDao();
			super.messageResponse =  messageDao.getMessage(id);
			
			super.fenetre.setPanel(super.get_p_responseOfMessage());
		}else if (text.equals("return")) {
			super.fenetre.dispose();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
