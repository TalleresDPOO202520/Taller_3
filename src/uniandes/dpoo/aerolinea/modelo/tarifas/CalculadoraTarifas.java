package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class CalculadoraTarifas {
    public static final double IMPUESTO = 0.28;

    public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
        int costo_base = calcularCostoBase(vuelo, cliente);

        double porcentaje_descuento = calcularPorcentajeDescuento(cliente); 
        int descuento = (int) Math.round(costo_base * porcentaje_descuento);

        int gravable  = costo_base - descuento;
        int impuestos = calcularValorImpuestos(gravable);

        return costo_base - descuento + impuestos;	
    }

    protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);
    
    protected abstract double calcularPorcentajeDescuento(Cliente cliente);

    protected int calcularDistanciaVuelo(Ruta ruta) {
        Aeropuerto origen  = ruta.getOrigen();
        Aeropuerto destino = ruta.getDestino();
        return Aeropuerto.calcularDistancia(origen, destino); 
    }

    protected int calcularValorImpuestos(int costo_base) {
        return (int) Math.round(costo_base * IMPUESTO);
    }
}
