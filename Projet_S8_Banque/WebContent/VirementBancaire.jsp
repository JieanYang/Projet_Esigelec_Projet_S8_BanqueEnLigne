

<!-- login_verify, if it's not user, redirect to index.jsp -->
<%@include file="/Templates/login_verify.jsp" %>

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
			<div class="col-sm-12">
			     <div class="p-3 mb-2 bg-secondary text-white"> VIREMENT BANCAIRE</div>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-12">
			     <form role="form" action="BordereauServlet" method="post" class="registration-form">
					<button type="submit" class="btn btn-primary" >Faire un virement par cheque</button>
				</form>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-12">
			     <form role="form" action="BoredereauCheque" method="post" class="registration-form">
				  	    <div class="form-group ">
					      <label for="inputState">Je veux faire un virement :</label>
					      <select name="type" id="inputState" class="form-control">
					        <option selected>type de virement</option>
					        <option>Mensuel</option>
					        <option>Occasionel</option>
					      </select>
					    </div>
					    <br>
					    
					  <div class="form-row">
					    <div class="form-group col-md-6">
					      <label for="inputName4">Numero compte émétteur :</label>
					      <input type="text" class="form-control" name="emetteur" id="inputName4" placeholder="XXXX XXXX XXXXXXXXXXX XX" required>
					    </div>
					    
					    <div class="form-group col-md-6">
					      <label for="inputName4">Numero compte bénéficiaire :</label>
					      <input type="text" class="form-control" name="beneficiaire" id="inputName4" placeholder="XXXX XXXX XXXXXXXXXXX XX" required>
					    </div>
					    
					    <div class="form-group col-md-6">
					      <label for="inputName4">date_transaction : </label>
					      <input type="date" class="form-control" name="date_transaction" id="inputdate">
					    </div>
					    
					    <div class="form-group col-md-6">
					      <label for="inputName4">date_create : </label>
					      <input type="date" class="form-control" name="date_create" id="inputdate">
					    </div>
					    
					  </div>
					  <div class="form-group">
					    <label for="inputAddress">Montant du virement : </label>
					    <input type="text" class="form-control" name="montant" id="inputmontant" placeholder="150" required>
					  </div>
					  
					  <div class="form-group">
					    <label for="inputAddress">Message</label>
					    <input type="text" class="form-control" name="message" id="inputmessages" placeholder="virement pour le loyer" required>
					  </div>


					  <button type="submit" class="btn btn-primary">Envoyer</button>
				</form>
			</div>
		</div>
	</div>
	
	<!-- footer.html -->
	<%@ include file="Templates/Footer.html"%>
</body>
</html>