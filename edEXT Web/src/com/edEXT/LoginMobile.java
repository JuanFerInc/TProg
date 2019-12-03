package com.edEXT;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginMobile")
public class LoginMobile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginMobile() {
        super();
    }
    
    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	if(request.getHeader("User-Agent").indexOf("Mobile") != -1 || (session.getAttribute("estado_sesion") == TipoSession.LOGIN_DOCENTE)) {
    	
    	request.getRequestDispatcher("/WEB-INF/paginas/paginaPrincipalMobile.jsp").forward(request, response);
    	}else {
        	request.getRequestDispatcher("/WEB-INF/template/404.jsp").forward(request, response);
    	}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		login(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		login(request,response);
	}

}
