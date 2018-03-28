<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html>

    <head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    


    </head>

    <body>
    
    
     <div class="p-3 mb-2 bg-secondary text-white"> CREATION COMPTE BANCAIRE</div>
     
     <div class="progress">
		  <div class="progress-bar" role="progressbar" style="width: 40%" aria-valuenow="15" aria-valuemin="0" aria-valuemax="100"></div>
		  <div class="progress-bar bg-success" role="progressbar" style="width: 40%" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
		  <div class="progress-bar bg-info" role="progressbar" style="width: 40%" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
	</div>

<div class=jumbotron>
 <div class=container>

 </div>
     <br/>
<br/>
     

  <form action="creerCompte" method="POST">
	  <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="inputName4">Nom </label>
	      <input type="text" class="form-control" name="nom" id="inputName4" placeholder="Serais">
	    </div>
	    
	    <div class="form-group col-md-6">
	      <label for="inputName4">Prénom </label>
	      <input type="text" class="form-control" name="prenom" id="inputName4" placeholder="Sebastien">
	    </div>
	    
	    <div class="form-group col-md-6">
	      <label for="inputName4">Tel : </label>
	      <input type="text" class="form-control" name="telephone" id="inputName4" placeholder="0769458855">
	    </div>
	    
	  </div>
	  <div class="form-group">
	    <label for="inputAddress">Date de Naissance : </label>
	    <input type="date" class="form-control" name="date" id="inputdate" placeholder="10/10/1990">
	  </div>
	  
	  <div class="form-group">
	    <label for="inputAddress">Adresse</label>
	    <input type="text" class="form-control" name="adresse" id="inputAddress" placeholder="1 rue jean mermoz">
	  </div>
	  <div class="form-group">
	    <label for="inputAddress2">Adresse mail</label>
	    <input type="text" class="form-control" name="email" id="inputAddress2" placeholder="sebastien@esigelec.fr">
	  </div>
	  <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="inputCity">Ville</label>
	      <input type="text" class="form-control" id="inputCity">
	    </div>
	    <div class="form-group col-md-4">
	      <label for="inputState">Pays</label>
	      <select id="inputState" class="form-control">
	        <option selected>France</option>
	        <option>Allemagne</option>
	        <option>Suisse</option>
	      </select>
	    </div>
	    
	  </div>
	  <div class="form-group">
	    <div class="form-check">
	      <input class="form-check-input" type="checkbox" id="gridCheck">
	      <label class="form-check-label" for="gridCheck">
	        Se souvenir de moi
	      </label>
	    </div>
	  </div>
	  <button type="submit" class="btn btn-primary">Envoyer</button>
</form>


</div>
    </body>

</html>
