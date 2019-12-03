package presentacion;

import javax.swing.JInternalFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import exception.ProgramaRepetidoExcep;
import logica.ctrleinterfaces.Fabrica;
import logica.ctrleinterfaces.interfaceUsuario;
import logica.ctrleinterfaces.interfaceCurso;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;

public class CrearProgramaDeFormacion extends JInternalFrame{
	private JTextField textNombre;
	private JTextField textDir;
	private JSpinner spDia;
	private JSpinner spMes;
	private JSpinner spAnio;
	private JSpinner spDia2;
	private JSpinner spMes2;
	private JSpinner spAnio2;
	private JSpinner spDia3;
	private JSpinner spMes3;
	private JSpinner spAnio3;
	private JTextField txtIMG;
	
	public CrearProgramaDeFormacion() {
		interfaceUsuario IUsuario=Fabrica.getInstancia().getIUsuario();
		interfaceCurso ICurso=Fabrica.getInstancia().getICurso();
		setTitle("Crear Programa de Formacion");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{72, 82, 68, 68, 56, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNombre = new JLabel("Nombre :");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		getContentPane().add(lblNombre, gbc_lblNombre);
		
		textNombre = new JTextField();
		GridBagConstraints gbc_textNombre = new GridBagConstraints();
		gbc_textNombre.gridwidth = 5;
		gbc_textNombre.insets = new Insets(0, 0, 5, 0);
		gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNombre.gridx = 1;
		gbc_textNombre.gridy = 0;
		getContentPane().add(textNombre, gbc_textNombre);
		textNombre.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion :");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 0;
		gbc_lblDescripcion.gridy = 1;
		getContentPane().add(lblDescripcion, gbc_lblDescripcion);
		
		textDir = new JTextField();
		GridBagConstraints gbc_textDir = new GridBagConstraints();
		gbc_textDir.insets = new Insets(0, 0, 5, 0);
		gbc_textDir.gridwidth = 5;
		gbc_textDir.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDir.gridx = 1;
		gbc_textDir.gridy = 1;
		getContentPane().add(textDir, gbc_textDir);
		textDir.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Periodo de Vigencia");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridwidth = 6;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Desde");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 6;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblDia = new JLabel("Dia :");
		GridBagConstraints gbc_lblDia = new GridBagConstraints();
		gbc_lblDia.insets = new Insets(0, 0, 5, 5);
		gbc_lblDia.gridx = 0;
		gbc_lblDia.gridy = 4;
		getContentPane().add(lblDia, gbc_lblDia);
		
		spDia = new JSpinner();
		spDia.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		GridBagConstraints gbc_spDia = new GridBagConstraints();
		gbc_spDia.insets = new Insets(0, 0, 5, 5);
		gbc_spDia.gridx = 1;
		gbc_spDia.gridy = 4;
		getContentPane().add(spDia, gbc_spDia);
		
		JLabel lblMes = new JLabel("Mes :");
		GridBagConstraints gbc_lblMes = new GridBagConstraints();
		gbc_lblMes.insets = new Insets(0, 0, 5, 5);
		gbc_lblMes.gridx = 2;
		gbc_lblMes.gridy = 4;
		getContentPane().add(lblMes, gbc_lblMes);
		
		spMes = new JSpinner();
		spMes.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		GridBagConstraints gbc_spMes = new GridBagConstraints();
		gbc_spMes.insets = new Insets(0, 0, 5, 5);
		gbc_spMes.gridx = 3;
		gbc_spMes.gridy = 4;
		getContentPane().add(spMes, gbc_spMes);
		
		JLabel lblAnio = new JLabel("Anio :");
		GridBagConstraints gbc_lblAnio = new GridBagConstraints();
		gbc_lblAnio.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnio.gridx = 4;
		gbc_lblAnio.gridy = 4;
		getContentPane().add(lblAnio, gbc_lblAnio);
		
		spAnio = new JSpinner();
		spAnio.setModel(new SpinnerNumberModel(1, 1, 3000, 1));
		GridBagConstraints gbc_spAnio = new GridBagConstraints();
		gbc_spAnio.insets = new Insets(0, 0, 5, 0);
		gbc_spAnio.gridx = 5;
		gbc_spAnio.gridy = 4;
		getContentPane().add(spAnio, gbc_spAnio);
		
		JLabel lblNewLabel_1 = new JLabel("Hasta");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridwidth = 6;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 5;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblDia_1 = new JLabel("Dia :");
		GridBagConstraints gbc_lblDia_1 = new GridBagConstraints();
		gbc_lblDia_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblDia_1.gridx = 0;
		gbc_lblDia_1.gridy = 6;
		getContentPane().add(lblDia_1, gbc_lblDia_1);
		
		spDia2 = new JSpinner();
		spDia2.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		GridBagConstraints gbc_spDia2 = new GridBagConstraints();
		gbc_spDia2.insets = new Insets(0, 0, 5, 5);
		gbc_spDia2.gridx = 1;
		gbc_spDia2.gridy = 6;
		getContentPane().add(spDia2, gbc_spDia2);
		
		JLabel lblMes_1 = new JLabel("Mes :");
		GridBagConstraints gbc_lblMes_1 = new GridBagConstraints();
		gbc_lblMes_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblMes_1.gridx = 2;
		gbc_lblMes_1.gridy = 6;
		getContentPane().add(lblMes_1, gbc_lblMes_1);
		
		spMes2 = new JSpinner();
		spMes2.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		GridBagConstraints gbc_spMes2 = new GridBagConstraints();
		gbc_spMes2.insets = new Insets(0, 0, 5, 5);
		gbc_spMes2.gridx = 3;
		gbc_spMes2.gridy = 6;
		getContentPane().add(spMes2, gbc_spMes2);
		
		JLabel lblAnio_1 = new JLabel("Anio :");
		GridBagConstraints gbc_lblAnio_1 = new GridBagConstraints();
		gbc_lblAnio_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnio_1.gridx = 4;
		gbc_lblAnio_1.gridy = 6;
		getContentPane().add(lblAnio_1, gbc_lblAnio_1);
		
		spAnio2 = new JSpinner();
		spAnio2.setModel(new SpinnerNumberModel(1, 1, 3000, 1));
		GridBagConstraints gbc_spAnio2 = new GridBagConstraints();
		gbc_spAnio2.insets = new Insets(0, 0, 5, 0);
		gbc_spAnio2.gridx = 5;
		gbc_spAnio2.gridy = 6;
		getContentPane().add(spAnio2, gbc_spAnio2);
		
		JLabel lblFechaDeAlta = new JLabel("Fecha de Alta");
		GridBagConstraints gbc_lblFechaDeAlta = new GridBagConstraints();
		gbc_lblFechaDeAlta.insets = new Insets(0, 0, 5, 0);
		gbc_lblFechaDeAlta.gridwidth = 6;
		gbc_lblFechaDeAlta.gridx = 0;
		gbc_lblFechaDeAlta.gridy = 7;
		getContentPane().add(lblFechaDeAlta, gbc_lblFechaDeAlta);
		
		JLabel lblDia_2 = new JLabel("Dia :");
		GridBagConstraints gbc_lblDia_2 = new GridBagConstraints();
		gbc_lblDia_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblDia_2.gridx = 0;
		gbc_lblDia_2.gridy = 8;
		getContentPane().add(lblDia_2, gbc_lblDia_2);
		
		spDia3 = new JSpinner();
		spDia3.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		GridBagConstraints gbc_spDia3 = new GridBagConstraints();
		gbc_spDia3.insets = new Insets(0, 0, 5, 5);
		gbc_spDia3.gridx = 1;
		gbc_spDia3.gridy = 8;
		getContentPane().add(spDia3, gbc_spDia3);
		
		JLabel lblMes_2 = new JLabel("Mes :");
		GridBagConstraints gbc_lblMes_2 = new GridBagConstraints();
		gbc_lblMes_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblMes_2.gridx = 2;
		gbc_lblMes_2.gridy = 8;
		getContentPane().add(lblMes_2, gbc_lblMes_2);
		
		spMes3 = new JSpinner();
		spMes3.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		GridBagConstraints gbc_spMes3 = new GridBagConstraints();
		gbc_spMes3.insets = new Insets(0, 0, 5, 5);
		gbc_spMes3.gridx = 3;
		gbc_spMes3.gridy = 8;
		getContentPane().add(spMes3, gbc_spMes3);
		
		JLabel lblAnio_2 = new JLabel("Anio:");
		GridBagConstraints gbc_lblAnio_2 = new GridBagConstraints();
		gbc_lblAnio_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnio_2.gridx = 4;
		gbc_lblAnio_2.gridy = 8;
		getContentPane().add(lblAnio_2, gbc_lblAnio_2);
		
		spAnio3 = new JSpinner();
		spAnio3.setModel(new SpinnerNumberModel(1, 1, 3000, 1));
		GridBagConstraints gbc_spAnio3 = new GridBagConstraints();
		gbc_spAnio3.insets = new Insets(0, 0, 5, 0);
		gbc_spAnio3.gridx = 5;
		gbc_spAnio3.gridy = 8;
		getContentPane().add(spAnio3, gbc_spAnio3);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkAndCreate(e);
				limpiar();
				IUsuario.salir();
				ICurso.salir();
				setVisible(false);
			}
		});
		
		JLabel lblUrlImagen = new JLabel("URL imagen");
		GridBagConstraints gbc_lblUrlImagen = new GridBagConstraints();
		gbc_lblUrlImagen.insets = new Insets(0, 0, 5, 5);
		gbc_lblUrlImagen.anchor = GridBagConstraints.EAST;
		gbc_lblUrlImagen.gridx = 0;
		gbc_lblUrlImagen.gridy = 9;
		getContentPane().add(lblUrlImagen, gbc_lblUrlImagen);
		
		txtIMG = new JTextField();
		GridBagConstraints gbc_txtIMG = new GridBagConstraints();
		gbc_txtIMG.gridwidth = 5;
		gbc_txtIMG.insets = new Insets(0, 0, 5, 0);
		gbc_txtIMG.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIMG.gridx = 1;
		gbc_txtIMG.gridy = 9;
		getContentPane().add(txtIMG, gbc_txtIMG);
		txtIMG.setColumns(10);
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 1;
		gbc_btnAceptar.gridy = 10;
		getContentPane().add(btnAceptar, gbc_btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				ICurso.salir();
				IUsuario.salir();
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 3;
		gbc_btnCancelar.gridy = 10;
		getContentPane().add(btnCancelar, gbc_btnCancelar);
	}
	public void cargarDatosCPDF() {
		textNombre.setText("");
		textDir.setText("");
	}
	private boolean checkSwing() {
		 boolean nombre = this.textNombre.getText().isEmpty();
	     boolean dir = this.textDir.getText().isEmpty();
	     if(nombre || dir) {
	    	 JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Registrar Usuario",
	                    JOptionPane.ERROR_MESSAGE);
	            return false;
	     }else return true;
	}
	private void checkAndCreate(ActionEvent e){
		if(checkSwing()) {
			interfaceCurso ICurso = Fabrica.getInstancia().getICurso();
			String imagen =  txtIMG.getSelectedText();
			int vDia = (Integer) spDia.getValue();
			int vMes = (Integer) spMes.getValue();
			int vAnio = (Integer) spAnio.getValue();
			Calendar fechaInicio = new GregorianCalendar(vAnio, vMes, vDia);
			int vDia2 = (Integer) spDia2.getValue();
			int vMes2 = (Integer) spMes2.getValue();
			int vAnio2 = (Integer) spAnio2.getValue();
			Calendar fechaFin = new GregorianCalendar(vAnio2, vMes2, vDia2);
			int vDia3 = (Integer) spDia3.getValue();
			int vMes3 = (Integer) spMes3.getValue();
			int vAnio3 = (Integer) spAnio3.getValue();
			Calendar fechaAlta = new GregorianCalendar(vAnio3, vMes3, vDia3);
			try {
			ICurso.registrarPrograma(textNombre.getText(), textDir.getText(), fechaInicio, fechaFin, fechaAlta, imagen);
			}catch(ProgramaRepetidoExcep err) {
				JOptionPane.showMessageDialog(this, err.getMessage(), "Registrar Programa", JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}
	private void limpiar() {
		textNombre.setText("");
		textDir.setText("");
		spDia.setValue(1);
		spMes.setValue(1);
		spAnio.setValue(1);
		spDia2.setValue(1);
		spMes2.setValue(1);
		spAnio2.setValue(1);
		spDia3.setValue(1);
		spMes3.setValue(1);
		spAnio3.setValue(1);
		
	}

}
