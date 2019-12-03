package logica.datatypes;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({DtEstudianteIn.class,DtDocente.class})
public class DtUsuario {
	private String nick, nombre, apellido, correo;
	private Calendar fechaNacimiento;
	private Set<String> seguidores, seguidos;
	private String imagen;

	// constructores
	public DtUsuario() {
		this.seguidores = new HashSet<String>();
		this.seguidos = new HashSet<String>();
	}

	public DtUsuario(String nom, String nick, String apel, String corr, Calendar fechita, String img,
			Set<String> seguidores, Set<String> seguidos) {
		this.apellido = apel;
		this.correo = corr;
		this.nick = nick;
		this.nombre = nom;
		this.fechaNacimiento = fechita;
		this.seguidores = seguidores;
		this.seguidos = seguidos;
		this.imagen = img;
	}

	// getters
	public String getNombre() {
		return this.nombre;
	}

	public String getNick() {
		return this.nick;
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

	public Set<String> getSeguidores() {
		return this.seguidores;
	}

	public Set<String> getSeguidos() {
		return this.seguidos;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setSeguidores(Set<String> seguidores) {
		this.seguidores = seguidores;
	}

	public void setSeguidos(Set<String> seguidos) {
		this.seguidos = seguidos;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
}
