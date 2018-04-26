<%@ page pageEncoding="UTF-8" %>

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

<div class=jumbotron>
 <div class=container>

 </div>
     <br/>
<br/>
     

  <form action="MessageClient" method="post">
	  <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="inputName4">Nom </label>
	      <input type="text" class="form-control" name="nom" id="inputName4" placeholder="Serais" required>
	    </div>
	    
	    <div class="form-group col-md-6">
	      <label for="inputName4">Prénom </label>
	      <input type="text" class="form-control" name="prenom" id="inputName4" placeholder="Sebastien" required>
	    </div>
	    
	  </div>
	  
	  <div class="form-group">
	    <label for="inputAddress">Telephone</label>
	    <input type="text" class="form-control" name="telephone" id="inputAddress" placeholder="0769458855" required>
	  </div>
	  
	  <div class="form-group">
	    <label for="inputAddress">Adresse</label>
	    <input type="text" class="form-control" name="adresse" id="inputAddress" placeholder="1 rue jean mermoz" required>
	  </div>
	  <div class="form-group">
	    <label for="inputAddress2">Adresse mail</label>
	    <input type="text" class="form-control" name="email" id="inputAddress2" placeholder="sebastien@esigelec.fr" required>
	  </div>
	  
	    <div class="form-group col-md-6">
	      <label for="inputName4">Votre message : </label>
	      <textarea type="text" class="form-control" name="zoneTexte" cols="10" id="inputName4" placeholder="Entrez votre message"></textarea>
	    </div>
	  
	  
	  <button type="submit" class="btn btn-primary">Envoyer</button>
</form>


</div>


		<!-- footer.html -->
		<%@ include file="Templates/Footer.html"%>
    </body>

</html>
