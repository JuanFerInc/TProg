package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import logica.ctrleinterfaces.Fabrica;
import logica.ctrleinterfaces.interfaceCurso;
import logica.ctrleinterfaces.interfaceUsuario;
import logica.datatypes.DtEdicion;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;
import java.awt.event.ActionEvent;

public class InscripcionAEdicionDeCurso extends JInternalFrame{
	private JTextField txtNombre;
	private JTextField txtCupos;
	private JTextField txtInicio;
	private JTextField txtFin;
	private JComboBox <String> cbInstituto;
	private JComboBox <String> cbCurso;
	private JComboBox <String> cbDocentes;
	private JComboBox <String> cbEstudiante;
	private JSpinner spDia;
	private JSpinner spMes;
	private JSpinner spAnio;
	private JTextField txtVideo;
	public InscripcionAEdicionDeCurso() {
		setTitle("Inscripcion a Edicion de Curso");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{47, 62, 57, 74, 71, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 55, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
	
		JLabel lblInstituto = new JLabel("Instituto :");
		GridBagConstraints gbc_lblInstituto = new GridBagConstraints();
		gbc_lblInstituto.gridwidth = 2;
		gbc_lblInstituto.insets = new Insets(0, 0, 5, 5);
		gbc_lblInstituto.gridx = 0;
		gbc_lblInstituto.gridy = 0;
		getContentPane().add(lblInstituto, gbc_lblInstituto);
		
		cbInstituto = new JComboBox <String>();
		GridBagConstraints gbc_cbInstituto = new GridBagConstraints();
		gbc_cbInstituto.gridwidth = 3;
		gbc_cbInstituto.insets = new Insets(0, 0, 5, 5);
		gbc_cbInstituto.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbInstituto.gridx = 2;
		gbc_cbInstituto.gridy = 0;
		getContentPane().add(cbInstituto, gbc_cbInstituto);
		
		JButton btnElegir = new JButton("Elegir");
		btnElegir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfaceCurso c = Fabrica.getInstancia().getICurso();
				Set<String> amigoset;
				cbCurso.removeAllItems();
				cbCurso.addItem("NONE");
				if(!cbInstituto.getSelectedItem().toString().equals("NONE")) {
					amigoset = c.seleccionarInstituto(cbInstituto.getSelectedItem().toString());
					for(String lol: amigoset) {
						cbCurso.addItem(lol);
					}
				}else {
					cartelito("No se puede dejar campos vacios o con el valor NONE");
				}
				
			}
		});
		GridBagConstraints gbc_btnElegir = new GridBagConstraints();
		gbc_btnElegir.insets = new Insets(0, 0, 5, 0);
		gbc_btnElegir.gridx = 5;
		gbc_btnElegir.gridy = 0;
		getContentPane().add(btnElegir, gbc_btnElegir);
		
		JLabel lblCurso = new JLabel("Curso :");
		GridBagConstraints gbc_lblCurso = new GridBagConstraints();
		gbc_lblCurso.gridwidth = 2;
		gbc_lblCurso.insets = new Insets(0, 0, 5, 5);
		gbc_lblCurso.gridx = 0;
		gbc_lblCurso.gridy = 1;
		getContentPane().add(lblCurso, gbc_lblCurso);
		
		cbCurso = new JComboBox<String>();
		GridBagConstraints gbc_cbCurso = new GridBagConstraints();
		gbc_cbCurso.gridwidth = 3;
		gbc_cbCurso.insets = new Insets(0, 0, 5, 5);
		gbc_cbCurso.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbCurso.gridx = 2;
		gbc_cbCurso.gridy = 1;
		getContentPane().add(cbCurso, gbc_cbCurso);
		
		JButton btnElegir_1 = new JButton("Elegir");
		btnElegir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfaceCurso c = Fabrica.getInstancia().getICurso();
				Set<String> mainbronce7;
				if(!cbCurso.getSelectedItem().toString().equals("NONE")) {
					c.seleccionarCurso(cbCurso.getSelectedItem().toString());
					boolean existe = c.existeEdicionVigenteDeCurso();
					if(existe) {
						DtEdicion dt = (DtEdicion) c.mostrarEdicionVigenteDeCurso();
						mainbronce7 = dt.getDocentesParticipan();
						for(String jorge: mainbronce7) {
							cbDocentes.addItem(jorge);
						}
						interfaceUsuario IUsuario = Fabrica.getInstancia().getIUsuario();
						txtNombre.setText(dt.getNombre());;
						txtCupos.setText(Integer.toString(dt.getCupo()));;
						txtInicio.setText(IUsuario.fechaDecente(dt.getInicio()));
						txtFin.setText(IUsuario.fechaDecente(dt.getFin()));
						mainbronce7 = IUsuario.listarEstudiantes();
						for(String jorge: mainbronce7) {
							cbEstudiante.addItem(jorge);
						}
					}else {
						cartelito("No existe edicion vigente del curso");
		 			}
				}else {
					cartelito("No puede haber un campo vacio o con el valor NONE");
				}
			}
		});
		GridBagConstraints gbc_btnElegir_1 = new GridBagConstraints();
		gbc_btnElegir_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnElegir_1.gridx = 5;
		gbc_btnElegir_1.gridy = 1;
		getContentPane().add(btnElegir_1, gbc_btnElegir_1);
		
		JLabel lblNewLabel = new JLabel("Datos de la Edicion Vigente (si existe)");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridwidth = 6;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre :");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.gridwidth = 2;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 3;
		getContentPane().add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.gridwidth = 2;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 3;
		getContentPane().add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblCupos = new JLabel("Cupos :");
		GridBagConstraints gbc_lblCupos = new GridBagConstraints();
		gbc_lblCupos.insets = new Insets(0, 0, 5, 5);
		gbc_lblCupos.gridx = 4;
		gbc_lblCupos.gridy = 3;
		getContentPane().add(lblCupos, gbc_lblCupos);
		
		txtCupos = new JTextField();
		txtCupos.setEditable(false);
		GridBagConstraints gbc_txtCupos = new GridBagConstraints();
		gbc_txtCupos.insets = new Insets(0, 0, 5, 0);
		gbc_txtCupos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCupos.gridx = 5;
		gbc_txtCupos.gridy = 3;
		getContentPane().add(txtCupos, gbc_txtCupos);
		txtCupos.setColumns(10);
		
		JLabel lblInicio = new JLabel("Inicio :");
		GridBagConstraints gbc_lblInicio = new GridBagConstraints();
		gbc_lblInicio.anchor = GridBagConstraints.WEST;
		gbc_lblInicio.insets = new Insets(0, 0, 5, 5);
		gbc_lblInicio.gridx = 1;
		gbc_lblInicio.gridy = 4;
		getContentPane().add(lblInicio, gbc_lblInicio);
		
		txtInicio = new JTextField();
		txtInicio.setEditable(false);
		GridBagConstraints gbc_txtInicio = new GridBagConstraints();
		gbc_txtInicio.gridwidth = 2;
		gbc_txtInicio.insets = new Insets(0, 0, 5, 5);
		gbc_txtInicio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInicio.gridx = 2;
		gbc_txtInicio.gridy = 4;
		getContentPane().add(txtInicio, gbc_txtInicio);
		txtInicio.setColumns(10);
		
		JLabel lblFin = new JLabel("Fin :");
		GridBagConstraints gbc_lblFin = new GridBagConstraints();
		gbc_lblFin.insets = new Insets(0, 0, 5, 5);
		gbc_lblFin.gridx = 4;
		gbc_lblFin.gridy = 4;
		getContentPane().add(lblFin, gbc_lblFin);
		
		txtFin = new JTextField();
		txtFin.setEditable(false);
		GridBagConstraints gbc_txtFin = new GridBagConstraints();
		gbc_txtFin.insets = new Insets(0, 0, 5, 0);
		gbc_txtFin.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFin.gridx = 5;
		gbc_txtFin.gridy = 4;
		getContentPane().add(txtFin, gbc_txtFin);
		txtFin.setColumns(10);
		
		JLabel lblVideo = new JLabel("Video");
		GridBagConstraints gbc_lblVideo = new GridBagConstraints();
		gbc_lblVideo.anchor = GridBagConstraints.WEST;
		gbc_lblVideo.insets = new Insets(0, 0, 5, 5);
		gbc_lblVideo.gridx = 1;
		gbc_lblVideo.gridy = 5;
		getContentPane().add(lblVideo, gbc_lblVideo);
		
		txtVideo = new JTextField();
		GridBagConstraints gbc_txtVideo = new GridBagConstraints();
		gbc_txtVideo.gridwidth = 3;
		gbc_txtVideo.insets = new Insets(0, 0, 5, 5);
		gbc_txtVideo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtVideo.gridx = 2;
		gbc_txtVideo.gridy = 5;
		getContentPane().add(txtVideo, gbc_txtVideo);
		txtVideo.setColumns(10);
	
		JLabel lblDocentes = new JLabel("Docentes :");
		GridBagConstraints gbc_lblDocentes = new GridBagConstraints();
		gbc_lblDocentes.gridwidth = 2;
		gbc_lblDocentes.insets = new Insets(0, 0, 5, 5);
		gbc_lblDocentes.gridx = 0;
		gbc_lblDocentes.gridy = 6;
		getContentPane().add(lblDocentes, gbc_lblDocentes);
		
		cbDocentes = new JComboBox<String>();
		GridBagConstraints gbc_cbDocentes = new GridBagConstraints();
		gbc_cbDocentes.gridwidth = 3;
		gbc_cbDocentes.insets = new Insets(0, 0, 5, 5);
		gbc_cbDocentes.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbDocentes.gridx = 2;
		gbc_cbDocentes.gridy = 6;
		getContentPane().add(cbDocentes, gbc_cbDocentes);
		
		JLabel lblEstudianteAInscribir = new JLabel("Estudiante a inscribir :");
		GridBagConstraints gbc_lblEstudianteAInscribir = new GridBagConstraints();
		gbc_lblEstudianteAInscribir.gridwidth = 2;
		gbc_lblEstudianteAInscribir.anchor = GridBagConstraints.EAST;
		gbc_lblEstudianteAInscribir.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstudianteAInscribir.gridx = 0;
		gbc_lblEstudianteAInscribir.gridy = 7;
		getContentPane().add(lblEstudianteAInscribir, gbc_lblEstudianteAInscribir);
		
		cbEstudiante = new JComboBox <String>();
		GridBagConstraints gbc_cbEstudiante = new GridBagConstraints();
		gbc_cbEstudiante.insets = new Insets(0, 0, 5, 0);
		gbc_cbEstudiante.gridwidth = 4;
		gbc_cbEstudiante.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbEstudiante.gridx = 2;
		gbc_cbEstudiante.gridy = 7;
		getContentPane().add(cbEstudiante, gbc_cbEstudiante);
		
		JLabel lblFechaDeInscripcion = new JLabel("Fecha de Inscripcion");
		GridBagConstraints gbc_lblFechaDeInscripcion = new GridBagConstraints();
		gbc_lblFechaDeInscripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeInscripcion.gridx = 2;
		gbc_lblFechaDeInscripcion.gridy = 8;
		getContentPane().add(lblFechaDeInscripcion, gbc_lblFechaDeInscripcion);
		
		JLabel lblDia = new JLabel("Dia :");
		GridBagConstraints gbc_lblDia = new GridBagConstraints();
		gbc_lblDia.insets = new Insets(0, 0, 5, 5);
		gbc_lblDia.gridx = 0;
		gbc_lblDia.gridy = 9;
		getContentPane().add(lblDia, gbc_lblDia);
		
		spDia = new JSpinner();
		spDia.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		GridBagConstraints gbc_spDia = new GridBagConstraints();
		gbc_spDia.insets = new Insets(0, 0, 5, 5);
		gbc_spDia.gridx = 1;
		gbc_spDia.gridy = 9;
		getContentPane().add(spDia, gbc_spDia);
		
		JLabel lblMes = new JLabel("Mes :");
		GridBagConstraints gbc_lblMes = new GridBagConstraints();
		gbc_lblMes.insets = new Insets(0, 0, 5, 5);
		gbc_lblMes.gridx = 2;
		gbc_lblMes.gridy = 9;
		getContentPane().add(lblMes, gbc_lblMes);
		
		spMes = new JSpinner();
		spMes.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		GridBagConstraints gbc_spMes = new GridBagConstraints();
		gbc_spMes.insets = new Insets(0, 0, 5, 5);
		gbc_spMes.gridx = 3;
		gbc_spMes.gridy = 9;
		getContentPane().add(spMes, gbc_spMes);
		
		JLabel lblAnio = new JLabel("Anio :");
		GridBagConstraints gbc_lblAnio = new GridBagConstraints();
		gbc_lblAnio.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnio.gridx = 4;
		gbc_lblAnio.gridy = 9;
		getContentPane().add(lblAnio, gbc_lblAnio);
	
		spAnio = new JSpinner();
		spAnio.setModel(new SpinnerNumberModel(1, 1, 3000,1));
		GridBagConstraints gbc_spAnio = new GridBagConstraints();
		gbc_spAnio.insets = new Insets(0, 0, 5, 0);
		gbc_spAnio.gridx = 5;
		gbc_spAnio.gridy = 9;
		getContentPane().add(spAnio, gbc_spAnio);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkswing()){
					interfaceUsuario u = Fabrica.getInstancia().getIUsuario();
					interfaceCurso c = Fabrica.getInstancia().getICurso();
					Calendar fechita = new GregorianCalendar((int) spAnio.getValue(),(int) spMes.getValue(),(int) spDia.getValue()); 
					String video = txtVideo.getSelectedText();
					u.seleccionarEstudiante(cbEstudiante.getSelectedItem().toString());
					try {
					u.inscribirEstudianteACurso(fechita,video);
					}catch(Exception ela) {};
					limpiar();
					setVisible(false);
					
					c.salir();
					u.salir();
				}
			}
		});
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 2;
		gbc_btnAceptar.gridy = 10;
		getContentPane().add(btnAceptar, gbc_btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				setVisible(false);
				interfaceUsuario u = Fabrica.getInstancia().getIUsuario();
				interfaceCurso c = Fabrica.getInstancia().getICurso();
				c.salir();
				u.salir();
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 4;
		gbc_btnCancelar.gridy = 10;
		getContentPane().add(btnCancelar, gbc_btnCancelar);
	}
	
	private void limpiar() {
		cbEstudiante.removeAllItems();
		cbCurso.removeAllItems();
		cbInstituto.removeAllItems();
		cbDocentes.removeAllItems();
		txtNombre.setText("");
		txtCupos.setText("");
		txtInicio.setText("");
		txtFin.setText("");
		spAnio.setValue(1);
		spMes.setValue(1);
		spDia.setValue(1);
	}
	public void cargarDatosIAEDC() {
		cbEstudiante.addItem("NONE");
		cbCurso.addItem("NONE");
		cbInstituto.addItem("NONE");
		interfaceCurso c = Fabrica.getInstancia().getICurso();
		Set<String> cacadevaca = c.listarInstitutos();
		for(String caquita:cacadevaca) {
			cbInstituto.addItem(caquita);
		}
	}
	private void cartelito(String txt) {
		JOptionPane.showMessageDialog(this, txt, "Inscripcion a edicion de curso", JOptionPane.ERROR_MESSAGE);
	}
	private boolean checkswing(){
		int a = (int) spAnio.getValue();
		int b = (int) spMes.getValue();
		int c = (int) spDia.getValue();
		if (c>31 || c<1 || b>12 || b<-1 || a<-1) {
			JOptionPane.showMessageDialog(this, "Las fechas no son validas", "Inscripcion a edicion de curso", JOptionPane.ERROR_MESSAGE);
            return false;
        }
		return true;
	}
}
