package controller;

import java.awt.Component;
import javax.swing.JOptionPane;
import dao.UserDao;
import dto.User;

public class ControleurLogin {

	private static Component frame;
	
	private UserDao conseillerDAO = new UserDao();

	public void checkCredentials(String email, String password) {
		if (email.equals("") || password.equals("")) {
			JOptionPane.showMessageDialog(frame, "Les deux champs doivent être renseigné", "Inane error",
					JOptionPane.ERROR_MESSAGE);
		} else if (UserDao.getCredentials(email, password)) {
			MainControleur.conseiller = conseillerDAO.getCurrentUser(email);
			MainControleur.menuPanel();
		} else {
			JOptionPane.showMessageDialog(frame, "Indentifiants invalide", "Inane error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
