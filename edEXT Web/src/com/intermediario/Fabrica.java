package com.intermediario;



public class Fabrica {

	private static Fabrica instancia = null;
	
	private Fabrica() {
		
	}
	
	public static Fabrica getInstancia() {
		if(instancia == null) {
		instancia = new Fabrica();
		}
		return instancia;
		};
	
	public interfaceCurso getICurso() {
		return new interfaceCurso();
		};

	public interfaceUsuario getIUsuario() {
		return new interfaceUsuario();
	};

}
