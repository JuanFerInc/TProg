
package publicador;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for dtInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dtInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nick" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="edicion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prio" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="fechaInscripcion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtInfo", propOrder = {
    "nick",
    "edicion",
    "estado",
    "prio",
    "fechaInscripcion"
})
public class DtInfo {

    protected String nick;
    protected String edicion;
    protected String estado;
    protected double prio;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaInscripcion;

    /**
     * Gets the value of the nick property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNick() {
        return nick;
    }

    /**
     * Sets the value of the nick property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNick(String value) {
        this.nick = value;
    }

    /**
     * Gets the value of the edicion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEdicion() {
        return edicion;
    }

    /**
     * Sets the value of the edicion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEdicion(String value) {
        this.edicion = value;
    }

    /**
     * Gets the value of the estado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Sets the value of the estado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Gets the value of the prio property.
     * 
     */
    public double getPrio() {
        return prio;
    }

    /**
     * Sets the value of the prio property.
     * 
     */
    public void setPrio(double value) {
        this.prio = value;
    }

    /**
     * Gets the value of the fechaInscripcion property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaInscripcion() {
        return fechaInscripcion;
    }

    /**
     * Sets the value of the fechaInscripcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaInscripcion(XMLGregorianCalendar value) {
        this.fechaInscripcion = value;
    }

}
