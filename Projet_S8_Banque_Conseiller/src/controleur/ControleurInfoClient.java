package controleur;

import dto.User;
import socket.client.SocketClient;

public class ControleurInfoClient {
	
	public User getDataClient(int clientID) {
		User client = new User();
		String infoC = SocketClient.startClient("infoclient"+"/"+clientID);
		String[] tabDataClient = infoC.split("/");
		
		client.setId_user(clientID);
		client.setNom(tabDataClient[1]);
		client.setPrenom(tabDataClient[2]);
		client.setEmail(tabDataClient[3]);
		client.setAdresse(tabDataClient[4]);
		client.setTelephone(tabDataClient[5]);
		client.setVille(tabDataClient[6]);
		client.setPays(tabDataClient[7]);
		client.setStringNaissance(tabDataClient[8]);
		
		return client;
	}

}
