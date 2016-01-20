package controllermvc;

// Swing, AWT y vistas
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import vistamvc.VentanaAplicacion;
import vistamvc.PanelGraficoMapa;
// Modelos
import modelomvc.MapaVectorialClientes;
// Contenedores de Entidades - Singleton
import contenedores.ContenedorClientesSingleton;
// Entidades
import entidades.Cliente;
// Utilidades
import java.util.Iterator;

/**
 * ControllerMVCMapaClientes
 * 
 * Controlador MVC para crear el Mapa de Clientes
 * 
 * @author Kr0n0
 */
public class ControllerMVCMapaClientes implements ActionListener {
    //asociacion con la vista
    VentanaAplicacion vistaMapa;
    //asociacion con el modelo
    MapaVectorialClientes mapaclientes;
    ContenedorClientesSingleton contenedorCli;
    // Entidades
    Cliente cliente;

    // CONSTRUCTOR
    public ControllerMVCMapaClientes(VentanaAplicacion ventana) {
        //incializacion
        this.vistaMapa = ventana;
        mapaclientes = new MapaVectorialClientes();
        contenedorCli=ContenedorClientesSingleton.getInstance();
    }

    // actionPerformed - Click en opcion de menu
    @Override
    public void actionPerformed(ActionEvent e) {
        //1.-Actualiza el modelo en función del evento de entrada    
        JMenuItem controlInterfaz = (JMenuItem) e.getSource(); //conversión del evento producido
        if (controlInterfaz.getText().equals("Generar Mapa de Clientes")) {
            Iterator itClientes;
            itClientes = ContenedorClientesSingleton.getInstance().getClientes().iterator();
            // Iteramos en la lista
            while (itClientes.hasNext()) {
            //Recogemos el objeto Cliente
            cliente = (Cliente) itClientes.next();
            mapaclientes.representar(cliente);
            //2.-Procesar y confifurar el mapa con la colección de figuras geometricas
            mapaclientes.generarGrafico(); //Generar el mapa
            //3.-seleccionar la vista y configurar para mostrar nuevo estado del modelo 
            PanelGraficoMapa panel_graficoMapaClientes = new PanelGraficoMapa(mapaclientes);            
            this.vistaMapa.setPanel(panel_graficoMapaClientes);
          }
    }
    }

}
