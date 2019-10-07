<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="lt.bit.data.Person" %>
<%@page import="lt.bit.db.DB" %>
<%@page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String idS = request.getParameter("id");
		Person p = null;
		try {
			p = DB.getById(new Integer(idS));
		} catch (Exception e) {
			// ignored
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	%>
	<form method="POST" action="save">
		<%
			if (p != null) {
		%>
		<input type="hidden" name="id" value="<%=p.getId()%>">
		<%
			}
		%>
		Vardas: <input name="fn" value="<%=(p!=null)?p.getFirstName() : "" %>"> 
		Pavarde: <input name="ln" value="<%=(p!=null)?p.getLastName() : "" %>">
		Gimimo date: <input name="bd" value="<%=(p!=null)?sdf.format(p.getBirthDate()) : "" %>"> 
		Alga: <input name="salary" value="<%=(p!=null)?p.getSalary() : "" %>">
		<input type="submit" value="save">
	</form>
	<a href="index.jsp">Cancel</a>
</body>
</html>