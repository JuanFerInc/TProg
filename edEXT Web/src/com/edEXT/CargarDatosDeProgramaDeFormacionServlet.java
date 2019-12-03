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

import publicador.DtPrograma;


@WebServlet("/CargarDatosDeProgramaDeFormacion")
public class CargarDatosDeProgramaDeFormacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private interfaceCurso ICurso;
       
    public CargarDatosDeProgramaDeFormacionServlet() {
        super();
    }

    private void darDatosProgramaDeFormacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String nombrePrograma = (String)request.getParameter("NombrePF");
    	ICurso = Fabrica.getInstancia().getICurso();
    	DtPrograma programa = (DtPrograma) ICurso.verDatosPrograma(nombrePrograma);
    	request.setAttribute("DatosPrograma", programa);
    	Set<String> cursos = ICurso.listarCursosExistente();
    	Set<String> cursosEnPrograma = new HashSet<String>( programa.getCursos());
    	for(String iter: cursosEnPrograma) {
    		if(cursos.contains(iter)) {
    			cursos.remove(iter);
    		}
    	}
    	request.setAttribute("cursosSinPrograma", cursos);
    	request.getRequestDispatcher("/WEB-INF/paginas/paginaDatosProgramaDeFormacion.jsp").forward(request, response);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		darDatosProgramaDeFormacion(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		darDatosProgramaDeFormacion(request, response);
	}

}
