package logica.ctrleinterfaces;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import exception.CategoriaRepetidaExcep;
import exception.CursoRepetidoExcep;
import exception.EdicionRepetidaExcep;
import exception.EstadoEsFinalExcep;
import exception.EstudianteSinEvaluarExcep;
import exception.InstitutoRepetidoExcep;
import exception.NoPudoInscribirseExcep;
import exception.NoSePudoResponderExcep;
import exception.ProgramaRepetidoExcep;
import exception.UsuarioNoExisteExcep;
import exception.UsuarioRepetidoExcep;
import logica.clases.Edicion;
import logica.clases.Estudiante;
import logica.datatypes.TipoUsuario;


public class cargarDatos {
public void cargarComentario(String nombreEdicion, String nickUsuario, String comentario) {
		CtrlCurso controladorCurso = CtrlCurso.getInstance();
		try {
		controladorCurso.comentar(nombreEdicion, comentario ,nickUsuario);
		} catch (NoSePudoResponderExcep e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	public void cargarComentario(String nombreEdicion, String nickUsuario, String comentario, int respuesta) {
		CtrlCurso controladorCurso = CtrlCurso.getInstance();
		try {
		controladorCurso.comentar(nombreEdicion, comentario ,nickUsuario, respuesta);
		} catch (NoSePudoResponderExcep e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public void cargarEdicion(String nombreCurso, String nombreEdicion, Calendar fechaInicioa, Calendar fechaFin, int cupos, Set<String> docentesParticipan, Calendar fechapublicacion,String imagen){
		CtrlCurso controladorCurso = CtrlCurso.getInstance();
		controladorCurso.seleccionarCurso(nombreCurso);
		System.out.println(nombreCurso);
		try {
			controladorCurso.registrarEdicion(nombreEdicion, fechaInicioa, fechaFin, cupos, docentesParticipan, fechapublicacion,imagen);
		}catch (EdicionRepetidaExcep e) {
		
		}

	}
	public Edicion  cargarInscripcion(Calendar fechaInscripcion, String nombreCurso, String nickEstudiante, String nombreEdicion, String video) {
		CtrlUsuario controladorUsuario = CtrlUsuario.getInstance();
		CtrlCurso controladorCurso = CtrlCurso.getInstance();
		Estudiante estudiante = controladorUsuario.dameEstudiante(nickEstudiante);
		Edicion edicion = controladorCurso.dameEdicion(nombreEdicion);
	
		try {
			System.out.println(nombreEdicion);
			estudiante.inscribirA(edicion, fechaInscripcion,video);
		} catch (NoPudoInscribirseExcep e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return edicion;
		}
	
	public void ingresarCursoAPrograma(String nombrePrograma, String nombreCurso) {
		CtrlCurso controladorCurso = CtrlCurso.getInstance();
		controladorCurso.seleccionarPrograma(nombrePrograma);
		controladorCurso.seleccionarCurso(nombreCurso);
		controladorCurso.aceptarAgregarCursoAPrograma();
	}
	
	public cargarDatos() {
		try {
	CtrlCurso controladorCurso = CtrlCurso.getInstance();
	CtrlUsuario controladorUsuario = CtrlUsuario.getInstance();
		
	//Cargado de Institutos
	try {
	
		controladorCurso.registrarInstituto("INCO");
		controladorCurso.registrarInstituto("IMERL");
		controladorCurso.registrarInstituto("Fisica");
		controladorCurso.registrarInstituto("IMPII");
		controladorCurso.registrarInstituto("Electrica");
		controladorCurso.registrarInstituto("DISI");
	}catch(InstitutoRepetidoExcep e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	
	//Cargado de categorias
		try {
		
			controladorCurso.altaCategoria("Social");
			controladorCurso.altaCategoria("Industrial");
			controladorCurso.altaCategoria("Educativo");
			controladorCurso.altaCategoria("Interdisciplinario");
			
		}catch(CategoriaRepetidaExcep e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	
	//Cargado de Cursos
	Set<String> previas = new HashSet<String>();
	Set<String> sinPrevias = new HashSet<String>();
	Set<String> categorias = new HashSet<String>();
	categorias.add("Social");
	String ahora = "Talleres plenarios";
	previas.add(ahora);
	try {
		controladorCurso.registrarCurso("IMERL", "Talleres plenarios", "*Talleres  plenarios*:  presentados por cuatro reconocidos matematicos uruguayos, plantearan diversos topicos  de matematica en el marco de  los cuales se realizaran actividades fomentando  la integracion entre estudiantes, docentes e investigadores", 3, 15, 1, "www.tmu.edu.uy", new GregorianCalendar(2019,2,1), sinPrevias, categorias, "http://bit.ly/2kPof8A");
		previas.add("Talleres plenarios");
		controladorCurso.registrarCurso("IMERL", "Seminarios de Resolucion de Problemas", "Seminario, *todos los jueves* en Facultad de Ingenieria a partir del jueves 25 de julio en las areas en que se desarollan los problemas de las olimpiadas de matematicas", 5, 30, 2, "www.tmu.edu.uy", new GregorianCalendar(2019,7,12), previas, categorias, "http://bit.ly/2mnDYwd");
		categorias.add("Social");
		controladorCurso.registrarCurso("IMPII", "Dalavuelta", "Dalavuelta es un proyecto de extension que nace en el instituto de ingenieria mecanica y produccion industrial (IMPI) de la Fing que, si bien inicia su trabajo en el desarollo de bicicletas accesibles para personas en situacion de discapacidad motriz a partir de bicicletas abandonadas, se propuso diseñar otras herramientas para fomentar la accesibilidad", 10, 60, 4, "https://eva.fing.edu.uy/course/view.php?id=783#section-2", new GregorianCalendar(2017,6,25), previas, categorias, "http://bit.ly/2lRnEU1");
		categorias.clear();
		categorias.add("Industrial");
		controladorCurso.registrarCurso("IMPII", "Extensionismo Industrial", "El proyecto contiene como objetivo desarollar intervenciones curriculares en pequeños emprendimientos productivos de diferentes sectores de la industria nacional. Las metodologias de trabajo permiten articular diversas interciones combinando actividades de enseñanza, extension e integracion por parte de los docentes del IMPII", 12, 75, 5, "https://eva.fing.edu.uy/course/view.php?id=783#section-2", new GregorianCalendar(2018,6,16), previas, categorias, "http://bit.ly/2mngdEx");
		controladorCurso.registrarCurso("IMPII", "Inclusion Energetica", "En el proyecto se conjuga el trabajo de docentes y estudiantes de la carrera Ingenieria Industrial Mecanica a traves del modulo de extension en donde se trabaja ne el diseño, construccion y prueba de un prototipo de colector solar adquiriendo conocimientos relevantes para luego poder replicarlos junto a las familias en los talleres. Las premisas fundamentales a la hora de pensar los diseños son: por un lado el bajo costo de los materiales y por el otro la facil construccion de forma de poder construirlos ellos mismos.", 6, 45, 3, "https://eva.fing.edu.uy/course/view.php?id=783#section-2", new GregorianCalendar(2019,2,1), sinPrevias, categorias, "http://bit.ly/2kPGN8K");
		categorias.clear();
		categorias.add("Educativo");
		categorias.add("Interdisciplinario");
		controladorCurso.registrarCurso("DISI", "Flor del Ceibo", "Flor de Ceibo es un proyecto central de la Universidad que tiene como mision movilizar la participacion de estudiantes universitarios en diversas tareas vinculadas con la puesta en funcionamiento del plan ceibal en el territorio nacional", 15, 150, 10, "http://www.flordeceibo.edu.uy/", new GregorianCalendar(2008,7,27), sinPrevias, categorias, "http://bit.ly/2mmRXCk");
		categorias.clear();
		categorias.add("Educativo");
		categorias.add("Social");
		controladorCurso.registrarCurso("INCO", "Taller de robotica educativa", "La asignatura se organiza en dos etapas. La primera etapa se dicta a traves de clases teoricopracticas donde seespera ademas que cada estudiante dedique horas de estudio. La segunda etapa consiste en que los estudiantes trabajen en grupo sobre el diseño e implementacion de una experiencia didactica de inclusion del robot butia en el aula , utilizando los conocimientos aprendidos en clase.", 8, 90, 6, "https://eva.fing.edu.uy/course/view.php?id=1187", new GregorianCalendar(2017,2,2), sinPrevias, categorias, "http://bit.ly/2m1cR9J");
		categorias.clear();
		categorias.add("Educativo");
		controladorCurso.registrarCurso("INCO", "Participacion en investigacion sobre el empleo del juego Komikan como recurso didactico en la Escuela", "Se propone desarollar una aplicacion interactiva para tablet Andoid basada en el juego de tablero Komikan (version web del juego), que incluya los distintos aspectos concernientes al juego asi como a situaciones especificas particulares", 9, 45, 3, "https://eva.fing.edu.uy/mod/folder/view.php?id=89398", new GregorianCalendar(2019,6,15), sinPrevias, categorias, "--");
		categorias.add("Social");
		controladorCurso.registrarCurso("INCO", "Herramientas de apoyo a la enseñanza de ingles. Instalacion y evaluacion", "Se realizaran visitas a escuelas rurales participantes en un proyecto conjunto del gruo PLN y el programa de politica linguisticas de ANEP, en el marco del cual se desarollaron diferentes herramientos para uso de maestros que enseñan ingles con apoyo remoto de profsores especializados desde montevideo", 12, 60, 4, "https://eva.fing.edu.uy/mod/folder/view.php?id=89398", new GregorianCalendar(2019,5,24), sinPrevias, categorias, "--");
		categorias.clear();
		categorias.add("Industrial");
		categorias.add("Educativo");
		controladorCurso.registrarCurso("Electrica", "MicroBit", "El centro ceibal se encuentra distribuyendo placas microbit para que estudiantes de primaria y secundaria aprendan nociones basicas de robotica, electronica y programacion de forma autonoma y ludica. Estas placas se basan e un microcontrolador y cuentan con leds, botones, acelerometro, brujula, bluetooth y otros sensores. Ademas las placas se programan facilmente con lenguaje tipo scratch y python, por lo que son muy utiles para un primer acercamiento a la tematica", 15, 105, 7, "https://www.fing.edu.uy/noticias/extension/modulo-de-tallerextension-microbit", new GregorianCalendar(2019,3,13), sinPrevias, categorias, "http://bit.ly/2kOZ6ec");
	}catch(CursoRepetidoExcep e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	//Cargado de Usuarios
	try {
		
		
		
	controladorUsuario.registrarUser("eleven11", "Eleven", "", new GregorianCalendar(1971,12,31) ,"eleven11@gmail.com", TipoUsuario.ESTUDIANTE, "","LzrZzge5","LzrZzge5", "http:// bit.ly/11Eleven11");
	controladorUsuario.registrarUser("costas", "Gerardo", "Costas",new GregorianCalendar(1983,11,15) ,"gcostas@gmail.com",TipoUsuario.ESTUDIANTE, "","nQ57u5az","nQ57u5az","http://bit.ly/1yTfPav" );
	controladorUsuario.registrarUser("roro", "Rodrigo", "Cotelo" , new GregorianCalendar(1975,8,2),"rcotelo@yahoo.com",TipoUsuario.ESTUDIANTE, "" ,"Xci95w9i","Xci95w9i","http://bit.ly/Xwsg0F");
	controladorUsuario.registrarUser("chechi", "Cecilia", "Garrido",new GregorianCalendar(1987,-9,12), "cgarrido@hotmail.com",TipoUsuario.ESTUDIANTE, "","RqF7U579","RqF7U579","http://bit.ly/2o5uwic");
	controladorUsuario.registrarUser("jeffw", "Jeff", "Williams",new GregorianCalendar(1964,11,27), "jwilliams@gmail.com", TipoUsuario.ESTUDIANTE, "","CQQ8MqpJ","CQQ8MqpJ","--" );
	controladorUsuario.registrarUser("weiss", "Adrian", "Weiss",new GregorianCalendar(1978,12,23), "aweiss@hotmail.com", TipoUsuario.ESTUDIANTE, "","CN3zuf8Y","CN3zuf8Y","http://bit.ly/2kMGyLP");
	controladorUsuario.registrarUser("Juanse", "Juan", "Segura", new GregorianCalendar(1992,5,21), "juanse92@gmail.com", TipoUsuario.ESTUDIANTE, "", "qwer456", "qwer456", "--");
	controladorUsuario.registrarUser("Anab", "Ana", "Belen", new GregorianCalendar(1970,4,7), "ana_belen@lapuerta.es", TipoUsuario.ESTUDIANTE, "", "awsedrf678", "awsedrf678", "--");
	controladorUsuario.registrarUser("Steveh", "Steve", "Harris", new GregorianCalendar(70, 3, 1), "steve@iron.com", TipoUsuario.ESTUDIANTE,"", "ZxCv123", "ZxCv123", "https://bit.ly/32zinQG");
	controladorUsuario.registrarUser("nadiav", "Nadia", "Vulkokov", new GregorianCalendar(1985,5,24), "vulkokov01@yahoo.es", TipoUsuario.ESTUDIANTE, "", "098okjH", "098okjH", "https://bit.ly/32yAupV");
	controladorUsuario.registrarUser("Keating", "Annalise", "Keating", new GregorianCalendar(1992,5,12), "annalise43@hotmail.com", TipoUsuario.ESTUDIANTE, "", "099ftgyh", "099ftgyh", "https://bit.ly/2X1pe45");
	controladorUsuario.registrarUser("saul", "Saul", "Goodman", new GregorianCalendar(1995,1,6), "goodman@hotmail.com", TipoUsuario.ESTUDIANTE, "", "VbN567", "VbN567", "https://bit.ly/33zo0zF");
	controladorUsuario.registrarUser("Sallyo", "Sally", "Owens", new GregorianCalendar(1994,4,25), "sallyo33@elcaldero.com", TipoUsuario.ESTUDIANTE, "", "kjh45XC", "kjh45XC", "https://bzfd.it/2X24XeS");
	controladorUsuario.registrarUser("Otism", "Otis", "Milburn", new GregorianCalendar(1995,6,21), "otism95@gmail.com", TipoUsuario.ESTUDIANTE, "", "sexEd101", "sexEd101", "https://bit.ly/36TRKsX");	
	controladorUsuario.registrarUser("heisenberg", "Walter", "White",new GregorianCalendar(1956,3,7), "heisenberg@gmail.com", TipoUsuario.DOCENTE, "INCO","zDUTwJD7","zDUTwJD7","http://bit.ly/2kR3Csv");
	controladorUsuario.registrarUser("benkenobi", "Obi-Wan", "Kenobi", new GregorianCalendar(1914,4,2), "benKenobi@gmail.com",TipoUsuario.DOCENTE, "INCO","5aM8CGch","5aM8CGch","http://bit.ly/2lU9e5y");
	controladorUsuario.registrarUser("waston", "Emma", "Watson",new GregorianCalendar(1990,4,15) , "e.watson@gmail.com",TipoUsuario.DOCENTE, "INCO","ahtL8FzL","ahtL8FzL","http://bit.ly/2kEQI0Y");
	controladorUsuario.registrarUser("house", "Gregory", "House", new GregorianCalendar(1959,5,15), "greghouse@gmail.com", TipoUsuario.DOCENTE, "Electrica","XTMWJ8iT","XTMWJ8iT","http://bit.ly/2lTUCDg");
	controladorUsuario.registrarUser("timmy", "Tim", "Cook",new GregorianCalendar(1960,11,1),"tim.cook@apple.com", TipoUsuario.DOCENTE, "IMERL" ,"6McCUA9g","6McCUA9g","http://bit.ly/2kRed6K");
	controladorUsuario.registrarUser("danny", "Daniel", "Riccio",new GregorianCalendar(1963,7,5), "dan.riccio@gmail.com", TipoUsuario.DOCENTE, "IMERL","4WgRR6nL","4WgRR6nL","http://bit.ly/2kRnpYR");
	controladorUsuario.registrarUser("phils","Philip", "Schiller", new GregorianCalendar(1961,10,7), "schiller@gmail.com", TipoUsuario.DOCENTE, "IMPII","4KJeAikG","4KJeAikG","http://bit.ly/2kQ4Cxc");
	controladorUsuario.registrarUser("bruces", "Bruce", "Sewell ", new GregorianCalendar(1959,12,3), "sewell@gmail.com", TipoUsuario.DOCENTE, "DISI","7KTCP7YL","7KTCP7YL","http://bit.ly/2mjQAEl");
	controladorUsuario.registrarUser("adri", "Adriana", "Garcia", new GregorianCalendar(1978,7,28), "agarcia@gmail.com", TipoUsuario.DOCENTE, "DISI","EB6Vq6Dj","EB6Vq6Dj","--" );
	
	
	//controladorUsuario.registrarUser("docente", "DocenteNombre", "DocenteApellido", new GregorianCalendar(6,6,6) ,"docente@gmail.com", TipoUsuario.DOCENTE, "DISI","docente","docente", "--");
	//controladorUsuario.registrarUser("estudiante", "EstudianteNombre", "EstudianteApellido", new GregorianCalendar(2,2,2) ,"estudiante@gmail.com", TipoUsuario.ESTUDIANTE, "","estudiante","estudiante", "--");
	
	}catch(Exception e ) {
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	
	//Cargado de Ediciones
	
	Set<String> docentesParticipan = new HashSet<String>();
	
	docentesParticipan.add("bruces");
	this.cargarEdicion("Flor del Ceibo", "Flor del Ceibo - 2010", new GregorianCalendar(2010,3,15), new GregorianCalendar(2010,7,7), -1, docentesParticipan, new GregorianCalendar(2010,2,16),"http://bit.ly/2kS4JID");
	docentesParticipan.clear();
	docentesParticipan.add("bruces");
	docentesParticipan.add("adri");
	this.cargarEdicion("Flor del Ceibo","Flor del Ceibo - 2012", new GregorianCalendar(2012,8,1), new GregorianCalendar(2012,11,20), -1, docentesParticipan, new GregorianCalendar(2012,7,10),"http://bit.ly/2kqYgEm");
	this.cargarEdicion("Flor del Ceibo", "Flor del Ceibo - 2018", new GregorianCalendar(2018,4,10), new GregorianCalendar(2018,8,7), -1, docentesParticipan, new GregorianCalendar(2018,3,6),"http://bit.ly/2lSYzrY");
	docentesParticipan.clear();
	docentesParticipan.add("phils");
	this.cargarEdicion("Dalavuelta", "Dalavuelta - 2018", new GregorianCalendar(2017,8,20), new GregorianCalendar(2017,11,10), 5, docentesParticipan, new GregorianCalendar(2017,7,20),"http://bit.ly/2lSzxcu");
	this.cargarEdicion("Extensionismo Industrial", "Extensionismo Industrial - 2018", new GregorianCalendar(2018,8,10), new GregorianCalendar(2018,11,10), 5, docentesParticipan, new GregorianCalendar(2018,7,8),"--");
	this.cargarEdicion("Inclusion Energetica", "Inclusion Energetica - 2019", new GregorianCalendar(2019,3,15), new GregorianCalendar(2019,4,30), 5, docentesParticipan, new GregorianCalendar(2019,2,20),"http://bit.ly/2lTiqqY");
	docentesParticipan.clear();
	docentesParticipan.add("heisenberg");
	this.cargarEdicion("Taller de robotica educativa" , "Taller de robotica educativa - 2017", new GregorianCalendar(2017,3,10), new GregorianCalendar(2017,5,10), 5, docentesParticipan, new GregorianCalendar(2017,2,15),"http://bit.ly/2kFn9fI");
	docentesParticipan.add("benkenobi");
	this.cargarEdicion("Taller de robotica educativa",  "Taller de robotica educativa - 2019", new GregorianCalendar(2019,3,10), new GregorianCalendar(2019,5,10), 5, docentesParticipan, new GregorianCalendar(2019,2,15),"http://bit.ly/2kOYlln");
	docentesParticipan.clear();
	docentesParticipan.add("benkenobi");
	docentesParticipan.add("waston");
	this.cargarEdicion("Taller de robotica educativa","Taller de robotica educativa - 2019-2", new GregorianCalendar(2019,9,10), new GregorianCalendar(2019,11,8), 5, docentesParticipan, new GregorianCalendar(2019,8,15),"http://bit.ly/2kOYpS9");
	docentesParticipan.clear();
	docentesParticipan.add("waston");
	this.cargarEdicion("Participacion en investigacion sobre el empleo del juego Komikan como recurso didactico en la Escuela", "Participacion en investigacion sobre el empleo del juego Komikan como recurso didactico en la Escuela - 2019", new GregorianCalendar(2019,7,29), new GregorianCalendar(2019,10,7), 5, docentesParticipan, new GregorianCalendar(2019,7,10),"--");
	docentesParticipan.clear();
	docentesParticipan.add("heisenberg");
	this.cargarEdicion("Herramientas de apoyo a la enseñanza de ingles. Instalacion y evaluacion", "Herramientas de apoyo a la enseñanza de ingles. Instalacion y evaluacion - 2019", new GregorianCalendar(2019,9,15), new GregorianCalendar(2019,12,15), 5, docentesParticipan, new GregorianCalendar(2019,6,2),"--");
	docentesParticipan.clear();
	docentesParticipan.add("house");
	this.cargarEdicion("MicroBit",  "MicroBit - 2019" , new GregorianCalendar(2019,8,12), new GregorianCalendar(2019,12,5), 5, docentesParticipan, new GregorianCalendar(2019,7,2),"http://bit.ly/2ki18mK");
	docentesParticipan.clear();
	docentesParticipan.add("timmy");
	docentesParticipan.add("danny");
	this.cargarEdicion("Talleres plenarios", "Talleres plenarios - 2019", new GregorianCalendar(2019,3,10), new GregorianCalendar(2019,3,30), -1, docentesParticipan, new GregorianCalendar(2019,3,2),"http://bit.ly/2ki1oSK");
	docentesParticipan.clear();
	docentesParticipan.add("timmy");
	this.cargarEdicion("Seminarios de Resolucion de Problemas", "Seminarios de Resolucion de Problemas - 2019", new GregorianCalendar(2019,9,10), new GregorianCalendar(2019,10,20), -1, docentesParticipan, new GregorianCalendar(2019,7,12),"http://bit.ly/2kF5zIN");
	
	
	//Cargado de Inscripciones
	Edicion edicion;
	Map<String,Integer> notas = new HashMap<String,Integer>();
	try {
	edicion = this.cargarInscripcion(new GregorianCalendar(2010,2,20), "Flor del Ceibo", "eleven11","Flor del Ceibo - 2010","https://youtu.be/fryZlu3DUPo");
	edicion.cambiameA("Aceptada", "eleven11");
	edicion = this.cargarInscripcion(new GregorianCalendar(2010,2,25), "Flor del Ceibo", "chechi","Flor del Ceibo - 2010","https://youtu.be/b89CnP0Iq30");
	edicion.cambiameA("Aceptada", "chechi");
	notas.put("eleven11", 6);
	notas.put("chechi", 8);
	edicion.evaluar(notas);
	edicion.cerrar();
	notas.clear();
	
	
	edicion = this.cargarInscripcion(new GregorianCalendar(2012,7,12), "Flor del Ceibo", "costas","Flor del Ceibo - 2012","https://youtu.be/eIvqPPcMepU");
	edicion.cambiameA("Aceptada", "costas");
	edicion = this.cargarInscripcion(new GregorianCalendar(2012,7,15), "Flor del Ceibo", "roro","Flor del Ceibo - 2012","https://youtu.be/vfc42Pb5RA8");
	edicion.cambiameA("Rechazada", "roro");
	edicion = this.cargarInscripcion(new GregorianCalendar(2012,7,30), "Flor del Ceibo", "weiss", "Flor del Ceibo - 2012", "");
	edicion.cambiameA("Aceptada", "weiss");

	notas.put("costas", 9);
	notas.put("weiss", 0);
	edicion.evaluar(notas);
	edicion.cerrar();
	notas.clear();

	
	edicion = this.cargarInscripcion(new GregorianCalendar(2018,3,10), "Flor del Ceibo", "roro","Flor del Ceibo - 2018","https://www.youtube.com/embed/3cZrMUtmTLQ");
	edicion.cambiameA("Aceptada", "roro");
	edicion = this.cargarInscripcion(new GregorianCalendar(2018,3,15), "Flor del Ceibo", "jeffw","Flor del Ceibo - 2018","");
	edicion.cambiameA("Aceptada", "jeffw");
	edicion = this.cargarInscripcion(new GregorianCalendar(2018,3,2), "Flor del Ceibo", "Otism", "Flor del Ceibo - 2018", "");
	edicion.cambiameA("Aceptada", "Otism");
	edicion = this.cargarInscripcion(new GregorianCalendar(2018,3,11), "Flor del Ceibo", "Keating", "Flor del Ceibo - 2018", "https://youtu.be/PUD36wlkmJ4");
	edicion.cambiameA("Aceptada", "Keating");
	edicion = this.cargarInscripcion(new GregorianCalendar(2018,3,11), "Flor del Ceibo", "nadiav", "Flor del Ceibo - 2018", "");
	edicion.cambiameA("Rechazada", "nadiav");
	notas.put("roro", 9);
	notas.put("jeffw", 6);
	notas.put("Otism", 10);
	notas.put("roro", 9);
	edicion.evaluar(notas);
	edicion.cerrar();
	notas.clear();
	
	edicion = this.cargarInscripcion(new GregorianCalendar(2017,7,25), "Dalavuelta", "chechi","Dalavuelta - 2018","");
	edicion.cambiameA("Aceptada", "chechi");
	edicion = this.cargarInscripcion(new GregorianCalendar(2017,7,28), "Dalavuelta", "eleven11","Dalavuelta - 2018","");
	edicion.cambiameA("Rechazada", "eleven11");
	edicion = this.cargarInscripcion(new GregorianCalendar(2017,8,2), "Dalavuelta", "roro","Dalavuelta - 2018","https://www.youtube.com/embed/7EyyqpLQAYA");
	edicion.cambiameA("Aceptada", "roro");
	edicion = this.cargarInscripcion(new GregorianCalendar(2017,8,10), "Dalavuelta", "costas","Dalavuelta - 2018","https://www.youtube.com/embed/FOQvGCFjpXo");
	edicion.cambiameA("Aceptada", "costas");
	edicion = this.cargarInscripcion(new GregorianCalendar(2017,8,15), "Dalavuelta", "jeffw","Dalavuelta - 2018","");
	edicion.cambiameA("Rechazada", "jeffw");
	notas.put("chechi", 7);
	notas.put("roro", 7);
	notas.put("costas", 6);
	edicion.evaluar(notas);
	edicion.cerrar();
	notas.clear();
	
	edicion = this.cargarInscripcion(new GregorianCalendar(2018,7,18), "Extensionismo Industrial", "costas","Extensionismo Industrial - 2018","https://www.youtube.com/embed/p6RKNMlXoyk");
	edicion.cambiameA("Aceptada", "costas");
	edicion = this.cargarInscripcion(new GregorianCalendar(2018,7,20), "Extensionismo Industrial", "chechi","Extensionismo Industrial - 2018","");
	edicion.cambiameA("Aceptada", "chechi");
	edicion = this.cargarInscripcion(new GregorianCalendar(2018,7,29), "Extensionismo Industrial", "eleven11","Extensionismo Industrial - 2018","");
	edicion.cambiameA("Aceptada", "eleven11");
	edicion = this.cargarInscripcion(new GregorianCalendar(2018,8,5), "Extensionismo Industrial", "weiss","Extensionismo Industrial - 2018","");
	edicion.cambiameA("Aceptada", "weiss");
	notas.put("costas", 9);
	notas.put("chechi", 9);
	notas.put("eleven11", 1);
	notas.put("weiss", 11);
	edicion.evaluar(notas);
	edicion.cerrar();
	notas.clear();
		
	
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,2,23), "Inclusion Energetica", "roro","Inclusion Energetica - 2019","https://www.youtube.com/embed/Pn_bGOSSvYU");
	edicion.cambiameA("Aceptada", "roro");
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,2,25), "Inclusion Energetica", "weiss","Inclusion Energetica - 2019","");
	edicion.cambiameA("Rechazada", "weiss");
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,2,28), "Inclusion Energetica", "chechi","Inclusion Energetica - 2019","");
	edicion.cambiameA("Aceptada", "chechi");
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,3,3), "Inclusion Energetica", "eleven11","Inclusion Energetica - 2019","");
	edicion.cambiameA("Rechazada", "eleven11");
	notas.put("roro", 7);
	notas.put("chechi", 11);
	edicion.evaluar(notas);
	edicion.cerrar();
	notas.clear();
	
	
	edicion = this.cargarInscripcion(new GregorianCalendar(2017,2,18), "Taller de robotica educativa", "weiss","Taller de robotica educativa - 2017","");
	edicion.cambiameA("Rechazada", "weiss");
	edicion = this.cargarInscripcion(new GregorianCalendar(2017,2,20), "Taller de robotica educativa", "roro","Taller de robotica educativa - 2017","https://www.youtube.com/embed/EllYgcWmcAY");
	edicion.cambiameA("Rechazada", "roro");
	edicion = this.cargarInscripcion(new GregorianCalendar(2017,3,3), "Taller de robotica educativa", "eleven11","Taller de robotica educativa - 2017","");
	edicion.cambiameA("Aceptada", "eleven11");
	notas.put("eleven11", 0);
	edicion.evaluar(notas);
	edicion.cerrar();
	notas.clear();
	
	
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,2,18), "Taller de robotica educativa", "jeffw","Taller de robotica educativa - 2019","");
	edicion.cambiameA("Aceptada", "jeffw");
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,2,22), "Taller de robotica educativa", "costas","Taller de robotica educativa - 2019","");
	edicion.cambiameA("Aceptada", "costas");
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,2,23), "Taller de robotica educativa", "roro","Taller de robotica educativa - 2019","");
	edicion.cambiameA("Rechazada", "roro");
	notas.put("jeffw", 8);
	notas.put("costas", 10);
	edicion.evaluar(notas);
	edicion.cerrar();
	notas.clear();
	
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,8,18), "Taller de robotica educativa", "weiss","Taller de robotica educativa - 2019-2","");
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,8,22), "Taller de robotica educativa", "chechi","Taller de robotica educativa - 2019-2","");
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,9,3), "Taller de robotica educativa", "roro","Taller de robotica educativa - 2019-2","");
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,9,1), "Taller de robotica educativa", "Keating","Taller de robotica educativa - 2019-2","https://youtu.be /6ZKoXTOqenw");
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,9,2), "Taller de robotica educativa", "saul","Taller de robotica educativa - 2019-2","");
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,8,31), "Taller de robotica educativa", "Anab","Taller de robotica educativa - 2019-2","");
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,9,1), "Taller de robotica educativa", "Sallyo","Taller de robotica educativa - 2019-2","https://youtu.be/Y7tBpv6sjiw");

	
	
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,7,13), "Participacion en investigacion sobre el empleo del juego Komikan como recurso didactico en la Escuela", "chechi","Participacion en investigacion sobre el empleo del juego Komikan como recurso didactico en la Escuela - 2019","");
	edicion.cambiameA("Aceptada", "chechi");
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,7,20), "Participacion en investigacion sobre el empleo del juego Komikan como recurso didactico en la Escuela", "weiss","Participacion en investigacion sobre el empleo del juego Komikan como recurso didactico en la Escuela - 2019","");
	edicion.cambiameA("Aceptada", "weiss");
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,7,22), "Participacion en investigacion sobre el empleo del juego Komikan como recurso didactico en la Escuela", "roro","Participacion en investigacion sobre el empleo del juego Komikan como recurso didactico en la Escuela - 2019","");
	edicion.cambiameA("Aceptada", "roro");
	notas.put("chechi", 0);
	notas.put("weiss", 0);
	notas.put("roro", 0);
	edicion.evaluar(notas);
	edicion.cerrar();
	notas.clear();
	
	
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,6,4), "Herramientas de apoyo a la enseñanza de ingles. Instalacion y evaluacion", "weiss","Herramientas de apoyo a la enseñanza de ingles. Instalacion y evaluacion - 2019","");
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,7,18), "Herramientas de apoyo a la enseñanza de ingles. Instalacion y evaluacion", "eleven11","Herramientas de apoyo a la enseñanza de ingles. Instalacion y evaluacion - 2019","");
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,8,20), "Herramientas de apoyo a la enseñanza de ingles. Instalacion y evaluacion", "jeffw","Herramientas de apoyo a la enseñanza de ingles. Instalacion y evaluacion - 2019","");
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,8,1), "Herramientas de apoyo a la enseñanza de ingles. Instalacion y evaluacion", "Steveh","Herramientas de apoyo a la enseñanza de ingles. Instalacion y evaluacion - 2019","https://youtu.be/VGovcwfV7A4");
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,8,15), "Herramientas de apoyo a la enseñanza de ingles. Instalacion y evaluacion", "Juanse","Herramientas de apoyo a la enseñanza de ingles. Instalacion y evaluacion - 2019","");
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,7,23), "Herramientas de apoyo a la enseñanza de ingles. Instalacion y evaluacion", "nadiav","Herramientas de apoyo a la enseñanza de ingles. Instalacion y evaluacion - 2019","");
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,8,1), "Herramientas de apoyo a la enseñanza de ingles. Instalacion y evaluacion", "saul","Herramientas de apoyo a la enseñanza de ingles. Instalacion y evaluacion - 2019","");
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,8,17), "Herramientas de apoyo a la enseñanza de ingles. Instalacion y evaluacion", "Otism","Herramientas de apoyo a la enseñanza de ingles. Instalacion y evaluacion - 2019","");

	
	
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,7,12), "MicroBit", "chechi","MicroBit - 2019","");
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,7,14), "MicroBit", "roro","MicroBit - 2019","https://www.youtube.com/embed/MGvt_-zxocM");
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,7,25), "MicroBit", "eleven11","MicroBit - 2019","");
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,8,5), "MicroBit", "jeffw","MicroBit - 2019","");
	
	
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,3,5), "Talleres plenarios", "costas","Talleres plenarios - 2019","");
	edicion.cambiameA("Rechazada", "costas");
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,3,4), "Talleres plenarios", "weiss","Talleres plenarios - 2019","");
	edicion.cambiameA("Aceptada", "weiss");
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,3,7), "Talleres plenarios", "roro","Talleres plenarios - 2019","");
	edicion.cambiameA("Aceptada", "roro");
	notas.put("weiss", 6);
	notas.put("roro", 7);
	edicion.evaluar(notas);
	edicion.cerrar();
	notas.clear();
	
	
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,7,15), "Seminarios de Resolucion de Problemas", "weiss","Seminarios de Resolucion de Problemas - 2019","");
	edicion.cambiameA("Aceptada", "weiss");
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,7,20), "Seminarios de Resolucion de Problemas", "costas","Seminarios de Resolucion de Problemas - 2019","");
	edicion.cambiameA("Rechazada", "costas");
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,8,6), "Seminarios de Resolucion de Problemas", "roro","Seminarios de Resolucion de Problemas - 2019","");
	edicion.cambiameA("Aceptada", "roro");
	edicion = this.cargarInscripcion(new GregorianCalendar(2019,8,30), "Seminarios de Resolucion de Problemas", "chechi","Seminarios de Resolucion de Problemas - 2019","");
	edicion.cambiameA("Rechazada", "chechi");
	notas.put("weiss", 10);
	notas.put("roro", 2);
	edicion.evaluar(notas);
	edicion.cerrar();
	notas.clear();
	
	
	} catch (NoPudoInscribirseExcep et) {
		et.printStackTrace();
		System.out.println(et.getMessage());
	} catch (EstudianteSinEvaluarExcep noporfavor) {
		noporfavor.printStackTrace();
		System.out.println(noporfavor.getMessage());
		System.out.println("error en inscribir a la gentuza");
	}
	
	
	
	
	
	
	
	
	
	
	//Cargado de Programa de formacion
	Calendar date = Calendar.getInstance();
	try {
		controladorCurso.registrarPrograma( "EFI Ingenieria Mecanica" , "Programa mecanica", new GregorianCalendar(2019,5,1), new GregorianCalendar(2019,10,31), date,"http://bit.ly/2lUzDAc");
		controladorCurso.registrarPrograma("Formacion integral", "Programa varios institutos", new GregorianCalendar(2019,7,15), new GregorianCalendar(2020,1,1), date,"--");
		controladorCurso.registrarPrograma("EFI Robotica", "Programa robotica", new GregorianCalendar(2019,9,3), new GregorianCalendar(2019,11,18), date,"http://bit.ly/2kFcGRu");
	}catch(ProgramaRepetidoExcep e) {
		System.out.println(e.getMessage());
	}
	this.ingresarCursoAPrograma("EFI Ingenieria Mecanica", "Dalavuelta");
	this.ingresarCursoAPrograma("EFI Ingenieria Mecanica", "Extensionismo Industrial");
	this.ingresarCursoAPrograma("EFI Ingenieria Mecanica", "Inclusion Energetica");
	this.ingresarCursoAPrograma("Formacion integral", "Seminarios de Resolucion de Problemas");
	this.ingresarCursoAPrograma("Formacion integral", "Extensionismo Industrial");
	this.ingresarCursoAPrograma("Formacion integral", "Flor del Ceibo");
	this.ingresarCursoAPrograma("Formacion integral", "Participacion en investigacion sobre el empleo del juego Komikan como recurso didactico en la Escuela");
	this.ingresarCursoAPrograma("EFI Robotica", "Taller de robotica educativa");
	this.ingresarCursoAPrograma("EFI Robotica", "MicroBit");
	
	} catch (EstadoEsFinalExcep e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	CtrlUsuario controladorUsuario = CtrlUsuario.getInstance();
	//CtrlCurso controladorCurso = CtrlCurso.getInstance();
	try {
	controladorUsuario.InscribirUsuarioAProgramaDeFormacion("eleven11", "EFI Ingenieria Mecanica");
	controladorUsuario.InscribirUsuarioAProgramaDeFormacion("chechi", "EFI Ingenieria Mecanica");
	controladorUsuario.InscribirUsuarioAProgramaDeFormacion("costas", "Formacion integral");
	controladorUsuario.InscribirUsuarioAProgramaDeFormacion("chechi", "Formacion integral");
	controladorUsuario.InscribirUsuarioAProgramaDeFormacion("eleven11", "Formacion integral");
	controladorUsuario.InscribirUsuarioAProgramaDeFormacion("weiss", "Formacion integral");
	controladorUsuario.InscribirUsuarioAProgramaDeFormacion("roro", "Formacion integral");
	controladorUsuario.InscribirUsuarioAProgramaDeFormacion("costas", "EFI Robotica");
	controladorUsuario.InscribirUsuarioAProgramaDeFormacion("chechi", "EFI Robotica");
	controladorUsuario.InscribirUsuarioAProgramaDeFormacion("roro", "EFI Robotica");
	controladorUsuario.InscribirUsuarioAProgramaDeFormacion("jeffw", "EFI Robotica");
	}catch (UsuarioRepetidoExcep e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
	}

	try {
	controladorUsuario = CtrlUsuario.getInstance();
	controladorUsuario.generarSeguimiento("eleven11", "roro");
	controladorUsuario.generarSeguimiento("eleven11", "heisenberg");
	controladorUsuario.generarSeguimiento("eleven11", "waston");
	
	controladorUsuario.generarSeguimiento("costas", "chechi");
	controladorUsuario.generarSeguimiento("costas", "danny");
	controladorUsuario.generarSeguimiento("costas", "phils");
	controladorUsuario.generarSeguimiento("costas", "jeffw");
	controladorUsuario.generarSeguimiento("costas", "benkenobi");
	
	controladorUsuario.generarSeguimiento("roro", "costas");
	controladorUsuario.generarSeguimiento("roro", "weiss");
	
	controladorUsuario.generarSeguimiento("chechi", "eleven11");
	controladorUsuario.generarSeguimiento("chechi", "jeffw");
	controladorUsuario.generarSeguimiento("chechi", "house");
	controladorUsuario.generarSeguimiento("chechi", "Anab");
	
	controladorUsuario.generarSeguimiento("jeffw", "eleven11");

	controladorUsuario.generarSeguimiento("weiss", "costas");
	controladorUsuario.generarSeguimiento("weiss", "heisenberg");
	controladorUsuario.generarSeguimiento("weiss", "timmy");

	controladorUsuario.generarSeguimiento("Juanse", "jeffw");
	controladorUsuario.generarSeguimiento("Juanse", "Steveh");
	controladorUsuario.generarSeguimiento("Juanse", "Sallyo");

	controladorUsuario.generarSeguimiento("Anab", "timmy");
	controladorUsuario.generarSeguimiento("Anab", "Otism");
	
	controladorUsuario.generarSeguimiento("Steveh", "eleven11");
	controladorUsuario.generarSeguimiento("Steveh", "waston");

	controladorUsuario.generarSeguimiento("nadiav", "Juanse");
	controladorUsuario.generarSeguimiento("nadiav", "Steveh");
	controladorUsuario.generarSeguimiento("nadiav", "Sallyo");
	controladorUsuario.generarSeguimiento("nadiav", "house");
	
	controladorUsuario.generarSeguimiento("Keating", "Steveh");
	controladorUsuario.generarSeguimiento("Keating", "timmy");
	
	controladorUsuario.generarSeguimiento("saul", "chechi");
	controladorUsuario.generarSeguimiento("saul", "Juanse");
	controladorUsuario.generarSeguimiento("saul", "waston");
	
	controladorUsuario.generarSeguimiento("Sallyo", "nadiav");
	
	controladorUsuario.generarSeguimiento("Otism", "nadiav");
	controladorUsuario.generarSeguimiento("Otism", "Steveh");

	controladorUsuario.generarSeguimiento("heisenberg", "roro");
	controladorUsuario.generarSeguimiento("heisenberg", "adri");
	controladorUsuario.generarSeguimiento("heisenberg", "saul");
	
	controladorUsuario.generarSeguimiento("benkenobi", "danny");

	controladorUsuario.generarSeguimiento("waston", "roro");
	controladorUsuario.generarSeguimiento("waston", "weiss");
	controladorUsuario.generarSeguimiento("waston", "heisenberg");
	
	controladorUsuario.generarSeguimiento("house", "jeffw");
	controladorUsuario.generarSeguimiento("house", "weiss");
	controladorUsuario.generarSeguimiento("house", "benkenobi");
	
	controladorUsuario.generarSeguimiento("timmy", "eleven11");
	controladorUsuario.generarSeguimiento("timmy", "chechi");
	controladorUsuario.generarSeguimiento("timmy", "jeffw");

	controladorUsuario.generarSeguimiento("danny", "costas");
	controladorUsuario.generarSeguimiento("danny", "weiss");
	controladorUsuario.generarSeguimiento("danny", "heisenberg");
	
	controladorUsuario.generarSeguimiento("phils", "bruces");
	controladorUsuario.generarSeguimiento("phils", "adri");
	
	controladorUsuario.generarSeguimiento("bruces", "phils");
	controladorUsuario.generarSeguimiento("bruces", "Steveh");
	
	controladorUsuario.generarSeguimiento("adri", "heisenberg");
	
	}catch(UsuarioNoExisteExcep excepcioncita) {
		excepcioncita.printStackTrace();
		System.out.println(excepcioncita.getMessage());
	}
	//Cargada de valoraciones
	interfaceCurso controladorCurso = Fabrica.getInstancia().getICurso();
	try {
	controladorCurso.valorar("eleven11", "Inclusion Energetica", 3);
	controladorCurso.valorar("chechi", "Inclusion Energetica", 4);
	controladorCurso.valorar("costas", "Inclusion Energetica", 5);
	controladorCurso.valorar("weiss", "Inclusion Energetica", 4);
	controladorCurso.valorar("roro", "Inclusion Energetica", 3);
	controladorCurso.valorar("jeffw", "Inclusion Energetica", 3);

	controladorCurso.valorar("chechi", "Dalavuelta", 2);
	controladorCurso.valorar("roro", "Dalavuelta", 5);
	controladorCurso.valorar("costas", "Dalavuelta", 4);

	controladorCurso.valorar("costas", "Extensionismo Industrial", 1);
	controladorCurso.valorar("chechi", "Extensionismo Industrial", 2);
	controladorCurso.valorar("eleven11", "Extensionismo Industrial", 3);
	controladorCurso.valorar("weiss", "Extensionismo Industrial", 1);
	
	controladorCurso.valorar("roro", "Flor del Ceibo", 5);
	controladorCurso.valorar("chechi", "Flor del Ceibo", 5);
	
	controladorCurso.valorar("eleven11", "Taller de robotica educativa", 4);
	controladorCurso.valorar("jeffw", "Taller de robotica educativa", 5);
	
	controladorCurso.valorar("chechi", "Participacion en investigacion sobre el empleo del juego Komikan como recurso didactico en la Escuela", 4);
	controladorCurso.valorar("weiss", "Participacion en investigacion sobre el empleo del juego Komikan como recurso didactico en la Escuela", 4);
	controladorCurso.valorar("roro", "Participacion en investigacion sobre el empleo del juego Komikan como recurso didactico en la Escuela", 4);
	
	controladorCurso.valorar("weiss", "Talleres plenarios", 1);
	
	controladorCurso.valorar("roro", "Seminarios de Resolucion de Problemas", 2);
	
	
	
	} catch(Exception excepcioncita) {
		excepcioncita.printStackTrace();
		System.out.println(excepcioncita.getMessage());
	}
	
	
	//Cargada de Comentarios
			this.cargarComentario("Flor del Ceibo - 2010", "eleven11", "Me gusto!");
			this.cargarComentario("Flor del Ceibo - 2010", "chechi", "Aceptable");
			this.cargarComentario("Extensionismo Industrial - 2018", "eleven11", "Horrible, nos matarion en las pruebas!");
			this.cargarComentario("Extensionismo Industrial - 2018", "chechi", "Que penal, te fue muy mal?", 0);
			this.cargarComentario("Extensionismo Industrial - 2018", "costas", "Para mi no estuvo tan mal, si estudias la salvas!");
			this.cargarComentario("Extensionismo Industrial - 2018", "weiss", "Ahh, vos porque sos un extraterrestre! Fue una carniceria", 2);
			this.cargarComentario("Taller de robotica educativa - 2019", "costas", "Muy buen curso, recomendable!");
			this.cargarComentario("Taller de robotica educativa - 2019", "jeffw", "Demas, me aceptaron. Tenes material para compartir?", 0);
			this.cargarComentario("Talleres plenarios - 2019", "weiss", "Una perdida de tiempo!");
			this.cargarComentario("Seminarios de Resolucion de Problemas - 2019", "roro", "En realidad nunca fui a clases y me fue mal");
			this.cargarComentario("Extensionismo Industrial - 2018", "eleven11", "Espantoso!!Perdi como en la guerra", 1);
			this.cargarComentario("Extensionismo Industrial - 2018", "chechi", "Mejor suerte para la proxima!", 4);
	}
}
