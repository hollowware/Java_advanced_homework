<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <c:forEach var="a" items="${addressList}">
        <span style="margin-right: 10px;"><b>Gatve: </b> ${a.address}</span>
        <span style="margin-right: 10px;"><b>Miestas: </b> ${a.city}</span>
        <span style="margin-right: 10px;"><b>Pasto kodas: </b> ${a.postalCode}</span>
        <a style="margin-left: 10px; text-decoration: none;" href="deleteAddress?id=${a.id}">Delete</a>
        <a style="margin-left: 10px; text-decoration: none;" href="editAddress?id=${a.id}">Edit</a>
        <hr>
    </c:forEach>
    <a href="editAddress">New</a>
    <a href="./">Cancel</a> 
</body>
</html>
