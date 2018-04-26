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
 * Servlet implementation class Login
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DAO aDAO= new DAO();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		String Firstname = request.getParameter("firstname");
		String Lastname = request.getParameter("lastname");
		String email= request.getParameter("email");
		String Password= request.getParameter("password");
		
		
		// aDAO.addUser(Firstname, Lastname, email, Password);
		
		UserDao userDao = new UserDao();
		User user = new User();
		user.setNom(Firstname);
		user.setPrenom(Lastname);
		user.setEmail(email);
		user.setPassword(Password);
		user.setCategorie_user("client");
		
		User user_verify = new User();
		user_verify = null;
		user_verify = userDao.addUser(user);
		
		if(user_verify != null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			response.getWriter().write("Faild inscription ->\nuser nom:" +Firstname+"\nemail->"+email);
		}
		
	}

}
