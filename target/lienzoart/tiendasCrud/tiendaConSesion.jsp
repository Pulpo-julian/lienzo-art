<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 07/10/2022
  Time: 06:04 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.List"%>
<%@ page import="com.grupotres.app.modelos.Tienda"%>
<%@ page import="com.grupotres.app.modelos.Producto"%>


<% List<Producto> productos = (List<Producto>) request.getAttribute("productos"); %>
<% Tienda tienda = (Tienda) request.getAttribute("tienda"); %>



<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title><%out.print(tienda.getNombre());%></title>
    <link rel="stylesheet" href="estilos/tiendaConSesion.css" id="recargar">
</head>
<body>

    <!-- HEADER -->
    <jsp:include page="../commons/headerSesion.jsp"></jsp:include>

    <div class="container-tienda">

        <div class="info-tienda">

            <div class="muestra">

                <img alt="TIENDA#" src="img/tiendaEjemplo.jpg" class="img">

                <h4><% out.print(tienda.getNombre());%></h4>
            </div>

            <div class="resumen">
                <h6>Direccion: <%out.print(tienda.getDireccion());%></h6>
                <p>Sobre Nosotros: <%out.print(tienda.getDescripcion());%></p>
            </div>

            <div class="boton-crear">
                <a href="${pageContext.request.contextPath}/crear-pruducto"> Publicar Producto </a>
            </div>

        </div>


        <div class="flex_container caja-productos">
            <%if (productos != null && productos.size() > 0) {%>

            <h1>Tus Productos Publicados</h1>

            <% for(Producto producto: productos){ %>

            <div class="producto card" style="border-radius: 10px;">

                <div class="muestra">
                    <a href="${pageContext.request.contextPath}/detalle-producto?codpro=<%out.print(producto.getCodigo());%>">
                        <img alt="#" src="<% out.println(producto.getUrlImagen()); %>" class="img">
                    </a>

                    <h4><% out.print(producto.getNombre());%></h4>
                </div>

                <div class="informacion" >

                    <ul class="listaproducto">
                        <li> <h6>Categoria: 	<% out.print(producto.getCategoria()); %></h6> </li>
                        <li> <h6>Estado: <% out.print(producto.getEstado()); %></h6> </li>
                        <li> <h6>Existencia: <% out.print(producto.getExistencia()); %></h6> </li>
                    </ul>

                    <div class="preciocarrito">
                        <a href="#" class="precio"><% out.print("$" + producto.getPrecio()); %></a>
                    </div>

                </div>

                <div class="editar-producto">
                    <a href="${pageContext.request.contextPath}/editar-producto"> Actulizar Producto </a>
                </div>

            </div>

            <%} %>


            <%} %>
        </div>

    </div>

</body>
</html>
