package logica.clases;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import exception.EvaluacionIncorrectaExcep;
import logica.datatypes.DtComentario;

public class Comentario {
	private int id;
	private String texto;
	private String autor;
	private Map<Integer,Comentario> respuestas;
	
	public Comentario(String texto, String autor, int id) {
		this.id = id;
		this.texto = texto;
		this.autor = autor;
		this.respuestas = new HashMap<Integer,Comentario>();
	}
	public int getId() {
		return this.id;
	}
	public DtComentario darDatatype(Curso cursillo) {
		Set<DtComentario> setsito = new HashSet<DtComentario>();
		for(Map.Entry<Integer, Comentario> entrada:respuestas.entrySet()) {
			setsito.add(entrada.getValue().darDatatype(cursillo));
		}
		
		try {
			return new DtComentario(this.id, this.texto, this.autor, setsito,cursillo.verValoracion(this.autor));			
		}catch(EvaluacionIncorrectaExcep excepcion) {
			return new DtComentario(this.id, this.texto, this.autor, setsito,-1);
		}
	}
	public void responder(Comentario respuesta) {
		respuestas.put(respuesta.getId(), respuesta);
	}
	
}
