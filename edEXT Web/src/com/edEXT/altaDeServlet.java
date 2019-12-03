package com.edEXT;

import java.io.IOException;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

import publicador.CursoRepetidoExcep_Exception;
import publicador.DtCurso;
import publicador.DtInfo;
import publicador.DtInstancia;
import publicador.DtUsuario;
import publicador.EdicionRepetidaExcep_Exception;
import publicador.EstudianteSinEvaluarExcep_Exception;
import publicador.NoPudoDesinscribirseExcep_Exception;
import publicador.NoPudoInscribirseExcep_Exception;
import publicador.ProgramaRepetidoExcep_Exception;
import publicador.TipoUsuario;


@WebServlet("/altaDe")
public class altaDeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private interfaceUsuario IUsuario;
    private interfaceCurso ICurso;
 
    public altaDeServlet() {
        super();
    }

    private void atenderRegistrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String Tipo = request.getParameter("Tipo");
    	IUsuario = Fabrica.getInstancia().getIUsuario();
    	ICurso=Fabrica.getInstancia().getICurso();
    	HttpSession session=request.getSession();
    	
    	
    	if(Tipo.compareTo("AltaUsuario") == 0) {
    	
    		String nombre = (String)request.getParameter("firstName");
    		String apellido = (String)request.getParameter("lastName");
    		String nick = (String)request.getParameter("username");
    		String email = (String)request.getParameter("email");
    		String instituto = (String)request.getParameter("instituto");
    		String docente = (String)request.getParameter("docente");
    		String pass = (String)request.getParameter("pas");
    		String passcon = (String)request.getParameter("pascon");
    		String url = (String)request.getParameter("urlimagen");
    		int anio = Integer.parseInt(request.getParameter("anio"));
    		int mes = Integer.parseInt(request.getParameter("mes"));
    		int dia = Integer.parseInt(request.getParameter("dia"));
    		GregorianCalendar fechita = new GregorianCalendar(anio,mes,dia);
    		if (docente==null) {
    			try {
    				instituto="holabb";
    				IUsuario.registrarUser(nick, nombre, apellido, fechita, email,TipoUsuario.ESTUDIANTE, instituto, pass, passcon, url);
    				session.setAttribute("estado_sesion", TipoSession.LOGIN_ESTUDIANTE);
					session.setAttribute("nick_usuario", nick);	
					request.getRequestDispatcher("/WEB-INF/paginas/paginaPrincipal.jsp").forward(request, response);
    			} catch (Exception e) {
    				request.setAttribute("errorRegistrar",e.getMessage());
    				Set<String> insti=Fabrica.getInstancia().getICurso().listarInstitutos();
    	    		request.setAttribute("institutos", insti);
    				request.getRequestDispatcher("/WEB-INF/paginas/paginaRegistrarUsuario.jsp").forward(request, response);
    			}
    		} else {
    			try {
    				IUsuario.registrarUser(nick, nombre, apellido, fechita, email, TipoUsuario.DOCENTE, instituto, pass, passcon, url);
    				session.setAttribute("estado_sesion", TipoSession.LOGIN_DOCENTE);
    				session.setAttribute("nick_usuario", nick);
    				request.getRequestDispatcher("/WEB-INF/paginas/paginaPrincipal.jsp").forward(request, response);
    			} catch (Exception e) {
    				request.setAttribute("errorRegistrar",e);
    				Set<String> insti=Fabrica.getInstancia().getICurso().listarInstitutos();
    	    		request.setAttribute("institutos", insti);
    				request.getRequestDispatcher("/WEB-INF/paginas/paginaRegistrarUsuario.jsp").forward(request, response);
    			}
    			
    		}
    		
    	} else if (Tipo.compareTo("AltaPF") == 0) {
    		
    		String nombre = (String)request.getParameter("nombrePF");
    		String des = (String)request.getParameter("descripcionPF");
    		String url1 = (String)request.getParameter("urlimagenPF");
    		int anioi = Integer.parseInt(request.getParameter("anioi"));
    		int mesi = Integer.parseInt(request.getParameter("mesi"));
    		int diai = Integer.parseInt(request.getParameter("diai"));
    		int aniof = Integer.parseInt(request.getParameter("aniof"));
    		int mesf = Integer.parseInt(request.getParameter("mesf"));
    		int diaf = Integer.parseInt(request.getParameter("diaf"));
    		GregorianCalendar fechitai = new GregorianCalendar(anioi,mesi,diai);
    		GregorianCalendar fechitaf = new GregorianCalendar(aniof,mesf,diaf);
    		GregorianCalendar fechitah = new GregorianCalendar();
           
    		try {
    			ICurso.registrarPrograma(nombre, des, fechitai, fechitaf, fechitah, url1);
    			request.getRequestDispatcher("/WEB-INF/paginas/paginaPrincipal.jsp").forward(request, response);
    		} catch (ProgramaRepetidoExcep_Exception e) {
    			request.setAttribute("errorRegistrar",e);
    			request.getRequestDispatcher("/WEB-INF/paginas/paginaAltaProgramaDeFormacion.jsp").forward(request, response);
    		}
    		
    	} else if (Tipo.compareTo("AltaCurso") == 0) {
    		String nombreinsti = (String)request.getParameter("insti");
    		String nombre = (String)request.getParameter("nombrecurso");
    		String des = (String)request.getParameter("dess");
    		String url = (String)request.getParameter("urll");
    		int duracion = Integer.parseInt(request.getParameter("duracion"));
    		int cantHoras = Integer.parseInt(request.getParameter("cantHoras"));
    		int creditos = Integer.parseInt(request.getParameter("cred"));
    		String urlimagen = (String)request.getParameter("urlimagen");
    		String[] pre=request.getParameterValues("previas");
    		String[] cat=request.getParameterValues("categorias");
    		GregorianCalendar alta = new GregorianCalendar();
    		if (pre==null&&cat==null) {
    			Set<String> previas=new HashSet<String>();
    			Set<String> categorias=new HashSet<String>();
    			try {
    				ICurso.registrarCurso(nombreinsti, nombre, des, duracion, cantHoras, creditos, url, alta, previas, categorias, urlimagen);
    				request.getRequestDispatcher("/WEB-INF/paginas/paginaPrincipal.jsp").forward(request, response);
    			} catch (CursoRepetidoExcep_Exception et) {
    				request.setAttribute("errorRegistrar",et);
    				Set<String> prev2=ICurso.listarCursosExistente();
    				Set<String> cat2=ICurso.listarCategorias();
    				request.setAttribute("categorias", cat2);
    				request.setAttribute("previas", prev2);
    				request.getRequestDispatcher("/WEB-INF/paginas/paginaAltaDeCurso.jsp").forward(request, response);
    			}
    		} else if (pre==null) {
    			Set<String> previas=new HashSet<String>();
    			Set<String> categorias=new HashSet<String>(Arrays.asList(cat));
    			try {
    				ICurso.registrarCurso(nombreinsti, nombre, des, duracion, cantHoras, creditos, url, alta, previas, categorias, urlimagen);
    				request.getRequestDispatcher("/WEB-INF/paginas/paginaPrincipal.jsp").forward(request, response);
    			} catch (CursoRepetidoExcep_Exception et) {
    				request.setAttribute("errorRegistrar",et);
    				Set<String> prev2=ICurso.listarCursosExistente();
    				Set<String> cat2=ICurso.listarCategorias();
    				request.setAttribute("categorias", cat2);
    				request.setAttribute("previas", prev2);
    				request.getRequestDispatcher("/WEB-INF/paginas/paginaAltaDeCurso.jsp").forward(request, response);
    			}
    		} else if (cat==null) {
    			Set<String> categorias=new HashSet<String>();
    			Set<String> previas=new HashSet<String>(Arrays.asList(pre));
    			try {
    				ICurso.registrarCurso(nombreinsti, nombre, des, duracion, cantHoras, creditos, url, alta, previas, categorias, urlimagen);
    				request.getRequestDispatcher("/WEB-INF/paginas/paginaPrincipal.jsp").forward(request, response);
    			} catch (CursoRepetidoExcep_Exception et) {
    				request.setAttribute("errorRegistrar",et);
    				Set<String> prev2=ICurso.listarCursosExistente();
    				Set<String> cat2=ICurso.listarCategorias();
    				request.setAttribute("categorias", cat2);
    				request.setAttribute("previas", prev2);
    				request.getRequestDispatcher("/WEB-INF/paginas/paginaAltaDeCurso.jsp").forward(request, response);
    			}
    		}else {
    			Set<String> previas=new HashSet<String>(Arrays.asList(pre));
    			Set<String> categorias=new HashSet<String>(Arrays.asList(cat));
    			try {
    				ICurso.registrarCurso(nombreinsti, nombre, des, duracion, cantHoras, creditos, url, alta, previas, categorias, urlimagen);
    				request.getRequestDispatcher("/WEB-INF/paginas/paginaPrincipal.jsp").forward(request, response);
    			} catch (CursoRepetidoExcep_Exception et) {
    				request.setAttribute("errorRegistrar",et);
    				Set<String> prev2=ICurso.listarCursosExistente();
    				Set<String> cat2=ICurso.listarCategorias();
    				request.setAttribute("categorias", cat2);
    				request.setAttribute("previas", prev2);
    				request.getRequestDispatcher("/WEB-INF/paginas/paginaAltaDeCurso.jsp").forward(request, response);
    			}
    		}
    		
    		
    	} else if (Tipo.compareTo("AltaEdicion") == 0) {
    		String nombreinsti = (String)request.getParameter("insti");
    		String nombrecurso = (String)request.getParameter("curso");
    		String nombre = (String)request.getParameter("nombre");
    		String urlimagen = (String)request.getParameter("imagenURL");
    		String check = (String)request.getParameter("cuposcheck");
    		int anioi = Integer.parseInt(request.getParameter("anio"));
    		int mesi = Integer.parseInt(request.getParameter("mes"));
    		int diai = Integer.parseInt(request.getParameter("dia"));
    		int aniof = Integer.parseInt(request.getParameter("aniof"));
    		int mesf = Integer.parseInt(request.getParameter("mesf"));
    		int diaf = Integer.parseInt(request.getParameter("diaf"));
    		String[] doce=request.getParameterValues("docentes");
    		GregorianCalendar alta = new GregorianCalendar();
    		GregorianCalendar fechitai = new GregorianCalendar(anioi,mesi,diai);
    		GregorianCalendar fechitaf = new GregorianCalendar(aniof,mesf,diaf);
    		if (doce==null) {
    			Set<String> docentes=new HashSet<String>();
    			if (check==null) {
    				int cupos=-1;
        			try {
        			ICurso.seleccionarInstituto(nombreinsti);
        			ICurso.seleccionarCurso(nombrecurso);
        			ICurso.registrarEdicion(nombre, fechitai, fechitaf, cupos, docentes, alta, urlimagen);
        			request.getRequestDispatcher("/WEB-INF/paginas/paginaPrincipal.jsp").forward(request, response);
        			} catch (EdicionRepetidaExcep_Exception ef){
        				request.setAttribute("errorRegistrar",ef);
        				request.setAttribute("cursito", nombrecurso);
        				Set<String> docen=IUsuario.listarDocentes();
        	    		request.setAttribute("docs", docen);
        	    		request.getRequestDispatcher("/WEB-INF/paginas/paginaAltaEdicionDeCurso.jsp").forward(request, response);
        			}
    			} else {
    				int cupos = Integer.parseInt(request.getParameter("cupos"));
    				try {
            			ICurso.seleccionarInstituto(nombreinsti);
            			ICurso.seleccionarCurso(nombrecurso);
            			ICurso.registrarEdicion(nombre, fechitai, fechitaf, cupos, docentes, alta, urlimagen);
            			request.getRequestDispatcher("/WEB-INF/paginas/paginaPrincipal.jsp").forward(request, response);
            			} catch (EdicionRepetidaExcep_Exception ef){
            				request.setAttribute("errorRegistrar",ef);
            				request.setAttribute("cursito", nombrecurso);
            				Set<String> docen=IUsuario.listarDocentes();
            	    		request.setAttribute("docs", docen);
            	    		request.getRequestDispatcher("/WEB-INF/paginas/paginaAltaEdicionDeCurso.jsp").forward(request, response);
            			}
    			}
    		} else {
    			Set<String> docentes=new HashSet<String>(Arrays.asList(doce));
    			if (check==null) {
    				int cupos=-1;
        			try {
        			ICurso.seleccionarInstituto(nombreinsti);
        			ICurso.seleccionarCurso(nombrecurso);
        			ICurso.registrarEdicion(nombre, fechitai, fechitaf, cupos, docentes, alta, urlimagen);
        			request.getRequestDispatcher("/WEB-INF/paginas/paginaPrincipal.jsp").forward(request, response);
        			} catch (EdicionRepetidaExcep_Exception ef){
        				request.setAttribute("errorRegistrar",ef);
        				request.setAttribute("cursito", nombrecurso);
        				Set<String> docen=IUsuario.listarDocentes();
        	    		request.setAttribute("docs", docen);
        	    		request.getRequestDispatcher("/WEB-INF/paginas/paginaAltaDeEdicionDeCurso.jsp").forward(request, response);
        			}
    			} else {
    				int cupos = Integer.parseInt(request.getParameter("cupos"));
    				try {
            			ICurso.seleccionarInstituto(nombreinsti);
            			ICurso.seleccionarCurso(nombrecurso);
            			ICurso.registrarEdicion(nombre, fechitai, fechitaf, cupos, docentes, alta, urlimagen);
            			request.getRequestDispatcher("/WEB-INF/paginas/paginaPrincipal.jsp").forward(request, response);
            			} catch (EdicionRepetidaExcep_Exception ef){
            				request.setAttribute("errorRegistrar",ef);
            				request.setAttribute("cursito", nombrecurso);
            				Set<String> docen=IUsuario.listarDocentes();
            	    		request.setAttribute("docs", docen);
            	    		request.getRequestDispatcher("/WEB-INF/paginas/paginaAltaDeEdicionDeCurso.jsp").forward(request, response);
            			}
    			}
    			
    		}
    		
    		
    		
    	}else if(Tipo.compareTo("CambiarDatosPerfil") == 0) {
    		String nick = request.getParameter("Nick");
    		String nombre = request.getParameter("Nombre");
    		String apellido = request.getParameter("Apellido");
    		String URLimagen = request.getParameter("URLImagen");

    		String cambiarPass = request.getParameter("changePass");
    		
    		String pass = request.getParameter("Password");
    		String passConf = request.getParameter("VerificationPassword");
    		
    		
    		
    		int anio = Integer.parseInt(request.getParameter("anio"));
    		int mes = Integer.parseInt(request.getParameter("mes"));
    		int dia = Integer.parseInt(request.getParameter("dia"));
   
    
    		Fabrica.getInstancia().getIUsuario().seleccionarUsuario(nick);Fabrica.getInstancia().getIUsuario().seleccionarUsuario(nick);
    		
    		
    		
    	
    		
    		if(cambiarPass != null) {
    			if(pass.compareTo(passConf) == 0) {
    				Fabrica.getInstancia().getIUsuario().editarUsuario(nombre, apellido, new GregorianCalendar(anio,mes,dia), URLimagen, pass);
    				response.sendRedirect("Perfil?nick="+nick);
    			}else {
    				
    				response.sendRedirect("Perfil?nick="+nick);
    			}
    		}else {
    			Fabrica.getInstancia().getIUsuario().editarUsuario(nombre, apellido, new GregorianCalendar(anio,mes,dia),URLimagen);
    			
    			response.sendRedirect("Perfil?nick="+nick);
    		}

    	}else if(Tipo.compareTo("AgregarCursosAProgramas") == 0) {
    		
    		String nombrePrograma = request.getParameter("NombrePF");
    		
    		
    		String lista[] = request.getParameterValues("cursos") ;
    		
    		
    		for(String j : lista) {
    			Fabrica.getInstancia().getICurso().seleccionarPrograma(nombrePrograma);
    			Fabrica.getInstancia().getICurso().seleccionarCurso(j);
    			Fabrica.getInstancia().getICurso().aceptarAgregarCursoAPrograma();
    		}
        	response.sendRedirect("CargarDatosDeProgramaDeFormacion?NombrePF="+nombrePrograma);
    	} else if (Tipo.compareTo("suscribirPF") == 0) {
    		String nombre=(String) session.getAttribute("nick_usuario");
    		String cursito=request.getParameter("curso");
    		String flag=request.getParameter("flag");
    		ICurso.seleccionarCurso(cursito);
    		IUsuario.seleccionarEstudiante(nombre);
    		String vid=(String)request.getParameter("psw");
    		String video=vid;
    		if (vid==null||vid.isEmpty()) {
    			video="https://www.youtube.com/embed/Z2nns-WOd6M";
    		}
    		if (flag.equals("f")) {
    		try {
    			IUsuario.inscribirEstudianteACurso(video);
    			String nombreCurso = cursito;
    	    	DtCurso curso = ICurso.verDatosCurso(nombreCurso);
    	    	if(curso.getEdicionActual().compareTo("") != 0) {
    	    		DtInstancia edicionVigente = ICurso.verDatosEdicion(curso.getEdicionActual());
    	    		request.setAttribute("DatosEdicionActual", edicionVigente);
    	    		Set<DtInfo> inscripciones = ICurso.listarInscripcionesACurso(nombreCurso);
    	    		Set<String> inscripcionesPendientes = new HashSet<String>();
    	    		for(DtInfo iter: inscripciones) {
    	    			if(iter.getEdicion().equals(edicionVigente.getNombre())) {
    	    				if(iter.getEstado().equals("Inscripto")) {
    	    					inscripcionesPendientes.add(iter.getNick());
    	    				}
    	    			}
    	    		}
    	    		request.setAttribute("InscripcionesPendientes", inscripcionesPendientes);
    	    		Set<String> inscripcionesAceptadas = new HashSet<String>();
    	    		for(DtInfo iter: inscripciones) {
    	    			if(iter.getEdicion().equals(edicionVigente.getNombre())) {
    	    				if(iter.getEstado().equals("Aceptada")) {
    	    					inscripcionesAceptadas.add(iter.getNick());
    	    				}
    	    			}
    	    		}
    	    		request.setAttribute("InscripcionesAceptadas", inscripcionesAceptadas);
    	    	}
    	 
    	    	request.setAttribute("DatosCurso", curso);
    			
    			request.getRequestDispatcher("/WEB-INF/paginas/paginaDatosDeCurso.jsp").forward(request, response);
    		} catch (NoPudoInscribirseExcep_Exception e) {
    			
    			String nombreCurso = cursito;
    	    	DtCurso curso = ICurso.verDatosCurso(nombreCurso);
    	    	if(curso.getEdicionActual().compareTo("") != 0) {
    	    		DtInstancia edicionVigente = ICurso.verDatosEdicion(curso.getEdicionActual());
    	    		request.setAttribute("DatosEdicionActual", edicionVigente);
    	    		Set<DtInfo> inscripciones = ICurso.listarInscripcionesACurso(nombreCurso);
    	    		Set<String> inscripcionesPendientes = new HashSet<String>();
    	    		for(DtInfo iter: inscripciones) {
    	    			if(iter.getEdicion().equals(edicionVigente.getNombre())) {
    	    				if(iter.getEstado().equals("Inscripto")) {
    	    					inscripcionesPendientes.add(iter.getNick());
    	    				}
    	    			}
    	    		}
    	    		request.setAttribute("InscripcionesPendientes", inscripcionesPendientes);
    	    		Set<String> inscripcionesAceptadas = new HashSet<String>();
    	    		for(DtInfo iter: inscripciones) {
    	    			if(iter.getEdicion().equals(edicionVigente.getNombre())) {
    	    				if(iter.getEstado().equals("Aceptada")) {
    	    					inscripcionesAceptadas.add(iter.getNick());
    	    				}
    	    			}
    	    		}
    	    		request.setAttribute("InscripcionesAceptadas", inscripcionesAceptadas);
    	    	}
    	    	
    	    	request.setAttribute("DatosCurso", curso);
    	    	request.setAttribute("mod", e);
    	    	request.setAttribute("error", e);
    			
    			
    			request.getRequestDispatcher("/WEB-INF/paginas/paginaDatosDeCurso.jsp").forward(request, response);
    		}	
    	} else {
    		String edicion=request.getParameter("edi");
    		IUsuario.modificarInscripcionDelEstudiante(video, nombre, edicion);
    		String nombreCurso = cursito;
	    	DtCurso curso = ICurso.verDatosCurso(nombreCurso);
	    	if(curso.getEdicionActual().compareTo("") != 0) {
	    		DtInstancia edicionVigente = ICurso.verDatosEdicion(curso.getEdicionActual());
	    		request.setAttribute("DatosEdicionActual", edicionVigente);
	    		Set<DtInfo> inscripciones = ICurso.listarInscripcionesACurso(nombreCurso);
	    		Set<String> inscripcionesPendientes = new HashSet<String>();
	    		for(DtInfo iter: inscripciones) {
	    			if(iter.getEdicion().equals(edicionVigente.getNombre())) {
	    				if(iter.getEstado().equals("Inscripto")) {
	    					inscripcionesPendientes.add(iter.getNick());
	    				}
	    			}
	    		}
	    		request.setAttribute("InscripcionesPendientes", inscripcionesPendientes);
	    		Set<String> inscripcionesAceptadas = new HashSet<String>();
	    		for(DtInfo iter: inscripciones) {
	    			if(iter.getEdicion().equals(edicionVigente.getNombre())) {
	    				if(iter.getEstado().equals("Aceptada")) {
	    					inscripcionesAceptadas.add(iter.getNick());
	    				}
	    			}
	    		}
	    		request.setAttribute("InscripcionesAceptadas", inscripcionesAceptadas);
	    	}
	 
	    	request.setAttribute("DatosCurso", curso);
			
			request.getRequestDispatcher("/WEB-INF/paginas/paginaDatosDeCurso.jsp").forward(request, response);
    	
    	}
    		
    		
    	} else if (Tipo.compareTo("desistir") == 0) {
    		String nombrecurso = request.getParameter("NombreCurso");
    		String nick = (String) session.getAttribute("nick_usuario");
    		try {
    		IUsuario.desistir(nick, nombrecurso);
    		DtUsuario dtU = IUsuario.seleccionarUsuario(nick);
    		request.setAttribute("dtUsuario", dtU);
    		request.getRequestDispatcher("/WEB-INF/paginas/paginaPerfil.jsp").forward(request, response);
    		} catch(NoPudoDesinscribirseExcep_Exception et) {
    			DtUsuario dtU = IUsuario.seleccionarUsuario(nick);
        		request.setAttribute("dtUsuario", dtU);
        		request.setAttribute("error", et);
        		request.getRequestDispatcher("/WEB-INF/paginas/paginaPerfil.jsp").forward(request, response);
    		}
    		
    	} else if (Tipo.compareTo("notas") == 0) {
    		String nombreCurso=request.getParameter("aceptadas");
        	DtCurso curso = ICurso.verDatosCurso(nombreCurso);
        	Set<String> inscripcionesAceptadas = new HashSet<String>();

        	if(curso.getEdicionActual().compareTo("") != 0) {
        		DtInstancia edicionVigente = ICurso.verDatosEdicion(curso.getEdicionActual());
        		request.setAttribute("DatosEdicionActual", edicionVigente);
        		Set<DtInfo> inscripciones = ICurso.listarInscripcionesACurso(nombreCurso);
        		Set<String> inscripcionesPendientes = new HashSet<String>();
        		for(DtInfo iter: inscripciones) {
        			if(iter.getEdicion().equals(edicionVigente.getNombre())) {
        				if(iter.getEstado().equals("Inscripto")) {
        					inscripcionesPendientes.add(iter.getNick());
        				}
        			}
        		}
        		request.setAttribute("InscripcionesPendientes", inscripcionesPendientes);
        		for(DtInfo iter: inscripciones) {
        			if(iter.getEdicion().equals(edicionVigente.getNombre())) {
        				if(iter.getEstado().equals("Aceptada")) {
        					inscripcionesAceptadas.add(iter.getNick());
        				}
        			}
        		}
        		request.setAttribute("InscripcionesAceptadas", inscripcionesAceptadas);
        	}
        	request.setAttribute("DatosCurso", curso);
    	    String nombreEdicion=curso.getEdicionActual();
    		Map<String,Integer> monicaa=new HashMap<String,Integer>();
    		for (String it:inscripcionesAceptadas) {
    			monicaa.put(it,Integer.parseInt( request.getParameter(it)));
    		}
    		try {
    			ICurso.corregirExamen(nombreEdicion, monicaa);
    			DtInstancia edicionVigente = ICurso.verDatosEdicion(curso.getEdicionActual());
        		request.setAttribute("DatosEdicionActual", edicionVigente);
    			request.getRequestDispatcher("/WEB-INF/paginas/paginaDatosDeCurso.jsp").forward(request, response);
    		} catch (EstudianteSinEvaluarExcep_Exception e) {
    			request.setAttribute("error", e);
    			DtInstancia edicionVigente = ICurso.verDatosEdicion(curso.getEdicionActual());
        		request.setAttribute("DatosEdicionActual", edicionVigente);
    			request.getRequestDispatcher("/WEB-INF/paginas/paginaDatosDeCurso.jsp").forward(request, response);
    		}
    	
    	
    	
    	} else if (Tipo.compareTo("cierre") == 0) {
    		String curso=request.getParameter("cursito");
    		ICurso.cerrarEdicion(curso);
    		request.getRequestDispatcher("/WEB-INF/paginas/paginaPrincipal.jsp").forward(request, response);
    	}
    	
    	

    	
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		atenderRegistrar(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		atenderRegistrar(request, response);
	}
	

} 	
