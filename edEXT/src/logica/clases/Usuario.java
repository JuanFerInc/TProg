package logica.clases;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


import exception.UsuarioNoExisteExcep;
import logica.datatypes.DtUsuario;


public abstract class Usuario {

	private String nick, nombre, apellido, correo, password, img;
	private Calendar fechaNacimiento;
	private Map<String, Usuario> seguidos, seguidores;

	// constructores
	public Usuario(String nom, String nick, String apel, String correo, Calendar fechitaDeNacimiento, String password,
			String imagen) {
		this.password = password;
		this.nombre = nom;
		this.apellido = apel;
		this.nick = nick;
		this.correo = correo;
		this.fechaNacimiento = fechitaDeNacimiento;
		this.img = imagen;
		this.seguidos = new HashMap<String, Usuario>();
		this.seguidores = new HashMap<String, Usuario>();
	}

	// getters
	public String getNick() {
		return this.nick;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public String getCorreo() {
		return this.correo;
	}

	public Calendar getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public String getPassword() {
		return this.password;
	}

	public String getImg() {
		return img;
	}

	// setters
	public void seguir(Usuario user) {
		seguidos.put(user.getNick(), user);
	}

	public void dejarDeSeguir(Usuario user) throws UsuarioNoExisteExcep {
		if (!seguidos.containsKey(user.getNick()))
			throw new UsuarioNoExisteExcep("No lo tiene como seguido");
		seguidos.remove(user.getNick());
	}

	public void setPassword(String pass) {
		this.password = pass;
	}

	public void serSeguido(Usuario user) {
		seguidores.put(user.getNick(), user);
	}

	public void dejarDeSerSeguido(Usuario user) throws UsuarioNoExisteExcep {
		if (!seguidores.containsKey(user.getNick()))
			throw new UsuarioNoExisteExcep("No lo tiene como seguidor");
		seguidores.remove(user.getNick());
	}

	// funciones

	// Devuelve un DtEstudiante como DtUsuario si es un Estudiante
	// Devuelve un DtDocente como DtUsuario si es un Docente
	public abstract DtUsuario dameDtUsuario();

	public void modificarUsuarios(String nombre, String apellido, Calendar fechaNacimiento, String img) {
		this.apellido = apellido;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.img = img;
	}

	// Explicaria que hace pero lo dice el nombre salu2
	public Set<String> listarSeguidores() {
		Set<String> retorno = new HashSet<String>();
		for (String u : seguidores.keySet())
			retorno.add(u);
		return retorno;
	}

	public Set<String> listarSeguidos() {
		Set<String> retorno = new HashSet<String>();
		for (String u : seguidos.keySet())
			retorno.add(u);
		return retorno;
	}
}
