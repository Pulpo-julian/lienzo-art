$(document).ready(() => {
	
	$(".respuestabusqueda").hide();

	$("#btnbuscar").click((event) => {
		
		
		buscar();
		
		
	});
	
	$("#buscador").keyup((event) => {
		
		if(event.keyCode == 13){
			
			buscar()
			
		}
		
	});
	
	
	
	function buscar(){
		
		var buscar = $("#buscador").val();
		
		if(buscar != ""){
			
			$.post("barrabusqueda", {buscar: buscar});
				
			/*
			$.post("barrabusqueda", {buscar: buscar}, (responseText) => {
				
				//$(".seccion").html(responseText);
				
				if(responseText.length > 0) {
					
					$(".seccion").html("");
					
					$(".respuestabusqueda").show();
					
					$("#titulorespuesta").html("Productos relacionados con: \"" + buscar + "\"");
					
					var productosHtml = "";
					
					responseText.forEach((value)  => {
						
						productosHtml += "<div class=\"producto card\" style=\"border-radius: 10px;\"";
						
						productosHtml += "		<div class=\"muestra\">";
						
						productosHtml += "			<a href=\"/CrudNuevoLienzoArt/formularioproducto?\">";
						
						productosHtml += "				<img alt=\"#\" src=\"" + value.urlImagen +"\" class=\"img\">";
						
						productosHtml += "			</a>";
									
						productosHtml += "			<h4>" + value.nombre + "</h4>";
						
						productosHtml += "		</div>";
								
						productosHtml += "		<div class=\"informacion\">";
								
						productosHtml += "				<ul class=\"listaproducto\">";
										
						productosHtml += "					<li> <h6>Categoria:" + value.categoria + "</h6> </li>";
						
						productosHtml += "					<li> <h6>Estado:" + value.estado + "</h6> </li>";
						
						productosHtml += "					<li> <h6>Existencia:" + value.existencia + "</h6> </li>";
						
						productosHtml += "					<li> <h6>Tienda: <a class=\"tienda\" href=\"#\">" + value.tienda + "</a> </h6> </li>";
										
						productosHtml += "				</ul>";
						
						productosHtml += "				<div class=\"preciocarrito\">";
						
						productosHtml += "					<a href=\"#\" class=\"precio\"> $" + value.precio + "</a>";
						
						productosHtml += "					<a href=\"#\" class=\"carrito\"><i class=\"fas fa-cart-plus\"></i></a>";
						
						productosHtml += "				</div>";
								
						productosHtml += "		</div>";
								
						productosHtml += "</div>";
						
					});
					
					//console.log(responseText[0].codigo);
					
					$(".seccion").html(productosHtml);
					
					
						
				} else {
					
					$(".seccion").html("");
					
					$(".respuestabusqueda").show();
					
					$("#titulorespuesta").html("No hay productos relacionados con: \"" + buscar + "\"");
				}
				
				console.log(responseText.length);
				
			});
			*/
				
				
		// entra cuando el campo de busqueda esta vacia
		} else {
			
			return;
			
		}
		
	} 
	
	
	

	
	
	
	
});