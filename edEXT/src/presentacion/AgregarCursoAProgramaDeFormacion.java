package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.util.Set;

import javax.swing.JButton;

import logica.ctrleinterfaces.Fabrica;
import logica.ctrleinterfaces.interfaceCurso;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarCursoAProgramaDeFormacion extends JInternalFrame{
	private JComboBox<String> cxProgramas;
	private JComboBox<String> cxCursos;
	
	public AgregarCursoAProgramaDeFormacion() {
		setTitle("Agregar Curso a Programa de Formacion");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{135, 207, 0, 0};
		gridBagLayout.rowHeights = new int[]{60, 62, 68, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblProgramaDeFormacion = new JLabel("Programas de Formacion :");
		GridBagConstraints gbc_lblProgramaDeFormacion = new GridBagConstraints();
		gbc_lblProgramaDeFormacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblProgramaDeFormacion.gridx = 0;
		gbc_lblProgramaDeFormacion.gridy = 0;
		getContentPane().add(lblProgramaDeFormacion, gbc_lblProgramaDeFormacion);
		
		cxProgramas = new JComboBox<String>();
		GridBagConstraints gbc_cxProgramas = new GridBagConstraints();
		gbc_cxProgramas.insets = new Insets(0, 0, 5, 5);
		gbc_cxProgramas.fill = GridBagConstraints.HORIZONTAL;
		gbc_cxProgramas.gridx = 1;
		gbc_cxProgramas.gridy = 0;
		getContentPane().add(cxProgramas, gbc_cxProgramas);
		
		JButton btnNewButton = new JButton("Elegir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mandarCursosDePrograma();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 0;
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblCursos = new JLabel("Cursos :");
		GridBagConstraints gbc_lblCursos = new GridBagConstraints();
		gbc_lblCursos.insets = new Insets(0, 0, 5, 5);
		gbc_lblCursos.gridx = 0;
		gbc_lblCursos.gridy = 1;
		getContentPane().add(lblCursos, gbc_lblCursos);
		
		cxCursos = new JComboBox<String>();
		GridBagConstraints gbc_cxCursos = new GridBagConstraints();
		gbc_cxCursos.insets = new Insets(0, 0, 5, 5);
		gbc_cxCursos.fill = GridBagConstraints.HORIZONTAL;
		gbc_cxCursos.gridx = 1;
		gbc_cxCursos.gridy = 1;
		getContentPane().add(cxCursos, gbc_cxCursos);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aceptar();
			}
		});
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.anchor = GridBagConstraints.EAST;
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 1;
		gbc_btnAceptar.gridy = 2;
		getContentPane().add(btnAceptar, gbc_btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.gridx = 2;
		gbc_btnCancelar.gridy = 2;
		getContentPane().add(btnCancelar, gbc_btnCancelar);
	}
	public void cargarDatosACAPDF() {
		interfaceCurso ICurso=Fabrica.getInstancia().getICurso();
		Set<String> programas = ICurso.listarProgramas();
		cxProgramas.addItem("NONE");
		for (String iter:programas) {
			cxProgramas.addItem(iter);
		}
	}
	private void mandarCursosDePrograma(){
		if(!cxProgramas.getSelectedItem().toString().equals("NONE")){
			interfaceCurso ICurso=Fabrica.getInstancia().getICurso();
			ICurso.seleccionarPrograma(cxProgramas.getSelectedItem().toString());
			Set<String> cursos = ICurso.listarCursosExistente();
			cxCursos.addItem("NONE");
			for (String iter:cursos) {
				cxCursos.addItem(iter);
			}
		}else {
			JOptionPane.showMessageDialog(this, "Elija un programa", "Agregar curso a programa",
                    JOptionPane.ERROR_MESSAGE);
		}
	}
	private void aceptar() {
		if(!cxCursos.getSelectedItem().toString().equals("NONE") && !cxProgramas.getSelectedItem().toString().equals("NONE")) {
			interfaceCurso ICurso=Fabrica.getInstancia().getICurso();
			ICurso.seleccionarCurso(cxCursos.getSelectedItem().toString());
			ICurso.aceptarAgregarCursoAPrograma();
			limpiar();
			ICurso.salir();
			setVisible(false);
		}else {
			JOptionPane.showMessageDialog(this, "Elija un curso", "Agregar curso a programa",
                    JOptionPane.ERROR_MESSAGE);
		}
	}
	private void limpiar() {
		cxProgramas.removeAllItems();
		cxCursos.removeAllItems();
	}

}
