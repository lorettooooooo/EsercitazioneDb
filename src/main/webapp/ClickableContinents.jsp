<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca Da Continenti</title>
</head>
<body>
	<a href="index.jsp">torna alla home</a>
	<c:forEach items="${continentsList}" var="continent">
		<p>
			<a href="/EsercitazioneDb/GetNationsServlet?continentName=${continent.name}">${continent.name}</a>
		</p>
	</c:forEach>
	<p>${continentSelected}</p>
	<p>${nationSelected}</p>
	<c:forEach items="${nationList}" var="nation">
		<p>
			<a href="/EsercitazioneDb/GetCitiesServlet?nationCode=${nation.code}&nationName=${nation.name}">${nation.name}</a> - abitanti: ${nation.population}
		</p>
	</c:forEach>
	<c:forEach items="${citiesList}" var="city">
		<p>
			<a href="https://www.youtube.com/watch?v=dQw4w9WgXcQ">${city.name}</a> - abitanti: ${city.population}
		</p>
	</c:forEach>

</body>
</html>