<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 04/10/2022
  Time: 06:44 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@ page import="com.grupotres.app.modelos.Producto"%>
<% Producto producto = (Producto) request.getAttribute("producto"); %>

<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <!-- Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title><%out.print(producto.getNombre());%></title>
    </head>
    <body>
        <!-- HEADER -->
        <jsp:include page="../commons/header.jsp"></jsp:include>

        <div class="seccionprincipal">

            <div class="titulocategoria">

                <h1 id="titulorespuesta"></h1>

            </div>

            <main class="seccion">

                <div class="flex_container">


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
                                <li> <h6><a class="tienda" href="#"><% out.print(producto.getTienda()); %></a> </h6> </li>
                            </ul>

                            <div class="preciocarrito">
                                <a href="#" class="precio"><% out.print("$" + producto.getPrecio()); %></a>
                            </div>

                        </div>

                    </div>

                </div>
            </main>




        </div>

    </body>
</html>
