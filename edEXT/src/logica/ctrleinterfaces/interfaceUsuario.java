package logica.ctrleinterfaces;

import java.util.Calendar;
import java.util.Set;

import exception.LoginIncorrectoExcep;
import exception.NoPudoDesinscribirseExcep;
import exception.NoPudoInscribirseExcep;
import exception.UsuarioNoExisteExcep;
import exception.UsuarioRepetidoExcep;
import logica.clases.Estudiante;
import logica.datatypes.DtUsuario;
import logica.datatypes.TipoError;
import logica.datatypes.TipoUsuario;


public interface interfaceUsuario {
	public Set<String> listarUsuarios();
	public DtUsuario verDatosUsuario(String nombreUsuario);
	public Set<String> listarEstudiantes();
	public void seleccionarEstudiante(String nickEstudiante);
	public DtUsuario seleccionarUsuario(String nickUsuario);
	public TipoError registrarUser(String nickname,String nombre,String apellido, Calendar fechaNacimiento,String mail, TipoUsuario tipo, String nombreInstituto, String password, String confirmacion, String imagen)throws Exception;
	public boolean inscribirEstudianteACurso(String video)throws NoPudoInscribirseExcep;
	public boolean inscribirEstudianteACurso(Calendar fechita, String video)throws NoPudoInscribirseExcep;
	public void modificarInscripcionDelEstudiante(String video, String usuario, String edicion);
	
	public void editarUsuario(String nombre, String apellido, Calendar fecha);
	public void editarUsuario(String nombre, String apellido, Calendar fecha,String img);
	public void editarUsuario(String nombre, String apellido, Calendar fecha,String img,String Password);
	public void salir();
	public Estudiante dameEstudiante(String nickEstudiante);
	public String fechaDecente(Calendar cal);
	public Set<String> listarDocentes();
	
	// funciones que faltan para la WEB
	public void generarSeguimiento(String objetivo, String origen)throws UsuarioNoExisteExcep;
	public void eliminarSeguimiento(String objetivo, String origen)throws UsuarioNoExisteExcep;
	public String iniciarSesion(String nick, String password)throws LoginIncorrectoExcep;
	
	
	public boolean estaAceptado(String nick, String edicion);
	public void InscribirUsuarioAProgramaDeFormacion(String nick, String programa) throws UsuarioRepetidoExcep;
	public void desistir(String nick, String edicion) throws NoPudoDesinscribirseExcep;
	
	

	
}
