<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
		<form method="get" action="LoginServlet"> <input type = "text" name="usernameInput"/>
		<input type="submit" value = "scegli username"/></form>
		<p>${errorMessage}</p>
</body>
</html>
