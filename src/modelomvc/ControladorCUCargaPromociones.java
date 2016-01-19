/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelomvc;

import contenedores.ContenedorPromocionesSingleton;
import entidades.Promocion;
import entidades.DatoFichero;
import entidades.RegistroFichero;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import proveeedores.ProveedorPromociones;
import validacionesdatos.ValidarPromocion;
        
/**
 *
 * @author Kr0n0
 */
public class ControladorCUCargaPromociones {

    // Contenedor
    private final ContenedorPromocionesSingleton contenedorPro;    
    ProveedorPromociones proveedor;
    ValidarPromocion validador;
    String ruta_fichero;
    RegistroFichero registro;
    DatoFichero dato;
    LinkedList<RegistroFichero> llRegistro;
    LinkedList<DatoFichero> llDato;
    Promocion promocion;
    Iterator itRegistro;
    Iterator itDato;

    
     /******************************************
    /  Constructor
    *******************************************/
    public ControladorCUCargaPromociones(String ruta) {
        contenedorPro = ContenedorPromocionesSingleton.getInstance();
        proveedor = new ProveedorPromociones(ruta);
        validador = new ValidarPromocion();
        ruta_fichero = ruta;
    }
    
    /**
     * 
     * @throws IOException 
     */
    public void CargarPromociones() throws IOException {
        // Leemos los registros usando el proveedor de datos y lo volcamos al LinkedList
        llRegistro = proveedor.LeerRegistros(ruta_fichero);
        // Asignamos el iterador al LinkedList de registros
        itRegistro = llRegistro.iterator();
        // Mientras que haya Registros en la lista
        while (itRegistro.hasNext()) {
            // Leemos el registro
            registro = (RegistroFichero) itRegistro.next();
            // Leemos las lineas de Datos del registro
            llDato = registro.getLineasDatos();
            // Asignamos el iterador al LinkedList de datos
            itDato = llDato.iterator();
            // Creamos Cliente nuevo
            promocion = new Promocion();
            while (itDato.hasNext()) {
                // Recogemos el valor del dato con su posicion y valor
                dato = (DatoFichero) itDato.next();
                // Guardamos los valores en la entidad
                promocion.setValoresPromocion(dato.getValor(), dato.getPosicion());
            } //FIN BUCLE DATOS
            
            // VALIDACION DE DATOS
            if (validador.esValido(promocion)) {
                    //Guardamos en el contenedor
                    contenedorPro.addPromocion(promocion);
                    // Mostramos mensaje de almacenar
                    System.out.println("CargarPromociones - "+promocion.getsIDPromocion()+" promocion validada y guardada.");
            }
           
        } // FIN BUCLE REGISTROS
        // Mostramos los datos del contenedor
        contenedorPro.dbgContenedorPromocionesSingleton();
    }
}