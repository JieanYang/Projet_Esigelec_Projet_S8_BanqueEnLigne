<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css_script/styles_index.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="css_script/form.css">

<a href="/login.jsp"> <input type="button" value="Espace Client"> </a> 

<title>Accueil</title>
</head>
<body class="container backC">

	<!-- head.html -->
	<%@ include file="head.html" %>

	<div class="row justify-content-around espace">
		<div class="card" style="width: 19rem;">
			<img class="card-img-top" src="Image/livretA.jpg"
				alt="Card image cap">
			<div class="card-body">
				<h5 class="card-title">Ouvrir un Compte Livret A</h5>
				<p class="card-text">Un texte ici ?</p>
				<a href="#" class="btn btn-primary">Ouvrir un compte</a>
			</div>
		</div>

		<div class="card" style="width: 19rem;">
			<img class="card-img-top" src="Image/compteCourant.jpg"
				alt="Card image cap">
			<div class="card-body">
				<h5 class="card-title">Ouvrir un compte courant</h5>
				<p class="card-text">Un texte ici ?</p>
				<a href="#" class="btn btn-primary">Ouvrir un compte</a>
			</div>
		</div>


		<div class="card" style="width: 19rem;">
			<img class="card-img-top" src="Image/compteTitre.jpg"
				alt="Card image cap">
			<div class="card-body">
				<h5 class="card-title">Ouvrir un compte titre</h5>
				<p class="card-text">Un texte ici ?</p>
				<a href="#" class="btn btn-primary">Ouvrir un compte</a>
			</div>
		</div>
	</div>

	<!-- <div class="col-container contourNews">
		<div class="col bordure">
			<h4>Colonne</h4>
			
		</div>

		<div class="col bordure">
			<h4>Colonne</h4>
			<p>Some other text..</p>
			<p>Some other text..</p>
		</div>
	</div> -->

	<!--Footer-->
	<footer class="footer">
		<div class="container">
			<span class="colorr">Place sticky footer content here.</span>
		</div>
	</footer>
	<!--/.Footer-->

	<script src="css_script/scripts_index.js"></script>
</body>
</html>