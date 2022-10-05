<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<% String buscar = (String) request.getAttribute("buscar"); %>
<% Integer cantidadProductosAgregados = (Integer) request.getAttribute("productosCarro"); %>

<head>
    <meta charset="UTF-8">
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="estilos/estilosheader1.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
</head>
    
    <header class="header row"> <!-- Inicio header -->
    
    	
        <div class="logo col-2">
            <a href="${pageContext.request.contextPath}/controlprincipal"> <img src="img/logoindex.png"> </a>
        </div>
    
        <div class="buscador col-2">
        	
        	<form action="${pageContext.request.contextPath}/controlprincipal" id="buscarForm">
        		<input type="search" id="buscador" name="buscar" class="buscar" placeholder="Buscar..." value="<%if(buscar != null && !buscar.isEmpty()) {out.println(buscar);} %>">
        	</form>
    
            <div id="btnbuscar" class="btn">
            	<button type="submit" form="buscarForm"><i class="fas fa-search"></i></button>
            </div>
        </div>
    
    
        <div class="usuario_login col">
        
             <form action="${pageContext.request.contextPath}/controlsesion" method="post">
                <input type="submit" name="sesion" value="Iniciar sesión" class="btniniciarsesion">
             </form>                                    
    
        </div>
        
        <div class="usuario_register col">
        
             <form action="${pageContext.request.contextPath}/controlsesion" method="post">
                <input type="submit" name="registro" value="Regístrate" class="btncrearusuario">
             </form>                                
    
        </div>

        <div class="carro_compras col">

            <form action="${pageContext.request.contextPath}/carro-compras.ss">
                <input type="submit" name="carrocompras" value="carrocompras" class="btncarrocompras">
                <%if(cantidadProductosAgregados != null && cantidadProductosAgregados != 0) {out.print(cantidadProductosAgregados);}%>
            </form>

        </div>
                    
    </header>