package no.hvl.dat108.hjelpeklasser;

import no.hvl.dat108.entiteter.Deltager;

public class Test {

	public static void main(String[] args) {
		
		Deltager d = new Deltager("41414141","Enannen","Person","Fisk123!","K");
		Validator v = new Validator(d);
		System.out.println(v.alleGodkjent());
		
		
		
	}
	
}
