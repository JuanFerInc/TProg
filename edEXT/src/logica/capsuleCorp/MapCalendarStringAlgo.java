package logica.capsuleCorp;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class MapCalendarStringAlgo {
	private Map<Calendar,String> mapita;
	
	public MapCalendarStringAlgo() {
		 this.mapita  = new HashMap<Calendar,String>();
	}
	public MapCalendarStringAlgo(Map<Calendar, String> mapita) {
		super();
		this.mapita = mapita;
	}

	public Map<Calendar, String> getMapita() {
		return mapita;
	}

	public void setMapita(Map<Calendar, String> mapita) {
		this.mapita = mapita;
	}
	
}
