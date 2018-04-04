package dao;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.*;

import Class.Transaction;
import dao.TransactionDao;

public class testDao {
	
	public static void print(Transaction transaction) {
		System.out.println();
		System.out.println(transaction.getId_transaction());
		System.out.println(transaction.getCategorie_transaction());
		System.out.println(transaction.getId_compte_emetteur());
		System.out.println(transaction.getId_compte_recepteur());
		System.out.println(transaction.getDate_transaction());
		System.out.println(transaction.getDate_create());
		System.out.println(transaction.getSomme());
		System.out.println(transaction.getDescription());
	}
	
	public static void main(String[] args) {
//		Fenetre f = new Fenetre();
//		Panels_conseiller p = new Panels_conseiller(f);
//		f.setPanel(p.get_P_listOfMessage());
		
//		Date utildate = new Date(); 
//		System.out.println(utildate);
//    	DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    	String datetostr = format.format(utildate);
//		System.out.println(datetostr);
//		Date newdate = format.parse(datetostr);
//		System.out.println(newdate);

    	
//		Timestamp sqldate = new Timestamp(utildate.getTime());
//		System.out.println(sqldate);
//		
//		Timestamp stamp = new Timestamp(System.currentTimeMillis());
//		Date date = new Date(stamp.getTime());
//		System.out.println(date);
		
		
		
		Date utildate = new Date();         
    	Timestamp sqldate = new Timestamp(utildate.getTime()); 

		
    	TransactionDao transactionDao = new TransactionDao();
    	Transaction transaction = new Transaction();
		transaction = new Transaction(7, "Cash", 47, 48, sqldate,null,(float) 34.4, "nothing is good");

//		transaction = transactionDao.addTransaction(transaction);
		
//    	transaction = transactionDao.getTransaction(6);
//    	transaction.setCategorie_transaction("cards");
//    	transaction.setId_compte_emetteur(50);
//    	transaction.setId_compte_recepteur(51);
//    	transaction.setSomme((float) 1.111);
//    	transaction.setDescription("!!!!!!!!!!!!I have a word!");
////    	
//
//    	transaction = transactionDao.updateTransaction(transaction);
//
//		List<Transaction> list = new ArrayList<Transaction>();
//		list = transactionDao.getListTransaction();
//		for(int i=0;i<list.size();i++)
//			print(list.get(i));
		transactionDao.deleteTransaction(transaction);
//		print(transaction);
    	
		
	}
}
