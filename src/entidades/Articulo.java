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
    
    // CONSTRUCTOR
    public Articulo() {
        super();
    }
   
    // GETTERS Y SETTERS PARA LOS ATRIBUTOS
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

    /**
     * setValoresArticulo
     * 
     * Establece los valores de los datos del articulo segun posicion
     * @param valor
     * @param posicion 
     */
    public void setValoresArticulo (String valor, int posicion) {
        switch (posicion) {
            case 0 :// IDP
                this.setsIDArticulo(valor);
                break;
            case 1 : //CATEGORIA
                this.setsCategoria(valor);
                break;
            case 2 : //PRECIO
                this.setsPrecio(valor);
                break;
            case 3 : //FICHATECNICA
                this.setsFichaTecnica(valor);
                break;
            case 4 : //DESCRIPCIONTECNICA
                this.setsDescripcion(valor);
                break;
            default:
                System.out.println("setValoresArticulo - Posicion Inválida");
        }
    }
}
