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

<title>Accueil</title>
</head>
<body class="container backC">
	<!-- top navigation -->
	<div class="topnav" id="myTopnav">
		<a href="#home" class="active">Accueil</a> <a href="#news">News</a> <a
			href="#bourse">Bourse</a> <a href="javascript:void(0);" class="icon"
			onclick="myFunction()">&#9776;</a>
	</div>
	<!-- header -->
	<div class="header">
		<a href="#default" class="logo">OnlineBank</a>
		<div class="header-right">
			<a class="btn active" name="espaceClient"
				onclick="document.getElementById('id01').style.display='block'"
				style="width: auto;">Espace Client</a>
			<!--<a class="active" href="#home">Home</a>
                <a href="#contact">Contact</a>
                <a href="#about">About</a>-->
		</div>
	</div>


	<!--login form-->
	<div id="id01" class="modal">

		<form class="modal-content animate" action="Login" method="post">
			<div class="imgcontainer">
				<span onclick="document.getElementById('id01').style.display='none'"
					class="close" title="Close Modal">&times;</span>
				<!--<img src="img_avatar2.png" alt="Avatar" class="avatar">-->
			</div>

			<div class="container">
				<label for="username"><b>Identifiant/Email</b></label> <input
					type="text" placeholder="Entrez votre Identifiant ou Email"
					name="username" required> <label for="psw"><b>Mot
						de passe</b></label> <input type="password"
					placeholder="Entrez votre Mot de passe" name="password" required>

				<button type="submit">Connexion</button>
				<!--<label>
        <input type="checkbox" checked="checked" name="remember"> Remember me
      </label>-->
			</div>

			<div class="container" style="background-color: #f1f1f1">
				<button type="button"
					onclick="document.getElementById('id01').style.display='none'"
					class="cancelbtn">Annuler</button>
				<!--<span class="psw">Forgot <a href="#">password?</a></span>-->
			</div>
		</form>
	</div>


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