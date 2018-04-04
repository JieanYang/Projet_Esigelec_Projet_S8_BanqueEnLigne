package vue;

import controller.Login;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel loginPan1 = new JPanel();
	private JPanel loginPan2 = new JPanel();

	// loginPan1 components
	private JLabel username = new JLabel("Username :");
	private JTextField uField = new JTextField();
	private JLabel password = new JLabel("Password :");
	private JPasswordField pField = new JPasswordField();
	private JButton button = new JButton("Login");
	
	// font
	Font font1 = new Font("SansSerif", Font.BOLD, 20);

	public LoginFrame() {
		this.setTitle("Login");
		this.setLayout(new GridLayout(0, 2));

		// loginPane1 Layout
		loginPan1.setLayout(new BoxLayout(loginPan1, BoxLayout.PAGE_AXIS));

		// loginPan1 components
		uField.setPreferredSize(new Dimension(5, 5));
		Font font1 = new Font("SansSerif", Font.BOLD, 20);
		username.setFont(font1);
		password.setFont(font1);
		uField.setFont(font1);
		pField.setFont(font1);
		button.setFont(font1);
		button.addActionListener(this);

		// add swing component to loginPan2 pane
		loginPan1.add(username);
		loginPan1.add(Box.createRigidArea(new Dimension(0, 5)));
		loginPan1.add(uField);
		loginPan1.add(Box.createRigidArea(new Dimension(0, 10)));
		loginPan1.add(password);
		loginPan1.add(Box.createRigidArea(new Dimension(0, 5)));
		loginPan1.add(pField);
		loginPan1.add(Box.createRigidArea(new Dimension(0, 10)));
		loginPan1.add(button);
		loginPan1.setBorder(BorderFactory.createEmptyBorder(100, 110, 600, 30));

		// add loginPan1 and loginPan2 to the main container
		this.add(loginPan1);
		this.add(loginPan2);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// https://stackoverflow.com/questions/9798066/gettext-vs-getpassword
		Login.checkCredentials(uField.getText(), new String(pField.getPassword()));
	}

}
