package no.hvl.dat108.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat108.EAO.DeltagerEAO;
import no.hvl.dat108.entiteter.Deltager;

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
		
		List<Deltager> liste = deltagerEAO.hentAlleDeltagere();
		request.setAttribute("deltagere", liste);
		
		request.getRequestDispatcher("/WEB-INF/jsp/html-templates/deltagerliste_MAL.jsp")
			.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
