<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Class.User, dao.UserDao" %>


<!-- Head will change depend the identification of user -->
<%
/* System.out.println("before"+session.getAttribute("id_user")+" test"+ session.getAttribute("test"));
if (session.getAttribute("test")==null){
session.setAttribute("id_user", "3");
}
System.out.println("after"+session.getAttribute("id_user"));
 */
String id_user = new String();
if ((String)session.getAttribute("login")=="login"){
	id_user = (String)session.getAttribute("id_user");
}else {
	id_user = null;
}
%>


<!-- top navigation -->
	<div class="topNav">
		<a href="index.jsp" class="topNav button_nav active_button_nav">Accueil</a> <a class="topNav button_nav" href="#news">News</a> <a class="topNav button_nav"
			href="ServletCoursDeLaBourse">Bourse</a> <a href="javascript:void(0);" class="icon"
			onclick="myFunction()">&#9776;</a>
	</div>
	
	<!-- header -->
	<div class="header">
		<a href="index.jsp" class="logo">OnlineBank</a>
		<div class="header-right">
		<% if(id_user == null) { %>

			
		<%} else if(id_user != null) {
			User user_login = new User();
			UserDao userDao = new UserDao();
			user_login = userDao.getUser(Integer.valueOf(id_user));
		%>

			<!-- Espace client --> 
			<a class="btn active" name="nameOfClient" 
			href="Clientconnecte.jsp">
				<%
				out.println("Hello! Manager "+user_login.getPrenom()+' '+user_login.getNom());
				%>
				</a>


			<!-- Button log out -->
			<form name="formLogOut" action="AuthentificationServlet" method="GET">	
				<input name="method" value="logout" style="display:none;">
				<button name="buttonLogOut" type="submit">
					Log out
				</button>
			</form>
			
		<%} %>
		</div>
	</div>