package contenedores;

import java.util.LinkedList;
import java.util.Iterator;
import entidades.Venta;

/**
 * Contenedor Ventas - Singleton
 * 
 * 
 * @brief Contenedor de ventas en Singleton
 * @author Kr0n0
 * 
 */

public class ContenedorVentasSingleton {
    private static ContenedorVentasSingleton  _instancia;
    private final LinkedList<Venta> llVentas;
    
    /**********************************************************
    * METODOS CONSTRUCTOR Y SINGLETON
    ***********************************************************/
    /**
     * ContenedorVentasSingleton()
     * 
     * @brief Constructor de clase
     */
    private ContenedorVentasSingleton() {
        llVentas= new LinkedList();
    }

    /**
     * getInstance() 
     * 
     * Método estático
     * 
     * @brief Devuelve la instancia del singleton o la crea si no existe
     * @return ContenedorVentasSingleton _instancia
     */
    public static ContenedorVentasSingleton getInstance() {
        if (_instancia==null){
         _instancia= new ContenedorVentasSingleton();
        }
        return _instancia;
    }
 
    /**********************************************************
    * METODOS ESPECIFICOS DE LA CLASE
    ***********************************************************/
    /**
     * getVentas()
     * 
     * @brief Devuelve la LinkedList de ventas
     * @return llVentas
     */
    public LinkedList<Venta> getVe3ntas () {
        return llVentas;
    }
    
     /**
     * addVenta(Venta v)
     * 
     * @brief Añade una venta a la LinkedList 
     * @param v Venta
     */
    public void addVenta(Venta v) {
        llVentas.addLast(v);
    }
    
    /**
     * getNumVentas()
     * 
     * @brief Método que devuelve el tamaño de la LinkedList de ventas
     * @return int
     */
    public int getNumVentas(){
        return llVentas.size();
    }
    
    /**
     * getVenta(String id)
     * 
     * 
     * @brief Devuelve el objeto Venta del ID pasado como parámetro
     * @param id identificador de venta
     * @return  venta si encontrado
     *          null si no encontrado
     */
    public Venta getVenta(String id) {
        Iterator<Venta> i;
        Venta veAux;
        
        // Creamos iterador para ir iterando por la LinkedList
        i = llVentas.iterator();
        // Mientras que haya elementos
        while (i.hasNext()) {
            // Recuperamos la venta 
            veAux = (Venta) i.next();
            // Si el ID es igual que el que buscamos, lo devolvemos
            if (id.equalsIgnoreCase(veAux.getsIDVenta())) return veAux;
        }
        // Si no, devolvemos null
        return (null);
    }
    
     /**
     * getPostVenta(int i)
     * 
     * @brief Devuelve la venta que está en la posición i
     * @param i posición de la venta
     * @return Venta
     */
    public Venta getPosVenta(int i){
        return llVentas.get(i);
    }
    
    /**********************************************************
    * METODOS DE DEBUG / TRAZAS DE LA CLASE
    ***********************************************************/
    
    public void dbgContenedorVentasSingleton() {
        Iterator<Venta> i;
        Venta veAux;
        
        // Creamos iterador para ir iterando por la LinkedList
        i = llVentas.iterator();
        // Mientras que haya elementos
        while (i.hasNext()) {
            // Recuperamos la venta 
             veAux = (Venta) i.next();
            // Imprimimos los datos de la venta en System.out
            // NOTA : Los datos de Cliente, Almacen y Tienda los recogemos de los objetos dependientes
            System.out.println("\n");
            System.out.println("IDVenta : " + veAux.getsIDVenta() 
                    + "\nIDCliente : " + veAux.getcCliente().getsIDCliente() 
                    + "\nIDAlmacen : " + veAux.getaAlmacen().getsIDAlmacen() 
                    + "\nIDTienda : " + veAux.gettTienda().getsIDTienda() 
                    + "\nUnidades : " + veAux.getsUnidades() 
                    + "\nImporte : " + veAux.getsImporte() 
                    + "\nFecha : " + veAux.getsFecha()
            + "\n");
        }
    }
    
}
