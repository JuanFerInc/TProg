package logica.capsuleCorp;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class SetString {
	private Set<String> setString;

	public SetString() {
		setString = new HashSet<String>();
	}

	public SetString(Set<String> setString) {
		this.setString = setString;
	}

	public Set<String> getSetString() {
		return setString;
	}

	public void setSetString(Set<String> setString) {
		this.setString = setString;
	}

}
