
package publicador;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "EdicionRepetidaExcep", targetNamespace = "http://publicador/")
public class EdicionRepetidaExcep_Exception
    extends java.lang.Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private EdicionRepetidaExcep faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public EdicionRepetidaExcep_Exception(String message, EdicionRepetidaExcep faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public EdicionRepetidaExcep_Exception(String message, EdicionRepetidaExcep faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: publicador.EdicionRepetidaExcep
     */
    public EdicionRepetidaExcep getFaultInfo() {
        return faultInfo;
    }

}
