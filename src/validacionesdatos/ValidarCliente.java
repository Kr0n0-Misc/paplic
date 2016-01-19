/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validacionesdatos;

import entidades.Cliente;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/**
 *
 * @author Kr0n0
 */
public class ValidarCliente {
    private boolean validar;
    static CharsetEncoder asciiEncoder;

    public ValidarCliente() {
        this.validar = true;
        asciiEncoder = Charset.forName("UTF-8").newEncoder(); 
    }

    /**
     * esValido
     * 
     * @brief Valida los campos de la entidad
     * @param cliente
     * @return 
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
     * Comprueba si el texto está en formato ASCII UTF-8 o si está vacío
     * 
     * @param campo
     * @return boolean
     */
    private boolean esCampoValido (String campo) {
        return (asciiEncoder.canEncode(campo) || !campo.equals(" ") || !campo.isEmpty());
    }    
    
}
