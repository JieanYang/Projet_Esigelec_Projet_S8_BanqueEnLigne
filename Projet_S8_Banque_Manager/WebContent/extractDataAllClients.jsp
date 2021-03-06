<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List, java.util.ArrayList, java.util.HashMap, java.util.Map" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Extract data of clients</title>

<!-- Bootstrap 4.0  -->
<%@include file="Resources/Resources_bootstrap_4.0.html"%>
<!-- CSS for Head.html -->
<link rel="stylesheet" href="Resources/Head.css">
<!-- chart -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>

<%@ include file="Templates/login_verify.jsp" %>


</head>
<% System.out.println("page extractDataAllClients start"); %>


<% 
	List<Integer> list_idUsers = new ArrayList<Integer>();
	list_idUsers = (List<Integer>)session.getAttribute("list_idUsers");
	int lenght = list_idUsers.size();				
%>
<body>
	<!-- head.html -->
	<%@ include file="Templates/Head.jsp"%>
	
	<div class="container">
		<div class="row">
			<div class="col-6">
				<h3>All Clients</h3>
			</div>
			<div class="col-6">
				<form action="total_depot" mehtod="GET" class="col-12">
					<Button type="submit" class="btn btn-outline-success">Les depot de banque</Button>
				</form>
			</div>
		</div>
		
		<div class="row">
			<table class="table table-hover">
			  <thead>
			    <tr>
			      <th scope="col">id</th>
			      <th scope="col">Nom</th>
			      <th scope="col">Prenom</th>
			      <th scope="col">email</th>
			      <th scope="col">ville</th>
			    </tr>
			  </thead>
			  <tbody>
			    <!-- <tr>
			      <th scope="row">1</th>
			      <td>Mark</td>
			      <td>Otto</td>
			      <td>@mdo</td>
			      <td>paris</td>
			    </tr> -->
			    <%if (lenght > 0) { %>
			    	<%for(Integer id: list_idUsers) { 
			    		UserDao userDao = new UserDao();
			    		User user = userDao.getUser(id);
			    	%>	
					    <tr class="data_user">
					      <th scope="row"><%=user.getId_user() %></th>
					      <td><%=user.getNom() %></td>
					      <td><%=user.getPrenom() %></td>
					      <td><%=user.getEmail() %></td>
					      <td><%=user.getVille() %></td>
					    </tr>
				    <% } %>
			    <% } %>
			  </tbody>
			</table>
		</div>
		
		
		
		<div class="row">
			<form action="ManagerServlet_dataOneClient" mehtod="GET" class="col-12">
				
				<div class="row">
					
					<input type="text" id="id_user_input" name="id_user_input" value=3 class="col-3" style="display: none;"></input>
				</div>
				
				
				<div class="row" style="margin-top: 10px;margin-bottom: 20px;">
					<div class="input-group col-6">
					  <div class="input-group-prepend">
					    <span class="input-group-text" style="background-color: #8e5ea2; color: white;">date started</span>
					  </div>
					  <input type="date" id="date_periode_start" name="date_periode_start" class="form-control col-4">
					</div>
					
					<div class="input-group col-6">
					  <div class="input-group-prepend">
					    <span class="input-group-text" style="background-color: #8e5ea2; color: white;">date finished</span>
					  </div>
					  <input  type="date" id="date_periode_finish" name="date_periode_finish" class="form-control col-4">
					</div>
				</div>
				
				<div class="row">
					<label class="col-3"> id of client:</label>
					<label class="col-3" id="id_user_label">3</label>
					<Button type="submit" class="btn btn-success col-1">Select</Button>
					
				</div>
			</form>
		</div>
		
		<script type="text/javascript">
			var users = document.getElementsByClassName("data_user");
			var label_idUser = document.getElementById("id_user_label");
			var input_idUser = document.getElementById("id_user_input");
			console.log(input_idUser);
			for (i = 0; i < users.length; i++) {
			    console.log(users[i]);
		    	/* var id = users[i].getElementsByTagName("th")[0].textContent;
		    	users[i].setAttribute("id_user", id); */
		    	
			    users[i].addEventListener("click", function() {
			    	var id_select = event.target.parentNode.getElementsByTagName("th")[0].textContent;
			    	console.log(id_select);
			    	label_idUser.textContent = id_select;
			    	input_idUser.setAttribute("value", id_select);
			    });
			}
		</script>
	</div>
	
	
	
	<!--Footer-->
	<footer class="footer">
		<div class="container">
			<span class="colorr">Place sticky footer content here.</span>
		</div>
	</footer>
	<!--/.Footer-->

	<style type="text/css">
		.footer {
			/*position: fixed;*/
			left: 0;
			bottom: 0;
			width: 100%;
			background-color: #333;
			color: white;
			text-align: center;
		}
		
		.colorr{
			color: #ddd;
		}
	</style>
<% System.out.println("page extractDataAllClients finish"); %>

</body>
</html>