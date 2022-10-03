<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page import="com.grupotres.app.modelos.Categoria"%>

<% List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias"); %>
<% Map<String, String> errores = (Map<String, String>) request.getAttribute("errores"); %>
<% String nombre = (String) request.getAttribute("nombre"); %>
<% String descripcion = (String) request.getAttribute("descripcion"); %>
<% String precio = (String) request.getAttribute("precio"); %>
<% String existencia = (String) request.getAttribute("existencia"); %>
<% String estado = (String) request.getAttribute("estado"); %>
<% String categoria = (String) request.getAttribute("categoria"); %>
<% String tienda = (String) request.getAttribute("tienda"); %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="estilos/register1.css">

<!-- JQuery -->
    <script src="https://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
<script defer src="scripts/validacionBootStrap.js"></script>
<title>Registrate en LienzoArt</title>
</head>

<body>

	<div class="formulario mt-100" id="formulario_producto">


		<h1><b>Publicar Producto</b></h1>
		<form action="${pageContext.request.contextPath}/formularioproducto" method="post" class="form_producto row <%if(errores != null && errores.size() > 0 ){%> <% out.print("was-validated"); %>" <%} %>" novalidate enctype="multipart/form-data">

			<div>
			
				<label class="form-label mt-4">Nombre del producto</label>
				<input class="form-control" type="text" id="nombre" name="nombre" required <%if(errores != null && !errores.containsKey("nombre")){%> value="<% out.print(nombre); %>" <%} %>>	
				<div class="invalid-feedback">
					    <%if(errores != null && errores.containsKey("nombre")){%> 
									<% out.print(errores.get("nombre")); %>
						<%} %>
				</div>
				<div class="valid-feedback">¡Correcto!</div>
			</div>


			<div>
				<label class="form-label mt-3">Descripción</label> 
				<input class="form-control" type="text" id="descripcion" name="descripcion" required <%if(errores != null && !errores.containsKey("descripcion")){%> value="<% out.print(descripcion); %>" <%} %>>
				<div class="invalid-feedback">
					    <%if(errores != null && errores.containsKey("descripcion")){%> 
									<% out.print(errores.get("descripcion")); %>
						<%} %>
				</div>
				<div class="valid-feedback">¡Correcto!</div>
			</div>

			<div>
				<label class="form-label mt-3">Precio</label> 
				<input class="form-control" type="number" id="precio" name="precio" required <%if(errores != null && !errores.containsKey("precio")){%> value="<% out.print(precio); %>" <%} %>>
				<div class="invalid-feedback">
					    <%if(errores != null && errores.containsKey("precio")){%> 
									<% out.print(errores.get("precio")); %>
						<%} %>
				</div>
				<div class="valid-feedback">¡Correcto!</div>
			</div>

			<div>
				<label class="form-label mt-3">Existencia</label> 
				<input class="form-control" type="number" id="existencia" name="existencia" required <%if(errores != null && !errores.containsKey("existencia")){%> value="<% out.print(existencia); %>" <%} %>>
				<div class="invalid-feedback">
					    <%if(errores != null && errores.containsKey("existencia")){%> 
									<% out.print(errores.get("existencia")); %>
						<%} %>
				</div>
				<div class="valid-feedback">¡Correcto!</div>
			</div>

			<div class="p_estados">
				<p class="form-label mt-3">Estado del producto</p>
				<select name="estado" id="" class="form-select" required>
					<option value="">Seleccionar...</option>
					<option value="1" <%if(errores != null && !errores.containsKey("estado") && "1".equals(estado)){%> <% out.print("selected"); %> <%} %>>Disponible</option>
					<option value="2" <%if(errores != null && !errores.containsKey("estado") && "2".equals(estado)){%> <% out.print("selected"); %> <%} %>>No disponible</option>
				</select>
				<div class="invalid-feedback">
					    <%if(errores != null && errores.containsKey("estado")){%> 
									<% out.print(errores.get("estado")); %>
						<%} %>
				</div>
				<div class="valid-feedback">¡Correcto!</div>
				
			</div>
			
			<div class="p_categorias">
			
				<p class="form-label mt-3">Categoría del producto</p>
				<select name="categoria" id="" class="form-select" required>
					
					<option value="">Seleccionar...</option>
				
					<%if(categorias != null) {%>
						
						<%for (Categoria cat: categorias) {%>
							
							<option value="<% out.print(cat.getCodigo()); %>" <%if(errores != null && !errores.containsKey("categoria") && Integer.toString(cat.getCodigo()).equals(estado)){%> <% out.print("selected"); %> <%} %>><% out.print(cat.getNombre()); %></option>
						
						<%} %>
						
					<%} %>
						
				</select>
				
				<div class="invalid-feedback">
					    <%if(errores != null && errores.containsKey("categoria")){%> 
									<% out.print(errores.get("categoria")); %>
						<%} %>
				</div>
				<div class="valid-feedback">¡Correcto!</div>
				
			</div>


			<div>
				<label class="form-label mt-3">Tienda <h6 style = "font-size: 15px;">campo provisional mientras se crea formulario de tienda</h6> </label> 
				<input class="form-control" type="text" placeholder="codigo de tienda" id="tienda" name="tienda" required <%if(errores != null && !errores.containsKey("tienda")){%> value="<% out.print(tienda); %>" <%} %>>
				<div class="invalid-feedback">
					    <%if(errores != null && errores.containsKey("tienda")){%> 
									<% out.print(errores.get("tienda")); %>
						<%} %>
				</div>
				<div class="valid-feedback">¡Correcto!</div>
			</div>
			
			<div>
				<label class="form-label mt-3">Seleccione un archivo de imagen del producto <h6 style = "font-size: 15px;">adjunta archivos con extencion: .jpg .ico .jpeg .png</h6> </label> 
				<input class="form-control" type="file" id="imagenes" name="imagen" required>
				<div class="invalid-feedback">
					    <%if(errores != null && errores.containsKey("imagen")){%> 
									<% out.print(errores.get("imagen")); %>
						<%} %>
				</div>
				<div class="valid-feedback">¡Correcto!</div>
			</div>
			

			<input type="submit" name="productocrear" value="Crear" class="btn btn-primary col-12 mt-3 boton-enviar">

		</form>


	</div>




</body>

</html>