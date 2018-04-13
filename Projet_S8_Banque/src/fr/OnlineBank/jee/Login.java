package fr.OnlineBank.jee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDao aDAO = new UserDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		boolean connexion = aDAO.getCredentials(email, password);
		
		
		if(connexion== true) {
			this.logIn(request, response);
			request.getRequestDispatcher("Clientconnecte.jsp").forward(request, response);
		}else {
			String message ="Votre email ou password est erroné !";
			request.getRequestDispatcher("pageCompteVerifie.jsp").forward(request, response);
		}
		
	}
	
	
	protected void logIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("login");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String id_user = ""+aDAO.getIdUser(email, password);
		
		// Session
		HttpSession session = request.getSession();
		session.setAttribute("login", "login");
		session.setAttribute("id_user", id_user);

		
		
	}
	
	
	/* logOut -> remove session "login" and "id_user"*/
	protected void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("logout");
		// Session
		HttpSession session = request.getSession();
		session.setAttribute("login", null);
		session.removeAttribute("id_user");


		RequestDispatcher rd;
		rd = getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}
	
	
}
