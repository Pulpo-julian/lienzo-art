<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="com.grupotres.app.modelos.Usuario" %>

<%String buscar = (String) request.getAttribute("buscar"); %>
<%Integer cantProductosCarro = (Integer) request.getSession().getAttribute("cantidadproductoscarro");%>
<%Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");%>

<head>
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
     <link rel="stylesheet" href="estilos/estilosheadersesion5.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
</head>
    
    <header class="header row col"> <!-- Inicio header -->

        <!-- Logo -->
        <div class="logo col-2">
            <a href="${pageContext.request.contextPath}/controlprincipal"> <img src="img/logoindex.png"> </a>
        </div>

        <!-- Buscador -->
        <div class="buscador col-5">
        	
        	<form action="${pageContext.request.contextPath}/controlprincipal" id="buscarForm">
        		<input type="search" name="buscar" class="buscar" placeholder="Buscar..." value="<%if(buscar != null && !buscar.isEmpty()) {out.println(buscar);} %>">
        	</form>
    
            <div id="btnbuscar" class="btn">
            	<button type="submit" class="bsc" form="buscarForm"><i class="fas fa-search"></i></button>
            </div>
        </div>

        <!-- Nombre usuario -->
        <div class="saludo col-1">
            <h4>Hola <%out.print(usuario.getNombres().split(" ")[0]);%></h4>
        </div>

        <!-- Mi cuenta boton -->
       	<div class="micuenta dropdown col-2" style="display: grid; grid-template-columns: 1fr 1fr; gap: 10px">


                <h6 class="saludo">Hi <%out.print(usuario.getNombres().split(" ")[0]);%></h6>

<<<<<<< HEAD

=======
>>>>>>> 16c9496c29b07d7d3a98bc4e89c8a643f44bb91a
        	<button type="button" class="btn btn-secondary dropdown-toggle"  id="btnmicuenta" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        		Mi cuenta
        	</button>
        	<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
        		<li><a href="${pageContext.request.contextPath}/usuario-config" class="dropdown-item">Configuración</a></li>
        		<li><a href="${pageContext.request.contextPath}/obtener-tienda" class="dropdown-item">Crear tienda</a></li>
        		<li><a href="${pageContext.request.contextPath}/cerrarsesion" class="dropdown-item">Cerrar sesión</a></li>
        	</ul>
       	</div>
        
        <div class="carrocompras col-2">
        
             <form action="${pageContext.request.contextPath}/productos-carro" method="post">
                <input type="submit" name="carrocompras" value="Carrocompras" class="btncarrocompras">
             </form>
            <%if(cantProductosCarro != null && cantProductosCarro != 0){%>
                <div class="cantidad-producto-agregados">
                    <h5><%out.print(cantProductosCarro);%></h5>
                </div>
            <%}%>
    
        </div>
                       
    </header>
    
    <body>
    	<!-- JS Bootstrap -->
    	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
    </body>
</div>