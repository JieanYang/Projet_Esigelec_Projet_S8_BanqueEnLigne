package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Class.Actions;
import Class.Entreprise;
import dao.ActionsDAO;
import dao.BourseDAO;
import dao.EntrepriseDAO;

@WebServlet("/ServletAchatAction")
public class ServletAchatAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BourseDAO bourseDAO = new BourseDAO();
	EntrepriseDAO entDAO = new EntrepriseDAO();
	ActionsDAO actDAO = new ActionsDAO();
       
    public ServletAchatAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<Date> listeDate = new ArrayList<Date>(); 
		listeDate = bourseDAO.getDate();
		ArrayList<Float> listeCour = new ArrayList<Float>();
		listeCour = bourseDAO.getCours();
		ArrayList<String> stringDateList = new ArrayList<String>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		for (Date aDate : listeDate) {
			stringDateList.add(simpleDateFormat.format(aDate));
	    }
		String id_user = (String)session.getAttribute("id_user");
		ArrayList<Entreprise> listEnt = entDAO.getEnt();
		ArrayList<Actions> listAct = actDAO.getact(id_user);
		request.setAttribute("listAct", listAct);
		request.setAttribute("listEnt", listEnt);
		request.setAttribute("stringDateList", stringDateList);
		request.setAttribute("listeCour", listeCour);
		getServletConfig().getServletContext().getRequestDispatcher("/affichageprix.jsp").forward(request,response);
	}
}