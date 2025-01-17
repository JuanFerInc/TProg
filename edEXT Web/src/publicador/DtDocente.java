
package publicador;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dtDocente complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dtDocente">
 *   &lt;complexContent>
 *     &lt;extension base="{http://publicador/}dtUsuario">
 *       &lt;sequence>
 *         &lt;element name="datosEdicionesIntegra" type="{http://publicador/}dtInstancia" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtDocente", propOrder = {
    "datosEdicionesIntegra"
})
public class DtDocente
    extends DtUsuario
{

    @XmlElement(nillable = true)
    protected List<DtInstancia> datosEdicionesIntegra;

    /**
     * Gets the value of the datosEdicionesIntegra property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the datosEdicionesIntegra property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatosEdicionesIntegra().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtInstancia }
     * 
     * 
     */
    public List<DtInstancia> getDatosEdicionesIntegra() {
        if (datosEdicionesIntegra == null) {
            datosEdicionesIntegra = new ArrayList<DtInstancia>();
        }
        return this.datosEdicionesIntegra;
    }

}
