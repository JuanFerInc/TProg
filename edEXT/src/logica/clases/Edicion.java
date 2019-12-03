package logica.clases;

import java.util.*;

import exception.EstadoEsFinalExcep;
import exception.EstudianteSinEvaluarExcep;
import exception.NoPudoInscribirseExcep;
import exception.NoSePudoResponderExcep;
import exception.UsuarioNoExisteExcep;
import logica.datatypes.DtComentario;
import logica.datatypes.DtEdicion;
import logica.datatypes.DtInfo;
import logica.datatypes.DtInstancia;

public class Edicion extends Instancia{
	private int cupo;
	private int aceptados;
	private Calendar fechaPublicacion;
	private Map<String,Map<Calendar,Inscripcion>> alumnosInscriptos;
	private Map<String,Docente> docentesParticipan;
	private boolean cerrado;
	private boolean borrarElBotonDeSuscribir;
	private Set<Comentario> primerNivel;
	private Map<Integer,Comentario> comentarios;
	private Integer generador;
	
		//constructores
	public Edicion(int cupo,Calendar fechaPublicacion,String nom,Calendar inicio,Calendar fin, Map<String,Docente> docentesParticipan,String foto) {
			super(nom, inicio, fin,foto);
			this.cupo=cupo;
			this.fechaPublicacion=fechaPublicacion;
			this.alumnosInscriptos = new HashMap<String,Map<Calendar,Inscripcion>>();
			this.docentesParticipan = docentesParticipan;
			this.cerrado = false;
			this.primerNivel = new HashSet<Comentario>();
			this.comentarios = new HashMap<Integer,Comentario>();
			this.generador = 0;
			this.borrarElBotonDeSuscribir = false;
		}
	
	
	public void setCerrada() {
		this.cerrado=true;
	}

	public boolean estaCerrado() {
		return this.cerrado;
	}
	public void cerrar() {
		this.cerrado = true;
	}
	public String getVideo(String nick) throws UsuarioNoExisteExcep {
		Map<Calendar,Inscripcion> mapita = alumnosInscriptos.get(nick);
		for(Map.Entry<Calendar, Inscripcion> ins: mapita.entrySet()) {
			//if(ins.getValue().getEstado().equals("Inscripto"))
				return ins.getValue().getVideo();
		}
		throw new UsuarioNoExisteExcep("El usuario " +nick+ " no esta inscripto");
	}
	
	public DtInstancia darDtInstancia() {
		Set<String> resDocente = new HashSet<String>();
		for(Map.Entry<String, Docente> iter : docentesParticipan.entrySet()) {
			resDocente.add(iter.getValue().getNick());
		}
		return new DtEdicion(cupo,fechaPublicacion,getNombre(),getFechaInicio(),getFechaFin(),resDocente,this.getImagen(), borrarElBotonDeSuscribir, cerrado);
	}
	//No se si estas dos son la misma
	public boolean inscribirEstudiante(Estudiante estudiante) {
		return alumnosInscriptos.containsKey(estudiante.getNick());
	}
	
	public void asociateAInscripcion(String nick, Inscripcion ins,Calendar cal) {
		if(alumnosInscriptos.containsKey(nick)) {
			Map<Calendar,Inscripcion> mapita = alumnosInscriptos.get(nick);
			mapita.put(cal, ins);
		}else {
			Map<Calendar,Inscripcion> mapita = new HashMap<Calendar,Inscripcion>();
			mapita.put(cal, ins);
			alumnosInscriptos.put(nick, mapita);
		
		}
	}
	//Para el nuevo cdu
	public Set<DtInfo> listarInscriptos(){
		Set<DtInfo> set = new HashSet<DtInfo>();
		for(Map.Entry<String, Map<Calendar,Inscripcion>> temp: alumnosInscriptos.entrySet()) {
			for(Map.Entry<Calendar, Inscripcion> entradita: temp.getValue().entrySet()) {
				DtInfo info = new DtInfo(entradita.getValue().getUserInscripto().getNick(),entradita.getValue().getNombreInstanciaInscripta(),entradita.getValue().getEstado());
				set.add(info);
			}
		}
		return set;
	}
	public Set<DtInfo> listarInscriptoscnFecha(){
		Set<DtInfo> set = new HashSet<DtInfo>();
		for(Map.Entry<String, Map<Calendar,Inscripcion>> temp: alumnosInscriptos.entrySet()) {
			for(Map.Entry<Calendar, Inscripcion> entradita: temp.getValue().entrySet()) {
				DtInfo info = new DtInfo(entradita.getValue().getUserInscripto().getNick(),entradita.getValue().getNombreInstanciaInscripta(),entradita.getValue().getEstado(),entradita.getValue().getFecha());
				set.add(info);
			}
		}
		return set;
	}
	
