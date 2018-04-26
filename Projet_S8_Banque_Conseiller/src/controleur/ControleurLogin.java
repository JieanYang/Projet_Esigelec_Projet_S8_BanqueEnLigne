package controleur;

import java.awt.Component;
import javax.swing.JOptionPane;

import controleur.MainControleur;
import socket.client.SocketClient;


public class ControleurLogin {

	private static Component frame;
	
//	private UserDao conseillerDAO = new UserDao();

	public void checkCredentials(String email, String password) {
		if (email.equals("") || password.equals("")) {
			JOptionPane.showMessageDialog(frame, "Les deux champs doivent être renseigné", "Inane error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			String loginCheck = SocketClient.startClient("login"+"/"+email+"/"+password);
			if(loginCheck.equals("valid")) {
				String conseillerInfo = SocketClient.startClient("utilisateur"+"/"+email);
				String[] cInfos = conseillerInfo.split("/");
				MainControleur.conseiller.setNom(cInfos[0]);
				MainControleur.conseiller.setPrenom(cInfos[1]);
				// redirect
				MainControleur.menuPanel();
			}else {
				JOptionPane.showMessageDialog(frame, "Indentifiants invalide", "Inane error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
