package no.hvl.dat108.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat108.entiteter.Deltager;
import no.hvl.dat108.hjelpeklasser.InnloggingUtil;

import static no.hvl.dat108.hjelpeklasser.UrlMappings.BEKREFTELSE_URL;

/**
 * Servlet implementation class BekreftelseServlet
 */
@WebServlet("/" + BEKREFTELSE_URL)
public class BekreftelseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Deltager d = (Deltager)request.getSession().getAttribute("deltager");
		System.out.println(d);
		String mobilnummer = d.getMobilnummer();
		String fornavn = d.getFornavn();
		String etternavn = d.getEtternavn();
		String kjoenn = d.getKjoenn();
		
		request.setAttribute("mobil", mobilnummer);
		request.setAttribute("fornavn", fornavn);
		request.setAttribute("etternavn", etternavn);
		request.setAttribute("kjoenn", kjoenn);
		
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/html-templates/paameldingsbekreftelse_MAL.jsp")
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
