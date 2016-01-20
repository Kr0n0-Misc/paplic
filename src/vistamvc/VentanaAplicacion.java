package vistamvc;

// Controladores MVC
import controllermvc.*;
// Swing, AWT y Vistas
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import vistamvc.PanelGraficoMapa;
/* NO SE USA
import javax.swing.JPanel;
*/

public class VentanaAplicacion extends JFrame {

    PanelGraficoMapa vista;// variable de estado de representación del mapa

    public VentanaAplicacion() {
        
        JMenuBar barraMenus = new JMenuBar();// control barra de menú superior
        // Creamos Controles de menus
        JMenu menuCargas = crearControlMenuCargas();
        JMenu menuGeoref = crearControlMenuGeoref();
        JMenu menuMapas = creaControlMenuMapas();

        // Añadimos los controles al menu
        barraMenus.add(menuCargas);
        barraMenus.add(menuGeoref);
        barraMenus.add(menuMapas);
        
        // Atributos de ventana
        this.setTitle("Cuadro de mando");
        this.setSize(1200, 800); //tamaño de la ventana
        this.setBackground(Color.WHITE); // color de fondo
        this.setLocationRelativeTo(null); // Centrada
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setJMenuBar(barraMenus);// asignar barra a control JFrame
        this.setVisible(true);// hacer visible la interfaz de ususario
    }

    /**
     * crearControlMenuCargas
     * 
     * Crea el menu de opciones para archivos de carga
     * @return JMenu
     */
    private JMenu crearControlMenuCargas() {
        // Opciones del menu de cargas
        JMenuItem itemAlmacen = new JMenuItem("Carga fichero Almacenes");
        JMenuItem itemArticulo = new JMenuItem("Carga fichero Articulos");
        JMenuItem itemCliente = new JMenuItem("Carga fichero Clientes");
        JMenuItem itemTienda = new JMenuItem("Carga fichero Tiendas");
        JMenuItem itemVenta = new JMenuItem("Carga fichero Ventas");
        JMenuItem itemPromocion = new JMenuItem("Carga fichero Promociones");
        // Titulo de Menu
        JMenu menu = new JMenu("Opciones de Carga");
        // Añadimos las opciones al menu
        menu.add(itemAlmacen);
        menu.add(itemArticulo);
        menu.add(itemCliente);
        menu.add(itemTienda);
        menu.add(itemVenta);
        menu.add(itemPromocion);
        // Enganchamos los ActionListener para cada una de las opciones de carga
        // NOTA : Usamos un único ContollerMVC y dependiendo del texto cargamos 
        // un archivo u otro en el Controller
        itemAlmacen.addActionListener(new ControllerMVCCargaDatos(this));
        itemArticulo.addActionListener(new ControllerMVCCargaDatos(this));
        itemCliente.addActionListener(new ControllerMVCCargaDatos(this));
        itemTienda.addActionListener(new ControllerMVCCargaDatos(this));
        itemVenta.addActionListener(new ControllerMVCCargaDatos(this));
        itemPromocion.addActionListener(new ControllerMVCCargaDatos(this));
        // Devolvemos el Menu
        return menu;
    }
    /**
     * crearControlMenuGeoref
     * 
     * Crea el menu de opciones para las opciones de Georeferencia
     * @return JMenu
     */
    private JMenu crearControlMenuGeoref() {
        // Opciones del menu de georeferencias
        JMenuItem itemGeoAlmacenes = new JMenuItem("Coordenadas de Almacenes");
        JMenuItem itemGeoClientes = new JMenuItem("Coordenadas de Clientes");
        JMenuItem itemGeoTiendas = new JMenuItem("Coordenadas de Tiendas");
        // Titulo del menú
        JMenu menu = new JMenu("GeoReferencia");
        // Añadimos las opciones al menu
        menu.add(itemGeoAlmacenes);
        menu.add(itemGeoClientes);
        menu.add(itemGeoTiendas);
        // Enganchamos los ActionListener para cada una de las opciones de carga
        // NOTA : Usamos un único ContollerMVC y dependiendo del texto cargamos 
        // un archivo u otro en el Controller
        itemGeoClientes.addActionListener(new ControllerMVCGeoRef(this));
        itemGeoAlmacenes.addActionListener(new ControllerMVCGeoRef(this));
        itemGeoTiendas.addActionListener(new ControllerMVCGeoRef(this));
        // Devolvemos el Menu
        return menu;
    }
    
    /**
     * creaControlMenuMapas
     * 
     * Crea el menu de opciones para las opciones de Mapas
     * @return JMenu
     */
    private JMenu creaControlMenuMapas() {
        JMenuItem itemMapaAlmacenes = new JMenuItem("Generar Mapa de Almacenes");
        JMenuItem itemMapaClientes = new JMenuItem("Generar Mapa de Clientes");
        JMenuItem itemMapaVentas = new JMenuItem("Generar Mapa de Ventas");
        // Titulo del menú
        JMenu menu = new JMenu("Opciones de Análisis");
        // Añadimos las opciones al menu     
        menu.add(itemMapaAlmacenes);
        menu.add(itemMapaClientes);
        menu.add(itemMapaVentas);
        // Enganchamos los ActionListener para cada una de las opciones de carga
        itemMapaClientes.addActionListener(new ControllerMVCMapaClientes(this));
        itemMapaAlmacenes.addActionListener(new ControllerMVCMapaAlmacenes(this));
        itemMapaVentas.addActionListener(new ControllerMVCMapaVentas(this));
        // Devolvemos el Menu
        return menu;
    }

    /**
     *
     * Método que permite configurar la vista y actualizarla
     */
    public void setPanel(PanelGraficoMapa vista) {
        this.vista = vista;
        this.setContentPane(vista);
        this.setVisible(true);
    }
}
