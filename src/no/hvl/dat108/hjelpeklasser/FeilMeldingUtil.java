package no.hvl.dat108.hjelpeklasser;

public class FeilMeldingUtil {
	
	private String feilmelding;
	
	public FeilMeldingUtil(String feilkode) {
		feilmelding = setFeilmelding(feilkode);
	}
	
	private String setFeilmelding(String feilkode) {
		
		if (feilkode == null) {
			return "";
		}
		
		switch(feilkode) {
		case "1":
			return "Ugyldig brukernavn, pr�v igjen.";
		case "2":
			return "Ugyldig passord, pr�v igjen";
		case "3":
			return "Sesjonen er utl�pt, logg inn p� nytt.";
		case "4":
			return "Mobilnummeret er allerede i bruk.";
		case "5":
			return "Feil i fornavn";
		case "6":
			return "Feil i etternavn";
		case "7":
			return "Ugyldig mobilnummer";
		case "8":
			return "Ikke sterkt nok passord";
		case "9": 
			return "Feil i flere felt";
		case "10":
			return "Mobilnummeret er allerede registrert";
		
					
		default:
			return "";
		
		}
		
	}
	
	public String getFeilmelding() {
		return feilmelding;
	}

}
