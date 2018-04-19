package Interface_conseiller;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Class.Message;
import dao.MessageDao;

public class PanelConseiller_responseOfMessage extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	protected static Fenetre fenetre;
	// data
	private int id_message;
	protected static Message message;
	protected static JTextArea textField_response;
	
	// Constructor
	PanelConseiller_responseOfMessage() {}
	PanelConseiller_responseOfMessage(Fenetre fenetre) {
		PanelConseiller_responseOfMessage.fenetre = fenetre;
		this.id_message = PanelConseiller_responseOfMessage.fenetre.getId_message();
		this.initiate_data();
		this.initiate_PanelConseiller_responseOfMessage();
	}
	private void initiate_PanelConseiller_responseOfMessage() {
		// Set title of frame
		PanelConseiller_responseOfMessage.fenetre.setTitle("Response");
		
		// Create Layout and constraints
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints layoutConstraints = new GridBagConstraints();
		
		// Background color and Border
		this.setBackground(Color.white);
		// this.setBorder((Border) new TitledBorder(null, "List of message:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		
		
		/**
		 *  Create panel for labels, textareas and components then add into mainPanel
		 */
		JPanel panel_labels_text = new JPanel();
		panel_labels_text.setBackground(Color.white);
			// Components
			JLabel label_id = new JLabel("id_message:");
			JLabel label_nom = new JLabel("nom:");
			JLabel label_prenom = new JLabel("prenom:");
			JLabel label_numphone = new JLabel("numphone:");
			JLabel label_email = new JLabel("email:");
			JLabel label_problem = new JLabel("problem:");
			JLabel label_response = new JLabel("response:");
			JLabel label_date = new JLabel("date:");
	
			JLabel textField_id = new JLabel();
			JLabel textField_nom = new JLabel();
			JLabel textField_prenom = new JLabel();
			JLabel textField_numphone = new JLabel();
			JLabel textField_email = new JLabel();
			JTextArea textField_problem = new JTextArea(5, 30);
			textField_problem.setLineWrap(true);
			textField_problem.setEditable(false);
			PanelConseiller_responseOfMessage.textField_response = new JTextArea(10,30);
			PanelConseiller_responseOfMessage.textField_response.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			PanelConseiller_responseOfMessage.textField_response.setLineWrap(true);
			JLabel textField_date = new JLabel();
			// add components
			panel_labels_text.add(label_id);
			panel_labels_text.add(label_nom);
			panel_labels_text.add(label_prenom);
			panel_labels_text.add(label_numphone);
			panel_labels_text.add(label_email);
			panel_labels_text.add(label_problem);
			panel_labels_text.add(label_response);
			panel_labels_text.add(label_date);
				
			panel_labels_text.add(textField_id);
			panel_labels_text.add(textField_nom);
			panel_labels_text.add(textField_prenom);
			panel_labels_text.add(textField_numphone);
			panel_labels_text.add(textField_email);
			panel_labels_text.add(textField_problem);
			panel_labels_text.add(PanelConseiller_responseOfMessage.textField_response);
			panel_labels_text.add(textField_date);
			
			// Insert data
			textField_id.setText(String.valueOf(PanelConseiller_responseOfMessage.message.getId_message()));
			textField_date.setText(PanelConseiller_responseOfMessage.message.getDate().toString());
			textField_nom.setText(PanelConseiller_responseOfMessage.message.getNom());
			textField_prenom.setText(PanelConseiller_responseOfMessage.message.getPrenom());
			textField_numphone.setText(PanelConseiller_responseOfMessage.message.getNumphone());
			textField_email.setText(PanelConseiller_responseOfMessage.message.getEmail());
			textField_problem.setText(PanelConseiller_responseOfMessage.message.getProblem());
			PanelConseiller_responseOfMessage.textField_response.setText(PanelConseiller_responseOfMessage.message.getReponse());
			
			
			// Layout for panel_labels_text
			panel_labels_text.setLayout(layout);
			// regulation -> position x, position y, width, height, strech x, strech y, margin 
			// Labels
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
			layoutConstraints.anchor = GridBagConstraints.NORTH;
			layout.setConstraints(label_problem,layoutConstraints);
			this.setConstraints(0,4,1,1,0,0,10,layoutConstraints);
			layout.setConstraints(label_response,layoutConstraints);
			
			// Textarea
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
			layout.setConstraints(PanelConseiller_responseOfMessage.textField_response,layoutConstraints);
			
			
			
			
		/**
		 * Create panel buttons and components then add into mainPanel
		 */
		JPanel panel_buttons = new JPanel();
		panel_buttons.setBackground(Color.white);
			// Components
			JButton button_response = new JButton("response");
			JButton button_No = new JButton("return");
			// Add listener and compoennts
			MousePolice_PanelConseiller_responseOfMessage police = new MousePolice_PanelConseiller_responseOfMessage();
			button_response.addMouseListener(police);
			button_No.addMouseListener(police);
			panel_buttons.add(button_response);
			panel_buttons.add(button_No);
			// Layout for panel_buttons
			panel_buttons.setLayout(layout);
			// regulation -> position x, position y, width, height, strech x, strech y, margin 
			this.setConstraints(0,0,1,1,0,0,10,layoutConstraints);
			layout.setConstraints(button_response,layoutConstraints);
			this.setConstraints(1,0,1,1,0,0,10,layoutConstraints);
			layout.setConstraints(button_No,layoutConstraints);
			
			
		/**
		 * Layout for mainPanel
		 */
		this.setLayout(layout);
		this.add(panel_labels_text);
		this.add(panel_buttons);
		// regulation
		/*layoutConstraints.anchor = GridBagConstraints.CENTER;
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;*/
		this.setLayout(layout);
		// regulations
		this.setConstraints(0, 0, 1, 1, 1, 1, 10, layoutConstraints);
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layout.setConstraints(panel_labels_text, layoutConstraints);
		this.setConstraints(0, 1, 1, 1, 0, 0, 10, layoutConstraints);
		layoutConstraints.fill = GridBagConstraints.NONE;
		layoutConstraints.anchor = GridBagConstraints.EAST;
		layout.setConstraints(panel_buttons, layoutConstraints);
		
	}
	private void initiate_data() {
		MessageDao messageDao = new MessageDao();
		PanelConseiller_responseOfMessage.message = messageDao.getMessage(this.id_message);
	}
	
	/**
	 * Other useful functions
	 */
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

class MousePolice_PanelConseiller_responseOfMessage extends PanelConseiller_responseOfMessage implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	MousePolice_PanelConseiller_responseOfMessage() {}
	
	@SuppressWarnings("static-access")
	public void mouseClicked(MouseEvent arg0) {
		String text = this.getText(arg0.getSource().toString());
		// System.out.println(text);
		if (text.equals("response")) {
			System.out.println("response_responseOfMessage");
			super.message.setReponse(super.textField_response.getText());
			MessageDao messageDao = new MessageDao();
			messageDao.updateMessage(super.message);
			
		}else if (text.equals("return")) {
			super.fenetre.setPanel(new PanelConseiller_listOfMessage(super.fenetre));
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
