<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap 4.0  -->
<%@include file="Resources/Resources_bootstrap_4.0.html"%>
<!-- CSS file -->
<link rel="stylesheet" href="Resources/Head.css">
	
	
</head>

<body>
	<!-- head.html -->
	 <%@ include file="Templates/Head.jsp" %> 

	<div class="container">
		<div class="row">
			<div class="col-sm-12"> 
				<form role="form" action="Actualites_servlet" method="post" class="registration-form">

				  <div class="form-group col-md-6">
					      <label for="inputName4"> Date : </label>
					      <input type="date" class="form-control" name="date" id="inputdate">
				   </div>
					    
				   <div class="form-group">
					    <label for="inputTitle">Titre</label>
					    <input type="text" class="form-control" name="title" id="inputtitle" placeholder="Veuillez noté le titre de votre actualité" required>
					  </div>

				  <div class="form-group">
				    <label for="exampleFormControlTextarea1">Actualités</label>
				    <textarea  type="text" class="form-control" name="text" id="exampleFormControlTextarea1" rows="4"></textarea>
				  </div>
				   <button type="submit" class="btn btn-primary">Envoyer</button>
				</form>
			</div>
		</div>
	</div>
     
	<!-- footer.html -->
	 <%@ include file="Templates/Footer.html" %> 



</body>
</html>