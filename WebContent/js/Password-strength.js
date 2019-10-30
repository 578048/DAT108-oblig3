"use strict";

/*------------------
 
 - Sjekker styrken på passordet ved sjekk av lengde og antall krav for regex som er oppfylt. 
   Passordet får poengscore, som benyttes i switch og deretter returnerer en streng til bruker.
 - Inspirert av et spørsmål på StackOverflow, og deler av kode er hentet fra:
 	"https://stackoverflow.com/questions/53966456/javascript-simple-password-strength-indicator"
 - Skrevet av: Kristoffer, Aksel, Thomas, Christian, Sølve, Teodor
 
 -------------*/

let password = document.getElementById("pwd");
let text = document.getElementById("progresslabel");

password.addEventListener('keyup', function() {
    let pwd = password.value;
    if (pwd.length === 0) {
        document.getElementById("progresslabel").innerHTML = "";
        
    }

    let strength = "";
    let prog = [/[$@!%*#?&]/, /[A-Z]/, /[0-9]/, /[a-z]/]
        .reduce((memo, test) => memo + test.test(pwd), 0);

    if (prog > 2 && pwd.length > 7) {
        prog++;
    }

    switch (prog) {
        default:
        case 1:
            strength = "Veldig svakt.";
            document.getElementById("progresslabel").style.color = '#d00';
            break;
        case 2:
            strength = "Svakt.";
            document.getElementById("progresslabel").style.color = '#DD7700';
            break;
        case 3:
            strength = "OK.";
            document.getElementById("progresslabel").style.color = '#DDD900';
            break;
        case 4:
            strength = "Sterkt";
            document.getElementById("progresslabel").style.color = '#88DD00';
            break;
        case 5:
            strength = "Veldig sterkt.";
            document.getElementById("progresslabel").style.color = '#00DD15';
            break;
    }

    document.getElementById("progresslabel").innerHTML = strength;

});



