package controller;

import java.util.ArrayList;

import dao.UserDao;
import dto.User;

public class ControleurInfoClient {
	
	public UserDao userDAO = new UserDao();
	
	public User getDataClient(int clientID) {	
		return userDAO.getClientInfo(clientID);
	}

}
