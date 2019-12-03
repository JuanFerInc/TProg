package presentacion;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.util.Set;

import javax.swing.SwingConstants;

import logica.ctrleinterfaces.Fabrica;
import logica.ctrleinterfaces.interfaceCurso;
import logica.datatypes.DtCurso;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarProgramaDeFormacionInfoCursos extends JInternalFrame {
	private JTextField textNombre;
	private JTextField textURL;
	private JTextField textDuracion;
	private JTextField textHora;
	private JTextField textCreditos;
	private JComboBox<String> cxPrevias;
	private JComboBox<String> cxEdiciones;
	private JTextField textActual;
	private JTextArea textDes;
	
	public ConsultarProgramaDeFormacionInfoCursos() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		GridBagConstraints gbc_textNombre = new GridBagConstraints();
		gbc_textNombre.gridwidth = 3;
		gbc_textNombre.insets = new Insets(0, 0, 5, 0);
		gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNombre.gridx = 1;
		gbc_textNombre.gridy = 0;
		getContentPane().add(textNombre, gbc_textNombre);
		textNombre.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 0;
		gbc_lblDescripcion.gridy = 1;
		getContentPane().add(lblDescripcion, gbc_lblDescripcion);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		getContentPane().add(scrollPane, gbc_scrollPane);
		
		textDes = new JTextArea();
		textDes.setWrapStyleWord(true);
		textDes.setLineWrap(true);
		textDes.setEditable(false);
		scrollPane.setViewportView(textDes);
		
		JLabel lblNewLabel_1 = new JLabel("URL");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textURL = new JTextField();
		textURL.setEditable(false);
		GridBagConstraints gbc_textURL = new GridBagConstraints();
		gbc_textURL.gridwidth = 3;
		gbc_textURL.insets = new Insets(0, 0, 5, 0);
		gbc_textURL.fill = GridBagConstraints.HORIZONTAL;
		gbc_textURL.gridx = 1;
		gbc_textURL.gridy = 2;
		getContentPane().add(textURL, gbc_textURL);
		textURL.setColumns(10);
		
		JLabel lblDuracion = new JLabel("Duracion");
		GridBagConstraints gbc_lblDuracion = new GridBagConstraints();
		gbc_lblDuracion.anchor = GridBagConstraints.EAST;
		gbc_lblDuracion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDuracion.gridx = 0;
		gbc_lblDuracion.gridy = 3;
		getContentPane().add(lblDuracion, gbc_lblDuracion);
		
		textDuracion = new JTextField();
		textDuracion.setEditable(false);
		GridBagConstraints gbc_textDuracion = new GridBagConstraints();
		gbc_textDuracion.insets = new Insets(0, 0, 5, 5);
		gbc_textDuracion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDuracion.gridx = 1;
		gbc_textDuracion.gridy = 3;
		getContentPane().add(textDuracion, gbc_textDuracion);
		textDuracion.setColumns(10);
		
		JLabel lblHoras = new JLabel("Horas");
		lblHoras.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblHoras = new GridBagConstraints();
		gbc_lblHoras.anchor = GridBagConstraints.EAST;
		gbc_lblHoras.insets = new Insets(0, 0, 5, 5);
		gbc_lblHoras.gridx = 2;
		gbc_lblHoras.gridy = 3;
		getContentPane().add(lblHoras, gbc_lblHoras);
		
		textHora = new JTextField();
		textHora.setEditable(false);
		GridBagConstraints gbc_textHora = new GridBagConstraints();
		gbc_textHora.insets = new Insets(0, 0, 5, 0);
		gbc_textHora.fill = GridBagConstraints.HORIZONTAL;
		gbc_textHora.gridx = 3;
		gbc_textHora.gridy = 3;
		getContentPane().add(textHora, gbc_textHora);
		textHora.setColumns(10);
		
		JLabel lblCreditos = new JLabel("Creditos");
		GridBagConstraints gbc_lblCreditos = new GridBagConstraints();
		gbc_lblCreditos.anchor = GridBagConstraints.EAST;
		gbc_lblCreditos.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreditos.gridx = 0;
		gbc_lblCreditos.gridy = 4;
		getContentPane().add(lblCreditos, gbc_lblCreditos);
		
		textCreditos = new JTextField();
		textCreditos.setEditable(false);
		GridBagConstraints gbc_textCreditos = new GridBagConstraints();
		gbc_textCreditos.insets = new Insets(0, 0, 5, 0);
		gbc_textCreditos.gridwidth = 3;
		gbc_textCreditos.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCreditos.gridx = 1;
		gbc_textCreditos.gridy = 4;
		getContentPane().add(textCreditos, gbc_textCreditos);
		textCreditos.setColumns(10);
		
		JLabel lblPrevias = new JLabel("Previas");
		GridBagConstraints gbc_lblPrevias = new GridBagConstraints();
		gbc_lblPrevias.anchor = GridBagConstraints.EAST;
		gbc_lblPrevias.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrevias.gridx = 0;
		gbc_lblPrevias.gridy = 5;
		getContentPane().add(lblPrevias, gbc_lblPrevias);
		
		cxPrevias = new JComboBox<String>();
		GridBagConstraints gbc_cxPrevias = new GridBagConstraints();
		gbc_cxPrevias.gridwidth = 3;
		gbc_cxPrevias.insets = new Insets(0, 0, 5, 0);
		gbc_cxPrevias.fill = GridBagConstraints.HORIZONTAL;
		gbc_cxPrevias.gridx = 1;
		gbc_cxPrevias.gridy = 5;
		getContentPane().add(cxPrevias, gbc_cxPrevias);
		
		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 6;
		getContentPane().add(label, gbc_label);
		
		JLabel lblEdicionActual = new JLabel("Ediciones");
		GridBagConstraints gbc_lblEdicionActual = new GridBagConstraints();
		gbc_lblEdicionActual.anchor = GridBagConstraints.EAST;
		gbc_lblEdicionActual.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdicionActual.gridx = 0;
		gbc_lblEdicionActual.gridy = 7;
		getContentPane().add(lblEdicionActual, gbc_lblEdicionActual);
		
		cxEdiciones = new JComboBox<String>();
		GridBagConstraints gbc_cxEdiciones = new GridBagConstraints();
		gbc_cxEdiciones.gridwidth = 3;
		gbc_cxEdiciones.insets = new Insets(0, 0, 5, 0);
		gbc_cxEdiciones.fill = GridBagConstraints.HORIZONTAL;
		gbc_cxEdiciones.gridx = 1;
		gbc_cxEdiciones.gridy = 7;
		getContentPane().add(cxEdiciones, gbc_cxEdiciones);
		
		JLabel lblEdicionActual_1 = new JLabel("Edicion Actual");
		GridBagConstraints gbc_lblEdicionActual_1 = new GridBagConstraints();
		gbc_lblEdicionActual_1.anchor = GridBagConstraints.EAST;
		gbc_lblEdicionActual_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdicionActual_1.gridx = 0;
		gbc_lblEdicionActual_1.gridy = 8;
		getContentPane().add(lblEdicionActual_1, gbc_lblEdicionActual_1);
		
		textActual = new JTextField();
		textActual.setEditable(false);
		GridBagConstraints gbc_textActual = new GridBagConstraints();
		gbc_textActual.insets = new Insets(0, 0, 5, 0);
		gbc_textActual.gridwidth = 3;
		gbc_textActual.fill = GridBagConstraints.HORIZONTAL;
		gbc_textActual.gridx = 1;
		gbc_textActual.gridy = 8;
		getContentPane().add(textActual, gbc_textActual);
		textActual.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarInfo();
			}
		});
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 2;
		gbc_btnAceptar.gridy = 9;
		getContentPane().add(btnAceptar, gbc_btnAceptar);
	}
	public void cargarDatosCDPDFI(String nombreCurso) {
		interfaceCurso ICurso=Fabrica.getInstancia().getICurso();
		DtCurso dato = ICurso.verDatosCurso(nombreCurso);
		textNombre.setText(dato.getNombre());
		textDes.setText(dato.getDescripcion());
		textURL.setText(dato.getURL());
		textDuracion.setText(Integer.toString(dato.getDuracion()));
		textHora.setText(Integer.toString(dato.getHoras()));
		textCreditos.setText(Integer.toString(dato.getCreditos()));
		cxPrevias.removeAllItems();
		cxPrevias.addItem("NONE");
		Set<String> previas = dato.getPrevias();
		for (String iter:previas) {
			cxPrevias.addItem(iter);
		}
		cxEdiciones.removeAllItems();
		cxEdiciones.addItem("NONE");
		Set<String> ediciones = dato.getEdiciones();
		for (String iter:ediciones) {
			cxEdiciones.addItem(iter);
		}
		textActual.setText(dato.getEdicionActual());
	}
	public void limpiarInfo() {
		textNombre.setText("");
		textDes.setText("");
		textURL.setText("");
		textDuracion.setText("");
		textHora.setText("");
		textCreditos.setText("");
		cxPrevias.removeAllItems();
		cxEdiciones.removeAllItems();
		textActual.setText("");
		setVisible(false);
	}

}
