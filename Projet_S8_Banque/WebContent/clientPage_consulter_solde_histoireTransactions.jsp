<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="sourceCss.html" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="head.html" %>

<div id="clientPage_conslter_solde_histoireTransaction" class="container">
	<h2 style="background-color: #117D8D; color:white;">Compte</h2>
	<div class="row">
		<div class="col-sm-4 col-12" style="margin-top: 5px; margin-bottom: 10px;">
			<div class="card">
				<div class="card-body">
					<h6 class="card-title">
						Compte liquid
					</h6>
					<h5>Solde:</h5>
				</div>
			</div>
		</div>
		<div class="col-sm-4 col-12" style="margin-top: 5px; margin-bottom: 10px;">
			<div class="card">
				<div class="card-body">
					<h6 class="card-title">
						Compte epargne
					</h6>
					<h5>Solde:</h5>
				</div>
			</div>
		</div>
		<div class="col-sm-4 col-12" style="margin-top: 5px; margin-bottom: 10px;">
			<div class="card">
				<div class="card-body">
					<h6 class="card-title">
						Compte titre
					</h6>
					<h5>Solde:<span>100</span></h5>
				</div>
			</div>
		</div>
	</div>
	

	<h2 style="background-color: #117D8D; color:white;">l'historique de transactions</h2>
	<div class="col-sm-12 row" style="margin-top:10px;">
		<table class="table">
			<thead class="thead" style="background-color: #5591BB; color:white;">
				<tr>
					<th scop="col">Date</th>
					<th scop="col">Description</th>
					<th scop="col">Somme</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>date</td>
					<td>description</td>
					<td>Somme</td>
				</tr>
				<tr>
					<td>date</td>
					<td>description</td>
					<td>Somme</td>
				</tr>
				<tr>
					<td>date</td>
					<td>description</td>
					<td>Somme</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>


</body>
</html>