/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelomvc;

import contenedores.ContenedorVentasSingleton;
import validacionesdatos.ValidarVenta;

/**
 *
 * @author Kr0n0
 */
public class ControladorCUCargaVentas {
    
    
    // Contenedor
    private final ContenedorVentasSingleton contenedorVen;    
    
     /******************************************
    /  Constructor
    *******************************************/
    public ControladorCUCargaVentas(String ruta) {
        contenedorVen = ContenedorVentasSingleton.getInstance();
        System.out.println("modelomvc.ControladorCUCargaVentas.<init>()");
    }
    
}
