package servlet;

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
import dao.Offres;
import dao.offres_DAO;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**import Class.transaction;*/

/**
 * Servlet implementation class Login
 */
@WebServlet("/offres_servlet")
public class offres_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	offres_DAO oDAO = new offres_DAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public offres_servlet() {
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
		// param1 permet de faire le traitement dans la servlet avant d'aller sur la
		// page actualites
		String param = request.getParameter("param1");// recupere le "param1" passer dans l'href "index.jsp"
		System.out.println("le code est " + param);

		if (new String(param).equals("1"))// si c'est verifier, si param 1=1
		{
			ResultSet result = oDAO.getfourLastOffres();// on met dans l'objet result les 5 dernier actu grace à la
														// fonction get... crée dans DAO
			Offres offre = null;// objet actu de type actualite
			List<Offres> listOffres = new LinkedList<Offres>();// arraylist de type offres
			int compteur = 0;

			try {
				while (result.next())// on parcour le result
				{

					// pour chaque resultat qu'on trouve on creer un objet offre( le resultat regroupe les
					// 4 offres et l'objet offre represente dans l'ensemble des r�sultats une offre
					// qui a une date un title et un text
					offre = new Offres(result.getString("nom_service"), result.getString("description"));// methode get
																											// de la
																											// class
																											// actualite.java
					// on l'ajoute dans la liste de actualite "actu"
					listOffres.add(offre);

					compteur++;// la liste s'incrémente

				}
				// Si le compteur est positif c'est a dire qu'on a trouve des valeurs
				if (compteur > 0) {
					// on affiche le message

					request.setAttribute("liste", listOffres);// On met "listActu" dans "list" et transferer la variable
																// list dans la page
					// on redirige vers la jsp
					this.getServletContext().getRequestDispatcher("/Offres.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}