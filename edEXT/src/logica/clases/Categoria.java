package logica.clases;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Categoria {
	private String nombre;
	public Categoria(String nombresito) {
		this.nombre = nombresito;
		cursitos = new HashMap<String,Curso>();
	}
	
	private Map<String,Curso> cursitos;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
		
	}

	public void addCurso(Curso cursillo) {
		cursitos.put(cursillo.getNombre(), cursillo);
	}

	public Set<String> getMierdasDeTarea2(){
			Set<String> resSet = new HashSet<String>();

			if(!cursitos.isEmpty()){
				for(Map.Entry<String,Curso>iter : cursitos.entrySet()){
					resSet.add(iter.getValue().getNombre());
				}
			}
			return resSet;
	}
}
