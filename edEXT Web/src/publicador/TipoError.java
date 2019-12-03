
package publicador;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tipoError.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tipoError">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OK"/>
 *     &lt;enumeration value="CORREO"/>
 *     &lt;enumeration value="NICK"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tipoError")
@XmlEnum
public enum TipoError {

    OK,
    CORREO,
    NICK;

    public String value() {
        return name();
    }

    public static TipoError fromValue(String v) {
        return valueOf(v);
    }

}
