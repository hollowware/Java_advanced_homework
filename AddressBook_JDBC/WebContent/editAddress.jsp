<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="lt.bit.data.Address" %>
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
		String idS = request.getParameter("id");
		Integer id = null;
		try {
			id = new Integer(new Integer(idS));
		} catch (Exception e) {
			// ignored
		}
		Address a = null;
		Person p = null;
		Integer pid = null;
		if (id == null) {
			String pidS = request.getParameter("pid");
			try {
				pid = new Integer (pidS);
			} catch (Exception e) {
				// ignored
			}
			p = DB.getById(pid);
		} else {
			a = DB.getAddressById(id);
			p = DB.getByAddress(a);
		}
		if (p == null) {
			response.sendRedirect("index.jsp");
			return;
		}
	%>
	<%= p.getFirstName() %>
	<%= p.getLastName() %>
	Adresu sarasas:
	<hr>
	<form method="POST" action="saveAddress">
		<%
			if (a != null) {
		%>
		<input type="hidden" name="id" value="<%=a.getId()%>">
		<%
			} else {
		%>
		<input type="hidden" name="pid" value="<%=p.getId()%>">
		<%
			}
		%>
		Gatve: <input name="address" value="<%=(a != null) ? a.getAddress() : "" %>">
		Miestas: <input name="city" value="<%=(a != null) ? a.getCity() : "" %>">
		Pasto kodas: <input name="postalCode" value="<%=(a != null) ? a.getPostalCode() : "" %>">
		<input type="submit" value="save">
	</form>
	<a href="addressList.jsp?id=<%= p.getId()%>">Back</a>
</body>
</html>