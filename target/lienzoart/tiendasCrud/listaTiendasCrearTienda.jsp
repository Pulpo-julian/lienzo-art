<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 06/10/2022
  Time: 10:19 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List"%>
<%@ page import="com.grupotres.app.modelos.Tienda"%>

<% List<Tienda> tiendas = (List<Tienda>) request.getAttribute("tiendas"); %>
<% String respuesta = (String) request.getAttribute("respuesta"); %>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap
    le comente este bootstrap por que la letra salia blanca
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="estilos/register1.css"> -->
    <title>Tus tiendas</title>
    <link rel="stylesheet" href="estilos/listarTiendasCrearTienda.css">
</head>
<body>

    <!-- HEADER -->
    <jsp:include page="../commons/headerSesion.jsp"></jsp:include>
    <div class="container">
          <div class="contenedor-cards">
                     <%if(respuesta != null){%>
            <div class="mensaje-respuesta" id="card">
              <h1><%out.print(respuesta);%></h1>
            </div>
                    <%}%>

            <%if(tiendas != null && tiendas.size() > 0){%>

            <%for(Tienda tienda: tiendas){%>
            <div class="card" style="background: #59AED6">
                <div class="tienda-info">
                    <h1><%out.print(tienda.getNombre());%></h1>
                    <h4><%out.print("Descripción: " + tienda.getDescripcion());%></h4>
                </div>
                <h4>
                    <a class="tienda" href="${pageContext.request.contextPath}/update-tienda?codtienda=<%out.print(tienda.getCodigo());%>">Editar Tienda</a> <br>
                    <a class="tienda" href="${pageContext.request.contextPath}/ver-tienda?codtienda=<%out.print(tienda.getCodigo());%>">ingresar a la Tienda</a>
                </h4>

            </div>
            <%}%>

            <%}%>
            <div class="card" style="background: #59AED6">
                <div class="creacion-nueva-tienda">
                    <form action="${pageContext.request.contextPath}/crear-tienda" method="post">
                        <input type="submit" name="crear-tienda" value="Crear una tienda" class="btn-creartienda">
                    </form>
                </div>
            </div>
          </div>
    </div>

</body>
</html>
