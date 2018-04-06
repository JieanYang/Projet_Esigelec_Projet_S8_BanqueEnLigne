package controller;

import java.util.Vector;

import dao.UserDao;
import dto.User;

public class ControleurListeClient {
	
	private UserDao userDAO = new UserDao();
	
	public Vector<User> getListClient(){
		Vector<User> listeClient = userDAO.getListUser();
		return listeClient;
	}
	
	public Vector<User> formatListClient(Vector<User> unformattedList) {
		Vector<User> formattedList = null;
		
		for(int i = 0; i<unformattedList.size() ; i++) {
			User user = new User();
			
			
			formattedList.add(user);
		}
		
		return formattedList;	
	}
}
