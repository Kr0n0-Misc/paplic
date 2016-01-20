package validacionesdatos;

// Entidades
import entidades.Tienda;
// Codificación
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/**
 * ValidarTienda
 * 
 * Clase para validar los datos proporcionados de Tienda.
 *
 * Comprueba si el campo es nulo o si es posible codificarlo en UTF-8
 * como comprobaciones básicas.
 * 
 * @author Kr0n0
 */
public class ValidarTienda {
    private boolean validar;
    static CharsetEncoder asciiEncoder;

    // CONSTRUCTOR
    public ValidarTienda() {
        this.validar = true;
        asciiEncoder = Charset.forName("UTF-8").newEncoder(); 
    }

    /**
     * esValido
     * 
     * Valida los campos de la entidad
     * @param tienda
     * @return boolean
     */
    public boolean esValido (Tienda tienda) {
        validar = (
                esCampoValido(tienda.getsCalle()) ||
                esCampoValido(tienda.getsCodPost()) ||
                esCampoValido(tienda.getsIDTienda()) ||
                esCampoValido(tienda.getsNum()) ||
                esCampoValido(tienda.getsPoblacion()) ||
                esCampoValido(tienda.getsProvincia()) ||
                esCampoValido(tienda.getsTelf()));
        return validar;
    }
    
    /**
     * esCampoValido
     * 
     * Comprueba si el texto está en formato ASCII UTF-8 o si está vacío para descartarlo
     * 
     * @param campo
     * @return boolean
     */
    private boolean esCampoValido (String campo) {
        return (asciiEncoder.canEncode(campo) || !campo.equals(" ") || !campo.isEmpty()) || !campo.equals("");
    }    
    
}
