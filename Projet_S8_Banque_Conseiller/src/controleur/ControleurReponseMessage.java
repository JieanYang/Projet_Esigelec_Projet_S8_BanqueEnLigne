package controleur;

import dto.Message;
import socket.client.SocketClient;

public class ControleurReponseMessage {

	public Message getDataMessage(int messageID) {
		Message message = new Message();
		String infoM = SocketClient.startClient("infomessage"+"/"+messageID);
		String[] tabDataMessage = infoM.split("/");
		System.out.println(infoM);
		message.setId_message(messageID);
		message.setNom(tabDataMessage[1]);
		message.setPrenom(tabDataMessage[2]);
		message.setNumphone(tabDataMessage[3]);
		message.setEmail(tabDataMessage[4]);
		message.setProblem(tabDataMessage[5]);
		return message;
	}
	
	public void envoyerReponse(int messageID, String reponse) {
		 SocketClient.startClient("reponsemessage"+"/"+messageID+"/"+reponse);
	}
	
}
