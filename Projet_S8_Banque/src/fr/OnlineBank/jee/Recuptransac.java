package fr.OnlineBank.jee;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CompteDao;
import dao.TransactionDao;

/**
 * Servlet implementation class Recuptransac
 */
@WebServlet("/Recuptransac")
public class Recuptransac extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	TransactionDao transaction= new TransactionDao();
	CompteDao compteDao = new CompteDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Recuptransac() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*String type = request.getParameter("type");
		int emetteur = Integer.parseInt(request.getParameter("emetteur") );
		int beneficiaire= Integer.parseInt(request.getParameter("beneficiaire"));
		
		Date date = request.getParameter("date");
		Float somme = request.getParameter("somme");
		String description = request.getParameter("description");

		
		TransactionDao.addTransaction(type, emetteur, beneficiaire, date, somme, description);
		
		SommeDao.emet(emetteur);
		SommeDao.benef(beneficiaire);*/
		
		
		compte= CompteaDao.getcompte();
		Compte.getcompte(emetteur);
		solde= compte.getsolde();
		solde= solde-somme;
		compte.setsolde(solde);
		CompteDao.update(compte);
		
		Compte.getcompte(beneficiaire);
		solde2= compte.getsolde();
		solde2= solde+somme;
		compte.setsolde(solde2);
		CompteDao.update(compte);
		
		compte= CompteaDao.getcompte();
		
	}
}