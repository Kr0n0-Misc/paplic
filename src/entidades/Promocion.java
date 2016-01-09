package entidades;

/**
 * Entidad Promocion
 * 
 * Formato fichero : 
 *  IDP:DESCUENTO
 * 
 * @author Kr0n0
 * 
 */

public class Promocion extends EntidadGeo {
    private String sIDPromocion, sDescuento;

    /******************************************
    /  Constructor
    *******************************************/
    public Promocion() {
        super();
    }

    /******************************************
    /  Getters y Setters para los atributos
     *******************************************/
    public String getsIDPromocion() {
        return sIDPromocion;
    }

    public void setsIDPromocion(String sIDPromocion) {
        this.sIDPromocion = sIDPromocion;
    }

    public String getsDescuento() {
        return sDescuento;
    }

    public void setsDescuento(String sDescuento) {
        this.sDescuento = sDescuento;
    }
   
}
