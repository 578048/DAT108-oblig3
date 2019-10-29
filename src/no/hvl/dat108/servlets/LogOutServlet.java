package no.hvl.dat108.servlets;

import java.io.IOException;
import static no.hvl.dat108.hjelpeklasser.UrlMappings.LOGOUT_URL;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat108.hjelpeklasser.InnloggingUtil;

/**
 * Servlet implementation class LogOutServlet
 */
@WebServlet("/" + LOGOUT_URL)
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		InnloggingUtil.loggUt(request);
		
		System.out.println(InnloggingUtil.erInnlogget(request));
		
		request.getRequestDispatcher("/WEB-INF/jsp/html-templates/ferdig_MAL.jsp")
		.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
