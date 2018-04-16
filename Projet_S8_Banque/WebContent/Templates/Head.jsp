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
			href="ServletCoursDeLaBourse">Bourse</a> <a href="javascript:void(0);" class="icon"
			onclick="myFunction()">&#9776;</a>
	</div>
	
	<style type="text/css">
		/* button {display:none;} */
		
		
		#button_logOut {
			border-radius: 4px;
			background-color: #046380;
			color: #f2f2f2;
			/* display: inline; */
			width: auto;
			margin: 0;
			padding: 12px;
			
		}
		
		#button_logOut:hover {
			color: black;
			background-color: white;
			text-decoration: none;
		}
	</style>
	
	<!-- header -->
	<div class="header">
		<a href="#default" class="logo">OnlineBank</a>
		<div class="header-right">
		<% if(id_user == null) { %>
			<button class="btn active" name="espaceClient" onclick="document.getElementById('id01').style.display='block'">Espace Client</button>
			<!--<a class="btn active" name="espaceClient" style="width: auto;" href="login.jsp">Espace Client</a>-->
			<!--<a class="active" href="#home">Home</a>
                <a href="#contact">Contact</a>
                <a href="#about">About</a>-->
            <!-- The Modal -->
				<div id="id01" class="modal">
				  <span onclick="document.getElementById('id01').style.display='none'" 
				class="close" title="Close Modal">&times;</span>
				
				  <!-- Modal Content -->
				  <form class="modal-content animate" action="Login" method="post">
				    
				    <div class="container">
				      <label for="uname"><b>Adresse mail :</b></label>
				      <input type="text" placeholder="Enter your mail" name="email" required>
				
				      <label for="psw"><b>Password</b></label>
				      <input type="password" placeholder="Enter Password" name="password" required>
				
				      <button type="submit">Login</button>
				      <label>
				        <input type="checkbox" checked="checked" name="remember"> Remember me
				      </label>
				    </div>
				
				    <div class="container" style="background-color:#f1f1f1">
				      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
				      <span class="psw">Forgot <a href="#">password?</a></span>
				    </div>
				  </form>
				</div>
				
				<script>
					// Get the modal
					var modal = document.getElementById('id01');
					
					// When the user clicks anywhere outside of the modal, close it
					window.onclick = function(event) {
					    if (event.target == modal) {
					        modal.style.display = "none";
					    }
					}
				</script>
		<%} else if(id_user != null) {
			User user_login = new User();
			UserDao userDao = new UserDao();
			user_login = userDao.getUser(Integer.valueOf(id_user));
		%>

			<!-- Espace client --> 
			<a class="btn active" name="name of client" 
				style="width: auto; display: inline;" href="Clientconnecte.jsp">
				<%
				out.println("Hello!"+user_login.getPrenom()+' '+user_login.getNom());
				%>
				</a>


			<!-- Button log out -->
			<form action="AuthentificationServlet" method="GET" style="display: inline;">	
				<input name="method" value="logout" style="display:none;">
				<button id="button_logOut" class="active" type="submit">
					Log out
				</button>
			</form>
			
		<%} %>
		</div>
	</div>