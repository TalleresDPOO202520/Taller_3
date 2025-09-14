package uniandes.dpoo.aerolinea.modelo;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.Collections;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.GeneradorTiquetes;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;
import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;


public class Vuelo{
	private Avion avion;
	private String fecha;
	private Ruta ruta;
	private Map<String, Tiquete> tiquetes;


	public Vuelo(Ruta ruta, java.lang.String fecha, Avion avion){
		this.ruta = ruta;
        this.fecha = fecha;
        this.avion = avion;
        this.tiquetes = new HashMap<>();
	}

	public Ruta getRuta() {
		return ruta;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public Avion getAvion() {
		return avion;
	}
	
	public Collection<Tiquete> getTiquetes(){
		return tiquetes.values();
	}
		
	
	public int venderTiquetes​(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) throws VueloSobrevendidoException{
		int capacidad = avion.getCapacidad();
		int vendidos = tiquetes.size();
		int disponibles = capacidad - vendidos;
	
		if (cantidad > disponibles){
		    throw new VueloSobrevendidoException(this);
		}
		
		int total = 0;
		for (int i = 0; i < cantidad; i++) {
			int tarifa = calculadora.calcularTarifa(this, cliente);
			Tiquete tiquete = GeneradorTiquetes.generarTiquete(this, cliente, tarifa);
	
			tiquetes.put(tiquete.getCodigo(), tiquete);
		
			total += tarifa;
		}
        return total;
	}

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) return true;
        if (!(objeto instanceof Vuelo)) return false;
        Vuelo other = (Vuelo) objeto;
        return ruta.equals(other.ruta) && fecha.equals(other.fecha);
    }


}

