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
		MessageBean messageBean1 = new MessageBean(1, "one", "Monsieur", "1111111111", "1@gmail.com", "I don't want to be good, so?", null, null);
		MessageBean messageBean2 = new MessageBean(0, "two", "Monsieur", "2222222222", "2@gmail.com", "I don't want to be bad, so?", null, null);
		MessageBean[] messageBeanList = {messageBean1, messageBean2};		
		HttpSession session = request.getSession();
		session.setAttribute("MessageBeanInfo", messageBeanList);
		
		// go to a page specific
		RequestDispatcher rd;
		rd = getServletContext().getRequestDispatcher("/testPageBean2.jsp");
		rd.forward(request, response);
		
//		String s = "get";
//		response.getWriter().write(s);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s = request.getParameter("method");
		if (s.equals("DELETE")) {
			doDelete(request, response);
		}else if (s.equals("POST")) {
			int[] list1 = {1, 2};
			System.out.println(list1[0]);
			System.out.println(list1[1]);

			int[] list2 = {};
			System.out.println(list2);
//			System.out.println(list2[0]);

			list2 = list1;
			System.out.println(list2[0]);
			System.out.println(list2[1]);
			
			response.getWriter().write(s);
		}
//		String[] s = {"post"};
//		response.getWriter().write(s);
		
		// TODO Auto-generated method stub
//		doGet(request, response);
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// session
		HttpSession session = request.getSession();
		session.removeAttribute("MessageBeanInfo");
		
		// go to a page specific
		RequestDispatcher rd;
		rd = getServletContext().getRequestDispatcher("/testPageBean2.jsp");
		rd.forward(request, response);
				
//		String s = "delete";
//		response.getWriter().write(s);
	}

}
