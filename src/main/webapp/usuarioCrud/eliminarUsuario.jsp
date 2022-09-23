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


		<h1>Eliminar Usuario</h1>
		<form action="/CrudNuevoLienzoArt/formulariousuario" method="post" class="form_usuario">

			<div>
				<label>Cedula</label> <input type="text" placeholder="su cedula"
					id="cedula" name="cedula">

				<%if(errores != null && errores.containsKey("cedula")){%>

				<h5>
					<% out.print(errores.get("cedula")); %>
				</h5>


				<%} %>

			</div>




			<input type="submit" name="crud" value="eliminar" class="boton_mov">

		</form>




	</div>




</body>

</html>