
package publicador;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tipoUsuario.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tipoUsuario">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DOCENTE"/>
 *     &lt;enumeration value="ESTUDIANTE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tipoUsuario")
@XmlEnum
public enum TipoUsuario {

    DOCENTE,
    ESTUDIANTE;

    public String value() {
        return name();
    }

    public static TipoUsuario fromValue(String v) {
        return valueOf(v);
    }

}
