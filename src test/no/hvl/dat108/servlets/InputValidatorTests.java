package no.hvl.dat108.servlets;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat108.entiteter.Deltager;
import no.hvl.dat108.hjelpeklasser.NameConverter;
import no.hvl.dat108.hjelpeklasser.Validator;

class InputValidatorTests {

	private Deltager d;
	private Validator v;
	
	@BeforeEach
	void setup() {
		
		d = new Deltager("","","","","","");
		v = new Validator(d);
	}
	
	@Test
	void testFornavn() {
		
		d.setFornavn("ole-marius");
		assertFalse(v.validateFirstName(d.getFornavn()));
		
		d.setFornavn(NameConverter.convertFirstLetter(d.getFornavn()));
		assertTrue(v.validateFirstName(d.getFornavn()));
		
		d.setFornavn("A");
		assertFalse(v.validateFirstName(d.getFornavn()));
		
	}
	
	@Test
	void testEtternavn() {
		
		d.setEtternavn("krogh-mariussen");
		assertFalse(v.validateFirstName(d.getEtternavn()));
		
		d.setEtternavn(NameConverter.convertFirstLetter("kroghmariussen"));
		assertTrue(v.validateFirstName(d.getEtternavn()));
		
		d.setEtternavn("A");
		assertFalse(v.validateFirstName(d.getEtternavn()));
		
	}
	
	@Test
	void testPassord() {
		
		d.setPassord("ingentall");
		assertEquals(false ,v.validatePassword(d.getPassord()));
		
		d.setPassord("ingenstorebokstaver");
		assertFalse(v.validatePassword(d.getPassord()));
		
		d.setPassord("kort");
		assertFalse(v.validatePassword(d.getPassord()));
		
		d.setPassord("321ogbokstaver");
		assertFalse(v.validatePassword(d.getPassord()));
		
		d.setPassord("Dette123virker");
		assertTrue(v.validatePassword(d.getPassord()));
		
	}
	
	@Test
	void testMobil() {
		
		d.setMobilnummer("1234567"); //for lite
		assertFalse(v.validatePhoneNumber(d.getMobilnummer()));
		d.setMobilnummer("123456789"); //for langt
		assertFalse(v.validatePhoneNumber(d.getMobilnummer()));
		d.setMobilnummer("12345678"); //for lite
		assertTrue(v.validatePhoneNumber(d.getMobilnummer()));
		
		d.setMobilnummer("123abc12");
		assertFalse(v.validatePhoneNumber(d.getMobilnummer()));
		
		
		
		
	}

}
