<%--
  Created by IntelliJ IDEA.
  User: luism
  Date: 16-06-2022
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Auto</title>
</head>
<body>
    <div>
        <c:if test="${msgError!= null }">
        <c:out value="${msgError }"></c:out>
        </c:if>

        <c:forEach var="auto" items="${autosCapturados}">
            <p>${auto.marca} ${auto.modelo} ${auto.velocidad} ${auto.color}</p>
            <br>
        </c:forEach>

    </div>
</body>
</html>
