package presentacion;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import logica.ctrleinterfaces.Fabrica;
import logica.ctrleinterfaces.interfaceCurso;
import logica.ctrleinterfaces.interfaceUsuario;
import logica.datatypes.DtInstancia;
import logica.datatypes.DtPrograma;

import java.awt.Insets;
import java.util.Set;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaDeCursoP extends JInternalFrame{
	private JTextField textNombre;
	private JTextField textFechaInicio;
	private JTextField textFechaFin;
	private JTextField textAlta;
	private JComboBox<String> cxCursos; 
	private JTextArea textDes;
	public ConsultaDeCursoP() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Datos del Programa:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		getContentPane().add(lblNombre, gbc_lblNombre);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		GridBagConstraints gbc_textNombre = new GridBagConstraints();
		gbc_textNombre.insets = new Insets(0, 0, 5, 0);
		gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNombre.gridx = 1;
		gbc_textNombre.gridy = 1;
		getContentPane().add(textNombre, gbc_textNombre);
		textNombre.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 0;
		gbc_lblDescripcion.gridy = 2;
		getContentPane().add(lblDescripcion, gbc_lblDescripcion);
		
		textDes = new JTextArea();
		textDes.setWrapStyleWord(true);
		textDes.setLineWrap(true);
		GridBagConstraints gbc_textDes = new GridBagConstraints();
		gbc_textDes.insets = new Insets(0, 0, 5, 0);
		gbc_textDes.fill = GridBagConstraints.BOTH;
		gbc_textDes.gridx = 1;
		gbc_textDes.gridy = 2;
		getContentPane().add(textDes, gbc_textDes);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha de Inicio:");
		GridBagConstraints gbc_lblFechaDeInicio = new GridBagConstraints();
		gbc_lblFechaDeInicio.anchor = GridBagConstraints.EAST;
		gbc_lblFechaDeInicio.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeInicio.gridx = 0;
		gbc_lblFechaDeInicio.gridy = 3;
		getContentPane().add(lblFechaDeInicio, gbc_lblFechaDeInicio);
		
		textFechaInicio = new JTextField();
		textFechaInicio.setEditable(false);
		GridBagConstraints gbc_textFechaInicio = new GridBagConstraints();
		gbc_textFechaInicio.insets = new Insets(0, 0, 5, 0);
		gbc_textFechaInicio.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFechaInicio.gridx = 1;
		gbc_textFechaInicio.gridy = 3;
		getContentPane().add(textFechaInicio, gbc_textFechaInicio);
		textFechaInicio.setColumns(10);
		
		JLabel lblFechaDeFinalizacion = new JLabel("Fecha de Finalizacion:");
		GridBagConstraints gbc_lblFechaDeFinalizacion = new GridBagConstraints();
		gbc_lblFechaDeFinalizacion.anchor = GridBagConstraints.EAST;
		gbc_lblFechaDeFinalizacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeFinalizacion.gridx = 0;
		gbc_lblFechaDeFinalizacion.gridy = 4;
		getContentPane().add(lblFechaDeFinalizacion, gbc_lblFechaDeFinalizacion);
		
		textFechaFin = new JTextField();
		textFechaFin.setEditable(false);
		GridBagConstraints gbc_textFechaFin = new GridBagConstraints();
		gbc_textFechaFin.insets = new Insets(0, 0, 5, 0);
		gbc_textFechaFin.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFechaFin.gridx = 1;
		gbc_textFechaFin.gridy = 4;
		getContentPane().add(textFechaFin, gbc_textFechaFin);
		textFechaFin.setColumns(10);
		
		JLabel lblFechaDePublicacion = new JLabel("Fecha de Publicacion:");
		GridBagConstraints gbc_lblFechaDePublicacion = new GridBagConstraints();
		gbc_lblFechaDePublicacion.anchor = GridBagConstraints.EAST;
		gbc_lblFechaDePublicacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDePublicacion.gridx = 0;
		gbc_lblFechaDePublicacion.gridy = 5;
		getContentPane().add(lblFechaDePublicacion, gbc_lblFechaDePublicacion);
		
		textAlta = new JTextField();
		textAlta.setEditable(false);
		GridBagConstraints gbc_textAlta = new GridBagConstraints();
		gbc_textAlta.insets = new Insets(0, 0, 5, 0);
		gbc_textAlta.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAlta.gridx = 1;
		gbc_textAlta.gridy = 5;
		getContentPane().add(textAlta, gbc_textAlta);
		textAlta.setColumns(10);
		
		JLabel lblCursos = new JLabel("Cursos:");
		GridBagConstraints gbc_lblCursos = new GridBagConstraints();
		gbc_lblCursos.anchor = GridBagConstraints.EAST;
		gbc_lblCursos.insets = new Insets(0, 0, 5, 5);
		gbc_lblCursos.gridx = 0;
		gbc_lblCursos.gridy = 6;
		getContentPane().add(lblCursos, gbc_lblCursos);
		
		cxCursos = new JComboBox<String>();
		GridBagConstraints gbc_cxCursos = new GridBagConstraints();
		gbc_cxCursos.insets = new Insets(0, 0, 5, 0);
		gbc_cxCursos.fill = GridBagConstraints.HORIZONTAL;
		gbc_cxCursos.gridx = 1;
		gbc_cxCursos.gridy = 6;
		getContentPane().add(cxCursos, gbc_cxCursos);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				limpiar();
			}
		});
		GridBagConstraints gbc_btnCerrar = new GridBagConstraints();
		gbc_btnCerrar.gridx = 1;
		gbc_btnCerrar.gridy = 8;
		getContentPane().add(btnCerrar, gbc_btnCerrar);
	}
	public void cargarDatosCDCP(String nombrePrograma) {
		if(!nombrePrograma.equals("NONE")) {
			interfaceCurso ICurso=Fabrica.getInstancia().getICurso();
			interfaceUsuario IUsuario=Fabrica.getInstancia().getIUsuario();
			DtInstancia datoI = ICurso.verDatosPrograma(nombrePrograma);
			DtPrograma dato = (DtPrograma)datoI;
			textNombre.setText(dato.getNombre());
			textDes.setText(dato.getDescripcion());
			textFechaInicio.setText(IUsuario.fechaDecente(dato.getInicio()));
			textFechaFin.setText(IUsuario.fechaDecente(dato.getFin()));
			textAlta.setText(IUsuario.fechaDecente(dato.getAlta()));
			Set<String> cursos = dato.getCursos();
			if(!cursos.isEmpty()) {
				for (String iter:cursos) {
					cxCursos.addItem(iter);
				}
			}else {
				cxCursos.addItem("NONE");
			}
		}
		
	}
	private void limpiar() {
		textNombre.setText("");
		textDes.setText("");
		textFechaInicio.setText("");
		textFechaFin.setText("");
		textAlta.setText("");
		cxCursos.removeAllItems();
	}

}
