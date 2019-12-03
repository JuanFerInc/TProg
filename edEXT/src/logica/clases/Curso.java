package logica.clases;

import java.util.*;

import exception.EvaluacionIncorrectaExcep;
import logica.datatypes.DtCurso;
import logica.datatypes.DtCursoDatosyEdiciones;
import logica.datatypes.DtEdicion;
import logica.datatypes.DtInstancia;
import logica.datatypes.Val;

public class Curso implements PC {
	private String nombre,descripcion,URL;
	private int duracion,creditos,horas;
	private Calendar fechaRegistrado;//Fecha que se hace el registro, tiene que ser actualisada antes
	private Map<String,Curso> Previas;//<Nombre,Curso>
	private Map<String,Edicion> Ediciones;//<Nombre,Edicion>
	private Map<String,Programa> ProgramasAsocia;//<Nombre,Programa>
	private Edicion Actual;//Apunta a la edicion actual del curso, no se sabe aun cual es
	private Map<String,Categoria> categorias;
	private String imagen;
	private Map<String,Integer> valoraciones;

	
	//constructores
	public Curso(String nom,String des,String url,int dura,int cred,int horas,Calendar fechita,Map<String,Curso> previa,Map<String,Categoria> categorias, String imagen) {
		this.categorias = categorias;
		this.nombre=nom;
		this.descripcion=des;
		this.URL=url;
		this.duracion=dura;
		this.creditos=cred;
		this.horas=horas;
		this.fechaRegistrado=fechita;
		this.Previas = previa;
		this.Ediciones = new HashMap<String,Edicion>();
		this.ProgramasAsocia = new HashMap<String,Programa>();
		this.Actual = null;
		this.imagen = imagen;
		this.valoraciones = new HashMap<String,Integer>();

		
	}

