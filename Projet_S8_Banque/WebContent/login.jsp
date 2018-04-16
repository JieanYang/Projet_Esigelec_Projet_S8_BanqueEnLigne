<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bootstrap Login &amp; Register Templates</title>        
        
        <!-- Bootstrap 4.0  -->
		<%@include file="Resources/Resources_bootstrap_4.0.html" %>
		
		<!-- CSS for Head.html -->
		<link rel="stylesheet" href="Resources/styles_index.css">


    </head>

    <body>
    
   		<%@ include file="Templates/Head.jsp" %>

        <!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                	
                    <div class="row justify-content-center">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1> Inscription client</h1>
                        </div>
                    </div>
                    
                    <div class="row"> 
                        
                        <div class="col-sm-1 middle-border"></div>
                        <div class="col-sm-1"></div>
                        	
                        <div class="col-sm-5">
                        	
                        	<div class="form-box">
                        		<div class="form-top">
	                        		<div class="form-top-left">
	                        			<h3>Sign up now</h3>
	                            		<p>Fill in the form below to get instant access:</p>
	                        		</div>
	                        		<div class="form-top-right">
	                        			<i class="fa fa-pencil"></i>
	                        		</div>
	                            </div>
	                            <div class="form-bottom">
				                    <form role="form" action="Register" method="post" class="registration-form">
				                    	
				                        <div class="form-group">
				                        	<label class="sr-only" for="form-first-name">Firstname</label>
				                        	<input type="text" name="firstname" placeholder="Firstname..." class="form-first-name form-control" id="form-first-name">
				                        </div>
				                         <div class="form-group">
				                        	<label class="sr-only" for="form-last-name">Lastname</label>
				                        	<input type="text" name="lastname" placeholder="Lastname..." class="form-last-name form-control" id="form-last-name">
				                        </div>
				                        <div class="form-group">
				                        	<label class="sr-only" for="form-email">Email</label>
				                        	<input type="text" name="email" placeholder="Email..." class="form-email form-control" id="form-email">
				                        </div>
				                       <div class="form-group">
				                        	<label class="sr-only" for="form-password">Password</label>
				                        	<input type="password" name="password" placeholder="Password..." class="form-password form-control" id="form-password">
				                        </div>
				                       
				                        <button type="submit" class="btn">Envoyer</button>
				                    </form>
			                    </div>
                        	</div>
                        	
                        </div>
                    </div>
                    
                </div>
            </div>
            
        </div>

        <!-- Footer -->
        <footer>
        	<div class="container">
        		<div class="row">
        			
        			<div class="col-sm-8 col-sm-offset-2">
        				<div class="footer-border"></div>
        				
        			</div>
        			
        		</div>
        	</div>
        </footer>

        <!-- Javascript -->
        <script src="assets/js/jquery-1.11.1.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/scripts.js"></script>
        
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>