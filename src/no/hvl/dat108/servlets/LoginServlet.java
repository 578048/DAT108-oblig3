package no.hvl.dat108.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static no.hvl.dat108.hjelpeklasser.UrlMappings.LOGIN_URL;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat108.EAO.DeltagerEAO;
import no.hvl.dat108.entiteter.Deltager;
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
		
		List<Deltager> liste = deltagerEAO.hentAlleDeltagere();
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		liste.forEach(out::println);
		
		request.getRequestDispatcher("/WEB-INF/jsp/html-templates/logginn_MAL.jsp")
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
