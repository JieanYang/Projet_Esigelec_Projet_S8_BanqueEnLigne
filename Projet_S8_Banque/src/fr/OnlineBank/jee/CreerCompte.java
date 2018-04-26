package fr.OnlineBank.jee;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import SendEmail.EmailSend;
import dao.CompteDao;

/**
 * Servlet implementation class creerCompte
 */
@WebServlet("/CreerCompte")
public class CreerCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CompteDao monDAO= new CompteDao();
	EmailSend monEmail = new EmailSend();
	  // A changer
	
//	  SimpleDateFormat sdfrmt = new SimpleDateFormat("dd-MM-yyyy");
//	     sdfrmt.setLenient(false);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreerCompte() {
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
	
		// Generer un code aleatoire entre 1000 et 9999
		int min =1000, max =9999 ;
		int nombreAleatoire = min + (int)(Math.random() * ((max - min) + 1));
		String code = ""+nombreAleatoire;
		
		// recuperer le nom
		String nom = request.getParameter("nom");
		// recuperer le prenom
		String prenom = request.getParameter("prenom");
		// recuperer le email
		String email= request.getParameter("email");
		// recuperer la date
		String date1= request.getParameter("date");
		// recuperer le mot de passe
		String password = request.getParameter("password");
		// definir comme client la categorie_user
		String categorie_user ="client";
		int telephone = 0;
		try {
			// recuperer le numero de Telephone
			telephone = Integer.parseInt(request.getParameter("telephone"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// reuperer l'adresse
		String adresse = request.getParameter("adresse");
		// reuperer le pays
		String pays = request.getParameter("pays");
		// reuperer la ville
		String ville = request.getParameter("ville");
	
		// envoies du code par mail
		monEmail.envoie_mail(email, code);
		
		// on insere dans la BDD toutes les informations recuperées
		monDAO.creerCompteBancaire(password,nom, prenom, telephone, email, adresse, date1, ville, pays,code,categorie_user);
		
		// on va a la page de Verification
		request.getRequestDispatcher("pageVerification.jsp").forward(request, response);
		

	}
	
	
	

}
