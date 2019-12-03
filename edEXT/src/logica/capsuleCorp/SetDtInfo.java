package logica.capsuleCorp;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import logica.datatypes.DtInfo;

@XmlAccessorType(XmlAccessType.FIELD)
public class SetDtInfo {
	private Set<DtInfo> SetDtInfo;

	public SetDtInfo() {
		this.SetDtInfo = new HashSet<DtInfo>();

	}

	public SetDtInfo(Set<DtInfo> SetDtInfo) {
		this.SetDtInfo = SetDtInfo;
	}

	public Set<DtInfo> getSetDtInfo() {
		return SetDtInfo;
	}

	public void setSetDtInfo(Set<DtInfo> setDtInfo) {
		SetDtInfo = setDtInfo;
	}
}
