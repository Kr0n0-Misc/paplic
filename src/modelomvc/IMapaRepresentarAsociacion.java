/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelomvc;

import entidades.EntidadGeo;


public interface IMapaRepresentarAsociacion {
    // Añadimos método representar basado en el de entidad pero con dos parametros
    
    public boolean representar (EntidadGeo entidad, EntidadGeo entidad2);
}
