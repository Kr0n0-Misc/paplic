package entidades;

/**
 * Entidad Articulo
 * 
 * Formato fichero : 
 *  IDP:CATEGORIA:PRECIO:FICHATECNICA:DESCRIPCIONTECNICA
 * 
 * @author Kr0n0
 * 
 */

public class Articulo extends EntidadGeo {
    private String sIDArticulo, sCategoria, sPrecio, sFichaTecnica, sDescripcion;
    
    /******************************************
    /  Constructor
    *******************************************/
    public Articulo() {
        super();
    }
    
    /******************************************
    /  Getters y Setters para los atributos
     *******************************************/
    public String getsIDArticulo() {
        return sIDArticulo;
    }

    public void setsIDArticulo(String sIDArticulo) {
        this.sIDArticulo = sIDArticulo;
    }

    public String getsCategoria() {
        return sCategoria;
    }

    public void setsCategoria(String sCategoria) {
        this.sCategoria = sCategoria;
    }

    public String getsPrecio() {
        return sPrecio;
    }

    public void setsPrecio(String sPrecio) {
        this.sPrecio = sPrecio;
    }

    public String getsFichaTecnica() {
        return sFichaTecnica;
    }

    public void setsFichaTecnica(String sFichaTecnica) {
        this.sFichaTecnica = sFichaTecnica;
    }

    public String getsDescripcion() {
        return sDescripcion;
    }

    public void setsDescripcion(String sDescripcion) {
        this.sDescripcion = sDescripcion;
    }
    
}
