package com.edEXT;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.intermediario.Fabrica;
import com.intermediario.interfaceCurso;
import com.intermediario.interfaceUsuario;


import publicador.NoPudoInscribirseExcep_Exception;


/**
 * Servlet implementation class subscribirServlet
 */
@WebServlet("/subscribir")
public class subscribirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private interfaceUsuario IUsuario;
	private interfaceCurso ICurso;
  
    public subscribirServlet() {
        super();
        
    }
    private void suscribir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NoPudoInscribirseExcep_Exception {
    	HttpSession session = request.getSession();
    	IUsuario = Fabrica.getInstancia().getIUsuario();
    	ICurso = Fabrica.getInstancia().getICurso();
    	String nick = (String)session.getAttribute("nick_usuario");
    	IUsuario.seleccionarEstudiante(nick);
		String curso = (String)request.getParameter("Curso");
		ICurso.seleccionarCurso(curso);
		String video="hacer";
		IUsuario.inscribirEstudianteACurso(video);
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			suscribir(request, response);
		} catch (NoPudoInscribirseExcep_Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			suscribir(request, response);
		} catch (NoPudoInscribirseExcep_Exception e) {
			e.printStackTrace();
		}
	}

}
