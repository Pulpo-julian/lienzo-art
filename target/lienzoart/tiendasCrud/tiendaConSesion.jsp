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
    <title><%out.print(tienda.getNombre());%></title>
</head>
<body>

    <div class="info-tienda">

        <div class="muestra">

            <img alt="TIENDA#" src="" class="img">

            <h4><% out.print(tienda.getNombre());%></h4>
        </div>

        <div class="resumen">
            <p><%out.print(tienda.getDescripcion());%></p>
        </div>

    </div>

    <div class="flex_container">
        <%if (productos != null && productos.size() > 0) {%>

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

    <div class="boton-crear">
        <a href="${pageContext.request.contextPath}/crear-pruducto"> Crear Producto </a>
    </div>

</body>
</html>
