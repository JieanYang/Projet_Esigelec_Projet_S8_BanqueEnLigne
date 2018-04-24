package fr.OnlineBank.jee;

import java.io.IOException;

import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Class.User;
import dao.ActionsDAO;
import dao.CompteDao;
import dao.EntrepriseDAO;
import dao.UserDao;
import Class.Compte;
import Class.Entreprise;
import  java.util.ArrayList;
import java.util.Date;

/**
 * Servlet implementation class AjoutAction
 */
@WebServlet("/AjoutAction")
public class AjoutAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		CompteDao compte =new CompteDao();
		int id_user=Integer.parseInt((String) session.getAttribute("id_user"));
		float solde=compte.soldeCourant(id_user);
		EntrepriseDAO entDAO = new EntrepriseDAO();
		ArrayList<Entreprise> listEnt = entDAO.getEnt();
		float somme=0;
		int nombre=0;
		for (int i = 0; i < listEnt.size(); i++){
			System.out.println(listEnt.get(i).getNom());
			System.out.println(request.getParameter(listEnt.get(i).getNom()));
			if(request.getParameter(listEnt.get(i).getNom())!="") {
			nombre=Integer.parseInt(request.getParameter(listEnt.get(i).getNom()));
			}
			else {
				nombre=0;
			}
			if(nombre!=0) {
				somme=somme+nombre*listEnt.get(i).getDernier();
			}
			else {
				System.out.println("0");
			}
			
		}
		System.out.println(somme+""+solde+""+id_user);
		if(somme<solde) {
		solde=solde-somme;
		System.out.println(solde);
		Compte compteemetteur = compte.getCompte(1);//utilisé compteCourant pour recup le id_compte (mais ca marche pas)
		System.out.println(compteemetteur);
		compteemetteur.setSolde(solde);
		compte.updateCompte(compteemetteur);
		for (int i = 0; i < listEnt.size(); i++){
			System.out.println("test");
			if(request.getParameter(listEnt.get(i).getNom())!="") {
				nombre=Integer.parseInt(request.getParameter(listEnt.get(i).getNom()));
				}
				else {
					nombre=0;
				}
		if(nombre!=0) {
		String entreprise=listEnt.get(i).getNom();
		float prixachat=listEnt.get(i).getDernier();  
		ActionsDAO dao = new ActionsDAO();
		Date date = new Date();         
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		System.out.println(id_user+entreprise+prixachat+sqlDate+nombre);
		dao.ajout(id_user,entreprise,prixachat, sqlDate,nombre);
			}
		}
		}
		else {
			System.out.println("erreur");
		}
		response.sendRedirect("Clientconnecte.jsp");
}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		CompteDao compte =new CompteDao();
		int id_user=Integer.parseInt((String) session.getAttribute("id_user"));
		float solde=compte.soldeCourant(id_user);
		EntrepriseDAO entDAO = new EntrepriseDAO();
		ArrayList<Entreprise> listEnt = entDAO.getEnt();
		float somme=0;
		for (int i = 0; i < listEnt.size(); i++){
			System.out.println(listEnt.get(i).getNom());
			System.out.println(request.getParameter(listEnt.get(i).getNom()));
			int nombre=Integer.parseInt(request.getParameter(listEnt.get(i).getNom()));//"nb"+String.valueOf(i)
			if(nombre!=(Integer)null) { //ou "nb"+i!=""
				somme=somme+nombre*listEnt.get(i).getDernier();
			}
			else {
				System.out.println(request.getParameter(listEnt.get(i).getNom()));
			}
			
		}
		System.out.println(somme);
		if(somme<solde) {
		solde=solde-somme;
		
		
		for (int i = 0; i < listEnt.size(); i++)while(i< listEnt.size() ) {
		
		int nombre=Integer.parseInt(request.getParameter("nb"+i));
		if(nombre!=(Integer)null) {
		String entreprise=listEnt.get(i).getNom();
		float prixachat=listEnt.get(i).getDernier();
		Timestamp stamp = new Timestamp(System.currentTimeMillis());
		Date date = new Date(stamp.getTime());
		ActionsDAO dao = new ActionsDAO();
		dao.ajout(id_user,entreprise,prixachat,(java.sql.Date) date,nombre);
		
			}
		}
		}
		else {
			System.out.println("erreur");
		}
		response.sendRedirect("Clientconnecte.jsp");
}
}
