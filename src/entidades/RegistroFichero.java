package entidades;

import java.util.LinkedList;

/**
 * RegistroFichero
 * 
 * @brief Clase para gestionar cada linea de fichero por los proveedores de datos
 * @author Kr0n0
 */
public class RegistroFichero {
    private final LinkedList<DatoFichero> llLineasDatos;

    // CONSTRUCTOR
    public RegistroFichero() {
        llLineasDatos = new LinkedList<>();
    }
    
    // METODOS PUBLICOS
    /**
     * getLineasDatos
     * 
     * Devuelve las lineas de datos al Proveedor
     * @return 
     */
    public LinkedList<DatoFichero> getLineasDatos() {
        return llLineasDatos;
    }
    
    /**
     * addDato
     * 
     * Añade un dato a la lista de líneas
     * @param dato 
     */
    public void addDato(DatoFichero dato) {
        llLineasDatos.addLast(dato);
    }
    
}