	//getters
	public String getNombre() {
			return this.nombre;
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
	public Calendar getFecha() {
		return this.fechaRegistrado;
	}
	//setters
	public void setNombre(String nom) {
			this.nombre=nom;
		}
	public void setDescripcion(String des) {
			this.descripcion=des;
		}
	public void setURL(String url) {
			this.URL=url;
		}
	public void setDuracion(int dur) {
			this.duracion=dur;
		}
	public void setCreditos(int cred) {
			this.creditos=cred;
		}
	public void setHoras(int horas) {
			this.horas=horas;
		}
	public void setFechaRegistrado (Calendar fechita) {
			this.fechaRegistrado=fechita;
		}
	
	public void setActual(Edicion edicion) {
		this.Actual = edicion;
	}
	//funciones
	public void asociarPrograma(Programa programa) {
		ProgramasAsocia.put(programa.getNombre(), programa);
	}

	
	public boolean estaVigente() {
		if(Actual != null){
			return true;
		}else{
			return false;
		}
	}

	public DtInstancia darDtEdicionActual() {
		return Actual.darDtInstancia();
	}
	public boolean existeEdicion(String nombreEdicion) {
		if(!Ediciones.containsKey(nombreEdicion)){
			return false;
		}else{
			return true;
		}
	}

	public Set<String> getNombreEdiciones(){
		Set<String> setNombreEdiciones = new HashSet<String>();
		for(Map.Entry<String,Edicion> iterProgramas: Ediciones.entrySet()){
			setNombreEdiciones.add(iterProgramas.getValue().getNombre());
		}
		return setNombreEdiciones;
	}

	public DtInstancia getDtEdicionActual() {
		return Actual.darDtInstancia();
	}

	public Set<String> getProgramasAsociado(){
		Set<String> setNombreProgramas = new HashSet<String>();
		for(Map.Entry<String,Programa> iterProgramas: ProgramasAsocia.entrySet()){
			setNombreProgramas.add(iterProgramas.getValue().getNombre());
		}
		return setNombreProgramas;
	}

	public void asociarmeAPrograma(Programa prog) {
		ProgramasAsocia.put(prog.getNombre(),prog);
	}

	public void asociarmeAEdicion(Edicion edi){
			Ediciones.put( edi.getNombre(),edi);
		}
	public DtCurso getDtCurso(){
		Set<String> setNombreEdiciones = new HashSet<String>();
		Set<String> setNombreProgramas = new HashSet<String>();
		Set<String> setPrevias = new HashSet<String>();
		
		for(Map.Entry<String,Edicion> iterEdicion :Ediciones.entrySet()){
			setNombreEdiciones.add( iterEdicion.getValue().getNombre() );
		}
		for(Map.Entry<String,Programa> iterProgramas: ProgramasAsocia.entrySet()){
			setNombreProgramas.add(iterProgramas.getValue().getNombre());
		}
		for(Map.Entry<String,Curso> iterPrevia :Previas.entrySet()){
			setPrevias.add( iterPrevia.getValue().getNombre() );
		}
		Set<String> cacadevaca = new HashSet<String>();
		for(Map.Entry<String,Categoria> iterPrevia :categorias.entrySet()){
			cacadevaca.add( iterPrevia.getKey());
		}
		String edicionActual = "";
		if(Actual != null) {
			edicionActual = Actual.getNombre();
		}
		DtCurso res = new DtCursoDatosyEdiciones(this.nombre,this.descripcion,this.URL,this.duracion,this.creditos,this.horas,this.fechaRegistrado,setPrevias,setNombreEdiciones,setNombreProgramas,cacadevaca,edicionActual,imagen);
		return res;
	}

	public Edicion getEdicionActual(){
		return Actual;
	}
	
	
	public Edicion getEdicionNoActual(String nombre) {
		return Ediciones.get(nombre);
	}
	
	public Set<String> getCategorias(){
		Set<String> SiSiEsUnLindoGatito = new HashSet<String>();
		for(Map.Entry<String,Categoria> iterCategrias :categorias.entrySet()){
			SiSiEsUnLindoGatito.add( iterCategrias.getValue().getNombre() );
		}
		return SiSiEsUnLindoGatito;
	}
	public Val puedeValorar(String nick) {
		if(valoraciones.containsKey(nick))
			return Val.YAEVALUO;
		for(Map.Entry<String, Edicion> edi: Ediciones.entrySet()) {
			if (edi.getValue().participa(nick));
				return Val.PUEDE;
		}			
		return Val.NOPUEDE;
	}
	
	public void valorar(int valoracion, String nick) throws EvaluacionIncorrectaExcep  {
		if(valoraciones.containsKey(nick))
			throw new EvaluacionIncorrectaExcep("Ya evaluo");
		if(this.puedeValorar(nick) != Val.PUEDE)
			throw new EvaluacionIncorrectaExcep("No esta en ninguna edicion del curso " + this.getNombre());
		if(valoracion <0 || valoracion >5)
			throw new EvaluacionIncorrectaExcep("La valoracion debe ser entre 0 y 5, la enviada es" + Integer.toString(valoracion));
		valoraciones.put(nick, valoracion);
	}
	public int verValoracion(String nick) throws EvaluacionIncorrectaExcep {
		if(valoraciones.containsKey(nick))
			return valoraciones.get(nick);
		throw new EvaluacionIncorrectaExcep("El estudiante no valoro");
	}
	public double verValoracionGlobal() throws EvaluacionIncorrectaExcep {
		if(valoraciones.isEmpty())
			throw new EvaluacionIncorrectaExcep("El curso no tiene valoraciones");
		double retorno =0, muchos =0;  
		for(Map.Entry<String, Integer> entrada:valoraciones.entrySet()) {
			retorno = retorno + entrada.getValue();
			muchos++;
		}
		retorno = retorno/muchos;
		return retorno;
	}
	public void cerrar() {
		this.Actual.cerrar();
		this.Actual = null;
	}
	
	public boolean tengoEdicion(String nombreEdicion) {
		return Ediciones.containsKey(nombreEdicion);
	}


}

