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

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css_script/styles_index.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>

<body class="container backC">
	<!-- head.html -->
	


     
     

<div class=jumbotron>
 <div class=container>

 </div>
     <br/>
<br/>

<div class="container" >
<h1 style="text-align:center;"><a href="index.jsp" >ACTUALITES</a></h1>
  <br>
  <br>
  <h2>Retrouver les actualites de votre banque</h2>
  
  <br>
  <br>
  
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

</body>
</html>