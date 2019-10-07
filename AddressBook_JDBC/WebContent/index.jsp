<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="lt.bit.data.Person" %>
<%@page import="lt.bit.db.DB" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		for (Person p : DB.getAll()) {
	%>
	<%=p.getId()%>
	<%=p.getFirstName()%>
	<%=p.getLastName()%>
	<%=p.getBirthDate()%>
	<%=p.getSalary()%>
	<a style="margin-right: 10px;" href="delete?id=<%=p.getId()%>">Delete</a>
	<a style="margin-right: 10px;" href="edit.jsp?id=<%=p.getId()%>">Edit</a>
	<a style="margin-right: 10px;" href="addressList.jsp?id=<%=p.getId()%>">Show Address List</a>
	<a style="margin-right: 10px;" href="contactList.jsp?id=<%=p.getId()%>">Show Contact List</a>
	<hr>
	<%
		}
	%>
	<a href="edit.jsp">New</a>
</body>
</html>