package logica.clases;

import java.util.Calendar;
import java.util.GregorianCalendar;

import exception.EdicionNoExisteExcep;
import exception.EstudianteSinEvaluarExcep;
import exception.NoPudoInscribirseExcep;
import exception.UsuarioNoExisteExcep;


public class Inscripcion {
	
	private Calendar fecha;
	private Instancia InstanciaInscripta;
	private Usuario userInscripto;
	private String estadoInsc;
	private double prioridad;
	private String video;
	private Integer nota;
	
	//Constructor
	
	//getter
	public Inscripcion(Programa prog, Usuario user, Calendar fecha) {
		this.estadoInsc = "Inscripto";
		this.fecha = fecha;
		this.userInscripto = user;
		this.InstanciaInscripta = prog;
	}
	
	public Inscripcion(Edicion ese, Calendar fecha, Usuario user, int prioridad, String presentacion) {
		this.InstanciaInscripta = ese;
		this.fecha = fecha;
		this.userInscripto = user;
		this.estadoInsc = "Inscripto";
		this.prioridad = 0.5 * prioridad;
		if(presentacion.isEmpty())
			this.video = null;
		else
			this.video = presentacion;
		this.nota = -1;
	}
	public String getEstado() {
		return this.estadoInsc;
	}
	
	public Integer getNota(boolean mandar) {
		if(mandar)
			return this.nota;
		else
			return -1;
	}
	public String getVideo() throws UsuarioNoExisteExcep {
		if(this.video == null)
			throw new UsuarioNoExisteExcep("pepe");
		return this.video;
	}
	
	public double getPrioridad(){
		return this.prioridad;
	}
	public void aceptarInscripcion() throws NoPudoInscribirseExcep {
		Edicion edy = (Edicion) this.InstanciaInscripta;
		edy.aceptarUnFlaco();
		this.estadoInsc = "Aceptada";
	}
	public void rechazarInscripcion() {
		this.estadoInsc = "Rechazada";
	}
	
	public Calendar getFecha() {
		return fecha;
	}
	//setter
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	public boolean esPrograma() {
		return (InstanciaInscripta instanceof Programa);
	}

	public String getNombreInstanciaInscripta(){
		return InstanciaInscripta.getNombre();
	}
	/*public void asociarInscripcion(Estudiante estudiante, Edicion e) {
		e.asociateInscripcion(this);
	}*/
	
	
	//Para los nuevos cdu
	public void cambiarVideo(String video) {
		this.video = video;
	}
	public Usuario getUserInscripto() {
		return this.userInscripto;
	}
	public Instancia getInscripcion() {
		return this.InstanciaInscripta;
	}
	public void kill() throws EdicionNoExisteExcep {
		if(this.InstanciaInscripta instanceof Programa)
			throw new EdicionNoExisteExcep("No es una edicion");
		Edicion ed = (Edicion) this.InstanciaInscripta;
		try {
			ed.desinscribir(userInscripto.getNick());
		} catch (UsuarioNoExisteExcep e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setNota(Integer nota) {
		this.nota = nota;
	}
	
}
