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

import publicador.DtInfo;
import publicador.DtInstancia;


@WebServlet("/EdicionPrevia")
public class EdicionPreviaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EdicionPreviaServlet() {
        super();
    }
    
    public class CustomComparator implements Comparator<DtInfo> {
        @Override
        public int compare(DtInfo o1, DtInfo o2) {
            return o1.getNick().compareTo(o2.getNick());
        }
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String nombreEdicion = request.getParameter("Nombre");
    	String nombreEdicion = java.net.URLDecoder.decode(request.getParameter("Nombre"),"UTF-8");
    	String nombreCurso = java.net.URLDecoder.decode(request.getParameter("NombreCurso"),"UTF-8");
		DtInstancia datos = Fabrica.getInstancia().getICurso().verDatosEdicion(nombreEdicion);
		Set<DtInfo> listaInscriptos = Fabrica.getInstancia().getICurso().listarInscripcionesAEdicion(nombreEdicion);
		
		List<DtInfo> inscriptos = new ArrayList<>(listaInscriptos);
		inscriptos.sort(new CustomComparator());
		
		request.setAttribute("Edicion", datos);
		request.setAttribute("Inscriptos", inscriptos);
		request.setAttribute("nombreCurso", nombreCurso);
		if(request.getHeader("User-Agent").indexOf("Mobile") != -1) {
			request.getRequestDispatcher("/WEB-INF/paginas/paginaEdicionesMobile.jsp").forward(request, response);
		}else {
		request.getRequestDispatcher("/WEB-INF/paginas/paginaEdicionesPrevias.jsp").forward(request, response);
		}
	}


}
