package contenedores;

import java.util.LinkedList;
import java.util.Iterator;
import entidades.Promocion;

/**
 * Contenedor Promociones - Singleton
 * 
 * Contenedor de promociones utilizando patrón Singleton
 * @author Kr0n0
 */

public class ContenedorPromocionesSingleton {
    private static ContenedorPromocionesSingleton  _instancia;
    private final LinkedList<Promocion> llPromociones;
    
    // CONSTRUCTOR Y SINGLETON
    private ContenedorPromocionesSingleton() {
        llPromociones= new LinkedList();
    }
            
    /**
     * getInstance
     * 
     * Devuelve la instancia del singleton o la crea si no existe
     * @return ContenedorArticulosSingleton _instancia
     */
    public static ContenedorPromocionesSingleton getInstance() {
        if (_instancia==null){
         _instancia= new ContenedorPromocionesSingleton();
        }
        return _instancia;
    }
 
    // METODOS PUBLICOS
    /**
     * getPromociones
     * 
     * Devuelve la LinkedList de promociones
     * @return llPromociones
     */
    public LinkedList<Promocion> getPromociones () {
        return llPromociones;
    }
    
     /**
     * addPromocion
     * 
     * Añade una promocion a la LinkedList 
     * @param p Promocion
     */
    public void addPromocion(Promocion p) {
        llPromociones.addLast(p);
    }
    
    /**
     * getNumPromociones
     * 
     * Método que devuelve el tamaño de la LinkedList de promociones
     * @return int
     */
    public int getNumPromociones(){
        return llPromociones.size();
    }
    
    /**
     * getPromocion
     * 
     * Devuelve el objeto Promocion del ID pasado como parámetro
     * @param id identificador de promocion
     * @return  promocion si encontrado
     *          null si no encontrado
     */
    public Promocion getPromocion(String id) {
        Iterator<Promocion> i;
        Promocion promocion;
        
        // Creamos iterador para ir iterando por la LinkedList
        i = llPromociones.iterator();
        // Mientras que haya elementos
        while (i.hasNext()) {
            // Recuperamos el artículo 
            promocion = (Promocion) i.next();
            // Si el ID es igual que el que buscamos, lo devolvemos
            if (id.equalsIgnoreCase(promocion.getsIDPromocion())) return promocion;
        }
        // Si no, devolvemos null
        return (null);
    }
    
     /**
     * getPosPromocion
     * 
     * Devuelve la promoción que está en la posición i
     * @param i posición de la promoción
     * @return Promocion
     */
    public Promocion getPosPromocion(int i){
        return llPromociones.get(i);
    }
    
    // METODOS TRAZAS
    /**
     * dbgContenedorClientesSingleton
     * 
     * Muestra por consola los datos de las promociones
     */
    public void dbgContenedorPromocionesSingleton() {
        Iterator<Promocion> i;
        Promocion promocion;
        
        // Creamos iterador para ir iterando por la LinkedList
        i = llPromociones.iterator();
        // Mientras que haya elementos
        while (i.hasNext()) {
            // Recuperamos la promoción 
            promocion = (Promocion) i.next();
            // Imprimimos los datos de la promoción en System.out
            System.out.println("\n");
            System.out.println("IDPromocion : " + promocion.getsIDPromocion() 
                    + "\nDescuento : " + promocion.getsDescuento()
            + "\n");
        }
    }
    
}
