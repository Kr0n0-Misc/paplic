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
   
}
