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

<title>Accueil</title>
</head>
<body class="container backC">

	<!-- head.html -->
	<%@ include file="head.html" %>



	<!--login form-->
	
	<div id="id01" class="modal">
		
		
		<!-- *********************************************************************************************************** -->
		<!--  <div class="container">
		<div class="row">
		<div class="col-md-4 col-md-offset-4">
		<div class="form-body">
		    <ul class="nav nav-tabs final-login">
		        <li class="active"><a data-toggle="tab" href="#sectionA">Sign In</a></li>
		        <li><a data-toggle="tab" href="#sectionB">Join us!</a></li>
		    </ul>
		    <div class="tab-content">
		        <div id="sectionA" class="tab-pane fade in active">
			        <div class="innter-form">
			            <form class="sa-innate-form" method="post">
				            <label>Email Address</label>
				            <input type="text" name="username">
				            <label>Password</label>
				            <input type="password" name="password">
				            <button type="submit">Sign In</button>
				            <a href="">Forgot Password?</a>
			            </form>
			         </div>
		            <div class="social-login">
		            <p>- - - - - - - - - - - - - Sign In With - - - - - - - - - - - - - </p>
		    		<ul>
		            <li><a href=""><i class="fa fa-facebook"></i> Facebook</a></li>
		            <li><a href=""><i class="fa fa-google-plus"></i> Google+</a></li>
		            <li><a href=""><i class="fa fa-twitter"></i> Twitter</a></li>
		            </ul>
		            </div>
		            <div class="clearfix"></div>
		        </div>
		        <div id="sectionB" class="tab-pane fade">
					<div class="innter-form">
		            <form class="sa-innate-form" method="post">
		            <label>Name</label>
		            <input type="text" name="username">
		            <label>Email Address</label>
		            <input type="text" name="username">
		            <label>Password</label>
		            <input type="password" name="password">
		            <button type="submit">Join now</button>
		            <p>By clicking Join now, you agree to hifriends's User Agreement, Privacy Policy, and Cookie Policy.</p>
		            </form>
		            </div>
		            <div class="social-login">
		            <p>- - - - - - - - - - - - - Register With - - - - - - - - - - - - - </p>
					<ul>
		            <li><a href=""><i class="fa fa-facebook"></i> Facebook</a></li>
		            <li><a href=""><i class="fa fa-google-plus"></i> Google+</a></li>
		            <li><a href=""><i class="fa fa-twitter"></i> Twitter</a></li>
		            </ul>
		            </div>
		        </div>
		    </div>
		    </div>
		    </div>
		    </div>
		    </div>
				
		
		
		
		
		<!--  <form class="modal-content animate" action="Login" method="post">
			<div class="imgcontainer">
				<span onclick="document.getElementById('id01').style.display='none'"
					class="close" title="Close Modal">&times;</span>
				<!--<img src="img_avatar2.png" alt="Avatar" class="avatar">-->
			<!--  </div>

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
			<!-- </div>

			<div class="container" style="background-color: #f1f1f1">
				<button type="button"
					onclick="document.getElementById('id01').style.display='none'"
					class="cancelbtn">Annuler</button>
				<!--<span class="psw">Forgot <a href="#">password?</a></span>-->
			<!-- </div>
		</form>-->
	</div>


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

	<script src="css_script/scripts_index.js"></script>
</body>
</html>