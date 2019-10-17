<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Deltagerliste</title>
</head>
<body>
	<h2>Deltagerliste</h2>
	<table class="pure-table">
		<tr bgcolor="#cccccc">
			<th>Kjønn</th>
			<th align="left">Navn</th>
			<th align="left">Mobil</th>
		</tr>
		<c:forEach items="${deltagere}" var="d">
			<tr bgcolor="#aaffaa">
				<td align="center">&#9792;</td>
				<td>${d.fornavn} ${d.etternavn}</td>
				<td>${d.mobilnummer }</td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<a href="logout">Ferdig</a>
	</p>
</body>
</html>