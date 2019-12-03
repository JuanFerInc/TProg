package logica.clases;


import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.annotation.XmlSeeAlso;

import logica.datatypes.DtDocente;
import logica.datatypes.DtInstancia;
import logica.datatypes.DtUsuario;

@XmlSeeAlso(Usuario.class)

public class Docente extends Usuario {
	private Instituto instituto;
	private Map<String, Edicion> Integra;

	// constructores
	public Docente(String nom, String nick, String apel, String correo, Calendar fechita, Instituto instituto,
			String password, String imagen) {
		super(nom, nick, apel, correo, fechita, password, imagen);
		this.instituto = instituto;
		Integra = new HashMap<String, Edicion>();
	}

	public DtUsuario dameDtUsuario() {

		Set<DtInstancia> datosEdicionesIntegra = new HashSet<>();
		for (Map.Entry<String, Edicion> iter : Integra.entrySet()) {
			datosEdicionesIntegra.add(iter.getValue().darDtInstancia());
		}
		instituto.getNombre();

		return new DtDocente(this.getNombre(), this.getNick(), this.getApellido(), this.getCorreo(),
				this.getFechaNacimiento(), datosEdicionesIntegra, this.getImg(), this.listarSeguidores(),
				this.listarSeguidos());
	}

	public void integrarEdicion(Edicion edicion) {
		Integra.put(edicion.getNombre(), edicion);
	}

}
