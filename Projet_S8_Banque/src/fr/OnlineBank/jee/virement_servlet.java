package fr.OnlineBank.jee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Class.Compte;
import dao.CompteDao;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**import Class.transaction;*/


/**
 * Servlet implementation class Login
 */
@WebServlet("/virement_servlet")
public class virement_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DAO vDAO= new DAO();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public virement_servlet() { 
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
		// récupérer les différents paramètres entrés dans le formulaire
		
		// ma partie (alexis)
		CompteDao compte = new CompteDao();
		
		int emet=Integer.parseInt(request.getParameter("emetteur"));
		int benef=Integer.parseInt(request.getParameter("beneficiaire"));
		int somme=Integer.parseInt(request.getParameter("montant"));
		
		Compte compteemetteur = compte.getCompte(emet);
		float solde = compteemetteur.getSolde();
		solde= solde-somme;
		if (solde>0) 
		{
		compteemetteur.setSolde(solde);
		compte.updateCompte(compteemetteur); //demande a etre en static
		
		Compte comptebenef = compte.getCompte(benef);
		float solde2= comptebenef.getSolde();
		solde2= solde2+somme;
		comptebenef.setSolde(solde2);
		compte.updateCompte(comptebenef);
		}
		
		else
		{
			//ecrire un message d'erreur en pop up
		}
		///
		
		
		
		
		String type = request.getParameter("type");
		
		
		
		
		int emetteur = 0;
		try {
			 emetteur = Integer.parseInt(request.getParameter("emetteur"));
			 System.out.println("toto"+emetteur);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		int beneficiaire = 0;// initialisation
		try {
			beneficiaire = Integer.parseInt(request.getParameter("beneficiaire"));//convertir la variable qui est au départ en string en Int et la récuperé
		} catch (NumberFormatException e) {// en cas d'erreur résoudre
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		String date_transaction= request.getParameter("date_transaction");// declarer une variable date_transaction et la recuperé en string par défaut
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// definition du format que je souhaite pour la date
		//surround below line with try catch block as below code throws checked exception
		Date date_transaction2 = null;//déclaration de variable de type date
		java.sql.Date sDate = null;//       ||      ||    ||    ||  ||  java.sql.Date
		try {
			date_transaction2 = sdf.parse(date_transaction);// convertir date_transaction(string) en (date) qui respecte le format prédéfinie
			 sDate = convertUtilToSql(date_transaction2);// recupere dans une nouvelle variable "sDate" la valeur convertie qui pourra etre insérer dans la base de données
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//java.sql.Date datee = new java.sql.Date(datee.getTime());
		
		
		
		
		String date_create= request.getParameter("date_create");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		//surround below line with try catch block as below code throws checked exception
		Date date_create2 = null;
		java.sql.Date sDate_create = null;
		try {
			date_create2 = sdf.parse(date_create);
			sDate_create = convertUtilToSql(date_create2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		
		
		
		float montant = Float.parseFloat(request.getParameter("montant"));
		
		
		
		
		
		String message= request.getParameter("message");
		
		
		
		
		
		vDAO.virement( type, emetteur, beneficiaire, sDate, sDate_create, montant, message);// fait reference à la méthode virement qui se trouve dans ma DAO
	}
	
	
	
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	private static java.sql.Date convertUtilToSql(java.util.Date uDate) {// Fonction qui permet de convertir la date en une version insérable dans la BDD
		
		        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
		
		        return sDate;//objet convertie
		
		    }


}
