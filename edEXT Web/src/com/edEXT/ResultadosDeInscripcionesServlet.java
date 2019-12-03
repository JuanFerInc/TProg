package com.edEXT;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ResultadosDeInscripciones")
public class ResultadosDeInscripcionesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ResultadosDeInscripcionesServlet() {
        super();

    }

    private void atenderResultadosDeInscripciones(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	
    	request.getRequestDispatcher("/WEB-INF/paginas/paginaResultadosDeInscripciones.jsp").forward(request, response);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		atenderResultadosDeInscripciones(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		atenderResultadosDeInscripciones(request, response);
	}

}
