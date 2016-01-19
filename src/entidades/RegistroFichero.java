/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.nio.file.Files;
import java.util.LinkedList;

/**
 * RegistroFichero
 * 
 * @brief Clase para gestionar cada linea de fichero por los proveedores de datos
 * @author Kr0n0
 */
public class RegistroFichero {
    private final LinkedList<DatoFichero> llLineasDatos;

    /******************************************
    /  Constructor
    *******************************************/
    public RegistroFichero() {
        llLineasDatos = new LinkedList<>();
    }
    
    
    /******************************************
    /  Metodos
    *******************************************/
    
    /**
     * getLineasDatos
     * 
     * @brief Devuelve las lineas de datos al Proveedor
     * @return 
     */
    public LinkedList<DatoFichero> getLineasDatos() {
        return llLineasDatos;
    }
    
    /**
     * addDato
     * 
     * @brief Añade un dato a la lista de líneas
     * @param dato 
     */
    public void addDato(DatoFichero dato) {
        llLineasDatos.addLast(dato);
    }
    
}
