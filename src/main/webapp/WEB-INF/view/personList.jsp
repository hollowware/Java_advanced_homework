<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <c:forEach var="p" items="${list}">
            <span style="margin-right: 10px;"><b>Vardas: </b>${p.firstName}</span>
            <span style="margin-right: 10px;"><b>Pavarde: </b>${p.lastName}</span>
            <span style="margin-right: 10px;"><b>Metai: </b><fmt:formatDate value="${p.birthDate}" pattern="yyyy-MM-dd"></fmt:formatDate></span>
            <span style="margin-right: 10px;"><b>Pinigu: </b>${p.salary}</span>
            <a style="margin-right: 10px; text-decoration: none;" href="delete?id=${p.id}">Delete</a>
            <a style="margin-right: 10px; text-decoration: none;" href="edit?id=${p.id}">Edit</a>
            <a style="margin-right: 10px; text-decoration: none;" href="personAddressList?id=${p.id}">Show Address List</a>
            <a style="margin-right: 10px; text-decoration: none;" href="personContactList?id=${p.id}">Show Contact List</a>
            <hr>
        </c:forEach>
        <a href="edit">New</a>
    </body>
</html>
