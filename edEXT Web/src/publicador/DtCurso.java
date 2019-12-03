
package publicador;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for dtCurso complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dtCurso">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="URL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="duracion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="creditos" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="horas" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fechaRegistrado" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="previas" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ediciones" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="programas" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="edicionActual" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="categorias" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="imagen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtCurso", propOrder = {
    "nombre",
    "descripcion",
    "url",
    "duracion",
    "creditos",
    "horas",
    "fechaRegistrado",
    "previas",
    "ediciones",
    "programas",
    "edicionActual",
    "categorias",
    "imagen"
})
@XmlSeeAlso({
    DtCursoDatosyEdiciones.class
})
public class DtCurso {

    protected String nombre;
    protected String descripcion;
    @XmlElement(name = "URL")
    protected String url;
    protected int duracion;
    protected int creditos;
    protected int horas;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaRegistrado;
    @XmlElement(nillable = true)
    protected List<String> previas;
    @XmlElement(nillable = true)
    protected List<String> ediciones;
    @XmlElement(nillable = true)
    protected List<String> programas;
    protected String edicionActual;
    @XmlElement(nillable = true)
    protected List<String> categorias;
    protected String imagen;

    /**
     * Gets the value of the nombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the value of the nombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Gets the value of the descripcion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the value of the descripcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getURL() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setURL(String value) {
        this.url = value;
    }

    /**
     * Gets the value of the duracion property.
     * 
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Sets the value of the duracion property.
     * 
     */
    public void setDuracion(int value) {
        this.duracion = value;
    }

    /**
     * Gets the value of the creditos property.
     * 
     */
    public int getCreditos() {
        return creditos;
    }

    /**
     * Sets the value of the creditos property.
     * 
     */
    public void setCreditos(int value) {
        this.creditos = value;
    }

    /**
     * Gets the value of the horas property.
     * 
     */
    public int getHoras() {
        return horas;
    }

    /**
     * Sets the value of the horas property.
     * 
     */
    public void setHoras(int value) {
        this.horas = value;
    }

    /**
     * Gets the value of the fechaRegistrado property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaRegistrado() {
        return fechaRegistrado;
    }

    /**
     * Sets the value of the fechaRegistrado property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaRegistrado(XMLGregorianCalendar value) {
        this.fechaRegistrado = value;
    }

    /**
     * Gets the value of the previas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the previas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrevias().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPrevias() {
        if (previas == null) {
            previas = new ArrayList<String>();
        }
        return this.previas;
    }

    /**
     * Gets the value of the ediciones property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ediciones property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEdiciones().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getEdiciones() {
        if (ediciones == null) {
            ediciones = new ArrayList<String>();
        }
        return this.ediciones;
    }

    /**
     * Gets the value of the programas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the programas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProgramas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getProgramas() {
        if (programas == null) {
            programas = new ArrayList<String>();
        }
        return this.programas;
    }

    /**
     * Gets the value of the edicionActual property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEdicionActual() {
        return edicionActual;
    }

    /**
     * Sets the value of the edicionActual property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEdicionActual(String value) {
        this.edicionActual = value;
    }

    /**
     * Gets the value of the categorias property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the categorias property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCategorias().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCategorias() {
        if (categorias == null) {
            categorias = new ArrayList<String>();
        }
        return this.categorias;
    }

    /**
     * Gets the value of the imagen property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Sets the value of the imagen property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImagen(String value) {
        this.imagen = value;
    }

}
