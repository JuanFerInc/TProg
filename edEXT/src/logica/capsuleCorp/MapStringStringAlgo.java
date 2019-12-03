package logica.capsuleCorp;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class MapStringStringAlgo {
	private Map<String, String> mapita;

	public MapStringStringAlgo() {
		this.mapita = new HashMap<String, String>();
	}

	public MapStringStringAlgo(Map<String, String> mapita) {
		this.mapita = mapita;
	}

	public Map<String, String> getMapStringString() {
		return mapita;
	}

	public void setMapStringString(Map<String, String> mapita) {
		this.mapita = mapita;
	}

}
