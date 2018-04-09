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
	<div class="topnav" id="myTopnav">
		<a href="index.jsp" class="active">Accueil</a> <a href="#news">News</a> <a
			href="affichageprix.jsp">Bourse</a> <a href="javascript:void(0);" class="icon"
			onclick="myFunction()">&#9776;</a>
	</div>
	<!-- header -->
	<div class="header">
		<a href="#default" class="logo">OnlineBank</a>
		<div class="header-right">
		<% if(id_user == null) { %>
			<a class="btn active" name="espaceClient" 
			style="width: auto;" href="login.jsp">Espace Client</a>
			<!--<a class="active" href="#home">Home</a>
                <a href="#contact">Contact</a>
                <a href="#about">About</a>-->
		<%} else if(id_user != null) {
			User user_login = new User();
			UserDao userDao = new UserDao();
			user_login = userDao.getUser(Integer.valueOf(id_user));
		%>
			<!-- Espace client --> 
			<a class="btn active" name="name of client" 
			style="width: auto;" href="Clientconnecté.jsp">
			<%
			out.println("Hello!"+user_login.getPrenom()+' '+user_login.getNom());
			%>
			</a>
			<!-- Button log out -->
			<form action="AuthentificationServlet" method="GET">	
				<input name="method" value="logout" style="display:none;">
				<button type="submit">
					Log out
				</button>
			</form>
			
		<%} %>
		</div>
	</div>