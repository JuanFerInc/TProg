package logica.capsuleCorp;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class MapStringIntegerAlgo {
	private Map<String, Integer> mapStringInteger;

	public MapStringIntegerAlgo() {
		this.mapStringInteger = new HashMap<String, Integer>();
	}

	public MapStringIntegerAlgo(Map<String, Integer> mapStringInteger) {
		this.mapStringInteger = mapStringInteger;
	}

	public Map<String, Integer> getMapStringInteger() {
		return mapStringInteger;
	}

	public void setMapStringInteger(Map<String, Integer> mapStringInteger) {
		this.mapStringInteger = mapStringInteger;
	}

}
