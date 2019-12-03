package logica.clases;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import exception.UsuarioRepetidoExcep;
import logica.datatypes.DtInstancia;
import logica.datatypes.DtPrograma;

public class Programa extends Instancia implements PC{
	private	String descripcion;
	private Map<String,Curso> Cursos;//<Nombre,Curso>
	private Calendar fechaAlta;
	private Map<String, Inscripcion> Estudiantes; 
	//constructores
	
	//Parametros: Descripcion, Nombre, Fecha inicio, Fecha fin
	public Programa(String des,String nom,Calendar inicio,Calendar fin, Calendar fechaAlta, String img) {
		super(nom,inicio,fin,img);
		this.descripcion=des;
		Cursos = new HashMap<String,Curso>();
		this.fechaAlta = fechaAlta;
		Estudiantes = new HashMap<String,Inscripcion>();
	}
	//getters
	public String getDescripcion() {
		return this.descripcion;
	}
	public Calendar getFecha() {
		return this.fechaAlta;
	}

	//setters
	public void setDescripcion(String des) {
		this.descripcion=des;
	}
	
	
	//Devuelve el nombre de todos los crusos que intengar
	//el programa
	public Set<String> getCurso() {
		Set<String> nombreCursos = new HashSet<String>();
		for(Map.Entry<String,Curso>iter: Cursos.entrySet()) {
			nombreCursos.add(iter.getValue().getNombre());
		}
		
		return nombreCursos;
	}

	public DtInstancia darDtInstancia() {
		Set<String> setNombreCursos = new HashSet<String>();

		for(Map.Entry<String, Curso> iter : Cursos.entrySet()){
			setNombreCursos.add(iter.getValue().getNombre());
		}
		return new DtPrograma(descripcion,getNombre(),getFechaInicio(),getFechaFin(),setNombreCursos,this.fechaAlta,this.getCategorias(), this.getImagen());
	}

	//Agrega el Curso c a la coleccion de Cursos que integran
	//el programa
	public void asociarCurso(Curso cures) {
		Cursos.put(cures.getNombre(), cures);
		cures.asociarPrograma(this);
	}
	public Set<String> getCategorias(){
		Set<String> creoQueEVistoUnLindoGatito = new HashSet<String>();
		Set<String> cat = new HashSet<String>();
		
		for(Map.Entry<String,Curso> iterCursos :Cursos.entrySet()){
			cat =  iterCursos.getValue().getCategorias();
			
			for(String SiSiEsUnLindoGatito :cat ) {
				creoQueEVistoUnLindoGatito.add(SiSiEsUnLindoGatito);
				
			}
		}
		return creoQueEVistoUnLindoGatito;
	}
	public Inscripcion agregarEstudiante(Estudiante estu) throws UsuarioRepetidoExcep{
		if(Estudiantes.containsKey(estu.getNick())) 
			throw new UsuarioRepetidoExcep("El usuario ya esta inscripto");
		Inscripcion ins = new Inscripcion(this,estu, new GregorianCalendar());
		Estudiantes.put(estu.getNick(), ins);
		return ins;
	}
	public Set<String> darInscriptos() {
		Set<String> retorno = new HashSet<String>();
		for(Map.Entry<String, Inscripcion> e:Estudiantes.entrySet())
			retorno.add(e.getValue().getUserInscripto().getNick());
		return retorno;
	}
}
