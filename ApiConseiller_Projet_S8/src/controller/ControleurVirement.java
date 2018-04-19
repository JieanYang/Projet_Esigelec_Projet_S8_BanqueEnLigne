package controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import dao.CompteDao;
import dao.TransactionDao;
import dao.UserDao;
import dto.Compte;
import dto.Transaction;
import dto.User;

public class ControleurVirement {

	private TransactionDao transactionDAO = new TransactionDao();
	public CompteDao userDAO = new CompteDao();
	
	public Vector<Compte> getClientAccount(int clientID) {	
		return userDAO.getListCompteById_lient(clientID);
	}
	
	public void addTransac(int compteEmeteur, int compteRecepteur, float somme, String description) {
		Transaction transaction = new Transaction();
		transaction.setId_compte_emetteur(compteEmeteur);
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
