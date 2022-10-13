<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.grupotres.app.modelos.Producto"%>
<% List<Producto> productos = (List<Producto>) request.getAttribute("productos"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carro de compras</title>
</head>
<body>

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
                <li> <h1>Precio: 	<% out.print(producto.getPrecio()); %></h1> </li>
                <li> <h6>Categoria: 	<% out.print(producto.getCategoria()); %></h6> </li>
                <li> <h6>Estado: <% out.print(producto.getEstado()); %></h6> </li>
                <li> <h6>Existencia: <% out.print(producto.getExistencia()); %></h6> </li>
                <li> <h6><a class="tienda" href="#"><% out.print(producto.getTienda()); %></a> </h6> </li>
            </ul>

            <div class="preciocarrito">
                <a href="${pageContext.request.contextPath}/quitar-producto?codpro=<%out.print(producto.getCodigo());%>" class="carrito">quitar</a>
            </div>

        </div>

    </div>

    <%} %>


    <%} %>
</div>
	
</body>
</html>