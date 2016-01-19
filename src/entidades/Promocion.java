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
   
    /**
     * setValoresPromocion
     * 
     * @brief Establece los valores de los datos de la promoción segun posicion
     * @param valor
     * @param posicion 
     */
    public void setValoresPromocion (String valor, int posicion) {
        switch (posicion) {
            case 0 : //IDP
                this.setsIDPromocion(valor);
                break;
            case 1 : //DESCUENTO
                this.setsDescuento(valor);
                break;
            default:
                System.out.println("setValoresPromocion - Posicion Inválida");
        }
    }
    
}
