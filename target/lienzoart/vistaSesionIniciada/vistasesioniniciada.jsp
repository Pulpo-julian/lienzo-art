<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Font Awesome -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
	<!-- Bootstrap -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<!-- JQuery -->
	<script src="https://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
	<link rel="stylesheet" href="estilos/estiloscategoriasproductos.css" id="recargar">
	<title>Lienzo Art</title>
</head>
<body>

	<!-- HEADER -->
	<jsp:include page="../commons/headerSesion.jsp"></jsp:include>
	        
	<!-- SECCION PRINCIPAL -->
	<div class="principal">
	
		
		<!-- ASIDE CATEGORIAS -->			
		<jsp:include page="../commons/aside.jsp"></jsp:include>
	
		
		<!-- SECCION PRODUCTOS -->			
  			<jsp:include page="../commons/secccionProductosConCarro.jsp"></jsp:include>
		
	
	</div>
			
	<!-- SECCION FOOTER -->
	<jsp:include page="../commons/footer.jsp"></jsp:include>

</body>
</html>