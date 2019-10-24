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
			return "Feil i en eller flere felt.";
					
		default:
			return "";
		}
		
	}
	
	public String getFeilmelding() {
		return feilmelding;
	}

}