	public void cambiameA(String estado, String nick) throws EstadoEsFinalExcep, NoPudoInscribirseExcep{
		Map<Calendar,Inscripcion> mapita = alumnosInscriptos.get(nick);
		Inscripcion temp = null;
		for(Map.Entry<Calendar, Inscripcion>i: mapita.entrySet()) {
			if(i.getValue().getEstado().equals("Inscripto"))
				temp = i.getValue();
		}
		if(temp == null)
			throw new EstadoEsFinalExcep("No tiene inscripcion pendiente");
		else {
			if(estado.equals("Aceptada") || estado.equals("Aceptado")) {
				temp.aceptarInscripcion();
			}else {
				temp.rechazarInscripcion();
			}
		}
	}
	public void aceptarUnFlaco() throws NoPudoInscribirseExcep{
		if(aceptados < cupo || cupo ==-1 )
			aceptados++;
		else 
			throw new NoPudoInscribirseExcep("No habian cupos");
	}
	
	
	
	//Se podría pasar a una funcion que devuelva también la nota si hay
	public Map<String,Calendar> listarAceptados(){
		Map<String,Calendar> retornito = new HashMap<String,Calendar>();
		for(Map.Entry<String, Map<Calendar,Inscripcion>> temp: alumnosInscriptos.entrySet()) {
			for(Map.Entry<Calendar, Inscripcion> i:temp.getValue().entrySet()) {
				if(i.getValue().getEstado().equals("Aceptada")){
					retornito.put(i.getValue().getUserInscripto().getNick(),i.getKey());		
				}
			}
		}					
		
		return retornito;
	}
	
	public List<Inscripcion> getList(){
		List<Inscripcion> retorno = new ArrayList<Inscripcion>();
		for(Map.Entry<String,Map<Calendar,Inscripcion>> i: alumnosInscriptos.entrySet()) {
			for(Map.Entry<Calendar, Inscripcion> j: i.getValue().entrySet()) {
				retorno.add(j.getValue());
			}
		}
		return retorno;
	}
	
	//Solo usada a traves de inscripcion
	public void desinscribir(String nick) throws UsuarioNoExisteExcep{
		if(!alumnosInscriptos.containsKey(nick))
			throw new UsuarioNoExisteExcep("No esta inscripto");
		Map<Calendar,Inscripcion> mapita = alumnosInscriptos.get(nick);
		for(Map.Entry<Calendar, Inscripcion> mpa: mapita.entrySet())
			if(mpa.getValue().getEstado().equals("Inscripto"))
				mapita.remove(mpa.getKey());
		if(mapita.isEmpty())
			alumnosInscriptos.remove(nick);
		else
			alumnosInscriptos.put(nick, mapita);
	}
	
	public void evaluar(Map<String,Integer> notas) throws EstudianteSinEvaluarExcep {
		boolean encontre;
		this.borrarElBotonDeSuscribir = true;
		for(Map.Entry<String, Integer> entry: notas.entrySet()) {
			encontre = false;
			Map<Calendar,Inscripcion> mapita = alumnosInscriptos.get(entry.getKey());
			for(Map.Entry<Calendar, Inscripcion> ent: mapita.entrySet()) {
				if(ent.getValue().getEstado().equals("Aceptada")) {
					ent.getValue().setNota(entry.getValue());
					encontre = true;
					break;
				}
			}
			if(!encontre)
				throw new EstudianteSinEvaluarExcep("Falta el estudiante" + entry.getKey());
		}
	}
	
	public int getNota(String nombre, boolean siosi) throws UsuarioNoExisteExcep {
		Map<Calendar,Inscripcion> mapita = alumnosInscriptos.get(nombre);
		for(Map.Entry<Calendar, Inscripcion> est:mapita.entrySet()){
			if(est.getValue().getEstado().equals("Aceptada"))
				return est.getValue().getNota(siosi||this.cerrado);
		}
		throw new UsuarioNoExisteExcep("El estudiante " + nombre + " no tiene una inscripcion a la edicion" + this.getNombre());
	}
	public boolean participa(String nick) {
		return (alumnosInscriptos.containsKey(nick));
	}
	public void comentar(String texto, String autor) throws NoSePudoResponderExcep {
		if(!alumnosInscriptos.containsKey(autor))
			throw new NoSePudoResponderExcep("El estudiante " + autor + " no pertenece a la edicion " + this.getNombre());
		Comentario nuevo = new Comentario(texto, autor, this.generador);
		this.primerNivel.add(nuevo);
		this.comentarios.put(nuevo.getId(), nuevo);
		this.generador++;
	}
	public void comentar(String texto, String autor, Integer respondido) throws NoSePudoResponderExcep {
		if(!alumnosInscriptos.containsKey(autor))
			throw new NoSePudoResponderExcep("El estudiante " + autor + " no pertenece a la edicion " + this.getNombre());
		Comentario nuevo = new Comentario(texto, autor, this.generador);
		if(!comentarios.containsKey(respondido))
			throw new NoSePudoResponderExcep("El comentario al que se quiere responder no existe");
		Comentario viejo = comentarios.get(respondido);
		viejo.responder(nuevo);
		this.comentarios.put(nuevo.getId(), nuevo);
		this.generador++;
	}
	
	public Set<DtComentario> getPrimerNivel(Curso cursillo){
		Set<DtComentario> retorno = new HashSet<DtComentario>();
		for(Comentario com: primerNivel) {
			retorno.add(com.darDatatype(cursillo));
		}
		return retorno;
	}
}



