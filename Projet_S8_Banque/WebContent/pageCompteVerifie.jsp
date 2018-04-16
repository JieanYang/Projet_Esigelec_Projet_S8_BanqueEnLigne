<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

    <head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap 4.0  -->
	<%@include file="Resources/Resources_bootstrap_4.0.html"%>
	<!-- CSS for Head.html -->
	 <link rel="stylesheet" href="Resources/Head.css">
    


    </head>

 <body>
 	<!-- head.html -->
	<%@ include file="Templates/Head.jsp"%>
 
 	<form method="post" action="PageCompteVerifie">
 		<h1>Votre compte est validé !</h1>
 		
 		<div class="form-group">
	    	<img width="400" src="Image/validation.jpg">
	    </div>
	  <div class="form-group">
	    <button type="submit" class="btn btn-primary">Retour Acceuil</button>
	  </div>
    
	
		
	 </form>
	 
</body>

</html>