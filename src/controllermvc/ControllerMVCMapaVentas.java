/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllermvc;

import contenedores.ContenedorVentasSingleton;
import entidades.Venta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.JMenuItem;
import modelomvc.MapaVectorialVentas;
import vistamvc.VentanaAplicacion;
import vistamvc.PanelGraficoMapa;


public class ControllerMVCMapaVentas implements ActionListener {
    //asociacion con la vista
    VentanaAplicacion vistaMapa;
    //asociacion con el modelo
    MapaVectorialVentas mapaventas;
    ContenedorVentasSingleton contenedorVen;
    // Entidades
    Venta venta;

    public ControllerMVCMapaVentas(VentanaAplicacion ventana) {
        //incializacion
        this.vistaMapa = ventana;
        mapaventas = new MapaVectorialVentas();
        contenedorVen=ContenedorVentasSingleton.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //1.-Actualiza el modelo en función del evento de entrada    
        JMenuItem controlInterfaz = (JMenuItem) e.getSource(); //conversión del evento producido
        if (controlInterfaz.getText().equals("Generar Mapa de Ventas")) {
            Iterator itVentas;
            itVentas = ContenedorVentasSingleton.getInstance().getVentas().iterator();
            // Iteramos en la lista
            while (itVentas.hasNext()) {
            //Recogemos el objeto Venta
            venta = (Venta) itVentas.next();
            // Representamos usando el mapa de ventas con dos parámetros : cliente y tienda          
            mapaventas.representar(venta.getcCliente(), venta.gettTienda());
            //2.-Procesar y confifurar el mapa con la colección de figuras geometricas
            mapaventas.generarGrafico(); //Generar el mapa
            
            //3.-seleccionar la vista y configurar para mostrar nuevo estado del modelo 
            PanelGraficoMapa panel_graficoMapaVentas = new PanelGraficoMapa(mapaventas);            
            this.vistaMapa.setPanel(panel_graficoMapaVentas);
          }
    }
    }

}
