/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 * DatoFichero
 * 
 * @brief Clase para gestionar cada dato dentro de una Linea de fichero.
 *        Controlamos posicion y valor para registrar en los contenedores
 * @author Kr0n0
 */
public class DatoFichero {
    private int posicion;
    private String valor;

    /******************************************
    /  Constructor
    *******************************************/
    public DatoFichero(int posicion, String valor) {
        this.posicion = posicion;
        this.valor = valor;
    }
    
    /******************************************
    /  Getters y Setters para los atributos
    *******************************************/
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
