package fr.OnlineBank.jee;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

			this.logIn(request, response);
			updateLog.editFile("Utilisateur: "+ email+" connecte le: "+dateFormat.format(date)+" /Ip client : "+clientIP+" /ServerIP : "+serverIP);
			request.getRequestDispatcher("Clientconnecte.jsp").forward(request, response);

		}else {
			updateLog.editFile("Echec de connection de l'utilisateur "+email+" le: "+dateFormat.format(date)+" /Ip client : "+clientIP+" /ServerIP : "+serverIP);
			String message ="Votre email ou password est errone !";
			request.getRequestDispatcher("index.jsp").forward(request, response);
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
	
	
	public  String getEncodedPassword(String password)
	{
			  byte[] uniqueKey = password.getBytes();
			  byte[] hash = null;
		try
			{
				hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
			}
		
		catch (NoSuchAlgorithmException e)
			{
				throw new Error("no MD5 support in this VM");
			}
		
			  StringBuffer hashString = new StringBuffer();
			  	for ( int i = 0; i < hash.length; ++i )
			  		{
			  			String hex = Integer.toHexString(hash[i]);
			  				if ( hex.length() == 1 )
			  					{
			  						hashString.append('0');
			  						hashString.append(hex.charAt(hex.length()-1));
			  					}
			  				
			  				else
			  					{
			  						hashString.append(hex.substring(hex.length()-2));
			  					}
			  		}
			  	
			 return hashString.toString();
			 
		}
		
	
	
}
