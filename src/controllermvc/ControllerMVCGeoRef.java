/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllermvc;

import contenedores.ContenedorClientesSingleton;
import contenedores.ContenedorAlmacenesSingleton;
import contenedores.ContenedorTiendasSingleton;
import entidades.Almacen;
import entidades.Cliente;
import entidades.Tienda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.JMenuItem;
import vistamvc.VentanaAplicacion;
import org.geo.GeoReferenciadorFactory;
import org.geo.IGeoReferenciador;


/**
 *
 * @author Kr0n0
 */
public class ControllerMVCGeoRef implements ActionListener {
    Cliente cliente;
    Almacen almacen;
    Tienda tienda;
    IGeoReferenciador interfazcomp;
    int[] aCoordenadas;
    
    public ControllerMVCGeoRef(VentanaAplicacion ventana) {

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       //1.-Actualiza el modelo en función del evento de entrada
       JMenuItem controlInterfaz = (JMenuItem) e.getSource(); //conversión del evento producido
       
        // Selector dependiendo de opcion de carga
       switch (controlInterfaz.getText()) {
           case "Coordenadas de Clientes" : 
               // Recogemos iterador de la LinkedList de Clientes del Singleton
               Iterator itClientes;
               itClientes = ContenedorClientesSingleton.getInstance().getClientes().iterator();
               // Iteramos en la lista
               while (itClientes.hasNext()) {
                   //Recogemos el objeto Cliente
                   cliente = (Cliente) itClientes.next();
                   //
                   // GEOLIB
                   // Creamos un interfaz GeoReferenciador del Factory
                   // Parámetros - CODPOST, CALLE, PROVINCIA                   
                   interfazcomp = GeoReferenciadorFactory.crear();
                   aCoordenadas = interfazcomp.georeferenciar(cliente.getsCodPost(), cliente.getsCalle(), cliente.getsProvincia());
                   // Establecemos las coordenadas en el cliente
                   cliente.setX(aCoordenadas[0]);
                   cliente.setY(aCoordenadas[1]);
                   System.out.println("\nCliente "+cliente.getsIDCliente()+" ["+cliente.getX()+"]["+cliente.getY()+"]");
               }
               break;
               
           case "Coordenadas de Almacenes" :
               // Recogemos iterador de la LinkedList de Almacenes del Singleton
               Iterator itAlmacenes;
               itAlmacenes = ContenedorAlmacenesSingleton.getInstance().getAlmacenes().iterator();
               // Iteramos en la lista
               while (itAlmacenes.hasNext()) {
                   //Recogemos el objeto Almacen
                   almacen = (Almacen) itAlmacenes.next();
                   //
                   // GEOLIB
                   // Creamos un interfaz GeoReferenciador del Factory  
                   // Parámetros - CODPOST, CALLE, PROVINCIA
                   interfazcomp = GeoReferenciadorFactory.crear();
                   aCoordenadas = interfazcomp.georeferenciar(almacen.getsCodPost(), almacen.getsCalle(), almacen.getsProvincia());
                   // Establecemos las coordenadas en el almacen
                   almacen.setX(aCoordenadas[0]);
                   almacen.setY(aCoordenadas[1]);
                   System.out.println("\nAlmacen"+almacen.getsIDAlmacen()+" ["+almacen.getX()+"]["+almacen.getY()+"]");
               }
               break;
               
           case "Coordenadas de Tiendas" : 
               // Recogemos iterador de la LinkedList de Tiendas del Singleton
               Iterator itTiendas;
               itTiendas = ContenedorTiendasSingleton.getInstance().getTiendas().iterator();
               // Iteramos en la lista
               while (itTiendas.hasNext()) {
                   //Recogemos el objeto Tienda
                   tienda = (Tienda) itTiendas.next();
                   //
                   // GEOLIB
                   // Creamos un interfaz GeoReferenciador del Factory  
                   // Parámetros - CODPOST, CALLE, PROVINCIA
                   interfazcomp = GeoReferenciadorFactory.crear();
                   aCoordenadas = interfazcomp.georeferenciar(tienda.getsCodPost(), tienda.getsCalle(), tienda.getsProvincia());
                   // Establecemos las coordenadas en la tienda
                   tienda.setX(aCoordenadas[0]);
                   tienda.setY(aCoordenadas[1]);
                   System.out.println("\nTienda"+tienda.getsIDTienda()+" ["+tienda.getX()+"]["+tienda.getY()+"]");
               }
               break;
       }
    }
    
}
