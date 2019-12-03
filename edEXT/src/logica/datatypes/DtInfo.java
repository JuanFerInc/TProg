package logica.datatypes;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtInfo {
	private String nick, edicion, estado;
	private double prio;
	private Calendar fechaInscripcion;

	public DtInfo(String nick, String edicion, String estado) {
		this.nick = nick;
		this.edicion = edicion;
		this.estado = estado;
		this.prio = -1;
	}

	public DtInfo(String nick, String edicion, String estado, Calendar fechaInscripcion) {
		this.nick = nick;
		this.edicion = edicion;
		this.estado = estado;
		this.prio = -1;
		this.fechaInscripcion = fechaInscripcion;
	}

	public DtInfo(String nick, String edicion, String estado, double prio) {
		this.nick = nick;
		this.edicion = edicion;
		this.estado = estado;
		this.prio = prio;
	}

	public String getNick() {
		return this.nick;
	}

	public Calendar getFechaInscirpcion() {
		return this.fechaInscripcion;
	}

	

	public String getEstado() {
		return this.estado;
	}

	public double getPrio() {
		return this.prio;
	}

	public String getEdicion() {
		return edicion;
	}

	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}

	public Calendar getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(Calendar fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setPrio(double prio) {
		this.prio = prio;
	}

}