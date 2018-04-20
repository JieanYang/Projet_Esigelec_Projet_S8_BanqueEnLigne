package dao;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.*;

import Class.User;
import dao.UserDao;

public class testDao {
	
	public static void print(User user) {
		System.out.println();
		System.out.println(user.getId_user());
		System.out.println(user.getCategorie_user());
		System.out.println(user.getNom());
		System.out.println(user.getPrenom());
		System.out.println(user.getEmail());
		System.out.println(user.getAdresse());
		System.out.println(user.getTelephone());
		System.out.println(user.getVille());
		System.out.println(user.getPays());
		System.out.println(user.getPassword());
		System.out.println(user.getDateNaissance());
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

		
		
		
//		Date utildate = new Date();         
//    	Timestamp sqldate = new Timestamp(utildate.getTime()); 
		
		Timestamp stamp = new Timestamp(System.currentTimeMillis());
		java.sql.Date date = new java.sql.Date(stamp.getTime());
		System.out.println(date);

		
    	UserDao userDao = new UserDao();
    	User user = new User();
		user = new User(1, "client", "nom", "prenom", "d@com","adress","93784956", "rouen", "France", "password", date.toString());

//		user = userDao.addUser(user);
		
//    	user = userDao.getUser(1);
//    	user.setCategorie_user("conseiller");
//    	user.setNom("nom22222");
//    	user.setPrenom("prenom2222");
//    	user.setEmail("I don't have emailaaaa");
//    	user.setAdresse("my home is in the city");
//    	user.setTelephone("000000000000001111111111111111");
//    	user.setVille("underground");
//    	user.setPays("China");
//    	user.setPassword("password222222222222222222");
//    	user = userDao.updateUser(user);
//
//		List<User> list = new ArrayList<User>();
//		list = userDao.getListUser();
//		for(int i=0;i<list.size();i++)
//			print(list.get(i));
		userDao.deleteUser(user);
//		print(user);
    	
		
	}
}
