package presentacion;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JSpinner;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import logica.ctrleinterfaces.Fabrica;
import logica.ctrleinterfaces.interfaceCurso;
import logica.ctrleinterfaces.interfaceUsuario;
import logica.datatypes.DtDocente;
import logica.datatypes.DtUsuario;


public class ModificarDatosDeUsuario extends JInternalFrame{
	private JTextField txtNick;
	private JTextField txtCorreo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JComboBox<String> cxUsuario;
	private JTextField txtTipoUsuario;
	private JSpinner spAnio;
	private JSpinner spMes;
	private JSpinner spDia;
	
	public ModificarDatosDeUsuario() {
		setTitle(" Modificar Datos de Usuario");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{42, 60, 73, 57, 55, 53, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lbUsuarioAModificar = new JLabel("Usuario a modificar");
		GridBagConstraints gbc_lbUsuarioAModificar = new GridBagConstraints();
		gbc_lbUsuarioAModificar.gridwidth = 2;
		gbc_lbUsuarioAModificar.insets = new Insets(0, 0, 5, 5);
		gbc_lbUsuarioAModificar.anchor = GridBagConstraints.EAST;
		gbc_lbUsuarioAModificar.gridx = 0;
		gbc_lbUsuarioAModificar.gridy = 0;
		getContentPane().add(lbUsuarioAModificar, gbc_lbUsuarioAModificar);
		
		cxUsuario = new JComboBox<String>();
		GridBagConstraints gbc_cxUsuario = new GridBagConstraints();
		gbc_cxUsuario.gridwidth = 4;
		gbc_cxUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_cxUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_cxUsuario.gridx = 2;
		gbc_cxUsuario.gridy = 0;
		getContentPane().add(cxUsuario, gbc_cxUsuario);
		
		JButton btnElegir = new JButton("Elegir");
		btnElegir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desplegarDatos();
			}
		});
		GridBagConstraints gbc_btnElegir = new GridBagConstraints();
		gbc_btnElegir.insets = new Insets(0, 0, 5, 0);
		gbc_btnElegir.gridx = 6;
		gbc_btnElegir.gridy = 0;
		getContentPane().add(btnElegir, gbc_btnElegir);
		
		JLabel lblDatosDelUsuario = new JLabel("Datos del usuario elegido");
		GridBagConstraints gbc_lblDatosDelUsuario = new GridBagConstraints();
		gbc_lblDatosDelUsuario.gridwidth = 7;
		gbc_lblDatosDelUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_lblDatosDelUsuario.gridx = 0;
		gbc_lblDatosDelUsuario.gridy = 1;
		getContentPane().add(lblDatosDelUsuario, gbc_lblDatosDelUsuario);
		
		JLabel lbNick = new JLabel("Nick :");
		GridBagConstraints gbc_lbNick = new GridBagConstraints();
		gbc_lbNick.gridwidth = 2;
		gbc_lbNick.insets = new Insets(0, 0, 5, 5);
		gbc_lbNick.gridx = 0;
		gbc_lbNick.gridy = 2;
		getContentPane().add(lbNick, gbc_lbNick);
		
		txtNick = new JTextField();
		txtNick.setEditable(false);
		GridBagConstraints gbc_txtNick = new GridBagConstraints();
		gbc_txtNick.gridwidth = 4;
		gbc_txtNick.insets = new Insets(0, 0, 5, 5);
		gbc_txtNick.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNick.gridx = 2;
		gbc_txtNick.gridy = 2;
		getContentPane().add(txtNick, gbc_txtNick);
		txtNick.setColumns(10);
		
		JLabel lbNoEditable1 = new JLabel("No editable");
		GridBagConstraints gbc_lbNoEditable1 = new GridBagConstraints();
		gbc_lbNoEditable1.insets = new Insets(0, 0, 5, 0);
		gbc_lbNoEditable1.gridx = 6;
		gbc_lbNoEditable1.gridy = 2;
		getContentPane().add(lbNoEditable1, gbc_lbNoEditable1);
		
		JLabel lbCorreoElectronico = new JLabel("Correo electronico :");
		GridBagConstraints gbc_lbCorreoElectronico = new GridBagConstraints();
		gbc_lbCorreoElectronico.gridwidth = 2;
		gbc_lbCorreoElectronico.insets = new Insets(0, 0, 5, 5);
		gbc_lbCorreoElectronico.gridx = 0;
		gbc_lbCorreoElectronico.gridy = 3;
		getContentPane().add(lbCorreoElectronico, gbc_lbCorreoElectronico);
		
		txtCorreo = new JTextField();
		txtCorreo.setEditable(false);
		GridBagConstraints gbc_txtCorreo = new GridBagConstraints();
		gbc_txtCorreo.gridwidth = 4;
		gbc_txtCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_txtCorreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCorreo.gridx = 2;
		gbc_txtCorreo.gridy = 3;
		getContentPane().add(txtCorreo, gbc_txtCorreo);
		txtCorreo.setColumns(10);
		
		JLabel lbNoEditable2 = new JLabel("No editable");
		GridBagConstraints gbc_lbNoEditable2 = new GridBagConstraints();
		gbc_lbNoEditable2.insets = new Insets(0, 0, 5, 0);
		gbc_lbNoEditable2.gridx = 6;
		gbc_lbNoEditable2.gridy = 3;
		getContentPane().add(lbNoEditable2, gbc_lbNoEditable2);
		
		JLabel lbNombre = new JLabel("Nombre :");
		GridBagConstraints gbc_lbNombre = new GridBagConstraints();
		gbc_lbNombre.gridwidth = 2;
		gbc_lbNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lbNombre.gridx = 0;
		gbc_lbNombre.gridy = 4;
		getContentPane().add(lbNombre, gbc_lbNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.gridwidth = 4;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 4;
		getContentPane().add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lbApellido = new JLabel("Apellido :");
		GridBagConstraints gbc_lbApellido = new GridBagConstraints();
		gbc_lbApellido.gridwidth = 2;
		gbc_lbApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lbApellido.gridx = 0;
		gbc_lbApellido.gridy = 5;
		getContentPane().add(lbApellido, gbc_lbApellido);
		
		txtApellido = new JTextField();
		GridBagConstraints gbc_txtApellido = new GridBagConstraints();
		gbc_txtApellido.gridwidth = 4;
		gbc_txtApellido.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellido.gridx = 2;
		gbc_txtApellido.gridy = 5;
		getContentPane().add(txtApellido, gbc_txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblDia = new JLabel("Dia :");
		GridBagConstraints gbc_lblDia = new GridBagConstraints();
		gbc_lblDia.insets = new Insets(0, 0, 5, 5);
		gbc_lblDia.gridx = 0;
		gbc_lblDia.gridy = 6;
		getContentPane().add(lblDia, gbc_lblDia);
		
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
		
		JLabel lblAnio = new JLabel("Anio:");
		GridBagConstraints gbc_lblAnio = new GridBagConstraints();
		gbc_lblAnio.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnio.gridx = 4;
		gbc_lblAnio.gridy = 6;
		getContentPane().add(lblAnio, gbc_lblAnio);
		
		spAnio = new JSpinner();
		spAnio.setModel(new SpinnerNumberModel(1, 1, 30000, 1));
		GridBagConstraints gbc_spAnio = new GridBagConstraints();
		gbc_spAnio.gridwidth = 2;
		gbc_spAnio.insets = new Insets(0, 0, 5, 0);
		gbc_spAnio.gridx = 5;
		gbc_spAnio.gridy = 6;
		getContentPane().add(spAnio, gbc_spAnio);
		
		JLabel lblTipoUsuario = new JLabel("Tipo usuario");
		GridBagConstraints gbc_lblTipoUsuario = new GridBagConstraints();
		gbc_lblTipoUsuario.gridwidth = 2;
		gbc_lblTipoUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoUsuario.gridx = 0;
		gbc_lblTipoUsuario.gridy = 7;
		getContentPane().add(lblTipoUsuario, gbc_lblTipoUsuario);
		
		txtTipoUsuario = new JTextField();
		txtTipoUsuario.setEditable(false);
		GridBagConstraints gbc_txtTipoUsuario = new GridBagConstraints();
		gbc_txtTipoUsuario.gridwidth = 5;
		gbc_txtTipoUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_txtTipoUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTipoUsuario.gridx = 2;
		gbc_txtTipoUsuario.gridy = 7;
		getContentPane().add(txtTipoUsuario, gbc_txtTipoUsuario);
		txtTipoUsuario.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfaceCurso ICurso=Fabrica.getInstancia().getICurso();
				interfaceUsuario IUsuario=Fabrica.getInstancia().getIUsuario();
				modificarUsuario();
				limpiar();
				setVisible(false);
				IUsuario.salir();
				ICurso.salir();
			}
		});
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 2;
		gbc_btnAceptar.gridy = 8;
		getContentPane().add(btnAceptar, gbc_btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 3;
		gbc_btnCancelar.gridy = 8;
		getContentPane().add(btnCancelar, gbc_btnCancelar);
		
	}
	public void cargarDatosMDU() {
		cxUsuario.removeAllItems();
		cxUsuario.addItem("NONE");
		//interfaceCurso ICurso=Fabrica.getInstancia().getICurso();
		interfaceUsuario IUsuario=Fabrica.getInstancia().getIUsuario();
		Set<String> sett=IUsuario.listarUsuarios();
		for (String i:sett) {
			cxUsuario.addItem(i);
		}
		
	}
	private void desplegarDatos() {
		interfaceUsuario IUsuario=Fabrica.getInstancia().getIUsuario();
		String s=cxUsuario.getSelectedItem().toString();
		if(!s.equals("NONE")) {
			DtUsuario dt=IUsuario.verDatosUsuario(s);
			txtNombre.setText(dt.getNombre());
			txtApellido.setText(dt.getApellido());
			txtNick.setText(dt.getNick());
			txtCorreo.setText(dt.getCorreo());
			int dia=dt.getFechaNacimiento().get(Calendar.DAY_OF_MONTH);
			int mes=dt.getFechaNacimiento().get(Calendar.MONTH);
			int anio=dt.getFechaNacimiento().get(Calendar.YEAR);
			if(mes == 0) {
				mes = 12;
				anio = anio-1;
			}
			spDia.setValue(dia);
			spMes.setValue(mes);
			spAnio.setValue(anio);
			if (dt instanceof DtDocente) {
				txtTipoUsuario.setText("Docente");
				//ver el campo instituto en DtDocente
			} else {
				txtTipoUsuario.setText("Estudiante");
			}
		}
	}
	private void limpiar() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtNick.setText("");
		txtCorreo.setText("");
		txtTipoUsuario.setText("");
		spDia.setValue(1);
		spMes.setValue(1);
		spAnio.setValue(1);
		cxUsuario.removeAllItems();
	}
	private void modificarUsuario() {
		//interfaceCurso ICurso=Fabrica.getInstancia().getICurso();
		interfaceUsuario IUsuario=Fabrica.getInstancia().getIUsuario();
		int dia=(int) spDia.getValue();
		int mes=(int) spMes.getValue();
		int anio=(int) spAnio.getValue();
		Calendar fechita=new GregorianCalendar(anio,mes,dia);
		String aCambiar=cxUsuario.getSelectedItem().toString();
		IUsuario.seleccionarUsuario(aCambiar);
		IUsuario.editarUsuario(txtNombre.getText(), txtApellido.getText(), fechita);
	}
}
