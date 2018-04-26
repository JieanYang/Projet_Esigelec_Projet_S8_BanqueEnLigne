<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List, java.util.ArrayList, java.util.HashMap, java.util.Map" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Extract data of clients</title>

<!-- Bootstrap 4.0  -->
<%@include file="Resources/Resources_bootstrap_4.0.html"%>
<!-- CSS for Head.html -->
<link rel="stylesheet" href="Resources/Head.css">
<!-- chart -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>

<%@ include file="Templates/login_verify.jsp" %>

<% System.out.println("page dataOneClient start"); %>

</head>
<% 
	//Map<String, Float> somme_income = (Map<String, Float>)session.getAttribute("somme_income");		
  // Map<String, Float> somme_outcome = (Map<String, Float>)session.getAttribute("somme_outcome");
   //Map<String, Float> total = (Map<String, Float>)session.getAttribute("total"); 
//float id_float = list_grapheData.get("id_client");
	//int id_int = (int)id_float;
%>
<body>
	<!-- head.html -->
	<%@ include file="Templates/Head.jsp"%>
	
	<div class="container">
		
		<div class="row">
			<canvas id="bar-chart-grouped"></canvas>
		</div>
	</div>
	<% 
	System.out.println(session.getAttribute("somme_income")); %>
	<script>
		// Bar chart
		new Chart(document.getElementById("bar-chart-grouped"), {
		    type: 'bar',
		    data: {
		 labels: ["banque"],
		 datasets: [
		 {
		label: "income",
		 backgroundColor: "#3e95cd",
		 data: [<%= session.getAttribute("somme_income") %>]
		  }, {
			label: "outcome",
		  backgroundColor: "#8e5ea2",
		  data: [<%= session.getAttribute("somme_outcome") %>]
		   }, {
			   label: "total",
	      backgroundColor: "#4FA632",
		  data: [<%= session.getAttribute("total") %>]
			    }
		      ]
		    },
		    options: {
		      title: {
		        display: true,
		        text: 'le total des depots effectues par les clients'
		      }
		    }
		});
	</script>
	
	<!--Footer-->
	<footer class="footer">
		<div class="container">
			<span class="colorr">Place sticky footer content here.</span>
		</div>
	</footer>
	<!--/.Footer-->

	<style type="text/css">
		.footer {
			/*position: fixed;*/
			left: 0;
			bottom: 0;
			width: 100%;
			background-color: #333;
			color: white;
			text-align: center;
		}
		
		.colorr{
			color: #ddd;
		}
	</style>
<% System.out.println("page dataOneClient finish"); %>

</body>
</html>