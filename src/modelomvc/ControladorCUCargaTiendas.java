package modelomvc;

// Modelos y Controladores de Carga
import contenedores.ContenedorTiendasSingleton;
// Entidades
import entidades.Tienda;
import entidades.DatoFichero;
import entidades.RegistroFichero;
// Utilidades
import java.util.Iterator;
import java.util.LinkedList;
// Entrada / Salida
import java.io.IOException;
import javax.swing.JOptionPane;
// Proveedores y Validadores
import proveeedores.ProveedorTiendas;
import validacionesdatos.ValidarTienda;
        
/**
 * ControladorCUCargaTiendas
 * 
 * Controlador para caso de uso Cargar Tiendas
 * 
 * @author Kr0n0
 */
public class ControladorCUCargaTiendas {
    private final ContenedorTiendasSingleton contenedorTie;    
    ProveedorTiendas proveedor;
    ValidarTienda validador;
    String ruta_fichero;
    RegistroFichero registro;
    DatoFichero dato;
    LinkedList<RegistroFichero> llRegistro;
    LinkedList<DatoFichero> llDato;
    Tienda tienda;
    Iterator itRegistro;
    Iterator itDato;

    // CONSTRUCTOR
    public ControladorCUCargaTiendas(String ruta) {
        contenedorTie = ContenedorTiendasSingleton.getInstance();
        proveedor = new ProveedorTiendas(ruta);
        validador = new ValidarTienda();
        ruta_fichero = ruta;
    }
    
    /**
     * CargarTiendas
     * 
     * Caso de uso Cargar Tiendas
     * 
     * @throws IOException 
     */
    public void CargarTiendas() throws IOException {
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
            // Creamos Tienda nueva
            tienda = new Tienda();
            while (itDato.hasNext()) {
                // Recogemos el valor del dato con su posicion y valor
                dato = (DatoFichero) itDato.next();
                // Guardamos los valores en la entidad
                tienda.setValoresTienda(dato.getValor(), dato.getPosicion());
            } //FIN BUCLE DATOS
            
            // VALIDACION DE DATOS
            if (validador.esValido(tienda)) {
                    //Guardamos en el contenedor
                    contenedorTie.addTienda(tienda);
                    // Mostramos mensaje de almacenar
                    System.out.println("CargarTiendas - " + tienda.getsIDTienda() + " tienda validada y guardada.");
            }
        } // FIN BUCLE REGISTROS
        // Mostramos los datos del contenedor
        JOptionPane.showMessageDialog (null, contenedorTie.getNumTiendas()+ " tiendas cargados", "Carga fichero Tiendas", JOptionPane.INFORMATION_MESSAGE);
        contenedorTie.dbgContenedorTiendasSingleton();
    }
}