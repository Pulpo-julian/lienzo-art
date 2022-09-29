<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<head>
<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<%@ page import="java.util.List"%>
<%@ page import="com.grupotres.app.modelos.Categoria"%>
<% List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias"); %>
<aside class="categorias">

	


	
		<blockquote class="categoria">
		
			<h2><b>Categorias</b></h2>
		
			<ul class="lista">
				<%if(categorias != null) {%>
					<%for(Categoria categoria: categorias) { %>			
						<li>
							<a href="${pageContext.request.contextPath}/controlprincipal?idcategoria=<% out.print(categoria.getCodigo()); %>&accion=listarporcategoria"><% out.print(categoria.getNombre()); %></a>
						</li>
					<%} %>
				<%}%>	
			</ul>	
			
		</blockquote>
	
	

</aside>