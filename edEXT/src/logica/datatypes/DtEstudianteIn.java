package logica.datatypes;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;

import logica.capsuleCorp.MapCalendarStringAlgo;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "DtEstudianteIn")
public class DtEstudianteIn extends DtUsuario {
	private Map<String, MapCalendarStringAlgo> mapEdiciones;
	private Set<String> setProgramas;

	// constructores
	public DtEstudianteIn() {
		super();
		this.mapEdiciones = new HashMap<String, MapCalendarStringAlgo>();
		this.setProgramas = new HashSet<String>();
	}

	public DtEstudianteIn(String nom, String nick, String apel, String corr, Calendar fechita,
			Map<String, Map<Calendar, String>> mapEdiciones, Set<String> setProgramas, String img,
			Set<String> seguidores, Set<String> seguidos) {
		super(nom, nick, apel, corr, fechita, img, seguidores, seguidos);

		Map<String, MapCalendarStringAlgo> res = new HashMap<String, MapCalendarStringAlgo>();

		for (Map.Entry<String, Map<Calendar, String>> iter : mapEdiciones.entrySet()) {
			MapCalendarStringAlgo algo = new MapCalendarStringAlgo(iter.getValue());
			res.put(iter.getKey(), algo);

		}

		this.mapEdiciones = res;
		this.setProgramas = setProgramas;
	}

	// getters
	public Set<String> getInscriptoProgramas() {
		return this.setProgramas;
	}

	public Map<String, Map<Calendar, String>> getInscriptoEdiciones() {
		Map<String, Map<Calendar, String>> res = new HashMap<String, Map<Calendar, String>>();
		for (Map.Entry<String, MapCalendarStringAlgo> iter : this.mapEdiciones.entrySet()) {
			res.put(iter.getKey(), iter.getValue().getMapita());
		}
		return res;
	}

	public Set<String> getInscriptoInstancias() {
		Set<String> retorno = this.getInscriptoProgramas();
		for (String k : mapEdiciones.keySet()) {
			retorno.add(k);
		}
		return retorno;
	}


	public void setMapEdiciones(Map<String, Map<Calendar, String>> mapEdiciones) {
		Map<String, MapCalendarStringAlgo> res = new HashMap<String, MapCalendarStringAlgo>();

		for (Map.Entry<String, Map<Calendar, String>> iter : mapEdiciones.entrySet()) {
			MapCalendarStringAlgo algo = new MapCalendarStringAlgo(iter.getValue());
			res.put(iter.getKey(), algo);

		}
		this.mapEdiciones = res;
	}

	public Set<String> getSetProgramas() {
		return setProgramas;
	}

	public void setSetProgramas(Set<String> setProgramas) {
		this.setProgramas = setProgramas;
	}

}
