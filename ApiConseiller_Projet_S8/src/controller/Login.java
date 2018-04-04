package controller;

import java.awt.Component;

import javax.swing.JOptionPane;

import dao.UserDao;
import vue.LoginFrame;

public class Login {

	private static LoginFrame loginUI;
	private static UserDao userDAO;
	private static Component frame;

	public static void checkCredentials(String email, String password) {
		if (email.equals("") || password.equals("")) {
			JOptionPane.showMessageDialog(frame, "You must fill email AND password", "Inane error",
					JOptionPane.ERROR_MESSAGE);
		} else if (UserDao.getCredentials(email, password)) {
			JOptionPane.showMessageDialog(frame, "Logged In");
		} else {
			JOptionPane.showMessageDialog(frame, "Invalid email or password", "Inane error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
