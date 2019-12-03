
package publicador;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for setDtComentario complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="setDtComentario">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="setDtComentario" type="{http://publicador/}dtComentario" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setDtComentario", propOrder = {
    "setDtComentario"
})
public class SetDtComentario {

    @XmlElement(nillable = true)
    protected List<DtComentario> setDtComentario;

    /**
     * Gets the value of the setDtComentario property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the setDtComentario property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSetDtComentario().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtComentario }
     * 
     * 
     */
    public List<DtComentario> getSetDtComentario() {
        if (setDtComentario == null) {
            setDtComentario = new ArrayList<DtComentario>();
        }
        return this.setDtComentario;
    }

}
