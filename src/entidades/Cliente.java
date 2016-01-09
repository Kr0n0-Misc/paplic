package entidades;

/**
 * Entidad Cliente
 * 
 * Formato fichero : 
 *  IDC:DNI:NOMBRE:APELLIDOS:CALLE:NUMERO:COD_POSTAL:POBLACION:PROVINCIA:TELEFONO
 * 
 * @author Kr0n0
 * 
 */

public class Cliente extends EntidadGeo {
    private String sCliente, sDNI, sNombre, sApellidos, sCalle, sNum, sCodPost, sPoblacion, sProvincia, sTelf;
    
    /******************************************
    /  Constructor
    *******************************************/
    public Cliente() {
        super();
    }
    
    /******************************************
    /  Getters y Setters para los atributos
    *******************************************/
    public String getsCliente() {
        return sCliente;
    }

    public void setsCliente(String sCliente) {
        this.sCliente = sCliente;
    }

    public String getsDNI() {
        return sDNI;
    }

    public void setsDNI(String sDNI) {
        this.sDNI = sDNI;
    }

    public String getsNombre() {
        return sNombre;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getsApellidos() {
        return sApellidos;
    }

    public void setsApellidos(String sApellidos) {
        this.sApellidos = sApellidos;
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

    public String getsTelf() {
        return sTelf;
    }

    public void setsTelf(String sTelf) {
        this.sTelf = sTelf;
    }

}
