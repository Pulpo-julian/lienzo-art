<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 07/10/2022
  Time: 12:13 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.Map"%>
<%@ page import="com.grupotres.app.modelos.Tienda" %>
<% Map<String, String> errores = (Map<String, String>)request.getAttribute("errores"); %>
<% Tienda tienda = (Tienda) request.getSession().getAttribute("tienda"); %>
<% String mensajeExito = (String) request.getAttribute("mensaje"); %>
<% String nombre = (String) request.getAttribute("nombre"); %>
<% String direccion = (String) request.getAttribute("direccion"); %>
<% String descripcion = (String) request.getAttribute("descripcion"); %>



<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="estilos/estilosactualizarusuario.css">

    <title>Actualiza tus datos en LienzoArt</title>
</head>

<body>
<!-- HEADER -->
<jsp:include page="../commons/headerSesion.jsp"></jsp:include>

<div class="formulario">


    <h1 class="title">Actualizar Tienda</h1>
    <form action="${pageContext.request.contextPath}/update-tienda" method="post" class="form_tienda row">

        <div class="col-6 mt-3">
            <label class="form-label">Nombre</label>
            <input class="form-control" type="text" value="<% if((errores != null && errores.containsKey("nombre")) || (errores != null && !errores.containsKey("nombre"))){
					out.print(nombre);
				} else {
					out.print(tienda.getNombre());
				}
					%>"
                   id="nombre" name="nombre">

            <%if(errores != null && errores.containsKey("nombre")){%>

            <h5>
                <% out.print(errores.get("nombre")); %>
            </h5>


            <%} %>

        </div>

        <div class="col-6 mt-3">
            <label class="form-label">Direccion</label>
            <input class="form-control" type="text"
                   value="<% if((errores != null && errores.containsKey("direccion")) || (errores != null && !errores.containsKey("direccion"))){
					out.print(direccion);
				} else {
					out.print(tienda.getDireccion());
				}
					%>" id="apellidos" name="apellidos">
            <%if(errores != null && errores.containsKey("direccion")){%>

            <h5>
                <% out.print(errores.get("direccion")); %>
            </h5>


            <%} %>

        </div>

        <div class="col-6 mt-3">


            <label class="form-label">Descripcion</label>
            <input class="form-control" type="text" value="<% if((errores != null && errores.containsKey("descripcion")) || (errores != null && !errores.containsKey("descripcion"))){
					out.print(descripcion);
				} else {
					out.print(tienda.getDescripcion());
				}
					%>"
                   id="correo" name="correo">

            <%if(errores != null && errores.containsKey("correo")){%>

            <h5>
                <% out.print(errores.get("correo")); %>
            </h5>

            <%} %>


            <input id="btn" type="submit" name="crud" value="actualizar" class="btn btn-primary boton_mov mt-4">



    </form>


    </div>



</body>

</html>
