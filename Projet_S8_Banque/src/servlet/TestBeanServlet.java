package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MessageBean;

/**
 * Servlet implementation class TestBeanServlet
 */
@WebServlet("/TestBeanServlet")
public class TestBeanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestBeanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=big5");
		response.setCharacterEncoding("big5");
		// Create a bean for saving information and we use session
		MessageBean messageBean = new MessageBean(0, "two", "Monsieur", "2222222222", "2@gmail.com", "I don't want to be bad, so?", null, null);
		HttpSession session = request.getSession();
		session.setAttribute("MessageBeanInfo", messageBean);
		
		// go to a page specific
		RequestDispatcher rd;
		rd = getServletContext().getRequestDispatcher("/testPageBean2.jsp");
		rd.forward(request, response);
		
		String s = "here";
		response.getWriter().write(s);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
