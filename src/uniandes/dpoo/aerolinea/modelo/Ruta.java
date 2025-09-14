package uniandes.dpoo.aerolinea.modelo;

/**
 * Esta clase tiene la información de una ruta entre dos aeropuertos que cubre una aerolínea.
 */
public class Ruta{
	private java.lang.String codigoRuta;
	private Aeropuerto destino;
	private java.lang.String horaLlegada;
	private java.lang.String horaSalida;
	private Aeropuerto origen;
	
	public Ruta(Aeropuerto origen, Aeropuerto destino, java.lang.String horaSalida, java.lang.String horaLlegada, java.lang.String codigoRuta) {
		this.origen = origen;
		this.destino = destino;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.codigoRuta = codigoRuta;
	}
	
	public java.lang.String getCodigoRuta(){
		return codigoRuta;
	}
	
	public Aeropuerto getOrigen() {
		return origen;
	}
	
	public Aeropuerto getDestino() {
		return destino;
	}
	
	public java.lang.String getHoraSalida(){
		return horaSalida;
	}
	
	public java.lang.String getHoraLlegada(){
		return horaLlegada;
	}
	
	public int getDuracion() {
		int salida = getHoras(this.horaSalida) * 60 + getMinutos(this.horaSalida);
        int llegada = getHoras(this.horaLlegada) * 60 + getMinutos(this.horaLlegada);
        int duracion = llegada - salida;
        if (duracion < 0){
        	duracion += 24 * 60;
        }
        return duracion;
	}
		
    /**
     * Dada una cadena con una hora y minutos, retorna los minutos.
     * 
     * Por ejemplo, para la cadena '715' retorna 15.
     * @param horaCompleta Una cadena con una hora, donde los minutos siempre ocupan los dos últimos caracteres
     * @return Una cantidad de minutos entre 0 y 59
     */
    public static int getMinutos( String horaCompleta )
    {
        int minutos = Integer.parseInt( horaCompleta ) % 100;
        return minutos;
    }

    /**
     * Dada una cadena con una hora y minutos, retorna las horas.
     * 
     * Por ejemplo, para la cadena '715' retorna 7.
     * @param horaCompleta Una cadena con una hora, donde los minutos siempre ocupan los dos últimos caracteres
     * @return Una cantidad de horas entre 0 y 23
     */
    public static int getHoras( String horaCompleta )
    {
        int horas = Integer.parseInt( horaCompleta ) / 100;
        return horas;
    }

    
}
