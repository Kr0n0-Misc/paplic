package controllermvc;

// Swing, AWT y vistas
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import vistamvc.VentanaAplicacion;
// Modelos y Controladores de Carga
import modelomvc.ControladorCUCargaAlmacenes;
import modelomvc.ControladorCUCargaArticulos;
import modelomvc.ControladorCUCargaClientes;
import modelomvc.ControladorCUCargaPromociones;
import modelomvc.ControladorCUCargaTiendas;
import modelomvc.ControladorCUCargaVentas;
// Entrada/Salida
import java.io.File;
import java.io.IOException;

/**
 * ControllerMVCCargaDatos
 * 
 * Controlador MVC para Carga de Datos
 * Es comun para los diferentes ficheros, discrimina por texto del controlInterfaz
 * 
 * @author Kr0n0
 */


public class ControllerMVCCargaDatos implements ActionListener {
    // Gestor de ficheros
    private JFileChooser fc;
    private FileFilter filter;
    private File selectedFile;
    private int resultado;
    
    // CONSTRUCTOR
    public ControllerMVCCargaDatos(VentanaAplicacion ventana) {
        super();
    }

    // actionPerformed - Click en opcion de menu
    @Override
    public void actionPerformed(ActionEvent e) {
        //1.-Actualiza el modelo en función del evento de entrada
       JMenuItem controlInterfaz = (JMenuItem) e.getSource(); //conversión del evento producido
        
       // Selector dependiendo de opcion de carga
       switch (controlInterfaz.getText()) {
            
           // CARGA FICHERO ALMACENES
           case "Carga fichero Almacenes" : 
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
               
           // CARGA FICHERO ARTICULOS
           case "Carga fichero Articulos" :
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
               
           // CARGA FICHERO CLIENTES
           case "Carga fichero Clientes" :
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
               
           // CARGA FICHERO TIENDAS
           case "Carga fichero Tiendas" :
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
               
           // CARGA FICHERO VENTAS
           case "Carga fichero Ventas" :
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
               
           // CARGA FICHERO PROMOCIONES   
           case "Carga fichero Promociones" :
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
