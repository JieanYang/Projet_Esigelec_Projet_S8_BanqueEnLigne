package fr.OnlineBank.jee;

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
		HttpSession session=request.getSession();
		//int id_emmetteur=Integer.parseInt(request.getParameter("id"));//il faut recup id_emetteur avec la session
		int id_client=(Integer) session.getAttribute("id_client");//permet de recup id_emmetteur
		
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String email=request.getParameter("email");
		String adresse=request.getParameter("adresse");
		String telephone=request.getParameter("telephone");
		String ville=request.getParameter("ville");
		String pays=request.getParameter("pays");
		String password=request.getParameter("password");
		String dateN=request.getParameter("ville");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mi:ss");
		Date dateNaissance = null;
		try {
			dateNaissance = (Date) sdf.parse(dateN);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		User user =new User();
		UserDao dao = new UserDao();
		
		user =dao.getUser(id_client);
		
		user.setAdresse(adresse);
		user.setDateNaissance(dateNaissance);
		user.setEmail(email);
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setPassword(password);
		user.setPays(pays);
		user.setTelephone(telephone);
		user.setVille(ville);
		
		dao.updateUser(user); //demande a etre en static
	}

}
