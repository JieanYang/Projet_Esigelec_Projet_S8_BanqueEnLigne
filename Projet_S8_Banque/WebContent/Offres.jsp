<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class=jumbotron>
 <div class=container>

 </div>
     <br/>
<br/>

<!--  <div class="container" >
<h1 style="text-align:center;"><a href="index.jsp" >ACTUALITES</a></h1>
 
  
  <br>
  <br>
  
  						<table border="2">
							<tbody>
								<tr><th>nom_service</th><th>description</th></tr><!-- entete du tableau -->
								<!--<c:forEach items="${liste}" var="emp"><!-- boucle for en jstl et on envoi la variable  -->
									<!--  <tr>
										chaque code insee est un lien cliquable qui redirige vers la servlet compareServlet-->
										<!--<td><c:out value="${emp.getNom_service()}"></c:out></td> recupere les attribus de l'objet actu individuellement(emp) pour l'inserer dans le tableau -->
										<!--<td><c:out value="${emp.getDescription()}"></c:out></td>
										
										
									</tr>
								</c:forEach>
							</tbody>
						</table>
  
  
</div>-->

</body>
</html>


<html>
<head>
<title>Demo CSS Table Price Hosting Plan</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="shortcut icon" href=http://www.freshdesignweb.com/wp-content/themes/fv24/images/icon.ico />
    <link rel="stylesheet" type="text/css" href="styles.css" media="all" />
    <link rel="stylesheet" type="text/css" href="demo.css" media="all" />
</head>
<body>
<div class="container">
			
            <div class="freshdesignweb-top">
                <a href="index.jsp" target="_blank">Home</a>
                <span class="right">
                   
                </span>
                <div class="clr"></div>
            </div><!--/ freshdesignweb top bar -->
			<header>
				<h1><span>Nos Offres</span></h1>
				<h2>Retrouver ci dessous les offres de votre banque</h2>
            </header>       
     <!-- start header here-->
	<header>
<div id="fdw-pricing-table">
<c:forEach items="${liste}" var="emp"><!-- boucle for en jstl et on envoi la variable  -->
    <div class="plan plan1 popular-plan">
        <div class="header"><c:out value="${emp.getNom_service()}"></c:out></td></div>
        

      
         <div class="field">
  <div class="control">
    <textarea class="textarea is-large" type="text" rows="10" disabled><c:out value="${emp.getDescription()}"></c:out></textarea> <!--  recupere les attribus de l'objet offre individuellement(emp) pour l'inserer dans le tableau -->
  </div>
</div>
         
         
    </div>
    </c:forEach>
    
</div>
	</header>
    
</div>
</body>
</html>
