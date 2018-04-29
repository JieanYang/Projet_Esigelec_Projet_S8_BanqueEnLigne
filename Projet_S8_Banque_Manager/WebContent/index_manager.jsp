<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>index manager</title>

<!-- Bootstrap 4.0  -->
<%@include file="Resources/Resources_bootstrap_4.0.html"%>
<!-- CSS for Head.html -->
<link rel="stylesheet" href="Resources/Head.css">

</head>
<% System.out.println("page index_manager start"); %>

<body>
	
	<!-- head.html -->
	<%@ include file="Templates/Head.jsp"%>
	
	<div class="container">
		<div class="row">
				<h1>manager index</h1>
		</div>
		
		<div class="row" style="display: <%if(login_head==null){ out.println("none");}else if(login_head.equals("login")){out.println("block");} %>;">
		  	<a href="menu_manager.jsp" class="btn btn-success">menu</a>
		</div>

		<div class="row">
			  <!-- Modal Content -->
			  <form class="modal-content animate" action="login_manager" method="post"
			   style="display:<% if(login_head==null){ out.println("block");}else if(login_head.equals("login")){out.println("none");} %>;">
			    
			    <div class="container">
			      <label for="uname"><b>Adresse mail :</b></label>
			      <input type="text" placeholder="Enter your mail" name="email" required>
			
			      <label for="psw"><b>Password</b></label>
			      <input type="password" placeholder="Enter Password" name="password" required>
			
			      <button name="loginUser" type="submit">Login</button>

			    </div>

			  </form>
			  
			  
		</div>
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
<% System.out.println("page index_manager finish"); %>

</body>
</html>