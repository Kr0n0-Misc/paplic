/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelomvc;
import contenedores.ContenedorClientesSingleton;

public class ControladorServicioCUGenerarMapaClientes {
   
    public boolean desarrollarServicio( MapaVectorialClientes mapa){
       //Acceder a cvontendores
        ContenedorClientesSingleton contenedor= ContenedorClientesSingleton.getInstance();
        // 
       // pintar el mapa
        mapa.representar(null);
    return true;
    }
}
