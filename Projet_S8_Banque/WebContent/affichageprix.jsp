<!-- Bootstrap 4.0  -->
<%@include file="Resources/Resources_bootstrap_4.0.html"%>
<!-- CSS for Head.html -->
 <link rel="stylesheet" href="Resources/Head.css">

<html>
<head>
<title>Cours de la bourse</title>
</head>

<body>
    <!-- head.html -->
	<%@ include file="Templates/Head.jsp"%>

    <div class="container">
        <div class="row">
            <div class="col-sm-8 offset-sm-2">
               <div class="p-3 mb-2 bg-secondary text-white"> <center>Affichage du cours de la bourse</center></div>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-12">
                <p><center>Veuillez selectionnner l'action que vous voulez étudier</center><p/>            
            </div>
        </div>

        <div class="row">
            <div class="col-sm-12">

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
            </div>
        </div>
    </div>

	<!-- footer.html -->
	<%@ include file="Templates/Footer.html"%>

</body>

</html>