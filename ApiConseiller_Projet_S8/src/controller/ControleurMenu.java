package controller;

import dao.UserDao;
import dto.User;

public class ControleurMenu {
	
	private UserDao userDAO = new UserDao();

	public User getConseillerInfo(String email) {
		return userDAO.getCurrentUser(email);
	}
}