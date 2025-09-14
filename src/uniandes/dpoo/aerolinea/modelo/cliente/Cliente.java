package uniandes.dpoo.aerolinea.modelo.cliente;


import java.util.Map;
import java.util.HashMap;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;
import uniandes.dpoo.aerolinea.modelo.Vuelo;

public abstract class Cliente {
	
	protected Map<String, Tiquete> tiquetes = new HashMap<>();

	public abstract String getTipoCliente();
	
	public abstract String getIdentificador();
	
	public void agregarTiquete(Tiquete t){
	    tiquetes.put(t.getCodigo(), t);
	}

	public int calcularValorTotalTiquetes(){
		int total = 0;
		for (Tiquete t: tiquetes.values()){
			total += t.getTarifa();
		}
	return total;}
	
    public void usarTiquetes(Vuelo vuelo){
    	for (Tiquete t: tiquetes.values()){
        if (t.getVuelo() == vuelo){
        t.marcarComoUsado();
        				}
                }
        }
}