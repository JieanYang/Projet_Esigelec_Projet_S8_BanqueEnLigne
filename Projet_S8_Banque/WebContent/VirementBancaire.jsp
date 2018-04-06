<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css_script/styles_index.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Accueil</title>
</head>
<body class="container backC">
	<!-- head.html -->
	<%@ include file="head.html" %>


     <div class="p-3 mb-2 bg-secondary text-white"> VIREMENT BANCAIRE</div>
     

<div class=jumbotron>
 <div class=container>

 </div>
     <br/>
<br/>
   <div class="form-bottom">  
<form role="form" action="virement_servlet" method="post" class="registration-form">
  
  
  	
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
</body>
</html>