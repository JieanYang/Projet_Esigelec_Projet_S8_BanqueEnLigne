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
			<%for(int i=0; i<messageList.length;i++) {%>
			<%out.println("<br>"); %>
			<%=messageList[i].getId_message()%>
			<%=messageList[i].getNom()%>
			<%=messageList[i].getPrenom()%>
			<%=messageList[i].getNumphone()%>
			<%=messageList[i].getEmail()%>
			<%=messageList[i].getProblem()%>
			<%=messageList[i].getReponse()%>
			<%=messageList[i].getDate()%>
			<%}%>
			
			
			<%  
			session.setAttribute("a",  "c");    
			String M = session.getAttribute("a").toString(); 
			%>
           	
	</div>
</body>
</html>