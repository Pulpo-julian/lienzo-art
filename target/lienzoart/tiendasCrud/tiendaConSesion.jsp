<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 07/10/2022
  Time: 06:04 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page import="com.grupotres.app.modelos.Categoria"%>

<% List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias"); %>
<% Map<String, String> errores = (Map<String, String>) request.getAttribute("errores"); %>
<% String nombre = (String) request.getAttribute("nombre"); %>
<% String descripcion = (String) request.getAttribute("descripcion"); %>
<% String precio = (String) request.getAttribute("precio"); %>

<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
