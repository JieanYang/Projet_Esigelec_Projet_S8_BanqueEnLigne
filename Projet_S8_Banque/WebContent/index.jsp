<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap 4.0  -->
<%@include file="Resources/Resources_bootstrap_4.0.html" %>
		
<!-- CSS for Head.html -->
<link rel="stylesheet" href="Resources/styles_index.css">


<title>Accueil</title>
</head>
<body class="container backC">

	<!-- head.html -->
	<%@ include file="/Templates/Head.html" %>

	<div class="row justify-content-around espace">
		<div class="card" style="width: 19rem;">
			<img class="card-img-top" src="Image/livretA.jpg"
				alt="Card image cap">
			<div class="card-body">
				<h5 class="card-title">Ouvrir un Compte</h5>
				<p class="card-text">Un texte ici ?</p>
				<a href="creerCompte.jsp" class="btn btn-primary">Ouvrir un compte</a>
			</div>
		</div>

		<div class="card" style="width: 19rem;">
			<img class="card-img-top" src="Image/compteCourant.jpg"
				alt="Card image cap">
			<div class="card-body">
				<h5 class="card-title">Creer un compte user</h5>
				<p class="card-text">Un texte ici ?</p>
				<a href="login.jsp" class="btn btn-primary">creer un compte</a>
			</div>
		</div>


		<div class="card" style="width: 19rem;">
			<img class="card-img-top" src="Image/compteTitre.jpg"
				alt="Card image cap">
			<div class="card-body">
				<h5 class="card-title">Faire un virement</h5>
				<p class="card-text">Un texte ici ?</p>
				<a href="VirementBancaire.jsp" class="btn btn-primary">Virement</a>
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

	<script src="/Resources/scripts_index.js"></script>
</body>
</html>