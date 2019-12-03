package com.edEXT;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.intermediario.Fabrica;
import com.intermediario.interfaceCurso;

import publicador.DtCurso;
import publicador.DtInstancia;



@WebServlet("/CargarDatosDeCursoMobile")
public class CargarDatosDeCursoMobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private interfaceCurso ICurso;
    static String CHARSET_FOR_URI_ENCODING;

    public CargarDatosDeCursoMobileServlet() {
        super();
    }
    
    private void cargarDatosCursoMobile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ICurso = Fabrica.getInstancia().getICurso();
    	String nombreCurso = java.net.URLDecoder.decode(request.getParameter("nombreCurso"),"UTF-8");
    	DtCurso curso = ICurso.verDatosCurso(nombreCurso);
    	
    	if(curso.getEdicionActual().compareTo("") != 0) {
    		DtInstancia edicionVigente = ICurso.verDatosEdicion(curso.getEdicionActual());
    		request.setAttribute("DatosEdicionActual", edicionVigente);
    	}
    	
    	request.setAttribute("DatosCurso", curso);
    	request.getRequestDispatcher("/WEB-INF/paginas/paginaDatosDeCursoMobile.jsp").forward(request, response);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cargarDatosCursoMobile(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cargarDatosCursoMobile(request,response);
	}

}
