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
	 public static final int TAILLE_TAMPON = 10240;
	 public static final String CHEMIN_FICHIERS = "C:\\Users\\9201709\\Desktop\\projet_s8_banque\\Projet_S8_Banque"; // A changer
	
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
	
		int min =1000, max =9999 ;
		int nombreAleatoire = min + (int)(Math.random() * ((max - min) + 1));
		String code = ""+nombreAleatoire;
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email= request.getParameter("email");
		String psw= request.getParameter("password");
		String date1= request.getParameter("date");
		String categorie_user ="client";
		int telephone = 0;
		try {
			telephone = Integer.parseInt(request.getParameter("telephone"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String adresse = request.getParameter("adresse");
		String pays = request.getParameter("pays");
		String ville = request.getParameter("ville");
		// On récupère le champ du fichier
       // Part part = request.getPart("fichier");
            
        // On vérifie qu'on a bien reçu un fichier
      //  String nomFichier = getNomFichier(part);
		
		
		
		
		monEmail.envoie_mail(email, code);
		
		monDAO.creerCompteBancaire(psw,nom, prenom, telephone, email, adresse, date1, ville, pays,code,categorie_user);
		
		request.getRequestDispatcher("pageVerification.jsp").forward(request, response);
		
		
		
		
		
		
	}
	
	
	
	
	

}
