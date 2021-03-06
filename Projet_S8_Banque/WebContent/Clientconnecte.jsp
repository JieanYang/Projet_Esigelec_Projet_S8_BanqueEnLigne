<%@ page pageEncoding="UTF-8" %>

<!-- login_verify, if it's not user, redirect to index.jsp -->
<%@include file="/Templates/login_verify.jsp" %>

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
	<%@ include file="/Templates/Head.jsp" %>

	<div class="container">
		<div class="row">
			<div class="col">
				<div class="card">
					<img class="card-img-top" src="Image/livretA.jpg"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">Ouvrir un Compte par user compte</h5>
						<p class="card-text">Un texte ici ?</p>
						<a href="creerCompteByUser.jsp" class="btn btn-primary">Ouvrir mon compte</a>
					</div>
				</div>
			</div>
				
			<div class="col">
				<div class="card">
					<img class="card-img-top" src="Image/virement.jpg"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">Faire un virement</h5>
						<p class="card-text">Un texte ici ?</p>
						<a href="VirementBancaire.jsp" class="btn btn-primary">Virement</a>
					</div>
				</div>
			</div>
			
			<div class="col">
				<div class="card">
					<img class="card-img-top" src="Image/modification.jpg"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">Faire une modification</h5>
						<p class="card-text">Un texte ici ?</p>
						<a href="Modification.jsp" class="btn btn-primary">Modifier</a>
					</div>
				</div>
			</div>
			
			<div class="col">
				<div class="card">
					<img class="card-img-top" src="Image/histoire of transaction.jpg"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">Solde et l'histoire des transactions</h5>
						<p class="card-text"></p>
						<form action="ClientServlet_consulter_solde_histoire" method="GET">
							<input name="method" value="GET" style="display:none;">
							
							<input name="id_user" value="<%=session.getAttribute("id_user") %>" style="display:none;">
							<button type="submit" class="btn btn-primary">
								Consulter
							</button>
						</form>
					</div>
				</div>
			</div>
			
			<div class="col">
				<div class="card">
					<img class="card-img-top" src="Image/achat actions.png"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">Achat ou vente d'actions</h5>
						<p class="card-text"></p>
						<form action="ServletAchatAction" method="GET">
							<input name="method" value="GET" style="display:none;">
							
							<input name="id_user" value="<%=session.getAttribute("id_user") %>" style="display:none;">
							<button type="submit" class="btn btn-primary">
								Consulter
							</button>
						</form>
					</div>
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

	</div>



	<div style="padding:75.5px;"></div>
	

	<!-- footer.html -->
	<%@ include file="Templates/Footer.html"%>

	<!-- <script src="/Resources/scripts_index.js"></script> -->

</body>
</html>