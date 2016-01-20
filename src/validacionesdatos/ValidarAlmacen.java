package validacionesdatos;

// Entidades
import entidades.Almacen;
// Codificación
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/**
 * ValidarAlmacen
 * 
 * Clase para validar los datos proporcionados de Almacén.
 *
 * Comprueba si el campo es nulo o si es posible codificarlo en UTF-8
 * como comprobaciones básicas.
 * 
 * @author Kr0n0
 */
public class ValidarAlmacen {
    private boolean validar;
    static CharsetEncoder asciiEncoder;

    // CONSTRUCTOR
    public ValidarAlmacen() {
        this.validar = true;
        asciiEncoder = Charset.forName("UTF-8").newEncoder(); 
    }

    /**
     * esValido
     * 
     * Valida los campos de la entidad
     * @param almacen
     * @return boolean
     */
    public boolean esValido (Almacen almacen) {
        this.validar = true;
        validar = (
            esCampoValido(almacen.getsCalle()) ||
            esCampoValido(almacen.getsCodPost()) ||
            esCampoValido(almacen.getsIDAlmacen()) ||
            esCampoValido(almacen.getsNum()) ||
            esCampoValido(almacen.getsPoblacion()) ||
            esCampoValido(almacen.getsProvincia()) ||
            esCampoValido(almacen.getsTelf()));
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
