package logica.datatypes;

import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;

import java.util.Calendar;
import java.util.HashSet;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({DtCursoDatosyEdiciones.class})
public class DtCurso {
	
	private String nombre,descripcion,URL;
	private int duracion,creditos,horas;
	private Calendar fechaRegistrado;
	private Set<String> previas;
	private Set<String> ediciones;
	private Set<String> programas;
	private String edicionActual;
	private Set<String> categorias;
	private String imagen;
		//constructores
	public DtCurso() {
		this.previas = new HashSet<>();
		this.ediciones = new HashSet<>();
		this.programas = new HashSet<>();
		this.categorias = new HashSet<>();
	}
	public DtCurso(String nom,String des,String url,int dura,int cred,int horas,Calendar fechaRegistrado,Set<String> previas, Set<String> categorias,String edicionActual, String imagen) {
			this.categorias = categorias;
			this.nombre=nom;
			this.descripcion=des;
			this.URL=url;
			this.duracion=dura;
			this.creditos=cred;
			this.horas=horas;
			this.fechaRegistrado=fechaRegistrado;
			this.previas = previas;
			this.edicionActual = edicionActual;
			this.imagen= imagen;
		}
		//getters
	public String getNombre() {
			return this.nombre;
		}
	public Set<String> getCategorias(){
		return this.categorias;
	}
	public String getDescripcion() {
			return this.descripcion;
		}
	public String getURL() {
			return this.URL;
		}
	public int getDuracion() {
			return this.duracion;
		}
	public int getCreditos() {
			return this.creditos;
		}
	public int getHoras() {
			return this.horas;
		}
	public Calendar getFechaRegistrado() {
			return this.fechaRegistrado;
		}
	public Set<String> getPrevias(){
		return this.previas;
	}
	public Set<String> getEdiciones(){
		return this.ediciones;
	}
	public String getEdicionActual() {
		return this.edicionActual;
	}
	public Set<String> getProgramas(){
		return this.programas;
	}
	public String getImagen() {
		return imagen;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public void setFechaRegistrado(Calendar fechaRegistrado) {
		this.fechaRegistrado = fechaRegistrado;
	}
	public void setPrevias(Set<String> previas) {
		this.previas = previas;
	}
	public void setEdiciones(Set<String> ediciones) {
		this.ediciones = ediciones;
	}
	public void setProgramas(Set<String> programas) {
		this.programas = programas;
	}
	public void setEdicionActual(String edicionActual) {
		this.edicionActual = edicionActual;
	}
	public void setCategorias(Set<String> categorias) {
		this.categorias = categorias;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

}
