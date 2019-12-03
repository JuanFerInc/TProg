
package publicador;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "CategoriaRepetidaExcep", targetNamespace = "http://publicador/")
public class CategoriaRepetidaExcep_Exception
    extends java.lang.Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private CategoriaRepetidaExcep faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public CategoriaRepetidaExcep_Exception(String message, CategoriaRepetidaExcep faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public CategoriaRepetidaExcep_Exception(String message, CategoriaRepetidaExcep faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: publicador.CategoriaRepetidaExcep
     */
    public CategoriaRepetidaExcep getFaultInfo() {
        return faultInfo;
    }

}
