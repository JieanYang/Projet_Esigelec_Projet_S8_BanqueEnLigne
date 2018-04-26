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
<!-- Css file -->
<link rel="stylesheet" href="Resources/Head.css">
	
	<a href="Note_actualités.jsp"> <input type="button" value="Ajouter une actualité"> </a> 
</head>

<body>
	<!-- head.html -->
	<%@ include file="Templates/Head.jsp" %>

    <div class="container">
        <div class="row jumbotron">
            <h2>Bienvenue sur votre page</h2>
        </div>
    </div>
     <!-- nothing used for instant -->

 <!--  <a href="Note_actualités.jsp"> <input type="button" value="Ajouter une actualité"> </a>  -->

</body>
</html>