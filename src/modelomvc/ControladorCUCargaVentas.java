/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelomvc;

import contenedores.ContenedorVentasSingleton;
import entidades.Venta;
import entidades.DatoFichero;
import entidades.RegistroFichero;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import proveeedores.ProveedorVentas;
import validacionesdatos.ValidarVenta;
        
/**
 *
 * @author Kr0n0
 */
public class ControladorCUCargaVentas {

    // Contenedor
    private final ContenedorVentasSingleton contenedorVen;    
    ProveedorVentas proveedor;
    ValidarVenta validador;
    String ruta_fichero;
    RegistroFichero registro;
    DatoFichero dato;
    LinkedList<RegistroFichero> llRegistro;
    LinkedList<DatoFichero> llDato;
    Venta venta;
    Iterator itRegistro;
    Iterator itDato;

    
     /******************************************
    /  Constructor
    *******************************************/
    public ControladorCUCargaVentas(String ruta) {
        contenedorVen = ContenedorVentasSingleton.getInstance();
        proveedor = new ProveedorVentas(ruta);
        validador = new ValidarVenta();
        ruta_fichero = ruta;
    }
    
    /**
     * 
     * @throws IOException 
     */
    public void CargarVentas() throws IOException {
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
            venta = new Venta();
            while (itDato.hasNext()) {
                // Recogemos el valor del dato con su posicion y valor
                dato = (DatoFichero) itDato.next();
                // Guardamos los valores en la entidad
                venta.setValoresVenta(dato.getValor(), dato.getPosicion());
            } //FIN BUCLE DATOS
            
            // VALIDACION DE DATOS
            if (validador.esValido(venta)) {
                    //Guardamos en el contenedor
                    contenedorVen.addVenta(venta);
                    // Mostramos mensaje de almacenar
                    System.out.println("CargarVentas - "+venta.getsIDVenta()+" venta validada y guardada.");
            }
           
        } // FIN BUCLE REGISTROS
        // Mostramos los datos del contenedor
        contenedorVen.dbgContenedorVentasSingleton();
    }
}