<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="lt.bit.data.Person" %>
<%@page import="lt.bit.data.Address" %>
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
	List<Address> l = DB.getPersonAddresses(new Integer(id));
	%>
	<%= p.getFirstName() %> <%= p.getLastName() %> Adresu sarasas:
	<hr>
	<%
		for (Address a : l) {
	%>
	<%= a.getAddress() %><%=a.getCity()%><%=a.getPostalCode()%>
	<a style="margin-right: 10px;" href="deleteAddress?id=<%=a.getId()%>">Delete</a>
	<a style="margin-right: 10px;" href="editAddress.jsp?id=<%=a.getId()%>">Edit</a>
	<hr>
	<%
		}
	%>
	<a href="editAddress.jsp?pid=<%=p.getId()%>">New</a>
	<a href="index.jsp">Back</a>
</body>
</html>