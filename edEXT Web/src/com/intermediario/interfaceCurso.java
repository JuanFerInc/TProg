package com.intermediario;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import publicador.CategoriaRepetidaExcep_Exception;
import publicador.CursoNoExisteExcep_Exception;
import publicador.CursoRepetidoExcep_Exception;
import publicador.DtComentario;
import publicador.DtCurso;
import publicador.DtInfo;
import publicador.DtInstancia;
import publicador.EdicionNoExisteExcep_Exception;
import publicador.EdicionRepetidaExcep_Exception;
import publicador.EstadoEsFinalExcep_Exception;
import publicador.EstudianteSinEvaluarExcep_Exception;
import publicador.EvaluacionIncorrectaExcep_Exception;
import publicador.InstitutoRepetidoExcep_Exception;
import publicador.ListInteger;
import publicador.ListString;
import publicador.MapStringStringAlgo;
import publicador.NoPudoInscribirseExcep_Exception;
import publicador.NoSePudoResponderExcep_Exception;
import publicador.ProgramaRepetidoExcep_Exception;
import publicador.Publicador;
import publicador.PublicadorService;
import publicador.SetDtComentario;
import publicador.SetString;
import publicador.UsuarioNoExisteExcep_Exception;
import publicador.Val;





public class interfaceCurso {
	private PublicadorService servicio;
	private Publicador publicador;

	public interfaceCurso() {
		this.servicio = new PublicadorService();
		this.publicador = servicio.getPublicadorPort();
	}

	public XMLGregorianCalendar toXMLGregorianCalendar(Calendar c) {

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

	public Calendar fromXMLGregorianCalendar(XMLGregorianCalendar xc) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(xc.toGregorianCalendar().getTimeInMillis());
		return c;
	}

	public Set<String> listarProgramas() {
		return new HashSet<String>(publicador.listarProgramas().getSetString());
	}

	public Set<String> listarCursosExistente() {
		return new HashSet<String>(publicador.listarCursosExistente().getSetString());
	}

	public Set<String> listarInstitutos() {
		return new HashSet<String>(publicador.listarInstitutos().getSetString());
	}

	public Set<String> seleccionarPrograma(String nombrePrograma) {
		return new HashSet<String>(publicador.seleccionarPrograma(nombrePrograma).getSetString());
	}

	public Set<String> seleccionarInstituto(String nombreInstituto) {
		return new HashSet<String>(publicador.seleccionarInstituto(nombreInstituto).getSetString());
	}

	public Set<String> seleccionarCurso(String nombreCurso) {
		return new HashSet<String>(publicador.seleccionarCurso(nombreCurso).getSetString());
	}

	public DtCurso verDatosCurso(String nombreCurso) {
		return publicador.verDatosCurso(nombreCurso);
	}

	public DtInstancia verDatosEdicion(String nombreEdicicon) {
		return publicador.verDatosEdicion(nombreEdicicon);
	}

	public DtInstancia verDatosPrograma(String nombrePrograma) {
		return publicador.verDatosPrograma(nombrePrograma);
	}

	public void aceptarAgregarCursoAPrograma() {
		publicador.aceptarAgregarCursoAPrograma();
	}

	public boolean registrarCurso(String nombreInstituto, String nombreCurso, String descripcionCurso,
			int duracionCurso, int cantidadHoras, int cantidadCreditos, String URL, Calendar fechaAlta,
			Set<String> previas, Set<String> categorias, String imagen) throws CursoRepetidoExcep_Exception {

		SetString previas1 = new SetString();

		for (String iterPrevias : previas) {
			previas1.getSetString().add(iterPrevias);
		}

		SetString categorias1 = new SetString();
		for (String iterCategorias : categorias) {
			categorias1.getSetString().add(iterCategorias);
		}

		return publicador.registrarCurso(nombreInstituto, nombreCurso, descripcionCurso, duracionCurso, cantidadHoras,
				cantidadCreditos, URL, toXMLGregorianCalendar(fechaAlta), previas1, categorias1, imagen);
	}

	public boolean registrarPrograma(String nombre, String descripcion, Calendar fechaInicio, Calendar fechaFin,
			Calendar fechaAlta, String img) throws ProgramaRepetidoExcep_Exception {

		return publicador.registrarPrograma(nombre, descripcion, toXMLGregorianCalendar(fechaFin),
				toXMLGregorianCalendar(fechaFin), toXMLGregorianCalendar(fechaAlta), img);

	}

	public boolean registrarEdicion(String nombre, Calendar fechaInicioa, Calendar fechaFin, int cupos,
			Set<String> docentesParticipan, Calendar fechapublicacion, String imagen)
			throws EdicionRepetidaExcep_Exception {

		SetString docentesParticipan1 = new SetString();
		for (String iterDocentes : docentesParticipan) {
			docentesParticipan1.getSetString().add(iterDocentes);
		}

		return publicador.registrarEdicion(nombre, toXMLGregorianCalendar(fechaInicioa),
				toXMLGregorianCalendar(fechaFin), cupos, docentesParticipan1, toXMLGregorianCalendar(fechapublicacion),
				imagen);
	}

	public boolean registrarInstituto(String nombreInstituto) throws InstitutoRepetidoExcep_Exception {
		return publicador.registrarInstituto(nombreInstituto);
	}

	public void pedirInfo() {
		publicador.pedirInfo();
	}

	public boolean existeEdicionVigenteDeCurso() {
		return publicador.existeEdicionVigenteDeCurso();
	}

