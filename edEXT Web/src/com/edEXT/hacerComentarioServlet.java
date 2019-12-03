package com.edEXT;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import publicador.NoSePudoResponderExcep_Exception;
import publicador.EdicionNoExisteExcep_Exception;
import com.intermediario.Fabrica;
import com.intermediario.interfaceCurso;


@WebServlet("/hacerComentario")
public class hacerComentarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private interfaceCurso ICurso;


    public hacerComentarioServlet() {
        super();
    }
    
    private void hacerComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	ICurso = Fabrica.getInstancia().getICurso();
    	String edicion = (String) request.getParameter("nombreEdicion");
    	String comen = (String)request.getParameter("responder");
    	if(comen != null) {
    	if(comen.equalsIgnoreCase("true")) {
    		String numerito = (String)request.getParameter("respondido");
        	int respondido = Integer.parseInt(numerito);
    		String texto = (String)request.getParameter("textirijillo");
    		HttpSession session = request.getSession();
    		String nick = (String)session.getAttribute("nick_usuario");
    		try {
    		ICurso.comentar(edicion, texto, nick, respondido);
        	request.getRequestDispatcher("/WEB-INF/paginas/paginaPrincipal.jsp").forward(request, response);

    		}catch(NoSePudoResponderExcep_Exception e ) {
    			request.getRequestDispatcher("/WEB-INF/template/404.jsp").forward(request, response);
    		}catch(EdicionNoExisteExcep_Exception j) {
    			request.getRequestDispatcher("/WEB-INF/template/404.jsp").forward(request, response);
    		}
    	}else if(comen.equalsIgnoreCase("false")) {
    		String primero = (String)request.getParameter("primero");
    		if(primero == null) {
    		request.setAttribute("nombreEdicion", edicion);
        	request.getRequestDispatcher("/WEB-INF/paginas/paginaHacerComentario.jsp").forward(request, response);
    		}else{
    			String texto = (String)request.getParameter("textirijillo");
        		HttpSession session = request.getSession();
        		String nick = (String)session.getAttribute("nick_usuario");
        		try {
        		ICurso.comentar(edicion, texto, nick);
            	request.getRequestDispatcher("/WEB-INF/paginas/paginaPrincipal.jsp").forward(request, response);

        		}catch(NoSePudoResponderExcep_Exception e ) {
        			request.getRequestDispatcher("/WEB-INF/template/404.jsp").forward(request, response);
        		}catch(EdicionNoExisteExcep_Exception j) {
        			request.getRequestDispatcher("/WEB-INF/template/404.jsp").forward(request, response);
        		}
    		}
    	}
    	}
    	String numerito = (String)request.getParameter("respondido");
    	int respondido = Integer.parseInt(numerito);
    	
    	request.setAttribute("nombreEdicion", edicion);
    	request.setAttribute("respondido", respondido);
    	request.getRequestDispatcher("/WEB-INF/paginas/paginaHacerComentario.jsp").forward(request, response);
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		hacerComment(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		hacerComment(request,response);
	}

}
