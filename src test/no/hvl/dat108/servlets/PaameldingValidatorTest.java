package no.hvl.dat108.servlets;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat108.entiteter.Deltager;
import no.hvl.dat108.hjelpeklasser.Validator;

class PaameldingValidatorTest {
	
	private Validator validator;
	private Deltager deltager;
	
	@BeforeEach
	void setup() {
		
		deltager = new Deltager("","","","","","");
		validator = new Validator(deltager);
		
	}
	
	@Test
	void testFornavnOgEtternavn() {
	
		deltager.setFornavn("Åge");
		deltager.setEtternavn("Ågesen");
		
		assertTrue(validator.validateFirstName(deltager.getFornavn()) && 
				validator.validateLastName(deltager.getEtternavn()));
		
		deltager.setEtternavn("aNNE");
		assertFalse(validator.validatePassword(deltager.getFornavn()));
		
	}
	
	@Test
	void testMobilNummer() {
		deltager.setMobilnummer("1234567");
		assertFalse(validator.validatePhoneNumber(deltager.getMobilnummer()));
		deltager.setMobilnummer("97676522");
		assertTrue(validator.validatePhoneNumber(deltager.getMobilnummer()));
	}
	
	@Test
	void testPassord() {
	
		deltager.setPassord("ingenstorebokstaver");
		assertFalse(validator.validatePassword(deltager.getPassord()));
		deltager.setPassord("stoR"); //men for kort
		assertFalse(validator.validatePassword(deltager.getPassord()));
		deltager.setPassord("sTorOgLangNok");
		assertTrue(validator.validatePassword(deltager.getPassord()));
		
	}
	
	

}
