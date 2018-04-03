package fr.OnlineBank.jee;

import Class.Message;
import Dao.MessageDao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Test {
	/*
	 * Print out the information of a message
	 */
	public static void bar(Message retour) {
		System.out.println("");
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
		/*
		 * Create an instance message and messageDao
		 * We don't give the value id_message and date
		 * because id_message and date will be filled by BDD or function .addMessage()
		 */
		
		
		/* test 1
		 * Message message1 = new Message(0, "one", "Monsieur", "1111111111", "1@gmail.com", "I don't want to be good, so?", null, null);

		Message message2 = new Message(0, "two", "Monsieur", "2222222222", "2@gmail.com", "I don't want to be bad, so?", null, null);
		MessageDao messageDao = new MessageDao();
		Message retour1 = new Message();
		Message retour2 = new Message();
		// add the message in the BDD by the methode messageDao.addMessage()
		retour1 = messageDao.addMessage(message1);
		retour2 = messageDao.addMessage(message2);
		System.out.println("addMessage ->");
		System.out.println("\nreour1 ->");
		bar(retour1);
		System.out.println("\nreour2 ->");
		bar(retour2);
		System.out.print("finish test 1");
		*/
		
		/* test 2
		 * Get all Messages in the BDD 
		 */
		// Create messageDao and List<Message>
		MessageDao messageDao = new MessageDao();
		List<Message> retour_list = new ArrayList<Message>();
		retour_list = messageDao.getListMessage();
		for(int i=0;i<retour_list.size();i++) {
			System.out.println("\nretour_list["+i+"] ->");
			bar(retour_list.get(i));
		}
		System.out.print("finish test 2");
		
		
		
		/* test 2->3
		 * Get a messge in the message_list
		 */
		// Get the first message -> index 0
		Message retour3 = messageDao.getMessage(retour_list.get(0).getId_message());
		System.out.println("");
		bar(retour3);
		System.out.print("finish test 3");

		/* test 4
		 * update a message
		 */
		retour3.setReponse("motherfucker, go away! please!");
		retour3 = messageDao.updateMessage(retour3); //return a message updated
		bar(retour3);
		// delete the reponse
		retour3.setReponse(null);
		retour3 = messageDao.updateMessage(retour3);
		bar (retour3);
		System.out.print("finish test 4");

		/* test 5
		 * Delete a message
		 */		
//		messageDao.deleteMessage(retour3);
		
		
	}

}
