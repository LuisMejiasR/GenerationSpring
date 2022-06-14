<%--
  Created by IntelliJ IDEA.
  User: luism
  Date: 13-06-2022
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- ESTE LO DEJAMOS COMO RESPALDO -->
<html>
<head>
    <title>Registro</title>
</head>
<body>
    <div>
        <!-- pasar información desde la vista a una url(action)-->
        <!-- el "method='get'" es por default, los parametros se ven en la ruta-->
        <!-- con el "method='post'", los parametros NO se ven, van ocultos-->
        <!-- form action= "(aqui se pone la url a la que queremos ir)" -->
        <form action="/registro/usuario" method="post">
            <label for="nombre"> Nombre: </label>
            <input type="text" id="nombre" name="gato">
            <br> <!-- saldo de linea -->
            <label for="apellido"> Apellido: </label>
            <input type="text" id="apellido" name="apellido">
            <br> <!-- saldo de linea -->
            <label for="edad"> Edad: </label>
            <input type="number" id="edad" name="edad">
            <br> <!-- saldo de linea -->
            <!-- submit para el envío de información -->
            <input type="submit" value="Registrar">
            <br> <!-- saldo de linea -->
            <!-- button es solo un boton clicleable -->
            <input type="button" value="Enviar">

        </form>
    </div>
</body>
</html>
