<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/formhack.css">

<title>Påmeldingsbekreftelse</title>
</head>
<body>
<div class="container">
	<h1>Påmeldingsbekreftelse</h1>
	<p>Påmeldingen er mottatt for:</p>
	
			<p>${mobil}</p>
			<p>${etternavn} ${fornavn}</p>
			<p>${kjoenn}</p>

	<a href="deltagerliste">Gå til deltagerlisten</a>
</div>

</body>
</html>