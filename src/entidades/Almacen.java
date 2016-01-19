package entidades;

/**
 * Entidad Almacen
 * 
 * Formato fichero : 
 *  IDA:CALLE:NUMERO:COD_POSTAL:TELEFONO:MUNICIPIO:PROVINCIA
 * 
 * @author Kr0n0
 * 
 */

public class Almacen extends EntidadGeo {
   private String sIDAlmacen, sCalle, sNum, sCodPost, sTelf, sPoblacion, sProvincia;
    //TODO ¿Poblacion es lo mismo que Municipio?
   
    /******************************************
    /  Constructor
    *******************************************/
    public Almacen() {
        super();
    }
   
    /******************************************
    /  Getters y Setters para los atributos
    *******************************************/
    public String getsIDAlmacen() {
        return sIDAlmacen;
    }

    public void setsIDAlmacen(String sIDAlmacen) {
        this.sIDAlmacen = sIDAlmacen;
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
     * setValoresAlmacen
     * 
     * @brief Establece los valores de los datos del almacen segun posicion
     * @param valor
     * @param posicion 
     */
    public void setValoresAlmacen (String valor, int posicion) {
        switch (posicion) {
            case 0 : //IDA
                this.setsIDAlmacen(valor);
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
            default:
                System.out.println("setValoresAlmacen - Posicion Inválida");
        }
    }
    
}
