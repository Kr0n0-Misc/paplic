package vistamvc;

import controllermvc.*;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import vistamvc.PanelGraficoMapa;

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
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setJMenuBar(barraMenus);// asignar barra a control JFrame
        this.setVisible(true);// hacer visible la interfaz de ususario
    }

    /**
     * crearControlMenuCargas
     * 
     * @brief Crea el menu de opciones para archivos de carga
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
    
    private JMenu crearControlMenuGeoref() {
        // Opciones del menu de georeferencias
        JMenuItem itemGeoClientes = new JMenuItem("Coordenadas de Clientes");
        JMenuItem itemGeoAlmacenes = new JMenuItem("Coordenadas de Almacenes");
        JMenuItem itemGeoTiendas = new JMenuItem("Coordenadas de Tiendas");

        JMenu menu = new JMenu("GeoReferencia");
        menu.add(itemGeoClientes);
        menu.add(itemGeoAlmacenes);
        menu.add(itemGeoTiendas);

        itemGeoClientes.addActionListener(new ControllerMVCGeoRef(this));
        itemGeoAlmacenes.addActionListener(new ControllerMVCGeoRef(this));
        itemGeoTiendas.addActionListener(new ControllerMVCGeoRef(this));
        
        return menu;
    }
    
    
    private JMenu creaControlMenuMapas() {

        JMenuItem itemAA = new JMenuItem("Generar Mapa de Clientes");
        JMenuItem itemAB = new JMenuItem("Generar Mapa Ventas");
        JMenuItem itemAC = new JMenuItem("Generar Mapa de Suministro");

        JMenu menu = new JMenu("Opciones de Análisis");
        menu.add(itemAA);
        menu.add(itemAB);
        menu.add(itemAC);

        itemAA.addActionListener(new ControllerMVCMapaClientes(this));
        itemAB.addActionListener(new ControllerMVCMapaClientes(this));
        itemAC.addActionListener(new ControllerMVCMapaClientes(this));

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
