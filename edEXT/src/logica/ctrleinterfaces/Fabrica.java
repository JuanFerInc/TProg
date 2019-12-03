package logica.ctrleinterfaces;

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
	
	public interfaceCurso getICurso() {return CtrlCurso.getInstance();};
	public interfaceUsuario getIUsuario() {return CtrlUsuario.getInstance();};
	
	
}
