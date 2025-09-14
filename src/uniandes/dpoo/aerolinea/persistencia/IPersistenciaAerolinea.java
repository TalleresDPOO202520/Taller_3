package uniandes.dpoo.aerolinea.persistencia;

import java.io.IOException;

import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteException;
import uniandes.dpoo.aerolinea.modelo.Aerolinea;

/**
 * Define las operaciones básicas para cargar y salvar una aerolínea.
 */
public interface IPersistenciaAerolinea {
    void cargarAerolinea(String archivo, Aerolinea aerolinea) throws IOException, InformacionInconsistenteException;

    void salvarAerolinea(String archivo, Aerolinea aerolinea) throws IOException;
}