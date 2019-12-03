package presentacion;

import javax.swing.JInternalFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import exception.CategoriaRepetidaExcep;

import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logica.ctrleinterfaces.Fabrica;
import logica.ctrleinterfaces.interfaceCurso;

public class AltaDeCategoria extends JInternalFrame{
	private JTextField textNombre;
	public AltaDeCategoria() {
		setTitle("Alta de Categoria");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{121, 0, 0};
		gridBagLayout.rowHeights = new int[]{80, 0, 55, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNombre = new JLabel("Nombre :");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		getContentPane().add(lblNombre, gbc_lblNombre);
		
		textNombre = new JTextField();
		GridBagConstraints gbc_textNombre = new GridBagConstraints();
		gbc_textNombre.insets = new Insets(0, 0, 5, 0);
		gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNombre.gridx = 1;
		gbc_textNombre.gridy = 0;
		getContentPane().add(textNombre, gbc_textNombre);
		textNombre.setColumns(10);
		
		
		interfaceCurso ICurso = Fabrica.getInstancia().getICurso();
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkAndCreate(e);
				limpiar();
				ICurso.salir();
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.anchor = GridBagConstraints.EAST;
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 0;
		gbc_btnAceptar.gridy = 2;
		getContentPane().add(btnAceptar, gbc_btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				ICurso.salir();
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.gridx = 1;
		gbc_btnCancelar.gridy = 2;
		getContentPane().add(btnCancelar, gbc_btnCancelar);
	}
	private void limpiar() {
		textNombre.setText("");
		setVisible(false);
	}
	private boolean checkSwing() {
        return !(this.textNombre.getText().isEmpty());
    }
	private void checkAndCreate(ActionEvent argo) {
		if(checkSwing()) {
			try {
				interfaceCurso ICurso = Fabrica.getInstancia().getICurso();
				ICurso.altaCategoria(textNombre.getText());
				JOptionPane.showMessageDialog(this, "La categoria se ha creado con exito", "Alta de Categoria",
						JOptionPane.INFORMATION_MESSAGE);
			}catch(CategoriaRepetidaExcep e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Alta de Categoria", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
