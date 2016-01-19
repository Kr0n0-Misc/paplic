/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelomvc;

import contenedores.ContenedorTiendasSingleton;
import entidades.Tienda;
import entidades.DatoFichero;
import entidades.RegistroFichero;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import proveeedores.ProveedorTiendas;
import validacionesdatos.ValidarTienda;
        
/**
 *
 * @author Kr0n0
 */
public class ControladorCUCargaTiendas {

    // Contenedor
    private final ContenedorTiendasSingleton contenedorTie;    
    ProveedorTiendas proveedor;
    ValidarTienda validador;
    String ruta_fichero;
    RegistroFichero registro;
    DatoFichero dato;
    LinkedList<RegistroFichero> llRegistro;
    LinkedList<DatoFichero> llDato;
    Tienda tienda;
    Iterator itRegistro;
    Iterator itDato;

    
     /******************************************
    /  Constructor
    *******************************************/
    public ControladorCUCargaTiendas(String ruta) {
        contenedorTie = ContenedorTiendasSingleton.getInstance();
        proveedor = new ProveedorTiendas(ruta);
        validador = new ValidarTienda();
        ruta_fichero = ruta;
    }
    
    /**
     * 
     * @throws IOException 
     */
    public void CargarTiendas() throws IOException {
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
            // Creamos Tienda nueva
            tienda = new Tienda();
            while (itDato.hasNext()) {
                // Recogemos el valor del dato con su posicion y valor
                dato = (DatoFichero) itDato.next();
                // Guardamos los valores en la entidad
                tienda.setValoresTienda(dato.getValor(), dato.getPosicion());
            } //FIN BUCLE DATOS
            
            // VALIDACION DE DATOS
            if (validador.esValido(tienda)) {
                    //Guardamos en el contenedor
                    contenedorTie.addTienda(tienda);
                    // Mostramos mensaje de almacenar
                    System.out.println("CargarTiendas - " + tienda.getsIDTienda() + " tienda validada y guardada.");
            }
           
        } // FIN BUCLE REGISTROS
        // Mostramos los datos del contenedor
        contenedorTie.dbgContenedorTiendasSingleton();
    }
}