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



@WebServlet("/VerCursosMobile")
public class VerCursosMobile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private interfaceCurso ICurso;

       
    public VerCursosMobile() {
        super();
    }
    
    private void cargarCursosMobile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ICurso = Fabrica.getInstancia().getICurso();
    	Set<String> InstitutosSinOrdernar = ICurso.listarInstitutos();
		List<String> Institutos = new ArrayList<>(InstitutosSinOrdernar);
		Institutos.sort(Comparator.comparing( String::toString ));
		
		Set<String> CategoriasSinOrdernar = ICurso.listarCategorias();
		List<String> Categorias = new ArrayList<>(CategoriasSinOrdernar);
		Categorias.sort(Comparator.comparing( String::toString ));
		
		
		request.setAttribute("ListaCategorias", Categorias);
		request.setAttribute("ListaInstitutos", Institutos);
    	request.getRequestDispatcher("/WEB-INF/paginas/paginaVerCursosMobile.jsp").forward(request, response);

    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cargarCursosMobile(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cargarCursosMobile(request,response);
		
	}

}
