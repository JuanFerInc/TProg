package com.edEXT;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.intermediario.Fabrica;
import com.intermediario.interfaceCurso;
import com.intermediario.interfaceUsuario;

import publicador.DtUsuario;


@WebServlet("/inicioDe")
public class inicioDe extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private interfaceUsuario IUsuario;
    private interfaceCurso ICurso;
    
    public inicioDe() {
    	
        super();

    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo = request.getParameter("Tipo");
    	HttpSession session = request.getSession();
    	ICurso = Fabrica.getInstancia().getICurso();
    	IUsuario = Fabrica.getInstancia().getIUsuario();
    	
    	if(tipo.compareTo("Session") == 0) {
    		request.getRequestDispatcher("/WEB-INF/paginas/inicioSession.jsp").forward(request, response);
    	}else if(tipo.compareTo("Registrar") == 0) {
    		Set<String> insti=ICurso.listarInstitutos();
    		request.setAttribute("institutos", insti);
    		request.getRequestDispatcher("/WEB-INF/paginas/paginaRegistrarUsuario.jsp").forward(request, response);
    	}else if(tipo.compareTo("AltaDeEdicionDeCurso") == 0) {
    		session.setAttribute("Instituto", (String)request.getParameter("Instituto"));
    		String cursito=(String)request.getParameter("nombreCurso");
    		request.setAttribute("cursito", cursito);
    		Set<String> docentes=IUsuario.listarDocentes();
    		request.setAttribute("docs", docentes);
    		request.getRequestDispatcher("/WEB-INF/paginas/paginaAltaDeEdicionDeCurso.jsp").forward(request, response);
    	}else if(tipo.compareTo("AltaDeCurso") == 0) {
    		session.setAttribute("Instituto", (String)request.getParameter("Instituto"));
    		Set<String> prev=ICurso.listarCursosExistente();
    		Set<String> cat=ICurso.listarCategorias();
    		request.setAttribute("categorias", cat);
    		request.setAttribute("previas", prev);
    		request.getRequestDispatcher("/WEB-INF/paginas/paginaAltaDeCurso.jsp").forward(request, response);
    	}else if(tipo.compareTo("crearProgramaDeFormacion") == 0) {
    		request.getRequestDispatcher("/WEB-INF/paginas/paginaAltaProgramaDeFormacion.jsp").forward(request, response);
    	}else if(tipo.compareTo("Editar") == 0) {
			String nick = request.getParameter("Nick");
    		DtUsuario DtU = Fabrica.getInstancia().getIUsuario().verDatosUsuario(nick);
    		request.setAttribute("DtUsuario", DtU);
    		request.getRequestDispatcher("/WEB-INF/paginas/paginaEditarPerfil.jsp").forward(request, response);
    	}
	}

}
