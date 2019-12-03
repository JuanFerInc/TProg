package logica.capsuleCorp;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import logica.datatypes.DtInfo;

@XmlAccessorType(XmlAccessType.FIELD)
public class ListDtInfo {
	private List<DtInfo> ListDtInfo;

	public ListDtInfo() {
		this.ListDtInfo = new ArrayList<DtInfo>();
	}

	public ListDtInfo(List<DtInfo> listDtInfo) {

		ListDtInfo = listDtInfo;
	}

	public List<DtInfo> getListDtInfo() {
		return ListDtInfo;
	}

	public void setListDtInfo(List<DtInfo> listDtInfo) {
		ListDtInfo = listDtInfo;
	}

}
