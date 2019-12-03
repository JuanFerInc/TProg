package logica.datatypes;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DtEdicion")
public class DtEdicion extends DtInstancia {

	private int cupo;
	private Calendar fechaPublicacion;
	private Set<String> docentesParticipan;
	private boolean borrarBoton;
	private boolean cerrada;

	// constructores
	public DtEdicion() {
		super();
		this.docentesParticipan = new HashSet<String>();
	}
	public DtEdicion(int cupo, Calendar fechaPublicacion, String nom, Calendar inicio, Calendar fin,
			Set<String> docentesParticipan, String fotito, boolean borrarBoton, boolean cerrada) {
		super(nom, inicio, fin, fotito);
		this.cupo = cupo;
		this.fechaPublicacion = fechaPublicacion;
		this.docentesParticipan = docentesParticipan;
		this.borrarBoton = borrarBoton;
		this.cerrada = cerrada;
	}

	// getters
	public int getCupo() {
		return this.cupo;
	}

	public Calendar getFechaPublicacion() {
		return this.fechaPublicacion;
	}

	public Set<String> getDocentesParticipan() {
		return this.docentesParticipan;
	}

	public boolean borrarBotonDeSuscribir() {
		return this.borrarBoton;
	}
	public boolean isBorrarBoton() {
		return borrarBoton;
	}
	public void setBorrarBoton(boolean borrarBoton) {
		this.borrarBoton = borrarBoton;
	}
	public void setCupo(int cupo) {
		this.cupo = cupo;
	}
	public void setFechaPublicacion(Calendar fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	public void setDocentesParticipan(Set<String> docentesParticipan) {
		this.docentesParticipan = docentesParticipan;
	}
}
