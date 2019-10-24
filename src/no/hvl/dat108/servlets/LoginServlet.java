package no.hvl.dat108.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import static no.hvl.dat108.hjelpeklasser.UrlMappings.DELTAGERLISTE_URL;
import static no.hvl.dat108.hjelpeklasser.UrlMappings.LOGIN_URL;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat108.EAO.DeltagerEAO;
import no.hvl.dat108.entiteter.Deltager;
import no.hvl.dat108.hjelpeklasser.FeilMeldingUtil;
import no.hvl.dat108.hjelpeklasser.InnloggingUtil;
import no.hvl.dat108.hjelpeklasser.PassordHashing;
import no.hvl.dat108.hjelpeklasser.UrlMappings;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/" + LOGIN_URL)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private DeltagerEAO deltagerEAO;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		
		String feilkode = request.getParameter("feilkode");
		
		if (feilkode == null) {
			
			request.getRequestDispatcher("/WEB-INF/jsp/html-templates/logginn_MAL.jsp")
			.forward(request, response);
			
		}
		
		FeilMeldingUtil util = new FeilMeldingUtil(feilkode);
		String feilmelding = util.getFeilmelding();
		
		request.setAttribute("feilmelding", feilmelding);
		
		request.getRequestDispatcher("/WEB-INF/jsp/html-templates/logginn_MAL.jsp")
		.forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String mobilnummer = request.getParameter("mobil");
		Deltager d = deltagerEAO.hentDeltagerMedBrukernavn(mobilnummer);
		//FeilMeldingUtil fmu;
		String feilkode = "";
		//PassordHashing hasher = new PassordHashing("SHA-256");
		
		
		if (d == null) { //mobilnummer/bruker eksisterer ikke
			feilkode = "1";
			//fmu = new FeilMeldingUtil(feilkode);
			response.sendRedirect(LOGIN_URL + "?feilkode=" + feilkode);
		} else {
			
			System.out.println(d.toString());
			
			String dbPassord = d.getPassord();
			//byte[] salt = hasher.getSalt();
			
			
			String plaintext = request.getParameter("passord");
			
			boolean likePassord = plaintext.equals(dbPassord); //uten hash
			
			//String hashedPassord = hasher.getPasswordHashinHex();
			
			if (!likePassord) {
				feilkode = "2";
				response.sendRedirect(LOGIN_URL + "?feilkode=" + feilkode );			
				
			} else {
				
				InnloggingUtil.loggInn(request, d);
				response.sendRedirect(DELTAGERLISTE_URL);
				
			}
			
				
				
				
			
			
			
		}
		
		
		//doGet(request, response);
	}

}
	