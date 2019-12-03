package publicador;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import exception.CategoriaRepetidaExcep;
import exception.CursoNoExisteExcep;
import exception.CursoRepetidoExcep;
import exception.EdicionNoExisteExcep;
import exception.EdicionRepetidaExcep;
import exception.EstadoEsFinalExcep;
import exception.EstudianteSinEvaluarExcep;
import exception.EvaluacionIncorrectaExcep;
import exception.InstitutoRepetidoExcep;
import exception.LoginIncorrectoExcep;
import exception.NoPudoDesinscribirseExcep;
import exception.NoPudoInscribirseExcep;
import exception.NoSePudoResponderExcep;
import exception.ProgramaRepetidoExcep;
import exception.UsuarioNoExisteExcep;
import exception.UsuarioRepetidoExcep;
import logica.capsuleCorp.ListDtInfo;
import logica.capsuleCorp.ListInteger;
import logica.capsuleCorp.ListString;
import logica.capsuleCorp.MapStringStringAlgo;
import logica.capsuleCorp.SetDtComentario;
import logica.capsuleCorp.SetDtInfo;
import logica.capsuleCorp.SetString;
import logica.ctrleinterfaces.CtrlCurso;
import logica.ctrleinterfaces.CtrlUsuario;
import logica.datatypes.DtComentario;
import logica.datatypes.DtCurso;
import logica.datatypes.DtInstancia;
import logica.datatypes.DtUsuario;
import logica.datatypes.TipoError;
import logica.datatypes.TipoUsuario;
import logica.datatypes.Val;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class Publicador {

	private CtrlCurso ICurso = CtrlCurso.getInstance();
	private CtrlUsuario IUsuario = CtrlUsuario.getInstance();

	private Endpoint endpoint = null;

	// Constructor
	public Publicador() {
	}

	// Operaciones las cuales quiero publicar
	@WebMethod(exclude = true)
	public void publicar() {
		 Properties prop = new Properties();
	        FileInputStream file = null;
	        try {
				file = new FileInputStream("/ens/home01/m/manuel.freire/edEXT/config.properties");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	        try {
				prop.load(file);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	        String laURL = prop.getProperty("URLPUBLICADOR");
	        	        
		endpoint = Endpoint.publish(laURL, this);
	}

	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
		return endpoint;
	}

	// ##############################################
	// FUNCIONES DEL CONTROLADOR DE CURSOS ##########
	// ##############################################
	@WebMethod
	public SetString listarProgramas() {
		return new SetString(ICurso.listarProgramas());
	}

	@WebMethod
	public SetString listarCursosExistente() {
		return new SetString(ICurso.listarCursosExistente());
	}

	@WebMethod
	public SetString listarInstitutos() {
		return new SetString(ICurso.listarInstitutos());
	}

	@WebMethod
	public SetString seleccionarPrograma(String nombrePrograma) {
		return new SetString(ICurso.seleccionarPrograma(nombrePrograma));
	}

	@WebMethod
	public SetString seleccionarInstituto(String nombreInstituto) {
		return new SetString(ICurso.seleccionarInstituto(nombreInstituto));
	}

	@WebMethod
	public SetString seleccionarCurso(String nombreCurso) {
		return new SetString(ICurso.seleccionarCurso(nombreCurso));
	}

	@WebMethod
	public DtCurso verDatosCurso(String nombreCurso) {
		return ICurso.verDatosCurso(nombreCurso);
	}

	@WebMethod
	public DtInstancia verDatosEdicion(String nombreEdicicon) {
		return ICurso.verDatosEdicion(nombreEdicicon);
	}

	@WebMethod
	public DtInstancia verDatosPrograma(String nombrePrograma) {
		return ICurso.verDatosPrograma(nombrePrograma);
	}

	@WebMethod
	public void aceptarAgregarCursoAPrograma() {
		ICurso.aceptarAgregarCursoAPrograma();
	}

	@WebMethod
	public boolean registrarCurso(String nombreInstituto, String nombreCurso, String descripcionCurso,
			int duracionCurso, int cantidadHoras, int cantidadCreditos, String URL, Calendar fechaAlta,
			SetString previas, SetString categorias, String imagen) throws CursoRepetidoExcep {
		return ICurso.registrarCurso(nombreInstituto, nombreCurso, descripcionCurso, duracionCurso, cantidadHoras,
				cantidadCreditos, URL, fechaAlta, previas.getSetString(), categorias.getSetString(), imagen);
	}

	@WebMethod
	public boolean registrarPrograma(String nombre, String descripcion, Calendar fechaInicio, Calendar fechaFin,
			Calendar fechaAlta, String img) throws ProgramaRepetidoExcep {
		return ICurso.registrarPrograma(nombre, descripcion, fechaInicio, fechaFin, fechaAlta, img);
	}

	@WebMethod
	public boolean registrarEdicion(String nombre, Calendar fechaInicioa, Calendar fechaFin, int cupos,
			SetString docentesParticipan, Calendar fechapublicacion, String imagen) throws EdicionRepetidaExcep {
		return ICurso.registrarEdicion(nombre, fechaInicioa, fechaFin, cupos, docentesParticipan.getSetString(),
				fechapublicacion, imagen);
	}

	@WebMethod
	public boolean registrarInstituto(String nombreInstituto) throws InstitutoRepetidoExcep {
		return ICurso.registrarInstituto(nombreInstituto);
	}

	@WebMethod
	public void pedirInfo() {
		ICurso.pedirInfo();
	}

	@WebMethod
	public boolean existeEdicionVigenteDeCurso() {
		return ICurso.existeEdicionVigenteDeCurso();
	}

	@WebMethod
	public DtInstancia mostrarEdicionVigenteDeCurso() {
		return ICurso.mostrarEdicionVigenteDeCurso();
	}

	@WebMethod
	public void salirCurso() {
		ICurso.salir();
	}

	@WebMethod
	public boolean esPrograma(String nombrePrograma) {
		return ICurso.esPrograma(nombrePrograma);
	}

	@WebMethod
	public SetString mostrarEdiciones() {
		return new SetString(ICurso.mostrarEdiciones());
	}

	@WebMethod
	public SetString listarCategorias() {
		return new SetString(ICurso.listarCategorias());
	}

	@WebMethod
	public void altaCategoria(String nombreCategoria) throws CategoriaRepetidaExcep {
		ICurso.altaCategoria(nombreCategoria);
	}

	@WebMethod
	public SetDtInfo listarInscripcionesACurso(String nombreCurso) {
		return new SetDtInfo(ICurso.listarInscripcionesACurso(nombreCurso));
	}

	@WebMethod
	public SetDtInfo listarInscripcionesAEdicion(String nombreEdicion) {
		return new SetDtInfo(ICurso.listarInscripcionesAEdicion(nombreEdicion));
	}

	@WebMethod
	public void cambiarEstado(String estado, String persona) throws EstadoEsFinalExcep, NoPudoInscribirseExcep {
		ICurso.cambiarEstado(estado, persona);
	}

	@WebMethod
	// esta funcion es igual que seleccionarInstituto
	// retorna la lista de cursos que estan en la categoria nombreCategoria
	// no creo que sea necesario guardar la categoria
	public SetString seleccionarCategoria(String nombreCategoria) {
		return new SetString(ICurso.seleccionarCategoria(nombreCategoria));
	}

	@WebMethod
	public ListString ordenarSegunAnio(SetString arg) throws CursoNoExisteExcep {
		return new ListString(ICurso.ordenarSegunAnio(arg.getSetString()));
	}

	@WebMethod
	public ListDtInfo ordenarSegunRanking(String nombreEdicion) throws EdicionNoExisteExcep {
		return new ListDtInfo(ICurso.ordenarSegunRanking(nombreEdicion));
	}

	@WebMethod
	public ListString ordenar(SetString arg) {
		return new ListString(ICurso.ordenar(arg.getSetString()));
	}

	@WebMethod
	public MapStringStringAlgo buscar(String busqueda) {
		return new MapStringStringAlgo(ICurso.buscar(busqueda));
	}

	@WebMethod
	public SetString inscriptosAPrograma(String nombre) {
		return new SetString(ICurso.inscriptosAPrograma(nombre));
	}

	@WebMethod
	public void corregirExamen(String Edicion, ListString keys,ListInteger value) throws EstudianteSinEvaluarExcep {
		int i = 0;
		List<String> claves = keys.getListString();
		List<Integer> valores = value.getListInteger();
		Map<String,Integer> notas = new HashMap<String,Integer>();
		
		while(i < claves.size()) {
			notas.put(claves.get(i), valores.get(i));
			i++;
		}
		
		ICurso.corregirExamen(Edicion, notas);
	}

	public int verCorreccion(String edicion, String user, boolean siosi)
			throws EstudianteSinEvaluarExcep, UsuarioNoExisteExcep {
		return ICurso.verCorreccion(edicion, user, siosi);
	}

	public String verVideoDeInscripcion(String Edicion, String nick) throws UsuarioNoExisteExcep {
		return ICurso.verVideoDeInscripcion(Edicion, nick);
	}

	public Val puedeValorar(String nick, String curso) {
		return ICurso.puedeValorar(nick, curso);
	}

	public void valorar(String nick, String curso, Integer valoracion) throws EvaluacionIncorrectaExcep {
		ICurso.valorar(nick, curso, valoracion);
	}

	public double verValoracion1(String curso) throws EvaluacionIncorrectaExcep {
		return ICurso.verValoracion(curso);
	}

	public double verValoracion2(String curso, String nick) throws EvaluacionIncorrectaExcep {
		return ICurso.verValoracion(curso, nick);
	}

	public void comentar1(String edicion, String texto, String autor)
			throws NoSePudoResponderExcep, EdicionNoExisteExcep {
		ICurso.comentar(edicion, texto, autor);
	}

	public void comentar2(String edicion, String texto, String autor, Integer respondido)
			throws NoSePudoResponderExcep, EdicionNoExisteExcep {
		ICurso.comentar(edicion, texto, autor, respondido);
	}

	public void cerrarEdicion(String curso) {
		ICurso.cerrarEdicion(curso);
	}
	
	public SetDtComentario verComentarios(String curso, String edicion){
		Set<DtComentario> res = ICurso.verComentarios(curso, edicion);
		SetDtComentario aRetornar =new SetDtComentario(res); 
		return aRetornar;
	}
	public boolean estaCerradaLaEdicion(String nombreEdicion) {
		return ICurso.estaCerradaLaEdicion(nombreEdicion);
	}
	public String dameNombreCurso(String nombreEdicion) {
		return ICurso.dameNombreCurso(nombreEdicion);
	}
	// ###############################################
	// FUNCIONES DEL CONTROLADOR DE USUARIO ##########
	// ###############################################

	@WebMethod
	public SetString listarUsuarios() {
		return new SetString(IUsuario.listarUsuarios());
	}

	@WebMethod
	public DtUsuario verDatosUsuario(String nombreUsuario) {
		return IUsuario.verDatosUsuario(nombreUsuario);
	}

	@WebMethod
	public SetString listarEstudiantes() {
		return new SetString(IUsuario.listarEstudiantes());
	}

	@WebMethod
	public void seleccionarEstudiante(String nickEstudiante) {
		IUsuario.seleccionarEstudiante(nickEstudiante);
	}

	@WebMethod
	public DtUsuario seleccionarUsuario(String nickUsuario) {
		return IUsuario.seleccionarUsuario(nickUsuario);
	}

	@WebMethod
	public TipoError registrarUser(String nickname, String nombre, String apellido, Calendar fechaNacimiento,
			String mail, TipoUsuario tipo, String nombreInstituto, String password, String confirmacion, String imagen)
			throws Exception {
		return IUsuario.registrarUser(nickname, nombre, apellido, fechaNacimiento, mail, tipo, nombreInstituto,
				password, confirmacion, imagen);
	}

	@WebMethod
	public boolean inscribirEstudianteACurso1(String video) throws NoPudoInscribirseExcep {
		return IUsuario.inscribirEstudianteACurso(video);
	}

	@WebMethod
	public boolean inscribirEstudianteACurso2(Calendar fechita, String video) throws NoPudoInscribirseExcep {
		return IUsuario.inscribirEstudianteACurso(fechita, video);
	}

	@WebMethod
	public void editarUsuario1(String nombre, String apellido, Calendar fecha) {
		IUsuario.editarUsuario(nombre, apellido, fecha);
	}

	@WebMethod
	public void editarUsuario2(String nombre, String apellido, Calendar fecha, String img) {
		IUsuario.editarUsuario(nombre, apellido, fecha, img);
	}

	@WebMethod
	public void editarUsuario3(String nombre, String apellido, Calendar fecha, String img, String Password) {
		IUsuario.editarUsuario(nombre, apellido, fecha, img, Password);
	}

	@WebMethod
	public void salirUsuario() {
		IUsuario.salir();
	}

	@WebMethod
	public String fechaDecente(Calendar cal) {
		return IUsuario.fechaDecente(cal);
	}

	@WebMethod
	public SetString listarDocentes() {
		return new SetString(IUsuario.listarDocentes());
	}

	@WebMethod
	public void generarSeguimiento(String objetivo, String origen) throws UsuarioNoExisteExcep {
		IUsuario.generarSeguimiento(objetivo, origen);
	}

	@WebMethod
	public void eliminarSeguimiento(String objetivo, String origen) throws UsuarioNoExisteExcep {
		IUsuario.eliminarSeguimiento(objetivo, origen);
	}

	@WebMethod
	public String iniciarSesion(String nick, String password) throws LoginIncorrectoExcep {
		return IUsuario.iniciarSesion(nick, password);
	}

	@WebMethod
	public boolean estaAceptado(String nick, String edicion) {
		return IUsuario.estaAceptado(nick, edicion);
	}

	@WebMethod
	public void InscribirUsuarioAProgramaDeFormacion(String nick, String programa) throws UsuarioRepetidoExcep {
		IUsuario.InscribirUsuarioAProgramaDeFormacion(nick, programa);
	}

	@WebMethod
	public void desistir(String nick, String edicion) throws NoPudoDesinscribirseExcep {
		IUsuario.desistir(nick, edicion);
	}

	public void modificarInscripcionDelEstudiante(String video, String usuario, String edicion) {
		IUsuario.modificarInscripcionDelEstudiante(video, usuario, edicion);
	}

}
