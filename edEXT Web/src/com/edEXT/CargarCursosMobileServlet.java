package com.edEXT;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.intermediario.Fabrica;
import com.intermediario.interfaceCurso;


@WebServlet("/CargarCursosMobile")
public class CargarCursosMobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private interfaceCurso ICurso;
  
	
    public CargarCursosMobileServlet() {
        super();
       
    }
    
    private void cargarCursosMobile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.removeAttribute("ListaCursos");
    	
    	String arg1 = (String)request.getParameter("arg1");
    	String arg2 = (String)request.getParameter("arg2");
    	ICurso = Fabrica.getInstancia().getICurso();
    	
    	if(arg1.compareTo("Categoria") == 0) {
    		Set<String> res;
    		res = ICurso.seleccionarCategoria(arg2);
    		List<String> Cursos = new ArrayList<>(res);
    		Cursos.sort(Comparator.comparing(String::toString));
    		
    		request.setAttribute("ListaCursos", Cursos);
    		
    	}else if(arg1.compareTo("Instituto") == 0) {
    		Set<String> res;
    		res = ICurso.seleccionarInstituto(arg2);
    		List<String> Cursos = new ArrayList<>(res);
    		Cursos.sort(Comparator.comparing(String::toString));
    		
    		request.setAttribute("ListaCursos", Cursos);
    	}
    	
    	request.getRequestDispatcher("/WEB-INF/paginas/paginaListarCursosMobile.jsp").forward(request, response);
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cargarCursosMobile(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cargarCursosMobile(request,response);
	}

}
