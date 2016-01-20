package validacionesdatos;

// Entidades
import entidades.Venta;
// Codificación
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/**
 * ValidarVenta
 * 
 * Clase para validar los datos proporcionados de Venta.
 *
 * Comprueba si el campo es nulo o si es posible codificarlo en UTF-8
 * como comprobaciones básicas.
 * 
 * El resto de comprobaciones (Cliente, Artículo, Tienda) se hacen en
 * el controlador.
 * 
 * @author Kr0n0
 */
public class ValidarVenta {
    private boolean validar;
    static CharsetEncoder asciiEncoder;

    // CONTROLLER
    public ValidarVenta() {
        this.validar = true;
        asciiEncoder = Charset.forName("UTF-8").newEncoder(); 
    }

    /**
     * esValido
     * 
     * Valida los campos de la entidad
     * @param venta
     * @return boolean
     */
    public boolean esValido (Venta venta) {
        validar = (
                esCampoValido(venta.getsFecha()) ||
                esCampoValido(venta.getsIDVenta()) ||
                esCampoValido(venta.getsImporte()) ||
                esCampoValido(venta.getsUnidades()));
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
