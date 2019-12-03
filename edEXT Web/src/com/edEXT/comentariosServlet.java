package com.edEXT;

import java.io.IOException;


import java.util.ArrayList;
import java.util.HashSet;
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
import publicador.DtComentario;
import publicador.DtEdicion;
import publicador.DtInstancia;

@WebServlet("/comentarios")
public class comentariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private interfaceCurso ICurso;
 
    public comentariosServlet() {
        super();
    }
    
    private List<DtComentario> darDtes(DtComentario i){
    	List<DtComentario> ret = new ArrayList<DtComentario>();
    	ret.add(i);
    	for(DtComentario pe : i.getRespuestas()) {
    		List<DtComentario> pep = darDtes(pe);
    		for(DtComentario p : pep) {
    			ret.add(p);
    		}
    	}
		return ret;
    }

    private void comentariado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ICurso = Fabrica.getInstancia().getICurso();
    	String edicion = (String) request.getParameter("nombreEdicion");
    	String curso = (String) request.getParameter("nombreCurso");
    	Set<DtComentario> comentarios = ICurso.verComentarios(curso, edicion);
    	List<DtComentario> res = new ArrayList<DtComentario>();
    	for(DtComentario i: comentarios) {
    		List<DtComentario> pepe = darDtes(i);
    		for(DtComentario j: pepe) {
    			res.add(j);
    		}
    	}
    	request.setAttribute("nombreEdicion", edicion);
    	request.setAttribute("comentario", res);
    	request.getRequestDispatcher("/WEB-INF/paginas/paginaListarComentarios.jsp").forward(request, response);

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		comentariado(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		comentariado(request,response);
	}

}
