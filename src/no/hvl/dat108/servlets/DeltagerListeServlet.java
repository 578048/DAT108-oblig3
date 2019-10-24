package no.hvl.dat108.servlets;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import no.hvl.dat108.EAO.DeltagerEAO;
import no.hvl.dat108.entiteter.Deltager;
import no.hvl.dat108.hjelpeklasser.InnloggingUtil;

import static no.hvl.dat108.hjelpeklasser.UrlMappings.LOGIN_URL;
import static no.hvl.dat108.hjelpeklasser.UrlMappings.DELTAGERLISTE_URL;
/**
 * Servlet implementation class DeltagerListeServlet
 */
@WebServlet("/" + DELTAGERLISTE_URL)
public class DeltagerListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private DeltagerEAO deltagerEAO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
		response.setContentType("text/plain");
		
		
		if (!InnloggingUtil.erInnlogget(request)) {
			response.sendRedirect(LOGIN_URL + "?feilkode=3");
		} else {
			
			List<Deltager> liste = deltagerEAO.hentAlleDeltagere();
			
			Deltager d = (Deltager) request.getSession().getAttribute("deltager");
			
			String innloggetMobil = d.getMobilnummer();
			
			request.setAttribute("mobil", innloggetMobil);
			
			String UTFMALE = "&male;";
			String UTFFEMALE = "&female;";
			 
			liste.sort((d1,d2) -> d1.getFornavn().compareTo(d2.getFornavn()));
			
			liste.forEach( (deltager) ->  {

				if (deltager.getKjoenn().equals("M")) {
					deltager.setKjoenn(UTFMALE);
				} else {
					deltager.setKjoenn(UTFFEMALE);
				}
				
			});
			
			request.setAttribute("deltagere", liste);
			
			request.getRequestDispatcher("/WEB-INF/jsp/html-templates/deltagerliste_MAL.jsp")
				.forward(request, response);
			
			
			
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
