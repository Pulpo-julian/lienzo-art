<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.List"%>
<%@ page import="com.grupotres.app.modelos.Usuario"%>
<% List<Usuario> listaUsuario = (List<Usuario>)request.getAttribute("listUsuarios"); %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	 <!--  <link rel="stylesheet" href="../estilos/listarEstilos.css"> -->
	<script defer src="../scripts/main.js"></script>
	<title>Insert title here</title>
	
	<style>
	
		.usuario {
		
			padding: 20px;
			border: 1px black solid;
			margin-left: auto;
			margin-right: auto;
			display: grid;
			grid-template-columns: 1fr 1fr;
		
		}
	
	</style>


</head>


<body>

	<%if (listaUsuario != null && listaUsuario.size() > 0) {%>
	
	
		<%for(int i = 0; i < listaUsuario.size(); i++) { %>
		
			<div class="usuario">
			
				<h1> Documento del usuario:  <% out.print(listaUsuario.get(i).getDocid()); %></h1>
				<h1> nombres del usuario:  <% out.print(listaUsuario.get(i).getNombres()); %></h1>
				<h1> apellidos del usuario:  <% out.print(listaUsuario.get(i).getApellidos()); %></h1>
				<h1> correo del usuario:  <% out.print(listaUsuario.get(i).getCorreo());%></h1>
			
			</div>
		
		
		
		
		<%} %>
		
		
		
		
	<%} %>
	

	<form action="/CrudNuevoLienzoArt/formulariousuario" method="post">
	
		
	
		<input type="submit" name="crud" value="listar">
	
	</form>

</body>
</html>