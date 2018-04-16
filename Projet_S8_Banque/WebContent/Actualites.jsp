<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
 <!--la librairie jstl permet de faire l'affichage de variables Java dans les pages jsp -->
 
<!DOCTYPE html>
<html lang="en">
<head>
  <!--  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>-->
  
  <meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap 4.0  -->
<%@include file="Resources/Resources_bootstrap_4.0.html"%>
<!-- CSS for Head.html -->
 <link rel="stylesheet" href="Resources/Head.css">
 
</head>
<body>

<body>

	<!-- head.html -->
	<%@ include file="Templates/Head.jsp"%>

	<div class="container">
		<div class=jumbotron>
			<h1 style="text-align:center;"><a href="index.jsp" >ACTUALITES</a></h1>
		</div>

		<div class="row">
			 <h2>Retrouver les actualites de votre banque</h2>
		</div>

		<div class="row">
			 <table border="2">
				<tbody>
					<tr><th>DATE</th><th>TITLE</th><th>TEXT</th></tr><!-- entete du tableau -->
					<c:forEach items="${liste}" var="emp"><!-- boucle for en jstl et on envoi la variable  -->
						<tr>
							<!--chaque code insee est un lien cliquable qui redirige vers la servlet compareServlet-->
							<td><c:out value="${emp.getDate()}"></c:out></td><!-- recupere les attribus de l'objet actu individuellement(emp) pour l'inserer dans le tableau -->
							<td><c:out value="${emp.getTitle()}"></c:out></td>
							<td><c:out value="${emp.getText()}"></c:out></td>
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
		 </div>
	</div>
  						

</body>
</html>