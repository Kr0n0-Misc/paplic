package modelomvc;

// Modelos y Controladores de Carga
import contenedores.ContenedorPromocionesSingleton;
// Entidades
import entidades.Promocion;
import entidades.DatoFichero;
import entidades.RegistroFichero;
// Utilidades
import java.util.Iterator;
import java.util.LinkedList;
// Entrada / Salida
import java.io.IOException;
// Proveedores y Validadores
import proveeedores.ProveedorPromociones;
import validacionesdatos.ValidarPromocion;
        
/**
 * ControladorCUCargaPromociones
 * 
 * Controlador para caso de uso Cargar Promociones
 * 
 * @author Kr0n0
 */
public class ControladorCUCargaPromociones {
    private final ContenedorPromocionesSingleton contenedorPro;    
    ProveedorPromociones proveedor;
    ValidarPromocion validador;
    String ruta_fichero;
    RegistroFichero registro;
    DatoFichero dato;
    LinkedList<RegistroFichero> llRegistro;
    LinkedList<DatoFichero> llDato;
    Promocion promocion;
    Iterator itRegistro;
    Iterator itDato;

    // CONSTRUCTOR
    public ControladorCUCargaPromociones(String ruta) {
        contenedorPro = ContenedorPromocionesSingleton.getInstance();
        proveedor = new ProveedorPromociones(ruta);
        validador = new ValidarPromocion();
        ruta_fichero = ruta;
    }
    
    /**
     * CargarPromociones
     * 
     * Caso de uso Cargar Promociones
     * 
     * @throws IOException 
     */
    public void CargarPromociones() throws IOException {
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
            promocion = new Promocion();
            while (itDato.hasNext()) {
                // Recogemos el valor del dato con su posicion y valor
                dato = (DatoFichero) itDato.next();
                // Guardamos los valores en la entidad
                promocion.setValoresPromocion(dato.getValor(), dato.getPosicion());
            } //FIN BUCLE DATOS
            
            // VALIDACION DE DATOS
            if (validador.esValido(promocion)) {
                    //Guardamos en el contenedor
                    contenedorPro.addPromocion(promocion);
                    // Mostramos mensaje de almacenar
                    System.out.println("CargarPromociones - "+promocion.getsIDPromocion()+" promocion validada y guardada.");
            }
        } // FIN BUCLE REGISTROS
        // Mostramos los datos del contenedor
        contenedorPro.dbgContenedorPromocionesSingleton();
    }
}