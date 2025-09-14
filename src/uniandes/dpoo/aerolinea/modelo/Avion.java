package uniandes.dpoo.aerolinea.modelo;

public class Avion {
	private int capacidad;
	private java.lang.String nombre;
	
	public Avion(java.lang.String nombre, int capacidad) {
		this.nombre = nombre;
		this.capacidad = capacidad;
	}
	
	public java.lang.String getNombre(){
		return nombre;	
	}
	public int getCapacidad() {
		return capacidad;
	}
	
}


