package presentacion;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import exception.EdicionRepetidaExcep;
import logica.ctrleinterfaces.Fabrica;
import logica.ctrleinterfaces.interfaceCurso;
import logica.ctrleinterfaces.interfaceUsuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import java.awt.event.ActionEvent;

public class AltaDeEdicionDeCurso extends JInternalFrame{
	private JTextField txtNombre;
	private JComboBox<String> cxInstituto;
	private JComboBox<String> cxCurso;
	private JSpinner spDia;
	private JSpinner spMes;
	private JSpinner spAnio;
	private JSpinner spDia2;
	private JSpinner spMes2;
	private JSpinner spAnio2;
	private JSpinner spCupos;
	private JComboBox<String> cxDocentes;
	private Set<String> docentesParticipan;
	private interfaceCurso ICurso;
	private JTextField txtIMG;
	
	@SuppressWarnings("deprecation")
	public AltaDeEdicionDeCurso() {		
		setTitle("Alta de Edicion de Curso");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{63, 70, 59, 94, 65, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblInstituto = new JLabel("Instituto :");
		GridBagConstraints gbc_lblInstituto = new GridBagConstraints();
		gbc_lblInstituto.insets = new Insets(0, 0, 5, 5);
		gbc_lblInstituto.anchor = GridBagConstraints.EAST;
		gbc_lblInstituto.gridx = 0;
		gbc_lblInstituto.gridy = 0;
		getContentPane().add(lblInstituto, gbc_lblInstituto);
		
		cxInstituto = new JComboBox <String>();
		GridBagConstraints gbc_cxInstituto = new GridBagConstraints();
		gbc_cxInstituto.insets = new Insets(0, 0, 5, 5);
		gbc_cxInstituto.gridwidth = 4;
		gbc_cxInstituto.fill = GridBagConstraints.HORIZONTAL;
		gbc_cxInstituto.gridx = 1;
		gbc_cxInstituto.gridy = 0;
		getContentPane().add(cxInstituto, gbc_cxInstituto);
		
		JButton btnElegir = new JButton("Elegir");
		btnElegir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elegir1();
			}
		});
		GridBagConstraints gbc_btnElegir = new GridBagConstraints();
		gbc_btnElegir.insets = new Insets(0, 0, 5, 0);
		gbc_btnElegir.gridx = 5;
		gbc_btnElegir.gridy = 0;
		getContentPane().add(btnElegir, gbc_btnElegir);
		
		JLabel lblCursos = new JLabel("Curso :");
		GridBagConstraints gbc_lblCursos = new GridBagConstraints();
		gbc_lblCursos.anchor = GridBagConstraints.EAST;
		gbc_lblCursos.insets = new Insets(0, 0, 5, 5);
		gbc_lblCursos.gridx = 0;
		gbc_lblCursos.gridy = 1;
		getContentPane().add(lblCursos, gbc_lblCursos);
		
		cxCurso = new JComboBox <String>();
		GridBagConstraints gbc_cxCurso = new GridBagConstraints();
		gbc_cxCurso.insets = new Insets(0, 0, 5, 5);
		gbc_cxCurso.gridwidth = 4;
		gbc_cxCurso.fill = GridBagConstraints.HORIZONTAL;
		gbc_cxCurso.gridx = 1;
		gbc_cxCurso.gridy = 1;
		getContentPane().add(cxCurso, gbc_cxCurso);
		
		JButton btnElegir_1 = new JButton("Elegir");
		btnElegir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfaceCurso c = Fabrica.getInstancia().getICurso();
				interfaceUsuario u = Fabrica.getInstancia().getIUsuario();
				if(!(cxCurso.getSelectedItem().toString().equals("NONE"))) {
					c.seleccionarCurso(cxCurso.getSelectedItem().toString());
					Set<String> doc = u.listarDocentes();
					cxDocentes.addItem("NONE");
					for(String pepito: doc ) {
						cxDocentes.addItem(pepito);
					}
				}
			}
		});
		GridBagConstraints gbc_btnElegir_1 = new GridBagConstraints();
		gbc_btnElegir_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnElegir_1.gridx = 5;
		gbc_btnElegir_1.gridy = 1;
		getContentPane().add(btnElegir_1, gbc_btnElegir_1);
		
		JLabel lblDatosDeLa = new JLabel("Datos de la Edicion");
		GridBagConstraints gbc_lblDatosDeLa = new GridBagConstraints();
		gbc_lblDatosDeLa.insets = new Insets(0, 0, 5, 0);
		gbc_lblDatosDeLa.gridwidth = 6;
		gbc_lblDatosDeLa.gridx = 0;
		gbc_lblDatosDeLa.gridy = 2;
		getContentPane().add(lblDatosDeLa, gbc_lblDatosDeLa);
		
		JLabel lblNewLabel = new JLabel("Nombre :");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
		gbc_txtNombre.gridwidth = 5;
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 3;
		getContentPane().add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblUrlImagen = new JLabel("URL imagen:");
		GridBagConstraints gbc_lblUrlImagen = new GridBagConstraints();
		gbc_lblUrlImagen.insets = new Insets(0, 0, 5, 5);
		gbc_lblUrlImagen.anchor = GridBagConstraints.EAST;
		gbc_lblUrlImagen.gridx = 0;
		gbc_lblUrlImagen.gridy = 4;
		getContentPane().add(lblUrlImagen, gbc_lblUrlImagen);
		
		txtIMG = new JTextField();
		GridBagConstraints gbc_txtIMG = new GridBagConstraints();
		gbc_txtIMG.gridwidth = 5;
		gbc_txtIMG.insets = new Insets(0, 0, 5, 0);
		gbc_txtIMG.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIMG.gridx = 1;
		gbc_txtIMG.gridy = 4;
		getContentPane().add(txtIMG, gbc_txtIMG);
		txtIMG.setColumns(10);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha de inicio");
		GridBagConstraints gbc_lblFechaDeInicio = new GridBagConstraints();
		gbc_lblFechaDeInicio.insets = new Insets(0, 0, 5, 0);
		gbc_lblFechaDeInicio.gridwidth = 6;
		gbc_lblFechaDeInicio.gridx = 0;
		gbc_lblFechaDeInicio.gridy = 5;
		getContentPane().add(lblFechaDeInicio, gbc_lblFechaDeInicio);
		
		JLabel lblNewLabel_1 = new JLabel("Dia :");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 6;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		spDia = new JSpinner();
		spDia.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		GridBagConstraints gbc_spDia = new GridBagConstraints();
		gbc_spDia.insets = new Insets(0, 0, 5, 5);
		gbc_spDia.gridx = 1;
		gbc_spDia.gridy = 6;
		getContentPane().add(spDia, gbc_spDia);
		
		JLabel lblMes = new JLabel("Mes :");
		GridBagConstraints gbc_lblMes = new GridBagConstraints();
		gbc_lblMes.insets = new Insets(0, 0, 5, 5);
		gbc_lblMes.gridx = 2;
		gbc_lblMes.gridy = 6;
		getContentPane().add(lblMes, gbc_lblMes);
		
		spMes = new JSpinner();
		spMes.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		GridBagConstraints gbc_spMes = new GridBagConstraints();
		gbc_spMes.insets = new Insets(0, 0, 5, 5);
		gbc_spMes.gridx = 3;
		gbc_spMes.gridy = 6;
		getContentPane().add(spMes, gbc_spMes);
		
		JLabel lblAnio = new JLabel("Anio :");
		GridBagConstraints gbc_lblAnio = new GridBagConstraints();
		gbc_lblAnio.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnio.gridx = 4;
		gbc_lblAnio.gridy = 6;
		getContentPane().add(lblAnio, gbc_lblAnio);
		
		spAnio = new JSpinner();
		spAnio.setModel(new SpinnerNumberModel(1, 1, 3000, 1));
		GridBagConstraints gbc_spAnio = new GridBagConstraints();
		gbc_spAnio.insets = new Insets(0, 0, 5, 0);
		gbc_spAnio.gridx = 5;
		gbc_spAnio.gridy = 6;
		getContentPane().add(spAnio, gbc_spAnio);
		
		JLabel lblFechaDe = new JLabel("Fecha de finalizacion");
		GridBagConstraints gbc_lblFechaDe = new GridBagConstraints();
		gbc_lblFechaDe.insets = new Insets(0, 0, 5, 0);
		gbc_lblFechaDe.gridwidth = 6;
		gbc_lblFechaDe.gridx = 0;
		gbc_lblFechaDe.gridy = 7;
		getContentPane().add(lblFechaDe, gbc_lblFechaDe);
		
		JLabel lblDia = new JLabel("Dia :");
		GridBagConstraints gbc_lblDia = new GridBagConstraints();
		gbc_lblDia.insets = new Insets(0, 0, 5, 5);
		gbc_lblDia.gridx = 0;
		gbc_lblDia.gridy = 8;
		getContentPane().add(lblDia, gbc_lblDia);
		
		spDia2 = new JSpinner();
		spDia2.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		GridBagConstraints gbc_spDia2 = new GridBagConstraints();
		gbc_spDia2.insets = new Insets(0, 0, 5, 5);
		gbc_spDia2.gridx = 1;
		gbc_spDia2.gridy = 8;
		getContentPane().add(spDia2, gbc_spDia2);
		
		JLabel lblMes_1 = new JLabel("Mes :");
		GridBagConstraints gbc_lblMes_1 = new GridBagConstraints();
		gbc_lblMes_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblMes_1.gridx = 2;
		gbc_lblMes_1.gridy = 8;
		getContentPane().add(lblMes_1, gbc_lblMes_1);
		
		spMes2 = new JSpinner();
		spMes2.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		GridBagConstraints gbc_spMes2 = new GridBagConstraints();
		gbc_spMes2.insets = new Insets(0, 0, 5, 5);
		gbc_spMes2.gridx = 3;
		gbc_spMes2.gridy = 8;
		getContentPane().add(spMes2, gbc_spMes2);
		
		JLabel lblAnio_1 = new JLabel("Anio :");
		GridBagConstraints gbc_lblAnio_1 = new GridBagConstraints();
		gbc_lblAnio_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnio_1.gridx = 4;
		gbc_lblAnio_1.gridy = 8;
		getContentPane().add(lblAnio_1, gbc_lblAnio_1);
		
		spAnio2 = new JSpinner();
		spAnio2.setModel(new SpinnerNumberModel(1, 1, 3000, 1));
		GridBagConstraints gbc_spAnio2 = new GridBagConstraints();
		gbc_spAnio2.insets = new Insets(0, 0, 5, 0);
		gbc_spAnio2.gridx = 5;
		gbc_spAnio2.gridy = 8;
		getContentPane().add(spAnio2, gbc_spAnio2);
		
		JLabel lblCupos = new JLabel("Cupos :");
		GridBagConstraints gbc_lblCupos = new GridBagConstraints();
		gbc_lblCupos.insets = new Insets(0, 0, 5, 5);
		gbc_lblCupos.gridx = 0;
		gbc_lblCupos.gridy = 9;
		getContentPane().add(lblCupos, gbc_lblCupos);
		
		spCupos = new JSpinner();
		spCupos.setModel(new SpinnerNumberModel( 0, null, null, 1));
		GridBagConstraints gbc_spCupos = new GridBagConstraints();
		gbc_spCupos.gridwidth = 2;
		gbc_spCupos.insets = new Insets(0, 0, 5, 5);
		gbc_spCupos.gridx = 1;
		gbc_spCupos.gridy = 9;
		getContentPane().add(spCupos, gbc_spCupos);
		
		JLabel lblOpcional = new JLabel("Opcional");
		GridBagConstraints gbc_lblOpcional = new GridBagConstraints();
		gbc_lblOpcional.insets = new Insets(0, 0, 5, 0);
		gbc_lblOpcional.anchor = GridBagConstraints.WEST;
		gbc_lblOpcional.gridwidth = 3;
		gbc_lblOpcional.gridx = 3;
		gbc_lblOpcional.gridy = 9;
		getContentPane().add(lblOpcional, gbc_lblOpcional);
		
		JLabel lblDocentes = new JLabel("Docentes :");
		GridBagConstraints gbc_lblDocentes = new GridBagConstraints();
		gbc_lblDocentes.anchor = GridBagConstraints.EAST;
		gbc_lblDocentes.insets = new Insets(0, 0, 5, 5);
		gbc_lblDocentes.gridx = 0;
		gbc_lblDocentes.gridy = 10;
		getContentPane().add(lblDocentes, gbc_lblDocentes);
		
		cxDocentes = new JComboBox <String>();
		GridBagConstraints gbc_cxDocentes = new GridBagConstraints();
		gbc_cxDocentes.gridwidth = 4;
		gbc_cxDocentes.insets = new Insets(0, 0, 5, 5);
		gbc_cxDocentes.fill = GridBagConstraints.HORIZONTAL;
		gbc_cxDocentes.gridx = 1;
		gbc_cxDocentes.gridy = 10;
		getContentPane().add(cxDocentes, gbc_cxDocentes);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfaceCurso ICurso=Fabrica.getInstancia().getICurso();
				checkandcreate();
				limpiar();
				setVisible(false);
				ICurso.salir();
			}
		});
		
		docentesParticipan = new HashSet<String>();
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(cxDocentes.getSelectedItem().toString().equals("NONE"))) {
					docentesParticipan.add(cxDocentes.getSelectedItem().toString());
				}else {
					cartelito("Seleccione un docente");
				}
			}
		});
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.insets = new Insets(0, 0, 5, 0);
		gbc_btnAgregar.gridx = 5;
		gbc_btnAgregar.gridy = 10;
		getContentPane().add(btnAgregar, gbc_btnAgregar);
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 1;
		gbc_btnAceptar.gridy = 11;
		getContentPane().add(btnAceptar, gbc_btnAceptar);
		
		
		interfaceCurso ICurso=Fabrica.getInstancia().getICurso();
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiar();
				setVisible(false);
				ICurso.salir();
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 3;
		gbc_btnCancelar.gridy = 11;
		getContentPane().add(btnCancelar, gbc_btnCancelar);
	}
	private void elegir1() {
		if(!cxInstituto.getSelectedItem().toString().equals("NONE")){
			interfaceCurso ICurso=Fabrica.getInstancia().getICurso();
			Set<String> cursos = ICurso.seleccionarInstituto(cxInstituto.getSelectedItem().toString());
			cxCurso.addItem("NONE");
			for (String iter:cursos) {
				cxCurso.addItem(iter);
			}
		}else {
			JOptionPane.showMessageDialog(this, "Elija un programa", "Agregar curso a programa",
                    JOptionPane.ERROR_MESSAGE);
		}
	}
	private void limpiar() {		
		txtNombre.setText("");
		cxInstituto.removeAllItems();
		cxCurso.removeAllItems();
		cxDocentes.removeAllItems();
		spDia.setValue(1);
		spDia2.setValue(1);
		spMes.setValue(1);
		spMes2.setValue(1);
		spAnio.setValue(1);
		spAnio2.setValue(1);
		spCupos.setValue(0);
	}
	
	public void cargarDatosADEDC() {
		interfaceCurso c = Fabrica.getInstancia().getICurso();
		Set<String> setsito = c.listarInstitutos();
		cxInstituto.addItem("NONE");
		for(String pepito: setsito ) {
			cxInstituto.addItem(pepito);
		}
	}
	
	private boolean CheckSwing() {
		boolean nombreU = this.txtNombre.getText().isEmpty();
		if(docentesParticipan.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Debe tener al menos un docente participando", "Alta de edicion de curso", JOptionPane.ERROR_MESSAGE);
            return false;
		}	
        int mes= (int) spMes.getValue();
        int dia= (int) spDia.getValue();
        int anio= (int) spAnio.getValue();
        int a = (int) spAnio2.getValue();
        int m = (int) spMes2.getValue();
        int d = (int) spDia2.getValue();
        if (dia>31 || dia<1 || mes>12 || mes<-1 || anio<-1 || d>31 || d<1 || m>12 || m<-1 || a<-1) {
        	 JOptionPane.showMessageDialog(this, "Las fechas no son validas", "Alta de edicion de curso", JOptionPane.ERROR_MESSAGE);
             return false;
        }
        if (nombreU) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacios o con valor NONE", "Inscripcion a edicion de curso", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
	}
	private void checkandcreate() {
		ICurso=Fabrica.getInstancia().getICurso();
		String urlimg = txtIMG.getSelectedText(); 
		if(CheckSwing()) {
			Calendar fechaP = Calendar.getInstance();
			Calendar fechaI = new GregorianCalendar((int )spAnio.getValue(), (int) spMes.getValue(),(int) spDia.getValue());
			Calendar fechaF = new GregorianCalendar((int )spAnio2.getValue(), (int) spMes2.getValue(),(int) spDia2.getValue());
			try{
				ICurso.registrarEdicion(txtNombre.getText(), fechaI, fechaF,(int) spCupos.getValue(), docentesParticipan, fechaP,urlimg);
				cartelito("Edicion registrada con exito");
			}catch (EdicionRepetidaExcep amigue){
				cartelito("La edicion ya se encuentra registrada");
			}
		}
	}
	private void cartelito(String txt) {
		JOptionPane.showMessageDialog(this, txt, "Alta de Edicion de Curso", JOptionPane.ERROR_MESSAGE);
	}

}
