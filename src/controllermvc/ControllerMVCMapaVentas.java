package controllermvc;

// Swing, AWT y vistas
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import vistamvc.VentanaAplicacion;
import vistamvc.PanelGraficoMapa;
// Modelos
import modelomvc.MapaVectorialVentas;
// Contenedores de Entidades - Singleton
import contenedores.ContenedorVentasSingleton;
// Entidades
import entidades.Venta;
// Utilidades
import java.util.Iterator;

/**
 * ControllerMVCMapaVentas
 * 
 * Controlador MVC para crear el Mapa de Ventas
 * 
 * @author Kr0n0
 */
public class ControllerMVCMapaVentas implements ActionListener {
    //asociacion con la vista
    VentanaAplicacion vistaMapa;
    //asociacion con el modelo
    MapaVectorialVentas mapaventas;
    ContenedorVentasSingleton contenedorVen;
    // Entidades
    Venta venta;

    // CONSTRUCTOR
    public ControllerMVCMapaVentas(VentanaAplicacion ventana) {
        //incializacion
        this.vistaMapa = ventana;
        mapaventas = new MapaVectorialVentas();
        contenedorVen=ContenedorVentasSingleton.getInstance();
    }

    // actionPerformed - Click en opcion de menu
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