	public DtInstancia mostrarEdicionVigenteDeCurso() {
		return publicador.mostrarEdicionVigenteDeCurso();
	}

	public void salir() {
		publicador.salirCurso();
	}

	public boolean esPrograma(String nombrePrograma) {
		return publicador.esPrograma(nombrePrograma);
	}

	public Set<String> mostrarEdiciones() {
		return new HashSet<String>(publicador.mostrarEdiciones().getSetString());
	}

	public Set<String> listarCategorias() {
		return new HashSet<String>(publicador.listarCategorias().getSetString());
	}

	public void altaCategoria(String nombreCategoria) throws CategoriaRepetidaExcep_Exception {
		publicador.altaCategoria(nombreCategoria);
	}

	public Set<DtInfo> listarInscripcionesACurso(String nombreCurso) {
		return new HashSet<>(publicador.listarInscripcionesACurso(nombreCurso).getSetDtInfo());
	}

	public Set<DtInfo> listarInscripcionesAEdicion(String nombreEdicion) {
		return new HashSet<>(publicador.listarInscripcionesAEdicion(nombreEdicion).getSetDtInfo());
	}

	public void cambiarEstado(String estado, String persona)
			throws EstadoEsFinalExcep_Exception, NoPudoInscribirseExcep_Exception {
		publicador.cambiarEstado(estado, persona);
	}

	public Set<String> seleccionarCategoria(String nombreCategoria) {
		return new HashSet<>(publicador.seleccionarCategoria(nombreCategoria).getSetString());
	}

	public List<String> ordenarSegunAnio(Set<String> arg) throws CursoNoExisteExcep_Exception {
		SetString arg0 = new SetString();
		for (String iter : arg) {
			arg0.getSetString().add(iter);
		}
		return publicador.ordenarSegunAnio(arg0).getListString();
	}

	public List<DtInfo> ordenarSegunRanking(String nombreEdicion) throws EdicionNoExisteExcep_Exception {
		return publicador.ordenarSegunRanking(nombreEdicion).getListDtInfo();
	}

	public List<String> ordenar(Set<String> arg) {
		SetString arg0 = new SetString();
		for (String iter : arg) {
			arg0.getSetString().add(iter);
		}
		return publicador.ordenar(arg0).getListString();
	}

	public Map<String, String> buscar(String busqueda) {
		Map<String,String> res = new HashMap<String,String>();
		for(MapStringStringAlgo.Mapita.Entry iter : publicador.buscar(busqueda).getMapita().getEntry()) {
			res.put(iter.getKey(),iter.getValue());
		}
		return res;
	}

	public Set<String> inscriptosAPrograma(String nombre) {
		return new HashSet<>(publicador.inscriptosAPrograma(nombre).getSetString());
	}

	public void corregirExamen(String Edicion, Map<String, Integer> notas) throws EstudianteSinEvaluarExcep_Exception {

		List<String> key = new ArrayList<String>();
		List<Integer> value = new ArrayList<Integer>();
		
		for(Map.Entry<String, Integer> iter : notas.entrySet()) {
			key.add(iter.getKey());
			value.add(iter.getValue());
		}

		
		ListString key1 = new ListString(key);
		ListInteger value1 = new ListInteger(value);
		
		
		publicador.corregirExamen(Edicion, key1,value1);

	}

	public int verCorreccion(String edicion, String user, boolean siosi)
			throws EstudianteSinEvaluarExcep_Exception, UsuarioNoExisteExcep_Exception {
		return publicador.verCorreccion(edicion, user, siosi);
	}

	public String verVideoDeInscripcion(String Edicion, String nick) throws UsuarioNoExisteExcep_Exception {
		return publicador.verVideoDeInscripcion(Edicion, nick);
	}

	public Val puedeValorar(String nick, String curso) {
		return publicador.puedeValorar(nick, curso);
	}

	public void valorar(String nick, String curso, Integer valoracion) throws EvaluacionIncorrectaExcep_Exception {
		publicador.valorar(nick, curso, valoracion);
	}

	public double verValoracion(String curso) throws EvaluacionIncorrectaExcep_Exception {
		return publicador.verValoracion1(curso);
	}

	public double verValoracion(String curso, String nick) throws EvaluacionIncorrectaExcep_Exception {
		return publicador.verValoracion2(curso, nick);
	}

	public void comentar(String edicion, String texto, String autor)
			throws EdicionNoExisteExcep_Exception, NoSePudoResponderExcep_Exception {
		publicador.comentar1(edicion, texto, autor);
	}

	public void comentar(String edicion, String texto, String autor, Integer respondido)
			throws EdicionNoExisteExcep_Exception, NoSePudoResponderExcep_Exception {
		publicador.comentar2(edicion, texto, autor, respondido);
	}

	public void cerrarEdicion(String curso) {
		publicador.cerrarEdicion(curso);
	}

	public boolean estaCerradaLaEdicion(String nombreEdicion) {
		return publicador.estaCerradaLaEdicion(nombreEdicion);
	}

	public Set<DtComentario> verComentarios(String curso, String edicion) {
		SetDtComentario p = publicador.verComentarios(curso, edicion);
		List<DtComentario> nuevo = p.getSetDtComentario();
		Set<DtComentario> res = new HashSet<DtComentario>();
		for(DtComentario iter: nuevo) {
			res.add(iter);
		}
		return res;
	}
	public String dameNombreCurso(String nombreEdicion) {
		return publicador.dameNombreCurso(nombreEdicion);
	}
}
