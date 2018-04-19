package controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;

import dao.CompteDao;
import dao.TransactionDao;
import dto.Compte;
import dto.Transaction;

public class ControleurVirement {

	private TransactionDao transactionDAO = new TransactionDao();
	public CompteDao compteDAO = new CompteDao();
	private String message;
	
	public Vector<Compte> getClientAccount(int clientID) {	
		return compteDAO.getListCompteById_lient(clientID);
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
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void addTransac(int compteEmeteur, int compteRecepteur, float somme, String description) {
		
		//get compte à créditer et ajouter la différence
		Compte compteCrediter = new Compte();
		Compte compteDebiter = new Compte();
		compteCrediter = compteDAO.getCompte(compteRecepteur);
		compteDebiter = compteDAO.getCompte(4321);
		compteCrediter.setSolde(compteCrediter.getSolde()+somme);
		compteDebiter.setSolde(compteDebiter.getSolde()-somme);
		compteDAO.updateCompte(compteCrediter);
		compteDAO.updateCompte(compteDebiter);
		
		Transaction transaction = new Transaction();
		transaction.setId_compte_emetteur(4321);
		transaction.setId_compte_recepteur(compteRecepteur);
		transaction.setSomme(somme);
		transaction.setDescription(description);
		Date utildate = new Date();         
    	Timestamp sqldate = new Timestamp(utildate.getTime()); 
    	transaction.setDate_transaction(sqldate);
    	transaction.setCategorie_transaction("cheque");
		transactionDAO.addTransaction(transaction);
	}
	
}
