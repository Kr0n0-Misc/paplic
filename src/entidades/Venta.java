package entidades;

/**
 * Entidad Venta
 * 
 * Formato fichero : 
 *  IDV:IDC:IDA:IDT:UNIDADES:IMPORTE:FECHA
 * 
 * @author Kr0n0
 * 
 */

public class Venta extends EntidadGeo {
   //private String sIDAlmacen, sCalle, sNum, sCodPost, sTelf, sPoblacion, sProvincia;
   private String sIDVenta, sUnidades, sImporte, sFecha;
   private Cliente cCliente;
   private Articulo aArticulo;
   private Tienda tTienda;
   private String sIDCliente, sIDArticulo, sIDTienda;

    /******************************************
    /  Constructor
    *******************************************/
   public Venta() {
       super();
   }

   // Constructor para crear Tienda, Cliente y Producto dependientes
   public Venta(Tienda tienda, Cliente cliente, Articulo articulo) {
       this.setsIDTienda(tienda.getsIDTienda());
       this.setsIDCliente(cliente.getsIDCliente());
       this.setsIDArticulo(articulo.getsIDArticulo());
   }

    /*************************************************
    /  Getters y Setters para las clases dependientes
    **************************************************/
   // CLIENTE
    public Cliente getcCliente() {
        return cCliente;
    }

    public void setcCliente(Cliente cCliente) {
        this.cCliente = cCliente;
    }

    public String getsIDCliente() {
        return sIDCliente;
    }

    public void setsIDCliente(String sIDCliente) {
        this.sIDCliente = sIDCliente;
    }
    
    // ARTICULO
    public Articulo getaArticulo() {
        return aArticulo;
    }

    public void setaArticulo(Articulo aArticulo) {
        this.aArticulo = aArticulo;
    }

    public String getsIDArticulo() {
        return sIDArticulo;
    }

    public void setsIDArticulo(String sIDArticulo) {
        this.sIDArticulo = sIDArticulo;
    }
    
    // TIENDA
    public Tienda gettTienda() {
        return tTienda;
    }

    public void settTienda(Tienda tTienda) {
        this.tTienda = tTienda;
    }

    public String getsIDTienda() {
        return sIDTienda;
    }

    public void setsIDTienda(String sIDTienda) {
        this.sIDTienda = sIDTienda;
    }

    
    /******************************************
    /  Getters y Setters para resto de atributos
    *******************************************/
    public String getsIDVenta() {
        return sIDVenta;
    }

    public void setsIDVenta(String sIDVenta) {
        this.sIDVenta = sIDVenta;
    }

    public String getsUnidades() {
        return sUnidades;
    }

    public void setsUnidades(String sUnidades) {
        this.sUnidades = sUnidades;
    }

    public String getsImporte() {
        return sImporte;
    }

    public void setsImporte(String sImporte) {
        this.sImporte = sImporte;
    }

    public String getsFecha() {
        return sFecha;
    }

    public void setsFecha(String sFecha) {
        this.sFecha = sFecha;
    }
   
    /**
     * setValoresVenta
     * 
     * @brief Establece los valores de los datos de la venta segun posicion 
     * @param valor
     * @param posicion 
     */
    public void setValoresVenta (String valor, int posicion) {
        switch (posicion) {
            case 0 : //IDV
                this.setsIDVenta(valor);
                break;
            case 1 : //IDC
                this.setsIDCliente(valor);
                break;
            case 2 : //IDA
                this.setsIDArticulo(valor);
                break;
            case 3 : //IDT
                this.setsIDTienda(valor);
                break;
            case 4 : //UNIDADES
                this.setsUnidades(valor);
                break;
            case 5 : //IMPORTE
                this.setsImporte(valor);
                break;
            case 6 : //FECHA
                this.setsFecha(valor);
                break;
            default:
                System.out.println("setValoresVenta - Posicion Inválida");
        }
    }
    
}
