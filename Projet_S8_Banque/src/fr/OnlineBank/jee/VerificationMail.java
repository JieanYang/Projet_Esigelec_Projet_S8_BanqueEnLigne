package fr.OnlineBank.jee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import SendEmail.EmailSend;
import dao.CompteDao;

/**
 * Servlet implementation class VerificationMail
 */
@WebServlet("/VerificationMail")
public class VerificationMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private String email ;
       CompteDao monDAO= new CompteDao();
       EmailSend monEmail = new EmailSend();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerificationMail() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String code = request.getParameter("code");
		
		boolean reponse= monDAO.recupererCode(code);
		String resultat =null ;
		String validation = null ;
	
		
		
		if(reponse==true) {
			request.getRequestDispatcher("pageCompteVerifie.jsp").forward(request, response);
			
		}else {
			resultat="Votre code de verification n'est pas le Bon !!! ";
			request.setAttribute("resultat", resultat);
			 request.setAttribute("validation", validation);
			
			request.getRequestDispatcher("pageVerification.jsp").forward(request, response);
		}
		 
		
	}

}
