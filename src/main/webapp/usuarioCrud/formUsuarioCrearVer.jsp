<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.Map"%>
<% Map<String, String> errores = (Map<String, String>)request.getAttribute("errores"); %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../estilos/principal.css">
<script defer src="../scripts/main.js"></script>
<title>Registrate en LienzoArt</title>
</head>

<body>

	<div>


		<h1>Crear Usuario</h1>
		<form action="CrudNuevoLienzoArt/formulariousuario" method="post" class="form_usuario">

			<div>
				<label>Cedula</label> <input type="text" placeholder="su cedula"
					id="cedula" name="cedula">

				<%if(errores != null && errores.containsKey("cedula")){%>

				<h5>
					<% out.print(errores.get("cedula")); %>
				</h5>


				<%} %>



			</div>


			<div>
				<label>Nombres</label> <input type="text" placeholder="su nombre"
					id="nombre" name="nombre">

				<%if(errores != null && errores.containsKey("nombre")){%>

				<h5>
					<% out.print(errores.get("nombre")); %>
				</h5>


				<%} %>

			</div>

			<div>
				<label>apellidos</label> <input type="text"
					placeholder="sus apellidos" id="apellidos" name="apellidos">
				<%if(errores != null && errores.containsKey("apellidos")){%>

				<h5>
					<% out.print(errores.get("apellidos")); %>
				</h5>


				<%} %>

			</div>

			<div>
				<label>Correo</label> <input type="text" placeholder="su correo"
					id="correo" name="correo">

				<%if(errores != null && errores.containsKey("correo")){%>

				<h5>
					<% out.print(errores.get("correo")); %>
				</h5>


				<%} %>


			</div>

			<div>
				<label>Contraseña</label> <input type="password"
					placeholder="contraseña" id="password" name="password">
				<%if(errores != null && errores.containsKey("password")){%>

				<h5>
					<% out.print(errores.get("password")); %>
				</h5>


				<%} %>

			</div>

			<div>
				<label>Telefono</label> <input type="text" placeholder="su telefono"
					id="telefono" name="telefono">
				<%if(errores != null && errores.containsKey("telefono")){%>

				<h5>
					<% out.print(errores.get("telefono")); %>
				</h5>


				<%} %>

			</div>

			<div class="p_ciudades">
				<p>Seleccione su Ciudad</p>
				<select name="ciudades" id="" class="ciudades">
					<option value="">Seleccione..</option>
					<option value="05001">Medellin</option>
					<option value="05318">Guarne</option>
					<option value="05321">Guatape</option>
					<option value="05376">La ceja</option>
					<option value="05440">Marinilla</option>
					<option value="05441">El Peñol</option>
					<option value="05615">Rionegro</option>
					<option value="05649">Rionegro</option>
					<option value="05656">San Jerónimo</option>
					<option value="05667">San Rafael</option>
				</select>
				<%if(errores != null && errores.containsKey("ciudades")){%>

				<h5>
					<% out.print(errores.get("ciudades")); %>
				</h5>


				<%} %>

			</div>

			<div>
				<label>Codigo Postal</label> <input type="text"
					placeholder="su codigo postal" id="codigoPostal"
					name="codigoPostal">
				<%if(errores != null && errores.containsKey("codigoPostal")){%>

				<h5>
					<% out.print(errores.get("codigoPostal")); %>
				</h5>


				<%} %>

			</div>

			<div>
				<label>Direccion</label> <input type="text"
					placeholder="su direccion" id="codigoPostal" name="direccion">
					
				<%if(errores != null && errores.containsKey("direccion")){%>

				<h5>
					<% out.print(errores.get("direccion")); %>
				</h5>


				<%} %>

			</div>

			<input type="submit" name="crud" value="crear" class="boton_mov">

		</form>




	</div>




</body>

</html>