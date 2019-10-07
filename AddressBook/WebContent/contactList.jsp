<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="lt.bit.data.Person" %>
<%@page import="lt.bit.data.Contact" %>
<%@page import="lt.bit.db.DB" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String idS = request.getParameter("id");
	
		if (idS == null) {
			response.sendRedirect("index.jsp");
			return;
		}
		
		Integer id = null;
		try {
			id = new Integer(new Integer(idS));
		} catch (Exception e) {
			response.sendRedirect("index.jsp");
			return;
		}
		
		Person p = DB.getById(id);
		if (p == null) {
			response.sendRedirect("index.jsp");
			return;
		}
		List<Contact> l = DB.getPersonContacts(new Integer(id));
	%>
	<%= p.getFirstName() %> <%= p.getLastName() %> Kontaktu sarasas:
	<hr>
	<%
		for (Contact c : l) {
	%>
	<%=c.getContact()%> <%=c.getType()%>
	<a style="margin-right: 10px;" href="deleteContact?id=<%=c.getId()%>">Delete</a>
	<a style="margin-right: 10px;" href="editContact.jsp?id=<%=c.getId()%>">Edit</a>
	<hr>
	<%
		}
	%>
	<a href="editContact.jsp?pid=<%=p.getId()%>">New</a>
	<a href="index.jsp">Back</a>
</body>
</html>