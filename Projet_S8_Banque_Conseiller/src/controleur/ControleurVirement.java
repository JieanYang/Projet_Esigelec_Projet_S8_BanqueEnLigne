package controleur;

import java.util.Vector;

import dto.Compte;
import socket.client.SocketClient;

public class ControleurVirement {

	private String messageDialog;

	public Vector<Compte> getClientAccount(int clientID) {
		Vector<Compte> listeCompte = new Vector<Compte>();
		String lCompte = SocketClient.startClient("listcompte" + "/" + clientID);
		String[] tabCompte = lCompte.split(";");
		for (int i = 1; i < tabCompte.length; i++) {
			String[] cInfo = tabCompte[i].split("/");
			Compte compte = new Compte();
			compte.setId_compte(Integer.parseInt(cInfo[0]));
			compte.setId_user(Integer.parseInt(cInfo[1]));
			compte.setCategorie_compte((cInfo[2]));
			compte.setEtat((cInfo[3]));
			compte.setSolde(Float.parseFloat((cInfo[4])));

			listeCompte.add(compte);
		}
		return listeCompte;
	}

	public boolean checkInput(String compteEmeteur, String somme) {
		try {
			Integer.parseInt(compteEmeteur);
			Float.parseFloat(somme);
			return true;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			this.setMessage("Invalid input");
		}
		return false;
	}

	public String getMessage() {
		return messageDialog;
	}

	public void setMessage(String messageD) {
		this.messageDialog = messageD;
	}

	public void addTransac(int compteEmeteur, int compteRecepteur, float somme, String description) {

		// get compte à créditer et ajouter la difference
		String compteC = SocketClient.startClient("getcompte" + "/" + compteRecepteur);
		String compteD = SocketClient.startClient("getcompte" + "/" + compteEmeteur);

		Compte compteCrediter = new Compte();
		String[] compte1 = compteC.split("/");
		compteCrediter.setId_compte(Integer.parseInt(compte1[0]));
		compteCrediter.setId_user(Integer.parseInt(compte1[1]));
		compteCrediter.setCategorie_compte(compte1[2]);
		compteCrediter.setEtat(compte1[3]);
		compteCrediter.setSolde(Float.parseFloat(compte1[4]));
		System.out.println("solde compte credite : " + compteCrediter.getSolde());

		Compte compteDebiter = new Compte();
		String[] compte2 = compteD.split("/");
		compteDebiter.setId_compte(Integer.parseInt(compte2[0]));
		compteDebiter.setId_user(Integer.parseInt(compte2[1]));
		compteDebiter.setCategorie_compte(compte2[2]);
		compteDebiter.setEtat(compte2[3]);
		compteDebiter.setSolde(Float.parseFloat(compte2[4]));
		System.out.println("solde compte debite : " + compteDebiter.getSolde());

		compteCrediter.setSolde(compteCrediter.getSolde() + somme);
		System.out.println("nouveau solde compte credite : " + compteCrediter.getSolde());
		SocketClient.startClient("updatecomptecrediter" + "/" + compteRecepteur + "/" + compteCrediter.getSolde());
		compteDebiter.setSolde(compteDebiter.getSolde() - somme);
		System.out.println("nouveau solde compte debite : " + compteDebiter.getSolde());
		SocketClient.startClient("updatecomptedebiter" + "/" + compteEmeteur + "/" + compteDebiter.getSolde());

		SocketClient.startClient("transaction" + "/" + compteDebiter.getId_compte() + "/"
				+ compteCrediter.getId_compte() + "/" + somme + "/" + description + "/" + "cheque");
	}

}
