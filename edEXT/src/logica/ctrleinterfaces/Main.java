package logica.ctrleinterfaces;
import java.awt.EventQueue;

import presentacion.mainMenu;
import publicador.Publicador;




public class Main {

	public static void main(String[] args) {
		Publicador publicador = new Publicador();
		publicador.publicar();
		System.out.println("FINISHED PUBLICADOR");
		
		
		/**
		* Launch the application.
		*/
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainMenu frame = new mainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		System.out.println("FINISHED");
		

	}
}
