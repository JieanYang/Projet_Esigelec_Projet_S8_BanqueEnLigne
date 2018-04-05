package controller;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dao.UserDao;
import vue.MainFrame;
import vue.PanelLogin;

public class ControleurLogin {
	
	public MainFrame mFrame = new MainFrame();

	private static PanelLogin loginUI;
	private static UserDao userDAO;
	private static Component frame;

	public static boolean checkCredentials(String email, String password) {
		if (email.equals("") || password.equals("")) {
			JOptionPane.showMessageDialog(frame, "You must fill email AND password", "Inane error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (UserDao.getCredentials(email, password)) {
			JOptionPane.showMessageDialog(frame, "Logged In");
			return true;
		} else {
			JOptionPane.showMessageDialog(frame, "Invalid email or password", "Inane error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
}
