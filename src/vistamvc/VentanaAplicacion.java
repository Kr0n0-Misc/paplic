package vistamvc;

import controllermvc.ControllerMVCMapaClientes;
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

        this.setTitle("Cuadro de mando");
        this.setSize(1200, 800); //tamaño de la ventana
        this.setBackground(Color.WHITE); // color de fondo
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar barraMenus = new JMenuBar();// control barra de menú superior
        JMenu menuC = creaControlMenuMapas(); // crear control menú elementos
        barraMenus.add(menuC);// asignar control de menú a barra superior 
        this.setJMenuBar(barraMenus);// asignar barra a control JFrame
        this.setVisible(true);// hacer visible la interfaz de ususario
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
