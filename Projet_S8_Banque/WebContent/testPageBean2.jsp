<%@page import="bean.MessageBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



<jsp:useBean id="MessageBeanInfo" class="bean.MessageBean" scope="session" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
	are you a bitch?
	</div>
	<div>
		<jsp:getProperty name="MessageBeanInfo" property="id_message" />
		<jsp:getProperty name="MessageBeanInfo" property="nom" />
		<jsp:getProperty name="MessageBeanInfo" property="prenom" />
		<jsp:getProperty name="MessageBeanInfo" property="numphone" />
		<jsp:getProperty name="MessageBeanInfo" property="email" />
		<jsp:getProperty name="MessageBeanInfo" property="problem" />
		<jsp:getProperty name="MessageBeanInfo" property="reponse" />
		<jsp:getProperty name="MessageBeanInfo" property="date" />
	</div>
</body>
</html>