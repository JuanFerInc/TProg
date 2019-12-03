package com.edEXT;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.intermediario.Fabrica;
import com.intermediario.interfaceUsuario;

import publicador.DtUsuario;


@WebServlet("/Perfil")
public class PerfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private interfaceUsuario IUsuario;

	public PerfilServlet() {
		super();
	
	}

	private void cargarPerfil(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IUsuario = Fabrica.getInstancia().getIUsuario();
		String nick = (String)request.getParameter("nick");
		DtUsuario dtU = IUsuario.seleccionarUsuario(nick);
		request.setAttribute("dtUsuario", dtU);

		request.getRequestDispatcher("/WEB-INF/paginas/paginaPerfil.jsp").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		cargarPerfil(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		cargarPerfil(request, response);
	}

}
