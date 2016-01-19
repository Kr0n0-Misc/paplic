/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelomvc;

import contenedores.ContenedorPromocionesSingleton;
import validacionesdatos.ValidarPromocion;

/**
 *
 * @author Kr0n0
 */
public class ControladorCUCargaPromociones {
    
    
    // Contenedor
    private final ContenedorPromocionesSingleton contenedorPro;    
    
     /******************************************
    /  Constructor
    *******************************************/
    public ControladorCUCargaPromociones(String ruta) {
        contenedorPro = ContenedorPromocionesSingleton.getInstance();
        System.out.println("modelomvc.ControladorCUCargaPromociones.<init>()");
    }
    
}
