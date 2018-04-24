package fr.OnlineBank.jee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Class.User;
import dao.UserDao;

/**
 * Servlet implementation class Achat_servlet
 */
@WebServlet("/Achat_servlet")
public class Achat_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Achat_servlet() {
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
		
		for (int i = 0; i < listEnt.size(); i++)while(i< listEnt.size() ) {
			
		}
		int id=Integer.parseInt(request.getParameter("id"));
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String email=request.getParameter("email");
		String adresse=request.getParameter("adresse");
		String telephone=request.getParameter("telephone");
		String ville=request.getParameter("ville");
		String pays=request.getParameter("pays");
		String password=request.getParameter("password");
		
		User user =new User();
		UserDao dao = new UserDao();
		
		user =dao.getUser(id);
		
		user.setAdresse(adresse);
		user.setEmail(email);
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setPassword(password);
		user.setPays(pays);
		user.setTelephone(telephone);
		user.setVille(ville);
		
		dao.updateUser(user); //demande a etre en static
		
		
		response.sendRedirect("Clientconnecte.jsp");
	}

}
