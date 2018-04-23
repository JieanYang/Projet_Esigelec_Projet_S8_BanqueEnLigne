<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<title>Demo CSS Table Price Hosting Plan</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="shortcut icon" href=http://www.freshdesignweb.com/wp-content/themes/fv24/images/icon.ico />
    <link rel="stylesheet" type="text/css" href="Resources/css3-table-price-hosting/styles.css" media="all" />
    <link rel="stylesheet" type="text/css" href="Resources/css3-table-price-hosting/demo.css" media="all" />

</head>
<body>
<div class="container">
			
            <div class="freshdesignweb-top">
                <a href="index.jsp" target="_blank">Home</a>
                <span class="right">
                   
                </span>
                <div class="clr"></div>
            </div>
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


	<!-- footer.html -->
	<%@ include file="Templates/Footer.html"%>
</body>
</html>
