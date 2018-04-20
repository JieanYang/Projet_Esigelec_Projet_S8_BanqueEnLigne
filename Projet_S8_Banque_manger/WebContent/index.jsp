<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<!-- Bootstrap 4.0  -->
<%@include file="Resources/Resources_bootstrap_4.0.html"%>
<!-- CSS for Head.html -->
<link rel="stylesheet" href="Resources/Head.css">

</head>
<body>
	
	<!-- head.html -->
	<%@ include file="Templates/Head.jsp"%>
	
	<div class="container">
		<div class="row">
				<h1>manager login</h1>
		</div>
<!-- 
		<div class="row">
			Modal Content
			  <form class="modal-content animate" action="login_manager" method="post">
			    
			    <div class="container">
			      <label for="uname"><b>Adresse mail :</b></label>
			      <input type="text" placeholder="Enter your mail" name="email" required>
			
			      <label for="psw"><b>Password</b></label>
			      <input type="password" placeholder="Enter Password" name="password" required>
			
			      <button name="loginUser" type="submit">Login</button>

			    </div>
			
			    <div class="container" style="background-color:#f1f1f1">
			      <button name="loginCancel" type="button" class="cancelbtn">Cancel</button>
			      <span class="psw">Forgot <a href="#">password?</a></span>
			    </div>
			  </form>
		</div> -->
		
		<div class="row">
			<form class="modal-content animate" action="login_manager" method="post">
			    	<input type="text" placeholder="Enter your mail" name="email" value="manager" required>
			    	<input type="password" placeholder="Enter Password" name="password" value="manager" required>
			    
			     	<button name="loginUser" type="submit">Login</button>
			</form>
		</div>
		
		<div class="row">
			<form action="ManagerServlet_extractDataClients" method="GET">			
				<button type="submit">
					extract data clients
				</button>
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

</body>
</html>