package logica.capsuleCorp;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ListString {
	private List<String> ListString;

	public ListString() {
		this.ListString = new ArrayList<String>();
	}

	public ListString(List<String> listString) {
		super();
		ListString = listString;
	}

	public List<String> getListString() {
		return ListString;
	}

	public void setListString(List<String> listString) {
		ListString = listString;
	}

}
