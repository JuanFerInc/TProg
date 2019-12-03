package logica.capsuleCorp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import logica.datatypes.DtEstudianteIn;

@XmlAccessorType(XmlAccessType.FIELD)
public class CositaDeEstudiante {
	private DtEstudianteIn loquito;

	public CositaDeEstudiante() {
		this.loquito = null;
	}

	public CositaDeEstudiante(DtEstudianteIn loquito) {
		this.loquito = loquito;
	}

	public DtEstudianteIn getLoquito() {
		return loquito;
	}

	public void setLoquito(DtEstudianteIn loquito) {
		this.loquito = loquito;
	}
}
