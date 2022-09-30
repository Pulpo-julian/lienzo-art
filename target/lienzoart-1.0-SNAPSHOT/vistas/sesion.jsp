<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" href="estilos/login1.css">
    <!-- JQuery -->
    <script src="https://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>



	<script defer type="text/javascript" src="scripts/sesion.js"></script>
	<script defer type="text/javascript" src="scripts/main.js"></script>
	
    <title>Iniciar sesión en LienzoArt</title>

</head>
<body>

    <div class="container">
    
    

	
		<div class="row">
		
			<div id="iconmain"class="col-6">
			
				<a href="${pageContext.request.contextPath}/controlprincipal">
					<img src="img/logo.png">
				</a>	
				
			</div>
		
			<div class="formulario col-6">
			
				<form action="${pageContext.request.contextPath}/formulariousuario" method="post">
				
					<h1>Iniciar sesión</h1>
					
					<div class="email col-11 m-3">
					
						<label for="correo" class="form-label">Correo electrónico</label>
						<input type="email" placeholder="Correo" id="correo" name="correo" class="form-control">
						
						
					</div>
					
					<div class="contraseña col-11 m-3">
					
						<label for="password" class="form-label">Contraseña</label>
						<input type="password" placeholder="Contraseña" id="password" name="password" class="form-control">
						
						
					</div>
					
					<input type="submit" name="botonsesion" value="Iniciar sesión" class="btn btn-secondary col-11 m-3 text-dark">
				
				</form>
				
				<div class="registro">
				
	
					<form action="${pageContext.request.contextPath}/controlsesion" method="post">
						
						<h6>¿No tienes una cuenta? <input type="submit" name="registro" id="btnregistro" value="Regístrate" class="boton_mov mt-3"> </h6>
						<h6>¿Olvidaste tu contraseña? <input type="submit" name="sesion" id="btnregistro" value="Recupérala" class="boton_mov"> </h6>	
						
					</form>	
				
				</div>
			
			</div>
			
		
		</div>



   	</div>
    
    

    
</body>
</html>