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
    private String sIDCliente, sDNI, sNombre, sApellidos, sCalle, sNum, sCodPost, sPoblacion, sProvincia, sTelf;
    
    /******************************************
    /  Constructor
    *******************************************/
    public Cliente() {
        super();
    }
   
    /******************************************
    /  Getters y Setters para los atributos
     *******************************************/
    
    public String getsIDCliente() {
        return sIDCliente;
    }
    
    public void setsIDCliente(String sIDCliente) {
        this.sIDCliente = sIDCliente;
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

    /**
     * setValoresCliente
     * 
     * @brief Establece los valores de los datos del cliente segun posicion
     * @param valor
     * @param posicion 
     */
    public void setValoresCliente (String valor, int posicion) {
        switch (posicion) {
            case 0 : //IDC
                this.setsIDCliente(valor);
                break;
            case 1 : //DNI
                this.setsDNI(valor);
                break;
            case 2 : //NOMBRE
                this.setsNombre(valor);
                break;
            case 3 : //APELLIDOS
                this.setsApellidos(valor);
                break;
            case 4 : //CALLE
                this.setsCalle(valor);
                break;
            case 5 : //NUMERO
                this.setsNum(valor);
                break;
            case 6 : //COD_POSTAL
                this.setsCodPost(valor);
                break;
            case 7 : //POBLACION
                this.setsPoblacion(valor);
                break;
            case 8 : //PROVINCIA
                this.setsProvincia(valor);
                break;
            case 9 : //TELEFONO
                this.setsTelf(valor);
                break;
            default:
                System.out.println("setValoresCliente - Posicion Inválida");
        }
    }
    
}
