<%@page import="Class.Entreprise"%>
<%@page import="servlet.ServletCoursDeLaBourse"%>
<%@page import="java.util.ArrayList" import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Bootstrap 4.0  -->
<%@include file="Resources/Resources_bootstrap_4.0.html"%>
<!-- CSS for Head.html -->
<link rel="stylesheet" href="Resources/Head.css">

<!-- jquery -->
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!-- ??? -->
<link rel="stylesheet" href="css_script/form.css">
<!-- Chart -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>

<title>Cours de la bourse</title>
</head>
<body>

	<!-- head.html -->
	<%@ include file="/Templates/Head.jsp"%>

	<div class="container">
		<canvas id="myChart"></canvas>
	</div>

	<%
		ArrayList<String> stringDateList = (ArrayList<String>) request.getAttribute("stringDateList");
		ArrayList<Integer> listeCour = (ArrayList<Integer>) request.getAttribute("listeCour");
	%>

	<script>
		var myChart = document.getElementById('myChart').getContext('2d');

		// chart data from the servlet

		var courDeLaBourse = new Chart(myChart, {
			type : 'line', // bar, horizontalBar, pri, line, doughnut, radar, polarArea
			data : {
				labels :<%-- <%=stringDateList%> --%>
				[<%for (int i = 0; i < stringDateList.size(); i++) {%>
					<%="'" + stringDateList.get(i) + "',"%>
				<%}%>]
		,
				datasets : [ {
					label : 'Dernier cour',
					data :<%=listeCour%>
		,
					backgroundColor : '#5eb5ef',
					borderColor : '#5eb5ef',
					fill : false,
				} ]
			},
			options : {
				title : {
					display : true,
					text : 'Cours de la bourse CAC40',
					fontSize : 20,
				},
				legend : {
					position : 'bottom',
					labels : {
						fontColor : 'black'
					}
				}
			}
		});
	</script>
	<div class="container">
		<div class="row justify-content-center">
			<h2>Cotations du CAC40</h2>
			<table class="table">

				<thead class="thead-dark">
					<tr>
						<th scope="col">Nom</th>
						<th scope="col">Ouverture</th>
						<th scope="col">+ Haut</th>
						<th scope="col">+ Bas</th>
						<th scope="col">Volume</th>
						<th scope="col">Veille</th>
						<th scope="col">Dernier</th>
						<th scope="col">Var</th>
					</tr>
				</thead>
				<tbody>

					<%
						ArrayList<Entreprise> listEnt = (ArrayList<Entreprise>) request.getAttribute("listEnt");
						for (int i = 0; i < listEnt.size(); i++) {
					%>
					<tr class="table-secondary">
						<td><%=listEnt.get(i).getNom()%></td>
						<td><%=listEnt.get(i).getOuverture()%></td>
						<td><%=listEnt.get(i).getHaut()%></td>
						<td><%=listEnt.get(i).getBas()%></td>
						<td><%=listEnt.get(i).getVolume()%></td>
						<td><%=listEnt.get(i).getVeille()%></td>
						<td><%=listEnt.get(i).getDernier()%></td>
						<td><%=listEnt.get(i).getVar()%></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>

	</div>

	<!-- footer.html -->
	<%@ include file="Templates/Footer.html"%>

</body>
</html>