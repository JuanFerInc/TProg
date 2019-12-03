package com.edEXT;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Principal")
public class PrincipalVisitanteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	
	
	
    public PrincipalVisitanteServlet() {
    	super(); 
    }
    
    public static void initSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("estado_sesion") == null) {
			session.setAttribute("estado_sesion", TipoSession.NO_LOGIN);
		}
	}


	private void processRequest(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		initSession(req);
		if(req.getHeader("User-Agent").indexOf("Mobile") != -1) {
			req.getRequestDispatcher("/WEB-INF/paginas/LoginMobile.jsp").forward(req, resp);
		}else {
		req.getRequestDispatcher("/WEB-INF/paginas/paginaPrincipal.jsp").forward(req, resp);
		}
	
	}
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
