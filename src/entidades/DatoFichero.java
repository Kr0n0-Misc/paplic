package entidades;

/**
 * DatoFichero
 * 
 * Clase para gestionar cada dato dentro de una Linea de fichero.
 * Controlamos posicion y valor para registrar en los contenedores
 * 
 * @author Kr0n0
 */
public class DatoFichero {
    private int posicion;
    private String valor;

    // CONSTRUCTOR
    public DatoFichero(int posicion, String valor) {
        this.posicion = posicion;
        this.valor = valor;
    }
    
    // GETTERS Y SETTERS PARA LOS ATRIBUTOS
    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
}
