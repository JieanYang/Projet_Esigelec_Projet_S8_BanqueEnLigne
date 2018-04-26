package fr.OnlineBank.jee;

import java.io.IOException;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

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
import dao.TransactionDao;
import dao.UserDao;
import Class.Actions;
import Class.Compte;
import Class.Entreprise;
import Class.Transaction;

import java.util.ArrayList;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		CompteDao compte = new CompteDao();
		int id_user = Integer.parseInt((String) session.getAttribute("id_user"));
		String type = request.getParameter("type");
		System.out.println(type);

		if (type.equals("Achat")) {
			float solde = compte.soldeCourant(id_user);
			System.out.println(solde);
			EntrepriseDAO entDAO = new EntrepriseDAO();
			ArrayList<Entreprise> listEnt = entDAO.getEnt();
			float somme = 0;
			int nombre = 0;
			int id_compte;
			for (int i = 0; i < listEnt.size(); i++) {// recuperation de la liste des actions que le client veux acheter
				System.out.println(listEnt.get(i).getNom());
				System.out.println(request.getParameter(listEnt.get(i).getNom()));
				if (request.getParameter(listEnt.get(i).getNom()) != "") {
					nombre = Integer.parseInt(request.getParameter(listEnt.get(i).getNom()));
				} else {
					nombre = 0;
					
				}
				if (nombre != 0) {
					somme = somme + nombre * listEnt.get(i).getDernier();// calcul du cout total
				} else {
					System.out.println("0");
				}

			}

			System.out.println(solde);

			if (somme < solde) {
				solde = solde - somme;
				Compte compteemetteur = compte.getCompteCourant(id_user);// utilise compteCourant pour recup le
																			// id_compte (mais ca marche pas)
				id_compte = compteemetteur.getId_compte();
				compteemetteur.setSolde(solde);
				compte.updateCompte(compteemetteur);
				for (int i = 0; i < listEnt.size(); i++) {
					if (request.getParameter(listEnt.get(i).getNom()) != "") {
						nombre = Integer.parseInt(request.getParameter(listEnt.get(i).getNom()));
					} else {
						nombre = 0;
					}
					if (nombre != 0) {
						String entreprise = listEnt.get(i).getNom();
						float prixachat = listEnt.get(i).getDernier();
						ActionsDAO dao = new ActionsDAO();
						Date date = new Date();
						java.sql.Date sqlDate = new java.sql.Date(date.getTime());
						System.out.println(id_user + entreprise + prixachat + sqlDate + nombre);
						// insetion dans la BDD des actions qu'il possede
						dao.ajout(id_user, entreprise, prixachat, sqlDate, nombre);
					}

				}
				Transaction transaction = new Transaction(0, "actions", id_compte, 999,
						new Timestamp(new Date().getTime()), null, somme, "achat d'actions");
				TransactionDao transactionDao = new TransactionDao();
				transactionDao.addTransaction(transaction);
			} else {
				System.out.println("erreur");
			}

			response.sendRedirect("Clientconnecte.jsp");
		}

		// fin de l'achat et debut de la partie vente

		else if (type.equals("Vente")) {
			EntrepriseDAO entDAO = new EntrepriseDAO();
			ArrayList<Entreprise> listEnt = entDAO.getEnt();
			float solde = compte.soldeCourant(id_user);
			int nombre = 0;
			int gain = 0;
			int nombreaction = 0;
			int diff = 0;
			int id_compte = 0;
			ActionsDAO dao = new ActionsDAO();
			for (int i = 0; i < listEnt.size(); i++) {
				if (request.getParameter(listEnt.get(i).getNom()) != "") {
					nombre = Integer.parseInt(request.getParameter(listEnt.get(i).getNom()));
				} else {
					nombre = 0;
				}
				if (nombre != 0) {
					nombreaction = dao.verif(id_user, listEnt.get(i).getNom());
					if (nombreaction > nombre) {
						gain = (int) (nombre * listEnt.get(i).getDernier());
						diff = nombreaction - nombre;
					} else {
						gain = (int) (nombreaction * listEnt.get(i).getDernier());
						diff = nombreaction - nombre;
					}
					// utilise compteCourant pour recup le id_compte
					Compte compteemetteur = compte.getCompteCourant(id_user);

					solde = solde + gain;
					compteemetteur.setSolde(solde);
					id_compte = compteemetteur.getId_compte();
					compte.updateCompte(compteemetteur);
					Actions action = dao.getAction(id_user, listEnt.get(i).getNom());
					action.setnombre(diff);
					dao.updatenombre(action);
					Transaction transaction = new Transaction(0, "actions", 999, id_compte,
							new Timestamp(new Date().getTime()), null, gain, "vente d'actions");
					TransactionDao transactionDao = new TransactionDao();
					transactionDao.addTransaction(transaction);
				}
			}
			dao.delete();
			response.sendRedirect("Clientconnecte.jsp");
		} else {
			System.out.println("erreur de merde");
			response.sendRedirect("affichageprix.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}