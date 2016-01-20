package proveeedores;

// Entidades
import entidades.DatoFichero;
import entidades.RegistroFichero;
// Entrada / Salida
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
// Utilidades
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *  ProveedorAlmacenes
 * 
 * Clase proveedor para lectura de fichero de datos de articulos
 * @author Kr0n0
 */
public class ProveedorArticulos {
    private final LinkedList<RegistroFichero> llLineasFichero;
    protected File fichero;

    // CONSTRUCTOR
    public ProveedorArticulos(String ruta) {
        // Creamos una nueva lista para ir guardando las lineas del fichero
        llLineasFichero = new LinkedList<>();
        // Creamos el objeto File con la ruta asociada
        this.fichero = new File(ruta);
    }
    
    /**
     * LeerRegistros
     * 
     * Lee los registros usando StringTokenizer y devuelve un LinkedList con los
     * registros
     * 
     * @param ruta
     * @return llLineasFichero
     * @throws FileNotFoundException 
     */
    public LinkedList<RegistroFichero> LeerRegistros (String ruta) throws FileNotFoundException {
        // Entrada de datos
        Reader filereader = new FileReader(fichero);
        BufferedReader brEntrada = new BufferedReader(filereader);  // Buffer para leer linea a linea
        // Almacenamiento de datos
        RegistroFichero registro;
        DatoFichero dato;
        // Cadenas y tokens
        String linea, sToken;
        StringTokenizer sTokenizer;
        int indice;
        try {
            // Mientras haya lineas en el fichero
            while ((linea = brEntrada.readLine()) != null) {
                // Creamos un registro nuevo y un tokenizer para separar por ":"
                registro = new RegistroFichero();
                sTokenizer = new StringTokenizer(linea, ":");
                // Reseteamos el indice
                indice = 0;
                // Mientras haya tokens en la linea
                while (sTokenizer.hasMoreTokens()) {
                    // Recogemos el dato, lo guardamos en el registro 
                    // e incrementamos indice
                    sToken = sTokenizer.nextToken();
                    dato = new DatoFichero(indice, sToken);
                    registro.addDato(dato);
                    indice++;
                }
                // Añadimos el registro a la lista de lineas 
                llLineasFichero.addLast(registro);
            } // Fin de fichero
        } catch (Exception e) {}
        return llLineasFichero;
    }
}
