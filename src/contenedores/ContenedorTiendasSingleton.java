package contenedores;

import java.util.LinkedList;
import java.util.Iterator;
import entidades.Tienda;

/**
 * Contenedor Tiendas - Singleton
 * 
 * @brief Contenedor de tiendas utilizando patrón Singleton
 * @author Kr0n0
 */

public class ContenedorTiendasSingleton {
    private static ContenedorTiendasSingleton  _instancia;
    private final LinkedList<Tienda> llTiendas;
    
    // CONSTRUCTOR Y SINGLETON
    private ContenedorTiendasSingleton() {
        llTiendas= new LinkedList();
    }

    /**
     * getInstance() 
     * 
     * Devuelve la instancia del singleton o la crea si no existe
     * @return ContenedorArticulosSingleton _instancia
     */
    public static ContenedorTiendasSingleton getInstance() {
        if (_instancia==null){
         _instancia= new ContenedorTiendasSingleton();
        }
        return _instancia;
    }
 
    // METODOS PUBLICOS
    /**
     * getTiendas
     * 
     * Devuelve la LinkedList de tiendas
     * @return llTiendas
     */
    public LinkedList<Tienda> getTiendas () {
        return llTiendas;
    }
    
     /**
     * addTienda
     * 
     * @brief Añade una tienda a la LinkedList 
     * @param t Tienda
     */
    public void addTienda(Tienda t) {
        llTiendas.addLast(t);
    }
    
    /**
     * getNumTiendas
     * 
     * Método que devuelve el tamaño de la LinkedList de tiendas
     * @return int
     */
    public int getNumTiendas(){
        return llTiendas.size();
    }
    
    /**
     * getTienda
     * 
     * Devuelve el objeto Tienda del ID pasado como parámetro
     * @param id identificador de tienda
     * @return  tienda si encontrado
     *          null si no encontrado
     */
    public Tienda getTienda(String id) {
        Iterator<Tienda> i;
        Tienda tienda;
        
        // Creamos iterador para ir iterando por la LinkedList
        i = llTiendas.iterator();
        // Mientras que haya elementos
        while (i.hasNext()) {
            // Recuperamos el artículo 
            tienda = (Tienda) i.next();
            // Si el ID es igual que el que buscamos, lo devolvemos
            if (id.equalsIgnoreCase(tienda.getsIDTienda())) return tienda;
        }
        // Si no, devolvemos null
        return (null);
    }
    
     /**
     * getPosTienda
     * 
     * Devuelve la tienda que está en la posición i
     * @param i posición de la tienda
     * @return Tienda
     */
    public Tienda getPosTienda(int i){
        return llTiendas.get(i);
    }
    
    // METODOS TRAZAS
    /**
     * dbgContenedorTiendasSingleton
     * 
     * Muestra por consola los datos de las tiendas
     */
    public void dbgContenedorTiendasSingleton() {
        Iterator<Tienda> i;
        Tienda tienda;
        
        // Creamos iterador para ir iterando por la LinkedList
        i = llTiendas.iterator();
        // Mientras que haya elementos
        while (i.hasNext()) {
            // Recuperamos la tienda 
             tienda = (Tienda) i.next();
            // Imprimimos los datos de la tienda en System.out
            System.out.println("\n");
            System.out.println("IDTienda : " + tienda.getsIDTienda() 
                    + "\nCalle : " + tienda.getsCalle() 
                    + "\nNum : " + tienda.getsNum() 
                    + "\nCodPost : " + tienda.getsCodPost() 
                    + "\nTelf : " + tienda.getsTelf() 
                    + "\nPoblacion : " + tienda.getsPoblacion() 
                    + "\nProvincia : " + tienda.getsProvincia()
            + "\n");
        }
    }
    
}
