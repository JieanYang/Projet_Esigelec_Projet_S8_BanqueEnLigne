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
 
 	<p> ${resultat}</p>
      
 	
	    <form action="VerificationMail" method="post">
			<div class="form-group col-md-4">
		      <label for="inputState">Veuillez Entrez votre code de verification envoyé par mail :</label>
		      <input id="inputState" name="code" class="form-control">
		        
		        <button type="submit" class="btn btn-primary">Envoyer</button>
		  
		 	</div>
		 </form>
		 
		 <c:if test="${validation}" var="variable">
		   <p><img src="/Image/validation.jpg"></p>
		</c:if>
	 
	 <!-- footer.html -->
	<%@ include file="Templates/Footer.html"%>
</body>

</html>