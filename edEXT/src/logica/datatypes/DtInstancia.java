package logica.datatypes;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({DtPrograma.class,DtEdicion.class})
public class DtInstancia {

	private String nombre;
	private Calendar inicio, fin;
	private String fotito;

	// constructores
	public DtInstancia() {

	}

	public DtInstancia(String nom, Calendar inicio, Calendar fin, String fotito) {
		this.nombre = nom;
		this.inicio = inicio;
		this.fin = fin;
		this.fotito = fotito;
	}

	// getters
	public String getNombre() {
		return this.nombre;
	}

	public String getFoto() {
		return this.fotito;
	}

	public Calendar getInicio() {
		return this.inicio;
	}

	public Calendar getFin() {
		return this.fin;
	}

	public String getFotito() {
		return fotito;
	}

	public void setFotito(String fotito) {
		this.fotito = fotito;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setInicio(Calendar inicio) {
		this.inicio = inicio;
	}

	public void setFin(Calendar fin) {
		this.fin = fin;
	}
}
