"use strict";

/* -------------------------------

   - Scriptet validerer input i realtid. 
     Validering skjer ved at hver label som tar input får sin egen tabell med valideringsfunksjoner.
     Det blir så opprettet en funksjon for hvert <li>-element i label. Hvert <li>-element inneholder et krav som må oppfylles.
     Når <li>-elementet oppfylles, skifter det farge fra rød til grønn ved hjelp av css.
     
     Eks: label fornavn har 3 <li>-elementer, og 3 tilsvarende funksjoner i en tabell. 
     Her sjekkes det for ulovlige tegn og lengde. 
     Hvis bruker prøver å sende inn data uten at alle inputfelter er godkjent, vil brukeren få en feilmelding om hva som evt. er galt.
     
   - CSS-kode er hentet fra: https://github.com/ireade/form-validation-realtime/tree/gh-pages/css
   - CustomValidation, validityChecks og andre funksjoner som kommuniserer med CSS og HTML er hentet fra:
     	"https://github.com/ireade/form-validation-realtime/blob/gh-pages/script.js"
   - Skrevet av: Kristoffer, Aksel, Thomas, Christian, Sølve, Teodor

    ----------------------------*/


function CustomValidation(input) {
    this.invalidities = [];
    this.validityChecks = [];

    //add reference to the input node
    this.inputNode = input;

    //trigger method to attach the listener
    this.registerListener();
}

CustomValidation.prototype = {
    addInvalidity: function(message) {
        this.invalidities.push(message);
    },
    getInvalidities: function() {
        return this.invalidities.join('. \n');
    },
    checkValidity: function(input) {
        for ( let i = 0; i < this.validityChecks.length; i++ ) {

            let isInvalid = this.validityChecks[i].isInvalid(input);
            if (isInvalid) {
                this.addInvalidity(this.validityChecks[i].invalidityMessage);
            }

            let requirementElement = this.validityChecks[i].element;

            if (requirementElement) {
                if (isInvalid) {
                    requirementElement.classList.add('invalid');
                    requirementElement.classList.remove('valid');
                } else {
                    requirementElement.classList.remove('invalid');
                    requirementElement.classList.add('valid');
                }

            } // end if requirementElement
        } // end for
    },
    checkInput: function() { // checkInput now encapsulated

        this.inputNode.CustomValidation.invalidities = [];
        this.checkValidity(this.inputNode);

        if ( this.inputNode.CustomValidation.invalidities.length === 0 && this.inputNode.value !== '' ) {
            this.inputNode.setCustomValidity('');
        } else {
            let message = this.inputNode.CustomValidation.getInvalidities();
            this.inputNode.setCustomValidity(message);
        }
    },
    registerListener: function() { //register the listener here

        let CustomValidation = this;

        this.inputNode.addEventListener('keyup', function() {
            CustomValidation.checkInput();
        });


    }

};

let fornavnValidateChecks;
fornavnValidateChecks = [
    {
        isInvalid: function (input) {
            return input.value.length < 2;
        },
        invalidityMessage: 'Input er for kort.',
        element: document.querySelector('label[for=fornavn] .input-requirements li:nth-child(1)')
    },
    {
        isInvalid: function (input) {
            return input.value.length > 20;
        },
        invalidityMessage: 'Input er for langt.',
        element: document.querySelector('label[for=fornavn] .input-requirements li:nth-child(2)')
    },
    {
        isInvalid: function (input) {
            let variables = input.value.match(/[^-A-ZÆØÅa-zæøå0-9 ]/g);
            return !!variables;
        },
        invalidityMessage: 'Input har ulovlige tegn.',
        element: document.querySelector('label[for=fornavn] .input-requirements li:nth-child(3)')
    }
];

