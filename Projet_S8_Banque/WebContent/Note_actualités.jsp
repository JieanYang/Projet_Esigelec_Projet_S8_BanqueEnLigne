<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css_script/styles_index.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	
	
</head>

<body class="container backC">
	<!-- head.html -->
	 <%@ include file="Templates/Manager.html" %> 


     
     

<div class=jumbotron>
 <div class=container>

 </div>
     <br/>
<br/>
   <div class="form-bottom">  
<form role="form" action="Actualites_servlet" method="post" class="registration-form">

  <div class="form-group col-md-6">
	      <label for="inputName4"> Date : </label>
	      <input type="date" class="form-control" name="date" id="inputdate">
   </div>
	    
   <div class="form-group">
	    <label for="inputTitle">Titre</label>
	    <input type="text" class="form-control" name="title" id="inputtitle" placeholder="Veuillez not� le titre de votre actualit�" required>
	  </div>

  <div class="form-group">
    <label for="exampleFormControlTextarea1">Actualit�s</label>
    <textarea  type="text" class="form-control" name="text" id="exampleFormControlTextarea1" rows="4"></textarea>
  </div>
   <button type="submit" class="btn btn-primary">Envoyer</button>
</form>



</body>
</html>