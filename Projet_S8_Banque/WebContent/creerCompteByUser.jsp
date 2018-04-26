<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Creer compte by user</title>
</head>

<!-- Bootstrap 4.0  -->
<%@include file="Resources/Resources_bootstrap_4.0.html"%>
<!-- CSS for Head.html -->
 <link rel="stylesheet" href="Resources/Head.css">
 
 <% 
User user_login_content = new User();
user_login_content = null;
UserDao userDao_content = new UserDao();

String id_user_content_string = (String)session.getAttribute("id_user");
int id_user_content_int = Integer.valueOf(id_user_content_string);
user_login_content = userDao_content.getUser(Integer.valueOf(id_user_content_int));

		
 %>
 
<body>
<!-- head.html -->
	<%@ include file="/Templates/Head.jsp" %>

	<div class="container">
		<form action="CLientServlet_creerCompteByUser" method="post" >
	  	    <div class="form-group ">
		      <label for="categorieCompte">Je veux ouvrir :</label>
		      <select name="categorieCompte" id="categorieCompte" class="form-control">
		        <option selected value="courant">Compte Bancaire</option>
		        <option value="epargne">Livret A</option>
		        <option value="titre">compte titre</option>
		      </select>
		    </div>
		    
		  <input name="id_user" value="<%=user_login_content.getId_user() %>" style="display: none;"></input>
		    
		  <div class="form-row">
		    <div class="form-group col-md-6">
		      <label for="inputName4">Nom </label>
		      <input type="text" class="form-control" name="nom" value="<%=user_login_content.getNom() %>" id="inputName4"  required>
		    </div>
		    
		    <div class="form-group col-md-6">
		      <label for="inputName4">Prénom </label>
		      <input type="text" class="form-control" name="prenom" value="<%=user_login_content.getPrenom() %>" id="inputName4"  required>
		    </div>
		    
		    <div class="form-group col-md-6">
		      <label for="inputName4">Telephone : </label>
		      <input type="text" class="form-control" name="telephone" value="<%=user_login_content.getTelephone() %>" id="inputName4"  required>
		    </div>
		    
		  </div>
		  <div class="form-group">
		    <label for="inputAddress">Date de Naissance : </label>
		    <input type="text" class="form-control" name="dateNaissance"  value="<%=user_login_content.getDateNaissance() %>" id="inputdate" placeholder="10/10/1990" required>
		  </div>
		  
		  <div class="form-group">
		    <label for="inputAddress">Adresse</label>
		    <input type="text" class="form-control" name="adresse" value="<%=user_login_content.getAdresse() %>" id="inputAddress"  required>
		  </div>
		  <div class="form-group">
		    <label for="inputAddress2">Adresse mail</label>
		    <input type="email" class="form-control" name="email" value="<%=user_login_content.getEmail() %>" id="inputAddress2"  required disabled>
		    
		  </div>
		  <div class="form-row">
		    <div class="form-group col-md-6">
		      <label for="inputCity">Ville</label>
		      <input type="text" name="ville" class="form-control" value="<%=user_login_content.getVille() %>" id="inputCity" required>
		    </div>
		    <div class="form-group col-md-4">
		      <label for="inputState">Pays</label>
		      <select id="inputState" name="pays" class="form-control">
		        <option selected value="france">France</option>
		        <option value="allemagne">Allemagne</option>
		        <option value="suisse">Suisse</option>
		      </select>
		    </div>
		    
		    <!-- <div class="form-group">
	                            <label  for="fichier">Ajouter Fichier : (de Type PDF)</label>
	                            <input class="form-control col-sm-8" type="hidden" name="MAX_FILE_SIZE" value="30720" />
	                            <input class="form-control col-sm-8 " id="fichier" type="file" name="fichier" />
	                            
	        </div> -->
		    
		  </div>
		  
		  <button type="submit" class="btn btn-primary">Create my account</button>  
		</form>
	</div>
	
	<!-- footer.html -->
	<%@ include file="Templates/Footer.html"%>

<!-- 	<script src="/Resources/scripts_index.js"></script>-->

</body>
</html>