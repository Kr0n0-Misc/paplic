package modelomvc;

// Modelos y Controladores de Carga
import contenedores.ContenedorArticulosSingleton;
import contenedores.ContenedorClientesSingleton;
import contenedores.ContenedorTiendasSingleton;
import contenedores.ContenedorVentasSingleton;
// Entidades
import entidades.Venta;
import entidades.DatoFichero;
import entidades.RegistroFichero;
import entidades.Articulo;
import entidades.Cliente;
import entidades.Tienda;
// Utilidades
import java.util.Iterator;
import java.util.LinkedList;
// Entrada / Salida
import java.io.IOException;
import javax.swing.JOptionPane;
// Proveedores y Validadores
import proveeedores.ProveedorVentas;
import validacionesdatos.ValidarVenta;
        
/**
 * ControladorCUCargaVentas
 * 
 * Controlador para caso de uso Cargar Ventas
 * 
 * @author Kr0n0
 */
public class ControladorCUCargaVentas {
    private final ContenedorVentasSingleton contenedorVen;
    ContenedorClientesSingleton contenedorCli;
    ContenedorArticulosSingleton contenedorArt;
    ContenedorTiendasSingleton contenedorTie;
    ProveedorVentas proveedor;
    ValidarVenta validador;
    String ruta_fichero;
    RegistroFichero registro;
    DatoFichero dato;
    LinkedList<RegistroFichero> llRegistro;
    LinkedList<DatoFichero> llDato;
    Venta venta;
    Iterator itRegistro;
    Iterator itDato;

    // CONSTRUCTOR
    public ControladorCUCargaVentas(String ruta) {
        contenedorVen = ContenedorVentasSingleton.getInstance();
        proveedor = new ProveedorVentas(ruta);
        validador = new ValidarVenta();
        ruta_fichero = ruta;
    }
    
    /**
     * CargarVentas
     * 
     * Caso de uso Cargar Tiendas
     * 
     * @throws IOException 
     */
    public void CargarVentas() throws IOException {
        // Leemos los registros usando el proveedor de datos y lo volcamos al LinkedList
        llRegistro = proveedor.LeerRegistros(ruta_fichero);
        // Cargamos los instancias para clientes, productos y tiendas (dependencias) 
        contenedorCli = ContenedorClientesSingleton.getInstance();
        contenedorArt = ContenedorArticulosSingleton.getInstance();
        contenedorTie = ContenedorTiendasSingleton.getInstance();     
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
            // Creamos Cliente nuevo
            venta = new Venta();
            while (itDato.hasNext()) {
                // Recogemos el valor del dato con su posicion y valor
                dato = (DatoFichero) itDato.next();
                // Guardamos los valores en la entidad
                venta.setValoresVenta(dato.getValor(), dato.getPosicion());
            } //FIN BUCLE DATOS
            
            // VALIDACION DE DATOS
            if (validador.esValido(venta)) {
                // Comprobamos que exista el cliente, producto y tienda buscando en los contenedores existentes.

                // Cliente
                Cliente cliente = ContenedorClientesSingleton.getInstance().getCliente(venta.getsIDCliente());
                if (cliente == null)
                        System.out.println("Cliente "+venta.getsIDCliente()+" no encontrado en el sistema.");
                // Articulo
                Articulo articulo = ContenedorArticulosSingleton.getInstance().getArticulo(venta.getsIDArticulo());
                if (articulo == null)
                        System.out.println("Articulo "+venta.getsIDArticulo()+" no encontrado en el sistema.");
                // Tienda
                Tienda tienda = ContenedorTiendasSingleton.getInstance().getTienda(venta.getsIDTienda());
                if (tienda == null)
                        System.out.println("Tienda "+venta.getsIDTienda()+" no encontrada en el sistema.");
                                
                if ((cliente != null) && (articulo != null) && (tienda != null)) {
                    //Guardamos las referencias a las entidades
                    venta.setaArticulo(articulo);
                    venta.setcCliente(cliente);
                    venta.settTienda(tienda);
                    //Guardamos en el contenedor
                    contenedorVen.addVenta(venta);
                    // Mostramos mensaje de almacenar
                    System.out.println("CargarVentas - "+venta.getsIDVenta()+" venta validada y guardada.");
                }
            }
           
        } // FIN BUCLE REGISTROS
        // Mostramos los datos del contenedor
        JOptionPane.showMessageDialog (null, contenedorVen.getNumVentas()+ " ventas cargadas", "Carga fichero Ventas", JOptionPane.INFORMATION_MESSAGE);
        contenedorVen.dbgContenedorVentasSingleton();
    }
}