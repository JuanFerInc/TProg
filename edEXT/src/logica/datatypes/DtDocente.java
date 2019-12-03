package logica.datatypes;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "DtDocente")
public class DtDocente extends DtUsuario {
	private Set<DtInstancia> datosEdicionesIntegra;

	// constructores
	public DtDocente() {
		super();
		this.datosEdicionesIntegra = new HashSet<DtInstancia>();
	}

	public DtDocente(String nom, String nick, String apel, String corr, Calendar fechita,
			Set<DtInstancia> datosEdicionesIntegra, String img, Set<String> seguidores, Set<String> seguidos) {
		super(nom, nick, apel, corr, fechita, img, seguidores, seguidos);
		this.datosEdicionesIntegra = datosEdicionesIntegra;
	}

	// getters
	public Set<DtInstancia> getRegistroInstancias() {
		return this.datosEdicionesIntegra;
	}

	public Set<DtInstancia> getDatosEdicionesIntegra() {
		return datosEdicionesIntegra;
	}

	public void setDatosEdicionesIntegra(Set<DtInstancia> datosEdicionesIntegra) {
		this.datosEdicionesIntegra = datosEdicionesIntegra;
	}

}
