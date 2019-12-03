
package publicador;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for val.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="val">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PUEDE"/>
 *     &lt;enumeration value="YAEVALUO"/>
 *     &lt;enumeration value="NOPUEDE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "val")
@XmlEnum
public enum Val {

    PUEDE,
    YAEVALUO,
    NOPUEDE;

    public String value() {
        return name();
    }

    public static Val fromValue(String v) {
        return valueOf(v);
    }

}
