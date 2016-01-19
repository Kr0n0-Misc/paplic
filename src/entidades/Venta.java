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
   private Almacen aAlmacen;
   private Tienda tTienda;
   private String sIDCliente, sIDAlmacen, sIDTienda;

    /******************************************
    /  Constructor
    *******************************************/
   public Venta() {
       super();
   }

    /*************************************************
    /  Getters y Setters para las clases dependientes
    **************************************************/
    public Cliente getcCliente() {
        return cCliente;
    }

    public void setcCliente(Cliente cCliente) {
        this.cCliente = cCliente;
    }

    public Almacen getaAlmacen() {
        return aAlmacen;
    }

    public void setaAlmacen(Almacen aAlmacen) {
        this.aAlmacen = aAlmacen;
    }

    public Tienda gettTienda() {
        return tTienda;
    }

    public void settTienda(Tienda tTienda) {
        this.tTienda = tTienda;
    }

    public String getsIDCliente() {
        return sIDCliente;
    }

    public void setsIDCliente(String sIDCliente) {
        this.sIDCliente = sIDCliente;
    }

    public String getsIDAlmacen() {
        return sIDAlmacen;
    }

    public void setsIDAlmacen(String sIDAlmacen) {
        this.sIDAlmacen = sIDAlmacen;
    }

    public String getsIDTienda() {
        return sIDTienda;
    }

    public void setsIDTienda(String sIDTienda) {
        this.sIDTienda = sIDTienda;
    }

    
    /******************************************
    /  Getters y Setters para los atributos
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
                this.setsIDAlmacen(valor);
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
