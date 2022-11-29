<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index page</title>
</head>
<body>
	<form action="/insertChampion" method="post">
		<span>id:</span> <input type="text" name="id"> <br />
		<span>Nombre:</span> <input type="text" name="name"> <br />
		<span>Titulo:</span> <input type="text" name="title"> <br />
		<span>Lore:</span> <input type="text" name="lore"> <br />
		<span>Tags:</span> <input type="text" name="tags"> <br />

		<input type="submit">
	</form>
</body>
</html>