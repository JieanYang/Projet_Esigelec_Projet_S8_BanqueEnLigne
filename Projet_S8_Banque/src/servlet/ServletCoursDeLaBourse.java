package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Class.Entreprise;
import dao.BourseDAO;
import dao.EntrepriseDAO;

@WebServlet("/ServletCoursDeLaBourse")
public class ServletCoursDeLaBourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BourseDAO bourseDAO = new BourseDAO();
	EntrepriseDAO entDAO = new EntrepriseDAO();
       
    public ServletCoursDeLaBourse() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Date> listeDate = new ArrayList<Date>(); 
		listeDate = bourseDAO.getDate();
		ArrayList<Float> listeCour = new ArrayList<Float>();
		listeCour = bourseDAO.getCours();
		ArrayList<String> stringDateList = new ArrayList<String>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		for (Date aDate : listeDate) {
			stringDateList.add(simpleDateFormat.format(aDate));
	    }
		
		ArrayList<Entreprise> listEnt = entDAO.getEnt();
		
		request.setAttribute("listEnt", listEnt);
		request.setAttribute("stringDateList", stringDateList);
		request.setAttribute("listeCour", listeCour);
		getServletConfig().getServletContext().getRequestDispatcher("/CoursDeLaBourse.jsp").forward(request,response);
	}
}
