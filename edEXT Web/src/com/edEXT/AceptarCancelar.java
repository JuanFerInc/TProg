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
import publicador.EstadoEsFinalExcep_Exception;
import publicador.NoPudoInscribirseExcep_Exception;




/**
 * Servlet implementation class AceptarCancelar
 */
@WebServlet("/AceptarCancelar")
public class AceptarCancelar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AceptarCancelar() {
        super();
        // TODO Auto-generated constructor stub
    }

	private void aceptarCancelar (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String Tipo = request.getParameter("Tipo");
		String holaabb=request.getParameter("nick");
		String nomcurso=request.getParameter("cursito");
		//ayyy monica
		interfaceCurso ICurso = Fabrica.getInstancia().getICurso();
		try {
			ICurso.cambiarEstado(Tipo, holaabb);
	    	String nombreCurso = nomcurso;
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
			} catch (EstadoEsFinalExcep_Exception e){
				String nombreCurso = nomcurso;
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
		    	request.setAttribute("error", e);
		    	
		    	request.getRequestDispatcher("/WEB-INF/paginas/paginaDatosDeCurso.jsp").forward(request, response);
				
			} catch  (NoPudoInscribirseExcep_Exception et){
				et.printStackTrace();
				System.out.println(et.getMessage());
				
			}
		
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		aceptarCancelar(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		aceptarCancelar(request,response);
	}

}
