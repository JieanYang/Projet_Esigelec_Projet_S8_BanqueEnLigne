package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AuthentificationServlet
 */
@WebServlet("/AuthentificationServlet")
public class AuthentificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthentificationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		
		if(method.equals("login"))
			this.logIn(request, response);
		if(method.equals("logout"))
			this.logOut(request, response);

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	/*logIn -> set session "login"->"login", "id_user"->(?) the id of user*/
	protected void logIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("login");
		String id_user = request.getParameter("id_user");
		
		// Session
		HttpSession session = request.getSession();
		session.setAttribute("login", "login");
		session.setAttribute("id_user", id_user);

		
		RequestDispatcher rd;
		rd = getServletContext().getRequestDispatcher("/Clientconnecte.jsp");
		rd.forward(request, response);
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
