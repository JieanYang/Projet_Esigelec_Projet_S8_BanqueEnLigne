package controleur;

import java.util.Vector;

import dto.User;
import socket.client.SocketClient;

public class ControleurListeClient {
	
	public Vector<User> getListClient(){
		Vector<User> listeClient = new Vector<User>();
		String lClient = SocketClient.startClient("listclient");
		String[] tabClient = lClient.split(";");
		for(int i = 1; i< tabClient.length ;i++) {
			String[] clInfo = tabClient[i].split("/");
			User user = new User();
			
			user.setId_user(Integer.parseInt(clInfo[0]));
			user.setNom(clInfo[1]);
			user.setPrenom(clInfo[2]);
			user.setEmail(clInfo[3]);
			user.setAdresse(clInfo[4]);
			user.setTelephone(clInfo[5]);
			user.setVille(clInfo[6]);
			user.setPays(clInfo[7]);
			user.setStringNaissance(clInfo[8]);

			listeClient.add(user);
		}
		return listeClient;
	}
}
