package com.intermediario;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import publicador.DtEstudianteIn;
import publicador.DtUsuario;
import publicador.Exception_Exception;
import publicador.LoginIncorrectoExcep_Exception;
import publicador.MapCalendarStringAlgo;
import publicador.NoPudoDesinscribirseExcep_Exception;
import publicador.NoPudoInscribirseExcep_Exception;
import publicador.Publicador;
import publicador.PublicadorService;
import publicador.TipoError;
import publicador.TipoUsuario;
import publicador.UsuarioNoExisteExcep_Exception;
import publicador.UsuarioRepetidoExcep_Exception;



public class interfaceUsuario {
	private PublicadorService servicio;
	private Publicador publicador;
	
	public interfaceUsuario() {
		this.servicio = new PublicadorService();
		this.publicador = servicio.getPublicadorPort();
	}

	public static XMLGregorianCalendar toXMLGregorianCalendar(Calendar c) {

		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(c.getTimeInMillis());
		XMLGregorianCalendar xc;
		try {
			xc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
			return xc;
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
			return null;
		}

	}
	public static Map<String, Map<Calendar, String>> toMapStringMapCalendarString(DtEstudianteIn.MapEdiciones mapita){
		Map<String, Map<Calendar,String> >mapaGrande = new HashMap<String,Map<Calendar,String>>();
		for(DtEstudianteIn.MapEdiciones.Entry iter : mapita.getEntry()) {
			
			String nombreEdicion = iter.getKey();
			MapCalendarStringAlgo cosita = iter.getValue();
			Map<Calendar,String> mapaChico = new HashMap<Calendar,String>();
			for(MapCalendarStringAlgo.Mapita.Entry iter2 : cosita.getMapita().getEntry()) {
				mapaChico.put(fromXMLGregorianCalendar(iter2.getKey()), iter2.getValue());
			}
			
			mapaGrande.put(nombreEdicion,mapaChico);
		}
		
		return mapaGrande;
		
	}
	
	public static Calendar fromXMLGregorianCalendar(XMLGregorianCalendar xc) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(xc.toGregorianCalendar().getTimeInMillis());
		return c;
	}

	public Set<String> listarUsuarios() {
		return new HashSet<String>(publicador.listarUsuarios().getSetString());
	}

	public DtUsuario verDatosUsuario(String nombreUsuario) {
		return publicador.verDatosUsuario(nombreUsuario);

	}

	public Set<String> listarEstudiantes() {
		return new HashSet<String>(publicador.listarEstudiantes().getSetString());
	}

	public void seleccionarEstudiante(String nickEstudiante) {
		publicador.seleccionarEstudiante(nickEstudiante);
	}

	public DtUsuario seleccionarUsuario(String nickUsuario) {
		return publicador.seleccionarUsuario(nickUsuario);
	}

	public TipoError registrarUser(String nickname, String nombre, String apellido, Calendar fechaNacimiento,
			String mail, TipoUsuario tipo, String nombreInstituto, String password, String confirmacion, String imagen)
			throws Exception_Exception {
		return publicador.registrarUser(nickname, nombre, apellido, toXMLGregorianCalendar(fechaNacimiento), mail, tipo,
				nombreInstituto, password, confirmacion, imagen);

	}

	public boolean inscribirEstudianteACurso(String video) throws NoPudoInscribirseExcep_Exception {
		return publicador.inscribirEstudianteACurso1(video);
	}

	public boolean inscribirEstudianteACurso(Calendar fechita, String video) throws NoPudoInscribirseExcep_Exception {
		return publicador.inscribirEstudianteACurso2(toXMLGregorianCalendar(fechita), video);

	}

	public void editarUsuario(String nombre, String apellido, Calendar fecha) {
		publicador.editarUsuario1(nombre, apellido, toXMLGregorianCalendar(fecha));
	}

	public void editarUsuario(String nombre, String apellido, Calendar fecha, String img) {
		publicador.editarUsuario2(nombre, apellido, toXMLGregorianCalendar(fecha), img);

	}

	public void editarUsuario(String nombre, String apellido, Calendar fecha, String img, String Password) {
		publicador.editarUsuario3(nombre, apellido, toXMLGregorianCalendar(fecha), img, Password);
	}

	public void salir() {
		publicador.salirUsuario();
	}

	public String fechaDecente(Calendar cal) {
		return publicador.fechaDecente(toXMLGregorianCalendar(cal));
	}


	public Set<String> listarDocentes(){
		return new HashSet<String>(publicador.listarDocentes().getSetString());
	}

	// funciones que faltan para la WEB
	public void generarSeguimiento(String objetivo, String origen) throws UsuarioNoExisteExcep_Exception {
			publicador.generarSeguimiento(objetivo, origen);
	}

	public void eliminarSeguimiento(String objetivo, String origen) throws UsuarioNoExisteExcep_Exception {
		publicador.eliminarSeguimiento(objetivo, origen);
	}

	public String iniciarSesion(String nick, String password) throws LoginIncorrectoExcep_Exception {
		return publicador.iniciarSesion(nick, password);
	}

	public boolean estaAceptado(String nick, String edicion) {
		return publicador.estaAceptado(nick, edicion);
	}

	public void InscribirUsuarioAProgramaDeFormacion(String nick, String programa) throws UsuarioRepetidoExcep_Exception {
		publicador.inscribirUsuarioAProgramaDeFormacion(nick, programa);
	}

	public void desistir(String nick, String edicion) throws NoPudoDesinscribirseExcep_Exception {
		publicador.desistir(nick, edicion);
	}
	public void modificarInscripcionDelEstudiante(String video, String usuario, String edicion) {
		publicador.modificarInscripcionDelEstudiante(video, usuario, edicion);
	}
	
}
