<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="lt.bit.data.Contact" %>
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
		Contact c = null;
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
			c = DB.getContactById(id);
			p = DB.getByContact(c);
		}
		if (p == null) {
			response.sendRedirect("index.jsp");
			return;
		}
		
	%>

	<%=p.getFirstName()%>
	<%=p.getLastName()%>
	Kontaktu sarasas:
	<hr>
	
	<form method="POST" action="saveContact">
		<%
			if (c != null) {
		%>
		<input type="hidden" name="id" value="<%=c.getId()%>">
		<%
			} else {
		%>
		<input type="hidden" name="pid" value="<%=p.getId()%>">
		<%
			}
		%>
		Tipas: <input name="type" value="<%=(c != null) ? c.getType() : "" %>">
		Kontaktas: <input name="contact" value="<%=(c != null) ? c.getContact() : "" %>">
		<input type="submit" value="save">
	</form>
	<a href="contactList.jsp?id=<%= p.getId()%>">Back</a>

</body>
</html>