<%String buscar = (String) request.getAttribute("buscar"); %>
<head>
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
     <link rel="stylesheet" href="estilos/estilosheadersesion5.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
</head>
    
    <header class="header row gx-5"> <!-- Inicio header -->
    
    	
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
    
       	<div class="micuenta dropdown col-1">   	
        	<button type="button" class="btn btn-secondary dropdown-toggle" id="btnmicuenta" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        		Mi cuenta
        	</button>
        	<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
        		<li><a href="#" class="dropdown-item">Configuraci�n</a></li>
        		<li><a href="#" class="dropdown-item">Crear tienda</a></li>
        		<li><a href="${pageContext.request.contextPath}/controlprincipal" class="dropdown-item">Cerrar sesi�n</a></li>
        	</ul>
       	</div>
        
        <div class="carrocompras col-1">
        
             <form action="${pageContext.request.contextPath}/controlsesion" method="post">
                <input type="submit" name="carrocompras" value="carrocompras" class="btncarrocompras">
             </form>                                
    
        </div>
                       
    </header>
    
    <body>
    	<!-- JS Bootstrap -->
    	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
    </body>
</div>