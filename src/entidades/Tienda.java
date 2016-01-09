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
    //TODO Datos Almacen

    /******************************************
    /  Constructor
    *******************************************/
    public Tienda() {
        super();
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
    
    
    
}
