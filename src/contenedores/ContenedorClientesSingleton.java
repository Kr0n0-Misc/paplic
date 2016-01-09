package contenedores;




import entidades.Cliente;
import java.util.LinkedList;


public class ContenedorClientesSingleton {
    
    private static ContenedorClientesSingleton  _instancia;
    private LinkedList<Cliente> coleccionElementos;
    
    private  ContenedorClientesSingleton() {
    coleccionElementos= new LinkedList();
    }
            
    public static ContenedorClientesSingleton getInstance() {
        if (_instancia==null){
         _instancia= new ContenedorClientesSingleton();
        }
        return _instancia;
    }
    public int size(){
     return coleccionElementos.size();
    }
    public Cliente getElemento(int i){

     return coleccionElementos.get(i);
    }
    
}
