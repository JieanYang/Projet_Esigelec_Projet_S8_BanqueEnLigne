package vue;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controleur.ControleurLogin;

public class Login extends JPanel {

	private static final long serialVersionUID = 1L;

	// the frame
	protected static MainFrame mainFrame;
	// the controler
	private ControleurLogin cLogin = new ControleurLogin();

	/**
	 * Create the panel.
	 */
	public Login() {
		this.initializeCompenant();
	}

	public Login(MainFrame mainFrame) {
		Login.mainFrame = mainFrame;
		this.initializeCompenant();
	}

	public void initializeCompenant() {

		this.setSize(600, 600);
		this.setLayout(null);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(184, 172, 116, 32);
		this.add(lblEmail);

		JTextField tFieldEmail = new JTextField();
		tFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tFieldEmail.setBounds(184, 217, 232, 32);
		this.add(tFieldEmail);
		tFieldEmail.setColumns(10);

		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMotDePasse.setBounds(185, 281, 170, 32);
		this.add(lblMotDePasse);

		JPasswordField tFieldPassword = new JPasswordField();
		tFieldPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tFieldPassword.setBounds(184, 326, 232, 32);
		this.add(tFieldPassword);
		tFieldPassword.setColumns(10);

		JButton btnConnecxion = new JButton("Connexion");
		btnConnecxion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnConnecxion.setBounds(215, 392, 170, 32);
		btnConnecxion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cLogin.checkCredentials(tFieldEmail.getText(), new String(tFieldPassword.getPassword()));
			}
		});
		this.add(btnConnecxion);
	}

}
