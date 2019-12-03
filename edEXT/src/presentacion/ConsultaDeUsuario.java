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
import logica.datatypes.DtDocente;
import logica.datatypes.DtEstudianteIn;
import logica.datatypes.DtInstancia;
import logica.datatypes.DtUsuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;

public class ConsultaDeUsuario extends JInternalFrame{
	private JTextField txtNombre;
	private JTextField txtNick;
	private JTextField txtApellido;
	private JTextField txtCorreo;
	private JTextField txtFecha;
	private JComboBox<String> cxUsuario;
	private infoEdicion infoE;
	private infoPrograma infoP;
	private JTextField txtTipoUsuario;
	private JComboBox<String> cxDocenteEdicion;
	private JComboBox<String> cxEstudianteEdicion;
	private JComboBox<String> cxEstudiantePrograma;
	
	public ConsultaDeUsuario() {
		setTitle("Consulta de Usuario");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{92, 112, 213, 78, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblUsuario = new JLabel("Usuario :");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 0;
		getContentPane().add(lblUsuario, gbc_lblUsuario);
		
		cxUsuario = new JComboBox<String>();
		GridBagConstraints gbc_cxUsuario = new GridBagConstraints();
		gbc_cxUsuario.gridwidth = 3;
		gbc_cxUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_cxUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_cxUsuario.gridx = 1;
		gbc_cxUsuario.gridy = 0;
		getContentPane().add(cxUsuario, gbc_cxUsuario);
		
		JButton btnElegir = new JButton("Elegir");
		btnElegir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCx();
				desplegarDatos();
			}
		});
		GridBagConstraints gbc_btnElegir = new GridBagConstraints();
		gbc_btnElegir.insets = new Insets(0, 0, 5, 0);
		gbc_btnElegir.gridx = 4;
		gbc_btnElegir.gridy = 0;
		getContentPane().add(btnElegir, gbc_btnElegir);
		
		JLabel lblDatosDelUsuario = new JLabel("Informacion basica del Usuario");
		GridBagConstraints gbc_lblDatosDelUsuario = new GridBagConstraints();
		gbc_lblDatosDelUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_lblDatosDelUsuario.gridwidth = 5;
		gbc_lblDatosDelUsuario.gridx = 0;
		gbc_lblDatosDelUsuario.gridy = 1;
		getContentPane().add(lblDatosDelUsuario, gbc_lblDatosDelUsuario);
		
		JLabel lblNombre = new JLabel("Nombre :");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 2;
		getContentPane().add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.gridwidth = 4;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 2;
		getContentPane().add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNick = new JLabel("Nick :");
		GridBagConstraints gbc_lblNick = new GridBagConstraints();
		gbc_lblNick.insets = new Insets(0, 0, 5, 5);
		gbc_lblNick.gridx = 0;
		gbc_lblNick.gridy = 3;
		getContentPane().add(lblNick, gbc_lblNick);
		
		txtNick = new JTextField();
		txtNick.setEditable(false);
		GridBagConstraints gbc_txtNick = new GridBagConstraints();
		gbc_txtNick.gridwidth = 4;
		gbc_txtNick.insets = new Insets(0, 0, 5, 0);
		gbc_txtNick.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNick.gridx = 1;
		gbc_txtNick.gridy = 3;
		getContentPane().add(txtNick, gbc_txtNick);
		txtNick.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido :");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 0;
		gbc_lblApellido.gridy = 4;
		getContentPane().add(lblApellido, gbc_lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		GridBagConstraints gbc_txtApellido = new GridBagConstraints();
		gbc_txtApellido.gridwidth = 4;
		gbc_txtApellido.insets = new Insets(0, 0, 5, 0);
		gbc_txtApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellido.gridx = 1;
		gbc_txtApellido.gridy = 4;
		getContentPane().add(txtApellido, gbc_txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblCorreo = new JLabel("Correo :");
		GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
		gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreo.gridx = 0;
		gbc_lblCorreo.gridy = 5;
		getContentPane().add(lblCorreo, gbc_lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setEditable(false);
		GridBagConstraints gbc_txtCorreo = new GridBagConstraints();
		gbc_txtCorreo.gridwidth = 4;
		gbc_txtCorreo.insets = new Insets(0, 0, 5, 0);
		gbc_txtCorreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCorreo.gridx = 1;
		gbc_txtCorreo.gridy = 5;
		getContentPane().add(txtCorreo, gbc_txtCorreo);
		txtCorreo.setColumns(10);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento :");
		GridBagConstraints gbc_lblFechaDeNacimiento = new GridBagConstraints();
		gbc_lblFechaDeNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeNacimiento.gridx = 0;
		gbc_lblFechaDeNacimiento.gridy = 6;
		getContentPane().add(lblFechaDeNacimiento, gbc_lblFechaDeNacimiento);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		GridBagConstraints gbc_txtFecha = new GridBagConstraints();
		gbc_txtFecha.gridwidth = 2;
		gbc_txtFecha.insets = new Insets(0, 0, 5, 5);
		gbc_txtFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFecha.gridx = 1;
		gbc_txtFecha.gridy = 6;
		getContentPane().add(txtFecha, gbc_txtFecha);
		txtFecha.setColumns(10);
		
		JLabel lblTipoDeUsuario = new JLabel("Tipo de Usuario :");
		GridBagConstraints gbc_lblTipoDeUsuario = new GridBagConstraints();
		gbc_lblTipoDeUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoDeUsuario.gridx = 3;
		gbc_lblTipoDeUsuario.gridy = 6;
		getContentPane().add(lblTipoDeUsuario, gbc_lblTipoDeUsuario);
		
		txtTipoUsuario = new JTextField();
		txtTipoUsuario.setEditable(false);
		GridBagConstraints gbc_txtTipoUsuario = new GridBagConstraints();
		gbc_txtTipoUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_txtTipoUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTipoUsuario.gridx = 4;
		gbc_txtTipoUsuario.gridy = 6;
		getContentPane().add(txtTipoUsuario, gbc_txtTipoUsuario);
		txtTipoUsuario.setColumns(10);
		
		JLabel lblInformacionDeDocente = new JLabel("Informacion de Docente ");
		GridBagConstraints gbc_lblInformacionDeDocente = new GridBagConstraints();
		gbc_lblInformacionDeDocente.insets = new Insets(0, 0, 5, 5);
		gbc_lblInformacionDeDocente.gridx = 2;
		gbc_lblInformacionDeDocente.gridy = 7;
		getContentPane().add(lblInformacionDeDocente, gbc_lblInformacionDeDocente);
		
		JLabel lblNewLabel = new JLabel("Ediciones de curso :");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 8;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		cxDocenteEdicion = new JComboBox<String>();
		GridBagConstraints gbc_cxDocenteEdicion = new GridBagConstraints();
		gbc_cxDocenteEdicion.gridwidth = 3;
		gbc_cxDocenteEdicion.insets = new Insets(0, 0, 5, 5);
		gbc_cxDocenteEdicion.fill = GridBagConstraints.HORIZONTAL;
		gbc_cxDocenteEdicion.gridx = 1;
		gbc_cxDocenteEdicion.gridy = 8;
		getContentPane().add(cxDocenteEdicion, gbc_cxDocenteEdicion);
		
		JButton btnVermasEdicionesDocente = new JButton("Ver mas ");
		btnVermasEdicionesDocente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				infoE.setVisible(true);
				infoP.setVisible(false);
				String hola=cxDocenteEdicion.getSelectedItem().toString();
				infoE.cargarDatosIE(hola);
			}
		});
		GridBagConstraints gbc_btnVermasEdicionesDocente = new GridBagConstraints();
		gbc_btnVermasEdicionesDocente.insets = new Insets(0, 0, 5, 0);
		gbc_btnVermasEdicionesDocente.gridx = 4;
		gbc_btnVermasEdicionesDocente.gridy = 8;
		getContentPane().add(btnVermasEdicionesDocente, gbc_btnVermasEdicionesDocente);
		
		JLabel lblInformacionDeEstudiante = new JLabel("Informacion de Estudiante");
		GridBagConstraints gbc_lblInformacionDeEstudiante = new GridBagConstraints();
		gbc_lblInformacionDeEstudiante.insets = new Insets(0, 0, 5, 5);
		gbc_lblInformacionDeEstudiante.gridx = 2;
		gbc_lblInformacionDeEstudiante.gridy = 9;
		getContentPane().add(lblInformacionDeEstudiante, gbc_lblInformacionDeEstudiante);
		
		JLabel lblEdicionesDeCurso = new JLabel("Ediciones de curso :");
		GridBagConstraints gbc_lblEdicionesDeCurso = new GridBagConstraints();
		gbc_lblEdicionesDeCurso.anchor = GridBagConstraints.EAST;
		gbc_lblEdicionesDeCurso.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdicionesDeCurso.gridx = 0;
		gbc_lblEdicionesDeCurso.gridy = 10;
		getContentPane().add(lblEdicionesDeCurso, gbc_lblEdicionesDeCurso);
		
		cxEstudianteEdicion = new JComboBox<String>();
		GridBagConstraints gbc_cxEstudianteEdicion = new GridBagConstraints();
		gbc_cxEstudianteEdicion.gridwidth = 3;
		gbc_cxEstudianteEdicion.insets = new Insets(0, 0, 5, 5);
		gbc_cxEstudianteEdicion.fill = GridBagConstraints.HORIZONTAL;
		gbc_cxEstudianteEdicion.gridx = 1;
		gbc_cxEstudianteEdicion.gridy = 10;
		getContentPane().add(cxEstudianteEdicion, gbc_cxEstudianteEdicion);
		
		JButton btnVermasEdicionesEstudiante = new JButton("Ver mas");
		btnVermasEdicionesEstudiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				infoE.setVisible(true);
				infoP.setVisible(false);
				String hola=cxEstudianteEdicion.getSelectedItem().toString();
				infoE.cargarDatosIE(hola);
			}
		});
		GridBagConstraints gbc_btnVermasEdicionesEstudiante = new GridBagConstraints();
		gbc_btnVermasEdicionesEstudiante.insets = new Insets(0, 0, 5, 0);
		gbc_btnVermasEdicionesEstudiante.gridx = 4;
		gbc_btnVermasEdicionesEstudiante.gridy = 10;
		getContentPane().add(btnVermasEdicionesEstudiante, gbc_btnVermasEdicionesEstudiante);
		
		JLabel lblProgramas = new JLabel("Programas :");
		GridBagConstraints gbc_lblProgramas = new GridBagConstraints();
		gbc_lblProgramas.anchor = GridBagConstraints.EAST;
		gbc_lblProgramas.insets = new Insets(0, 0, 5, 5);
		gbc_lblProgramas.gridx = 0;
		gbc_lblProgramas.gridy = 11;
		getContentPane().add(lblProgramas, gbc_lblProgramas);
		
		cxEstudiantePrograma = new JComboBox<String>();
		GridBagConstraints gbc_cxEstudiantePrograma = new GridBagConstraints();
		gbc_cxEstudiantePrograma.gridwidth = 3;
		gbc_cxEstudiantePrograma.insets = new Insets(0, 0, 5, 5);
		gbc_cxEstudiantePrograma.fill = GridBagConstraints.HORIZONTAL;
		gbc_cxEstudiantePrograma.gridx = 1;
		gbc_cxEstudiantePrograma.gridy = 11;
		getContentPane().add(cxEstudiantePrograma, gbc_cxEstudiantePrograma);
		
		JButton btnVermasProgramasEstudiantes = new JButton("Ver mas");
		btnVermasProgramasEstudiantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				infoP.setVisible(true);
				String hola=cxEstudiantePrograma.getSelectedItem().toString();
				infoE.setVisible(false);
				infoP.cargarDatosIP(hola);
			}
		});
		GridBagConstraints gbc_btnVermasProgramasEstudiantes = new GridBagConstraints();
		gbc_btnVermasProgramasEstudiantes.insets = new Insets(0, 0, 5, 0);
		gbc_btnVermasProgramasEstudiantes.gridx = 4;
		gbc_btnVermasProgramasEstudiantes.gridy = 11;
		getContentPane().add(btnVermasProgramasEstudiantes, gbc_btnVermasProgramasEstudiantes);
		
		infoE=new infoEdicion();
		infoE.setVisible(false);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		limpiar();
        		setVisible(false);
        	}
        });
        GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
        gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
        gbc_btnCancelar.gridx = 2;
        gbc_btnCancelar.gridy = 12;
        getContentPane().add(btnCancelar, gbc_btnCancelar);
        GridBagConstraints gbc_infoE = new GridBagConstraints();
        gbc_infoE.insets = new Insets(0, 0, 0, 5);
        gbc_infoE.gridwidth = 3;
        gbc_infoE.fill = GridBagConstraints.BOTH;
        gbc_infoE.gridx = 0;
        gbc_infoE.gridy = 13;
        getContentPane().add(infoE, gbc_infoE);
        
        infoP=new infoPrograma();
        infoP.setVisible(false);
        GridBagConstraints gbc_infoP = new GridBagConstraints();
        gbc_infoP.gridwidth = 3;
        gbc_infoP.fill = GridBagConstraints.BOTH;
        gbc_infoP.gridx = 2;
        gbc_infoP.gridy = 13;
        getContentPane().add(infoP, gbc_infoP);

	}
	
	public void cargarDatosCDU() {
		cxUsuario.removeAllItems();
		cxUsuario.addItem("NONE");
		cxEstudiantePrograma.addItem("NONE");
		cxEstudianteEdicion.addItem("NONE");
		cxDocenteEdicion.addItem("NONE");
		interfaceUsuario IUsuario=Fabrica.getInstancia().getIUsuario();
		Set<String> usu=IUsuario.listarUsuarios();
		for (String iter:usu) {
			cxUsuario.addItem(iter);
		}
	}
	private void desplegarDatos() {
		interfaceUsuario IUsuario=Fabrica.getInstancia().getIUsuario();
		interfaceCurso ICurso=Fabrica.getInstancia().getICurso();
		String usu=cxUsuario.getSelectedItem().toString();
		if (!usu.equals("NONE")) {
			DtUsuario info=IUsuario.verDatosUsuario(usu);
			txtNick.setText(info.getNick());
			txtNombre.setText(info.getNombre());
			txtApellido.setText(info.getApellido());
			txtCorreo.setText(info.getCorreo());
			String s= IUsuario.fechaDecente(info.getFechaNacimiento());
			txtFecha.setText(s);
			if(info instanceof DtDocente) {
				//((DtDocente)info).
				txtTipoUsuario.setText("Docente");
				Set<DtInstancia> setsito =((DtDocente)info).getRegistroInstancias();
				for (DtInstancia iter:setsito) {
					cxDocenteEdicion.addItem(iter.getNombre());
				}
				} else {
				txtTipoUsuario.setText("Estudiante");
				Set<String> sett=((DtEstudianteIn)info).getInscriptoInstancias();
				boolean p;
				for (String i:sett) {
					p=ICurso.esPrograma(i);
					if (p) {
						cxEstudiantePrograma.addItem(i);
					} else {
						cxEstudianteEdicion.addItem(i);
					}
				}
				}
			}
		}
	
	private void limpiar() { 
		txtNick.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtCorreo.setText("");
		txtFecha.setText("");
		txtTipoUsuario.setText("");
		cxUsuario.removeAllItems();
		cxEstudiantePrograma.removeAllItems();
		cxEstudianteEdicion.removeAllItems();
		cxDocenteEdicion.removeAllItems();
	}
	private void limpiarCx() {
		cxEstudiantePrograma.removeAllItems();
		cxEstudianteEdicion.removeAllItems();
		cxDocenteEdicion.removeAllItems();
		cxEstudiantePrograma.addItem("NONE");
		cxEstudianteEdicion.addItem("NONE");
		cxDocenteEdicion.addItem("NONE");
	}
}
