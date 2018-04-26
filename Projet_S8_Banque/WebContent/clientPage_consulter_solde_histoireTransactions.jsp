<%@page import="Class.Transaction, Class.Compte, java.util.List, java.util.ArrayList, java.util.Map, java.util.HashMap,
dao.CompteDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<!-- login_verify, if it's not user, redirect to index.jsp -->
<%@include file="/Templates/login_verify.jsp" %>


<%	
	Map compteIdList = new HashMap(); 
	compteIdList = (Map) session.getAttribute("CompteInfo");
	int id_compte_courrant = Integer.valueOf((String)compteIdList.get("courant"));
	int id_compte_epargne = Integer.valueOf((String)compteIdList.get("epargne"));
	int id_compte_titre = Integer.valueOf((String)compteIdList.get("titre"));
	
	Map transactionList = new HashMap(); 
	transactionList = (Map) session.getAttribute("TransactionInfo");	
/* 	List<Transaction> transactionList = new ArrayList<Transaction>(); 
	transactionList = (List<Transaction>) session.getAttribute("TransactionInfo"); */



	

	
%>

<!-- Bootstrap 4.0  -->
<%@include file="Resources/Resources_bootstrap_4.0.html"%>
<!-- CSS for Head.html -->
 <link rel="stylesheet" href="Resources/Head.css">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- head.html -->
<%@ include file="Templates/Head.jsp"%>

<%!
public String fillSolde(int id_compte) {
	CompteDao compteDao = new CompteDao();
	String retour = new String();
	
	retour = "None";
	retour = String.valueOf(compteDao.getCompte(id_compte).getSolde());

	return retour;
}
%>

<%!
public String takeId_compte(int id_compte) {
	CompteDao compteDao = new CompteDao();
	String retour = new String();
	
	retour = "None";
	retour = String.valueOf(compteDao.getCompte(id_compte).getId_compte());

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
						Compte courrant <span>
						<%
							out.println("<br>Numero compte: " + takeId_compte(id_compte_courrant));
						%></span>
					</h6>
					<h5>Solde:<sapn>
					<% 
						out.println(fillSolde(id_compte_courrant));
					%>
					</sapn></h5>
				</div>
			</div>
		</div>
		<div class="col-sm-4 col-12" style="margin-top: 5px; margin-bottom: 10px;">
			<div class="card">
				<div class="card-body">
					<h6 class="card-title">
						Compte epargne <span>
						<%
							out.println("<br>Numero compte: " + takeId_compte(id_compte_epargne));
						%></span>
					</h6>
					<h5>Solde:<span>
					<% 
						out.println(fillSolde(id_compte_epargne));
					%>
					</span></h5>
				</div>
			</div>
		</div>
		<div class="col-sm-4 col-12" style="margin-top: 5px; margin-bottom: 10px;">
			<div class="card">
				<div class="card-body">
					<h6 class="card-title">
						Compte titre <span>
						<%
							out.println("<br>Numero compte: " + takeId_compte(id_compte_titre));
						%></span>
					</h6>
					<h5>Solde:<span>
					<% 
						out.println(fillSolde(id_compte_titre));
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
			   <li class="nav-item">
					<form action="ClientServlet_consulter_solde_histoire" method="GET">
						<input name="method" value="extractCSV" style="display:none;">
						
						<input name="id_user" value=<%=session.getAttribute("id_user") %> style="display:none;">
						<button type="submit" style="width: 30px; height: 30px; margin-left:10px; padding-right:0; background: url(Image/extractCSV.png); background-size:30px 30px; background-repeat:no-repeat;">
						<!-- 	<img src="Image/extractCSV.png" alt="Download CSV" style="width: 30px; height: 30px;"> -->
						</button>
					</form>
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
							// System.out.println("courrant"+id_compte_courrant);
							for(Transaction item: (List<Transaction>)transactionList.get("courant")){
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
								// System.out.println("epargne"+id_compte_epargne);
								for(Transaction item: (List<Transaction>)transactionList.get("epargne")){
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
								// System.out.println("epargne"+id_compte_titre);
								for(Transaction item: (List<Transaction>)transactionList.get("titre")){
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
							%>
						</tbody>
					</table>
			  </div>
			</div>
		</div>	
		
		
	</div>
</div>

	<!-- footer.html -->
	<%@ include file="Templates/Footer.html"%>

</body>
</html>