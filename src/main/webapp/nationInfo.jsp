<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cerca una nazione</title>
</head>
<body>
	<a href="index.jsp">torna alla home</a>
	<div>
		<form method="get">
			<input type="text" placeholder="nome nazione" name="nationName"/>
			<input type = "text" placeholder="nome continente" name="continentName"/>
			<input type="submit" value="Cerca una nazione" formaction="/EsercitazioneDb/GetNationServlet"/>
		</form>
	</div>
	<c:forEach items="${nationList}" var="nation">
	 <p>${nation.code} - ${nation.name} - ${nation.continent} -
		${nation.population} - ${nation.area}</p>
	</c:forEach>
	
</body>
</html>