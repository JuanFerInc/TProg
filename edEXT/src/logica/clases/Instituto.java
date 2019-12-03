package logica.clases;

import java.util.*;
import java.util.Set;


public class Instituto {
	private String nombre;
	private Map<String,Curso> Cursos;

	//constructor
	public Instituto(String nom) {
		this.nombre=nom;
		Cursos = new HashMap<String,Curso>();
	}
	//getters
	public String getNombre() {
		return this.nombre;
	}
	//setters
	public void setNombre(String nom) {
		this.nombre=nom;
	}
	//funciones
	public void asociarCurso(Curso curse) {
		Cursos.put(curse.getNombre(),curse);
	}

	//Devuelve un set vacio si el instituto no contiene cursos
	public Set<String> cursosEnInstituto() {
		Set<String> resSet = new HashSet<String>();

		if(!Cursos.isEmpty()){
			for(Map.Entry<String,Curso>iter : Cursos.entrySet()){
				resSet.add(iter.getValue().getNombre());
			}

		}else{

		}
		return resSet;
	}
}



