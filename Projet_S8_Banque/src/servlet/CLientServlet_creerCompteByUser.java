package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Class.Compte;
import Class.User;
import dao.CompteDao;
import dao.UserDao;

/**
 * Servlet implementation class CLientServlet_creerCompteByUser
 */
@WebServlet("/CLientServlet_creerCompteByUser")
public class CLientServlet_creerCompteByUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CLientServlet_creerCompteByUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: create compte by user").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id_user = request.getParameter("id_user");
		String categorie_compte = request.getParameter("categorieCompte");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String telephone = request.getParameter("telephone");
		String date_naissance= request.getParameter("dateNaissance");
		String adresse = request.getParameter("adresse");
		String email= request.getParameter("email");
		String ville = request.getParameter("ville");
		String pays = request.getParameter("pays");

		/*System.out.println(categorie_compte);
		System.out.println(nom);
		System.out.println(prenom);
		System.out.println(telephone);
		System.out.println(date_naissance);
		System.out.println(adresse);
		System.out.println(email);
		System.out.println(ville);
		System.out.println(pays);*/
		

		UserDao userDao = new UserDao();
		CompteDao compteDao = new CompteDao();
		User user = new User();
		Compte compte = new Compte();
		
		user = userDao.getUser(Integer.valueOf(id_user));
		//System.out.println(user.getEmail());
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setTelephone(telephone);
		user.setDateNaissance(date_naissance);
		user.setAdresse(adresse);
		//user.setEmail(email);
		user.setVille(ville);
		user.setPays(pays);
		
		compte.setId_user(user.getId_user());
		compte.setCategorie_compte(categorie_compte);
		compte.setEtat("active");
		compte.setSolde(0);
		
		userDao.updateUser(user);
		compteDao.addCompte(compte);
		
		//response.getWriter().write("finish");
		request.getRequestDispatcher("Clientconnecte.jsp").forward(request, response);
	}

}
