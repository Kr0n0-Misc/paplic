package modelomvc;

// Modelos y Controladores de Carga
import contenedores.ContenedorClientesSingleton;
// Entidades
import entidades.Cliente;
import entidades.DatoFichero;
import entidades.RegistroFichero;
// Utilidades
import java.util.Iterator;
import java.util.LinkedList;
// Entrada/Salida
import java.io.IOException;
import javax.swing.JOptionPane;
// Proveedores y Validadores
import proveeedores.ProveedorClientes;
import validacionesdatos.ValidarCliente;
        
/**
 * ControladorCUCargaClientes
 *
 * Controlador para caso de uso Cargar Articulos
 * 
 * @author Kr0n0
 */
public class ControladorCUCargaClientes {
    private final ContenedorClientesSingleton contenedorCli;    
    ProveedorClientes proveedor;
    ValidarCliente validador;
    String ruta_fichero;
    RegistroFichero registro;
    DatoFichero dato;
    LinkedList<RegistroFichero> llRegistro;
    LinkedList<DatoFichero> llDato;
    Cliente cliente;
    Iterator itRegistro;
    Iterator itDato;

    // CONSTRUCTOR
    public ControladorCUCargaClientes(String ruta) {
        contenedorCli = ContenedorClientesSingleton.getInstance();
        proveedor = new ProveedorClientes(ruta);
        validador = new ValidarCliente();
        ruta_fichero = ruta;
    }
    
    /**
     * CargarClientes
     * 
     * Caso de uso Cargar Clientes
     * 
     * @throws IOException 
     */
    public void CargarClientes() throws IOException {
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
            // Creamos Cliente nuevo
            cliente = new Cliente();
            while (itDato.hasNext()) {
                // Recogemos el valor del dato con su posicion y valor
                dato = (DatoFichero) itDato.next();
                // Guardamos los valores en la entidad
                cliente.setValoresCliente(dato.getValor(), dato.getPosicion());
            } //FIN BUCLE DATOS
            
            // VALIDACION DE DATOS
            if (validador.esValido(cliente)) {
                    //Guardamos en el contenedor
                    contenedorCli.addCliente(cliente);
                    // Mostramos mensaje de almacenar
                    System.out.println("CargarClientes - "+cliente.getsIDCliente()+" cliente validado y guardado.");
            }
           
        } // FIN BUCLE REGISTROS
        // Mostramos los datos del contenedor
        JOptionPane.showMessageDialog (null, contenedorCli.getNumClientes()+ " clientes cargados", "Carga fichero Clientes", JOptionPane.INFORMATION_MESSAGE);
        contenedorCli.dbgContenedorClientesSingleton();
    }
}