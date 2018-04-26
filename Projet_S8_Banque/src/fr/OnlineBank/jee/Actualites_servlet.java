package fr.OnlineBank.jee;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Class.Actualite;
import dao.DAO_Actu;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**import Class.transaction;*/


/**
 * Servlet implementation class Login
 */
@WebServlet("/Actualites_servlet")
public class Actualites_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 DAO_Actu bDAO = new DAO_Actu();
	 
	 
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Actualites_servlet() { 
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//param1 permet de faire le traitement dans la servlet avant d'aller sur la page actualites
		String param= request.getParameter("param1");// recupere le "param1" passer dans l'href "index.jsp"
		System.out.println("le code est "+param);
		
		if(new String(param).equals("1"))// si c'est verifier, si param 1=1
		{
			ResultSet result = bDAO.getFiveLastActualites();//on met dans l'objet result les 5 dernier actu grace a la fonction get... cree dans DAO
			Actualite actu = null;// objet actu de type actualite
			List<Actualite> listActu = new LinkedList<Actualite>();// arraylist de type actualite
			int compteur =0;
			
			try {
				while(result.next())// on parcour le result 
				{
					
					//pour chaque resultat trouve on creer un objet Actualite( le resultat regroupe les 5 actus et l'objet actu represente dans l'ensemble des reultats une actualite qui a une date un title et un text
					 actu= new Actualite(result.getDate("Date"), result.getString("Title"), result.getString("Text"));// methode get de la class actualite.java
					//on l'ajoute dans la liste de actualite "actu"
					 listActu.add(actu);
					
					 compteur++;// la liste d'incremente
					
					
				}
				//Si le compteur est positif c'est a dire qu'on a trouve des valeurs
				if(compteur>0){
					//on affiche le message 	
					
					request.setAttribute( "liste", listActu );//On met "listActu" dans "list" et transferer la variable list dans la page
					 //on redirige vers la jsp
					 this.getServletContext().getRequestDispatcher( "/Actualites.jsp" ).forward( request, response );
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// r茅cup茅rer les diff茅rents param猫tres entr茅s dans le formulaire
		
		
		
		String date= request.getParameter("date");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		//surround below line with try catch block as below code throws checked exception
		Date date2 = null;
		java.sql.Date date3 = null;
		try {
			date2 = sdf2.parse(date);
			date3 = convertUtilToSql(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String title= request.getParameter("title");

		
		String text= request.getParameter("text");

		bDAO.actualites ( date3, title, text);// fait reference a la methode actualites qui se trouve dans ma DAO
		
		response.sendRedirect("Manager_Page.jsp");
	}
	
	
	
	private static java.sql.Date convertUtilToSql(java.util.Date uDate) {// Fonction qui permet de convertir la date en une version ins茅rable dans la BDD
		
		        java.sql.Date Date3 = new java.sql.Date(uDate.getTime());
		
		        return Date3;//objet convertie
		
		    }


}

