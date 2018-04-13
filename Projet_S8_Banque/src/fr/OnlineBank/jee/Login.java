package fr.OnlineBank.jee;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Class.UpdateLogFile;
import dao.UserDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDao aDAO = new UserDao();
	UpdateLogFile updateLog = new UpdateLogFile();
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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
		
		String clientIP = request.getRemoteAddr();
		String serverIP = request.getLocalAddr();
		updateLog.checkExistingFile();
		Date date = new Date();

		boolean connexion = aDAO.getCredentials(email, password);
		
		if(connexion== true) {
			updateLog.editFile("Utilisateur: "+ email+" connecté le: "+dateFormat.format(date)+" /Ip client : "+clientIP+" /ServerIP : "+serverIP);
			request.getRequestDispatcher("pageContact.jsp").forward(request, response);
		}else {
			updateLog.editFile("Echec de connection de l'utilisateur "+email+" le: "+dateFormat.format(date)+" /Ip client : "+clientIP+" /ServerIP : "+serverIP);
			String message ="Votre email ou password est erroné !";
			request.getRequestDispatcher("pageCompteVerifie.jsp").forward(request, response);
		}
		
	}
}
