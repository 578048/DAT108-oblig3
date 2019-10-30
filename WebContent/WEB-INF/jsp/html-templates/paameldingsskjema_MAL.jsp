

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Påmelding</title>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,700' rel='stylesheet' type='text/css'>
    
    <link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/formhack.css">
    
</head>

<body>

<div class="container">
    <form class="paamelding" method="post">
        <h1>Påmeldingsskjema</h1>
        
        <p>
		<font color="red">
			${feilmelding}
		</font>
		</p>

        <label for="fornavn">
            <span>Fornavn</span>

            <input type="text" id="fname" name="fornavn" minlength="2" required>
            <ul class="input-requirements">
                <li>Navnet må være minimum 2 bokstaver.</li>
                <li>Navnet må være maksimum 20 bokstaver.</li>
                <li>Kun bokstaver, -, og mellomrom tillatt.</li>
            </ul>
        </label>

        <label for="etternavn">
            <span>Etternavn</span>

            <input type="text" id="lname" name="etternavn" minlength="2" required>
            <ul class="input-requirements">
                <li>Navnet må være minimum 2 bokstaver.</li>
                <li>Navnet må være maks 20 bokstaver.</li>
                <li>Kun bokstaver, -, tillatt.</li>
            </ul>
        </label>

        <label for="mobilnummer">
            <span>Mobilnummer</span>

            <input type="text" id="phone" name="mobil" minlength="8" required>
            <ul class="input-requirements">
                <li>Mobilnummeret må være akkurat 8 siffer langt.</li>
                <li>Kun siffer tillatt.</li>
            </ul>
        </label>

        <label for="password">
            <span>Passord</span>
            <br>
            
            <span id="progresslabel"></span>

            <input type="password" id="pwd" name="passord" minlength="8" required>
            <ul class="input-requirements">
                <li>Minimum 8 tegn.</li>
                <li>Maksimum 40 tegn.</li>
                <li>Må inneholde minst ett tall.</li>
                <li>Må inneholde minst én stor bokstav.</li>
                <li>Må inneholde minst én liten bokstav.</li>
            </ul>

        </label>

        <label for="password_repeat">
            <span>Repeter passord</span>
            <input type="password" id="pwd_repeat" name="passordRepetert" minlength="8" required>
            <ul class="input-requirements">
                <li>Må være identisk med passord i forrige linje.</li>
            </ul>
        </label>

	<span class="checkbox-container">
        <label>
            <input type="radio" name="kjonn" value="M" required> Mann<br>
            <input type="radio" name="kjonn" value="K"> Kvinne<br>
        </label>
	</span>
        <br>

        <input type="submit">

    </form>
</div>
    <script src="js/Validation.js"></script>
    <script src="js/password-strength.js"></script>

</body>
</html>