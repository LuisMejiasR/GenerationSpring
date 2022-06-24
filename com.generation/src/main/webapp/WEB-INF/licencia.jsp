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
    <title>Registro licencia</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous">
</head>
<body>
<div class="container">
    <c:if test="${msgError!= null}">
        <c:out value="${msgError }"></c:out>
    </c:if>

    <%--@elvariable id="licencia" type="java"--%>
    <form:form action="/licencia/guardar" method="post" modelAttribute="licencia">
        <form:label path="numero" class="form-label">Numero: </form:label>
        <form:input path="numero" type="number" class="form-control"/>
        <br>
        <form:label path="fechaVencimiento" class="form-label">Fecha de vencimiento:</form:label>
        <form:input path="fechaVencimiento" type="date" class="form-control"/>
        <br>
        <form:label path="clase" class="form-label">Clase:</form:label>
        <form:input path="clase" type="text" class="form-control"/>
        <br> <!-- saldo de linea -->
        <form:label path="vencida" class="form-label">Estado:</form:label>
        <form:input type="text" path="vencida" class="form-control"/>
        <br>
        <!-- USUARIO OneToOne-->
        <form:select path="usuario" class="form-select">
            <form:option value="0">Seleccione un usuario</form:option>
            <c:forEach  var="usuario" items="${listaUsuarios}">
                <c:if test="${usuario.licencia.id == null}">
                    <form:option value="${usuario.id}">${usuario.nombre} ${usuario.apellido} </form:option>
                </c:if>
            </c:forEach>

    </form:select>
    <br>
    <!-- submit para el envío de información -->
    <button type="submit" class="btn btn-primary">Registrar Licencia</button>


    </form:form>
    <br>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Numero</th>
            <th scope="col">Fecha Vencimiento</th>
            <th scope="col">Clase</th>
            <th scope="col">Estado</th>
            <th scope="col">Usuario</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="licencia" items="${listaLicencias}" >
            <tr>

                <th scope="row">${licencia.id}</th>
                <td>${licencia.numero}</td>
                <td>${licencia.fechaVencimiento}</td>
                <td>${licencia.clase}</td>
                <td>${licencia.vencida}</td>
                <td>${licencia.usuario.nombre} ${licencia.usuario.apellido}</td><!-- LAZY -->

                <td><a class="btn btn-warning" href="/licencia/editar/${licencia.id}" role="button">Editar</a></td>
                <td><a class="btn btn-danger" href="/licencia/eliminar/${licencia.id}" role="button">Eliminar</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
