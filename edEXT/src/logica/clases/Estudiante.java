package logica.clases;


import java.util.Calendar;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import exception.EdicionNoExisteExcep;
import exception.NoPudoDesinscribirseExcep;
import exception.NoPudoInscribirseExcep;
import exception.NoPudoInscribirseModificarExcep;
import logica.datatypes.DtEstudianteIn;
import logica.datatypes.DtUsuario;


public class Estudiante extends Usuario{
	private Set<Inscripcion> programas;
	private Map<String,Map<Calendar,Inscripcion>> Inscripciones;
	
	
	//constructores
	public Estudiante (String nom,String nick,String apel,String correo,Calendar fechita, String password, String imagen) {
			super(nom,nick,apel,correo,fechita, password, imagen);
			Inscripciones = new HashMap<String,Map<Calendar,Inscripcion>>();
			programas = new HashSet<Inscripcion>();
			
	}

	//funciones
	public void ponerEnPrograma(Inscripcion pre) {
		programas.add(pre);
	}
	
	
	public void inscribirA(Edicion edy, Calendar fecha, String video)throws NoPudoInscribirseExcep {
		int cantidad = 0;
		if(Inscripciones.containsKey(edy.getNombre())) {
			Map<Calendar,Inscripcion> soyelmapa = Inscripciones.get(edy.getNombre());
			for(Map.Entry<Calendar, Inscripcion> i:soyelmapa.entrySet()) {
				if(i.getValue().getEstado().equals("Inscripto") || i.getValue().getEstado().equals("Aceptada"))
					if(i.getValue().getEstado().equals("Inscripto")) {
						throw new NoPudoInscribirseExcep("Ya tiene una inscripcion pendiente o ya fue aceptado");
					}
					throw new NoPudoInscribirseModificarExcep("Ya tiene una inscripcion pendiente o ya fue aceptado");
				
			}
			cantidad = soyelmapa.keySet().size();
		}
		Inscripcion ins = new Inscripcion(edy,fecha, this, cantidad, video);
		Calendar cal = fecha;
		edy.asociateAInscripcion(this.getNick(),ins,cal);
		if(Inscripciones.containsKey(edy.getNombre())) {
			Map<Calendar,Inscripcion> mapita = Inscripciones.get(edy.getNombre());
			mapita.put(cal, ins);
		}else {
			Map<Calendar,Inscripcion> mapita = new HashMap<Calendar,Inscripcion>();
			mapita.put(cal, ins);
			Inscripciones.put(edy.getNombre(), mapita);
		}
		
	}
	
	public void desistir(String nombreEdicion) throws EdicionNoExisteExcep, NoPudoDesinscribirseExcep {
		if(!Inscripciones.containsKey(nombreEdicion)) 
			throw new EdicionNoExisteExcep("El estudiante no tiene una inscripcion a esta edicion");
		Map<Calendar, Inscripcion> mapita = Inscripciones.get(nombreEdicion);
		for(Map.Entry<Calendar, Inscripcion> i: mapita.entrySet()) {
			Inscripcion ins = i.getValue();
			if(ins.getEstado().equals("Inscripto")) {
				ins.kill();
				mapita.remove(ins.getFecha());
				if(mapita.isEmpty()) {
					Inscripciones.remove(nombreEdicion);
				}else {
					Inscripciones.put(nombreEdicion, mapita);
				}
			return;
			}
		}
		throw new NoPudoDesinscribirseExcep("Todas las inscripciones de" + this.getNick() + "a la edicion" + nombreEdicion + "tienen estados finales");
	}
	
	public DtUsuario dameDtUsuario() {
		Map<String,Map<Calendar,String>> mapEdiciones = new HashMap<String,Map<Calendar,String>>();
		Set<String> setProgramas = new HashSet<String>();
		
		for (Map.Entry<String,Map<Calendar,Inscripcion>>iter :Inscripciones.entrySet()){
			for(Map.Entry<Calendar, Inscripcion> i: iter.getValue().entrySet()) {
				if(i.getValue().esPrograma()) {
					setProgramas.add(i.getValue().getNombreInstanciaInscripta());
				}else {
					if(mapEdiciones.containsKey(i.getValue().getNombreInstanciaInscripta())) {
						Map<Calendar,String> mapita = mapEdiciones.get(i.getValue().getNombreInstanciaInscripta());
						mapita.put(i.getKey(), i.getValue().getEstado());
					}else {
						Map<Calendar,String> mapita = new HashMap<Calendar,String>();
						mapita.put(i.getKey(), i.getValue().getEstado());
						mapEdiciones.put(i.getValue().getNombreInstanciaInscripta(),mapita );
					}
				}
			}
		}		
		return new DtEstudianteIn(getNombre(),getNick(),getApellido(),getCorreo(),getFechaNacimiento(),mapEdiciones,setProgramas,this.getImg(), this.listarSeguidores(), this.listarSeguidos());
	}
	


	public boolean estaInscripto(String edicion) {
		if(!Inscripciones.containsKey(edicion)) {
			return true;
		}else {
			Map<Calendar,Inscripcion> mapita = Inscripciones.get(edicion);
			for(Map.Entry<Calendar, Inscripcion> k:mapita.entrySet()) {
				if(!k.getValue().getEstado().equals("Rechazada"))
					return false;
			}
			return true;
		}
	}
	public void modificarInscripcion(String edicion, String video) {
		Map<Calendar,Inscripcion> mapita = Inscripciones.get(edicion);
		for(Map.Entry<Calendar, Inscripcion> ins:mapita.entrySet()) {
			if(ins.getValue().getEstado().equals("Inscripto"))
				ins.getValue().cambiarVideo(video);
		}
	}


}
