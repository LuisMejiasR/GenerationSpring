<%--
  Created by IntelliJ IDEA.
  User: luism
  Date: 13-06-2022
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Registro</title>
</head>
<body>
    <div>
        <c:if test="${msgError!= null }">
            <c:out value="${msgError }"></c:out>
        </c:if>

        <!-- esto se usa unicamente para trabajar con formularios -->
        <%--@elvariable id="usuario" type="com.generation.models.Usuario"--%>
        <form:form action="/registro/usuario" method="post" modelAttribute="usuario">
            <form:label path="nombre">Nombre: </form:label>
            <form:input path="nombre"/>
            <br>
            <form:label path="apellido">Apellido: </form:label>
            <form:input path="apellido"/>
            <br>
            <form:label path="edad">Edad: </form:label>
            <form:input type ="number" path="edad"/>
            <br> <!-- saldo de linea -->
            <form:label path="password">Contraseña: </form:label>
            <form:input path="password"/>
            <br>
            <!-- submit para el envío de información -->
            <input type="submit" value="Registrar">
        </form:form>
    </div>
</body>
</html>
