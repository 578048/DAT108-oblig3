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
			return "Ugyldig brukernavn, prøv igjen.";
		case "2":
			return "Ugyldig passord, prøv igjen";
		case "3":
			return "Sesjonen er utløpt, logg inn på nytt.";
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
