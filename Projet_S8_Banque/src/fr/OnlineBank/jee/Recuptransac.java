package fr.OnlineBank.jee;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Class.Compte;
import dao.CompteDao;
import dao.TransactionDao;

/**
 * Servlet implementation class Recuptransac
 */
@WebServlet("/Recuptransac")
public class Recuptransac extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CompteDao compte = new CompteDao();
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
		
		int emetteur=Integer.parseInt(request.getParameter("emetteur"));
		int beneficiaire=Integer.parseInt(request.getParameter("beneficiaire"));
		int somme=Integer.parseInt(request.getParameter("somme"));
		
		Compte compteemetteur = compte.getCompte(emetteur);
		float solde = compteemetteur.getSolde();
		solde= solde-somme;
		compteemetteur.setSolde(solde);
		CompteDao.updateCompte(compteemetteur); //demande a etre en static
		
		Compte comptebenef = compte.getCompte(beneficiaire);
		float solde2= comptebenef.getSolde();
		solde2= solde+somme;
		comptebenef.setSolde(solde2);
		CompteDao.updateCompte(comptebenef);
		
		compte= CompteaDao.getcompte(); //a quoi ca sert ?
		
	}
}