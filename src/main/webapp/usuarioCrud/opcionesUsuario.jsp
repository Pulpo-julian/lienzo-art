<%@ page import="com.grupotres.app.modelos.Usuario" %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 03/10/2022
  Time: 05:44 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <!-- Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="estilos/opcionesusuario.css">
        <title>Opciones de usuario</title>
    </head>
    <body>

    <!-- HEADER -->
    <jsp:include page="../commons/headerSesion.jsp"></jsp:include>

    <div class="container">
        <h1>Configuracion del usuario: </h1>

        <% out.println( ((Usuario)request.getSession().getAttribute("usuario")).getNombres()); %>

        <div class="usuario_update col-2">
            <form action="${pageContext.request.contextPath}/usuario-config-datos">
                <input type="submit" value="Actualiza tus datos" class="btniniciarsesion">
            </form>
        </div>

        <div class="usuario_update col-2">
            <form action="${pageContext.request.contextPath}/usuario-config-delete">
                <input type="submit" value="Cerrar cuenta" class="btniniciarsesion">
            </form>
        </div>
    </div>
    </body>
</html>
