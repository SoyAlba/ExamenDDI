<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Listado</title>
</head>
<body>
<br/>
<div class="container">
<form action="/verChampion" method="get">
	<input type="submit" name="mostrar campeones" value="ver campeones">
</form>
<br/>
<table>
<c:forEach var="champion" items="${requestScope.lista}" varStatus="indice">
	<tr>
		<td><c:out value="${champion.id}"/></td>
		<td><c:out value="${champion.name}"/></td>
        <td><c:out value="${champion.title}"/></td>
		<td><c:out value="${champion.lore}"/></td>
		<td><c:out value="${champion.tags}"/></td>
		<td>
                <form action="/ChampionDelete" method="get">
                    <input type="hidden" name="champion_name" value="${champion.getName()}"/>
                    <input type="hidden" name="id" value="${champion.getId()}"/>
                    <input type="submit"/>
                </form>
        </td>
	</tr>
</c:forEach>
</table>
<br/>
<a type="button"href="index.jsp">Volver al index </a>
</div>
</body>
</html>