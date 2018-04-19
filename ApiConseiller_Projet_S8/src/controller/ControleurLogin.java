package controller;

import java.awt.Component;
import javax.swing.JOptionPane;
import dao.UserDao;

public class ControleurLogin {

	private static Component frame;

	public void checkCredentials(String email, String password) {
//		if (email.equals("") || password.equals("")) {
//			JOptionPane.showMessageDialog(frame, "You must fill email AND password", "Inane error",
//					JOptionPane.ERROR_MESSAGE);
//		} else if (UserDao.getCredentials(email, password)) {
			MainControleur.menuPanel(email);
//		} else {
//			JOptionPane.showMessageDialog(frame, "Invalid email or password", "Inane error", JOptionPane.ERROR_MESSAGE);
//		}
	}
}
