<%@page import="Class.Transaction, Class.Compte, java.util.List, java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%	
	List<Compte> compteList = new ArrayList<Compte>(); 
	compteList = (List<Compte>) session.getAttribute("CompteInfo");
	
	List<Transaction> transactionList = new ArrayList<Transaction>(); 
	transactionList = (List<Transaction>) session.getAttribute("TransactionInfo");
%>


<%@include file="sourceCss.html" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="head.html" %>

<div class="container row">
	<%
	if (compteList != null ){
		out.println("<br>"+compteList);
	} 
	if (transactionList != null ){
		out.println("<br>"+transactionList);
	}
	%>
</div>

<%!
public String fillSolde(String categorie, List<Compte> compteList) {
	String retour = new String();
	for(Compte item: compteList){
		// System.out.println(item.getCategorie_compte());
		if((item.getCategorie_compte().equals(categorie))){
			retour = String.valueOf(item.getSolde());
			// System.out.println(retour);
		}
		
		if(retour == null){
			retour = "None";
		}
	}
	System.out.println(retour);
	return retour;
}
%>

<div id="clientPage_conslter_solde_histoireTransaction" class="container">
	<h2 style="background-color: #117D8D; color:white;">Compte</h2>
	<div class="row">
		<div class="col-sm-4 col-12" style="margin-top: 5px; margin-bottom: 10px;">
			<div class="card">
				<div class="card-body">
					<h6 class="card-title">
						Compte courrant
					</h6>
					<h5>Solde:<sapn>
					<% 
						out.println(fillSolde("courrant", compteList));
					%>
					</sapn></h5>
				</div>
			</div>
		</div>
		<div class="col-sm-4 col-12" style="margin-top: 5px; margin-bottom: 10px;">
			<div class="card">
				<div class="card-body">
					<h6 class="card-title">
						Compte epargne
					</h6>
					<h5>Solde:<span>
					<% 
						out.println(fillSolde("epargne", compteList));
					%>
					</span></h5>
				</div>
			</div>
		</div>
		<div class="col-sm-4 col-12" style="margin-top: 5px; margin-bottom: 10px;">
			<div class="card">
				<div class="card-body">
					<h6 class="card-title">
						Compte titre
					</h6>
					<h5>Solde:<span>
					<% 
						out.println(fillSolde("titre", compteList));
					%>
					</span></h5>
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
				<%
					for(Transaction item: transactionList){
						out.println("<tr>");
						out.println("<td>"+item.getDate_transaction()+"</td>");
						out.println("<td>"+item.getDescription()+"</td>");
						out.println("<td>"+item.getSomme()+"</td>");
						out.println("</tr>");
						
					}
				%>
				<!-- <tr>
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
				</tr> -->
			</tbody>
		</table>
	</div>
</div>


</body>
</html>