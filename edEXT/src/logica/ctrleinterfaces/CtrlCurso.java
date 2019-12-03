package logica.ctrleinterfaces;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import exception.CategoriaRepetidaExcep;
import exception.CursoNoExisteExcep;
import exception.CursoRepetidoExcep;
import exception.EdicionNoExisteExcep;
import exception.EdicionRepetidaExcep;
import exception.EstadoEsFinalExcep;
import exception.EstudianteSinEvaluarExcep;
import exception.EvaluacionIncorrectaExcep;
import exception.InstitutoRepetidoExcep;
import exception.NoPudoInscribirseExcep;
import exception.NoSePudoResponderExcep;
import exception.ProgramaRepetidoExcep;
import exception.UsuarioNoExisteExcep;
import exception.UsuarioRepetidoExcep;
import logica.clases.Categoria;
import logica.clases.Curso;
import logica.clases.Docente;
import logica.clases.Edicion;
import logica.clases.Estudiante;
import logica.clases.Inscripcion;
import logica.clases.Instancia;
import logica.clases.Instituto;
import logica.clases.PC;
import logica.clases.Programa;
import logica.datatypes.DtComentario;
import logica.datatypes.DtCurso;
import logica.datatypes.DtInfo;
import logica.datatypes.DtInstancia;
import logica.datatypes.Val;

public class CtrlCurso implements interfaceCurso {
	private String nombrePrograma, nombreInstituto, nombreCurso, nombreEdicion;
	private Map<String, Curso> Cursos; // <Nombre,Curso>
	private Map<String, Instituto> Institutos;// <Nombre,Instituto>
	private Map<String, Instancia> Instancias;// <Nombre,Instacia>
	private Map<String, Categoria> Categorias; // <Nombre, Categoria>

	protected static CtrlCurso CtrlCursoInstancia = null;

	private CtrlCurso() {
		nombreCurso = null;
		nombreInstituto = null;
		nombrePrograma = null;
		nombreEdicion = null;
		Cursos = new HashMap<String, Curso>();
		Institutos = new HashMap<String, Instituto>();
		Instancias = new HashMap<String, Instancia>();
		Categorias = new HashMap<String, Categoria>();

	}

	public static CtrlCurso getInstance() {
		if (CtrlCursoInstancia == null) {
			CtrlCursoInstancia = new CtrlCurso();
		}
		return CtrlCursoInstancia;
	}

	public Instituto darInstituto(String nombreInstituto) {
		Instituto res = (Instituto) Institutos.get(nombreInstituto);
		return res;
	}

	// Devuelve un set con los nombres
	// de todos los programas que existen
	public Set<String> listarProgramas() {

		Set<String> resultadoSet = new HashSet<String>();

		for (Map.Entry<String, Instancia> iter : Instancias.entrySet()) {
			Instancia inst = iter.getValue();

			if (inst instanceof Programa) {
				resultadoSet.add(inst.getNombre());
			}

		}
		return resultadoSet;
	}

	public Set<String> listarCursosExistente() {
		Set<String> resString = new HashSet<String>();
		for (Map.Entry<String, Curso> iter : Cursos.entrySet()) {
			resString.add(iter.getValue().getNombre());

		}
		return resString;
	}

	public void pedirInfo() {
		cargarDatos cargador = new cargarDatos();
		Institutos.get(nombreInstituto);
		Instancias.get(nombreEdicion);
	}

	public Set<String> listarInstitutos() {
		Set<String> resSet = new HashSet<String>();

		for (Map.Entry<String, Instituto> iter : Institutos.entrySet()) {
			resSet.add(iter.getValue().getNombre());
		}
		return resSet;
	}

	public Set<String> seleccionarPrograma(String nombrePrograma) {
		this.nombrePrograma = nombrePrograma;

		Instancia prep = Instancias.get(nombrePrograma);

		return ((Programa) prep).getCurso();

	}

	public Set<String> seleccionarInstituto(String nombreInstituto) {
		this.nombreInstituto = nombreInstituto;

		Instituto ins = Institutos.get(nombreInstituto);
		return ins.cursosEnInstituto();
	}

	public Set<String> seleccionarCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
		Set<String> setNombreCursos = new HashSet<String>();
		for (Map.Entry<String, Curso> iter : Cursos.entrySet()) {
			setNombreCursos.add(iter.getValue().getNombre());
		}

