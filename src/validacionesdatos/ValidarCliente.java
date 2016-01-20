package validacionesdatos;

// Entidades
import entidades.Cliente;
// Codificación
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/**
 * ValidarCliente
 * 
 * Clase para validar los datos proporcionados de Cliente.
 *
 * Comprueba si el campo es nulo o si es posible codificarlo en UTF-8
 * como comprobaciones básicas.
 * 
 * @author Kr0n0
 */
public class ValidarCliente {
    private boolean validar;
    static CharsetEncoder asciiEncoder;

    // CONSTRUCTOR
    public ValidarCliente() {
        this.validar = true;
        asciiEncoder = Charset.forName("UTF-8").newEncoder(); 
    }

    /**
     * esValido
     * 
     * @brief Valida los campos de la entidad
     * @param cliente
     * @return boolean
     */
    public boolean esValido (Cliente cliente) {
        validar = (
            esCampoValido(cliente.getsApellidos()) ||
            esCampoValido(cliente.getsCalle()) ||
            esCampoValido(cliente.getsCodPost()) ||
            esCampoValido(cliente.getsDNI()) ||
            esCampoValido(cliente.getsIDCliente()) ||
            esCampoValido(cliente.getsNombre()) ||
            esCampoValido(cliente.getsNum()) ||
            esCampoValido(cliente.getsPoblacion()) ||
            esCampoValido(cliente.getsProvincia()) ||
            esCampoValido(cliente.getsTelf()));
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
