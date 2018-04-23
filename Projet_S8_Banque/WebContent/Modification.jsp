<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- login_verify, if it's not user, redirect to index.jsp -->
<%@include file="/Templates/login_verify.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modification</title>

	<!-- Bootstrap 4.0  -->
	<%@include file="Resources/Resources_bootstrap_4.0.html"%>
	<!-- CSS for Head.html -->
	 <link rel="stylesheet" href="Resources/Head.css">
	 
</head>

<% 
	String id_user_stirng_content = (String)session.getAttribute("id_user");
	int id_user_int_content = Integer.valueOf(id_user_stirng_content);
	UserDao userDao_content = new UserDao(); 
	User user_login_content = new User();
	user_login_content = userDao_content.getUser(id_user_int_content);
%>

<body>
    <!-- head.html -->
	<%@ include file="Templates/Head.jsp"%>
    
     <div class="p-3 mb-2 bg-secondary text-white"> MODIFICATION DES INFORMATIONS</div>

<div class=jumbotron>
 <div class=container>
 
  </div>
 
 
  <form action="modification" method="post">
  
  		<div class="form-row" >
		    <%-- <div class="form-group col-md-6">
		      <label for="inputName4">ID:</label>
		      <input value="<%out.println((String)session.getAttribute("id_user")); %>" name="id" disabled >
		   </div> --%>
		   <div class="form-group col-md-6">
		      <label for="inputName4">ID</label>
		      <input type="text" value="<%=user_login_content.getId_user() %>" name="dateNaissance" disabled >
		    </div>
			
			<div class="form-group col-md-6">
		      <label for="inputName4">date_naissance</label>
		      <input type="text" value="<%=user_login_content.getDateNaissance() %>" name="dateNaissance" disabled >
		    </div>
	   </div>

	
	  <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="inputName4">Nom </label>
	      <input type="text" class="form-control" name="nom" value="<%=user_login_content.getNom() %>" id="inputName4" placeholder="nom" required>
	    </div>
	    
	    <div class="form-group col-md-6">
	      <label for="inputName4">Prénom </label>
	      <input type="text" class="form-control" name="prenom" value="<%=user_login_content.getPrenom() %>" id="inputName4" placeholder="prenom" required>
	    </div>
	    
	    <div class="form-group col-md-6">
	      <label for="inputName4">Mot de passe </label>
	      <input type="password" class="form-control" name="password" value="<%=user_login_content.getPassword() %>" id="inputName4" placeholder="XXXX" required>
	    </div>
	    
	    <div class="form-group col-md-6">
	      <label for="inputName4">Tel : </label>
	      <input type="text" class="form-control" name="telephone" value="<%=user_login_content.getTelephone() %>" id="inputName4" placeholder="076945XXXX" required>
	    </div>
	    
	  </div>
	  
	  <div class="form-group">
	    <label for="inputAddress">Adresse</label>
	    <input type="text" class="form-control" name="adresse" value="<%=user_login_content.getAdresse() %>" id="inputAddress" placeholder="1 rue jean mermoz" required>
	  </div>
	  <div class="form-group">
	    <label for="inputAddress2">Adresse mail</label>
	    <input type="text" class="form-control" name="email" value="<%=user_login_content.getEmail() %>" id="inputAddress2" placeholder="XXXX@esigelec.fr"  required />
	    
	  </div>
	  <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="inputCity">Ville</label>
	      <input type="text" name="ville" value="<%=user_login_content.getVille() %>" class="form-control" id="inputCity" required>
	    </div>
	    <div class="form-group col-md-4">
	      <label for="inputState">Pays</label>
	      <select id="inputState" name="pays" value="<%=user_login_content.getPays() %>" class="form-control">
	        <option selected value="france">France</option>
	        <option value="allemagne">Allemagne</option>
	        <option value="suisse">Suisse</option>
	      </select>
	    </div>
	  </div>
	  
	  <button type="submit" class="btn btn-primary">Envoyer</button>
</form>


</div>
    </body>
    
    <!-- footer.html -->
	<%@ include file="Templates/Footer.html"%>
</html>