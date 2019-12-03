
package publicador;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for listInteger complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="listInteger">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="listInteger" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listInteger", propOrder = {
    "listInteger"
})
public class ListInteger {

    @XmlElement(nillable = true)
    protected List<Integer> listInteger;
    public ListInteger() {
    	this.listInteger = new ArrayList<Integer>();
    }
    public ListInteger(List<Integer> lista) {
    	this.listInteger = lista;
    }
    
    /**
     * Gets the value of the listInteger property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listInteger property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListInteger().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getListInteger() {
        if (listInteger == null) {
            listInteger = new ArrayList<Integer>();
        }
        return this.listInteger;
    }

}
