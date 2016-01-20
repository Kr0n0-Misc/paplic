package contenedores;

import java.util.LinkedList;
import java.util.Iterator;
import entidades.Almacen;

/**
 * Contenedor Almacen - Singleton
 * 
 * Contenedor de almacenes utilizando patrón Singleton
 * @author Kr0n0
 */

public class ContenedorAlmacenesSingleton {
    private static ContenedorAlmacenesSingleton  _instancia;
    private final LinkedList<Almacen> llAlmacenes;
    
    // CONSTRUCTOR Y SINGLETON
    private ContenedorAlmacenesSingleton() {
        llAlmacenes= new LinkedList();
    }
            
    /**
     * getInstance
     * 
     * Devuelve la instancia del singleton o la crea si no existe
     * @return ContenedorArticulosSingleton _instancia
     */
    public static ContenedorAlmacenesSingleton getInstance() {
        if (_instancia==null){
         _instancia= new ContenedorAlmacenesSingleton();
        }
        return _instancia;
    }
 
    // METODOS PUBLICOS
    /**
     * getAlmacenes
     * 
     * Devuelve la LinkedList de almacenes
     * @return llArticulos
     */
    public LinkedList<Almacen> getAlmacenes () {
        return llAlmacenes;
    }
    
     /**
     * addAlmacen
     * 
     * Añade un almacen a la LinkedList 
     * @param a Almacen
     */
    public void addAlmacen(Almacen a) {
        llAlmacenes.addLast(a);
    }
    
    /**
     * getNumAlmacenes
     * 
     * Devuelve el tamaño de la LinkedList de almacenes
     * @return int
     */
    public int getNumAlmacenes(){
        return llAlmacenes.size();
    }
    
    /**
     * getAlmace
     * 
     * Devuelve el objeto Almacen del ID pasado como parámetro
     * @param id identificador de almacen
     * @return  almacen si encontrado
     *          null si no encontrado
     */
    public Almacen getAlmacen(String id) {
        Iterator<Almacen> i;
        Almacen almacen;
        
        // Creamos iterador para ir iterando por la LinkedList
        i = llAlmacenes.iterator();
        // Mientras que haya elementos
        while (i.hasNext()) {
            // Recuperamos el artículo 
            almacen = (Almacen) i.next();
            // Si el ID es igual que el que buscamos, lo devolvemos
            if (id.equalsIgnoreCase(almacen.getsIDAlmacen())) return almacen;
        }
        // Si no, devolvemos null
        return (null);
    }
    
     /**
     * getPosAlmacen(int i)
     * 
     * Devuelve el almacen que está en la posición i
     * @param i posición del almacen
     * @return Almacen
     */
    public Almacen getPosAlmacen(int i){
        return llAlmacenes.get(i);
    }
    
    // METODOS TRAZAS
    /**
     * dbgContenedorAlmacenesSingleton
     * 
     * Muestra por consola los datos de los almacenes
     */
    public void dbgContenedorAlmacenesSingleton() {
        Iterator<Almacen> i;
        Almacen almacen;
        
        // Creamos iterador para ir iterando por la LinkedList
        i = llAlmacenes.iterator();
        // Mientras que haya elementos
        while (i.hasNext()) {
            // Recuperamos el almacen 
            almacen = (Almacen) i.next();
            // Mostramos los datos del almacen
            System.out.println("\n");
            System.out.println("IDAlmacen : " + almacen.getsIDAlmacen() 
                    + "\nCalle : " + almacen.getsCalle() 
                    + "\nNum : " + almacen.getsNum() 
                    + "\nCodPost : " + almacen.getsCodPost() 
                    + "\nTelf : " + almacen.getsTelf() 
                    + "\nPoblacion : " + almacen.getsPoblacion() 
                    + "\nProvincia : " + almacen.getsProvincia()
            + "\n");
        }
    }
    
}
