/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validacionesdatos;

import entidades.Tienda;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/**
 *
 * @author Kr0n0
 */
public class ValidarTienda {
    private boolean validar;
    static CharsetEncoder asciiEncoder;

    public ValidarTienda() {
        this.validar = true;
        asciiEncoder = Charset.forName("UTF-8").newEncoder(); 
    }

    /**
     * esValido
     * 
     * @brief Valida los campos de la entidad
     * @param promocion
     * @return 
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
     * Comprueba si el texto está en formato ASCII UTF-8 o si está vacío
     * 
     * @param campo
     * @return boolean
     */
    private boolean esCampoValido (String campo) {
        return (asciiEncoder.canEncode(campo) || !campo.equals(" "));
    }    
    
}
