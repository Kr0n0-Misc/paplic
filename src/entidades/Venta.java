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
   
}
