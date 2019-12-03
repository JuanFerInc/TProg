package presentacion;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import logica.ctrleinterfaces.Fabrica;
import logica.ctrleinterfaces.interfaceCurso;
import logica.ctrleinterfaces.interfaceUsuario;
import logica.datatypes.DtCurso;
import logica.datatypes.DtCursoDatosyEdiciones;

public class ConsultaDeCurso extends JInternalFrame{
	private JTextField textNombre;
	private JTextField textDuracion;
	private JTextField textHora;
	private JTextField textURL;
	private JTextField textCreditos;
	private JTextField textFecha;
	private JComboBox<String> cxInstituto;
	private JComboBox<String> cxCursos;
	private JComboBox<String> cxPrevias;
	private JComboBox<String> cxEdiciones;
	private JComboBox<String> cxProgramas;
	private JComboBox<String> cxCategorias;
	private ConsultaDeCursoE infoE;
	private ConsultaDeCursoP infoP;
	private JTextArea textDescripcion;
	
	private interfaceCurso ICurso;
	private interfaceUsuario IUsuario;
	
	
	public ConsultaDeCurso() {
		ICurso = Fabrica.getInstancia().getICurso();
		IUsuario = Fabrica.getInstancia().getIUsuario();
		infoE = new ConsultaDeCursoE();
		infoP = new ConsultaDeCursoP();
		
		setTitle("Consulta de Curso");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{75, 71, 112, 69, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblInstituto = new JLabel("Instituto :");
		GridBagConstraints gbc_lblInstituto = new GridBagConstraints();
		gbc_lblInstituto.insets = new Insets(0, 0, 5, 5);
		gbc_lblInstituto.gridx = 0;
		gbc_lblInstituto.gridy = 0;
		getContentPane().add(lblInstituto, gbc_lblInstituto);
		
		cxInstituto = new JComboBox<String>();
		GridBagConstraints gbc_cxInstituto = new GridBagConstraints();
		gbc_cxInstituto.fill = GridBagConstraints.HORIZONTAL;
		gbc_cxInstituto.gridwidth = 3;
		gbc_cxInstituto.insets = new Insets(0, 0, 5, 5);
		gbc_cxInstituto.gridx = 1;
		gbc_cxInstituto.gridy = 0;
		getContentPane().add(cxInstituto, gbc_cxInstituto);
		
		JButton btnElegirInstitutos = new JButton("Elegir");
		btnElegirInstitutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cxCursos.removeAllItems();
				cargarCursos();
			}
		});
		GridBagConstraints gbc_btnElegirInstitutos = new GridBagConstraints();
		gbc_btnElegirInstitutos.insets = new Insets(0, 0, 5, 0);
		gbc_btnElegirInstitutos.gridx = 4;
		gbc_btnElegirInstitutos.gridy = 0;
		getContentPane().add(btnElegirInstitutos, gbc_btnElegirInstitutos);
		
		JLabel lblCursos = new JLabel("Cursos :");
		GridBagConstraints gbc_lblCursos = new GridBagConstraints();
		gbc_lblCursos.insets = new Insets(0, 0, 5, 5);
		gbc_lblCursos.gridx = 0;
		gbc_lblCursos.gridy = 1;
		getContentPane().add(lblCursos, gbc_lblCursos);
		
		cxCursos = new JComboBox<String>();
		GridBagConstraints gbc_cxCursos = new GridBagConstraints();
		gbc_cxCursos.fill = GridBagConstraints.HORIZONTAL;
		gbc_cxCursos.gridwidth = 3;
		gbc_cxCursos.insets = new Insets(0, 0, 5, 5);
		gbc_cxCursos.gridx = 1;
		gbc_cxCursos.gridy = 1;
		getContentPane().add(cxCursos, gbc_cxCursos);
		
		JButton btnElegirCurso = new JButton("Elegir");
		btnElegirCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarDatosCurso();
				
			}
		});
		GridBagConstraints gbc_btnElegirCurso = new GridBagConstraints();
		gbc_btnElegirCurso.insets = new Insets(0, 0, 5, 0);
		gbc_btnElegirCurso.gridx = 4;
		gbc_btnElegirCurso.gridy = 1;
		getContentPane().add(btnElegirCurso, gbc_btnElegirCurso);
		
		JLabel lblNewLabel = new JLabel("Datos de curso");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridwidth = 5;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre :");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 3;
		getContentPane().add(lblNombre, gbc_lblNombre);
		
		textNombre = new JTextField();
		GridBagConstraints gbc_textNombre = new GridBagConstraints();
		gbc_textNombre.gridwidth = 2;
		gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textNombre.gridx = 1;
		gbc_textNombre.gridy = 3;
		getContentPane().add(textNombre, gbc_textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Duracion :");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 3;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textDuracion = new JTextField();
		GridBagConstraints gbc_textDuracion = new GridBagConstraints();
		gbc_textDuracion.insets = new Insets(0, 0, 5, 0);
		gbc_textDuracion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDuracion.gridx = 4;
		gbc_textDuracion.gridy = 3;
		getContentPane().add(textDuracion, gbc_textDuracion);
		textDuracion.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion :");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 0;
		gbc_lblDescripcion.gridy = 4;
		getContentPane().add(lblDescripcion, gbc_lblDescripcion);
		
		textDescripcion = new JTextArea();
		GridBagConstraints gbc_textDescripcion = new GridBagConstraints();
		gbc_textDescripcion.gridwidth = 2;
		gbc_textDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_textDescripcion.fill = GridBagConstraints.BOTH;
		gbc_textDescripcion.gridx = 1;
		gbc_textDescripcion.gridy = 4;
		getContentPane().add(textDescripcion, gbc_textDescripcion);
		
		JLabel lblNewLabel_2 = new JLabel("horas :");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 4;
		getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textHora = new JTextField();
		GridBagConstraints gbc_textHora = new GridBagConstraints();
		gbc_textHora.insets = new Insets(0, 0, 5, 0);
		gbc_textHora.fill = GridBagConstraints.HORIZONTAL;
		gbc_textHora.gridx = 4;
		gbc_textHora.gridy = 4;
		getContentPane().add(textHora, gbc_textHora);
		textHora.setColumns(10);
		
		JLabel lblUrl = new JLabel("URL :");
		GridBagConstraints gbc_lblUrl = new GridBagConstraints();
		gbc_lblUrl.insets = new Insets(0, 0, 5, 5);
		gbc_lblUrl.gridx = 0;
		gbc_lblUrl.gridy = 5;
		getContentPane().add(lblUrl, gbc_lblUrl);
		
		textURL = new JTextField();
		GridBagConstraints gbc_textURL = new GridBagConstraints();
		gbc_textURL.gridwidth = 2;
		gbc_textURL.fill = GridBagConstraints.HORIZONTAL;
		gbc_textURL.insets = new Insets(0, 0, 5, 5);
		gbc_textURL.gridx = 1;
		gbc_textURL.gridy = 5;
		getContentPane().add(textURL, gbc_textURL);
		textURL.setColumns(10);
		
		JLabel lblCreditos = new JLabel("Creditos :");
		GridBagConstraints gbc_lblCreditos = new GridBagConstraints();
		gbc_lblCreditos.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreditos.gridx = 3;
		gbc_lblCreditos.gridy = 5;
		getContentPane().add(lblCreditos, gbc_lblCreditos);
	
		textCreditos = new JTextField();
		GridBagConstraints gbc_textCreditos = new GridBagConstraints();
		gbc_textCreditos.insets = new Insets(0, 0, 5, 0);
		gbc_textCreditos.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCreditos.gridx = 4;
		gbc_textCreditos.gridy = 5;
		getContentPane().add(textCreditos, gbc_textCreditos);
		textCreditos.setColumns(10);
		
		JLabel lblFechaDeAlta = new JLabel("Fecha de alta :");
		GridBagConstraints gbc_lblFechaDeAlta = new GridBagConstraints();
		gbc_lblFechaDeAlta.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeAlta.gridx = 0;
		gbc_lblFechaDeAlta.gridy = 6;
		getContentPane().add(lblFechaDeAlta, gbc_lblFechaDeAlta);
		
		textFecha = new JTextField();
		GridBagConstraints gbc_textFecha = new GridBagConstraints();
		gbc_textFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFecha.insets = new Insets(0, 0, 5, 0);
		gbc_textFecha.gridwidth = 4;
		gbc_textFecha.gridx = 1;
		gbc_textFecha.gridy = 6;
		getContentPane().add(textFecha, gbc_textFecha);
		textFecha.setColumns(10);
		
		JLabel lblPrevias = new JLabel("Previas :");
		GridBagConstraints gbc_lblPrevias = new GridBagConstraints();
		gbc_lblPrevias.anchor = GridBagConstraints.EAST;
		gbc_lblPrevias.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrevias.gridx = 0;
		gbc_lblPrevias.gridy = 7;
		getContentPane().add(lblPrevias, gbc_lblPrevias);
		
		cxPrevias = new JComboBox<String>();
		GridBagConstraints gbc_cxPrevias = new GridBagConstraints();
		gbc_cxPrevias.gridwidth = 4;
		gbc_cxPrevias.insets = new Insets(0, 0, 5, 0);
		gbc_cxPrevias.fill = GridBagConstraints.HORIZONTAL;
		gbc_cxPrevias.gridx = 1;
		gbc_cxPrevias.gridy = 7;
		getContentPane().add(cxPrevias, gbc_cxPrevias);
		
		JLabel lblNewLabel_3 = new JLabel("Ediciones :");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 8;
		getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		cxEdiciones = new JComboBox<String>();
		GridBagConstraints gbc_cxEdiciones = new GridBagConstraints();
		gbc_cxEdiciones.gridwidth = 3;
		gbc_cxEdiciones.insets = new Insets(0, 0, 5, 5);
		gbc_cxEdiciones.fill = GridBagConstraints.HORIZONTAL;
		gbc_cxEdiciones.gridx = 1;
		gbc_cxEdiciones.gridy = 8;
		getContentPane().add(cxEdiciones, gbc_cxEdiciones);
		
		
		
		JButton btnDatosEdicion = new JButton("Datos");
		btnDatosEdicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				infoE.setVisible(true);
				infoP.setVisible(false);
				String hola=cxEdiciones.getSelectedItem().toString();
				infoE.cargarDatosCDCE(hola);
			}
		});
		GridBagConstraints gbc_btnDatosEdicion = new GridBagConstraints();
		gbc_btnDatosEdicion.insets = new Insets(0, 0, 5, 0);
		gbc_btnDatosEdicion.gridx = 4;
		gbc_btnDatosEdicion.gridy = 8;
		getContentPane().add(btnDatosEdicion, gbc_btnDatosEdicion);
		
		JLabel lblProgramas = new JLabel("Programas :");
		GridBagConstraints gbc_lblProgramas = new GridBagConstraints();
		gbc_lblProgramas.anchor = GridBagConstraints.EAST;
		gbc_lblProgramas.insets = new Insets(0, 0, 5, 5);
		gbc_lblProgramas.gridx = 0;
		gbc_lblProgramas.gridy = 9;
		getContentPane().add(lblProgramas, gbc_lblProgramas);
		
		cxProgramas = new JComboBox<String>();
		GridBagConstraints gbc_cxProgramas = new GridBagConstraints();
		gbc_cxProgramas.gridwidth = 3;
		gbc_cxProgramas.insets = new Insets(0, 0, 5, 5);
		gbc_cxProgramas.fill = GridBagConstraints.HORIZONTAL;
		gbc_cxProgramas.gridx = 1;
		gbc_cxProgramas.gridy = 9;
		getContentPane().add(cxProgramas, gbc_cxProgramas);
		
		JButton btnDatosProgramas = new JButton("Datos");
		btnDatosProgramas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				infoE.setVisible(false);
				infoP.setVisible(true);
				String hola = cxProgramas.getSelectedItem().toString();
				infoP.cargarDatosCDCP(hola);
			}
		});
		GridBagConstraints gbc_btnDatosProgramas = new GridBagConstraints();
		gbc_btnDatosProgramas.insets = new Insets(0, 0, 5, 0);
		gbc_btnDatosProgramas.gridx = 4;
		gbc_btnDatosProgramas.gridy = 9;
		getContentPane().add(btnDatosProgramas, gbc_btnDatosProgramas);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				ICurso.salir();
				setVisible(false);
			}
		});
		
		JLabel lblCategorias = new JLabel("Categorias");
		GridBagConstraints gbc_lblCategorias = new GridBagConstraints();
		gbc_lblCategorias.anchor = GridBagConstraints.EAST;
		gbc_lblCategorias.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategorias.gridx = 0;
		gbc_lblCategorias.gridy = 10;
		getContentPane().add(lblCategorias, gbc_lblCategorias);
		
		cxCategorias = new JComboBox<String>();
		GridBagConstraints gbc_cxCategorias = new GridBagConstraints();
		gbc_cxCategorias.insets = new Insets(0, 0, 5, 5);
		gbc_cxCategorias.fill = GridBagConstraints.HORIZONTAL;
		gbc_cxCategorias.gridx = 1;
		gbc_cxCategorias.gridy = 10;
		getContentPane().add(cxCategorias, gbc_cxCategorias);
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 2;
		gbc_btnAceptar.gridy = 10;
		getContentPane().add(btnAceptar, gbc_btnAceptar);
		
		infoE=new ConsultaDeCursoE();
		infoE.setVisible(false);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridwidth = 5;
		gbc.gridx = 2;
		gbc.gridy = 11;
		getContentPane().add(infoE, gbc);
		
		infoP=new ConsultaDeCursoP();
		infoP.setVisible(false);
		GridBagConstraints gbcp = new GridBagConstraints();
		gbcp.fill = GridBagConstraints.BOTH;
		gbcp.gridwidth = 5;
		gbcp.gridx = 2;
		gbcp.gridy = 11;
		getContentPane().add(infoP, gbcp);
		
	}
	public void cargarInstitutos() {
		cxInstituto.addItem("NONE");
		Set<String> nombreInstitutos = ICurso.listarInstitutos();
		for(String iter: nombreInstitutos) {
			cxInstituto.addItem(iter);
		}
		
	}
	private void cargarCursos() {
		cxCursos.addItem("NONE");
		String nombreInstituto = cxInstituto.getSelectedItem().toString();
		if(nombreInstituto != "NONE") {
			Set<String> nombreCursos = ICurso.seleccionarInstituto(nombreInstituto);
			for(String iter: nombreCursos) {
				cxCursos.addItem(iter);
				
			}	
		}	
	}

	private void cargarDatosCurso() {
		String nombreCurso = cxCursos.getSelectedItem().toString();
		cxPrevias.removeAllItems();
		cxProgramas.removeAllItems();
		cxEdiciones.removeAllItems();
		cxPrevias.removeAllItems();
		
		if(nombreCurso != "NONE") {
			DtCurso datosCurso = ICurso.verDatosCurso(nombreCurso);
			textNombre.setText(datosCurso.getNombre());
			textDescripcion.setText(datosCurso.getDescripcion());
			textURL.setText(datosCurso.getURL());
			textDuracion.setText(Integer.toString(datosCurso.getDuracion()));
			textHora.setText(Integer.toString( datosCurso.getHoras()));
			textCreditos.setText(Integer.toString(datosCurso.getCreditos()));
			textFecha.setText(IUsuario.fechaDecente(datosCurso.getFechaRegistrado()));
			
			//Cargar previas
			Set<String> cursoPrevias = datosCurso.getPrevias();
			if(cursoPrevias.isEmpty()) {
				cxPrevias.addItem("NONE");
			}else {
				for(String iter: cursoPrevias) {
					cxPrevias.addItem(iter);
				}
			}
			//Cargar Ediciones
			Set<String> cursoEdiciones = ((DtCursoDatosyEdiciones)datosCurso).getEdiciones();
			if(cursoEdiciones.isEmpty()) {
				cxEdiciones.addItem("NONE");
			}else {
				for(String iter: cursoEdiciones) {
					cxEdiciones.addItem(iter);
				}
			}
			//Cargar Programas
			Set<String> cursoProgramas = ((DtCursoDatosyEdiciones)datosCurso).getProgramas();
			if(cursoProgramas.isEmpty()) {
				cxProgramas.addItem("NONE");
			}else {

				for(String iter2:cursoProgramas) {
					cxProgramas.addItem(iter2);
				}
				
			}
			//Cargar Categorias
			Set<String> categorias = datosCurso.getCategorias();
			for(String altoGatito:categorias) {
				cxCategorias.addItem(altoGatito);
			}
			
			
			
		}
		
		
	}
	private void limpiar() {
		cxInstituto.removeAllItems();
		cxCursos.removeAllItems();
		cxPrevias.removeAllItems();
		cxEdiciones.removeAllItems();
		cxProgramas.removeAllItems();
		textNombre.setText("");
		textDescripcion.setText("");
		textURL.setText("");
		textFecha.setText("");
		textDuracion.setText("");
		textHora.setText("");
		textCreditos.setText("");
		
	}
}
