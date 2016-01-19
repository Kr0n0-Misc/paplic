/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelomvc;

import contenedores.ContenedorTiendasSingleton;
import validacionesdatos.ValidarTienda;

/**
 *
 * @author Kr0n0
 */
public class ControladorCUCargaTiendas {
    
    
    // Contenedor
    private final ContenedorTiendasSingleton contenedorTie;    
    
     /******************************************
    /  Constructor
    *******************************************/
    public ControladorCUCargaTiendas(String ruta) {
        contenedorTie = ContenedorTiendasSingleton.getInstance();
        System.out.println("modelomvc.ControladorCUCargaTiendas.<init>()");
    }
    
}
