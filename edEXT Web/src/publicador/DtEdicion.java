
package publicador;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for dtEdicion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dtEdicion">
 *   &lt;complexContent>
 *     &lt;extension base="{http://publicador/}dtInstancia">
 *       &lt;sequence>
 *         &lt;element name="cupo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fechaPublicacion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="docentesParticipan" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="borrarBoton" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="cerrada" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtEdicion", propOrder = {
    "cupo",
    "fechaPublicacion",
    "docentesParticipan",
    "borrarBoton",
    "cerrada"
})
public class DtEdicion
    extends DtInstancia
{

    protected int cupo;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaPublicacion;
    @XmlElement(nillable = true)
    protected List<String> docentesParticipan;
    protected boolean borrarBoton;
    protected boolean cerrada;

    /**
     * Gets the value of the cupo property.
     * 
     */
    public int getCupo() {
        return cupo;
    }

    /**
     * Sets the value of the cupo property.
     * 
     */
    public void setCupo(int value) {
        this.cupo = value;
    }

    /**
     * Gets the value of the fechaPublicacion property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaPublicacion() {
        return fechaPublicacion;
    }

    /**
     * Sets the value of the fechaPublicacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaPublicacion(XMLGregorianCalendar value) {
        this.fechaPublicacion = value;
    }

    /**
     * Gets the value of the docentesParticipan property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the docentesParticipan property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocentesParticipan().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDocentesParticipan() {
        if (docentesParticipan == null) {
            docentesParticipan = new ArrayList<String>();
        }
        return this.docentesParticipan;
    }

    /**
     * Gets the value of the borrarBoton property.
     * 
     */
    public boolean isBorrarBoton() {
        return borrarBoton;
    }

    /**
     * Sets the value of the borrarBoton property.
     * 
     */
    public void setBorrarBoton(boolean value) {
        this.borrarBoton = value;
    }

    /**
     * Gets the value of the cerrada property.
     * 
     */
    public boolean isCerrada() {
        return cerrada;
    }

    /**
     * Sets the value of the cerrada property.
     * 
     */
    public void setCerrada(boolean value) {
        this.cerrada = value;
    }

}
