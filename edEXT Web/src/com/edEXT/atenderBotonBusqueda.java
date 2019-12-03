package com.edEXT;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.intermediario.Fabrica;

import publicador.CursoNoExisteExcep_Exception;



@WebServlet("/TuNombreEs")
public class atenderBotonBusqueda extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
 
    public atenderBotonBusqueda() {
        super();
    }

    private void botonBuscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String buscar = request.getParameter("MMMMMMOOOOOOOOOOOOONICA");
    	String forma = request.getParameter("FormaBuscqueda");
    	Map<String,String> resultado = Fabrica.getInstancia().getICurso().buscar(buscar);
    	
    	request.setAttribute("Buscaste",buscar);
    	if(forma == null) {
         	
        	request.setAttribute("Resultado", resultado);
        	
        	
    	}else if(forma.compareTo("FiltrarCurso") == 0) {
    		
    		Iterator<Map.Entry<String,String>> iter = resultado.entrySet().iterator();
    		while (iter.hasNext()) {
    		    Map.Entry<String,String> entry = iter.next();
    		    if(entry.getValue().compareTo("Programa") == 0){
    		        iter.remove();
    		    }
    		}
    		
        	request.setAttribute("Resultado", resultado);
    	}else if(forma.compareTo("FiltrarPrograma") == 0) {
    		Iterator<Map.Entry<String,String>> iter = resultado.entrySet().iterator();
    		while (iter.hasNext()) {
    		    Map.Entry<String,String> entry = iter.next();
    		    if(entry.getValue().compareTo("Curso") == 0){
    		        iter.remove();
    		    }
    		}
    		
        	request.setAttribute("Resultado", resultado);
    	}else if(forma.compareTo("Alfa") == 0) {
    		
    		List<String> ayuda = Fabrica.getInstancia().getICurso().ordenar(resultado.keySet());
    		request.setAttribute("Ayuda", ayuda);
    		request.setAttribute("Resultado", resultado);
    		
    	}else if(forma.compareTo("Fecha") == 0) {
    		
    
			try {
				List<String> ayuda = Fabrica.getInstancia().getICurso().ordenarSegunAnio(resultado.keySet());
				request.setAttribute("Ayuda", ayuda);
				request.setAttribute("Resultado", resultado);
			} catch (CursoNoExisteExcep_Exception e) {
				e.printStackTrace();
			}
    		
    		
    		
    	}
    	request.getRequestDispatcher("/WEB-INF/paginas/paginaListarBusqueda.jsp").forward(request, response);
	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		botonBuscar(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		botonBuscar(request,response);
	}

}
