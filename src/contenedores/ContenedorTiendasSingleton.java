package contenedores;

import java.util.LinkedList;
import java.util.Iterator;
import entidades.Tienda;

/**
 * Contenedor Tiendas - Singleton
 * 
 * 
 * @brief Contenedor de tiendas en Singleton
 * @author Kr0n0
 * 
 */

public class ContenedorTiendasSingleton {
    private static ContenedorTiendasSingleton  _instancia;
    private final LinkedList<Tienda> llTiendas;
    
    /**********************************************************
    * METODOS CONSTRUCTOR Y SINGLETON
    ***********************************************************/
    /**
     * ContenedorTiendasSingleton()
     * 
     * @brief Constructor de clase
     */
    private ContenedorTiendasSingleton() {
        llTiendas= new LinkedList();
    }
            
    /**
     * getInstance() 
     * 
     * Método estático
     * 
     * @brief Devuelve la instancia del singleton o la crea si no existe
     * @return ContenedorTiendasSingleton _instancia
     */
    public static ContenedorTiendasSingleton getInstance() {
        if (_instancia==null){
         _instancia= new ContenedorTiendasSingleton();
        }
        return _instancia;
    }
 
    /**********************************************************
    * METODOS ESPECIFICOS DE LA CLASE
    ***********************************************************/
    /**
     * getTiendas()
     * 
     * @brief Devuelve la LinkedList de tiendas
     * @return llTiendas
     */
    public LinkedList<Tienda> getTiendas () {
        return llTiendas;
    }
    
     /**
     * addTienda(Tienda t)
     * 
     * @brief Añade una tienda a la LinkedList 
     * @param t Tienda
     */
    public void addTienda(Tienda t) {
        llTiendas.addLast(t);
    }
    
    /**
     * getNumTiendas()
     * 
     * @brief Método que devuelve el tamaño de la LinkedList de tiendas
     * @return int
     */
    public int getNumTiendas(){
        return llTiendas.size();
    }
    
    /**
     * getTienda(String id)
     * 
     * 
     * @brief Devuelve el objeto Tienda del ID pasado como parámetro
     * @param id identificador de tienda
     * @return  tienda si encontrado
     *          null si no encontrado
     */
    public Tienda getTienda(String id) {
        Iterator<Tienda> i;
        Tienda tiAux;
        
        // Creamos iterador para ir iterando por la LinkedList
        i = llTiendas.iterator();
        // Mientras que haya elementos
        while (i.hasNext()) {
            // Recuperamos el artículo 
            tiAux = (Tienda) i.next();
            // Si el ID es igual que el que buscamos, lo devolvemos
            if (id.equalsIgnoreCase(tiAux.getsIDTienda())) return tiAux;
        }
        // Si no, devolvemos null
        return (null);
    }
    
     /**
     * getPosTienda(int i)
     * 
     * @brief Devuelve la tienda que está en la posición i
     * @param i posición de la tienda
     * @return Tienda
     */
    public Tienda getPosTienda(int i){
        return llTiendas.get(i);
    }
    
    /**********************************************************
    * METODOS DE DEBUG / TRAZAS DE LA CLASE
    ***********************************************************/
    
    
    public void dbgContenedorTiendasSingleton() {
        Iterator<Tienda> i;
        Tienda tiAux;
        
        // Creamos iterador para ir iterando por la LinkedList
        i = llTiendas.iterator();
        // Mientras que haya elementos
        while (i.hasNext()) {
            // Recuperamos la tienda 
             tiAux = (Tienda) i.next();
            // Imprimimos los datos de la tienda en System.out
            System.out.println("\n");
            System.out.println("IDTienda : " + tiAux.getsIDTienda() 
                    + "\nCalle : " + tiAux.getsCalle() 
                    + "\nNum : " + tiAux.getsNum() 
                    + "\nCodPost : " + tiAux.getsCodPost() 
                    + "\nTelf : " + tiAux.getsTelf() 
                    + "\nPoblacion : " + tiAux.getsPoblacion() 
                    + "\nProvincia : " + tiAux.getsProvincia()
            + "\n");
        }
    }
    
}
