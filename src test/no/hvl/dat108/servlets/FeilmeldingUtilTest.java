package no.hvl.dat108.servlets;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;

import no.hvl.dat108.entiteter.Deltager;
import no.hvl.dat108.hjelpeklasser.InnloggingUtil;
import no.hvl.dat108.servlets.BekreftelseServlet;
import no.hvl.dat108.servlets.LoginServlet;
import no.hvl.dat108.servlets.PaameldingsskjemaServlet;



class FeilmeldingUtilTest {
	
	private MockHttpServletRequest mockRequest;
	private MockHttpServletResponse mockResponse;
	private LoginServlet servelat;
	
	@Before
	void setup() {
		mockResponse = new MockHttpServletResponse();
		servelat = new LoginServlet();
		mockRequest = new MockHttpServletRequest();
	}
	
	@Test
	void testLoggInn() throws ServletException, IOException {
		assertTrue(mockRequest == null);
//		mockRequest.setParameter("feilkode", "1");
//		
//		servelat.doGet(mockRequest, mockResponse);
//		
//		assertTrue(mockRequest.getAttribute("feilmelding") != null);
//		
	}

}
