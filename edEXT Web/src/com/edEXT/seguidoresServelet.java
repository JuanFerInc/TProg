package com.edEXT;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.intermediario.Fabrica;
import com.intermediario.interfaceUsuario;

import publicador.UsuarioNoExisteExcep_Exception;


@WebServlet("/seguidores")
public class seguidoresServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private interfaceUsuario IUsuario;

    public seguidoresServelet() {
        super();
    }

    private void seguirlo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	IUsuario = Fabrica.getInstancia().getIUsuario();
    	String seguir = (String)request.getParameter("seguir");
    	String desde = (String)request.getParameter("desde");
    	String hasta = (String)request.getParameter("hasta");
    	try {
    	if(seguir.equalsIgnoreCase("true")) {
    		IUsuario.generarSeguimiento(desde, hasta);
    	}else {
    		IUsuario.eliminarSeguimiento(desde, hasta);
    	}
    	}catch(UsuarioNoExisteExcep_Exception excepcioncita) {
    		excepcioncita.printStackTrace();
    		System.out.println(excepcioncita.getMessage());
    	}
    	response.sendRedirect("Principal");
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		seguirlo(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		seguirlo(request,response);
	}

}
