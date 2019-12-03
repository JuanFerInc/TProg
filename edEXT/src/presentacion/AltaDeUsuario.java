package presentacion;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;


import logica.ctrleinterfaces.Fabrica;
import logica.ctrleinterfaces.interfaceCurso;
import logica.ctrleinterfaces.interfaceUsuario;
import logica.datatypes.TipoUsuario;



import java.awt.event.ActionListener;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class AltaDeUsuario extends JInternalFrame{
	private JTextField txtNick;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCorreo;
	private JLabel lbTipoUsuario;
	private JComboBox<String> cxTipoUsuario;
	private JLabel lbInstituto;
	private JComboBox<String> cxInstituto;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lbFDN;
	private JLabel lbDia;
	private JSpinner spDia;
	private JLabel lbMes;
	private JSpinner spMes;
	private JLabel lbAnio;
	private JSpinner spAnio;
	private JTextField txtPass;
	private JTextField txtConfirm;
	private JLabel lblContrasea;
	private JLabel lblConfirmacion;

	
	
	
	public AltaDeUsuario() {
		interfaceUsuario IUsuario=Fabrica.getInstancia().getIUsuario();
		interfaceCurso ICurso=Fabrica.getInstancia().getICurso();
		
		setTitle("Alta de Usuario");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {52, 66, 55, 71, 78, 83};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 28, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lbNick = new JLabel("Nick :");
		GridBagConstraints gbc_lbNick = new GridBagConstraints();
		gbc_lbNick.gridwidth = 2;
		gbc_lbNick.insets = new Insets(0, 0, 5, 5);
		gbc_lbNick.gridx = 0;
		gbc_lbNick.gridy = 0;
		getContentPane().add(lbNick, gbc_lbNick);
		
		txtNick = new JTextField();
		GridBagConstraints gbc_txtNick = new GridBagConstraints();
		gbc_txtNick.gridwidth = 4;
		gbc_txtNick.insets = new Insets(0, 0, 5, 0);
		gbc_txtNick.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNick.gridx = 2;
		gbc_txtNick.gridy = 0;
		getContentPane().add(txtNick, gbc_txtNick);
		txtNick.setColumns(10);
		
		JLabel lbNombre = new JLabel("Nombre :");
		GridBagConstraints gbc_lbNombre = new GridBagConstraints();
		gbc_lbNombre.gridwidth = 2;
		gbc_lbNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lbNombre.gridx = 0;
		gbc_lbNombre.gridy = 1;
		getContentPane().add(lbNombre, gbc_lbNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.gridwidth = 4;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 1;
		getContentPane().add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lbApellido = new JLabel("Apellido :");
		GridBagConstraints gbc_lbApellido = new GridBagConstraints();
		gbc_lbApellido.gridwidth = 2;
		gbc_lbApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lbApellido.gridx = 0;
		gbc_lbApellido.gridy = 2;
		getContentPane().add(lbApellido, gbc_lbApellido);
		
		txtApellido = new JTextField();
		GridBagConstraints gbc_txtApellido = new GridBagConstraints();
		gbc_txtApellido.gridwidth = 4;
		gbc_txtApellido.insets = new Insets(0, 0, 5, 0);
		gbc_txtApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellido.gridx = 2;
		gbc_txtApellido.gridy = 2;
		getContentPane().add(txtApellido, gbc_txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lbCorreo = new JLabel("Correo electronico :");
		GridBagConstraints gbc_lbCorreo = new GridBagConstraints();
		gbc_lbCorreo.gridwidth = 2;
		gbc_lbCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_lbCorreo.gridx = 0;
		gbc_lbCorreo.gridy = 3;
		getContentPane().add(lbCorreo, gbc_lbCorreo);
		
		txtCorreo = new JTextField();
		GridBagConstraints gbc_txtCorreo = new GridBagConstraints();
		gbc_txtCorreo.gridwidth = 4;
		gbc_txtCorreo.insets = new Insets(0, 0, 5, 0);
		gbc_txtCorreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCorreo.gridx = 2;
		gbc_txtCorreo.gridy = 3;
		getContentPane().add(txtCorreo, gbc_txtCorreo);
		txtCorreo.setColumns(10);
		
		lbFDN = new JLabel("Fecha de nacimiento");
		GridBagConstraints gbc_lbFDN = new GridBagConstraints();
		gbc_lbFDN.gridwidth = 6;
		gbc_lbFDN.insets = new Insets(0, 0, 5, 0);
		gbc_lbFDN.gridx = 0;
		gbc_lbFDN.gridy = 4;
		getContentPane().add(lbFDN, gbc_lbFDN);
		
		lbDia = new JLabel("Dia :");
		GridBagConstraints gbc_lbDia = new GridBagConstraints();
		gbc_lbDia.insets = new Insets(0, 0, 5, 5);
		gbc_lbDia.gridx = 0;
		gbc_lbDia.gridy = 5;
		getContentPane().add(lbDia, gbc_lbDia);
		
		spDia = new JSpinner();
		spDia.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		GridBagConstraints gbc_spDia = new GridBagConstraints();
		gbc_spDia.insets = new Insets(0, 0, 5, 5);
		gbc_spDia.gridx = 1;
		gbc_spDia.gridy = 5;
		getContentPane().add(spDia, gbc_spDia);
		
		lbMes = new JLabel("Mes :");
		GridBagConstraints gbc_lbMes = new GridBagConstraints();
		gbc_lbMes.insets = new Insets(0, 0, 5, 5);
		gbc_lbMes.gridx = 2;
		gbc_lbMes.gridy = 5;
		getContentPane().add(lbMes, gbc_lbMes);
		
		spMes = new JSpinner();
		spMes.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		GridBagConstraints gbc_spMes = new GridBagConstraints();
		gbc_spMes.insets = new Insets(0, 0, 5, 5);
		gbc_spMes.gridx = 3;
		gbc_spMes.gridy = 5;
		getContentPane().add(spMes, gbc_spMes);
		
		lbAnio = new JLabel("anio :");
		GridBagConstraints gbc_lbAnio = new GridBagConstraints();
		gbc_lbAnio.insets = new Insets(0, 0, 5, 5);
		gbc_lbAnio.gridx = 4;
		gbc_lbAnio.gridy = 5;
		getContentPane().add(lbAnio, gbc_lbAnio);
		
		spAnio = new JSpinner();
		spAnio.setModel(new SpinnerNumberModel(1, 1, 3000, 1));
		GridBagConstraints gbc_spAnio = new GridBagConstraints();
		gbc_spAnio.insets = new Insets(0, 0, 5, 0);
		gbc_spAnio.gridx = 5;
		gbc_spAnio.gridy = 5;
		getContentPane().add(spAnio, gbc_spAnio);
		
		lbTipoUsuario = new JLabel("Tipo Usuario");
		GridBagConstraints gbc_lbTipoUsuario = new GridBagConstraints();
		gbc_lbTipoUsuario.gridwidth = 2;
		gbc_lbTipoUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lbTipoUsuario.gridx = 0;
		gbc_lbTipoUsuario.gridy = 6;
		getContentPane().add(lbTipoUsuario, gbc_lbTipoUsuario);
		
		cxTipoUsuario = new JComboBox<String>();
		
		GridBagConstraints gbc_cxTipoUsuario = new GridBagConstraints();
		gbc_cxTipoUsuario.gridwidth = 4;
		gbc_cxTipoUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_cxTipoUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_cxTipoUsuario.gridx = 2;
		gbc_cxTipoUsuario.gridy = 6;
		getContentPane().add(cxTipoUsuario, gbc_cxTipoUsuario);
		
		lbInstituto = new JLabel("En caso de Docente elija el Instituto");
		GridBagConstraints gbc_lbInstituto = new GridBagConstraints();
		gbc_lbInstituto.insets = new Insets(0, 0, 5, 0);
		gbc_lbInstituto.gridwidth = 6;
		gbc_lbInstituto.gridx = 0;
		gbc_lbInstituto.gridy = 7;
		getContentPane().add(lbInstituto, gbc_lbInstituto);
		
		cxInstituto = new JComboBox<String>();
		
		GridBagConstraints gbc_cxInstituto = new GridBagConstraints();
		gbc_cxInstituto.insets = new Insets(0, 0, 5, 0);
		gbc_cxInstituto.gridwidth = 6;
		gbc_cxInstituto.fill = GridBagConstraints.HORIZONTAL;
		gbc_cxInstituto.gridx = 0;
		gbc_cxInstituto.gridy = 8;
		getContentPane().add(cxInstituto, gbc_cxInstituto);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argo) {
				checkAndCreate(argo);
				limpiar();
				IUsuario.salir();
				ICurso.salir();
				setVisible(false);
			}
		});
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.anchor = GridBagConstraints.EAST;
		gbc_lblContrasea.gridx = 1;
		gbc_lblContrasea.gridy = 9;
		getContentPane().add(lblContrasea, gbc_lblContrasea);
		
		txtPass = new JTextField();
		GridBagConstraints gbc_txtPass = new GridBagConstraints();
		gbc_txtPass.insets = new Insets(0, 0, 5, 5);
		gbc_txtPass.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPass.gridx = 2;
		gbc_txtPass.gridy = 9;
		getContentPane().add(txtPass, gbc_txtPass);
		txtPass.setColumns(10);
		
		lblConfirmacion = new JLabel("Confirmacion");
		GridBagConstraints gbc_lblConfirmacion = new GridBagConstraints();
		gbc_lblConfirmacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmacion.anchor = GridBagConstraints.EAST;
		gbc_lblConfirmacion.gridx = 3;
		gbc_lblConfirmacion.gridy = 9;
		getContentPane().add(lblConfirmacion, gbc_lblConfirmacion);
		
		txtConfirm = new JTextField();
		GridBagConstraints gbc_txtConfirm = new GridBagConstraints();
		gbc_txtConfirm.insets = new Insets(0, 0, 5, 5);
		gbc_txtConfirm.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtConfirm.gridx = 4;
		gbc_txtConfirm.gridy = 9;
		getContentPane().add(txtConfirm, gbc_txtConfirm);
		txtConfirm.setColumns(10);
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.anchor = GridBagConstraints.WEST;
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 2;
		gbc_btnAceptar.gridy = 10;
		getContentPane().add(btnAceptar, gbc_btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
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
		gbc_btnCancelar.gridx = 4;
		gbc_btnCancelar.gridy = 10;
		getContentPane().add(btnCancelar, gbc_btnCancelar);
	}
	private void limpiar() {
		txtNick.setText("");
		txtNombre.setText("");
		txtCorreo.setText("");
		txtApellido.setText("");
		cxInstituto.removeAllItems();
		spDia.setValue(1);
		spMes.setValue(1);
		spAnio.setValue(1);
		cxTipoUsuario.removeAllItems();
		txtPass.setText("");
		txtConfirm.setText("");
	}
	public void cargarDatosADU() {
		cxTipoUsuario.addItem("NONE");
		cxTipoUsuario.addItem("Estudiante");
		cxTipoUsuario.addItem("Docente");
		interfaceCurso ICurso=Fabrica.getInstancia().getICurso();
		cxInstituto.addItem("NONE");
		Set<String> insti=ICurso.listarInstitutos();
		for (String iter:insti) {
			cxInstituto.addItem(iter);
		}
	}
	
	private boolean checkSwing() {
        boolean nombreU = this.txtNombre.getText().isEmpty();
        boolean apellidoU = this.txtApellido.getText().isEmpty();
        boolean correoU = this.txtCorreo.getText().isEmpty();
        boolean nickU= this.txtNick.getText().isEmpty() || this.txtPass.getText().isEmpty() || this.txtConfirm.getText().isEmpty();
        boolean checkeoPass = this.txtConfirm.getText().equals(this.txtPass.getText());
        boolean tipoU=(this.cxTipoUsuario.getSelectedItem().toString().equals("NONE"));
        boolean institutoU=((this.cxTipoUsuario.getSelectedItem().toString().equals("Docente"))&&(this.cxInstituto.getSelectedItem().toString().equals("NONE")));
        int mes= (Integer) spMes.getValue();
        int dia= (Integer) spDia.getValue();
        int anio=(Integer) spAnio.getValue();
        if (dia>31 || dia<1 || mes>12 || mes<-1 || anio<-1) {
        	 JOptionPane.showMessageDialog(this, "Las fechas no son validas", "Registrar Usuario",
                     JOptionPane.ERROR_MESSAGE);
             return false;
        }
        if (nombreU || apellidoU || nickU || correoU ||tipoU ||institutoU) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Registrar Usuario",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(!checkeoPass) {
        	JOptionPane.showMessageDialog(this, "Los campos contraseña y confirmacion deben coincidir", "Registrar Usuario",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
	
	private void checkAndCreate(ActionEvent argo) {
		if (checkSwing()) {
			interfaceUsuario IUsuario=Fabrica.getInstancia().getIUsuario();
			String value = cxTipoUsuario.getSelectedItem().toString();
			//spDia.commitEdit();
			//spMes.commitEdit();
			//spAnio.commitEdit();
			int vDia = (Integer) spDia.getValue();
			int vMes = (Integer) spMes.getValue();
			int vAnio = (Integer) spAnio.getValue();
			String pass = txtPass.getText();
			Calendar cal=new GregorianCalendar(vAnio, vMes, vDia);
            try {
            	if (value.equals("Docente")) {
        			String inst =cxInstituto.getSelectedItem().toString();
        			IUsuario.registrarUser(txtNick.getText(), txtNombre.getText(), txtApellido.getText(), cal, txtCorreo.getText(),TipoUsuario.DOCENTE,inst,pass,pass,"" );
//Aca cambio
            	} else {
//Aca cambio
        			IUsuario.registrarUser(txtNick.getText(), txtNombre.getText(), txtApellido.getText(), cal, txtCorreo.getText(),TipoUsuario.ESTUDIANTE,"NONE",pass,pass, "" );
        		}
                JOptionPane.showMessageDialog(this, "El Usuario se ha creado con Exito", "Registrar Usuario",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception e) {
                // Muestro error de registro
                JOptionPane.showMessageDialog(this, e.getMessage(), "Registrar Usuario", JOptionPane.ERROR_MESSAGE);
            }
		}
	}
	
	
	
	
}
