<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



<%
/* verify the identification of user */
// System.out.println("verify");
// || (Integer)session.getAttribute("id_user") == 0|| (Integer)session.getAttribute("id_user") == null
System.out.println("verify start");
if (session.getAttribute("login") == null){
	// redirect
	/* response.setStatus(response.SC_MOVED_TEMPORARILY);
	response.setHeader("Location", "/Projet_S8_Banque/index.jsp"); */
	System.out.println("no authentification");
	request.getRequestDispatcher("index_manager.jsp").forward(request, response);
}
System.out.println("authentification\nverify finish");
%>