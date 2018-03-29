package fr.OnlineBank.jee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DAO aDAO = new DAO();

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
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (aDAO.login(username, password)) {
			response.getWriter()
					.write("<!DOCTYPE html>\r\n" + "<html>\r\n" + "	<head>\r\n" + "		<title>Page Title</title>\r\n"
							+ "	</head>\r\n" + "	<body>\r\n" + "		<h1>You are logged in</h1>\r\n" + "	</body>\r\n"
							+ "</html>");
			// response.sendRedirect("HelloWorldMultiLanguage.jsp");
		} else {
			response.getWriter()
					.write("<!DOCTYPE html>\r\n" + "<html>\r\n" + "	<head>\r\n" + "		<title>Page Title</title>\r\n"
							+ "	</head>\r\n" + "	<body>\r\n" + "		<h1>FORBIDDEN</h1>\r\n" + "	</body>\r\n"
							+ "</html>");
		}
	}
}
