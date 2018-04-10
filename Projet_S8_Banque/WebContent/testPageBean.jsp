<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="TestBeanServlet" method="GET">
	<input name="method" value="GET" style="display:none;">


	<button type="submit">
		get
	</button>
</form>
<form action="TestBeanServlet" method="POST">
	<input name="method" value="POST" style="display:none;">
	
	<button type="submit">
		post
	</button>
</form>
<form action="TestBeanServlet" method="POST">
	<input name="method" value="DELETE" style="display:none;">

	<button type="submit">
		delete
	</button>
</form>
<form action="ClientServlet_consulter_solde_histoire" method="GET">
	<input name="method" value="GET" style="display:none;">
	
	<input name="id_client" value=3>
	<button type="submit">
		get client solde and histoire
	</button>
</form>

<form action="ClientServlet_consulter_solde_histoire" method="GET">
	<input name="method" value="extractCSV" style="display:none;">
	
	<input name="id_client" value=3>
	<button type="submit">
		extract CSV
	</button>
</form>

<form action="AuthentificationServlet" method="GET">
	<input name="method" value="login" style="display:none;">
	
	<input name="id_user" value=3>
	<button type="submit">
		login
	</button>
</form>
<form action="AuthentificationServlet" method="GET">
	<input name="method" value="logout" style="display:none;">

	<button type="submit">
		logout
	</button>
</form>

</body>
</html>