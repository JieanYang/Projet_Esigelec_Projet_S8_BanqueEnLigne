<%@page import="Class.Transaction, Class.Compte, java.util.List, java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%	
	List<Compte> compteList = new ArrayList<Compte>(); 
	compteList = (List<Compte>) session.getAttribute("CompteInfo");
	
	List<Transaction> transactionList = new ArrayList<Transaction>(); 
	transactionList = (List<Transaction>) session.getAttribute("TransactionInfo");
	
	

	int id_compte_courrant = -1;
	int id_compte_epargne = -1;
	int id_compte_titre = -1;
	for(Compte item: compteList){
		if(item.getCategorie_compte().equals("courrant")){
			id_compte_courrant = item.getId_compte();
			// System.out.println(id_compte_courrant);
		}
		if(item.getCategorie_compte().equals("epargne")){
			id_compte_epargne = item.getId_compte();
			// System.out.println(id_compte_epargne);
		}
		if(item.getCategorie_compte().equals("titre")){
			id_compte_titre = item.getId_compte();
			// System.out.println(id_compte_titre);
		}
		
	}
	

	
%>

<!-- Bootstrap 4.0  -->
<%@include file="Resources/Resources_bootstrap_4.0.html" %>

<!-- CSS for Head.html -->
<link rel="stylesheet" href="Resources/styles_index.css">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="/Templates/Head.html" %>

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
		<div class="col-sm-12">
			<ul class="nav nav-tabs" id="myTab" role="tablist">
			  <li class="nav-item">
			    <a class="nav-link active" id="courrant-tab" data-toggle="tab" href="#courrant" role="tab" aria-controls="courrant" aria-selected="true" style="color: #4D85AD;">Compte courrant</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" id="epargne-tab" data-toggle="tab" href="#epargne" role="tab" aria-controls="epargne" aria-selected="false" style="color: #4D85AD;">Compte epargne</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" id="titre-tab" data-toggle="tab" href="#titre" role="tab" aria-controls="titre" aria-selected="false" style="color: #4D85AD;">Compte titre</a>
			  </li>
			</ul>
		</div>
		<div class="col-sm-12">
			<div class="tab-content" id="myTabContent">
			  <div class="tab-pane fade show active" id="courrant" role="tabpanel" aria-labelledby="courrant-tab" style="background-color: white; color: black">
			  	<table class="table" style="margin-top: 10px;">
					<thead class="thead" style="background-color: #046380; color:white;">
						<tr>
							<th scop="col">Date</th>
							<th scop="col">Description</th>
							<th scop="col">Somme</th>
						</tr>
					</thead>
					<tbody>	
						<%
							List<Integer> list_existence_courrant = new ArrayList<Integer>();
							System.out.println("courrant"+id_compte_courrant);
							for(Transaction item: transactionList){
								if( id_compte_courrant == item.getId_compte_emetteur() || id_compte_courrant == item.getId_compte_recepteur() ){
									if(list_existence_courrant.indexOf(item.getId_transaction()) == -1 ){
										list_existence_courrant.add(item.getId_transaction());
										out.println("<tr>");
										out.println("<td>"+item.getDate_transaction()+"</td>");
										out.println("<td>"+item.getDescription()+"</td>");
										if( id_compte_courrant == item.getId_compte_emetteur()){
											out.println("<td>"+"-"+item.getSomme()+"</td>");
										}else{
											out.println("<td>"+"+"+item.getSomme()+"</td>");
										}
										out.println("</tr>");
									}
								}
							}
						%>
					</tbody>
				</table>
			  </div>
			  <div class="tab-pane fade" id="epargne" role="tabpanel" aria-labelledby="epargne-tab" style="background-color: white; color: black">
			  		<table class="table" style="margin-top: 10px;">
						<thead class="thead" style="background-color: #046380; color:white;">
							<tr>
								<th scop="col">Date</th>
								<th scop="col">Description</th>
								<th scop="col">Somme</th>
							</tr>
						</thead>
						<tbody>	
							<%
								List<Integer> list_existence_epargne = new ArrayList<Integer>();
								System.out.println("epargne"+id_compte_epargne);
								for(Transaction item: transactionList){
									if( id_compte_epargne == item.getId_compte_emetteur() || id_compte_epargne == item.getId_compte_recepteur() ){
										if(list_existence_epargne.indexOf(item.getId_transaction()) == -1 ){
											list_existence_epargne.add(item.getId_transaction());
											out.println("<tr>");
											out.println("<td>"+item.getDate_transaction()+"</td>");
											out.println("<td>"+item.getDescription()+"</td>");
											if( id_compte_epargne == item.getId_compte_emetteur()){
												out.println("<td>"+"-"+item.getSomme()+"</td>");
											}else{
												out.println("<td>"+"+"+item.getSomme()+"</td>");
											}
											out.println("</tr>");
										}
									}
								}
							%>
						</tbody>
					</table>
			  </div>
			  <div class="tab-pane fade" id="titre" role="tabpanel" aria-labelledby="titre-tab" style="background-color: white; color: black">
			  		<table class="table" style="margin-top: 10px;">
						<thead class="thead" style="background-color: #046380; color:white;">
							<tr>
								<th scop="col">Date</th>
								<th scop="col">Description</th>
								<th scop="col">Somme</th>
							</tr>
						</thead>
						<tbody>	
							<%
								List<Integer> list_existence_titre = new ArrayList<Integer>();
								System.out.println("epargne"+id_compte_titre);
								for(Transaction item: transactionList){
									if( id_compte_titre == item.getId_compte_emetteur() || id_compte_titre == item.getId_compte_recepteur() ){
										if(list_existence_titre.indexOf(item.getId_transaction()) == -1 ){
											list_existence_titre.add(item.getId_transaction());
											out.println("<tr>");
											out.println("<td>"+item.getDate_transaction()+"</td>");
											out.println("<td>"+item.getDescription()+"</td>");
											if( id_compte_titre == item.getId_compte_emetteur()){
												out.println("<td>"+"-"+item.getSomme()+"</td>");
											}else{
												out.println("<td>"+"+"+item.getSomme()+"</td>");
											}
											out.println("</tr>");
										}
									}
								}
							%>
						</tbody>
					</table>
			  </div>
			</div>
		</div>	
		
		
	</div>
</div>


</body>
</html>