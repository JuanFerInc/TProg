package logica.ctrleinterfaces;

import java.util.Calendar;
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
import logica.clases.Edicion;
import logica.datatypes.DtComentario;
import logica.datatypes.DtCurso;
import logica.datatypes.DtInfo;
import logica.datatypes.DtInstancia;
import logica.datatypes.Val;


public interface interfaceCurso {
	public  Set<String> listarProgramas();
	public Set<String> listarCursosExistente();
	public  Set<String> listarInstitutos();
	public Set<String>	seleccionarPrograma(String nombrePrograma);
	public Set<String> seleccionarInstituto(String nombreInstituto);
	public  Set<String>	seleccionarCurso(String nombreCurso);
	public DtCurso verDatosCurso(String nombreCurso);
	public DtInstancia verDatosEdicion(String nombreEdicicon);
	public DtInstancia verDatosPrograma(String nombrePrograma);
	public void aceptarAgregarCursoAPrograma();
	public boolean registrarCurso(String nombreInstituto, String nombreCurso,String  descripcionCurso,int duracionCurso,int cantidadHoras,int cantidadCreditos, String URL,Calendar fechaAlta, Set<String> previas,Set<String> categorias,String imagen)throws CursoRepetidoExcep;
	public boolean registrarPrograma(String nombre,String descripcion,Calendar fechaInicio,Calendar fechaFin,Calendar fechaAlta, String img)throws ProgramaRepetidoExcep;
	public boolean	registrarEdicion(String nombre,Calendar fechaInicioa,Calendar fechaFin,int cupos,Set<String> docentesParticipan,Calendar fechapublicacion,String imagen)throws EdicionRepetidaExcep;
	public boolean	registrarInstituto(String nombreInstituto)throws InstitutoRepetidoExcep;
	public Edicion	pedirEdicionVigente();
	public void pedirInfo();
	public boolean existeEdicionVigenteDeCurso();
	public DtInstancia mostrarEdicionVigenteDeCurso();
	public void salir();
	public boolean esPrograma(String nombrePrograma);
	public Set<String> mostrarEdiciones();
	public Set<String> listarCategorias();
	public void altaCategoria(String nombreCategoria) throws CategoriaRepetidaExcep;
	public Set<DtInfo> listarInscripcionesACurso(String nombreCurso);
	public Set<DtInfo> listarInscripcionesAEdicion(String nombreEdicion);
	public void cambiarEstado(String estado, String persona) throws EstadoEsFinalExcep, NoPudoInscribirseExcep;

	//esta funcion es igual que seleccionarInstituto
	//retorna la lista de cursos que estan en la categoria nombreCategoria
	//no creo que sea necesario guardar la categoria 
	public Set<String> seleccionarCategoria(String nombreCategoria);
	public List<String> ordenarSegunAnio(Set<String> arg) throws CursoNoExisteExcep ;
	public List<DtInfo> ordenarSegunRanking(String nombreEdicion) throws EdicionNoExisteExcep;
	public List<String> ordenar(Set<String> arg);
	public Map<String,String> buscar(String busqueda);
	public Set<String> inscriptosAPrograma(String nombre);
	public void corregirExamen(String Edicion, Map<String,Integer> notas) throws EstudianteSinEvaluarExcep;
	public void cerrarEdicion(String curso); 
	
	
	public int verCorreccion(String edicion, String user, boolean siosi) throws UsuarioNoExisteExcep;
	public String verVideoDeInscripcion(String Edicion, String nick) throws UsuarioNoExisteExcep;
	public Val puedeValorar(String nick, String curso);
	public void valorar(String nick,String curso, Integer valoracion) throws EvaluacionIncorrectaExcep;
	public double verValoracion(String curso) throws EvaluacionIncorrectaExcep;
	public double verValoracion(String curso, String nick) throws EvaluacionIncorrectaExcep;
	public void comentar(String edicion, String texto, String autor) throws NoSePudoResponderExcep, EdicionNoExisteExcep;
	public void comentar(String edicion, String texto, String autor, Integer respondido) throws NoSePudoResponderExcep, EdicionNoExisteExcep;
	
	//SOLO RETORNA EL PRIMER NIVEL
	public Set<DtComentario> verComentarios(String curso, String edicion);
	public boolean estaCerradaLaEdicion(String nombreEdicion);
	
	public String dameNombreCurso(String nombreEdicion);
}
