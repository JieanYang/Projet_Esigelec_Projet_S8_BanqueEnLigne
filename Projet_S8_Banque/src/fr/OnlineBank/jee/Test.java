package fr.OnlineBank.jee;

import Class.Message;
import Dao.MessageDao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Test {
	
	public static void bar(Message retour) {
		System.out.println(retour.getId_message());
		System.out.println(retour.getNom());
		System.out.println(retour.getPrenom());
		System.out.println(retour.getNumphone());
		System.out.println(retour.getEmail());
		System.out.println(retour.getProblem());
		System.out.println(retour.getReponse());
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		System.out.println(ft.format(retour.getDate()));
	}

	public static void main(String[] args) {
		MessageDao messageDao = new MessageDao();
		Message message = new Message(5, "Yang", "Jiean", "0698122254", "yja8534786@gmail.com", "I don't want to be bad, so?", null, null);
		List<Message> retour = new ArrayList<Message>();
//		retour = messageDao.getMessage(3);
//		retour.setEmail("a@gmail.com");
//		retour.setNumphone("111111111");
//		retour.setReponse("motherfucker");
//		retour = messageDao.updateMessage(retour);
		retour = messageDao.getListMessage();
		
		for(int i=0;i<retour.size();i++)
			bar(retour.get(i));
		
		messageDao.deleteMessage(retour.get(1));
		
		System.out.print("finish");
	}

}
