package controleur;

import socket.client.SocketClient;

public class ControleurOffre {

	public void addOffre(String titre, String description) {
		SocketClient.startClient("ajouteroffre" + "/" + titre + "/" + description);
	}

}
