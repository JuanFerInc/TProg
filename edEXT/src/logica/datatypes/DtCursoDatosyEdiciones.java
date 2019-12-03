package logica.datatypes;

import java.util.Calendar;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "DtCursoDatosyEdiciones")
public class DtCursoDatosyEdiciones extends DtCurso {
	private Set<String> ediciones;
	private Set<String> programas;

	// constructores
	public DtCursoDatosyEdiciones() {
		super();
		this.ediciones = new HashSet<>();
		this.programas = new HashSet<>();
	}
	public DtCursoDatosyEdiciones(String nom, String des, String url, int dura, int cred, int horas,
			Calendar fechaRegistrado, Set<String> previas, Set<String> edi, Set<String> prog, Set<String> categorias,
			String edicionActual, String imagen) {
		super(nom, des, url, dura, cred, horas, fechaRegistrado, previas, categorias, edicionActual, imagen);
		this.ediciones = edi;
		this.programas = prog;
	}

	// getters
	public Set<String> getEdiciones() {
		return this.ediciones;
	}

	public Set<String> getProgramas() {
		return this.programas;
	}

	public void setEdiciones(Set<String> ediciones) {
		this.ediciones = ediciones;
	}

	public void setProgramas(Set<String> programas) {
		this.programas = programas;
	}

}