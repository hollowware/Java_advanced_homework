<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <c:forEach var="c" items="${contactList}">
        <span style="margin-right: 10px;"><b>Kontakto tipas: </b>${c.type}</span>
        <span style="margin-right: 10px;"><b>Kontaktas: </b>${c.contact}</span>
        <a style="margin-right: 10px; text-decoration: none;" href="deleteContact?id=${c.id}">Delete</a>
        <a style="margin-right: 10px; text-decoration: none;" href="editContact?id=${c.id}">Edit</a>
        <hr>
    </c:forEach>
    <a href="editContact">New</a>
    <a href="./">Cancel</a> 
</body>
</html>
