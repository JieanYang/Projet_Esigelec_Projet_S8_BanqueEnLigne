<!-- Bootstrap 4.0  -->
<%@include file="Resources/Resources_bootstrap_4.0.html"%>
<!-- CSS for Head.html -->
 <link rel="stylesheet" href="Resources/Head.css">
<%@page import="Class.Entreprise"%>
<%@page import="Class.Actions"%>
<%@page import="servlet.ServletAchatAction"%>
<%@page import="java.util.ArrayList" import="java.util.Date"%>
<html>
<head>
<title>Achat d'Action</title>
</head>

<body>
    <!-- head.html -->
	<%@ include file="Templates/Head.jsp"%>

    <div class="container">
        <div class="row">
            <div class="col-sm-8 offset-sm-2">
               <div class="p-3 mb-2 bg-secondary text-white"> <center>Achat d'action</center></div>
            </div>
        </div>
        
         <div class="container">
		<div class="row justify-content-center">
			<h2>Vos actions</h2>
			<table class="table">

				<thead class="thead-dark">
					<tr>
						<th scope="col">id_user</th>
						<th scope="col">entreprise</th>
						<th scope="col">prix achat</th>
						<th scope="col">date</th>
						<th scope="col">nombre</th>
					</tr>
				</thead>
				<tbody>
					<%
						ArrayList<Actions> listAct = (ArrayList<Actions>) request.getAttribute("listAct");
						for (int i = 0; i < listAct.size(); i++) {
					%>
					<tr class="table-secondary">
						<td><%=listAct.get(i).getid_user()%></td>
						<td><%=listAct.get(i).getentreprise()%></td>
						<td><%=listAct.get(i).getprixachat()%></td>
						<td><%=listAct.get(i).getdate()%></td>
						<td><%=listAct.get(i).getnombre()%></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>

	</div>
	 <form action="AjoutAction">
	
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
						<th scope="col">Nombre</th>
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
						<td><label for="inputName4"></label>
					      <input type="text" class="form-control" name="<%=listEnt.get(i).getNom()%>" id="inputName4"></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>

	</div>
	
	<div class="form-group ">
					      <label for="inputState">Type :</label>
					      <select name="type" id="inputState" class="form-control">
					        <option selected>type de transaction</option>
					        <option>Achat</option>
					        <option>Vente</option>
					        
					      </select>
					    </div>
	<br>
	                  <center><button type="submit" class="btn btn-primary">Valider</button></center>
	<br>
	
                  </form>
                  <center><button type="submit" class="btn btn-primary">Retour</button></center>
                
            </div>
        </div>
    </div>
    
        <!-- footer.html -->
    <%@ include file="Templates/Footer.html"%>

</body>

</html>