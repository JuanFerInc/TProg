
package publicador;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dtCursoDatosyEdiciones complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dtCursoDatosyEdiciones">
 *   &lt;complexContent>
 *     &lt;extension base="{http://publicador/}dtCurso">
 *       &lt;sequence>
 *         &lt;element name="ediciones" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="programas" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtCursoDatosyEdiciones", propOrder = {
    "rest"
})
public class DtCursoDatosyEdiciones
    extends DtCurso
{

    @XmlElementRefs({
        @XmlElementRef(name = "ediciones", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "programas", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<String>> rest;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "Ediciones" is used by two different parts of a schema. See: 
     * line 312 of http://localhost:9129/publicador?xsd=1
     * line 300 of http://localhost:9129/publicador?xsd=1
     * <p>
     * To get rid of this property, apply a property customization to one 
     * of both of the following declarations to change their names: 
     * Gets the value of the rest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<String>> getRest() {
        if (rest == null) {
            rest = new ArrayList<JAXBElement<String>>();
        }
        return this.rest;
    }

}
