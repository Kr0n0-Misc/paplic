/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelomvc;

import contenedores.ContenedorArticulosSingleton;
import entidades.Articulo;
import entidades.DatoFichero;
import entidades.RegistroFichero;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import proveeedores.ProveedorArticulos;
import validacionesdatos.ValidarArticulo;
        
/**
 *
 * @author Kr0n0
 */
public class ControladorCUCargaArticulos {

    // Contenedor
    private final ContenedorArticulosSingleton contenedorArt;    
    ProveedorArticulos proveedor;
    ValidarArticulo validador;
    String ruta_fichero;
    RegistroFichero registro;
    DatoFichero dato;
    LinkedList<RegistroFichero> llRegistro;
    LinkedList<DatoFichero> llDato;
    Articulo articulo;
    Iterator itRegistro;
    Iterator itDato;

    
     /******************************************
    /  Constructor
    *******************************************/
    public ControladorCUCargaArticulos(String ruta) {
        contenedorArt = ContenedorArticulosSingleton.getInstance();
        proveedor = new ProveedorArticulos(ruta);
        validador = new ValidarArticulo();
        ruta_fichero = ruta;
    }
    
    /**
     * 
     * @throws IOException 
     */
    public void CargarArticulos() throws IOException {
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
            // Creamos Articulo nuevo
            articulo = new Articulo();
            while (itDato.hasNext()) {
                // Recogemos el valor del dato con su posicion y valor
                dato = (DatoFichero) itDato.next();
                // Guardamos los valores en la entidad
                articulo.setValoresArticulo(dato.getValor(), dato.getPosicion());
            } //FIN BUCLE DATOS
            
            // VALIDACION DE DATOS
            if (validador.esValido(articulo)) {
                    //Guardamos en el contenedor
                    contenedorArt.addArticulo(articulo);
                    // Mostramos mensaje de almacenar
                    System.out.println("CargarArticulos - "+articulo.getsIDArticulo()+" articulo validado y guardado.");
            }
           
        } // FIN BUCLE REGISTROS
        // Mostramos los datos del contenedor
        contenedorArt.dbgContenedorArticulosSingleton();
    }
}