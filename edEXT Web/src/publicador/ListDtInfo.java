
package publicador;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for listDtInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="listDtInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ListDtInfo" type="{http://publicador/}dtInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listDtInfo", propOrder = {
    "listDtInfo"
})
public class ListDtInfo {

    @XmlElement(name = "ListDtInfo", nillable = true)
    protected List<DtInfo> listDtInfo;

    /**
     * Gets the value of the listDtInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listDtInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListDtInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtInfo }
     * 
     * 
     */
    public List<DtInfo> getListDtInfo() {
        if (listDtInfo == null) {
            listDtInfo = new ArrayList<DtInfo>();
        }
        return this.listDtInfo;
    }

}
