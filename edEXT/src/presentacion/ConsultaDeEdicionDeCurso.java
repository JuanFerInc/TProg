package presentacion;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JTextField;

import logica.ctrleinterfaces.Fabrica;
import logica.ctrleinterfaces.interfaceCurso;
import logica.ctrleinterfaces.interfaceUsuario;
import logica.datatypes.DtEdicion;
import logica.datatypes.DtInstancia;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.Set;
import java.awt.event.ActionEvent;

public class ConsultaDeEdicionDeCurso extends JInternalFrame{
	private JTextField txtNombre;
	private JTextField txtFechaInicio;
	private JTextField txtFechaFin;
	private JTextField txtCupos;
	private JComboBox <String> cxInstituto;
	private JComboBox <String> cxCurso;
	private JComboBox <String>cxEdicion;
	private JComboBox <String> cxDocente;
	public ConsultaDeEdicionDeCurso() {
		setTitle("Consulta de Edicion de Curso");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{125, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblInstituto = new JLabel("Instituto :");
		GridBagConstraints gbc_lblInstituto = new GridBagConstraints();
		gbc_lblInstituto.insets = new Insets(0, 0, 5, 5);
		gbc_lblInstituto.gridx = 0;
		gbc_lblInstituto.gridy = 0;
		getContentPane().add(lblInstituto, gbc_lblInstituto);
		
		cxInstituto = new JComboBox<String>();
		GridBagConstraints gbc_cxInstituto = new GridBagConstraints();
		gbc_cxInstituto.insets = new Insets(0, 0, 5, 5);
		gbc_cxInstituto.fill = GridBagConstraints.HORIZONTAL;
		gbc_cxInstituto.gridx = 1;
		gbc_cxInstituto.gridy = 0;
		getContentPane().add(cxInstituto, gbc_cxInstituto);
		
		JButton btnElegir = new JButton("Elegir");
		btnElegir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cxCurso.removeAllItems();
				cxCurso.addItem("NONE");
				if(!cxInstituto.getSelectedItem().toString().equals("NONE")) {
					interfaceCurso c = Fabrica.getInstancia().getICurso();
					Set<String> tito = c.seleccionarInstituto(cxInstituto.getSelectedItem().toString());
					for(String pepito: tito ) {
						cxCurso.addItem(pepito);
					}
				}else {
					cartelito("No puede dejar campos vacios o con valor NONE");
				}
			}
		});
		GridBagConstraints gbc_btnElegir = new GridBagConstraints();
		gbc_btnElegir.insets = new Insets(0, 0, 5, 0);
		gbc_btnElegir.gridx = 2;
		gbc_btnElegir.gridy = 0;
		getContentPane().add(btnElegir, gbc_btnElegir);
		
		JLabel lblCurso = new JLabel("Curso :");
		GridBagConstraints gbc_lblCurso = new GridBagConstraints();
		gbc_lblCurso.insets = new Insets(0, 0, 5, 5);
		gbc_lblCurso.gridx = 0;
		gbc_lblCurso.gridy = 1;
		getContentPane().add(lblCurso, gbc_lblCurso);
		
		cxCurso = new JComboBox<String>();
		GridBagConstraints gbc_cxCurso = new GridBagConstraints();
		gbc_cxCurso.insets = new Insets(0, 0, 5, 5);
		gbc_cxCurso.fill = GridBagConstraints.HORIZONTAL;
		gbc_cxCurso.gridx = 1;
		gbc_cxCurso.gridy = 1;
		getContentPane().add(cxCurso, gbc_cxCurso);
		
		JButton btnElegir_1 = new JButton("Elegir");
		btnElegir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cxEdicion.removeAllItems();
				cxEdicion.addItem("NONE");
				if(!cxCurso.getSelectedItem().toString().equals("NONE")) {
					interfaceCurso ICurso = Fabrica.getInstancia().getICurso();
					ICurso.seleccionarCurso(cxCurso.getSelectedItem().toString());
					Set<String> ediciones = ICurso.mostrarEdiciones();
					for(String pepito: ediciones ) {
						cxEdicion.addItem(pepito);
					}
				}else {
					cartelito("No puede dejar campos vacios o con valor NONE");
				}
			}
		});
		GridBagConstraints gbc_btnElegir_1 = new GridBagConstraints();
		gbc_btnElegir_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnElegir_1.gridx = 2;
		gbc_btnElegir_1.gridy = 1;
		getContentPane().add(btnElegir_1, gbc_btnElegir_1);
		
		JLabel lblEdicion = new JLabel("Edicion :");
		GridBagConstraints gbc_lblEdicion = new GridBagConstraints();
		gbc_lblEdicion.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdicion.gridx = 0;
		gbc_lblEdicion.gridy = 2;
		getContentPane().add(lblEdicion, gbc_lblEdicion);
		
		cxEdicion = new JComboBox<String>();
		GridBagConstraints gbc_cxEdicion = new GridBagConstraints();
		gbc_cxEdicion.insets = new Insets(0, 0, 5, 5);
		gbc_cxEdicion.fill = GridBagConstraints.HORIZONTAL;
		gbc_cxEdicion.gridx = 1;
		gbc_cxEdicion.gridy = 2;
		getContentPane().add(cxEdicion, gbc_cxEdicion);
		
		JButton btnElegir_2 = new JButton("Elegir");
		btnElegir_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elegir2();
			}
		});
		GridBagConstraints gbc_btnElegir_2 = new GridBagConstraints();
		gbc_btnElegir_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnElegir_2.gridx = 2;
		gbc_btnElegir_2.gridy = 2;
		getContentPane().add(btnElegir_2, gbc_btnElegir_2);
		
		JLabel lblNewLabel = new JLabel("Datos de la Edicion");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNombre = new JLabel(" Nombre :");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 4;
		getContentPane().add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.gridwidth = 2;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 4;
		getContentPane().add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha de inicio :");
		GridBagConstraints gbc_lblFechaDeInicio = new GridBagConstraints();
		gbc_lblFechaDeInicio.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeInicio.gridx = 0;
		gbc_lblFechaDeInicio.gridy = 5;
		getContentPane().add(lblFechaDeInicio, gbc_lblFechaDeInicio);
		
		txtFechaInicio = new JTextField();
		txtFechaInicio.setEditable(false);
		GridBagConstraints gbc_txtFechaInicio = new GridBagConstraints();
		gbc_txtFechaInicio.gridwidth = 2;
		gbc_txtFechaInicio.insets = new Insets(0, 0, 5, 0);
		gbc_txtFechaInicio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFechaInicio.gridx = 1;
		gbc_txtFechaInicio.gridy = 5;
		getContentPane().add(txtFechaInicio, gbc_txtFechaInicio);
		txtFechaInicio.setColumns(10);
		
		JLabel lblFechaDeFinalizacion = new JLabel("Fecha de Finalizacion :");
		GridBagConstraints gbc_lblFechaDeFinalizacion = new GridBagConstraints();
		gbc_lblFechaDeFinalizacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeFinalizacion.gridx = 0;
		gbc_lblFechaDeFinalizacion.gridy = 6;
		getContentPane().add(lblFechaDeFinalizacion, gbc_lblFechaDeFinalizacion);
		
		txtFechaFin = new JTextField();
		txtFechaFin.setEditable(false);
		GridBagConstraints gbc_txtFechaFin = new GridBagConstraints();
		gbc_txtFechaFin.gridwidth = 2;
		gbc_txtFechaFin.insets = new Insets(0, 0, 5, 0);
		gbc_txtFechaFin.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFechaFin.gridx = 1;
		gbc_txtFechaFin.gridy = 6;
		getContentPane().add(txtFechaFin, gbc_txtFechaFin);
		txtFechaFin.setColumns(10);
		
		JLabel lblCupos = new JLabel("Cupos :");
		GridBagConstraints gbc_lblCupos = new GridBagConstraints();
		gbc_lblCupos.insets = new Insets(0, 0, 5, 5);
		gbc_lblCupos.gridx = 0;
		gbc_lblCupos.gridy = 7;
		getContentPane().add(lblCupos, gbc_lblCupos);
		
		txtCupos = new JTextField();
		txtCupos.setEditable(false);
		GridBagConstraints gbc_txtCupos = new GridBagConstraints();
		gbc_txtCupos.gridwidth = 2;
		gbc_txtCupos.insets = new Insets(0, 0, 5, 0);
		gbc_txtCupos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCupos.gridx = 1;
		gbc_txtCupos.gridy = 7;
		getContentPane().add(txtCupos, gbc_txtCupos);
		txtCupos.setColumns(10);
		
		cxDocente = new JComboBox<String>();
		GridBagConstraints gbc_cxDocente = new GridBagConstraints();
		gbc_cxDocente.gridwidth = 2;
		gbc_cxDocente.gridheight = 2;
		gbc_cxDocente.insets = new Insets(0, 0, 5, 5);
		gbc_cxDocente.fill = GridBagConstraints.HORIZONTAL;
		gbc_cxDocente.gridx = 1;
		gbc_cxDocente.gridy = 8;
		getContentPane().add(cxDocente, gbc_cxDocente);
		
		JLabel lblDocentes = new JLabel("Docentes :");
		GridBagConstraints gbc_lblDocentes = new GridBagConstraints();
		gbc_lblDocentes.gridheight = 2;
		gbc_lblDocentes.insets = new Insets(0, 0, 5, 5);
		gbc_lblDocentes.gridx = 0;
		gbc_lblDocentes.gridy = 8;
		getContentPane().add(lblDocentes, gbc_lblDocentes);
		
		interfaceCurso ICurso = Fabrica.getInstancia().getICurso();
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				setVisible(false);
				ICurso.salir();
			}
		});
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 1;
		gbc_btnAceptar.gridy = 10;
		getContentPane().add(btnAceptar, gbc_btnAceptar);
	}
	private void cartelito(String txt) {
		JOptionPane.showMessageDialog(this, txt, "Consulta de edicion de curso", JOptionPane.ERROR_MESSAGE);
	}
	
	public void cargarDatosCDEDC() {
		cxInstituto.addItem("NONE");
		cxCurso.addItem("NONE");
		cxEdicion.addItem("NONE");
		interfaceCurso c = Fabrica.getInstancia().getICurso();
		Set<String> setsito = c.listarInstitutos();
		for(String pepe: setsito) {
			cxInstituto.addItem(pepe);
		}

	}
	private void elegir2() {
		if(!cxEdicion.getSelectedItem().toString().equals("NONE")) {
			interfaceCurso ICurso = Fabrica.getInstancia().getICurso();
			interfaceUsuario IUsuario = Fabrica.getInstancia().getIUsuario();
			DtInstancia dato = ICurso.verDatosEdicion((cxEdicion.getSelectedItem().toString()));
			DtEdicion info = (DtEdicion) dato;
			String cupo = Integer.toString(info.getCupo());
			txtCupos.setText(cupo);
			txtNombre.setText(info.getNombre());
			txtFechaInicio.setText(IUsuario.fechaDecente(info.getInicio()));
			txtFechaFin.setText(IUsuario.fechaDecente(info.getFin()));
			Set<String> docentes = info.getDocentesParticipan();
			for(String pepito: docentes ) {
				cxDocente.addItem(pepito);
			}
		}else {
			cartelito("No puede dejar campos vacios o con valor NONE");
		}
	}
	private void limpiar() {
		cxInstituto.removeAllItems();
		cxCurso.removeAllItems();
		cxEdicion.removeAllItems();
		cxDocente.removeAllItems();
		txtNombre.setText("");
		txtFechaInicio.setText("");
		txtFechaFin.setText("");
		txtCupos.setText("");
	}

}
