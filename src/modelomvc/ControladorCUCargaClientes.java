/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelomvc;

import contenedores.ContenedorClientesSingleton;
import validacionesdatos.ValidarCliente;

/**
 *
 * @author Kr0n0
 */
public class ControladorCUCargaClientes {
    
    
    // Contenedor
    private final ContenedorClientesSingleton contenedorCli;    
    
     /******************************************
    /  Constructor
    *******************************************/
    public ControladorCUCargaClientes(String ruta) {
        contenedorCli = ContenedorClientesSingleton.getInstance();
        System.out.println("modelomvc.ControladorCUCargaClientes.<init>()");
        
    }
    
}
