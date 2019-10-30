<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>

	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,700' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">

	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/formhack.css">
<meta charset="UTF-8">

<title>Deltagerliste</title>
</head>
<body>
<div class="container">
	<h1>Deltagerliste</h1>
	<table class="pure-table">
	<c:forEach items="${deltagere}" var="d">
			<c:choose>
				<c:when test="${d.mobilnummer eq mobil}">  
					<tr bgcolor="#00ff00">
						<td align="center">${d.kjoenn}</td>
						<td>${d.fornavn} ${d.etternavn}</td>
						<td>
						<c:set value="${d.mobilnummer}" var="m"/>
						<c:out value="${fn:substring(m,0,3)} ${fn:substring(m,3,5)} ${fn:substring(m,5,8)}"/>
						</td>
					</tr>
				</c:when>
				<c:otherwise> 
				
					<tr bgcolor="#FFFFFF">
						<td align="center">${d.kjoenn}</td>
						<td>${d.fornavn} ${d.etternavn}</td>
						<td>
						<c:set value="${d.mobilnummer}" var="m" />
						<c:out value="${fn:substring(m,0,3)} ${fn:substring(m,3,5)} ${fn:substring(m,5,8)}"/>
						</td>
					</tr>
					
				</c:otherwise> 
			
			</c:choose>
		</c:forEach>
		</table>
		
	<p>
		<a href="logout">Logg ut</a>
	</p>
</div>

</body>
</html>