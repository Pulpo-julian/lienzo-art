<%@ page import="java.util.List"%>
<%@ page import="com.grupotres.app.modelos.Producto"%>
<% List<Producto> productos = (List<Producto>) request.getAttribute("productos"); %>
<% String accion = (String) request.getAttribute("accion"); %>
<% String buscar = (String) request.getAttribute("buscar"); %>


<div class="seccionprincipal">

	<div class="titulocategoria">
	
		<h1 id="titulorespuesta"></h1>
	
	</div>

	<main class="seccion">
	
	
	
		<%if (accion != null && productos.size() > 0) {%>
		
			<div class="titulocategoria">
				
				<h1>Productos de Categoria: "<% out.print(productos.get(0).getCategoria()); %>"</h1>	
				
			</div>
	
		<%} else if (accion != null && productos.size() == 0){ %>
		
			<div class="titulocategoria">
				
				<h1>Por el momento no hay productos de esta Categoria</h1>
			
			</div>
			
		<%} else if (buscar != null && productos.size() > 0 && !buscar.isEmpty()) {%>
			
			<div class="titulocategoria">
				
				<h1>Productos relacionados con: "<% out.print(buscar); %>"</h1>
			
			</div>			
			
		<%} else if (buscar != null && productos.size() == 0) {%>
			
			<div class="titulocategoria">
				
				<h1>Por el momento no hay productos relacionados con: "<% out.print(buscar); %>"</h1>
			
			</div>
			
		<%} %>


	
	    <div class="flex_container">
		<%if (productos != null && productos.size() > 0) {%>
		
			<% for(Producto producto: productos){ %>
			
				<div class="producto card" style="border-radius: 10px;">
					
					<div class="muestra">
						<a href="${pageContext.request.contextPath}/formularioproducto?">
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
							<a href="#" class="carrito"><i class="fas fa-cart-plus"></i></a>
						</div>
						
					</div>
					
				</div>
				
			<%} %>
		
		
		<%} %>
		</div>
	</main>




</div>


    		
    		
    		
    		