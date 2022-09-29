<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.Map"%>
<% Map<String, String> errores = (Map<String, String>) request.getAttribute("errores"); %>
<% String cedula = (String) request.getAttribute("cedula"); %>
<% String nombre = (String) request.getAttribute("nombre"); %>
<% String apellidos = (String) request.getAttribute("apellidos"); %>
<% String correo = (String) request.getAttribute("correo"); %>
<% String password = (String) request.getAttribute("password"); %>
<% String telefono = (String) request.getAttribute("telefono"); %>
<% String ciudad = (String) request.getAttribute("ciudad"); %>
<% String codigoPostal = (String) request.getAttribute("codigoPostal"); %>
<% String direccion = (String) request.getAttribute("direccion"); %>

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

<div class="seccion row">

	<div id="iconmain"class="col-6">
			
		<a href="${pageContext.request.contextPath}/controlprincipal"> <img src="img/logo.png"> </a>
				
	</div>
	
	<div class="formulario col-6">


		<h1>Registro</h1>
		<form action="${pageContext.request.contextPath}/formulariousuario" method="post" class="form_usuario row <%if(errores != null && errores.size() > 0 ){%> <% out.print("was-validated"); %>" <%} %>" novalidate>

			<div class="col-6">
			
				<label class="form-label mt-3">Cédula</label>
				<input class="form-control" type="number" placeholder="Número de cédula" id="cedula" name="cedula" required <%if(errores != null && !errores.containsKey("cedula")){%> value="<% out.print(cedula); %>" <%} %>>
				<div class="invalid-feedback">
					    <%if(errores != null && errores.containsKey("cedula")){%> 
									<% out.print(errores.get("cedula")); %>
						<%} %>
				</div>
				<div class="valid-feedback">¡Correcto!</div>	
				
			</div>


			<div class="col-6">
				<label class="form-label mt-3">Nombres</label> 
				<input class="form-control" type="text" placeholder="Juan" id="nombre" name="nombre" required <%if(errores != null && !errores.containsKey("nombre")){%> value="<% out.print(nombre); %>" <%} %>>
				<div class="invalid-feedback">
					<%if(errores != null && errores.containsKey("nombre")){%>
							<% out.print(errores.get("nombre")); %>
					<%} %>
				</div>
				<div class="valid-feedback">¡Correcto!</div>
			</div>

			<div class="col-6">
				<label class="form-label mt-3">Apellidos</label> 
				<input class="form-control" type="text" placeholder="Pérez lópez" id="apellidos" name="apellidos" required <%if(errores != null && !errores.containsKey("apellidos")){%> value="<% out.print(apellidos); %>" <%} %>>
				<div class="invalid-feedback">
					<%if(errores != null && errores.containsKey("apellidos")){%>
							<% out.print(errores.get("apellidos")); %>
					<%} %>
				</div>
				<div class="valid-feedback">¡Correcto!</div>

			</div>

			<div class="col-6">
				<label class="form-label mt-3">Correo electrónico</label> 
				<input class="form-control" type="text" placeholder="correo@gmail.com" id="correo" name="correo" required <%if(errores != null && !errores.containsKey("correo")){%> value="<% out.print(correo); %>" <%} %>>
				<div class="invalid-feedback">
					<%if(errores != null && errores.containsKey("correo")){%>
							<% out.print(errores.get("correo")); %>
					<%} %>
				</div>
				<div class="valid-feedback">¡Correcto!</div>
			</div>

			<div class="col-6">
				<label class="form-label mt-3">Contraseña</label> 
				<input class="form-control" type="password" placeholder="Contraseña" id="password" name="password" required <%if(errores != null && !errores.containsKey("password")){%> value="<% out.print(password); %>" <%} %>>
				<div class="invalid-feedback">
					<%if(errores != null && errores.containsKey("password")){%>
							<% out.print(errores.get("password")); %>
					<%} %>
				</div>
				<div class="valid-feedback">¡Correcto!</div>
				
			</div>

			<div class="col-6">
				<label class="form-label mt-3">Número de contacto</label> 
				<input class="form-control" type="text" placeholder="000-000-0000" id="telefono" name="telefono" required <%if(errores != null && !errores.containsKey("telefono")){%> value="<% out.print(telefono); %>" <%} %>>
				<div class="invalid-feedback">
					<%if(errores != null && errores.containsKey("telefono")){%>
							<% out.print(errores.get("telefono")); %>
					<%} %>
				</div>
				<div class="valid-feedback">¡Correcto!</div>
			</div>

			<div class="p_ciudades col-6">
				<p class="form-label mt-3">Seleccione su Ciudad</p>
				<select name="ciudades" id="" class="form-select" required>
					<option value="">Seleccionar...</option>
					<option value="05001" <%if(errores != null && !errores.containsKey("ciudades") && "05001".equals(ciudad)){%> <% out.print("selected"); %> <%} %>>Medellin</option>
					<option value="05318" <%if(errores != null && !errores.containsKey("ciudades") && "05318".equals(ciudad)){%> <% out.print("selected"); %> <%} %>>Guarne</option>
					<option value="05321" <%if(errores != null && !errores.containsKey("ciudades") && "05321".equals(ciudad)){%> <% out.print("selected"); %> <%} %>>Guatape</option>
					<option value="05376" <%if(errores != null && !errores.containsKey("ciudades") && "05376".equals(ciudad)){%> <% out.print("selected"); %> <%} %>>La ceja</option>
					<option value="05440" <%if(errores != null && !errores.containsKey("ciudades") && "05440".equals(ciudad)){%> <% out.print("selected"); %> <%} %>>Marinilla</option>
					<option value="05541" <%if(errores != null && !errores.containsKey("ciudades") && "05541".equals(ciudad)){%> <% out.print("selected"); %> <%} %>>El Peñol</option>
					<option value="05615" <%if(errores != null && !errores.containsKey("ciudades") && "05615".equals(ciudad)){%> <% out.print("selected"); %> <%} %>>Rionegro</option>
					<option value="05649" <%if(errores != null && !errores.containsKey("ciudades") && "05649".equals(ciudad)){%> <% out.print("selected"); %> <%} %>>San carlos</option>
					<option value="05656" <%if(errores != null && !errores.containsKey("ciudades") && "05656".equals(ciudad)){%> <% out.print("selected"); %> <%} %>>San Jerónimo</option>
					<option value="05667" <%if(errores != null && !errores.containsKey("ciudades") && "05667".equals(ciudad)){%> <% out.print("selected"); %> <%} %>>San Rafael</option>
				</select>
				<div class="invalid-feedback">
					<%if(errores != null && errores.containsKey("ciudades")){%>
							<% out.print(errores.get("ciudades")); %>
					<%} %>
				</div>
				<div class="valid-feedback">¡Correcto!</div>

			</div>

			<div class="col-6">
				<label class="form-label mt-3">Código postal</label> 
				<input class="form-control" type="text" placeholder="000000" id="codigoPostal" name="codigoPostal" required <%if(errores != null && !errores.containsKey("codigoPostal")){%> value="<% out.print(codigoPostal); %>" <%} %>>
				<div class="invalid-feedback">
					<%if(errores != null && errores.containsKey("codigoPostal")){%>
							<% out.print(errores.get("codigoPostal")); %>
					<%} %>
				</div>
				<div class="valid-feedback">¡Correcto!</div>
				
			</div>

			<div class="col-12">
				<label class="form-label mt-3">Dirección</label> 
				<input class="form-control" type="text" placeholder="cra x #xx-xx" id="direccion" name="direccion"required <%if(errores != null && !errores.containsKey("direccion")){%> value="<% out.print(direccion); %>" <%} %>>
				<div class="invalid-feedback">
					<%if(errores != null && errores.containsKey("direccion")){%>
							<% out.print(errores.get("direccion")); %>
					<%} %>
				</div>
				<div class="valid-feedback">¡Correcto!</div>
				
			</div>
			

			<input type="submit" name="crud" value="Crear" class="btn btn-primary col-12 mt-4 text-dark">

		</form>


	</div>
</div>



</body>

</html>