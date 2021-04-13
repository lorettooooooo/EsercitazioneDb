
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cerca una città</title>
</head>
<body>
<div>${loggedUser}</div>
	<a href="Home.jsp">torna alla home</a>
	<div>
		<form method="get">
			<input type="text" name="cityName" placeholder ="nome città">
			<input type="submit" value="Cerca una città" formaction="/EsercitazioneDb/GetCityServlet">
		</form>
	</div>
	
	<p>${city.name} - ${city.countryCode} - ${city.district} -
		${city.population}</p>
	
</body>
</html>
