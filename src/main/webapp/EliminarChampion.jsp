<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Listado campeon</title>
</head>
<body>
<br/>
<form action="/ChampionDelete" method="post">
	<span>Seguro que quiere borrar la campeon ${name} y sus abilidades asociadas</span>
	<input type="hidden" id="id" name="id" value="${id}">
	<br />
	<input type="submit">
</form>
<br/>
<a href="Titulacion/TitulacionList.jsp">Listado de titulaciones</a>
<a href="../index.jsp">Menu principal</a>
<br/>
</body>
</html>