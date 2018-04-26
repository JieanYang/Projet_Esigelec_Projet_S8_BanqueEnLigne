package servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Class.Compte;
import Class.Transaction;
import dao.CompteDao;
import dao.TransactionDao;
import fr.OnlineBank.jee.DAO;

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

	DAO vDAO = new DAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public virement_servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		// recupeer les diffeents parametres entre dans le formulaire
		// ma partie (alexis)
		
		// parameters from form in the page
		int emetteur = 0;
		if (request.getParameter("emetteur").equals("")) {
			emetteur = 0;
		} else {
			emetteur = Integer.parseInt(request.getParameter("emetteur"));
		}
		int beneficiaire = 0;
		if (request.getParameter("beneficiaire").equals("")) {
			beneficiaire = 0;
		} else {
			beneficiaire = Integer.parseInt(request.getParameter("beneficiaire"));
		}
		String type = request.getParameter("type");
		float montant = Float.parseFloat(request.getParameter("montant"));
		String message= request.getParameter("message");
		String date_transaction = request.getParameter("date_transaction");
		
		//handle the data transaction
		//date_transaction = request.getParameter("date_transaction");// declarer une variable date_transaction et
		// la recupere en string par debut
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// definition du format que je souhaite pour la date
		// surround below line with try catch block as below code throws checked
		// exception
		Date date_transaction2 = null;// d閏laration de variable de type date
		java.sql.Date sDate = null;// || || || || || java.sql.Date
		try {
			date_transaction2 = sdf.parse(date_transaction);// convertir date_transaction(string) en (date) qui respecte
			// le format pr閐閒inie
			sDate = convertUtilToSql(date_transaction2);// recupere dans une nouvelle variable "sDate" la valeur
			// convertie qui pourra etre ins閞er dans la base de donn閑s
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		/*System.out.println(type);
		System.out.println(emetteur);
		System.out.println(beneficiaire);
		System.out.println(montant);
		System.out.println(message);
		System.out.println("after change type:"+sDate);*/
		
		
		//Take comptes emetteur and recepteur
		CompteDao compteDao = new CompteDao();
		Compte compte_emetteur = null;
		Compte compte_recepteur = null;
		compte_emetteur = compteDao.getCompte(emetteur);
		compte_recepteur = compteDao.getCompte(beneficiaire);
		
		String categorie_transaction = "";
		
		if(compte_emetteur != null && compte_recepteur != null) {
			// commerce between two compte
			compte_emetteur.setSolde(compte_emetteur.getSolde()-montant);
			compte_recepteur.setSolde(compte_recepteur.getSolde()+montant);
			categorie_transaction = "commerce";
		} else if (compte_emetteur != null && compte_recepteur == null) {
			// extract cash
			categorie_transaction = "extract";
			compte_emetteur.setSolde(compte_emetteur.getSolde()-montant);
		} else if (compte_emetteur == null && compte_recepteur != null) {
			// charge cash
			compte_recepteur.setSolde(compte_recepteur.getSolde()+montant);
			categorie_transaction = "charge";
		}
		
		// New transaction		
		Transaction transaction = new Transaction(0, categorie_transaction, emetteur, beneficiaire, new Timestamp(sDate.getTime()), null, montant, message);
		// It must have a id of compte is 999 indicate the banque autre
		if(emetteur == 0) {
			transaction.setId_compte_emetteur(999);
		} else if(beneficiaire == 0) {
			transaction.setId_compte_recepteur(999);
		}
		
		TransactionDao transactionDao = new TransactionDao();

		/*System.out.println("id_transcation:"+transaction.getId_transaction());
		System.out.println("categorie_transaction:"+transaction.getCategorie_transaction());
		System.out.println("id_emetteur:"+transaction.getId_compte_emetteur());
		System.out.println("id_recepteur:"+transaction.getId_compte_recepteur());
		System.out.println("date_trasnaction:"+transaction.getDate_transaction());
		System.out.println("date_create:"+transaction.getDate_create());
		System.out.println("somme:"+transaction.getSomme());
		System.out.println("description:"+transaction.getDescription());*/
		
		// Update the data in the database
		transactionDao.addTransaction(transaction);
		compteDao.updateCompte(compte_emetteur);
		compteDao.updateCompte(compte_recepteur);
		
		
		response.sendRedirect("Clientconnecte.jsp");
		//response.getWriter().append("Served at: virement ").append(request.getContextPath());
		
		
		
		/*float solde = compteemetteur.getSolde();
		solde = solde - somme;
		if (solde > 0) {
			compteemetteur.setSolde(solde);
			compte.updateCompte(compteemetteur); // demande a etre en static

			Compte comptebenef = compte.getCompte(benef);
			float solde2 = comptebenef.getSolde();
			solde2 = solde2 + somme;
			comptebenef.setSolde(solde2);
			compte.updateCompte(comptebenef);
		}

		else {
			// ecrire un message d'erreur en pop up
		}


		type = request.getParameter("type");

		int emetteur = 0;
		try {
			emetteur = Integer.parseInt(request.getParameter("emetteur"));
			System.out.println("toto" + emetteur);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int beneficiaire = 0;// initialisation
		try {
			beneficiaire = Integer.parseInt(request.getParameter("beneficiaire"));// convertir la variable qui est au
																					// deart en string en Int et la
																					// recupere
		} catch (NumberFormatException e) {// en cas d'erreur r閟oudre
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		
		

		// java.sql.Date datee = new java.sql.Date(datee.getTime());
		/**
		 * date_create will create automatically by TransactionDao
		 */
		/*String date_create = request.getParameter("date_create");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		// surround below line with try catch block as below code throws checked
		// exception
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
		
		vDAO.virement( type, emetteur, beneficiaire, sDate, sDate_create, montant, message);*/// fait reference a la mehode virement qui se trouve dans ma DAO

		
	}

	private static java.sql.Date convertUtilToSql(java.util.Date uDate) {// Fonction qui permet de convertir la date en
																			// une version ins閞able dans la BDD

		java.sql.Date sDate = new java.sql.Date(uDate.getTime());

		return sDate;// objet convertie

	}

}
