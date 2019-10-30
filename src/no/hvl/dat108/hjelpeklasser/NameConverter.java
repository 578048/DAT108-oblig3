package no.hvl.dat108.hjelpeklasser;

public class NameConverter {
	
	public static String convertFirstLetter(String string) {
		String firstSubstring;
		String firstSecondSubstring;
		String lastSubstring;
		String lastSecondSubstring;
		String finalString;
		String finalSecondString;
		int charPos = 0;
		
		if (string.contains("-")|| string.contains(" ")) {
		if (string.contains(" ")) {
			charPos = string.indexOf(" ");
		} else if (string.contains("-")) {
			charPos = string.indexOf("-");
		}
			firstSubstring = string.substring(0, 1).toUpperCase();
			lastSubstring = string.substring(1, charPos+1).toLowerCase();
			firstSecondSubstring = string.substring(charPos+1, charPos+2).toUpperCase();
			lastSecondSubstring = string.substring(charPos+2, string.length()).toLowerCase();
			finalSecondString = firstSubstring.concat(lastSubstring).concat(firstSecondSubstring).concat(lastSecondSubstring);
			return finalSecondString;
		}
		
		
		firstSubstring = string.substring(0, 1).toUpperCase();
		lastSubstring = string.substring(1, string.length()).toLowerCase();
		finalString = firstSubstring.concat(lastSubstring);
		return finalString;
	}

}
