/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllermvc;

import contenedores.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
//import modelomvc.MapaVectorialClientes;
import vistamvc.VentanaAplicacion;
//import vistamvc.PanelGraficoMapa;


public class ControllerMVCCargaDatos implements ActionListener {
    
    /*
    //asociacion con la vista
    VentanaAplicacion vistaMapa;
    //asociacion con el modelo
    MapaVectorialClientes mapaclientes;
    */

    
    // Contenedores
    ContenedorAlmacenesSingleton contenedorAlm;
    ContenedorArticulosSingleton contenedorArt;
    ContenedorClientesSingleton contenedorCli;
    ContenedorTiendasSingleton contenedorTie;
    ContenedorVentasSingleton contenedorVen;
    ContenedorPromocionesSingleton contenedorPro;

    public ControllerMVCCargaDatos(VentanaAplicacion ventana) {
      //TODO   
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //1.-Actualiza el modelo en función del evento de entrada
       JMenuItem controlInterfaz = (JMenuItem) e.getSource(); //conversión del evento producido
        
       // Selector dependiendo de opcion de carga
       switch (controlInterfaz.getText()) {
           case "Carga fichero Almacenes" : 
               // CARGA FICHERO ALMACENES
               // Recogemos la instancia del singleton correspondiente
               contenedorAlm=ContenedorAlmacenesSingleton.getInstance();
               System.out.println("[ControllerMVCCargaDatos] - Carga de fichero Almacenes");
               
               break;
           case "Carga fichero Articulos" :
               // CARGA FICHERO ARTICULOS
               // Recogemos la instancia del singleton correspondiente
               contenedorArt=ContenedorArticulosSingleton.getInstance();
               System.out.println("[ControllerMVCCargaDatos] - Carga de fichero Articulos");
               
               break;
           case "Carga fichero Clientes" :
               // CARGA FICHERO CLIENTES
               // Recogemos la instancia del singleton correspondiente
               contenedorCli=ContenedorClientesSingleton.getInstance();
               System.out.println("[ControllerMVCCargaDatos] - Carga de fichero Clientes");
               
               break;
           case "Carga fichero Tiendas" :
               // CARGA FICHERO TIENDAS
               // Recogemos la instancia del singleton correspondiente
               contenedorTie=ContenedorTiendasSingleton.getInstance();
               System.out.println("[ControllerMVCCargaDatos] - Carga de fichero Tiendas");
               
               break;
           case "Carga fichero Ventas" :
               // CARGA FICHERO VENTAS
               // Recogemos la instancia del singleton correspondiente
               contenedorVen=ContenedorVentasSingleton.getInstance();
               System.out.println("[ControllerMVCCargaDatos] - Carga de fichero Ventas");
               
               break;
           case "Carga fichero Promociones" :
               // CARGA FICHERO PROMOCIONES
               // Recogemos la instancia del singleton correspondiente
               contenedorPro=ContenedorPromocionesSingleton.getInstance();
               System.out.println("[ControllerMVCCargaDatos] - Carga de fichero Promociones");
           
               break;
       }
       
    }
}
