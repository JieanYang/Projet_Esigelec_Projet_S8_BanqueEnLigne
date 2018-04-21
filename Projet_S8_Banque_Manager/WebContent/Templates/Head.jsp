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
int id_user = -1;
String login = null;
/* login = (String)session.getAttribute("login");
 *///System.out.println(login==("login")); -> false
/* System.out.println(login.equals("login"));
 *//* if (login.equals("login")){
	id_user = (Integer)session.getAttribute("id_user");
	System.out.println("id_user");
	//System.out.println(id_user);
} */
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
		<%-- <% if(login.equals(null)) { %>

			
		<%} else if(login.equals("login")) {
			User user_login = new User();
			UserDao userDao = new UserDao();
			user_login = userDao.getUser(Integer.valueOf(id_user));
		%>

			<!-- Espace client --> 
			<a class="btn active" name="nameOfClient" href="menu_manager.jsp">
				<%
				out.println("Hello! Manager "+user_login.getPrenom()+' '+user_login.getNom());
				%>
				</a> --%>


			<!-- Button log out -->
			<form name="formLogOut" action="login_manager" method="GET">	
				<input name="method" value="logout" style="display:none;">
				<button name="buttonLogOut" type="submit">
					Log out
				</button>
			</form>
			
	<%-- 	<%} %> --%>
		</div>
	</div>