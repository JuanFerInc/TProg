package presentacion;

import javax.swing.JInternalFrame;

import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.util.Set;

import javax.swing.JTextField;

import logica.ctrleinterfaces.Fabrica;
import logica.ctrleinterfaces.interfaceCurso;
import logica.ctrleinterfaces.interfaceUsuario;
import logica.datatypes.DtInstancia;
import logica.datatypes.DtPrograma;
import presentacion.ConsultarProgramaDeFormacionInfoCursos;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ConsultaDeProgramaDeFormacion extends JInternalFrame{
	private JTextField textNombre;
	private JTextField fechaInicio;
	private JTextField fechaFin;
	private JTextField fechaAlta;
	private JComboBox<String> cxProgramas;
	private JComboBox<String> cxCursos;
	private ConsultarProgramaDeFormacionInfoCursos infoCurso;
	private JTextArea textDes;
	private JComboBox<String> cxCategorias;
	
	public ConsultaDeProgramaDeFormacion() {
		setTitle("Consulta de Programa de Formacion");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{67, 64, 108, 79, 25, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblProgramasDeFormacion = new JLabel("Programa de Formacion :");
		GridBagConstraints gbc_lblProgramasDeFormacion = new GridBagConstraints();
		gbc_lblProgramasDeFormacion.gridwidth = 2;
		gbc_lblProgramasDeFormacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblProgramasDeFormacion.gridx = 0;
		gbc_lblProgramasDeFormacion.gridy = 0;
		getContentPane().add(lblProgramasDeFormacion, gbc_lblProgramasDeFormacion);
		
		cxProgramas = new JComboBox<String>();
		GridBagConstraints gbc_cxProgramas = new GridBagConstraints();
		gbc_cxProgramas.gridwidth = 3;
		gbc_cxProgramas.insets = new Insets(0, 0, 5, 5);
		gbc_cxProgramas.fill = GridBagConstraints.HORIZONTAL;
		gbc_cxProgramas.gridx = 2;
		gbc_cxProgramas.gridy = 0;
		getContentPane().add(cxProgramas, gbc_cxProgramas);
		
		JButton btnElegir = new JButton("Elegir");
		btnElegir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desplegarDatos();
			}
		});
		GridBagConstraints gbc_btnElegir = new GridBagConstraints();
		gbc_btnElegir.insets = new Insets(0, 0, 5, 0);
		gbc_btnElegir.gridx = 5;
		gbc_btnElegir.gridy = 0;
		getContentPane().add(btnElegir, gbc_btnElegir);
		
		JLabel lblDatosBasicos = new JLabel("Datos basicos del programa de formacion");
		GridBagConstraints gbc_lblDatosBasicos = new GridBagConstraints();
		gbc_lblDatosBasicos.insets = new Insets(0, 0, 5, 0);
		gbc_lblDatosBasicos.gridwidth = 6;
		gbc_lblDatosBasicos.gridx = 0;
		gbc_lblDatosBasicos.gridy = 1;
		getContentPane().add(lblDatosBasicos, gbc_lblDatosBasicos);
		
		JLabel lblNombre = new JLabel("Nombre :");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.gridwidth = 2;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 2;
		getContentPane().add(lblNombre, gbc_lblNombre);
		
		textNombre = new JTextField();
		GridBagConstraints gbc_textNombre = new GridBagConstraints();
		gbc_textNombre.gridwidth = 4;
		gbc_textNombre.insets = new Insets(0, 0, 5, 0);
		gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNombre.gridx = 2;
		gbc_textNombre.gridy = 2;
		getContentPane().add(textNombre, gbc_textNombre);
		textNombre.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion :");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.gridwidth = 2;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 0;
		gbc_lblDescripcion.gridy = 3;
		getContentPane().add(lblDescripcion, gbc_lblDescripcion);
		
		textDes = new JTextArea();
		GridBagConstraints gbc_textDes = new GridBagConstraints();
		gbc_textDes.gridwidth = 4;
		gbc_textDes.insets = new Insets(0, 0, 5, 0);
		gbc_textDes.fill = GridBagConstraints.BOTH;
		gbc_textDes.gridx = 2;
		gbc_textDes.gridy = 3;
		getContentPane().add(textDes, gbc_textDes);
		
		JLabel lblPeriodoDeVigencia = new JLabel("Periodo de vigencia");
		GridBagConstraints gbc_lblPeriodoDeVigencia = new GridBagConstraints();
		gbc_lblPeriodoDeVigencia.insets = new Insets(0, 0, 5, 0);
		gbc_lblPeriodoDeVigencia.gridwidth = 6;
		gbc_lblPeriodoDeVigencia.gridx = 0;
		gbc_lblPeriodoDeVigencia.gridy = 4;
		getContentPane().add(lblPeriodoDeVigencia, gbc_lblPeriodoDeVigencia);
		
		JLabel lblInicio = new JLabel("Inicio :");
		GridBagConstraints gbc_lblInicio = new GridBagConstraints();
		gbc_lblInicio.insets = new Insets(0, 0, 5, 5);
		gbc_lblInicio.gridx = 0;
		gbc_lblInicio.gridy = 5;
		getContentPane().add(lblInicio, gbc_lblInicio);
		
		fechaInicio = new JTextField();
		GridBagConstraints gbc_fechaInicio = new GridBagConstraints();
		gbc_fechaInicio.gridwidth = 2;
		gbc_fechaInicio.insets = new Insets(0, 0, 5, 5);
		gbc_fechaInicio.fill = GridBagConstraints.HORIZONTAL;
		gbc_fechaInicio.gridx = 1;
		gbc_fechaInicio.gridy = 5;
		getContentPane().add(fechaInicio, gbc_fechaInicio);
		fechaInicio.setColumns(10);
		
		JLabel lblFinal = new JLabel("Final :");
		GridBagConstraints gbc_lblFinal = new GridBagConstraints();
		gbc_lblFinal.insets = new Insets(0, 0, 5, 5);
		gbc_lblFinal.gridx = 3;
		gbc_lblFinal.gridy = 5;
		getContentPane().add(lblFinal, gbc_lblFinal);
		
		fechaFin = new JTextField();
		GridBagConstraints gbc_fechaFin = new GridBagConstraints();
		gbc_fechaFin.insets = new Insets(0, 0, 5, 0);
		gbc_fechaFin.gridwidth = 2;
		gbc_fechaFin.fill = GridBagConstraints.HORIZONTAL;
		gbc_fechaFin.gridx = 4;
		gbc_fechaFin.gridy = 5;
		getContentPane().add(fechaFin, gbc_fechaFin);
		fechaFin.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Fecha de alta :");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 6;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		fechaAlta = new JTextField();
		GridBagConstraints gbc_fechaAlta = new GridBagConstraints();
		gbc_fechaAlta.insets = new Insets(0, 0, 5, 0);
		gbc_fechaAlta.gridwidth = 4;
		gbc_fechaAlta.fill = GridBagConstraints.HORIZONTAL;
		gbc_fechaAlta.gridx = 2;
		gbc_fechaAlta.gridy = 6;
		getContentPane().add(fechaAlta, gbc_fechaAlta);
		fechaAlta.setColumns(10);
		
		JLabel lblCursos = new JLabel("Cursos :");
		GridBagConstraints gbc_lblCursos = new GridBagConstraints();
		gbc_lblCursos.anchor = GridBagConstraints.EAST;
		gbc_lblCursos.insets = new Insets(0, 0, 5, 5);
		gbc_lblCursos.gridx = 0;
		gbc_lblCursos.gridy = 7;
		getContentPane().add(lblCursos, gbc_lblCursos);
		
		cxCursos = new JComboBox<String>();
		GridBagConstraints gbc_cxCursos = new GridBagConstraints();
		gbc_cxCursos.gridwidth = 4;
		gbc_cxCursos.insets = new Insets(0, 0, 5, 5);
		gbc_cxCursos.fill = GridBagConstraints.HORIZONTAL;
		gbc_cxCursos.gridx = 1;
		gbc_cxCursos.gridy = 7;
		getContentPane().add(cxCursos, gbc_cxCursos);
		
		JButton btnVerMas = new JButton("Ver mas");
		btnVerMas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desplegarDatosVerMas();
				infoCurso.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnVerMas = new GridBagConstraints();
		gbc_btnVerMas.insets = new Insets(0, 0, 5, 0);
		gbc_btnVerMas.gridx = 5;
		gbc_btnVerMas.gridy = 7;
		getContentPane().add(btnVerMas, gbc_btnVerMas);
		
		infoCurso = new ConsultarProgramaDeFormacionInfoCursos();
		infoCurso.setVisible(false);
		
		JButton btnAceptar = new JButton("Cerrar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfaceCurso ICurso=Fabrica.getInstancia().getICurso();
				limpiar();
				ICurso.salir();
				setVisible(false);
			}
		});
		
		JLabel lblCategorias = new JLabel("Categorias:");
		GridBagConstraints gbc_lblCategorias = new GridBagConstraints();
		gbc_lblCategorias.gridwidth = 2;
		gbc_lblCategorias.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategorias.gridx = 0;
		gbc_lblCategorias.gridy = 8;
		getContentPane().add(lblCategorias, gbc_lblCategorias);
		
		cxCategorias = new JComboBox<String>();
		GridBagConstraints gbc_cxCategorias = new GridBagConstraints();
		gbc_cxCategorias.gridwidth = 3;
		gbc_cxCategorias.insets = new Insets(0, 0, 5, 5);
		gbc_cxCategorias.fill = GridBagConstraints.HORIZONTAL;
		gbc_cxCategorias.gridx = 2;
		gbc_cxCategorias.gridy = 8;
		getContentPane().add(cxCategorias, gbc_cxCategorias);
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 0);
		gbc_btnAceptar.gridx = 5;
		gbc_btnAceptar.gridy = 9;
		getContentPane().add(btnAceptar, gbc_btnAceptar);
		GridBagConstraints gbc_infoP = new GridBagConstraints();
        gbc_infoP.gridwidth = 6;
        gbc_infoP.fill = GridBagConstraints.BOTH;
        gbc_infoP.gridx = 0;
        gbc_infoP.gridy = 10;
        getContentPane().add(infoCurso, gbc_infoP);
	}
	public void cargarDatosCDPDF() {
		interfaceCurso ICurso=Fabrica.getInstancia().getICurso();
		Set<String> programas = ICurso.listarProgramas();
		cxProgramas.addItem("NONE");
		for (String iter:programas) {
			cxProgramas.addItem(iter);
		}		
	}
	private void desplegarDatos() {
		interfaceCurso ICurso=Fabrica.getInstancia().getICurso();
		interfaceUsuario IUsuario=Fabrica.getInstancia().getIUsuario();
		String programa = cxProgramas.getSelectedItem().toString();
		if(!(programa.equals("NONE"))) {
			DtInstancia datos = ICurso.verDatosPrograma(programa);
			DtPrograma dat = (DtPrograma)datos;
			textNombre.setText(datos.getNombre());
			textDes.setText(dat.getDescripcion());
			fechaInicio.setText(IUsuario.fechaDecente(datos.getInicio()));
			fechaFin.setText(IUsuario.fechaDecente(datos.getFin()));
			fechaAlta.setText(IUsuario.fechaDecente(dat.getAlta()));
			Set<String> cursos = dat.getCursos();
			cxCursos.removeAllItems();
			cxCursos.addItem("NONE");
			for (String iter:cursos) {
				cxCursos.addItem(iter);
			}
			cxCategorias.removeAllItems();
			cxCategorias.addItem("NONE");
			Set<String> categorias = dat.getCategorias();
			for(String it: categorias) {
				cxCategorias.addItem(it);
			}
		}
		
	}
	private void desplegarDatosVerMas() {
		String selectedCurso = cxCursos.getSelectedItem().toString();
		if(selectedCurso != "NONE") {
			infoCurso.cargarDatosCDPDFI(selectedCurso);
		}
		
	}
	private void limpiar() {
		textNombre.setText("");
		textDes.setText("");
		fechaInicio.setText("");
		fechaFin.setText("");
		fechaAlta.setText("");
		cxProgramas.removeAllItems();
		cxCursos.removeAllItems();
	}

}
