
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Logg inn</title>

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,700' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/formhack.css">
</head>

<body>
<div class="container">
	<form class="logginn" method="post">
	<h1>Innlogging</h1>
		<br>
		<p>
		<font color="red">
			${feilmelding}
		</font>
		</p>

		<label for="number_login">
			<span>Mobilnummer</span>

			<input type="text" id="mobil" name="mobil" minlength="8" required>
		</label>

		<label for="password">
			<span>Passord</span>

			<input type="password" id="password" name="passord" required>
		</label>

		<br>

		<input type="submit" value="Logg inn">
		<br>
		<p align="center">Meld deg på ved å trykke <a href="paamelding">her</a></p>
	</form>
</div>
</body>
</html>