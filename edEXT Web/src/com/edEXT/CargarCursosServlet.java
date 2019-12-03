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
import javax.servlet.http.HttpSession;

import com.intermediario.Fabrica;
import com.intermediario.interfaceCurso;

@WebServlet("/CargarCursos")
public class CargarCursosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private interfaceCurso ICurso;
    

    public CargarCursosServlet() {
        super();
       
    }

    private void cargarCursos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String arg1 = (String)request.getParameter("arg1");
    	String arg2 = (String)request.getParameter("arg2");
    	HttpSession session = request.getSession();
    	ICurso = Fabrica.getInstancia().getICurso();
    	
    	
    	Set<String> res;
    	
    	if(arg1.compareTo("Categoria") == 0) {
    		//este tiene que cambiar la funcion selecccionarInstituto por una que te list
    		//lost cursos dependiendo de la cetegoria que sea selccionada
    		res = ICurso.seleccionarCategoria(arg2);
    		List<String> Cursos = new ArrayList<>(res);
    		Cursos.sort(Comparator.comparing(String::toString));
    		
    		
    		request.setAttribute("ListaCursos", Cursos);
    		
    	}else if(arg1.compareTo("Instituto") == 0) {
    		res = ICurso.seleccionarInstituto(arg2);
    		List<String> Cursos = new ArrayList<>(res);
    		Cursos.sort(Comparator.comparing(String::toString));
    		
    		
    		request.setAttribute("NombreInsituto", arg2);
    		request.setAttribute("ListaCursos", Cursos);
    		
    	}
    	
    	
    	request.getRequestDispatcher("/WEB-INF/paginas/paginaListarCursos.jsp").forward(request, response);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cargarCursos(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cargarCursos(request, response);
	}

}
