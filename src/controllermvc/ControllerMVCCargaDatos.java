/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllermvc;

//import contenedores.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
//import modelomvc.MapaVectorialClientes;
import vistamvc.VentanaAplicacion;
//import vistamvc.PanelGraficoMapa;

// Controladores de Casos de Uso - Cargas
import modelomvc.ControladorCUCargaAlmacenes;
import modelomvc.ControladorCUCargaArticulos;
import modelomvc.ControladorCUCargaClientes;
import modelomvc.ControladorCUCargaPromociones;
import modelomvc.ControladorCUCargaTiendas;
import modelomvc.ControladorCUCargaVentas;


public class ControllerMVCCargaDatos implements ActionListener {
    
    // Gestor de ficheros
    private JFileChooser fc;
    private FileFilter filter;
    private File selectedFile;
    
    private int resultado;

    
    public ControllerMVCCargaDatos(VentanaAplicacion ventana) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //1.-Actualiza el modelo en función del evento de entrada
       JMenuItem controlInterfaz = (JMenuItem) e.getSource(); //conversión del evento producido
        
       // Selector dependiendo de opcion de carga
       switch (controlInterfaz.getText()) {
           case "Carga fichero Almacenes" : 
               // CARGA FICHERO ALMACENES
               System.out.println("[ControllerMVCCargaDatos] - Carga de fichero Almacenes");
               // Abrimos el filechooser
               filter = new FileNameExtensionFilter("Datos Almacenes (.txt)", "txt");
               fc = new JFileChooser();
               fc.addChoosableFileFilter(filter);
               fc.setFileFilter(filter);
               resultado = fc.showOpenDialog(controlInterfaz);
               if (resultado == JFileChooser.APPROVE_OPTION) {
                   selectedFile = fc.getSelectedFile();
                   // Cargar ControladorCUCargaAlmacenes
                   System.out.println("[ControllerMVCCargaDatos] - Fichero " + selectedFile.getAbsolutePath() + " seleccionado.");
                   ControladorCUCargaAlmacenes cargaAlmacenes = new ControladorCUCargaAlmacenes(selectedFile.getAbsolutePath());
                   try {
                       cargaAlmacenes.CargarAlmacenes();
                   }
                   catch (IOException excepcion) {}
               }            
               break;
               
           case "Carga fichero Articulos" :
               // CARGA FICHERO ARTICULOS
               // Recogemos la instancia del singleton correspondiente
               System.out.println("[ControllerMVCCargaDatos] - Carga de fichero Articulos");
               // Abrimos el filechooser
               filter = new FileNameExtensionFilter("Datos Articulos (.txt)", "txt");
               fc = new JFileChooser();
               fc.addChoosableFileFilter(filter);
               fc.setFileFilter(filter);
               resultado = fc.showOpenDialog(controlInterfaz);
               if (resultado == JFileChooser.APPROVE_OPTION) {
                   selectedFile = fc.getSelectedFile();
                   // Cargar ControladorCUCargaArticulos
                   System.out.println("[ControllerMVCCargaDatos] - Fichero " + selectedFile.getAbsolutePath() + " seleccionado.");
                   ControladorCUCargaArticulos cargaArticulos = new ControladorCUCargaArticulos(selectedFile.getAbsolutePath());
                   try {
                       cargaArticulos.CargarArticulos();
                   }
                   catch (IOException excepcion) {}
               }            
               break;

           case "Carga fichero Clientes" :
               // CARGA FICHERO CLIENTES
               // Recogemos la instancia del singleton correspondiente
               System.out.println("[ControllerMVCCargaDatos] - Carga de fichero Clientes");
               // Abrimos el filechooser
               filter = new FileNameExtensionFilter("Datos Clientes (.txt)", "txt");
               fc = new JFileChooser();
               fc.addChoosableFileFilter(filter);
               fc.setFileFilter(filter);
               resultado = fc.showOpenDialog(controlInterfaz);
               if (resultado == JFileChooser.APPROVE_OPTION) {
                   selectedFile = fc.getSelectedFile();
                   // Cargar ControladorCUCargaClientes - Pasamos como parámetro el getAbsolutePath()
                   System.out.println("[ControllerMVCCargaDatos] - Fichero " + selectedFile.getAbsolutePath() + " seleccionado.");
                   ControladorCUCargaClientes cargaClientes = new ControladorCUCargaClientes(selectedFile.getAbsolutePath());
                   try {
                       cargaClientes.CargarClientes();
                   }
                   catch (IOException excepcion) {}
               }            
               break;
               
           case "Carga fichero Tiendas" :
               // CARGA FICHERO TIENDAS
               // Recogemos la instancia del singleton correspondiente
               System.out.println("[ControllerMVCCargaDatos] - Carga de fichero Tiendas");
               // Abrimos el filechooser
               filter = new FileNameExtensionFilter("Datos Tiendas (.txt)", "txt");
               fc = new JFileChooser();
               fc.addChoosableFileFilter(filter);
               fc.setFileFilter(filter);
               resultado = fc.showOpenDialog(controlInterfaz);
               if (resultado == JFileChooser.APPROVE_OPTION) {
                   selectedFile = fc.getSelectedFile();
                   // Cargar ControladorCUCargaTiendas                   
                   System.out.println("[ControllerMVCCargaDatos] - Fichero " + selectedFile.getAbsolutePath() + " seleccionado.");
                   ControladorCUCargaTiendas cargaTiendas = new ControladorCUCargaTiendas(selectedFile.getAbsolutePath());
                    try {
                       cargaTiendas.CargarTiendas();
                   }
                   catch (IOException excepcion) {}
               }            
               break;

           case "Carga fichero Ventas" :
               // CARGA FICHERO VENTAS
               // Recogemos la instancia del singleton correspondiente
               System.out.println("[ControllerMVCCargaDatos] - Carga de fichero Ventas");
               // Abrimos el filechooser
               filter = new FileNameExtensionFilter("Datos Ventas (.txt)", "txt");
               fc = new JFileChooser();
               fc.addChoosableFileFilter(filter);
               fc.setFileFilter(filter);
               resultado = fc.showOpenDialog(controlInterfaz);
               if (resultado == JFileChooser.APPROVE_OPTION) {
                   selectedFile = fc.getSelectedFile();
                   // Cargar ControladorCUCargaVentas
                   System.out.println("[ControllerMVCCargaDatos] - Fichero " + selectedFile.getAbsolutePath() + " seleccionado.");
                   ControladorCUCargaVentas cargaVentas = new ControladorCUCargaVentas(selectedFile.getAbsolutePath());
                   try {
                       cargaVentas.CargarVentas();
                   }
                   catch (IOException excepcion) {}
               }            
               break;
               
           case "Carga fichero Promociones" :
               // CARGA FICHERO PROMOCIONES
               // Recogemos la instancia del singleton correspondiente
               System.out.println("[ControllerMVCCargaDatos] - Carga de fichero Promociones");
                          // Abrimos el filechooser
               filter = new FileNameExtensionFilter("Datos Promociones (.txt)", "txt");
               fc = new JFileChooser();
               fc.addChoosableFileFilter(filter);
               fc.setFileFilter(filter);
               resultado = fc.showOpenDialog(controlInterfaz);
               if (resultado == JFileChooser.APPROVE_OPTION) {
                   selectedFile = fc.getSelectedFile();
                   System.out.println("[ControllerMVCCargaDatos] - Fichero " + selectedFile.getAbsolutePath() + " seleccionado.");
                   ControladorCUCargaPromociones cargaPromociones = new ControladorCUCargaPromociones(selectedFile.getAbsolutePath());
                   try {
                       cargaPromociones.CargarPromociones();
                   }
                   catch (IOException excepcion) {}
               }            
               break;
       }
       
    }
}
