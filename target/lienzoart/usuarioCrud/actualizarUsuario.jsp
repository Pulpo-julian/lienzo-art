<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.Map"%>
<%@ page import="com.grupotres.app.modelos.Usuario" %>
<%@ page import="com.grupotres.app.modelos.Ciudad" %>
<%@ page import="java.util.List" %>
<% Map<String, String> errores = (Map<String, String>)request.getAttribute("errores"); %>
<% Usuario usuario = (Usuario) request.getSession().getAttribute("usuario"); %>
<% List<Ciudad> ciudades = (List<Ciudad>) request.getAttribute("ciudades"); %>
<% String mensajeExito = (String) request.getAttribute("mensaje"); %>
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
<link rel="stylesheet" href="estilos/estilosactualizarusuario.css">

<title>Actualiza tus datos en LienzoArt</title>
</head>

<body>
	<!-- HEADER -->
	<jsp:include page="../commons/headerSesion.jsp"></jsp:include>

	<div class="formulario">


		<h1 class="title">Actualizar Usuario</h1>
		<form action="${pageContext.request.contextPath}/formulariousuario" method="post" class="form_usuario row">

			<div class="col-6 mt-3">
				<label class="form-label">Cedula</label>
				<input class="form-control" type="text" value="<% if((errores != null && errores.containsKey("cedula")) || (errores != null && !errores.containsKey("cedula"))){
					out.print(cedula);
				} else {
					out.print(usuario.getDocid());
				}
					%>"
											 id="cedula" name="cedula">

				<%if(errores != null && errores.containsKey("cedula")){%>

				<h5>
					<% out.print(errores.get("cedula")); %>
				</h5>

				<%} %>

			</div>


			<div class="col-6 mt-3">
				<label class="form-label">Nombres</label>
				<input class="form-control" type="text" value="<% if((errores != null && errores.containsKey("nombre")) || (errores != null && !errores.containsKey("nombre"))){
					out.print(nombre);
				} else {
					out.print(usuario.getNombres());
				}
					%>"
					id="nombre" name="nombre">

				<%if(errores != null && errores.containsKey("nombre")){%>

				<h5>
					<% out.print(errores.get("nombre")); %>
				</h5>


				<%} %>

			</div>

			<div class="col-6 mt-3">
				<label class="form-label">Apellidos</label>
				<input class="form-control" type="text"
						 						value="<% if((errores != null && errores.containsKey("apellidos")) || (errores != null && !errores.containsKey("apellidos"))){
					out.print(apellidos);
				} else {
					out.print(usuario.getApellidos());
				}
					%>" id="apellidos" name="apellidos">
				<%if(errores != null && errores.containsKey("apellidos")){%>

				<h5>
					<% out.print(errores.get("apellidos")); %>
				</h5>


				<%} %>

			</div>

			<div class="col-6 mt-3">
			
			
				<label class="form-label">Correo</label>
				<input class="form-control" type="text" value="<% if((errores != null && errores.containsKey("correo")) || (errores != null && !errores.containsKey("correo"))){
					out.print(correo);
				} else {
					out.print(usuario.getCorreo());
				}
					%>"
					id="correo" name="correo">

				<%if(errores != null && errores.containsKey("correo")){%>

				<h5>
					<% out.print(errores.get("correo")); %>
				</h5>

				<%} %>


			</div>






			<%if(usuario.getPerfil() == 3){%>

				<div>
					<p>por ahora eres un usuario comprador, crea una tienda para convertirte en Vendedor</p>
				</div>

			<%} else  if (usuario.getPerfil() == 2) {%>

				<div>
					<p>Ahora eres vendedor, ya puedes publicar tus productos en tus tiendas</p>
				</div>

			<%} %>

			<div class="col-6 mt-3">


				<label class="form-label">Telefono</label>
				<input class="form-control" type="text" value="<% if((errores != null && errores.containsKey("telefono")) || (errores != null && !errores.containsKey("telefono"))){
					out.print(telefono);
				} else {
					out.print(usuario.getTelefono());
				}
					%>"
											 id="correo" name="telefono">

				<%if(errores != null && errores.containsKey("telefono")){%>

				<h5>
					<% out.print(errores.get("telefono")); %>
				</h5>

				<%} %>


			</div>

			<div class="col-6 mt-3">


				<label class="form-label">Seleccione su Ciudad: </label>

				<select name="ciudades" id="" class="form-select" required>
					<%for(int i = 0; i < ciudades.size(); i++) {
						String codigoCiudad = ciudades.get(i).getCodigo();
						String nombreCiudad = ciudades.get(i).getNombre();
					%>
						<%if(ciudad == null) {%>
							<option value="<%out.print(codigoCiudad); %>" <%if(codigoCiudad.equals(usuario.getCiudad())){%> <% out.print("selected"); %> <%} %>><%out.print(nombreCiudad);%></option>
						<%} else {%>
							<option value="<%out.print(codigoCiudad); %>" <%if(codigoCiudad.equals(ciudad)){%> <% out.print("selected"); %> <%} %>><%out.print(nombreCiudad);%></option>
						<%} %>
					<%} %>

				</select>



			</div>

			<div class="col-6 mt-3">


				<label class="form-label">Código Postal</label>
				<input class="form-control" type="text" value="<% if((errores != null && errores.containsKey("codigoPostal")) || (errores != null && !errores.containsKey("codigoPostal"))){
					out.print(codigoPostal);
				} else {
					out.print(usuario.getCodigoPostal());
				}
					%>"
											   id="codigopostal" name="codigoPostal">

				<%if(errores != null && errores.containsKey("codigoPostal")){%>

				<h5>
					<% out.print(errores.get("codigoPostal")); %>
				</h5>

				<%} %>


			</div>

			<div class="col-6 mt-3">


				<label class="form-label">Direccion</label>
				<input class="form-control" type="text" value="<% if((errores != null && errores.containsKey("direccion")) || (errores != null && !errores.containsKey("direccion"))){
					out.print(direccion);
				} else {
					out.print(usuario.getDireccion());
				}
					%>"
											   id="direccion" name="direccion">

				<%if(errores != null && errores.containsKey("direccion")){%>

				<h5>
					<% out.print(errores.get("direccion")); %>
				</h5>

				<%} %>


			</div>

			<input id="btn" type="submit" name="crud" value="actualizar" class="btn btn-primary boton_mov mt-4">

		</form>

		<%if(mensajeExito != null) {%>

			<h4>Has actualizado tus datos con exito!!!</h4>

		<%} %>



	</div>




</body>

</html>