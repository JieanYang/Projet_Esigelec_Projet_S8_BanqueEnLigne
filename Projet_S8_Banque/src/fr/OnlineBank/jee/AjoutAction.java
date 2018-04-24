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
import dao.UserDao;
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
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ArrayList<Entreprise> listEnt = (ArrayList<Entreprise>) request.getAttribute("listEnt");
		CompteDao compte =new CompteDao();
		int id_user=Integer.parseInt((String) session.getAttribute("id_user"));
		float solde=compte.soldeCourant(id_user);
		float somme=0;
		for (int i = 0; i < listEnt.size(); i++){
			int nombre=Integer.parseInt(request.getParameter("nb"+i));
			if(nombre!=(Integer)null) { //ou "nb"+i!=""
				somme=somme+nombre*listEnt.get(i).getDernier();
			}
			
		}
		System.out.println(somme);
		if(somme<solde) {
		
		
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
