package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.ctrleinterfaces.cargarDatos;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JToolBar;
import javax.swing.JButton;

public class mainMenu extends JFrame {

	private JPanel contentPane;
	private AgregarCursoAProgramaDeFormacion JIFAgregarCursoAProgramaDeFormacion;
	private AltaDeCurso JIFAltaDeCurso;
	private AltaDeEdicionDeCurso JIFAltaDeEdicionDeCurso;
	private AltaDeInstituto JIFAltaDeInstituto;
	private AltaDeUsuario JIFAltaDeUsuario;
	private ConsultaDeCurso JIFConsultaDeCurso;
	private ConsultaDeEdicionDeCurso JIFConsultaDeEdicionDeCurso;
	private ConsultaDeProgramaDeFormacion JIFConsultaDeProgramaDeFormacion;
	private ConsultaDeUsuario JIFConsultaDeUsuario;
	private CrearProgramaDeFormacion JIFCrearProgramaDeFormacion;
	private InscripcionAEdicionDeCurso JIFInscripcionAEdicionDeCurso;
	private ModificarDatosDeUsuario JIFModificarDatosDeUsuario;
	private AltaDeCategoria JIFAltaDeCategoria;
	/**
	 * Create the frame.
	 */
	public mainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 526);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnUsuario = new JMenu("Usuario");
		menuBar.add(mnUsuario);
		
		JMenuItem mntmAltaUsuario = new JMenuItem("Alta");
		mntmAltaUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JIFAltaDeUsuario.setVisible(false);
            	JIFModificarDatosDeUsuario.setVisible(false);
            	JIFAltaDeCurso.setVisible(false);
            	JIFConsultaDeCurso.setVisible(false);
            	JIFAltaDeEdicionDeCurso.setVisible(false);
            	JIFConsultaDeEdicionDeCurso.setVisible(false);
            	JIFInscripcionAEdicionDeCurso.setVisible(false);
            	JIFCrearProgramaDeFormacion.setVisible(false);
            	JIFAgregarCursoAProgramaDeFormacion.setVisible(false);
            	JIFConsultaDeProgramaDeFormacion.setVisible(false);
            	JIFAltaDeInstituto.setVisible(false);
            	JIFConsultaDeUsuario.setVisible(false);
            	
            	JIFAltaDeUsuario.setVisible(true);
            	JIFAltaDeUsuario.cargarDatosADU();
            }
        });
		mnUsuario.add(mntmAltaUsuario);
		
		JMenuItem mntmConsultaUsuario = new JMenuItem("Consulta");
		mntmConsultaUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JIFAltaDeUsuario.setVisible(false);
            	JIFModificarDatosDeUsuario.setVisible(false);
            	JIFAltaDeCurso.setVisible(false);
            	JIFConsultaDeCurso.setVisible(false);
            	JIFAltaDeEdicionDeCurso.setVisible(false);
            	JIFConsultaDeEdicionDeCurso.setVisible(false);
            	JIFInscripcionAEdicionDeCurso.setVisible(false);
            	JIFCrearProgramaDeFormacion.setVisible(false);
            	JIFAgregarCursoAProgramaDeFormacion.setVisible(false);
            	JIFConsultaDeProgramaDeFormacion.setVisible(false);
            	JIFAltaDeInstituto.setVisible(false);
            	JIFConsultaDeUsuario.setVisible(false);
            	
            	JIFConsultaDeUsuario.setVisible(true);
            	JIFConsultaDeUsuario.cargarDatosCDU();
            }
        });
		mnUsuario.add(mntmConsultaUsuario);
		
		JMenuItem mntmModificarDatosUsuario = new JMenuItem("Modificar datos");
		mntmModificarDatosUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JIFAltaDeUsuario.setVisible(false);
            	JIFModificarDatosDeUsuario.setVisible(false);
            	JIFAltaDeCurso.setVisible(false);
            	JIFConsultaDeCurso.setVisible(false);
            	JIFAltaDeEdicionDeCurso.setVisible(false);
            	JIFConsultaDeEdicionDeCurso.setVisible(false);
            	JIFInscripcionAEdicionDeCurso.setVisible(false);
            	JIFCrearProgramaDeFormacion.setVisible(false);
            	JIFAgregarCursoAProgramaDeFormacion.setVisible(false);
            	JIFConsultaDeProgramaDeFormacion.setVisible(false);
            	JIFAltaDeInstituto.setVisible(false);
            	JIFConsultaDeUsuario.setVisible(false);
            	
            	JIFModificarDatosDeUsuario.setVisible(true);
            	JIFModificarDatosDeUsuario.cargarDatosMDU();
            }
        });
		mnUsuario.add(mntmModificarDatosUsuario);
		
		JMenu mnCurso = new JMenu("Curso");
		menuBar.add(mnCurso);
		
		JMenuItem mntmAltaCurso = new JMenuItem("Alta");
		mntmAltaCurso.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JIFAltaDeUsuario.setVisible(false);
            	JIFModificarDatosDeUsuario.setVisible(false);
            	JIFAltaDeCurso.setVisible(false);
            	JIFConsultaDeCurso.setVisible(false);
            	JIFAltaDeEdicionDeCurso.setVisible(false);
            	JIFConsultaDeEdicionDeCurso.setVisible(false);
            	JIFInscripcionAEdicionDeCurso.setVisible(false);
            	JIFCrearProgramaDeFormacion.setVisible(false);
            	JIFAgregarCursoAProgramaDeFormacion.setVisible(false);
            	JIFConsultaDeProgramaDeFormacion.setVisible(false);
            	JIFAltaDeInstituto.setVisible(false);
            	JIFConsultaDeUsuario.setVisible(false);
            	
            	JIFAltaDeCurso.setVisible(true);
            	JIFAltaDeCurso.cargarDatosADC();
            }
        });
		mnCurso.add(mntmAltaCurso);
		
		JMenuItem mntmConsultaCurso = new JMenuItem("Consulta");
		mntmConsultaCurso.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JIFAltaDeUsuario.setVisible(false);
            	JIFModificarDatosDeUsuario.setVisible(false);
            	JIFAltaDeCurso.setVisible(false);
            	JIFConsultaDeCurso.setVisible(false);
            	JIFAltaDeEdicionDeCurso.setVisible(false);
            	JIFConsultaDeEdicionDeCurso.setVisible(false);
            	JIFInscripcionAEdicionDeCurso.setVisible(false);
            	JIFCrearProgramaDeFormacion.setVisible(false);
            	JIFAgregarCursoAProgramaDeFormacion.setVisible(false);
            	JIFConsultaDeProgramaDeFormacion.setVisible(false);
            	JIFAltaDeInstituto.setVisible(false);
            	JIFConsultaDeUsuario.setVisible(false);
            	
            	JIFConsultaDeCurso.setVisible(true);
            	JIFConsultaDeCurso.cargarInstitutos();
            }
        });
		mnCurso.add(mntmConsultaCurso);
		
		JMenu mnEdicionDeCurso = new JMenu("Edicion de Curso");
		menuBar.add(mnEdicionDeCurso);
		
		JMenuItem mntmAltaEdicion = new JMenuItem("Alta");
		mntmAltaEdicion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JIFAltaDeUsuario.setVisible(false);
            	JIFModificarDatosDeUsuario.setVisible(false);
            	JIFAltaDeCurso.setVisible(false);
            	JIFConsultaDeCurso.setVisible(false);
            	JIFAltaDeEdicionDeCurso.setVisible(false);
            	JIFConsultaDeEdicionDeCurso.setVisible(false);
            	JIFInscripcionAEdicionDeCurso.setVisible(false);
            	JIFCrearProgramaDeFormacion.setVisible(false);
            	JIFAgregarCursoAProgramaDeFormacion.setVisible(false);
            	JIFConsultaDeProgramaDeFormacion.setVisible(false);
            	JIFAltaDeInstituto.setVisible(false);
            	JIFConsultaDeUsuario.setVisible(false);
            	
            	JIFAltaDeEdicionDeCurso.setVisible(true);
            	JIFAltaDeEdicionDeCurso.cargarDatosADEDC();
            }
        });
		mnEdicionDeCurso.add(mntmAltaEdicion);
		
		JMenuItem mntmConsulta = new JMenuItem("Consulta");
		mntmConsulta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JIFAltaDeUsuario.setVisible(false);
            	JIFModificarDatosDeUsuario.setVisible(false);
            	JIFAltaDeCurso.setVisible(false);
            	JIFConsultaDeCurso.setVisible(false);
            	JIFAltaDeEdicionDeCurso.setVisible(false);
            	JIFConsultaDeEdicionDeCurso.setVisible(false);
            	JIFInscripcionAEdicionDeCurso.setVisible(false);
            	JIFCrearProgramaDeFormacion.setVisible(false);
            	JIFAgregarCursoAProgramaDeFormacion.setVisible(false);
            	JIFConsultaDeProgramaDeFormacion.setVisible(false);
            	JIFAltaDeInstituto.setVisible(false);
            	JIFConsultaDeUsuario.setVisible(false);
            	
            	JIFConsultaDeEdicionDeCurso.setVisible(true);  
            	JIFConsultaDeEdicionDeCurso.cargarDatosCDEDC();
            }
        });
		mnEdicionDeCurso.add(mntmConsulta);
		
		JMenuItem mntmInscripcion = new JMenuItem("Inscripcion");
		mntmInscripcion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JIFAltaDeUsuario.setVisible(false);
            	JIFModificarDatosDeUsuario.setVisible(false);
            	JIFAltaDeCurso.setVisible(false);
            	JIFConsultaDeCurso.setVisible(false);
            	JIFAltaDeEdicionDeCurso.setVisible(false);
            	JIFConsultaDeEdicionDeCurso.setVisible(false);
            	JIFInscripcionAEdicionDeCurso.setVisible(false);
            	JIFCrearProgramaDeFormacion.setVisible(false);
            	JIFAgregarCursoAProgramaDeFormacion.setVisible(false);
            	JIFConsultaDeProgramaDeFormacion.setVisible(false);
            	JIFAltaDeInstituto.setVisible(false);
            	JIFConsultaDeUsuario.setVisible(false);
            	
            	JIFInscripcionAEdicionDeCurso.setVisible(true);
            	JIFInscripcionAEdicionDeCurso.cargarDatosIAEDC();
            }
        });
		mnEdicionDeCurso.add(mntmInscripcion);
		
		JMenu mnProgramaDeFormacion = new JMenu("Programa de Formacion");
		menuBar.add(mnProgramaDeFormacion);
		
		JMenuItem mntmCrear = new JMenuItem("Crear");
		mntmCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JIFAltaDeUsuario.setVisible(false);
            	JIFModificarDatosDeUsuario.setVisible(false);
            	JIFAltaDeCurso.setVisible(false);
            	JIFConsultaDeCurso.setVisible(false);
            	JIFAltaDeEdicionDeCurso.setVisible(false);
            	JIFConsultaDeEdicionDeCurso.setVisible(false);
            	JIFInscripcionAEdicionDeCurso.setVisible(false);
            	JIFCrearProgramaDeFormacion.setVisible(false);
            	JIFAgregarCursoAProgramaDeFormacion.setVisible(false);
            	JIFConsultaDeProgramaDeFormacion.setVisible(false);
            	JIFAltaDeInstituto.setVisible(false);
            	JIFConsultaDeUsuario.setVisible(false);
            	
            	JIFCrearProgramaDeFormacion.setVisible(true);
            }
        });
		mnProgramaDeFormacion.add(mntmCrear);
		
		JMenuItem mntmAgregarCursoA = new JMenuItem("Agregar curso a");
		mntmAgregarCursoA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JIFAltaDeUsuario.setVisible(false);
            	JIFModificarDatosDeUsuario.setVisible(false);
            	JIFAltaDeCurso.setVisible(false);
            	JIFConsultaDeCurso.setVisible(false);
            	JIFAltaDeEdicionDeCurso.setVisible(false);
            	JIFConsultaDeEdicionDeCurso.setVisible(false);
            	JIFInscripcionAEdicionDeCurso.setVisible(false);
            	JIFCrearProgramaDeFormacion.setVisible(false);
            	JIFAgregarCursoAProgramaDeFormacion.setVisible(false);
            	JIFConsultaDeProgramaDeFormacion.setVisible(false);
            	JIFAltaDeInstituto.setVisible(false);
            	JIFConsultaDeUsuario.setVisible(false);
            	
            	JIFAgregarCursoAProgramaDeFormacion.setVisible(true);
            	JIFAgregarCursoAProgramaDeFormacion.cargarDatosACAPDF();
            }
        });
		mnProgramaDeFormacion.add(mntmAgregarCursoA);
		
		JMenuItem mntmConsulta_1 = new JMenuItem("Consulta");
		mntmConsulta_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JIFAltaDeUsuario.setVisible(false);
            	JIFModificarDatosDeUsuario.setVisible(false);
            	JIFAltaDeCurso.setVisible(false);
            	JIFConsultaDeCurso.setVisible(false);
            	JIFAltaDeEdicionDeCurso.setVisible(false);
            	JIFConsultaDeEdicionDeCurso.setVisible(false);
            	JIFInscripcionAEdicionDeCurso.setVisible(false);
            	JIFCrearProgramaDeFormacion.setVisible(false);
            	JIFAgregarCursoAProgramaDeFormacion.setVisible(false);
            	JIFConsultaDeProgramaDeFormacion.setVisible(false);
            	JIFAltaDeInstituto.setVisible(false);
            	JIFConsultaDeUsuario.setVisible(false);
            	
            	JIFConsultaDeProgramaDeFormacion.setVisible(true);
            	JIFConsultaDeProgramaDeFormacion.cargarDatosCDPDF();
            }
        });
		mnProgramaDeFormacion.add(mntmConsulta_1);
		
		JMenu mnInstituto = new JMenu("Instituto");
		menuBar.add(mnInstituto);
		
		JMenuItem mntmAltaInstituto = new JMenuItem("Alta");
		mntmAltaInstituto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JIFAltaDeUsuario.setVisible(false);
            	JIFModificarDatosDeUsuario.setVisible(false);
            	JIFAltaDeCurso.setVisible(false);
            	JIFConsultaDeCurso.setVisible(false);
            	JIFAltaDeEdicionDeCurso.setVisible(false);
            	JIFConsultaDeEdicionDeCurso.setVisible(false);
            	JIFInscripcionAEdicionDeCurso.setVisible(false);
            	JIFCrearProgramaDeFormacion.setVisible(false);
            	JIFAgregarCursoAProgramaDeFormacion.setVisible(false);
            	JIFConsultaDeProgramaDeFormacion.setVisible(false);
            	JIFAltaDeInstituto.setVisible(false);
            	JIFConsultaDeUsuario.setVisible(false);
            	
            	JIFAltaDeInstituto.setVisible(true);
            }
        });
		mnInstituto.add(mntmAltaInstituto);
		
		JMenu mnCategoria = new JMenu("Categoria");
		menuBar.add(mnCategoria);

		
		JMenuItem mntmAltaCat = new JMenuItem("Alta");
		mntmAltaCat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JIFAltaDeUsuario.setVisible(false);
            	JIFModificarDatosDeUsuario.setVisible(false);
            	JIFAltaDeCurso.setVisible(false);
            	JIFConsultaDeCurso.setVisible(false);
            	JIFAltaDeEdicionDeCurso.setVisible(false);
            	JIFConsultaDeEdicionDeCurso.setVisible(false);
            	JIFInscripcionAEdicionDeCurso.setVisible(false);
            	JIFCrearProgramaDeFormacion.setVisible(false);
            	JIFAgregarCursoAProgramaDeFormacion.setVisible(false);
            	JIFConsultaDeProgramaDeFormacion.setVisible(false);
            	JIFAltaDeInstituto.setVisible(false);
            	JIFConsultaDeUsuario.setVisible(false);
            	JIFAltaDeInstituto.setVisible(false);
            	
            	JIFAltaDeCategoria.setVisible(true);
            	
            }
        });
		mnCategoria.add(mntmAltaCat);
		
		JMenu mnCargarDatos = new JMenu("Cargar datos");
		menuBar.add(mnCargarDatos);
		
		JMenuItem mntmCargar = new JMenuItem("Cargar");
		mntmCargar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cargarDatos datos = new cargarDatos();
        		datos = null;
            }
        });
		mnCargarDatos.add(mntmCargar);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{424, 0};
        gbl_contentPane.rowHeights = new int[]{230, 0};
        gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);
        //AltaDeInstituto
        JIFAltaDeInstituto =new AltaDeInstituto();
        JIFAltaDeInstituto.setVisible(false);
        //AltaDeCategoria
        JIFAltaDeCategoria = new AltaDeCategoria();
        JIFAltaDeCategoria.setVisible(false);
        //ConsultaDeProgramaDeFormacion
        JIFConsultaDeProgramaDeFormacion=new ConsultaDeProgramaDeFormacion();
        JIFConsultaDeProgramaDeFormacion.setVisible(false);
        //AltaDeUsuario
        JIFAltaDeUsuario= new AltaDeUsuario();
        JIFAltaDeUsuario.setVisible(false);
        //arranca la declaracion de las internals frames de los casos de uso
        
        //AgregarCursoAProgramaDeFormacion
        JIFAgregarCursoAProgramaDeFormacion= new AgregarCursoAProgramaDeFormacion();
        JIFAgregarCursoAProgramaDeFormacion.setVisible(false);
        //ConsultaDeCurso
        JIFConsultaDeCurso=new ConsultaDeCurso();
        JIFConsultaDeCurso.setVisible(false);
        //InscripcionAEdicionDeCurso
        JIFInscripcionAEdicionDeCurso=new InscripcionAEdicionDeCurso();
        JIFInscripcionAEdicionDeCurso.setVisible(false);
        //ConsultaDeUsuario
        JIFConsultaDeUsuario=new ConsultaDeUsuario();
        JIFConsultaDeUsuario.setVisible(false);
        //ConsultaDeEdicionDeCurso
        JIFConsultaDeEdicionDeCurso=new ConsultaDeEdicionDeCurso();
        JIFConsultaDeEdicionDeCurso.setVisible(false);
        //CrearProgramaDeFormacion
        JIFCrearProgramaDeFormacion=new CrearProgramaDeFormacion();
        JIFCrearProgramaDeFormacion.setVisible(false);
        //ModificarDatosDeUsuario
        JIFModificarDatosDeUsuario=new ModificarDatosDeUsuario();
        JIFModificarDatosDeUsuario.setVisible(false);
        //AltaDeEdicionDeCurso 
        JIFAltaDeEdicionDeCurso = new AltaDeEdicionDeCurso();
        JIFAltaDeEdicionDeCurso.setVisible(false);
        //AltaDeCurso
        JIFAltaDeCurso = new AltaDeCurso();
        JIFAltaDeCurso.setVisible(false);
        GridBagConstraints gbc_JIFAltaDeCurso = new GridBagConstraints();
        gbc_JIFAltaDeCurso.fill = GridBagConstraints.BOTH;
        gbc_JIFAltaDeCurso.gridx = 0;
        gbc_JIFAltaDeCurso.gridy = 0;
        contentPane.add(JIFAltaDeCurso, gbc_JIFAltaDeCurso);
        GridBagConstraints gbc_JIFAltaDeEdicionDeCurso = new GridBagConstraints();
        gbc_JIFAltaDeEdicionDeCurso.fill = GridBagConstraints.BOTH;
        gbc_JIFAltaDeEdicionDeCurso.gridx = 0;
        gbc_JIFAltaDeEdicionDeCurso.gridy = 0;
        contentPane.add(JIFAltaDeEdicionDeCurso, gbc_JIFAltaDeEdicionDeCurso);
        GridBagConstraints gbc_JIFModificarDatosDeUsuario = new GridBagConstraints();
        gbc_JIFModificarDatosDeUsuario.fill = GridBagConstraints.BOTH;
        gbc_JIFModificarDatosDeUsuario.gridx = 0;
        gbc_JIFModificarDatosDeUsuario.gridy = 0;
        contentPane.add(JIFModificarDatosDeUsuario, gbc_JIFModificarDatosDeUsuario);
        GridBagConstraints gbc_JIFCrearProgramaDeFormacion = new GridBagConstraints();
        gbc_JIFCrearProgramaDeFormacion.fill = GridBagConstraints.BOTH;
        gbc_JIFCrearProgramaDeFormacion.gridx = 0;
        gbc_JIFCrearProgramaDeFormacion.gridy = 0;
        contentPane.add(JIFCrearProgramaDeFormacion, gbc_JIFCrearProgramaDeFormacion);
        GridBagConstraints gbc_JIFConsultaDeEdicionDeCurso = new GridBagConstraints();
        gbc_JIFConsultaDeEdicionDeCurso.fill = GridBagConstraints.BOTH;
        gbc_JIFConsultaDeEdicionDeCurso.gridx = 0;
        gbc_JIFConsultaDeEdicionDeCurso.gridy = 0;
        contentPane.add(JIFConsultaDeEdicionDeCurso, gbc_JIFConsultaDeEdicionDeCurso);
        GridBagConstraints gbc_JIFConsultaDeUsuario = new GridBagConstraints();
        gbc_JIFConsultaDeUsuario.fill = GridBagConstraints.BOTH;
        gbc_JIFConsultaDeUsuario.gridx = 0;
        gbc_JIFConsultaDeUsuario.gridy = 0;
        contentPane.add(JIFConsultaDeUsuario, gbc_JIFConsultaDeUsuario);
        GridBagConstraints gbc_JIFInscripcionAEdicionDeCurso = new GridBagConstraints();
        gbc_JIFInscripcionAEdicionDeCurso.fill = GridBagConstraints.BOTH;
        gbc_JIFInscripcionAEdicionDeCurso.gridx = 0;
        gbc_JIFInscripcionAEdicionDeCurso.gridy = 0;
        contentPane.add(JIFInscripcionAEdicionDeCurso, gbc_JIFInscripcionAEdicionDeCurso);
        GridBagConstraints gbc_JIFConsultaDeCurso = new GridBagConstraints();
        gbc_JIFConsultaDeCurso.fill = GridBagConstraints.BOTH;
        gbc_JIFConsultaDeCurso.gridx = 0;
        gbc_JIFConsultaDeCurso.gridy = 0;
        contentPane.add(JIFConsultaDeCurso, gbc_JIFConsultaDeCurso);
        GridBagConstraints gbc_JIFAgregarCursoAProgramaDeFormacion = new GridBagConstraints();
        gbc_JIFAgregarCursoAProgramaDeFormacion.fill = GridBagConstraints.BOTH;
        gbc_JIFAgregarCursoAProgramaDeFormacion.gridx = 0;
        gbc_JIFAgregarCursoAProgramaDeFormacion.gridy = 0;
        contentPane.add(JIFAgregarCursoAProgramaDeFormacion, gbc_JIFAgregarCursoAProgramaDeFormacion);
        GridBagConstraints gbc_JIFAltaDeUsuario = new GridBagConstraints();
        gbc_JIFAltaDeUsuario.fill = GridBagConstraints.BOTH;
        gbc_JIFAltaDeUsuario.gridx = 0;
        gbc_JIFAltaDeUsuario.gridy = 0;
        contentPane.add(JIFAltaDeUsuario, gbc_JIFAltaDeUsuario);
        GridBagConstraints gbc_JIFConsultaDeProgramaDeFormacion = new GridBagConstraints();
        gbc_JIFConsultaDeProgramaDeFormacion.fill = GridBagConstraints.BOTH;
        gbc_JIFConsultaDeProgramaDeFormacion.gridx = 0;
        gbc_JIFConsultaDeProgramaDeFormacion.gridy = 0;
        contentPane.add(JIFConsultaDeProgramaDeFormacion, gbc_JIFConsultaDeProgramaDeFormacion);
        GridBagConstraints gbc_JIFAltaDeInstituto = new GridBagConstraints();
        gbc_JIFAltaDeInstituto.fill = GridBagConstraints.BOTH;
        gbc_JIFAltaDeInstituto.gridx = 0;
        gbc_JIFAltaDeInstituto.gridy = 0;
        contentPane.add(JIFAltaDeInstituto, gbc_JIFAltaDeInstituto);
        
        GridBagConstraints gbc_JIFAltaDeCategoria = new GridBagConstraints();
        gbc_JIFAltaDeCategoria.fill = GridBagConstraints.BOTH;
        gbc_JIFAltaDeCategoria.gridx = 0;
        gbc_JIFAltaDeCategoria.gridy = 0;
        contentPane.add(JIFAltaDeCategoria, gbc_JIFAltaDeCategoria);
        
        
	}

} 