package com.edEXT;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.intermediario.Fabrica;
import com.intermediario.interfaceUsuario;

import publicador.DtDocente;
import publicador.DtUsuario;
import publicador.LoginIncorrectoExcep_Exception;

@WebServlet("/atenderLogin")
public class atenderLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private interfaceUsuario IUsuario;
 
    public atenderLogin() {
        super();
       
    }

	private void intentarLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IUsuario = Fabrica.getInstancia().getIUsuario();
		HttpSession session = request.getSession();
		
		if(request.getHeader("User-Agent").indexOf("Mobile") != -1) {
			session.removeAttribute("nick_usuario"); //PUEDE SER QUE NO DEJE BORRAR SI NO HAY
			String id = request.getParameter("inputID");
			String pas = request.getParameter("inputPassword");
			
			try {
				String nick = IUsuario.iniciarSesion(id, pas);
				DtUsuario user = IUsuario.verDatosUsuario(nick);
				
				if(user instanceof DtDocente) {
					session.setAttribute("estado_sesion", TipoSession.LOGIN_DOCENTE);
					request.setAttribute("error_login","Los docentes no tienen acceso");
					request.getRequestDispatcher("/WEB-INF/paginas/LoginMobile.jsp").forward(request, response);
				}else {
					session.setAttribute("estado_sesion", TipoSession.LOGIN_ESTUDIANTE);
					session.setAttribute("nick_usuario", nick);
					response.sendRedirect("LoginMobile");
				}
				
				
			}catch(LoginIncorrectoExcep_Exception e) {
				session.setAttribute("estado_sesion",TipoSession.NO_LOGIN);	
				request.setAttribute("error_login","No Existe Usuario");
				request.getRequestDispatcher("/WEB-INF/paginas/LoginMobile.jsp").forward(request, response);
			}
			
		}else {
		
		if( request.getParameter("Tipo")!= null && request.getParameter("Tipo").toString().compareTo("logout") == 0) {
			session.setAttribute("estado_sesion",TipoSession.NO_LOGIN);	
			session.removeAttribute("nick_usuario");
			response.sendRedirect("Principal");
			
		}else {

			String id = request.getParameter("inputID");
			String pas = request.getParameter("inputPassword");
			
			try {
				String nick = IUsuario.iniciarSesion(id, pas);
				DtUsuario user = IUsuario.verDatosUsuario(nick);
				
				if(user instanceof DtDocente) {
					session.setAttribute("estado_sesion", TipoSession.LOGIN_DOCENTE);
					session.setAttribute("nick_usuario", nick);
					response.sendRedirect("Principal");
				}else {
					session.setAttribute("estado_sesion", TipoSession.LOGIN_ESTUDIANTE);
					session.setAttribute("nick_usuario", nick);
					response.sendRedirect("Principal");
				}
				
				
			}catch(LoginIncorrectoExcep_Exception e) {
				session.setAttribute("estado_sesion",TipoSession.NO_LOGIN);	
				request.setAttribute("error_login","No Existe Usuario");
				request.getRequestDispatcher("/WEB-INF/paginas/inicioSession.jsp").forward(request, response);
			}
			
		}
	}
		
		
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		intentarLogin(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		intentarLogin(request, response);
	}

}
