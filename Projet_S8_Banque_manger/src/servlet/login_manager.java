package servlet;

import java.io.IOException;
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
 * Servlet implementation class login_manager
 */
@WebServlet("/login_manager")
public class login_manager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login_manager() {
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

	
	/*public static void main(String[] args) throws ServletException, IOException {
		login_manager login = new login_manager();
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		login.doPost(request, response);
	}*/
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String clientIP = request.getRemoteAddr();
		String serverIP = request.getLocalAddr();
		
		UserDao userDao = new UserDao();
		UpdateLogFile updateLog = new UpdateLogFile();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		HttpSession session = request.getSession();
		
		updateLog.checkExistingFile();
		Date date = new Date();
		
		int id_user = userDao.getId_byAuthentification(email, password);
		
		if(id_user != -1) {
			
			
			// Session
			session.setAttribute("login", "login");
			session.setAttribute("id_user", id_user);
			
			updateLog.editFile("Utilisateur: "+ email+" connecte le: "+dateFormat.format(date)+" /Ip client : "+clientIP+" /ServerIP : "+serverIP);
			request.getRequestDispatcher("extractDataClients.jsp").forward(request, response);
			response.getWriter().write("success -> id_User:" +id_user+"<br>login->"+email+", password->"+password);
		} else {
			// Session
			session.setAttribute("login", null);
			session.setAttribute("id_user", -1);
			
			updateLog.editFile("Echec de connection de l'utilisateur "+email+" le: "+dateFormat.format(date)+" /Ip client : "+clientIP+" /ServerIP : "+serverIP);
			String message ="Votre email ou password est erron� !";
			response.getWriter().write("Faild->id_User:" +id_user+"<br>login->"+email+", password->"+password);
		}
		
		
		// TODO Auto-generated method stub
		// doGet(request, response);
	}

}
