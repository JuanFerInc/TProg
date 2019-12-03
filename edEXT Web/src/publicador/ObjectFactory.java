
package publicador;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the publicador package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CursoNoExisteExcep_QNAME = new QName("http://publicador/", "CursoNoExisteExcep");
    private final static QName _DtPrograma_QNAME = new QName("http://publicador/", "DtPrograma");
    private final static QName _EdicionNoExisteExcep_QNAME = new QName("http://publicador/", "EdicionNoExisteExcep");
    private final static QName _EstadoEsFinalExcep_QNAME = new QName("http://publicador/", "EstadoEsFinalExcep");
    private final static QName _UsuarioRepetidoExcep_QNAME = new QName("http://publicador/", "UsuarioRepetidoExcep");
    private final static QName _EstudianteSinEvaluarExcep_QNAME = new QName("http://publicador/", "EstudianteSinEvaluarExcep");
    private final static QName _EvaluacionIncorrectaExcep_QNAME = new QName("http://publicador/", "EvaluacionIncorrectaExcep");
    private final static QName _NoPudoDesinscribirseExcep_QNAME = new QName("http://publicador/", "NoPudoDesinscribirseExcep");
    private final static QName _NoSePudoResponderExcep_QNAME = new QName("http://publicador/", "NoSePudoResponderExcep");
    private final static QName _InstitutoRepetidoExcep_QNAME = new QName("http://publicador/", "InstitutoRepetidoExcep");
    private final static QName _ProgramaRepetidoExcep_QNAME = new QName("http://publicador/", "ProgramaRepetidoExcep");
    private final static QName _EdicionRepetidaExcep_QNAME = new QName("http://publicador/", "EdicionRepetidaExcep");
    private final static QName _DtCursoDatosyEdiciones_QNAME = new QName("http://publicador/", "DtCursoDatosyEdiciones");
    private final static QName _Exception_QNAME = new QName("http://publicador/", "Exception");
    private final static QName _CategoriaRepetidaExcep_QNAME = new QName("http://publicador/", "CategoriaRepetidaExcep");
    private final static QName _DtDocente_QNAME = new QName("http://publicador/", "DtDocente");
    private final static QName _DtEstudianteIn_QNAME = new QName("http://publicador/", "DtEstudianteIn");
    private final static QName _UsuarioNoExisteExcep_QNAME = new QName("http://publicador/", "UsuarioNoExisteExcep");
    private final static QName _CursoRepetidoExcep_QNAME = new QName("http://publicador/", "CursoRepetidoExcep");
    private final static QName _DtEdicion_QNAME = new QName("http://publicador/", "DtEdicion");
    private final static QName _LoginIncorrectoExcep_QNAME = new QName("http://publicador/", "LoginIncorrectoExcep");
    private final static QName _NoPudoInscribirseExcep_QNAME = new QName("http://publicador/", "NoPudoInscribirseExcep");
    private final static QName _DtCursoDatosyEdicionesEdiciones_QNAME = new QName("", "ediciones");
    private final static QName _DtCursoDatosyEdicionesProgramas_QNAME = new QName("", "programas");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: publicador
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MapCalendarStringAlgo }
     * 
     */
    public MapCalendarStringAlgo createMapCalendarStringAlgo() {
        return new MapCalendarStringAlgo();
    }

    /**
     * Create an instance of {@link MapCalendarStringAlgo.Mapita }
     * 
     */
    public MapCalendarStringAlgo.Mapita createMapCalendarStringAlgoMapita() {
        return new MapCalendarStringAlgo.Mapita();
    }

    /**
     * Create an instance of {@link MapStringStringAlgo }
     * 
     */
    public MapStringStringAlgo createMapStringStringAlgo() {
        return new MapStringStringAlgo();
    }

    /**
     * Create an instance of {@link MapStringStringAlgo.Mapita }
     * 
     */
    public MapStringStringAlgo.Mapita createMapStringStringAlgoMapita() {
        return new MapStringStringAlgo.Mapita();
    }

    /**
     * Create an instance of {@link DtEstudianteIn }
     * 
     */
    public DtEstudianteIn createDtEstudianteIn() {
        return new DtEstudianteIn();
    }

    /**
     * Create an instance of {@link DtEstudianteIn.MapEdiciones }
     * 
     */
    public DtEstudianteIn.MapEdiciones createDtEstudianteInMapEdiciones() {
        return new DtEstudianteIn.MapEdiciones();
    }

    /**
     * Create an instance of {@link LoginIncorrectoExcep }
     * 
     */
    public LoginIncorrectoExcep createLoginIncorrectoExcep() {
        return new LoginIncorrectoExcep();
    }

    /**
     * Create an instance of {@link NoPudoInscribirseExcep }
     * 
     */
    public NoPudoInscribirseExcep createNoPudoInscribirseExcep() {
        return new NoPudoInscribirseExcep();
    }

    /**
     * Create an instance of {@link DtEdicion }
     * 
     */
    public DtEdicion createDtEdicion() {
        return new DtEdicion();
    }

    /**
     * Create an instance of {@link UsuarioNoExisteExcep }
     * 
     */
    public UsuarioNoExisteExcep createUsuarioNoExisteExcep() {
        return new UsuarioNoExisteExcep();
    }

    /**
     * Create an instance of {@link CursoRepetidoExcep }
     * 
     */
    public CursoRepetidoExcep createCursoRepetidoExcep() {
        return new CursoRepetidoExcep();
    }

    /**
     * Create an instance of {@link CategoriaRepetidaExcep }
     * 
     */
    public CategoriaRepetidaExcep createCategoriaRepetidaExcep() {
        return new CategoriaRepetidaExcep();
    }

    /**
     * Create an instance of {@link DtDocente }
     * 
     */
    public DtDocente createDtDocente() {
        return new DtDocente();
    }

    /**
     * Create an instance of {@link DtCursoDatosyEdiciones }
     * 
     */
    public DtCursoDatosyEdiciones createDtCursoDatosyEdiciones() {
        return new DtCursoDatosyEdiciones();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link NoSePudoResponderExcep }
     * 
     */
    public NoSePudoResponderExcep createNoSePudoResponderExcep() {
        return new NoSePudoResponderExcep();
    }

    /**
     * Create an instance of {@link NoPudoDesinscribirseExcep }
     * 
     */
    public NoPudoDesinscribirseExcep createNoPudoDesinscribirseExcep() {
        return new NoPudoDesinscribirseExcep();
    }

    /**
     * Create an instance of {@link EdicionRepetidaExcep }
     * 
     */
    public EdicionRepetidaExcep createEdicionRepetidaExcep() {
        return new EdicionRepetidaExcep();
    }

    /**
     * Create an instance of {@link InstitutoRepetidoExcep }
     * 
     */
    public InstitutoRepetidoExcep createInstitutoRepetidoExcep() {
        return new InstitutoRepetidoExcep();
    }

    /**
     * Create an instance of {@link ProgramaRepetidoExcep }
     * 
     */
    public ProgramaRepetidoExcep createProgramaRepetidoExcep() {
        return new ProgramaRepetidoExcep();
    }

    /**
     * Create an instance of {@link EdicionNoExisteExcep }
     * 
     */
    public EdicionNoExisteExcep createEdicionNoExisteExcep() {
        return new EdicionNoExisteExcep();
    }

    /**
     * Create an instance of {@link EstadoEsFinalExcep }
     * 
     */
    public EstadoEsFinalExcep createEstadoEsFinalExcep() {
        return new EstadoEsFinalExcep();
    }

    /**
     * Create an instance of {@link EstudianteSinEvaluarExcep }
     * 
     */
    public EstudianteSinEvaluarExcep createEstudianteSinEvaluarExcep() {
        return new EstudianteSinEvaluarExcep();
    }

    /**
     * Create an instance of {@link EvaluacionIncorrectaExcep }
     * 
     */
    public EvaluacionIncorrectaExcep createEvaluacionIncorrectaExcep() {
        return new EvaluacionIncorrectaExcep();
    }

    /**
     * Create an instance of {@link UsuarioRepetidoExcep }
     * 
     */
    public UsuarioRepetidoExcep createUsuarioRepetidoExcep() {
        return new UsuarioRepetidoExcep();
    }

    /**
     * Create an instance of {@link CursoNoExisteExcep }
     * 
     */
    public CursoNoExisteExcep createCursoNoExisteExcep() {
        return new CursoNoExisteExcep();
    }

    /**
     * Create an instance of {@link DtPrograma }
     * 
     */
    public DtPrograma createDtPrograma() {
        return new DtPrograma();
    }

    /**
     * Create an instance of {@link ListDtInfo }
     * 
     */
    public ListDtInfo createListDtInfo() {
        return new ListDtInfo();
    }

    /**
     * Create an instance of {@link ListString }
     * 
     */
    public ListString createListString() {
        return new ListString();
    }

    /**
     * Create an instance of {@link ListInteger }
     * 
     */
    public ListInteger createListInteger() {
        return new ListInteger();
    }

    /**
     * Create an instance of {@link SetDtInfo }
     * 
     */
    public SetDtInfo createSetDtInfo() {
        return new SetDtInfo();
    }

    /**
     * Create an instance of {@link DtCurso }
     * 
     */
    public DtCurso createDtCurso() {
        return new DtCurso();
    }

    /**
     * Create an instance of {@link DtUsuario }
     * 
     */
    public DtUsuario createDtUsuario() {
        return new DtUsuario();
    }

    /**
     * Create an instance of {@link SetString }
     * 
     */
    public SetString createSetString() {
        return new SetString();
    }

    /**
     * Create an instance of {@link DtInstancia }
     * 
     */
    public DtInstancia createDtInstancia() {
        return new DtInstancia();
    }

    /**
     * Create an instance of {@link SetDtComentario }
     * 
     */
    public SetDtComentario createSetDtComentario() {
        return new SetDtComentario();
    }

    /**
     * Create an instance of {@link DtInfo }
     * 
     */
    public DtInfo createDtInfo() {
        return new DtInfo();
    }

    /**
     * Create an instance of {@link DtComentario }
     * 
     */
    public DtComentario createDtComentario() {
        return new DtComentario();
    }

    /**
     * Create an instance of {@link MapCalendarStringAlgo.Mapita.Entry }
     * 
     */
    public MapCalendarStringAlgo.Mapita.Entry createMapCalendarStringAlgoMapitaEntry() {
        return new MapCalendarStringAlgo.Mapita.Entry();
    }

    /**
     * Create an instance of {@link MapStringStringAlgo.Mapita.Entry }
     * 
     */
    public MapStringStringAlgo.Mapita.Entry createMapStringStringAlgoMapitaEntry() {
        return new MapStringStringAlgo.Mapita.Entry();
    }

    /**
     * Create an instance of {@link DtEstudianteIn.MapEdiciones.Entry }
     * 
     */
    public DtEstudianteIn.MapEdiciones.Entry createDtEstudianteInMapEdicionesEntry() {
        return new DtEstudianteIn.MapEdiciones.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CursoNoExisteExcep }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicador/", name = "CursoNoExisteExcep")
    public JAXBElement<CursoNoExisteExcep> createCursoNoExisteExcep(CursoNoExisteExcep value) {
        return new JAXBElement<CursoNoExisteExcep>(_CursoNoExisteExcep_QNAME, CursoNoExisteExcep.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DtPrograma }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicador/", name = "DtPrograma")
    public JAXBElement<DtPrograma> createDtPrograma(DtPrograma value) {
        return new JAXBElement<DtPrograma>(_DtPrograma_QNAME, DtPrograma.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EdicionNoExisteExcep }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicador/", name = "EdicionNoExisteExcep")
    public JAXBElement<EdicionNoExisteExcep> createEdicionNoExisteExcep(EdicionNoExisteExcep value) {
        return new JAXBElement<EdicionNoExisteExcep>(_EdicionNoExisteExcep_QNAME, EdicionNoExisteExcep.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EstadoEsFinalExcep }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicador/", name = "EstadoEsFinalExcep")
    public JAXBElement<EstadoEsFinalExcep> createEstadoEsFinalExcep(EstadoEsFinalExcep value) {
        return new JAXBElement<EstadoEsFinalExcep>(_EstadoEsFinalExcep_QNAME, EstadoEsFinalExcep.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UsuarioRepetidoExcep }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicador/", name = "UsuarioRepetidoExcep")
    public JAXBElement<UsuarioRepetidoExcep> createUsuarioRepetidoExcep(UsuarioRepetidoExcep value) {
        return new JAXBElement<UsuarioRepetidoExcep>(_UsuarioRepetidoExcep_QNAME, UsuarioRepetidoExcep.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EstudianteSinEvaluarExcep }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicador/", name = "EstudianteSinEvaluarExcep")
    public JAXBElement<EstudianteSinEvaluarExcep> createEstudianteSinEvaluarExcep(EstudianteSinEvaluarExcep value) {
        return new JAXBElement<EstudianteSinEvaluarExcep>(_EstudianteSinEvaluarExcep_QNAME, EstudianteSinEvaluarExcep.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EvaluacionIncorrectaExcep }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicador/", name = "EvaluacionIncorrectaExcep")
    public JAXBElement<EvaluacionIncorrectaExcep> createEvaluacionIncorrectaExcep(EvaluacionIncorrectaExcep value) {
        return new JAXBElement<EvaluacionIncorrectaExcep>(_EvaluacionIncorrectaExcep_QNAME, EvaluacionIncorrectaExcep.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NoPudoDesinscribirseExcep }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicador/", name = "NoPudoDesinscribirseExcep")
    public JAXBElement<NoPudoDesinscribirseExcep> createNoPudoDesinscribirseExcep(NoPudoDesinscribirseExcep value) {
        return new JAXBElement<NoPudoDesinscribirseExcep>(_NoPudoDesinscribirseExcep_QNAME, NoPudoDesinscribirseExcep.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NoSePudoResponderExcep }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicador/", name = "NoSePudoResponderExcep")
    public JAXBElement<NoSePudoResponderExcep> createNoSePudoResponderExcep(NoSePudoResponderExcep value) {
        return new JAXBElement<NoSePudoResponderExcep>(_NoSePudoResponderExcep_QNAME, NoSePudoResponderExcep.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InstitutoRepetidoExcep }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicador/", name = "InstitutoRepetidoExcep")
    public JAXBElement<InstitutoRepetidoExcep> createInstitutoRepetidoExcep(InstitutoRepetidoExcep value) {
        return new JAXBElement<InstitutoRepetidoExcep>(_InstitutoRepetidoExcep_QNAME, InstitutoRepetidoExcep.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProgramaRepetidoExcep }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicador/", name = "ProgramaRepetidoExcep")
    public JAXBElement<ProgramaRepetidoExcep> createProgramaRepetidoExcep(ProgramaRepetidoExcep value) {
        return new JAXBElement<ProgramaRepetidoExcep>(_ProgramaRepetidoExcep_QNAME, ProgramaRepetidoExcep.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EdicionRepetidaExcep }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicador/", name = "EdicionRepetidaExcep")
    public JAXBElement<EdicionRepetidaExcep> createEdicionRepetidaExcep(EdicionRepetidaExcep value) {
        return new JAXBElement<EdicionRepetidaExcep>(_EdicionRepetidaExcep_QNAME, EdicionRepetidaExcep.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DtCursoDatosyEdiciones }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicador/", name = "DtCursoDatosyEdiciones")
    public JAXBElement<DtCursoDatosyEdiciones> createDtCursoDatosyEdiciones(DtCursoDatosyEdiciones value) {
        return new JAXBElement<DtCursoDatosyEdiciones>(_DtCursoDatosyEdiciones_QNAME, DtCursoDatosyEdiciones.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicador/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CategoriaRepetidaExcep }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicador/", name = "CategoriaRepetidaExcep")
    public JAXBElement<CategoriaRepetidaExcep> createCategoriaRepetidaExcep(CategoriaRepetidaExcep value) {
        return new JAXBElement<CategoriaRepetidaExcep>(_CategoriaRepetidaExcep_QNAME, CategoriaRepetidaExcep.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DtDocente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicador/", name = "DtDocente")
    public JAXBElement<DtDocente> createDtDocente(DtDocente value) {
        return new JAXBElement<DtDocente>(_DtDocente_QNAME, DtDocente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DtEstudianteIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicador/", name = "DtEstudianteIn")
    public JAXBElement<DtEstudianteIn> createDtEstudianteIn(DtEstudianteIn value) {
        return new JAXBElement<DtEstudianteIn>(_DtEstudianteIn_QNAME, DtEstudianteIn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UsuarioNoExisteExcep }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicador/", name = "UsuarioNoExisteExcep")
    public JAXBElement<UsuarioNoExisteExcep> createUsuarioNoExisteExcep(UsuarioNoExisteExcep value) {
        return new JAXBElement<UsuarioNoExisteExcep>(_UsuarioNoExisteExcep_QNAME, UsuarioNoExisteExcep.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CursoRepetidoExcep }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicador/", name = "CursoRepetidoExcep")
    public JAXBElement<CursoRepetidoExcep> createCursoRepetidoExcep(CursoRepetidoExcep value) {
        return new JAXBElement<CursoRepetidoExcep>(_CursoRepetidoExcep_QNAME, CursoRepetidoExcep.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DtEdicion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicador/", name = "DtEdicion")
    public JAXBElement<DtEdicion> createDtEdicion(DtEdicion value) {
        return new JAXBElement<DtEdicion>(_DtEdicion_QNAME, DtEdicion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginIncorrectoExcep }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicador/", name = "LoginIncorrectoExcep")
    public JAXBElement<LoginIncorrectoExcep> createLoginIncorrectoExcep(LoginIncorrectoExcep value) {
        return new JAXBElement<LoginIncorrectoExcep>(_LoginIncorrectoExcep_QNAME, LoginIncorrectoExcep.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NoPudoInscribirseExcep }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicador/", name = "NoPudoInscribirseExcep")
    public JAXBElement<NoPudoInscribirseExcep> createNoPudoInscribirseExcep(NoPudoInscribirseExcep value) {
        return new JAXBElement<NoPudoInscribirseExcep>(_NoPudoInscribirseExcep_QNAME, NoPudoInscribirseExcep.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ediciones", scope = DtCursoDatosyEdiciones.class)
    public JAXBElement<String> createDtCursoDatosyEdicionesEdiciones(String value) {
        return new JAXBElement<String>(_DtCursoDatosyEdicionesEdiciones_QNAME, String.class, DtCursoDatosyEdiciones.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "programas", scope = DtCursoDatosyEdiciones.class)
    public JAXBElement<String> createDtCursoDatosyEdicionesProgramas(String value) {
        return new JAXBElement<String>(_DtCursoDatosyEdicionesProgramas_QNAME, String.class, DtCursoDatosyEdiciones.class, value);
    }

}
