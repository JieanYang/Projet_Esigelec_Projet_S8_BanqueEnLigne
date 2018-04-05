package vue;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ControleurLogin;

public class PanelLogin extends JPanel implements ActionListener{

	private JLabel email = new JLabel("Email :");
	private JTextField uField = new JTextField();
	private JLabel password = new JLabel("Password :");
	private JPasswordField pField = new JPasswordField();
	private JButton button = new JButton("Login");

	/**
	 * Create the panel.
	 */
	public PanelLogin() {
		this.setSize(600, 600);
		setLayout(null);

		// loginPane1 Layout
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		// this components
		uField.setPreferredSize(new Dimension(5, 5));
		Font font1 = new Font("SansSerif", Font.BOLD, 20);
		email.setFont(font1);
		password.setFont(font1);
		uField.setFont(font1);
		pField.setFont(font1);
		button.setFont(font1);
		button.addActionListener(this);

		// add swing component to loginPan2 pane
		this.add(email);
		this.add(Box.createRigidArea(new Dimension(0, 5)));
		this.add(uField);
		this.add(Box.createRigidArea(new Dimension(0, 10)));
		this.add(password);
		this.add(Box.createRigidArea(new Dimension(0, 5)));
		this.add(pField);
		this.add(Box.createRigidArea(new Dimension(0, 10)));
		this.add(button);
		this.setBorder(BorderFactory.createEmptyBorder(100, 110, 600, 30));
	}

	public void actionPerformed(ActionEvent e) {
		if(ControleurLogin.checkCredentials(uField.getText(), new String(pField.getPassword()))) {
			
		}
	}

}
