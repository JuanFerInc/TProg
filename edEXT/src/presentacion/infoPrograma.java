package presentacion;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Set;

import javax.swing.JTextField;

import logica.ctrleinterfaces.Fabrica;
import logica.ctrleinterfaces.interfaceCurso;
import logica.ctrleinterfaces.interfaceUsuario;
import logica.datatypes.DtEdicion;
import logica.datatypes.DtInstancia;
import logica.datatypes.DtPrograma;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class infoPrograma extends JInternalFrame{
	private JTextField txtNombre;
	private JTextField txtDescripcion;
	private JTextField txtInicio;
	private JTextField txtFinal;
	private JTextField txtAlta;
	private DefaultListModel<String> listModel;
	
	public infoPrograma() {
		setTitle("Informacion de programa de formacion");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{68, 106, 59, 89, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNombre = new JLabel("Nombre :");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		getContentPane().add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.gridwidth = 4;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 0;
		getContentPane().add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion :");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 0;
		gbc_lblDescripcion.gridy = 1;
		getContentPane().add(lblDescripcion, gbc_lblDescripcion);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setEditable(false);
		GridBagConstraints gbc_txtDescripcion = new GridBagConstraints();
		gbc_txtDescripcion.gridwidth = 4;
		gbc_txtDescripcion.insets = new Insets(0, 0, 5, 0);
		gbc_txtDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDescripcion.gridx = 1;
		gbc_txtDescripcion.gridy = 1;
		getContentPane().add(txtDescripcion, gbc_txtDescripcion);
		txtDescripcion.setColumns(10);
		
		JLabel lblPeriodoDeVigencia = new JLabel("Periodo de Vigencia");
		GridBagConstraints gbc_lblPeriodoDeVigencia = new GridBagConstraints();
		gbc_lblPeriodoDeVigencia.insets = new Insets(0, 0, 5, 0);
		gbc_lblPeriodoDeVigencia.gridwidth = 5;
		gbc_lblPeriodoDeVigencia.gridx = 0;
		gbc_lblPeriodoDeVigencia.gridy = 2;
		getContentPane().add(lblPeriodoDeVigencia, gbc_lblPeriodoDeVigencia);
		
		JLabel lblInicio = new JLabel("Inicio :");
		GridBagConstraints gbc_lblInicio = new GridBagConstraints();
		gbc_lblInicio.insets = new Insets(0, 0, 5, 5);
		gbc_lblInicio.gridx = 0;
		gbc_lblInicio.gridy = 3;
		getContentPane().add(lblInicio, gbc_lblInicio);
		
		txtInicio = new JTextField();
		txtInicio.setEditable(false);
		GridBagConstraints gbc_txtInicio = new GridBagConstraints();
		gbc_txtInicio.insets = new Insets(0, 0, 5, 5);
		gbc_txtInicio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInicio.gridx = 1;
		gbc_txtInicio.gridy = 3;
		getContentPane().add(txtInicio, gbc_txtInicio);
		txtInicio.setColumns(10);
		
		JLabel lblFinal = new JLabel("Final :");
		GridBagConstraints gbc_lblFinal = new GridBagConstraints();
		gbc_lblFinal.anchor = GridBagConstraints.EAST;
		gbc_lblFinal.insets = new Insets(0, 0, 5, 5);
		gbc_lblFinal.gridx = 2;
		gbc_lblFinal.gridy = 3;
		getContentPane().add(lblFinal, gbc_lblFinal);
		
		txtFinal = new JTextField();
		txtFinal.setEditable(false);
		GridBagConstraints gbc_txtFinal = new GridBagConstraints();
		gbc_txtFinal.insets = new Insets(0, 0, 5, 0);
		gbc_txtFinal.gridwidth = 2;
		gbc_txtFinal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFinal.gridx = 3;
		gbc_txtFinal.gridy = 3;
		getContentPane().add(txtFinal, gbc_txtFinal);
		txtFinal.setColumns(10);
		
		JLabel lblFechaAlta = new JLabel("Fecha Alta :");
		GridBagConstraints gbc_lblFechaAlta = new GridBagConstraints();
		gbc_lblFechaAlta.anchor = GridBagConstraints.EAST;
		gbc_lblFechaAlta.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaAlta.gridx = 0;
		gbc_lblFechaAlta.gridy = 4;
		getContentPane().add(lblFechaAlta, gbc_lblFechaAlta);
		
		txtAlta = new JTextField();
		txtAlta.setEditable(false);
		GridBagConstraints gbc_txtAlta = new GridBagConstraints();
		gbc_txtAlta.gridwidth = 4;
		gbc_txtAlta.insets = new Insets(0, 0, 5, 0);
		gbc_txtAlta.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAlta.gridx = 1;
		gbc_txtAlta.gridy = 4;
		getContentPane().add(txtAlta, gbc_txtAlta);
		txtAlta.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cursos :");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 5;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				limpiar();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 5;
		getContentPane().add(scrollPane, gbc_scrollPane);
		
		listModel = new DefaultListModel<>();
		JList<String> list = new JList<>(listModel);
		scrollPane.setViewportView(list);
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 2;
		gbc_btnAceptar.gridy = 6;
		getContentPane().add(btnAceptar, gbc_btnAceptar);
	}
	public void cargarDatosIP(String s) {
		if (!s.equals("NONE")) {
			interfaceCurso ICurso=Fabrica.getInstancia().getICurso();
			interfaceUsuario IUsuario=Fabrica.getInstancia().getIUsuario();
			DtInstancia dt=ICurso.verDatosPrograma(s);
			txtNombre.setText(dt.getNombre());
			txtFinal.setText(IUsuario.fechaDecente(dt.getFin()));
			txtInicio.setText(IUsuario.fechaDecente(dt.getInicio()));
			DtPrograma dtt=((DtPrograma)dt);
			txtAlta.setText(IUsuario.fechaDecente(dtt.getAlta()));
			txtDescripcion.setText(dtt.getDescripcion());
			Set<String> setsito=dtt.getCursos();
			for (String i:setsito) {
				listModel.addElement(i);
			}
			if (setsito.isEmpty()) {
				listModel.addElement("NONE");
				}
		} else {
			listModel.addElement("NONE");
		}
	}
	private void limpiar() {
		txtNombre.setText("");
		txtFinal.setText("");
		txtInicio.setText("");
		txtAlta.setText("");
		txtDescripcion.setText("");
		listModel.removeAllElements();
	}
}
