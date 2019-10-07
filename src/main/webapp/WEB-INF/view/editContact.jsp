<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="saveContact">
            <c:if test="${contact != null}">
                <input type="hidden" name="id" value="${contact.id}">
            </c:if> 
            Savininko id: <input name="personId" value="${contact.person.id}"> 
            Kontakto tipas: <input name="type" value="${contact.type}"> 
            Kontaktas: <input name="contact" value="${contact.contact}">
            <input type="submit" value="save">
        </form>
        <a href="/personContactList?id=${contact.person.id}">Cancel</a> <!-- neveikia, nors URL atrodo tvarkingai -->
    </body>
</html>
