package contenedores;

import java.util.LinkedList;
import java.util.Iterator;
import entidades.Articulo;

/**
 * Contenedor Artículos - Singleton
 * 
 * @brief Contenedor de artículos utilizando patrón Singleton
 * @author Kr0n0
 */

public class ContenedorArticulosSingleton {
    private static ContenedorArticulosSingleton  _instancia;
    private final LinkedList<Articulo> llArticulos;
    
    // CONSTRUCTOR Y SINGLETON
    private ContenedorArticulosSingleton() {
        llArticulos= new LinkedList();
    }
            
    /**
     * getInstance
     * 
     * Devuelve la instancia del singleton o la crea si no existe
     * @return ContenedorArticulosSingleton _instancia
     */
    public static ContenedorArticulosSingleton getInstance() {
        if (_instancia==null){
         _instancia= new ContenedorArticulosSingleton();
        }
        return _instancia;
    }
 
    // METODOS PUBLICOS
    /**
     * getArticulos
     * 
     * Devuelve la LinkedList de artículos
     * @return llArticulos
     */
    public LinkedList<Articulo> getArticulos () {
        return llArticulos;
    }
    
     /**
     * addArticulo
     * 
     * Añade un art`ículo a la LinkedList 
     * @param a Articulo
     */
    public void addArticulo(Articulo a) {
        llArticulos.addLast(a);
    }
    
    /**
     * getNumArticulos
     * 
     * Devuelve el tamaño de la LinkedList de elementos
     * @return int
     */
    public int getNumArticulos(){
        return llArticulos.size();
    }
    
    /**
     * getArticulo
     * 
     * Devuelve el objeto Artículo del ID pasado como parámetro
     * @param id identificador de artículo
     * @return  artículo si encontrado
     *          null si no encontrado
     */
    public Articulo getArticulo(String id) {
        Iterator<Articulo> i;
        Articulo articulo;
        
        // Creamos iterador para ir iterando por la LinkedList
        i = llArticulos.iterator();
        // Mientras que haya elementos
        while (i.hasNext()) {
            // Recuperamos el artículo 
            articulo = (Articulo) i.next();
            // Si el ID es igual que el que buscamos, lo devolvemos
            if (id.equalsIgnoreCase(articulo.getsIDArticulo())) return articulo;
        }
        // Si no, devolvemos null
        return (null);
    }
    
     /**
     * getPosArticulo
     * 
     * Devuelve el artículo que está en la posición i
     * @param i posición del artículo
     * @return Artículo
     */
    public Articulo getPosArticulo(int i){
        return llArticulos.get(i);
    }
    
    // METODOS TRAZAS
    /**
     * dbgContenedorArticulosSingleton
     * 
     * Muestra por consola los datos de los articulos
     */
    public void dbgContenedorArticulosSingleton() {
        Iterator<Articulo> i;
        Articulo articulo;
        
        // Creamos iterador para ir iterando por la LinkedList
        i = llArticulos.iterator();
        // Mientras que haya elementos
        while (i.hasNext()) {
            // Recuperamos el artículo 
            articulo = (Articulo) i.next();
            // Imprimimos los datos del artículo en System.out
            System.out.println("\n");
            System.out.println("IDArticulo : " + articulo.getsIDArticulo() 
                    + "\nCategoria : " + articulo.getsCategoria() 
                    + "\nPrecio : " + articulo.getsPrecio() 
                    + "\nFichaTecnica : " + articulo.getsFichaTecnica() 
                    + "\nDescripcion : " + articulo.getsDescripcion()
            + "\n");
        }
    }
    
}
