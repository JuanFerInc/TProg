package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Set;

import javax.swing.JTextField;

import logica.ctrleinterfaces.Fabrica;
import logica.ctrleinterfaces.interfaceCurso;
import logica.ctrleinterfaces.interfaceUsuario;
import logica.datatypes.DtDocente;
import logica.datatypes.DtEdicion;
import logica.datatypes.DtEstudianteIn;
import logica.datatypes.DtInstancia;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class infoEdicion extends JInternalFrame{
	private JTextField txtNombre;
	private JTextField txtFI;
	private JTextField txtFF;
	private JTextField txtCupo;
	private JScrollPane scrollPane;
	private DefaultListModel<String> listModel;
	
	public infoEdicion() {
		setTitle("Informacion de la Edicion");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 37, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNombre = new JLabel("Nombre :");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		getContentPane().add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 0;
		getContentPane().add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha de inicio :");
		GridBagConstraints gbc_lblFechaDeInicio = new GridBagConstraints();
		gbc_lblFechaDeInicio.anchor = GridBagConstraints.EAST;
		gbc_lblFechaDeInicio.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeInicio.gridx = 0;
		gbc_lblFechaDeInicio.gridy = 1;
		getContentPane().add(lblFechaDeInicio, gbc_lblFechaDeInicio);
		
		txtFI = new JTextField();
		txtFI.setEditable(false);
		GridBagConstraints gbc_txtFI = new GridBagConstraints();
		gbc_txtFI.insets = new Insets(0, 0, 5, 0);
		gbc_txtFI.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFI.gridx = 1;
		gbc_txtFI.gridy = 1;
		getContentPane().add(txtFI, gbc_txtFI);
		txtFI.setColumns(10);
		
		JLabel lblFechaDeFinalizacion = new JLabel("Fecha de finalizacion :");
		GridBagConstraints gbc_lblFechaDeFinalizacion = new GridBagConstraints();
		gbc_lblFechaDeFinalizacion.anchor = GridBagConstraints.EAST;
		gbc_lblFechaDeFinalizacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeFinalizacion.gridx = 0;
		gbc_lblFechaDeFinalizacion.gridy = 2;
		getContentPane().add(lblFechaDeFinalizacion, gbc_lblFechaDeFinalizacion);
		
		txtFF = new JTextField();
		txtFF.setEditable(false);
		GridBagConstraints gbc_txtFF = new GridBagConstraints();
		gbc_txtFF.insets = new Insets(0, 0, 5, 0);
		gbc_txtFF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFF.gridx = 1;
		gbc_txtFF.gridy = 2;
		getContentPane().add(txtFF, gbc_txtFF);
		txtFF.setColumns(10);
		
		JLabel lblCupos = new JLabel("Cupos :");
		GridBagConstraints gbc_lblCupos = new GridBagConstraints();
		gbc_lblCupos.anchor = GridBagConstraints.EAST;
		gbc_lblCupos.insets = new Insets(0, 0, 5, 5);
		gbc_lblCupos.gridx = 0;
		gbc_lblCupos.gridy = 3;
		getContentPane().add(lblCupos, gbc_lblCupos);
		
		txtCupo = new JTextField();
		txtCupo.setEditable(false);
		GridBagConstraints gbc_txtCupo = new GridBagConstraints();
		gbc_txtCupo.insets = new Insets(0, 0, 5, 0);
		gbc_txtCupo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCupo.gridx = 1;
		gbc_txtCupo.gridy = 3;
		getContentPane().add(txtCupo, gbc_txtCupo);
		txtCupo.setColumns(10);
		
		JLabel lblDocentes = new JLabel("Docentes :");
		GridBagConstraints gbc_lblDocentes = new GridBagConstraints();
		gbc_lblDocentes.insets = new Insets(0, 0, 5, 5);
		gbc_lblDocentes.gridx = 0;
		gbc_lblDocentes.gridy = 4;
		getContentPane().add(lblDocentes, gbc_lblDocentes);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		getContentPane().add(scrollPane, gbc_scrollPane);
		
		listModel = new DefaultListModel<>();
		JList<String> list = new JList<>(listModel);
		scrollPane.setViewportView(list);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				limpiar();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 5;
		getContentPane().add(btnNewButton, gbc_btnNewButton);
	}
	public void cargarDatosIE(String h) {
		if (!h.equals("NONE")) {
		interfaceCurso ICurso=Fabrica.getInstancia().getICurso();
		interfaceUsuario IUsuario=Fabrica.getInstancia().getIUsuario();
		DtInstancia dt=ICurso.verDatosEdicion(h);
		txtNombre.setText(dt.getNombre());
		txtFI.setText(IUsuario.fechaDecente(dt.getInicio()));
		txtFF.setText(IUsuario.fechaDecente(dt.getFin()));
		int bebe=((DtEdicion)dt).getCupo();
		String bb= Integer.toString(bebe);
		txtCupo.setText(bb);
		Set<String> setsito=((DtEdicion)dt).getDocentesParticipan();
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
		txtFI.setText("");
		txtFF.setText("");
		txtCupo.setText("");
		listModel.removeAllElements();
	}
	
}
