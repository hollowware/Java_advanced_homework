<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Insert title here</title>
    </head>
    <body>
        <form method="POST" action="save">
            <c:if test="${person != null}">
                <input type="hidden" name="id" value="${person.id}">
            </c:if> 
            Vardas: <input name="fn" value="${person.firstName}"> 
            Pavarde: <input name="ln" value="${person.lastName}">
            Gimimo date: <input name="bd" value="<fmt:formatDate value="${person.birthDate}" pattern="yyyy-MM-dd"></fmt:formatDate>"> 
            Alga: <input name="salary" value="${person.salary}">
            <input type="submit" value="save">
        </form>
        <a href="./">Cancel</a>
    </body>
</html>