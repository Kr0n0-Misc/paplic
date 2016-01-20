package validacionesdatos;

// Entidades
import entidades.Articulo;
// Codificación
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/**
 * ValidarArticulo
 * 
 * Clase para validar los datos proporcionados de Artículo.
 *
 * Comprueba si el campo es nulo o si es posible codificarlo en UTF-8
 * como comprobaciones básicas.
 * 
 * @author Kr0n0
 */
public class ValidarArticulo {
    private boolean validar;
    static CharsetEncoder asciiEncoder;

    // CONSTRUCTOR
    public ValidarArticulo() {
        this.validar = true;
        asciiEncoder = Charset.forName("UTF-8").newEncoder(); 
    }

    /**
     * esValido
     * 
     * Valida los campos de la entidad
     * @param articulo
     * @return boolean
     */
    public boolean esValido (Articulo articulo) {
        validar = (
            esCampoValido(articulo.getsCategoria()) ||
            esCampoValido(articulo.getsDescripcion()) ||
            esCampoValido(articulo.getsFichaTecnica()) ||
            esCampoValido(articulo.getsIDArticulo()) ||
            esCampoValido(articulo.getsPrecio()));
        return validar;
    }
    
    /**
     * esCampoValido
     * 
     * Comprueba si el texto está en formato ASCII UTF-8 o si está vacío para descartarlo
     * @param campo
     * @return boolean
     */
    private boolean esCampoValido (String campo) {
        return (asciiEncoder.canEncode(campo) || !campo.equals(" ") || !campo.isEmpty());
    }
    
    
}
