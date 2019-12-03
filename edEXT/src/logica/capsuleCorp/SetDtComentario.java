package logica.capsuleCorp;

import java.util.HashSet;
import java.util.Set;

import logica.datatypes.DtComentario;

public class SetDtComentario {
	private Set<DtComentario> setDtComentario;
	
	public SetDtComentario() {
		this.setDtComentario = new HashSet<DtComentario>();
	}
	public SetDtComentario(Set<DtComentario> setDtComen) {
		this.setDtComentario = setDtComen;
	}
	public Set<DtComentario> getSetDtComentario() {
		return this.setDtComentario;
	}
	public void setSetDtComentario(Set<DtComentario> setDtComen) {
		this.setDtComentario = setDtComen;
	}
	
}
