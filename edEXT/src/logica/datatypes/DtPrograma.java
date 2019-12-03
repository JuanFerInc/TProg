package logica.datatypes;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DtPrograma")
public class DtPrograma extends DtInstancia {
	private String descripcion;
	private Set<String> cursos;
	private Set<String> categorias;
	private Calendar fechaAlta;

	// constructores
	public DtPrograma() {
		super();
		this.cursos = new HashSet<String>();
		this.categorias = new HashSet<String>();
	}

	public DtPrograma(String des, String nom, Calendar inicio, Calendar fin, Set<String> cursos, Calendar fechaAlta,
			Set<String> categorias, String fotito) {
		super(nom, inicio, fin, fotito);
		this.cursos = cursos;
		this.descripcion = des;
		this.fechaAlta = fechaAlta;
		this.categorias = categorias;
	}

	// getters
	public String getDescripcion() {
		return this.descripcion;
	}

	public Set<String> getCursos() {
		return this.cursos;
	}

	public Calendar getAlta() {
		return fechaAlta;
	}

	public Set<String> getCategorias() {
		return this.categorias;
	}

	public Set<String> getcursos() {
		return cursos;
	}

	public void setcursos(Set<String> cursos) {
		this.cursos = cursos;
	}

	public Calendar getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Calendar fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setCategorias(Set<String> categorias) {
		this.categorias = categorias;
	}
}
