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
import com.intermediario.interfaceUsuario;


@WebServlet("/CargarListasDatos")
public class CargarListasDatosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private interfaceCurso ICurso;
	private interfaceUsuario IUsuario;
	
    public CargarListasDatosServlet() {
        super();
      
    }

    private void cargarListaDeDatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String arg1 = (String)request.getParameter("Tipo");
    	
    	ICurso = Fabrica.getInstancia().getICurso();
    	IUsuario = Fabrica.getInstancia().getIUsuario();
    	
    	
    	if(arg1.compareTo("Categorias") == 0) {
    		Set<String> CategoriasSinOrdernar = ICurso.listarCategorias();
    		List<String> Categorias = new ArrayList<>(CategoriasSinOrdernar);
    		Categorias.sort(Comparator.comparing( String::toString ));
    		
    		
    		request.setAttribute("ListaCategorias", Categorias);
    		request.getRequestDispatcher("/WEB-INF/paginas/paginaListarCategorias.jsp").forward(request, response);
    	}else if(arg1.compareTo("Institutos") == 0) {
    		Set<String> InstitutosSinOrdernar = ICurso.listarInstitutos();
    		List<String> Institutos = new ArrayList<>(InstitutosSinOrdernar);
    		Institutos.sort(Comparator.comparing( String::toString ));
    		
    		request.setAttribute("ListaInstitutos", Institutos);
    		request.getRequestDispatcher("/WEB-INF/paginas/paginaListarInstitutos.jsp").forward(request, response);
    	}else if(arg1.compareTo("Usuarios") == 0) {
    		Set<String> UsuariosSinOrdenar = IUsuario.listarUsuarios();
    		List<String> Usuarios = new ArrayList<>(UsuariosSinOrdenar);
    		Usuarios.sort(Comparator.comparing(String::toString));
    		
    		request.setAttribute("ListaUsuarios", Usuarios);
    		request.getRequestDispatcher("/WEB-INF/paginas/paginaListarUsuarios.jsp").forward(request, response);
    	}else if(arg1.compareTo("ProgramasFormacion") == 0) {
    		Set<String> x = ICurso.listarProgramas();
    		List<String> ProgramaFormacion = new ArrayList<>(x);
    		ProgramaFormacion.sort(Comparator.comparing( String::toString ));
    		
    		
    		request.setAttribute("ListaProgramaFormacion", ProgramaFormacion);
    		request.getRequestDispatcher("/WEB-INF/paginas/paginaListarProgramaFormacion.jsp").forward(request, response);
    	}
    	
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cargarListaDeDatos(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cargarListaDeDatos(request, response);
	}

}
