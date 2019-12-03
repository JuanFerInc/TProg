package presentacion;

import javax.swing.JInternalFrame;
import java.util.*;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import exception.CursoRepetidoExcep;
import logica.ctrleinterfaces.Fabrica;
import logica.ctrleinterfaces.interfaceCurso;
import logica.ctrleinterfaces.interfaceUsuario;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AltaDeCurso extends JInternalFrame {
	private JTextField txtNombre;
	private JTextField txtURL;
	private JComboBox<String> cxInstituto;
	private JSpinner spDuracion;
	private JSpinner spHoras;
	private JSpinner spCreditos;
	private JSpinner spDia ;
	private JSpinner spMes;
	private JSpinner spAnio;
	private JTextArea textDes;
	private JComboBox<String> cxPrevias;
	private Set<String> previas;
	private interfaceCurso ICurso;
	private JComboBox<String> cbCategorias;
	private Set<String> categorias;
	private JTextField textField;

	public AltaDeCurso() {
		previas=new HashSet<String>();
		setTitle("Alta de Curso");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{71, 88, 0, 0, 74, 62, 63, 85, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 54, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblInstituto = new JLabel("Instituto :");
		GridBagConstraints gbc_lblInstituto = new GridBagConstraints();
		gbc_lblInstituto.insets = new Insets(0, 0, 5, 5);
		gbc_lblInstituto.gridx = 0;
		gbc_lblInstituto.gridy = 0;
		getContentPane().add(lblInstituto, gbc_lblInstituto);
		
		cxInstituto = new JComboBox<String>();
		GridBagConstraints gbc_cxInstituto = new GridBagConstraints();
		gbc_cxInstituto.fill = GridBagConstraints.HORIZONTAL;
		gbc_cxInstituto.insets = new Insets(0, 0, 5, 0);
		gbc_cxInstituto.gridwidth = 7;
		gbc_cxInstituto.gridx = 1;
		gbc_cxInstituto.gridy = 0;
		getContentPane().add(cxInstituto, gbc_cxInstituto);
		
		JLabel lblNewLabel = new JLabel("Nombre :");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridwidth = 7;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 1;
		getContentPane().add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblDuracion = new JLabel("Descripcion :");
		GridBagConstraints gbc_lblDuracion = new GridBagConstraints();
		gbc_lblDuracion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDuracion.gridx = 0;
		gbc_lblDuracion.gridy = 2;
		getContentPane().add(lblDuracion, gbc_lblDuracion);
		
		textDes = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 7;
		gbc_textArea.insets = new Insets(0, 0, 5, 0);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 2;
		getContentPane().add(textDes, gbc_textArea);
		
		JLabel lblCategoria = new JLabel("Categorias");
		GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
		gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategoria.anchor = GridBagConstraints.EAST;
		gbc_lblCategoria.gridx = 0;
		gbc_lblCategoria.gridy = 3;
		getContentPane().add(lblCategoria, gbc_lblCategoria);
		
		cbCategorias = new JComboBox<String>();
		GridBagConstraints gbc_cbCategorias = new GridBagConstraints();
		gbc_cbCategorias.gridwidth = 6;
		gbc_cbCategorias.insets = new Insets(0, 0, 5, 5);
		gbc_cbCategorias.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbCategorias.gridx = 1;
		gbc_cbCategorias.gridy = 3;
		getContentPane().add(cbCategorias, gbc_cbCategorias);
		
		JButton btnElegirCat = new JButton("Elegir");
		btnElegirCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!cbCategorias.getSelectedItem().toString().equals("NONE")){
					if(categorias.contains((cbCategorias.getSelectedItem().toString()))){
						cartelito("La categoria ya fue agregada");
					}else {
					categorias.add(cbCategorias.getSelectedItem().toString());
					}
				}else {
					cartelito("NONE no es una categoria valida");
				}
			}
		});
		GridBagConstraints gbc_btnElegirCat = new GridBagConstraints();
		gbc_btnElegirCat.insets = new Insets(0, 0, 5, 0);
		gbc_btnElegirCat.gridx = 7;
		gbc_btnElegirCat.gridy = 3;
		getContentPane().add(btnElegirCat, gbc_btnElegirCat);
		
		JLabel lblDuracion_1 = new JLabel("Duracion :");
		GridBagConstraints gbc_lblDuracion_1 = new GridBagConstraints();
		gbc_lblDuracion_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblDuracion_1.gridx = 0;
		gbc_lblDuracion_1.gridy = 4;
		getContentPane().add(lblDuracion_1, gbc_lblDuracion_1);
		
		spDuracion = new JSpinner();
		spDuracion.setModel(new SpinnerNumberModel(0, 0, 3000, 1));
		GridBagConstraints gbc_spDuracion = new GridBagConstraints();
		gbc_spDuracion.insets = new Insets(0, 0, 5, 5);
		gbc_spDuracion.gridx = 1;
		gbc_spDuracion.gridy = 4;
		getContentPane().add(spDuracion, gbc_spDuracion);
		
		JLabel lblNewLabel_1 = new JLabel("Horas :");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 4;
		gbc_lblNewLabel_1.gridy = 4;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		spHoras = new JSpinner();
		spHoras.setModel(new SpinnerNumberModel(0, 0, 3000, 1));
		GridBagConstraints gbc_spHoras = new GridBagConstraints();
		gbc_spHoras.insets = new Insets(0, 0, 5, 5);
		gbc_spHoras.gridx = 5;
		gbc_spHoras.gridy = 4;
		getContentPane().add(spHoras, gbc_spHoras);
		
		JLabel lblCreditos = new JLabel("Creditos :");
		GridBagConstraints gbc_lblCreditos = new GridBagConstraints();
		gbc_lblCreditos.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreditos.gridx = 6;
		gbc_lblCreditos.gridy = 4;
		getContentPane().add(lblCreditos, gbc_lblCreditos);
		
		spCreditos = new JSpinner();
		spCreditos.setModel(new SpinnerNumberModel(0, 0, 3000, 1));
		GridBagConstraints gbc_spCreditos = new GridBagConstraints();
		gbc_spCreditos.insets = new Insets(0, 0, 5, 0);
		gbc_spCreditos.gridx = 7;
		gbc_spCreditos.gridy = 4;
		getContentPane().add(spCreditos, gbc_spCreditos);
		
		JLabel lblUrl = new JLabel("URL :");
		GridBagConstraints gbc_lblUrl = new GridBagConstraints();
		gbc_lblUrl.insets = new Insets(0, 0, 5, 5);
		gbc_lblUrl.gridx = 0;
		gbc_lblUrl.gridy = 5;
		getContentPane().add(lblUrl, gbc_lblUrl);
		
		txtURL = new JTextField();
		GridBagConstraints gbc_txtURL = new GridBagConstraints();
		gbc_txtURL.insets = new Insets(0, 0, 5, 0);
		gbc_txtURL.gridwidth = 7;
		gbc_txtURL.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtURL.gridx = 1;
		gbc_txtURL.gridy = 5;
		getContentPane().add(txtURL, gbc_txtURL);
		txtURL.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha de alta");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridwidth = 8;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 6;
		getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblDia = new JLabel("Dia :");
		GridBagConstraints gbc_lblDia = new GridBagConstraints();
		gbc_lblDia.insets = new Insets(0, 0, 5, 5);
		gbc_lblDia.gridx = 0;
		gbc_lblDia.gridy = 7;
		getContentPane().add(lblDia, gbc_lblDia);
		
		spDia = new JSpinner();
		spDia.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		GridBagConstraints gbc_spDia = new GridBagConstraints();
		gbc_spDia.insets = new Insets(0, 0, 5, 5);
		gbc_spDia.gridx = 1;
		gbc_spDia.gridy = 7;
		getContentPane().add(spDia, gbc_spDia);
		
		JLabel lblMes = new JLabel("Mes :");
		GridBagConstraints gbc_lblMes = new GridBagConstraints();
		gbc_lblMes.insets = new Insets(0, 0, 5, 5);
		gbc_lblMes.gridx = 4;
		gbc_lblMes.gridy = 7;
		getContentPane().add(lblMes, gbc_lblMes);
		
		spMes = new JSpinner();
		spMes.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		GridBagConstraints gbc_spMes = new GridBagConstraints();
		gbc_spMes.insets = new Insets(0, 0, 5, 5);
		gbc_spMes.gridx = 5;
		gbc_spMes.gridy = 7;
		getContentPane().add(spMes, gbc_spMes);
		
		JLabel lblAnio = new JLabel("Anio :");
		GridBagConstraints gbc_lblAnio = new GridBagConstraints();
		gbc_lblAnio.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnio.gridx = 6;
		gbc_lblAnio.gridy = 7;
		getContentPane().add(lblAnio, gbc_lblAnio);
		
		spAnio = new JSpinner();
		spAnio.setModel(new SpinnerNumberModel(1, 1, 3000, 1));
		GridBagConstraints gbc_spAnio = new GridBagConstraints();
		gbc_spAnio.insets = new Insets(0, 0, 5, 0);
		gbc_spAnio.gridx = 7;
		gbc_spAnio.gridy = 7;
		getContentPane().add(spAnio, gbc_spAnio);
		
		JLabel lblPrevias = new JLabel("Previas :");
		GridBagConstraints gbc_lblPrevias = new GridBagConstraints();
		gbc_lblPrevias.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrevias.gridx = 0;
		gbc_lblPrevias.gridy = 8;
		getContentPane().add(lblPrevias, gbc_lblPrevias);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent argo) {
				desplegarDatos();
			}
		});
		
		cxPrevias = new JComboBox<String>();
		GridBagConstraints gbc_cxPrevias = new GridBagConstraints();
		gbc_cxPrevias.gridwidth = 6;
		gbc_cxPrevias.insets = new Insets(0, 0, 5, 5);
		gbc_cxPrevias.fill = GridBagConstraints.HORIZONTAL;
		gbc_cxPrevias.gridx = 1;
		gbc_cxPrevias.gridy = 8;
		getContentPane().add(cxPrevias, gbc_cxPrevias);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarSet(cxPrevias.getSelectedItem().toString());
			}
		});
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.insets = new Insets(0, 0, 5, 0);
		gbc_btnAgregar.gridx = 7;
		gbc_btnAgregar.gridy = 8;
		getContentPane().add(btnAgregar, gbc_btnAgregar);
		
		JLabel lblUrlDeImagen = new JLabel("URL imagen:");
		GridBagConstraints gbc_lblUrlDeImagen = new GridBagConstraints();
		gbc_lblUrlDeImagen.insets = new Insets(0, 0, 5, 5);
		gbc_lblUrlDeImagen.anchor = GridBagConstraints.EAST;
		gbc_lblUrlDeImagen.gridx = 0;
		gbc_lblUrlDeImagen.gridy = 9;
		getContentPane().add(lblUrlDeImagen, gbc_lblUrlDeImagen);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 6;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 9;
		getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 1;
		gbc_btnAceptar.gridy = 10;
		getContentPane().add(btnAceptar, gbc_btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent es) {
                limpiarFormulario();
                setVisible(false);
                limpiarSet();
            }
        });
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 5;
		gbc_btnCancelar.gridy = 10;
		getContentPane().add(btnCancelar, gbc_btnCancelar);
	}
	
	private void pepito(CursoRepetidoExcep esto) {
		JOptionPane.showMessageDialog(this, esto.getMessage(), "Registrar Usuario", JOptionPane.ERROR_MESSAGE);
	}
	private void limpiarFormulario() {
		categorias.clear();
		txtNombre.setText("");
		textDes.setText("");
		txtURL.setText("");
		cxInstituto.removeAllItems();
		spDuracion.setValue(0);
		spHoras.setValue(0);
		spCreditos.setValue(0);
		spDia.setValue(1);
		spMes.setValue(1);
		spAnio.setValue(1);
		cxPrevias.removeAllItems();
		cbCategorias.removeAllItems();
	}
	
	private boolean checkSwing() {
		boolean nombreU = this.txtNombre.getText().isEmpty();
        boolean des = this.textDes.getText().isEmpty();
        boolean url = this.txtURL.getText().isEmpty();
        boolean tipoU=(this.cxInstituto.getSelectedItem().toString().equals("NONE"));
        boolean flag = categorias.isEmpty();
        int mes= (int) spMes.getValue();
        int dia= (int) spDia.getValue();
        int anio=(int) spAnio.getValue();
        if (dia>31 || dia<1 || mes>12 || mes<-1 || anio<-1) {
        	 JOptionPane.showMessageDialog(this, "Las fechas no son validas", "Alta de Curso", JOptionPane.ERROR_MESSAGE);
             return false;
        }
        int dur = (int) spDuracion.getValue();
        int hor = (int) spHoras.getValue();
        int cred = (int) spCreditos.getValue();
        
        if(dur < 0 || hor < 0 || cred< 0) {
        	JOptionPane.showMessageDialog(this, "La duracion, creditos y horas debe ser mayor a cero", "Alta de Curso", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (nombreU || des || url || tipoU|| flag) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Alta de Curso", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
	
	public void cargarDatosADC() {
		//interfaceUsuario IUsuario=Fabrica.getInstancia().getIUsuario();
		ICurso=Fabrica.getInstancia().getICurso();
		Set<String> setsito = ICurso.listarInstitutos();
		categorias =  ICurso.listarCategorias();
		cxInstituto.addItem("NONE");
		cbCategorias.addItem("NONE");
		for ( String nombreVariableTemporal : setsito ) {
              cxInstituto.addItem(nombreVariableTemporal);
		}
		for(String cat:categorias) {
			cbCategorias.addItem(cat);
		}
		setsito = ICurso.listarCategorias();
		Set<String> prev=ICurso.listarCursosExistente();
		for (String i:prev) {
			cxPrevias.addItem(i);
		}
		cxPrevias.addItem("NONE");
	}
	
private void desplegarDatos() {
	interfaceCurso ICurso=Fabrica.getInstancia().getICurso();
	String url = txtURL.getSelectedText();
	if(checkSwing()) {

	int vDia = (int) spDia.getValue();
	int vMes = (int) spMes.getValue();
	int vAnio = (int) spAnio.getValue();
	Calendar cal=new GregorianCalendar(vAnio, vMes, vDia);
	try {
	ICurso.registrarCurso(cxInstituto.getSelectedItem().toString(), txtNombre.getText(),textDes.getText() , (int) spDuracion.getValue(), (int) spHoras.getValue(), (int) spCreditos.getValue(),txtURL.getText(),cal, previas, categorias,url);
	} catch(CursoRepetidoExcep esto) {
		pepito(esto);
	}
	limpiarFormulario();
    setVisible(false);
	}
	ICurso.salir();
	limpiarSet();
}
private void agregarSet(String s) {
	
	if(s != "NONE") {
		cxPrevias.removeItem(s);
		
		boolean existe=previas.contains(s);
		if (!existe) {
			previas.add(s);
		}
	}
	
}
private void limpiarSet() {
	previas.clear();
}

private void cartelito(String txt){
	JOptionPane.showMessageDialog(this, txt, "Consulta de edicion de curso", JOptionPane.ERROR_MESSAGE);
}

}
