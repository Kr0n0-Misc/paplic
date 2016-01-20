package validacionesdatos;

// Entidades
import entidades.Promocion;
// Codificación
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/**
 * ValidarCliente
 * 
 * Clase para validar los datos proporcionados de Promocion.
 *
 * Comprueba si el campo es nulo o si es posible codificarlo en UTF-8
 * como comprobaciones básicas.
 * 
 * @author Kr0n0
 */
public class ValidarPromocion {
    private boolean validar;
    static CharsetEncoder asciiEncoder;

    // CONSTRUCTOR
    public ValidarPromocion() {
        this.validar = true;
        asciiEncoder = Charset.forName("UTF-8").newEncoder(); 
    }

    /**
     * esValido
     * 
     * Valida los campos de la entidad
     * @param promocion
     * @return boolean
     */
    public boolean esValido (Promocion promocion) {
        validar = (
            esCampoValido(promocion.getsDescuento()) ||
            esCampoValido(promocion.getsIDPromocion()));
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
        return (asciiEncoder.canEncode(campo) || !campo.equals(" ") || !campo.isEmpty());
    }    
}
