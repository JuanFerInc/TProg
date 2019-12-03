package logica.ctrleinterfaces;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import exception.ConfirmacionIncorrectaExcep;
import exception.CorreoInvalidoExcep;
import exception.EdicionNoExisteExcep;
import exception.LoginIncorrectoExcep;
import exception.NoPudoDesinscribirseExcep;
import exception.NoPudoInscribirseExcep;
import exception.PasswordVacioExcep;
import exception.UsuarioNoExisteExcep;
import exception.UsuarioRepetidoExcep;
import logica.clases.Docente;
import logica.clases.Edicion;
import logica.clases.Estudiante;
import logica.clases.Instituto;
import logica.clases.Usuario;
import logica.datatypes.DtInfo;
import logica.datatypes.DtUsuario;
import logica.datatypes.TipoError;
import logica.datatypes.TipoUsuario;


public class CtrlUsuario implements interfaceUsuario {
	
	private String nickUsuario;
	private Map<String,Usuario> UsuariosNick;
	private Map<String,Usuario> UsuariosCorreo;



	private static CtrlUsuario CtrlUsuarioInstancia = null;


	private CtrlUsuario(){
		nickUsuario = null;
		UsuariosNick = new HashMap<String,Usuario>();
		UsuariosCorreo = new HashMap<String,Usuario>();


	}

	public static CtrlUsuario getInstance(){
		if(CtrlUsuarioInstancia == null){
			CtrlUsuarioInstancia = new CtrlUsuario();
		}
		return CtrlUsuarioInstancia;
	}

	public Set<String> listarUsuarios(){
		Set<String> nombreUsuarios = new HashSet<String>();
		for(Map.Entry<String,Usuario>iter : UsuariosNick.entrySet()){
			nombreUsuarios.add(iter.getValue().getNick());
		}
		return nombreUsuarios;
	}

	public DtUsuario verDatosUsuario(String nombreUsuario){
		Usuario usr = UsuariosNick.get(nombreUsuario);
		return usr.dameDtUsuario();
	}

	public Set<String> listarEstudiantes(){
		Set<String> setNombreEstudiantes = new HashSet<String>();
		for(Map.Entry<String,Usuario> iter : UsuariosNick.entrySet()){
			Usuario usr = iter.getValue();
			if(usr instanceof Estudiante){
				setNombreEstudiantes.add(((Estudiante)usr).getNick());
			}
		}
		return setNombreEstudiantes;
	}

	public void seleccionarEstudiante(String nickEstudiante){
		this.nickUsuario = nickEstudiante;
	}

	public DtUsuario seleccionarUsuario(String nickUsuario) {
		this.nickUsuario = nickUsuario;
		return UsuariosNick.get(nickUsuario).dameDtUsuario();

	}
	public TipoError registrarUser(String nickname,String nombre,String apellido, Calendar fechaNacimiento,String mail, TipoUsuario tipo, String nombreInstituto, String password, String confirmacion, String imagen)throws Exception{
		if(UsuariosNick.containsKey(nickname)){
			throw new UsuarioRepetidoExcep("El usuario con el nick: " + nickname + " ya esta registrado.");
		}
		if(UsuariosCorreo.containsKey(mail)){
			throw new UsuarioRepetidoExcep("El usuario con el correo: " + mail + "ya esta registrado.");
		}
		if(password.compareTo(confirmacion)!= 0) {
			throw new ConfirmacionIncorrectaExcep("El Password y la Confirmacion no son iguales.");
		}
		if(password == "") {
			throw new PasswordVacioExcep("El password no puede ser vacio.");
		}
		
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	    if(!mail.matches(regex)) {
	    	throw new CorreoInvalidoExcep("El correo "+ mail + " es de formato invalido");
	    }
		
		
		
		
		Usuario usr = null;
		 if( tipo == TipoUsuario.DOCENTE) {
			CtrlCurso ctrlC = CtrlCurso.getInstance();
			Instituto instituto = ctrlC.darInstituto(nombreInstituto);
			usr = new Docente(nombre,nickname,apellido,mail,fechaNacimiento, instituto, password, imagen);
		 }else{
		 	usr = new Estudiante(nombre,nickname,apellido,mail,fechaNacimiento, password, imagen);
		 }
		 UsuariosNick.put(usr.getNick(),usr);
		 UsuariosCorreo.put(usr.getCorreo(),usr);
		 return TipoError.OK;
	}
	public boolean inscribirEstudianteACurso(String video)throws NoPudoInscribirseExcep {
		Calendar fechita = new GregorianCalendar();
		return this.inscribirEstudianteACurso(fechita, video);
		
	}

