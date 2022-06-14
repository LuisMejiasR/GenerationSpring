<%--
  Created by IntelliJ IDEA.
  User: luism
  Date: 13-06-2022
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Luis Mejías Rojas</title>
</head>
<body>
    <h1>Hola <c:out value="${nombres}"/> <c:out value="${apellidos}"/> </h1>
    <p> Tu edad es: <c:out value="${edad}"/> </p>
    <br>
    <p><c:out value="${usuario.nombre} ${usuario.apellido}"/> </p>
    <p><c:out value="${usuario.getEdad()}"/> </p>
</body>
</html>
