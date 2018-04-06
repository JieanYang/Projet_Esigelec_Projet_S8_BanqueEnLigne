<%@page import="Class.Message"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%	
	Message[] messageList = {}; 
	messageList = (Message[]) session.getAttribute("MessageBeanInfo");
%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
	are you going to the beach?
	</div>
	<div>
		<%-- <jsp:getProperty name="MessageBeanInfo" property="id_message" />
		<jsp:getProperty name="MessageBeanInfo" property="nom" />
		<jsp:getProperty name="MessageBeanInfo" property="prenom" />
		<jsp:getProperty name="MessageBeanInfo" property="numphone" />
		<jsp:getProperty name="MessageBeanInfo" property="email" />
		<jsp:getProperty name="MessageBeanInfo" property="problem" />
		<jsp:getProperty name="MessageBeanInfo" property="reponse" />
		<jsp:getProperty name="MessageBeanInfo" property="date" /> --%>
	</div>
	<div>
			<%-- <%=session.getAttribute("MessageBeanInfo")%> --%>
			<%
			if (messageList != null){
				for(int i=0; i<messageList.length;i++) {
					out.println("<br>"); 
					out.println(messageList[i].getId_message());
					out.println(messageList[i].getNom());
					out.println(messageList[i].getPrenom());
					out.println(messageList[i].getNumphone());
					out.println(messageList[i].getEmail());
					out.println(messageList[i].getProblem());
					out.println(messageList[i].getReponse());
					out.println(messageList[i].getDate());
				}
			}
			%>
			
			
			<%  
			session.setAttribute("a",  "c");    
			String M = session.getAttribute("a").toString(); 
			%>
           	
	</div>
</body>
</html>