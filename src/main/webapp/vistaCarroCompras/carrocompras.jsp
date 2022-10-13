<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 13/10/2022
  Time: 01:18 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.List"%>
<%@ page import="com.grupotres.app.modelos.Producto"%>
<%@ page import="com.grupotres.app.modelos.ItemProducto" %>
<% List<Producto> productos = (List<Producto>) request.getAttribute("productos"); %>
<% List<ItemProducto> items = (List<ItemProducto>) request.getAttribute("itemProductos"); %>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <!-- JQuery -->
    <script src="https://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
    <link rel="stylesheet" href="estilos/estiloscarrocompras.css">
    <title>Carro de compras</title>
</head>
<body>
<!-- HEADER -->
<jsp:include page="../commons/headerSesion.jsp"></jsp:include>

<div class="flex_container">
    <%if (items != null && items.size() > 0) { int i = 0; int valorTotal = 0;%>

    <h1>Tus productos agregados</h1>

    <% for(ItemProducto item: items){ Producto producto = productos.get(i++);%>


        <%if(item.getCantProducto() == 0) continue;%>


    <div class="contenedor-productos">

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
                    <li> <h6><a class="tienda" href="#"><% out.print(producto.getTienda()); %></a> </h6> </li>
                </ul>

                <div class="preciocarrito">
                    <p class="precio"><% out.print("Valor unidad: $" + producto.getPrecio()); %></p>

                    <div class ="unidades">
                        <h4>Cantidad: <%out.print(item.getCantProducto());%></h4>
                    </div>
                </div>

                <div class ="valor-total">
                    <h4>valor total: </h4>
                    <h3><%out.print(item.getCantProducto() * item.getValorProducto());%></h3>
                    <%valorTotal += item.getCantProducto() * item.getValorProducto();%>
                </div>


                <a href="${pageContext.request.contextPath}/eliminar-producto?codpro=<%out.print(producto.getCodigo());%>" class="carrito">Eliminar Producto</a>
            </div>

        </div>
    </div>

    <%} %>

    <div class="precio-total">
        <h2>Total a pagar:</h2><h1>$ <%out.print(valorTotal);%></h1>
    </div>
    <div class="pagar">
        <a href="${pageContext.request.contextPath}/pagar-factura">Pagar</a>
    </div>
    <%} %>
</div>

</body>
</html>
