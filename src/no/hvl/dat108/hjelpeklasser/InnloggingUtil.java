package no.hvl.dat108.hjelpeklasser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import no.hvl.dat108.entiteter.Deltager;

public class InnloggingUtil {
	
	
	public static boolean erInnlogget(HttpServletRequest request) {
		
		HttpSession sesjon = request.getSession();
		
		if (sesjon == null || sesjon.getAttribute("deltager") == null) {
			return false;
		}
		
		return true;
	}
	
	public static void loggInn(HttpServletRequest request, Deltager d) {
		
		HttpSession sesjon = request.getSession(false);
		if (erInnlogget(request)) {
			sesjon.invalidate();
		}
		
		sesjon = request.getSession(true);
		sesjon.setAttribute("deltager", d);
		sesjon.setMaxInactiveInterval(10);
		
		
	}
	
	public static void loggUt(HttpServletRequest request) {
		HttpSession sesjon = request.getSession();
		sesjon.invalidate();
		
	}
	
	
	
	
		
}
