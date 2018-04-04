package dao;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.*;

import Class.Compte;
import dao.CompteDao;

public class testDao {
	
	public static void print(Compte compte) {
		System.out.println();
		System.out.println(compte.getId_compte());
		System.out.println(compte.getId_user());
		System.out.println(compte.getCategorie_compte());
		System.out.println(compte.getEtat());
		System.out.println(compte.getSolde());
		System.out.println(compte.getDate_create());
		System.out.println(compte.getDate_delete());
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
		
		
		long millis=System.currentTimeMillis();  
    	java.sql.Date date=new java.sql.Date(millis); 
    	System.out.println(date.toString());
		
    	CompteDao compteDao = new CompteDao();
    	Compte compte = new Compte();
		compte = new Compte(50, 1, "aaF","aaa",(float) 12.20,null, null);
//		compte = compteDao.addCompte(compte);
		
//    	compte = compteDao.getCompte(50);
//    	compte.setCategorie_compte("conseiller");
//    	compte.setEtat("cold");
//    	compte.setSolde(compte.getSolde()-20);
//    	compte.setDate_delete(date);
////    	
//
//    	compte = compteDao.updateCompte(compte);
//
//		List<Compte> list = new ArrayList<Compte>();
//		list = compteDao.getListCompte();
//		for(int i=0;i<list.size();i++)
//			print(list.get(i));
		compteDao.deleteCompte(compte);
		print(compte);
    	
		
	}
}
