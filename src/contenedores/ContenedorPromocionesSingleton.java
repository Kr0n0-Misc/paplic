package contenedores;

import java.util.LinkedList;
import java.util.Iterator;
import entidades.Promocion;

/**
 * Contenedor Promociones - Singleton
 * 
 * 
 * @brief Contenedor de promociones en Singleton
 * @author Kr0n0
 * 
 */

public class ContenedorPromocionesSingleton {
    private static ContenedorPromocionesSingleton  _instancia;
    private final LinkedList<Promocion> llPromociones;
    
    /**********************************************************
    * METODOS CONSTRUCTOR Y SINGLETON
    ***********************************************************/
    /**
     * ContenedorPromocionesSingleton()
     * 
     * @brief Constructor de clase
     */
    private ContenedorPromocionesSingleton() {
        llPromociones= new LinkedList();
    }
            
    /**
     * getInstance() 
     * 
     * Método estático
     * 
     * @brief Devuelve la instancia del singleton o la crea si no existe
     * @return ContenedorPromocionesSingleton _instancia
     */
    public static ContenedorPromocionesSingleton getInstance() {
        if (_instancia==null){
         _instancia= new ContenedorPromocionesSingleton();
        }
        return _instancia;
    }
 
    /**********************************************************
    * METODOS ESPECIFICOS DE LA CLASE
    ***********************************************************/
    /**
     * getPromociones()
     * 
     * @brief Devuelve la LinkedList de promociones
     * @return llPromociones
     */
    public LinkedList<Promocion> getPromociones () {
        return llPromociones;
    }
    
     /**
     * addPromocion(Promocion p)
     * 
     * @brief Añade una promocion a la LinkedList 
     * @param p Promocion
     */
    public void addPromocion(Promocion p) {
        llPromociones.addLast(p);
    }
    
    /**
     * getNumPromociones()
     * 
     * @brief Método que devuelve el tamaño de la LinkedList de promociones
     * @return int
     */
    public int getNumPromociones(){
        return llPromociones.size();
    }
    
    /**
     * getPromocion(String id)
     * 
     * 
     * @brief Devuelve el objeto Promocion del ID pasado como parámetro
     * @param id identificador de promocion
     * @return  promocion si encontrado
     *          null si no encontrado
     */
    public Promocion getPromocion(String id) {
        Iterator<Promocion> i;
        Promocion prAux;
        
        // Creamos iterador para ir iterando por la LinkedList
        i = llPromociones.iterator();
        // Mientras que haya elementos
        while (i.hasNext()) {
            // Recuperamos el artículo 
            prAux = (Promocion) i.next();
            // Si el ID es igual que el que buscamos, lo devolvemos
            if (id.equalsIgnoreCase(prAux.getsIDPromocion())) return prAux;
        }
        // Si no, devolvemos null
        return (null);
    }
    
     /**
     * getPosPromocion(int i)
     * 
     * @brief Devuelve la promoción que está en la posición i
     * @param i posición de la promoción
     * @return Promocion
     */
    public Promocion getPosPromocion(int i){
        return llPromociones.get(i);
    }
    
    /**********************************************************
    * METODOS DE DEBUG / TRAZAS DE LA CLASE
    ***********************************************************/
    
    public void dbgContenedorPromocionesSingleton() {
        Iterator<Promocion> i;
        Promocion prAux;
        
        // Creamos iterador para ir iterando por la LinkedList
        i = llPromociones.iterator();
        // Mientras que haya elementos
        while (i.hasNext()) {
            // Recuperamos la promoción 
            prAux = (Promocion) i.next();
            // Imprimimos los datos de la promoción en System.out
            System.out.println("\n");
            System.out.println("IDPromocion : " + prAux.getsIDPromocion() 
                    + "\nDescuento : " + prAux.getsDescuento()
            + "\n");
        }
    }
    
}
