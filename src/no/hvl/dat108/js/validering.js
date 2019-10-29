/**
 * 	Klient-side validator for PåmeldingServlet
 */

'use strict'


const fornavn = document.getElementById('fornavn');
const etternavn = document.getElementById('etternavn');
const mobilnummer = document.getElementById('mobil');
const passord = document.getElementById('passord');
const passordRepetert = document.getElementById('repetert');


const submitKnapp = document.getElementById('pure-button pure-button-primary');

const godkjentNavn = s => {
	s.length >= 2 && /^[ÆØÅæøåA-Za-z- ]+$/.test(s)
};

const godKjentPassord = p => {
	p.length >= 8 && 
}



validateFirstName = firstName => {
	
};