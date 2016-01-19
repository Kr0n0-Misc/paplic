package entidades;

/**
 * Entidad Tienda
 * 
 * Formato fichero : 
 *  IDT:CALLE:NUMERO:COD_POSTAL:TELEFONO:POBLACION:PROVINCIA:IDA
 * 
 * @author Kr0n0
 * 
 */

public class Tienda extends EntidadGeo {
    private String sIDTienda, sCalle, sNum, sCodPost, sTelf, sPoblacion, sProvincia;
    private Almacen aAlmacen;
    private String sIDAlmacen;

    /******************************************
    /  Constructor
    *******************************************/
    public Tienda() {
        //this.aAlmacen= new Almacen();
    }
    
    /*************************************************
    /  Getters y Setters para las clases dependientes
   **************************************************/
    
    public Almacen getaAlmacen() {
        return aAlmacen;
    }

    public void setaAlmacen(Almacen aAlmacen) {
        this.aAlmacen = aAlmacen;
    }
    
    public String getsIDAlmacen() {
        return sIDAlmacen;
    }
    
    public void setsIDAlmacen(String sIDAlmacen) {
        this.sIDAlmacen = sIDAlmacen;
    }
    
    /******************************************
    /  Getters y Setters para los atributos
     *******************************************/
    public String getsIDTienda() {
        return sIDTienda;
    }
    
    public void setsIDTienda(String sIDTienda) {
        this.sIDTienda = sIDTienda;
    }

    public String getsCalle() {
        return sCalle;
    }

    public void setsCalle(String sCalle) {
        this.sCalle = sCalle;
    }

    public String getsNum() {
        return sNum;
    }

    public void setsNum(String sNum) {
        this.sNum = sNum;
    }

    public String getsCodPost() {
        return sCodPost;
    }

    public void setsCodPost(String sCodPost) {
        this.sCodPost = sCodPost;
    }

    public String getsTelf() {
        return sTelf;
    }

    public void setsTelf(String sTelf) {
        this.sTelf = sTelf;
    }

    public String getsPoblacion() {
        return sPoblacion;
    }

    public void setsPoblacion(String sPoblacion) {
        this.sPoblacion = sPoblacion;
    }

    public String getsProvincia() {
        return sProvincia;
    }

    public void setsProvincia(String sProvincia) {
        this.sProvincia = sProvincia;
    }    
    
    /**
     * setValoresTienda
     * 
     * @brief Establece los valores de los datos de la tienda segun posicion
     * @param valor
     * @param posicion 
     */
    public void setValoresTienda (String valor, int posicion) {
        switch (posicion) {
            case 0 : //IDT
                this.setsIDTienda(valor);
                break;
            case 1 : //CALLE
                this.setsCalle(valor);
                break;
            case 2 : //NUMERO
                this.setsNum(valor);
                break;
            case 3 : //COD_POSTAL
                this.setsCodPost(valor);
                break;
            case 4 : //TELEFONO
                this.setsTelf(valor);
                break;
            case 5 : //POBLACION
                this.setsPoblacion(valor);
                break;
            case 6 : //PROVINCIA
                this.setsProvincia(valor);
                break;
            case 7 : //IDA
                //this.aAlmacen.setsIDAlmacen(valor);
                this.setsIDAlmacen(valor);
            default:
                System.out.println("setValorAlmacen - Posicion Inválida");
        }
    }
    
}