		return setNombreCursos;
	}

	public DtCurso verDatosCurso(String nombreCurso) {
		Curso conrol = Cursos.get(nombreCurso);

		return conrol.getDtCurso();
	}

	public DtInstancia verDatosEdicion(String nombreEdicicon) {
		Instancia ese = Instancias.get(nombreEdicicon);
		Edicion edicion = (Edicion) ese;
		return edicion.darDtInstancia();
	}

	public DtInstancia verDatosPrograma(String nombrePrograma) {
		Instancia esta = Instancias.get(nombrePrograma);
		return ((Programa) esta).darDtInstancia();
	}

	public void aceptarAgregarCursoAPrograma() {
		Curso curse = Cursos.get(this.nombreCurso);
		Programa prog = (Programa) Instancias.get(this.nombrePrograma);

		prog.asociarCurso(curse);
		salir();
	}

	// retorna True sii el curso fue creado
	public boolean registrarCurso(String nombreInstituto, String nombreCurso, String descripcionCurso,
			int duracionCurso, int cantidadHoras, int cantidadCreditos, String URL, Calendar fechaAlta,
			Set<String> previas, Set<String> categorias, String imagen) throws CursoRepetidoExcep {
		boolean flag = Cursos.containsKey(nombreCurso);

		if (!flag) {
			Instituto insti = Institutos.get(nombreInstituto);
			Map<String, Curso> previasPosta = new HashMap<String, Curso>();

			for (String it : previas) {
				previasPosta.put(it, Cursos.get(it));
			}
			Map<String, Categoria> categoriasDelCurso = new HashMap<String, Categoria>();
			for (String it : categorias) {
				categoriasDelCurso.put(it, Categorias.get(it));
			}
			Curso cursillo = new Curso(nombreCurso, descripcionCurso, URL, duracionCurso, cantidadCreditos,
					cantidadHoras, fechaAlta, previasPosta, categoriasDelCurso, imagen);
			for (Map.Entry<String, Categoria> it : categoriasDelCurso.entrySet()) {
				it.getValue().addCurso(cursillo);
			}
			insti.asociarCurso(cursillo);
			Cursos.put(nombreCurso, cursillo);

			return true;
		} else {
			throw new CursoRepetidoExcep("El Curso " + nombreCurso + " ya esta en el sistema.");

		}

	}

	public boolean registrarPrograma(String nombre, String descripcion, Calendar fechaInicio, Calendar fechaFin,
			Calendar fechaAlta, String img) throws ProgramaRepetidoExcep {
		if (!Instancias.containsKey(nombre)) {
			Programa prog = new Programa(descripcion, nombre, fechaInicio, fechaFin, fechaAlta, img);
			Instancias.put(nombre, prog);
			return true;
		} else {
			throw new ProgramaRepetidoExcep("El Programa " + nombre + " ya esta en el sistema.");
		}
	}

	public boolean registrarEdicion(String nombre, Calendar fechaInicioa, Calendar fechaFin, int cupos,
			Set<String> docentesParticipan, Calendar fechapublicacion, String imagen) throws EdicionRepetidaExcep {
		Curso cece = Cursos.get(nombreCurso);
		for (Map.Entry<String, Curso> arreglo : Cursos.entrySet()) {
			if (arreglo.getValue().existeEdicion(nombre))
				throw new EdicionRepetidaExcep("Esta repetida en otro curso");
		}
		if (!cece.existeEdicion(nombre)) {
			Map<String, Docente> docentes = new HashMap<String, Docente>();
			for (String i : docentesParticipan) {
				CtrlUsuario user = CtrlUsuario.getInstance();
				Docente doc = user.darDocente(i);
				docentes.put(i, doc);
			}
			Edicion ede = new Edicion(cupos, fechapublicacion, nombre, fechaInicioa, fechaFin, docentes, imagen);
			cece.asociarmeAEdicion(ede);
			Instancias.put(ede.getNombre(), ede);

			// Criterio para decidir cual va a ser edicion vigente
			if (cece.getEdicionActual() == null && Calendar.getInstance().before(ede.getFechaFin())) {
				cece.setActual(ede);
			} else if (cece.getEdicionActual() != null && cece.getEdicionActual().getFechaInicio().after(ede.getFechaInicio())
					&& Calendar.getInstance().before(ede.getFechaFin())) {
				cece.setActual(ede);
			}
			for (Map.Entry<String, Docente> iter : docentes.entrySet()) {
				iter.getValue().integrarEdicion(ede);
			}
			return false;
		} else {
			throw new EdicionRepetidaExcep(
					"La Edicion con el nombre " + nombre + " ya esta en el sistema en el mismo curso.");
		}

	}

	public boolean registrarInstituto(String nombreInstituto) throws InstitutoRepetidoExcep {
		if (!Institutos.containsKey(nombreInstituto)) {
			Instituto isi = new Instituto(nombreInstituto);
			this.nombreInstituto = null;
			Institutos.put(nombreInstituto, isi);
			return false;
		} else {
			throw new InstitutoRepetidoExcep("El Instituto " + nombreInstituto + " ya esta en el sistema.");

		}
	}

	public Edicion pedirEdicionVigente() {
		return Cursos.get(nombreCurso).getEdicionActual();
	}

	public boolean existeEdicionVigenteDeCurso() {

		Curso curso = Cursos.get(this.nombreCurso);

		return curso.estaVigente();
	}

	public DtInstancia mostrarEdicionVigenteDeCurso() {
		Curso control = Cursos.get(this.nombreCurso);
		return control.getDtEdicionActual();
	}

	public void salir() {
		this.nombrePrograma = null;
		this.nombreInstituto = null;
		this.nombreCurso = null;
		this.nombreEdicion = null;
	}

	// esta funcion la usa solamente el controlador de usuario
	public Edicion inscribirEstudianteACurso() {
		return Cursos.get(this.nombreCurso).getEdicionActual();
	}

	protected Edicion dameEdicion(String nombreEdicion) {
		return (Edicion) Instancias.get(nombreEdicion);

	}

	public boolean esPrograma(String nombrePrograma) {
		if (Instancias.get(nombrePrograma) instanceof Programa) {
			return true;
		} else {
			return false;
		}
	}

	public Set<String> mostrarEdiciones() {
		Curso curso = Cursos.get(nombreCurso);
		return curso.getNombreEdiciones();
	}

	public void altaCategoria(String nombreCategoria) throws CategoriaRepetidaExcep {
		if (Categorias.containsKey(nombreCategoria)) {
			throw new CategoriaRepetidaExcep("La categoria ya existe: " + nombreCategoria);
		} else {
			Categoria gato = new Categoria(nombreCategoria);
			Categorias.put(nombreCategoria, gato);
		}

	}

	public Set<String> listarCategorias() {
		Set<String> retorno = new HashSet<String>();
		for (Map.Entry<String, Categoria> iter : Categorias.entrySet()) {
			Categoria inst = iter.getValue();

			retorno.add(inst.getNombre());

		}
		return retorno;
	}

	// Nuevas para los casos de uso de abajo
	public Set<DtInfo> listarInscripcionesAEdicion(String nombreEdicion) {
		Edicion miEddy = (Edicion) this.Instancias.get(nombreEdicion);
		return miEddy.listarInscriptoscnFecha();
	}

	public Set<DtInfo> listarInscripcionesACurso(String nombreCurso) {
		Edicion eddy = this.Cursos.get(nombreCurso).getEdicionActual();
		Set<DtInfo> amigoSet = eddy.listarInscriptos();
		this.nombreCurso = nombreCurso;
		return amigoSet;
	}

	public void cambiarEstado(String estado, String persona) throws EstadoEsFinalExcep, NoPudoInscribirseExcep {
		Edicion cavani = Cursos.get(nombreCurso).getEdicionActual();
		cavani.cambiameA(estado, persona);
	}

	public Map<String, Calendar> listarAceptados(String nombreEdicion) {
		Map<String, Calendar> retornito;
		Edicion eda = (Edicion) Instancias.get(nombreEdicion);// Cursos.get(nombreCurso).getEdicionNoActual(nombreEdicion);
		retornito = eda.listarAceptados();

		return retornito;
	}



	public Set<String> seleccionarCategoria(String nombreCategoria) {
		Set<String> setsito;
		Categoria katy = Categorias.get(nombreCategoria);
		setsito = katy.getMierdasDeTarea2();

		return setsito;
	}

	// Nombre - Tipo
	public Map<String, String> buscar(String busqueda) {
		Map<String, String> loquevoyaretornar = new HashMap<String, String>();
		for (Map.Entry<String, Curso> i : Cursos.entrySet()) {
			if (i.getValue().getNombre().contains(busqueda) || i.getValue().getDescripcion().contains(busqueda)) {
				loquevoyaretornar.put(i.getValue().getNombre(), "Curso");
			}
		}
		for (Map.Entry<String, Instancia> i : Instancias.entrySet()) {
			if (i.getValue() instanceof Programa && (i.getValue().getNombre().contains(busqueda) || ((Programa) i.getValue()).getDescripcion().contains(busqueda)))
				loquevoyaretornar.put(i.getValue().getNombre(), "Programa");
		}
		return loquevoyaretornar;
	}

	public List<String> ordenar(Set<String> arg) {
		int nnn = arg.size();
		List<String> aList = new ArrayList<String>(nnn);
		for (String x : arg)
			aList.add(x);
		Collections.sort(aList);
		return aList;
	}

	public List<DtInfo> ordenarSegunRanking(String nombreEdicion) throws EdicionNoExisteExcep {
		if (!Instancias.containsKey(nombreEdicion))
			throw new EdicionNoExisteExcep("El nombre de edicion no existe");
		Edicion edicioncita = (Edicion) Instancias.get(nombreEdicion);
		List<Inscripcion> temp = edicioncita.getList();

		List<DtInfo> aList = new ArrayList<DtInfo>(temp.size());
		for (Inscripcion i : temp) {
			DtInfo agregado = new DtInfo(i.getUserInscripto().getNick(), nombreEdicion, i.getEstado(),
					i.getPrioridad());
			aList.add(agregado);
		}
		aList.sort(Comparator.comparing(DtInfo::getPrio).reversed());

		return aList;
	}

	public List<String> ordenarSegunAnio(Set<String> arg) throws CursoNoExisteExcep {
		for (String a : arg) {
			boolean flag1, flag2;
			flag1 = (!Instancias.containsKey(a) || Instancias.get(a) instanceof Edicion);
			flag2 = !Cursos.containsKey(a);
			if (!flag1 && !flag2)
				throw new CursoNoExisteExcep("El curso/programa con el nombre " + a + " no existe");
		}
		int isi = 0, ene = arg.size();
		List<PC> listita = new ArrayList<PC>(ene);
		listita.sort(Comparator.comparing(PC::getFecha));
		List<String> aList = new ArrayList<String>(ene);
		while (isi < ene) {
			aList.add(listita.get(isi).getNombre());
			isi++;
		}

		return aList;

	}
	public Set<String> inscriptosAPrograma(String nombre){
		Programa prog = (Programa) Instancias.get(nombre);
		return prog.darInscriptos();
	}
	public void inscribirEstudianteAPrograma(Estudiante est, String nombre) throws UsuarioRepetidoExcep{
		Programa prog = (Programa) Instancias.get(nombre);
		Inscripcion isi = prog.agregarEstudiante(est);
		
		
		est.ponerEnPrograma(isi);
	}
	public void corregirExamen(String edicion, Map<String,Integer> notas) throws EstudianteSinEvaluarExcep {
		Edicion eddy = (Edicion) Instancias.get(edicion);
		if(eddy.estaCerrado())
			throw new EstudianteSinEvaluarExcep("Edicion cerrada, no se logro evaluar");
		eddy.evaluar(notas);
		
	}
	public void cerrarEdicion(String curso) {
		Curso eddy = (Curso) Cursos.get(curso);
		eddy.cerrar();
	}
	
	public int verCorreccion(String edicion, String user, boolean siosi) throws UsuarioNoExisteExcep{
		Edicion edy = (Edicion) Instancias.get(edicion);
		return edy.getNota(user,siosi);
	}
	public String verVideoDeInscripcion(String edicion, String nick) throws UsuarioNoExisteExcep {
		Edicion edy = (Edicion) Instancias.get(edicion);
		return edy.getVideo(nick);
	}
	
	public Val puedeValorar(String nick, String curso) {
		Curso cursillo = Cursos.get(curso);
		return cursillo.puedeValorar(nick);
	}
	public void valorar(String nick, String curso, Integer valoracion) throws EvaluacionIncorrectaExcep {
		Curso cursillo = Cursos.get(curso);
		cursillo.valorar(valoracion, nick);
	}
	public double verValoracion(String curso) throws EvaluacionIncorrectaExcep {
		Curso cursillo = Cursos.get(curso);
		return cursillo.verValoracionGlobal();
	}
	public double verValoracion(String curso, String nick) throws EvaluacionIncorrectaExcep {
		Curso cursillo = Cursos.get(curso);
		return cursillo.verValoracion(nick);
	}
	public void comentar(String edicion, String texto, String autor) throws NoSePudoResponderExcep {
		Edicion edy = (Edicion) Instancias.get(edicion);
		edy.comentar(texto, autor);
	}
	public void comentar(String edicion, String texto, String autor, Integer respondido) throws NoSePudoResponderExcep {
		Edicion edy = (Edicion) Instancias.get(edicion);
		edy.comentar(texto, autor,respondido);

	}

	public Set<DtComentario> verComentarios(String curso, String edicion){
		Curso cursillo = Cursos.get(curso);
		Edicion edicioncilla = (Edicion) Instancias.get(edicion);
		return edicioncilla.getPrimerNivel(cursillo);
	}
	public boolean estaCerradaLaEdicion(String edicion) {
		Edicion eddy = (Edicion) Instancias.get(edicion);
		return eddy.estaCerrado();
	}
	
	public String dameNombreCurso(String nombreEdicion) {
		for(Map.Entry<String, Curso> iter: Cursos.entrySet()) {
			if(iter.getValue().tengoEdicion(nombreEdicion)) {
				return iter.getKey();
			}
		}
		return null;
	}

}
