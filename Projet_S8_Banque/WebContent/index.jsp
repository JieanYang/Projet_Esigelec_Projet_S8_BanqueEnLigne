<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap 4.0  -->
<%@include file="Resources/Resources_bootstrap_4.0.html"%>
<!-- CSS for Head.html -->
<link rel="stylesheet" href="Resources/Head.css">

<title>Accueil</title>
</head>
<body>

	<!-- head.html -->
	<%@ include file="Templates/Head.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col">
				<div class="card">
					<img class="card-img-top" src="Image/livretA.jpg"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">80 euros offert à l'ouverture de compte</h5>
						<p class="card-text">0 euros Pour vos cartes Visa Classic et
							Premier et pas seulement la 1ère année</p>
						<a href="creerCompte.jsp" class="btn btn-primary">Ouvrir un
							compte</a>
					</div>
				</div>
			</div>
			
			<div class="col">
				<div class="card">
					<img class="card-img-top" src="Image/compteCourant.jpg"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">Creer un compte Client</h5>
						<p class="card-text">Devenez Client de OnlineBank et accedez à
							tous nos outils et notre plateforme de Trading</p>
						<a href="login.jsp" class="btn btn-primary">Devenir Client</a>
					</div>
				</div>
			</div>

			<div class="col">
				<div class="card">
					<img class="card-img-top" src="Image/compteTitre.jpg"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">Regarder le cours de la bourse</h5>
						<p class="card-text">Vous etes interessé par la bourse ,
							inscrivez vous et commencez à trader en réel sans frais</p>
						<a href="affichageprix.jsp" class="btn btn-primary">bourse</a>
					</div>
				</div>
			</div>

			<div class="col">
				<div class="card">
					<img class="card-img-top" src="Image/contact.png"
						alt="Card image contact message">
					<div class="card-body">
						<h5 class="card-title">Nous Contacter</h5>
						<p class="card-text">Envoyer un mail à votre conseiller</p>
						<a href="pageContact.jsp" class="btn btn-primary">Message</a>
					</div>
				</div>
			</div>
		</div>



	</div>
	
	<div style="padding:62px;"></div>
	
	<!-- footer.html -->
	<%@ include file="Templates/Footer.html"%>

	

	<!-- <script src="/Resources/scripts_index.js"></script> -->
</body>
</html>