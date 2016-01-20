package contenedores;

import java.util.LinkedList;
import java.util.Iterator;
import entidades.Venta;

/**
 * Contenedor Ventas - Singleton
 * 
 * Contenedor de ventas utilizando patrón Singleton
 * @author Kr0n0
 * 
 */

public class ContenedorVentasSingleton {
    private static ContenedorVentasSingleton  _instancia;
    private final LinkedList<Venta> llVentas;
    
    // CONSTRUCTOR Y SINGLETON
    private ContenedorVentasSingleton() {
        llVentas= new LinkedList();
    }

    /**
     * getInstance() 
     * 
     * Devuelve la instancia del singleton o la crea si no existe
     * @return ContenedorArticulosSingleton _instancia
     */
    public static ContenedorVentasSingleton getInstance() {
        if (_instancia==null){
         _instancia= new ContenedorVentasSingleton();
        }
        return _instancia;
    }
 
    // METODOS PUBLICOS
    /**
     * getVentas
     * 
     * Devuelve la LinkedList de ventas
     * @return llVentas
     */
    public LinkedList<Venta> getVentas () {
        return llVentas;
    }
    
     /**
     * addVenta
     * 
     * Añade una venta a la LinkedList 
     * @param v Venta
     */
    public void addVenta(Venta v) {
        llVentas.addLast(v);
    }
    
    /**
     * getNumVentas
     * 
     * Método que devuelve el tamaño de la LinkedList de ventas
     * @return int
     */
    public int getNumVentas(){
        return llVentas.size();
    }
    
    /**
     * getVenta
     * 
     * Devuelve el objeto Venta del ID pasado como parámetro
     * @param id identificador de venta
     * @return  venta si encontrado
     *          null si no encontrado
     */
    public Venta getVenta(String id) {
        Iterator<Venta> i;
        Venta venta;
        
        // Creamos iterador para ir iterando por la LinkedList
        i = llVentas.iterator();
        // Mientras que haya elementos
        while (i.hasNext()) {
            // Recuperamos la venta 
            venta = (Venta) i.next();
            // Si el ID es igual que el que buscamos, lo devolvemos
            if (id.equalsIgnoreCase(venta.getsIDVenta())) return venta;
        }
        // Si no, devolvemos null
        return (null);
    }
    
     /**
     * getPostVenta
     * 
     * Devuelve la venta que está en la posición i
     * @param i posición de la venta
     * @return Venta
     */
    public Venta getPosVenta(int i){
        return llVentas.get(i);
    }
    
    // METODOS TRAZAS
    /**
     * dbgContenedorVentasSingleton
     * 
     * Muestra por consola los datos de las ventas
     */
    public void dbgContenedorVentasSingleton() {
        Iterator<Venta> i;
        Venta venta;
        
        // Creamos iterador para ir iterando por la LinkedList
        i = llVentas.iterator();
        // Mientras que haya elementos
        while (i.hasNext()) {
            // Recuperamos la venta 
             venta = (Venta) i.next();
            // Imprimimos los datos de la venta en System.out
            // NOTA : Los datos de Cliente, Almacen y Tienda los recogemos de los objetos dependientes
            System.out.println("\n");
            System.out.println("IDVenta : " + venta.getsIDVenta() 
                    /**
                    + "\nIDCliente : " + venta.getcCliente().getsIDCliente() 
                    + "\nIDAlmacen : " + venta.getaAlmacen().getsIDAlmacen() 
                    + "\nIDTienda : " + venta.gettTienda().getsIDTienda() 
                    */
                    + "\nIDCliente : " + venta.getsIDCliente()
                    + "\nIDArticulo : " + venta.getsIDArticulo()
                    + "\nIDTienda : " + venta.getsIDTienda()
                    + "\nUnidades : " + venta.getsUnidades() 
                    + "\nImporte : " + venta.getsImporte() 
                    + "\nFecha : " + venta.getsFecha()
            + "\n");
        }
    }
}
