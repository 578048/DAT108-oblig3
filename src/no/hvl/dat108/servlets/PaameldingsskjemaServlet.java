package no.hvl.dat108.servlets;

import java.io.IOException;

import java.security.NoSuchAlgorithmException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.postgresql.util.PSQLException;

import no.hvl.dat108.EAO.DeltagerEAO;
import no.hvl.dat108.entiteter.Deltager;
import no.hvl.dat108.hjelpeklasser.FeilMeldingUtil;
import no.hvl.dat108.hjelpeklasser.InnloggingUtil;
import no.hvl.dat108.hjelpeklasser.PassordHashing;
import no.hvl.dat108.hjelpeklasser.Validator;
import static no.hvl.dat108.hjelpeklasser.UrlMappings.DELTAGERLISTE_URL;
import static no.hvl.dat108.hjelpeklasser.UrlMappings.PAAMELDING_URL;
import static no.hvl.dat108.hjelpeklasser.UrlMappings.BEKREFTELSE_URL;;
/**
 * Servlet implementation class PaameldingsskjemaServlet
 */

@WebServlet("/" + PAAMELDING_URL)
public class PaameldingsskjemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private DeltagerEAO deltagerEAO;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String feilkode = request.getParameter("feilkode");
		
		if (feilkode == null) {
			
			request.getRequestDispatcher("/WEB-INF/jsp/html-templates/paameldingsskjema_MAL.jsp")
			.forward(request, response);
			
		}
		
		FeilMeldingUtil util = new FeilMeldingUtil(feilkode);
		
		request.setAttribute("feilmelding", util.getFeilmelding());
		
		request.getRequestDispatcher("/WEB-INF/jsp/html-templates/paameldingsskjema_MAL.jsp")
			.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String mobilnummer = request.getParameter("mobil");
		String passord = request.getParameter("passord");
		String fornavn = request.getParameter("fornavn");
		String etternavn = request.getParameter("etternavn");
		String kjoenn = request.getParameter("kjonn");
		
		
		Deltager d = new Deltager(mobilnummer,fornavn,etternavn,passord,kjoenn, "");
		Validator v = new Validator(d);

		if(v.alleGodkjent()) {
			
			PassordHashing pH = new PassordHashing(PassordHashing.SHA256);
			
			byte[] salt = pH.getSalt();
			try {
				pH.generateHashWithSalt(passord, salt);
			} catch(NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			
			String hashedPassord = pH.getPasswordHashinHex();
			String passordSalt = pH.getPasswordSalt();
			
			d.setPassord(hashedPassord);
			d.setSalt(passordSalt);
			
			System.out.println(d.getSalt());
			
			
			boolean lagtTil = deltagerEAO.leggTilDeltager(d);
			
			if (lagtTil) {
				
				//logge inn
				
				InnloggingUtil.loggInn(request, d);
				
				response.sendRedirect(BEKREFTELSE_URL);
				
			} else {
				//ikke lagt til / mobilnummer finnes fra før
				
				response.sendRedirect(PAAMELDING_URL + "?feilkode=4");
				
			}
			
			
		} else { //ikke godkjente felt
			response.sendRedirect(PAAMELDING_URL + "?feilkode=5");
		}
		
		
		
		
		
		//doGet(request, response);
	}

}
