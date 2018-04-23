package servlet;

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

import Class.Compte;
import Class.User;
import dao.UserDao;



/**
 * Servlet implementation class modification
 */


@WebServlet("/modification")
public class modification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modification() {
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
		
		// Session
		HttpSession session = request.getSession();
		String id_user = (String)session.getAttribute("id_user");
		// Take data of user old
		User user = new User();
		UserDao userDao = new UserDao();
		user = userDao.getUser(Integer.valueOf(id_user));

		/*System.out.println(user.getId_user());
		System.out.println(user.getCategorie_user());
		System.out.println(user.getNom());
		System.out.println(user.getPrenom());
		System.out.println(user.getEmail());
		System.out.println(user.getAdresse());
		System.out.println(user.getTelephone());
		System.out.println(user.getVille());
		System.out.println(user.getPays());
		System.out.println(user.getPassword());
		System.out.println(user.getDateNaissance()+"\n");*/
		
		// Take data form the form
		String id = request.getParameter("id");
		String date_naissance = request.getParameter("dateNaissance");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String password = request.getParameter("password");
		String telephone = request.getParameter("telephone");
		String adresse = request.getParameter("adresse");
		String email = request.getParameter("email");
		String ville = request.getParameter("ville");
		String pays = request.getParameter("pays");
		
		/*System.out.println(id);
		System.out.println(date_naissance);
		System.out.println(nom);
		System.out.println(prenom);
		System.out.println(password);
		System.out.println(telephone);
		System.out.println(adresse);
		System.out.println(email);
		System.out.println(ville);
		System.out.println(pays+"\n");*/
		
		// Change the data in the class User
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setPassword(password);
		user.setTelephone(telephone);
		user.setAdresse(adresse);
		user.setEmail(email);
		user.setVille(ville);
		user.setPays(pays);
		
		/*System.out.println(user.getId_user());
		System.out.println(user.getCategorie_user());
		System.out.println(user.getNom());
		System.out.println(user.getPrenom());
		System.out.println(user.getEmail());
		System.out.println(user.getAdresse());
		System.out.println(user.getTelephone());
		System.out.println(user.getVille());
		System.out.println(user.getPays());
		System.out.println(user.getPassword());
		System.out.println(user.getDateNaissance()+"\n");*/
	
		// Update database
		userDao.updateUser(user); //demande a etre en static
		
		
		response.sendRedirect("Clientconnecte.jsp");
	}

}
