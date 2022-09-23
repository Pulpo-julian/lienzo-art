<% String buscar = (String) request.getAttribute("buscar"); %>
<head>
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
    
        <div class="buscador col-6">
        	
        	<form action="${pageContext.request.contextPath}/controlprincipal" id="buscarForm">
        		<input type="search" id="buscador" name="buscar" class="buscar" placeholder="Buscar..." value="<%if(buscar != null && !buscar.isEmpty()) {out.println(buscar);} %>">
        	</form>
    
            <div id="btnbuscar" class="btn">
            	<button type="submit" form="buscarForm"><i class="fas fa-search"></i></button>
            </div>
        </div>
    
    
        <div class="usuario_login col-2">
        
             <form action="${pageContext.request.contextPath}/controlsesion" method="post">
                <input type="submit" name="sesion" value="Iniciar sesi�n" class="btniniciarsesion">
             </form>                                    
    
        </div>
        
        <div class="usuario_register col-2">
        
             <form action="${pageContext.request.contextPath}/controlsesion" method="post">
                <input type="submit" name="registro" value="Reg�strate" class="btncrearusuario">
             </form>                                
    
        </div>
                    
    </header>