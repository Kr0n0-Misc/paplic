package contenedores;

import java.util.LinkedList;
import java.util.Iterator;
import entidades.Cliente;

/**
 * Contenedor Clientes - Singleton
 * 
 * @brief Contenedor de clientes utilizando patrón Singleton
 * @author Kr0n0
 */

public class ContenedorClientesSingleton {
    private static ContenedorClientesSingleton  _instancia;
    private final LinkedList<Cliente> llClientes;
    
    // CONSTRUCTOR Y SINGLETON
    private ContenedorClientesSingleton() {
        llClientes= new LinkedList();
    }
            
    /**
     * getInstance
     * 
     * Devuelve la instancia del singleton o la crea si no existe
     * @return ContenedorArticulosSingleton _instancia
     */
    public static ContenedorClientesSingleton getInstance() {
        if (_instancia==null){
         _instancia= new ContenedorClientesSingleton();
        }
        return _instancia;
    }

    // METODOS PUBLICOS
    /**
     * getClientes
     * 
     * Devuelve la LinkedList de clientes
     * @return llClientes
     */
    public LinkedList<Cliente> getClientes () {
        return llClientes;
    }
    
    /**
     * addCLiente
     * 
     * Añade un cliente a la LinkedList 
     * @param c Cliente
     */
    public void addCliente(Cliente c) {
      llClientes.addLast(c);
    }
    
    /**
     * getNumClientes
     * 
     * Método que devuelve el tamaño de la LinkedList de elementos
     * @return int
     */
    public int getNumClientes(){
        return llClientes.size();
    }
    
    /**
     * getCliente
     * 
     * Devuelve el objeto Cliente del ID pasado como parámetro
     * @param id identificador de cliente
     * @return  cliente si encontrado
     *          null si no encontrado
     */
    public Cliente getCliente(String id) {
        Iterator<Cliente> i;
        Cliente cliente;
        
        // Creamos iterador para ir iterando por la LinkedList
        i = llClientes.iterator();
        // Mientras que haya elementos
        while (i.hasNext()) {
            // Recuperamos el cliente 
            cliente = (Cliente) i.next();
            // Si el ID es igual que el que buscamos, lo devolvemos
            if (id.equalsIgnoreCase(cliente.getsIDCliente())) return cliente;
        }
        // Si no, devolvemos null
        return (null);
    }
    
    /**
     * getPosCliente
     * 
     * Devuelve el cliente que está en la posición i
     * @param i posición del cliente
     * @return Cliente
     */
    public Cliente getPosCliente(int i){
        return llClientes.get(i);
    }
    
    // METODOS TRAZAS
    /**
     * dbgContenedorClientesSingleton
     * 
     * Muestra por consola los datos de los clientes
     */
    public void dbgContenedorClientesSingleton() {
        Iterator<Cliente> i;
        Cliente cliente;
        
        // Creamos iterador para ir iterando por la LinkedList
        i = llClientes.iterator();
        // Mientras que haya elementos
        while (i.hasNext()) {
            // Recuperamos el cliente 
            cliente = (Cliente) i.next();
            // Imprimimos los datos del cliente en System.out
            System.out.println("\n");
            System.out.println("IDCliente : " + cliente.getsIDCliente() 
                    + "\nDNI : " + cliente.getsDNI() 
                    + "\nNombre : " + cliente.getsNombre() 
                    + "\nApellidos : " + cliente.getsApellidos() 
                    + "\nCalle : " + cliente.getsCalle() 
                    + "\nNum : " + cliente.getsNum() 
                    + "\nCodPost : " + cliente.getsCodPost() 
                    + "\nPoblacion : " + cliente.getsPoblacion() 
                    + "\nProvincia : " + cliente.getsProvincia() 
                    + "\nTeléfono : "+cliente.getsTelf() 
            + "\n");
        }
    }
   
}
