package logica.clases;

import java.util.Calendar;
import logica.datatypes.DtInstancia;
public abstract class Instancia {
	
	private String nombre;
	private Calendar Fechainicio,Fechafin;
	private String foto;
	
	//constructores
	public Instancia(String nom,Calendar inicio,Calendar fin,String foto) {
		this.nombre=nom;
		this.foto = foto;
		this.Fechainicio=inicio;
		this.Fechafin=fin;
	}
	//getters
	public String getNombre() {
			return this.nombre;
		}
	public Calendar getFechaInicio() {
			return this.Fechainicio;
		}
	public Calendar getFechaFin() {
			return this.Fechafin;
		}
	public String getImagen() {
		return this.foto;
	}
	public void setImagen(String img) {
		this.foto =img;
	}

	//funciones

	//Retorna un DtPrograma si es un programa
	//Retorna un DtEdicion si es una edicion
	public abstract DtInstancia darDtInstancia();
		
}
