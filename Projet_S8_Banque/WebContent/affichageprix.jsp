<!-- Bootstrap 4.0  -->
<%@include file="Resources/Resources_bootstrap_4.0.html" %>

<!-- CSS for Head.html -->
<link rel="stylesheet" href="Resources/styles_index.css">


<title>Cours de la bourse</title>
</head>

    <body>
    
    <%@ include file="Templates/Head.html" %>
    
   <div class="p-3 mb-2 bg-secondary text-white"> <center>Affichage du cours de la bourse</center></div>
    

<div class=jumbotron>
 <div class=container>

 </div>
<br/>

  
<p><center>Veuillez selectionnner l'action que vous voulez �tudier</center><p/>

<br/>


        <form action="Recupprix">
  <div class="form-group">
   <center><label><center> Nom de l'entreprise </center></label>
    <select name = "entreprise" id = "entreprise">
    <option value = "sopra"> Sopra </option>
    <option value = "hermes"> Hermes </option>
    <option value = "cgg"> Cgg </option>
    <option value = "axa"> Axa </option>
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