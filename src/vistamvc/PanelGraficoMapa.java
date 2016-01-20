/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vistamvc;

import java.awt.Graphics;
import javax.swing.JPanel;
import modelomvc.MapaVectorialAlmacenes;
import modelomvc.MapaVectorialBase;
import modelomvc.MapaVectorialClientes;
import modelomvc.MapaVectorialVentas;


public class PanelGraficoMapa extends JPanel{
    //asociación de sólo lectura con el modelo 
    MapaVectorialBase mapa;    
    
    // Sobrecargamos para los tres diferentes paneles que tenemos
    // CLIENTES
    public PanelGraficoMapa(MapaVectorialClientes mapa){
        this.mapa=mapa;   
    }
    
    // ALMACENES
    public PanelGraficoMapa(MapaVectorialAlmacenes mapa){
        this.mapa=mapa;   
    }
    
    // VENTAS
    public PanelGraficoMapa(MapaVectorialVentas mapa){
        this.mapa=mapa;   
    }
    
    // OVERRIDE A METODO PAINT DE LA CLASE JPANEL
    @Override
    public void paint(Graphics g) {
         //actualizacion de la vista y acceso al modelo     
        g.drawImage(mapa.getImagen(), 0, 0, this);
    }

}
