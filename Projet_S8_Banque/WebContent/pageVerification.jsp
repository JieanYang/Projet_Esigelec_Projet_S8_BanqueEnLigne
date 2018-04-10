<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

    <head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    


    </head>

 <body>
 
 	 <c:if test="${ sessionScope.code == sessionScope.code2 }">
        <p>Votre adresse email est validé !</p>
    </c:if>
       
 	
	    <form action="VerificationMail" method="post">
			<div class="form-group col-md-4">
		      <label for="inputState">Veuillez Entrez votre code de verification :</label>
		      <input id="inputState" name="code" class="form-control">
		        
		        <button type="submit" class="btn btn-primary">Envoyer</button>
		  
		 	</div>
		 </form>
	 
	 
</body>

</html>