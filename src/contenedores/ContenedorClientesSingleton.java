package contenedores;

import java.util.LinkedList;
import java.util.Iterator;
import entidades.Cliente;

/**
 * Contenedor Clientes - Singleton
 * 
 * 
 * @brief Contenedor de clientes en Singleton
 * @author Kr0n0
 * 
 */

public class ContenedorClientesSingleton {
    private static ContenedorClientesSingleton  _instancia;
    private final LinkedList<Cliente> llClientes;
    
    /**********************************************************
    * METODOS CONSTRUCTOR Y SINGLETON
    ***********************************************************/
    
    /**
     * ContenedorClientesSingleton()
     * 
     * @brief Constructor de clase
     */
    private ContenedorClientesSingleton() {
        llClientes= new LinkedList();
    }
            
    /**
     * getInstance() 
     * 
     * Método estático
     * 
     * @brief Devuelve la instancia del singleton o la crea si no existe
     * @return ContenedorClientesSingleton _instancia
     */
    public static ContenedorClientesSingleton getInstance() {
        if (_instancia==null){
         _instancia= new ContenedorClientesSingleton();
        }
        return _instancia;
    }
    
    /**********************************************************
    * METODOS ESPECIFICOS DE LA CLASE
    ***********************************************************/

    /**
     * getClientes()
     * 
     * @brief Devuelve la LinkedList de clientes
     * @return llClientes
     */
    public LinkedList<Cliente> getClientes () {
        return llClientes;
    }
    
    /**
     * addCLiente(Cliente c)
     * 
     * @brief Añade un cliente a la LinkedList 
     * @param c Cliente
     */
    public void addCliente(Cliente c) {
      llClientes.addLast(c);
    }
    
    /**
     * getNumClientes()
     * 
     * @brief Método que devuelve el tamaño de la LinkedList de elementos
     * @return int
     */
    public int getNumClientes(){
        return llClientes.size();
    }
    
    /**
     * getCliente(String id)
     * 
     * 
     * @brief Devuelve el objeto Cliente del ID pasado como parámetro
     * @param id identificador de cliente
     * @return  cliente si encontrado
     *          null si no encontrado
     */
    public Cliente getCliente(String id) {
        Iterator<Cliente> i;
        Cliente clAux;
        
        // Creamos iterador para ir iterando por la LinkedList
        i = llClientes.iterator();
        // Mientras que haya elementos
        while (i.hasNext()) {
            // Recuperamos el cliente 
            clAux = (Cliente) i.next();
            // Si el ID es igual que el que buscamos, lo devolvemos
            if (id.equalsIgnoreCase(clAux.getsIDCliente())) return clAux;
        }
        // Si no, devolvemos null
        return (null);
    }
    
    /**
     * getPosCliente(int i)
     * 
     * @brief Devuelve el cliente que está en la posición i
     * @param i posición del cliente
     * @return Cliente
     */
    public Cliente getPosCliente(int i){
        return llClientes.get(i);
    }
    
    /**********************************************************
    * METODOS DE DEBUG / TRAZAS DE LA CLASE
    ***********************************************************/

    public void dbgContenedorClientesSingleton() {
        Iterator<Cliente> i;
        Cliente clAux;
        
        // Creamos iterador para ir iterando por la LinkedList
        i = llClientes.iterator();
        // Mientras que haya elementos
        while (i.hasNext()) {
            // Recuperamos el cliente 
            clAux = (Cliente) i.next();
            // Imprimimos los datos del cliente en System.out
            System.out.println("\n");
            System.out.println("IDCliente : " + clAux.getsIDCliente() 
                    + "\nDNI : " + clAux.getsDNI() 
                    + "\nNombre : " + clAux.getsNombre() 
                    + "\nApellidos : " + clAux.getsApellidos() 
                    + "\nCalle : " + clAux.getsCalle() 
                    + "\nNum : " + clAux.getsNum() 
                    + "\nCodPost : " + clAux.getsCodPost() 
                    + "\nPoblacion : " + clAux.getsPoblacion() 
                    + "\nProvincia : " + clAux.getsProvincia() 
                    + "\nTeléfono : "+clAux.getsTelf() 
            + "\n");
        }
    }
   
}
