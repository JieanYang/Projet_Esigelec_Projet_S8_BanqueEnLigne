package controleur;

import java.util.Vector;

import dto.Message;
import socket.client.SocketClient;

public class ControleurListeMessage {

	public Vector<Message> getListMessage() {
		Vector<Message> listeMessage = new Vector<Message>();
		String lMessage = SocketClient.startClient("listmessage");
		String[] tabMessage = lMessage.split(";");
		for (int i = 1; i < tabMessage.length; i++) {
			String[] mlInfo = tabMessage[i].split("/");
			Message message = new Message();
			
			message.setId_message(Integer.parseInt(mlInfo[0]));
			message.setNom(mlInfo[1]);
			message.setPrenom(mlInfo[2]);
			message.setNumphone(mlInfo[3]);
			message.setEmail(mlInfo[4]);
			message.setProblem(mlInfo[5]);
			listeMessage.add(message);
		}
		return listeMessage;
	}
}
