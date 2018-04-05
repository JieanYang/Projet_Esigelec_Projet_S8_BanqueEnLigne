package fr.OnlineBank.jee;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Class.Message;
import dao.MessageDao;

/**
 * Servlet implementation class MessageClient
 */
@WebServlet("/MessageClient")
public class MessageClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MessageDao monDao = new MessageDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageClient() {
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
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email= request.getParameter("email");
		String numphone = request.getParameter("telephone");
		String adresse = request.getParameter("adresse");
		String problem = request.getParameter("zoneTexte");
		int id =1 ;
		String reponse = request.getParameter("");
		Date utildate = new Date();         
    	Timestamp sqldate = new Timestamp(utildate.getTime());  
    	
		
		Message message = new Message(id,nom,prenom,numphone,email,problem,reponse,sqldate);
		monDao.addMessage(message);
		
	}

}
