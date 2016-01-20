package controllermvc;

// Swing, AWT y vistas
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import vistamvc.VentanaAplicacion;
import vistamvc.PanelGraficoMapa;
// Modelos
import modelomvc.MapaVectorialAlmacenes;
// Contenedores de Entidades - Singleton
import contenedores.ContenedorAlmacenesSingleton;
// Entidades
import entidades.Almacen;
// Utilidades
import java.util.Iterator;

/**
 * ControllerMVCMapaAlmacenes
 * 
 * Controlador MVC para crear el Mapa de Almacenes
 * 
 * @author Kr0n0
 */
public class ControllerMVCMapaAlmacenes implements ActionListener {
    //asociacion con la vista
    VentanaAplicacion vistaMapa;
    //asociacion con el modelo
    MapaVectorialAlmacenes mapaalmacenes;
    ContenedorAlmacenesSingleton contenedorAlm;
    // Entidades
    Almacen almacen;

    // CONSTRUCTOR
    public ControllerMVCMapaAlmacenes(VentanaAplicacion ventana) {
        //incializacion
        this.vistaMapa = ventana;
        mapaalmacenes = new MapaVectorialAlmacenes();
        contenedorAlm=ContenedorAlmacenesSingleton.getInstance();
    }

    // actionPerformed - Click en opcion de menu
    @Override
    public void actionPerformed(ActionEvent e) {
        //1.-Actualiza el modelo en función del evento de entrada    
        JMenuItem controlInterfaz = (JMenuItem) e.getSource(); //conversión del evento producido
        if (controlInterfaz.getText().equals("Generar Mapa de Almacenes")) {
            Iterator itAlmacenes;
            itAlmacenes = ContenedorAlmacenesSingleton.getInstance().getAlmacenes().iterator();
            // Iteramos en la lista
            while (itAlmacenes.hasNext()) {
            //Recogemos el objeto Cliente
            almacen = (Almacen) itAlmacenes.next();
            mapaalmacenes.representar(almacen);
            //2.-Procesar y confifurar el mapa con la colección de figuras geometricas
            mapaalmacenes.generarGrafico(); //Generar el mapa
            //3.-seleccionar la vista y configurar para mostrar nuevo estado del modelo 
            PanelGraficoMapa panel_graficoMapaAlmacenes = new PanelGraficoMapa(mapaalmacenes);            
            this.vistaMapa.setPanel(panel_graficoMapaAlmacenes);
          }
        }
    }

}
