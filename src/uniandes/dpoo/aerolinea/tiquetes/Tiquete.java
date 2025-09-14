package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.modelo.*;
import uniandes.dpoo.aerolinea.modelo.cliente.*;

public class Tiquete {
	
	private Cliente cliente;
	private String codigo;
	private int tarifa;
	private boolean usado;
    private Vuelo vuelo;
    
    

	public Tiquete(String codigo, Vuelo vuelo, Cliente clienteComprador, int tarifa) {
		this.cliente = clienteComprador;
		this.codigo = codigo;
		this.tarifa = tarifa;
		this.usado = false;
		this.vuelo = vuelo;
	}
	
	public Cliente getCliente(){
		return cliente;
	}
	
	public Vuelo getVuelo(){
		return vuelo;
	}
	
	public String getCodigo(){
		return codigo;
	}
	
	public int getTarifa(){
		return tarifa;
	}
	

    public void marcarComoUsado(){
    	this.usado = true;
    }
	
	public boolean esUsado(){
		return usado;
	}
	
}
