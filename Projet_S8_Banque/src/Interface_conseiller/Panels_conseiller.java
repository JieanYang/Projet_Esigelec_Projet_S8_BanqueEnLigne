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
	// panel list of message
	protected JPanel p_listOfMessage = new JPanel();
	protected List<Message> listOfMessage;
	protected static Vector<String> vector = new Vector<String>();
	protected static JList listComponent;

	// panel response message
	protected JPanel p_responseOfMessage = new JPanel();
	protected static Message messageResponse;
	protected JLabel textField_id;
	protected JLabel textField_nom;
	protected JLabel textField_prenom;
	protected JLabel textField_numphone;
	protected JLabel textField_email;
	protected JTextArea textField_problem;
	protected static JTextArea textField_response;
	protected JLabel textField_date;

	
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
		// title of panel
		this.fenetre.setTitle("List of messages");
		
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
		MousePolice_p_listOfMessage police = new MousePolice_p_listOfMessage(this.fenetre);
		update.addMouseListener(police);
		response.addMouseListener(police);
		No.addMouseListener(police);
		
		// Add components
		this.p_listOfMessage.add(scrollPane);
		this.p_listOfMessage.add(update);
		this.p_listOfMessage.add(response);
		this.p_listOfMessage.add(No);
		
		// Apply layout
		// position x, position y, width, height, strech x, strech y, margin 
		this.setConstraints(0, 0, 2, 1, 0, 0, 10, layoutConstraints);
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

		// title of panel
		this.fenetre.setTitle("Response message");

		// Create panel
		this.p_responseOfMessage.setBackground(Color.WHITE);
		
		// Components
		JLabel label_id = new JLabel("id_message:");
		JLabel label_nom = new JLabel("nom:");
		JLabel label_prenom = new JLabel("prenom:");
		JLabel label_numphone = new JLabel("numphone:");
		JLabel label_email = new JLabel("email:");
		JLabel label_problem = new JLabel("problem:");
		JLabel label_response = new JLabel("response:");
		JLabel label_date = new JLabel("date:");

		textField_id = new JLabel();
		textField_nom = new JLabel();
		textField_prenom = new JLabel();
		textField_numphone = new JLabel();
		textField_email = new JLabel();
		textField_problem = new JTextArea(5, 30);
		textField_problem.setLineWrap(true);
		textField_problem.setEditable(false);
		textField_response = new JTextArea(10,30);
		textField_response.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		textField_response.setLineWrap(true);
		textField_date = new JLabel();
		

		JButton button_response = new JButton("response");
		JButton button_No = new JButton("return");

		// Add listener
		MousePolice_p_responseOfMessage police = new MousePolice_p_responseOfMessage(this.fenetre);
		button_response.addMouseListener(police);
		button_No.addMouseListener(police);

		// Set value for components
		if (this.messageResponse != null) {
			textField_id.setText(String.valueOf(this.messageResponse.getId_message()));
			textField_date.setText(this.messageResponse.getDate().toString());
			textField_nom.setText(this.messageResponse.getNom());
			textField_prenom.setText(this.messageResponse.getPrenom());
			textField_numphone.setText(this.messageResponse.getNumphone());
			textField_email.setText(this.messageResponse.getEmail());
			textField_problem.setText(this.messageResponse.getProblem());
			textField_response.setText(this.messageResponse.getReponse());
		}

			
		this.p_responseOfMessage.add(label_id);
		this.p_responseOfMessage.add(label_nom);
		this.p_responseOfMessage.add(label_prenom);
		this.p_responseOfMessage.add(label_numphone);
		this.p_responseOfMessage.add(label_email);
		this.p_responseOfMessage.add(label_problem);
		this.p_responseOfMessage.add(label_response);
		this.p_responseOfMessage.add(label_date);

		this.p_responseOfMessage.add(textField_id);
		this.p_responseOfMessage.add(textField_nom);
		this.p_responseOfMessage.add(textField_prenom);
		this.p_responseOfMessage.add(textField_numphone);
		this.p_responseOfMessage.add(textField_email);
		this.p_responseOfMessage.add(textField_problem);
		this.p_responseOfMessage.add(textField_response);
		this.p_responseOfMessage.add(textField_date);

		this.p_responseOfMessage.add(button_response);
		this.p_responseOfMessage.add(button_No);
		
		// Layout and constraints
		GridBagLayout layout = new GridBagLayout();
		this.p_responseOfMessage.setLayout(layout);
		GridBagConstraints layoutConstraints = new GridBagConstraints();


		// Apply layout
		// position x, position y, width, height, strech x, strech y, margin 
		this.setConstraints(0,0,1,1,0,0,10,layoutConstraints);
		layout.setConstraints(label_id,layoutConstraints);
		this.setConstraints(3,0,1,1,0,0,10,layoutConstraints);
		layout.setConstraints(label_date,layoutConstraints);
		this.setConstraints(0,1,1,1,0,0,10,layoutConstraints);
		layout.setConstraints(label_nom,layoutConstraints);
		this.setConstraints(3,1,1,1,0,0,10,layoutConstraints);
		layout.setConstraints(label_prenom,layoutConstraints);

		this.setConstraints(0,2,1,1,0,0,10,layoutConstraints);
		layout.setConstraints(label_numphone,layoutConstraints);
		this.setConstraints(3,2,1,1,0,0,10,layoutConstraints);
		layout.setConstraints(label_email,layoutConstraints);
		this.setConstraints(0,3,1,1,0,0,10,layoutConstraints);
		layout.setConstraints(label_problem,layoutConstraints);
		this.setConstraints(0,4,1,1,0,0,10,layoutConstraints);
		layout.setConstraints(label_response,layoutConstraints);

		// position x, position y, width, height, strech x, strech y, margin 
		this.setConstraints(1,0,1,1,1,0,10,layoutConstraints);
		layout.setConstraints(textField_id,layoutConstraints);
		this.setConstraints(4,0,1,1,1,0,10,layoutConstraints);
		layout.setConstraints(textField_date,layoutConstraints);
		this.setConstraints(1,1,1,1,1,0,10,layoutConstraints);
		layout.setConstraints(textField_nom,layoutConstraints);
		this.setConstraints(4,1,1,1,1,0,10,layoutConstraints);
		layout.setConstraints(textField_prenom,layoutConstraints);

		this.setConstraints(1,2,1,1,1,0,10,layoutConstraints);
		layout.setConstraints(textField_numphone,layoutConstraints);
		this.setConstraints(4,2,1,1,1,0,10,layoutConstraints);
		layout.setConstraints(textField_email,layoutConstraints);
		this.setConstraints(1,3,5,1,1,0,10,layoutConstraints);
		layout.setConstraints(textField_problem,layoutConstraints);
		this.setConstraints(0,5,5,2,1,1,10,layoutConstraints);
		layout.setConstraints(textField_response,layoutConstraints);

		this.setConstraints(1,8,1,1,0,0,10,layoutConstraints);
		layout.setConstraints(button_response,layoutConstraints);
		this.setConstraints(4,8,1,1,0,0,10,layoutConstraints);
		layout.setConstraints(button_No,layoutConstraints);

	}
	
}

class MousePolice_p_listOfMessage extends Panels_conseiller implements MouseListener {

	public MousePolice_p_listOfMessage(Fenetre fenetre) {
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
			System.out.println("update_listOfMessage");
			MessageDao messageDao = new MessageDao();
			super.listOfMessage = messageDao.getListMessage();
			// update list of messages
			super.vector.clear();
			super.vector = super.updateVector(super.vector);
			super.listComponent.setListData(super.vector);
		}else if (text.equals("response")) {
			System.out.println("response_listOfMessage");
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

class MousePolice_p_responseOfMessage extends Panels_conseiller implements MouseListener {




	public MousePolice_p_responseOfMessage(Fenetre fenetre) {
		super(fenetre);
		// TODO Auto-generated constructor stub
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
		if (text.equals("response")) {
			System.out.println("response_responseOfMessage");
			
			super.messageResponse.setReponse(super.textField_response.getText());;
			MessageDao messageDao = new MessageDao();
			messageDao.updateMessage(super.messageResponse);
			
		}else if (text.equals("return")) {
			super.fenetre.setPanel(super.get_P_listOfMessage());
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

