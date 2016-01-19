/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validacionesdatos;

import entidades.Articulo;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/**
 *
 * @author Kr0n0
 */
public class ValidarArticulo {
    private boolean validar;
    static CharsetEncoder asciiEncoder;

    public ValidarArticulo() {
        this.validar = true;
        asciiEncoder = Charset.forName("UTF-8").newEncoder(); 
    }

    /**
     * esValido
     * 
     * @brief Valida los campos de la entidad
     * @param articulo
     * @return 
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
     * Comprueba si el texto está en formato ASCII UTF-8 o si está vacío
     * 
     * @param campo
     * @return boolean
     */
    private boolean esCampoValido (String campo) {
        return (asciiEncoder.canEncode(campo) || !campo.equals(" ") || !campo.isEmpty());
    }
    
    
}
