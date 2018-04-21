<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Class.User, dao.UserDao" %>


<!-- Head will change depend the identification of user -->
<%

System.out.println("head start");
String login_head = null;
login_head = (String)session.getAttribute("login");

%>


<!-- top navigation -->
	<div class="topNav">
		<a href="index_manager.jsp" class="topNav button_nav active_button_nav">Accueil</a> <!-- <a class="topNav button_nav" href="#news">News</a> <a class="topNav button_nav"
			href="ServletCoursDeLaBourse">Bourse</a> <a href="javascript:void(0);" class="icon"
			onclick="myFunction()">&#9776;</a> -->
	</div>
	
	<!-- header -->
	<div class="header">
		<a href="index_manager.jsp" class="logo">OnlineBank</a>
		<div class="header-right">
		<% if(login_head == null) { %>

			
		<%} else if(login_head.equals("login")) {
			User user_login = new User();
			UserDao userDao = new UserDao();
			//user_login = userDao.getUser(Integer.valueOf(id_user_string_head));
		%>

			<%-- <!-- Espace client --> 
			<a class="btn active" name="nameOfClient" href="menu_manager.jsp">
				<%
				out.println("Hello! Manager "+user_login.getPrenom()+' '+user_login.getNom());
				%>
				</a>  --%>

			<!-- Button log out -->
			<form name="formLogOut" action="login_manager" method="GET">	
				<input name="method" value="logout" style="display:none;">
				<button name="buttonLogOut" type="submit">
					Log out
				</button>
			</form>
			
	 	<%} 
	 	System.out.println("head finish");%>
		</div>
	</div>