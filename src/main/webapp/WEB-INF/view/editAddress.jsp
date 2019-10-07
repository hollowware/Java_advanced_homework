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
        <form method="POST" action="saveAddress">
            <c:if test="${address != null}">
                <input type="hidden" name="id" value="${address.id}">
            </c:if> 
            <!--Savininko id: <input name="personId" value="${address.person.id}">--> 
            Adresas: <input name="address" value="${address.address}"> 
            Miestas: <input name="city" value="${address.city}">
            Pasto Kodas: <input name="postalCode" value="${address.postalCode}"> 
            <input type="submit" value="save">
        </form>
        <a href="/personAddressList?id=${address.person.id}">Cancel</a> <!-- neveikia, nors URL atrodo tvarkingai -->
    </body>
</html>
