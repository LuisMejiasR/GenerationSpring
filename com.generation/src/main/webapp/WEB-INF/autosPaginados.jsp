<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: luism
  Date: 16-06-2022
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Autos CSS</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <!-- formulario de busqueda -->
        <form action="/registroauto/buscar" method="post">
            <label for="marca">Marca:</label>
            <input type="text" id="marca" name="marca">

            <input type="submit" value="Buscar" class="btn btn-primary">
        </form>
        <br>
        <!-- paginacion -->
        <c:forEach var="numeroPagina" begin="1" end="${totalPaginas}">
            <a href="/registroauto/pagina/${numeroPagina}">${numeroPagina}</a>
        </c:forEach>

        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Marca</th>
                <th scope="col">Modelo</th>
                <th scope="col">Velocidad</th>
                <th scope="col">Color</th>
                <th scope="col">Acciones</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="auto" items="${autosCapturados.content}">
                <tr>
                    <th scope="row">${auto.id}</th>
                    <td>${auto.marca}</td>
                    <td>${auto.modelo}</td>
                    <td>${auto.velocidad}</td>
                    <td>${auto.color}</td>
                    <td><a class="btn btn-warning" href="editar/${auto.id}" role="button">Editar</a></td>
                    <td><a class="btn btn-danger" href="eliminar/${auto.id}" role="button">Eliminar</a></td>

                </tr>
            </c:forEach>

            </tbody>
        </table>
        <c:if test="${msgAuto= null }">
            <c:out value="${msgAuto }"></c:out>
        </c:if>
        <td><a class="btn btn-primary" href="/registroauto" role="button">Agregar nuevo auto</a></td>
    </div>
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>

</body>
</html>
