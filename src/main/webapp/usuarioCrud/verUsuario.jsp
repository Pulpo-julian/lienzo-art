<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.Map"%>
<%@ page import="modelos.Usuario"%>
<% Usuario usuario = (Usuario) request.getAttribute("usuario"); %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../estilos/Styles.css">
<script defer src="../scripts/main.js"></script>
<title>Registrate en LienzoArt</title>
</head>

<body>

	<div>


		<h1>Buscar Usuario</h1>
		<form action="/CrudNuevoLienzoArt/formulariousuario" method="post" class="form_usuario">

			<div>
				<label>Cedula</label> <input type="text" placeholder="su cedula"
					id="cedula" name="cedula">

				

			</div>




			<input type="submit" name="crud" value="mostrar" class="boton_mov">

		</form>
		
		<%if(usuario != null){%>

					<h1>cedula del usuario:</h1>

					<h5>
						<% out.print(usuario.getDocid()); %>
					</h5>
					
					<h1>Nombres del usuario:</h1>

					<h5>
						<% out.print(usuario.getNombres()); %>
					</h5>
					
					<h1>apellidos del usuario:</h1>

					<h5>
						<% out.print(usuario.getApellidos()); %>
					</h5>
					
					<h1>correo del usuario:</h1>

					<h5>
						<% out.print(usuario.getCorreo()); %>
					</h5>


		<%} %>




	</div>




</body>

</html>