let etternavnValidateChecks;
etternavnValidateChecks = [
    {
        isInvalid: function (input) {
           return input.value.length < 2;
        },
        invalidityMessage: 'Input er for kort.',
        element: document.querySelector('label[for="etternavn"] .input-requirements li:nth-child(1)')
    },
    {
        isInvalid: function (input) {
            return input.value.length > 20;
        },
        invalidityMessage: 'Input er for lang.',
        element: document.querySelector('label[for="etternavn"] .input-requirements li:nth-child(2)')
    },
    {
        isInvalid: function (input) {
        let variables = input.value.match(/[^A-ZÆØÅa-zæøå0-9-]/g);
        return !!variables;
    },
        invalidityMessage: 'Input har ulovlige tegn.',
        element: document.querySelector('label[for=etternavn] .input-requirements li:nth-child(3)')
    }
];

let nummerValidateChecks;
nummerValidateChecks = [
    {
        isInvalid: function (input) {
            return input.value.length !== 8;
        },
        invalidityMessage: 'Input har ikke 8 sifre.',
        element: document.querySelector('label[for=mobilnummer] .input-requirements li:nth-child(1)')
    },
    {
        isInvalid: function (input) {
            return !input.value.match(/[0-9]/g);
        },
        invalidityMessage: 'Input består ikke av kun sifre.',
        element: document.querySelector('label[for=mobilnummer] .input-requirements li:nth-child(2)')
    }
];

let passordValidateChecks;
passordValidateChecks = [
    {
        isInvalid: function (input) {
            return input.value.length < 8;
        },
        invalidityMessage: 'Input er for kort.',
        element: document.querySelector('label[for="password"] .input-requirements li:nth-child(1)')
    },
    {
        isInvalid: function (input) {
            return input.value.length > 40;
        },
        invalidityMessage: 'Input er for langt.',
        element: document.querySelector('label[for="password"] .input-requirements li:nth-child(2)')
    },
    {
        isInvalid: function (input) {
            return !input.value.match(/[0-9]/g);
        },
        invalidityMessage: 'Passordet mangler minst ett tall.',
        element: document.querySelector('label[for="password"] .input-requirements li:nth-child(3)')
    },
    {
        isInvalid: function (input) {
            return !input.value.match(/[A-Z]/g);
        },
        invalidityMessage: 'Passordet mangler minst én stor bokstav.',
        element: document.querySelector('label[for="password"] .input-requirements li:nth-child(4)')
    },
    {
        isInvalid: function (input) {
            return !input.value.match(/[a-z]/g);
        },
        invalidityMessage:'Passordet mangler minst én liten bokstav.',
        element: document.querySelector('label[for="password"] .input-requirements li:nth-child(5)')
    }

];

let password_repeatValidateChecks;
password_repeatValidateChecks = [
    {
        isInvalid: function () {
            return passord_repeatinput.value !== passordInput.value;
        },
        invalidityMessage: 'Passordene er ikke like.',
        element: document.querySelector('label[for="password_repeat"] .input-requirements li:nth-child(1)')
    }
];

let fornavnInput = document.getElementById("fname");
let etternavnInput = document.getElementById("lname");
let nummerInput = document.getElementById("phone");
let passordInput = document.getElementById("pwd");
let passord_repeatinput = document.getElementById("pwd_repeat");


fornavnInput.CustomValidation = new CustomValidation(fornavnInput);
fornavnInput.CustomValidation.validityChecks = fornavnValidateChecks;

etternavnInput.CustomValidation = new CustomValidation(etternavnInput);
etternavnInput.CustomValidation.validityChecks = etternavnValidateChecks;

nummerInput.CustomValidation = new CustomValidation(nummerInput);
nummerInput.CustomValidation.validityChecks = nummerValidateChecks;

passordInput.CustomValidation = new CustomValidation(passordInput);
passordInput.CustomValidation.validityChecks = passordValidateChecks;

passord_repeatinput.CustomValidation = new CustomValidation(passord_repeatinput);
passord_repeatinput.CustomValidation.validityChecks = password_repeatValidateChecks;

let inputs = document.querySelectorAll('input:not([type="submit"])');

let submit = document.querySelector('input[type="submit"]');
let form = document.getElementById('registrering');

function validate() {
    for (let i = 0; i < inputs.length; i++) {
        inputs[i].CustomValidation.checkInput();
    }
}

submit.addEventListener('click', validate);
form.addEventListener('submit', validate);
