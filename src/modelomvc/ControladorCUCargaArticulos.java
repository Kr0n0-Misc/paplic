/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelomvc;

import contenedores.ContenedorArticulosSingleton;
import validacionesdatos.ValidarArticulo;

/**
 *
 * @author Kr0n0
 */
public class ControladorCUCargaArticulos {
    
    
    // Contenedor
    private final ContenedorArticulosSingleton contenedorArt;    
    
    /******************************************
    /  Constructor
    *******************************************/
    public ControladorCUCargaArticulos(String ruta) {
        contenedorArt = ContenedorArticulosSingleton.getInstance();
        System.out.println("modelomvc.ControladorCUCargaArticulos.<init>()");
        
    }
    
}
