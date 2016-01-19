/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validacionesdatos;

import entidades.Venta;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/**
 *
 * @author Kr0n0
 */
public class ValidarVenta {
    private boolean validar;
    static CharsetEncoder asciiEncoder;

    public ValidarVenta() {
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
     * Comprueba si el texto está en formato ASCII UTF-8 o si está vacío
     * 
     * @param campo
     * @return boolean
     */
    private boolean esCampoValido (String campo) {
        return (!isPureAscii(campo) || campo.equals(" "));
    }    
  
    /**
     * isPureAscii
     * 
     * Comprueba si es ascii la cadena
     * 
     * @param v
     * @return 
     */
    private static boolean isPureAscii(String v) {
      return asciiEncoder.canEncode(v);
    }
    
}
