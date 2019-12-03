package com.edEXT;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.intermediario.Fabrica;
import com.intermediario.interfaceCurso;

import publicador.DtCurso;
import publicador.DtInfo;
import publicador.DtInstancia;

@WebServlet("/CargarDatosDeCurso")
public class CargarDatosDeCursoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private interfaceCurso ICurso;
    static String CHARSET_FOR_URI_ENCODING;
    
    public CargarDatosDeCursoServlet() {
        super();
        
    }

    private void darDatosCurso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	    			
    	ICurso = Fabrica.getInstancia().getICurso();
    	String nombreCurso = java.net.URLDecoder.decode(request.getParameter("nombreCurso"),"UTF-8");
    	DtCurso curso = ICurso.verDatosCurso(nombreCurso);
    	

    	if(curso.getEdicionActual().compareTo("") != 0) {
    		DtInstancia edicionVigente = ICurso.verDatosEdicion(curso.getEdicionActual());
    		request.setAttribute("DatosEdicionActual", edicionVigente);
    		Set<DtInfo> inscripciones = ICurso.listarInscripcionesACurso(nombreCurso);
    		Set<String> inscripcionesPendientes = new HashSet<String>();
    		for(DtInfo iter: inscripciones) {
    			if(iter.getEdicion().equals(edicionVigente.getNombre())) {
    				if(iter.getEstado().equals("Inscripto")) {
    					inscripcionesPendientes.add(iter.getNick());
    				}
    			}
    		}
    		request.setAttribute("InscripcionesPendientes", inscripcionesPendientes);
    		Set<String> inscripcionesAceptadas = new HashSet<String>();
    		for(DtInfo iter: inscripciones) {
    			if(iter.getEdicion().equals(edicionVigente.getNombre())) {
    				if(iter.getEstado().equals("Aceptada")) {
    					inscripcionesAceptadas.add(iter.getNick());
    				}
    			}
    		}
    		request.setAttribute("InscripcionesAceptadas", inscripcionesAceptadas);
    	}
    	
    	request.setAttribute("DatosCurso", curso);
    	
    	request.getRequestDispatcher("/WEB-INF/paginas/paginaDatosDeCurso.jsp").forward(request, response);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		darDatosCurso(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		darDatosCurso(request, response);
	}

}
