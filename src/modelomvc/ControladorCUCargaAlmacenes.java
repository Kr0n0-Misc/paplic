package modelomvc;

// Modelos y Controladores de Carga
import contenedores.ContenedorAlmacenesSingleton;
// Entidades
import entidades.Almacen;
import entidades.DatoFichero;
import entidades.RegistroFichero;
// Utilidades
import java.util.Iterator;
import java.util.LinkedList;
// Entrada/Salida
import java.io.IOException;
import javax.swing.JOptionPane;
// Proveedores y Validadores
import proveeedores.ProveedorAlmacenes;
import validacionesdatos.ValidarAlmacen;
        
/**
 * ControladorCUCargaAlmacenes
 * 
 * Controlador para caso de uso Cargar Almacenes
 * 
 * @author Kr0n0
 */
public class ControladorCUCargaAlmacenes {
    private final ContenedorAlmacenesSingleton contenedorAlm;    
    ProveedorAlmacenes proveedor;
    ValidarAlmacen validador;
    String ruta_fichero;
    RegistroFichero registro;
    DatoFichero dato;
    LinkedList<RegistroFichero> llRegistro;
    LinkedList<DatoFichero> llDato;
    Almacen almacen;
    Iterator itRegistro;
    Iterator itDato;
    
    // CONSTRUCTOR
    public ControladorCUCargaAlmacenes(String ruta) {
        contenedorAlm = ContenedorAlmacenesSingleton.getInstance();
        proveedor = new ProveedorAlmacenes(ruta);
        validador = new ValidarAlmacen();
        ruta_fichero = ruta;
    }
    
    /**
     * CargarAlmacenes
     * 
     * Caso de uso Cargar Almacenes
     * @throws IOException 
     */
    public void CargarAlmacenes() throws IOException {
        // Leemos los registros usando el proveedor de datos y lo volcamos al LinkedList
        llRegistro = proveedor.LeerRegistros(ruta_fichero);
        // Asignamos el iterador al LinkedList de registros
        itRegistro = llRegistro.iterator();
        // Mientras que haya Registros en la lista
        while (itRegistro.hasNext()) {
            // Leemos el registro
            registro = (RegistroFichero) itRegistro.next();
            // Leemos las lineas de Datos del registro
            llDato = registro.getLineasDatos();
            // Asignamos el iterador al LinkedList de datos
            itDato = llDato.iterator();
            // Creamos Almacen nuevo
            almacen = new Almacen();
            while (itDato.hasNext()) {
                // Recogemos el valor del dato con su posicion y valor
                dato = (DatoFichero) itDato.next();
                // Guardamos los valores en la entidad
                almacen.setValoresAlmacen(dato.getValor(), dato.getPosicion());
            } //FIN BUCLE DATOS
            
            // VALIDACION DE DATOS
            if (validador.esValido(almacen)) {
                    //Guardamos en el contenedor
                    contenedorAlm.addAlmacen(almacen);
                    // Mostramos mensaje de almacenar
                    System.out.println("CargarAlmacenes - "+almacen.getsIDAlmacen() +" almacen validado y guardado.");
            }
           
        } // FIN BUCLE REGISTROS
        // Mostramos los datos del contenedor
        JOptionPane.showMessageDialog (null, contenedorAlm.getNumAlmacenes()+ " almacenes cargados", "Carga fichero Almacenes", JOptionPane.INFORMATION_MESSAGE);
        contenedorAlm.dbgContenedorAlmacenesSingleton();        
    }
}