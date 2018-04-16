<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



<%
/* verify the identification of user */
// System.out.println("verify");
// || (Integer)session.getAttribute("id_user") == 0|| (Integer)session.getAttribute("id_user") == null

if (session.getAttribute("login") == null || session.getAttribute("id_user") == null ){
	// redirect
	response.setStatus(response.SC_MOVED_TEMPORARILY);
	response.setHeader("Location", "/Projet_S8_Banque/index.jsp");
}

%>