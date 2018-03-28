<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

    <head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Cours de la Bourse</title>


    </head>

    <body>
    
    
   <div class="p-3 mb-2 bg-secondary text-white"> Affichage du cours de la bourse</div>
    


<div class="progress">
  <div class="progress-bar" role="progressbar" style="width: 40%" aria-valuenow="15" aria-valuemin="0" aria-valuemax="100"></div>
  <div class="progress-bar bg-success" role="progressbar" style="width: 40%" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
  <div class="progress-bar bg-info" role="progressbar" style="width: 40%" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
</div>
<div class=jumbotron>
 <div class=container>

 </div>
<br/>

  
<p><center>Veuillez selectionnner l'action que vous voulez étudier</center><p/>

<br/>


        <form action="recupprix">
  <div class="form-group">
   <center><label><center> Nom de l'entreprise </center></label>
    <select name = "entreprise" id = "entreprise">
    <option value = "sopra"> Sopra </option>
    <option value = "hermes"> Hermes </option>
    <option value = "cgg"> Cgg </option>
    <option value = "Axa"> axa </option>
    </select>
    <align left><button type="submit" class="btn btn-primary">Valider</button></align>
    
    </center>
    <br>
    
    
    
    
    <div class="form-group">
    <center><label>Le Prix de l'action est de:</label>
    <input type ="text">
    
    
    </center>
    
    </div>
    <br>
  
  <center><button type="submit" class="btn btn-primary">Retour</button></center>
</form>

    </body>

</html>