	public boolean inscribirEstudianteACurso(Calendar fechaInscripcion, String video)throws NoPudoInscribirseExcep {
		CtrlCurso MasterOfAllCourses = CtrlCurso.getInstance(); 
		Edicion edi = MasterOfAllCourses.pedirEdicionVigente();
		Usuario user_pepe = UsuariosNick.get(nickUsuario);
		Estudiante estudiante_pepe;
		if (user_pepe instanceof Estudiante) {
			estudiante_pepe = (Estudiante)user_pepe;
		}else {
			throw new NoPudoInscribirseExcep("Es un docente");
		}
		estudiante_pepe.inscribirA(edi, fechaInscripcion, video);
		
		MasterOfAllCourses.salir();
		return true;
	}
	
	public void modificarInscripcionDelEstudiante(String video, String usuario, String edicion) {
		Estudiante estu =(Estudiante) UsuariosNick.get(usuario);
		estu.modificarInscripcion(edicion,video);
	}
	
	public void editarUsuario(String nombre, String apellido, Calendar fecha,String img) {
		Usuario usr = UsuariosNick.get(nickUsuario);
		usr.modificarUsuarios(nombre,apellido,fecha,img);
		salir();
	}

	public void salir() {
		this.nickUsuario = null;
	}
	
	public Docente darDocente(String nickDocente) {
		return (Docente) UsuariosNick.get(nickDocente);
	}
	
	public Estudiante dameEstudiante(String nickEstudiante){
		return (Estudiante)UsuariosNick.get(nickEstudiante);
	}
	public String fechaDecente(Calendar cal) {
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int mes = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		
		if(mes == 0) {
			mes = 12;
			year = year - 1;
		}
		
		String dde = Integer.toString(day);
		String mme = Integer.toString(mes);
		String yye = Integer.toString(year);
		
		String str = dde + "/" + mme + "/" + yye;
		return str;
	}
	public Set<String> listarDocentes(){
		Set<String> setNombreDocentes = new HashSet<String>();
		for(Map.Entry<String,Usuario> iter : UsuariosNick.entrySet()){
			Usuario usr = iter.getValue();
			if(usr instanceof Docente){
				setNombreDocentes.add(((Docente)usr).getNick());
			}
		}
		return setNombreDocentes;
	}
	
	
	//Para el ultimo cdu
	//Tira excepcion tanto si no existe como si no es estudiante

	
	public String iniciarSesion(String nick, String password)throws LoginIncorrectoExcep{
		if(UsuariosNick.containsKey(nick) && UsuariosNick.get(nick).getPassword().equals(password)) {
			return UsuariosNick.get(nick).getNick();
		}else if(UsuariosCorreo.containsKey(nick) && UsuariosCorreo.get(nick).getPassword().equals(password)) {
			return UsuariosCorreo.get(nick).getNick();
		}else {
			throw new LoginIncorrectoExcep("Pone las cosas bien amigo");
		}
	}
	
	
	
	//Si esto llega a funcionar mal hay que revisar el tema de los gets de DtUsuario
	public boolean estaAceptado(String nick, String edicion) {
		Estudiante pepe = (Estudiante)UsuariosNick.get(nick);
		return pepe.estaInscripto(edicion);
	}

	public void editarUsuario(String nombre, String apellido, Calendar fecha,String img ,String Password) {
		Usuario user = UsuariosNick.get(nickUsuario);
		user.setPassword(Password);
		user.modificarUsuarios(nombre, apellido, fecha,img);
		salir();
	}

	
	public void generarSeguimiento(String desde, String hasta) throws UsuarioNoExisteExcep {
		Usuario uno, dos;
		uno = UsuariosNick.get(desde);
		dos = UsuariosNick.get(hasta);
		if(uno == null || dos == null) {
			if(uno == null)
				throw new UsuarioNoExisteExcep("desde " + desde);
			else
				throw new UsuarioNoExisteExcep("hasta");
		}
		uno.seguir(dos);
		dos.serSeguido(uno);
	}

	
	public void eliminarSeguimiento(String desde, String hasta) throws UsuarioNoExisteExcep {
		Usuario uno, dos;
		uno = UsuariosNick.get(desde);
		dos = UsuariosNick.get(hasta);
		if(uno == null || dos == null) {
			if(uno == null)
				throw new UsuarioNoExisteExcep("desde"+ desde);
			else
				throw new UsuarioNoExisteExcep("hasta");
		}
		uno.dejarDeSeguir(dos);
		dos.dejarDeSerSeguido(uno);		
		
	}

	
	public void editarUsuario(String nombre, String apellido, Calendar fecha) {
		Usuario usr = UsuariosNick.get(nickUsuario);
		this.editarUsuario(nombre, apellido, fecha, usr.getImg());
	}
	public void InscribirUsuarioAProgramaDeFormacion(String nick, String programa) throws UsuarioRepetidoExcep {
		CtrlCurso.getInstance().inscribirEstudianteAPrograma((Estudiante) UsuariosNick.get(nick), programa);
	}
	
	public void desistir(String nick, String edicion) throws NoPudoDesinscribirseExcep{
		Estudiante user = (Estudiante) UsuariosNick.get(nick);
		try {
			user.desistir(edicion);
		} catch (EdicionNoExisteExcep e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	



}

