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
<link rel="stylesheet" href="../estilos/Styles.css">
<script defer src="../scripts/main.js"></script>
<title>Registrate en LienzoArt</title>
</head>

<body>

	<div>


		<h1>Actualizar Usuario</h1>
		<form action="${pageContext.request.contextPath}/formulariousuario" method="post" class="form_usuario">

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







			<input type="submit" name="crud" value="actualizar" class="boton_mov">

		</form>




	</div>




</body>

</html>