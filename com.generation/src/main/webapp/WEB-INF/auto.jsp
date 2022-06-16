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
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous">
</head>
<body>
    <div>
        <c:if test="${msgError!= null }">
        <c:out value="${msgError }"></c:out>
        </c:if>

        <%--@elvariable id="auto" type="com.generation.models.Auto"--%>
        <form:form action="/registroauto/auto" method="post" modelAttribute="auto">
            <form:label path="color" class="form-label">Color: </form:label>
            <form:input path="color" class="form-control"/>
            <br>
            <form:label path="modelo" class="form-label">Modelo: </form:label>
            <form:input path="modelo" class="form-control"/>
            <br>
            <form:label path="marca" class="form-label">Marca: </form:label>
            <form:input path="marca" class="form-control"/>
            <br> <!-- saldo de linea -->
            <form:label path="velocidad" class="form-label">Velocidad: </form:label>
            <form:input type="number" path="velocidad" class="form-control"/>
            <br>
        <!-- submit para el envío de información -->
            <input type="submit" value="Registrar Auto">
            <button type="submit" class="btn btn-primary">Registrar Auto</button>
            <button type="submit" class="btn btn-outline-primary">Guardar

        </form:form>
    </div>
</body>
</html>
