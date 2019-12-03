package logica.datatypes;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import logica.clases.Comentario;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtComentario {
	private int id;
	private String texto;
	private String autor;
	private Set<DtComentario> respuestas;
	private int valoracionDelCurso;

	public DtComentario(int id, String texto, String autor, Set<DtComentario> respuestas, int valoracion) {
		this.id = id;
		this.texto = texto;
		this.autor = autor;
		this.valoracionDelCurso=valoracion;
		this.respuestas = new HashSet<DtComentario>();
		this.respuestas = respuestas;
	}
	public int getId() {
		return this.id;
	}
	public String getTexto() {
		return this.texto;
	}
	public String getAutor() {
		return this.autor;
	}
	public Set<DtComentario> getRespuestas() {
		return this.respuestas;
	}
	
	//Devuelve -1 si no tiene nada 
	public int getValoracion() {
		return this.valoracionDelCurso;
	}
	
}
