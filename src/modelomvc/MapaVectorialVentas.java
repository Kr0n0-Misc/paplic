/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelomvc;

import entidades.EntidadGeo;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


public class MapaVectorialVentas extends MapaVectorialBase implements IMapaRepresentarEntidad {

    public MapaVectorialVentas() {
        super();
        //incializar contexto de dibujo
       grafico2d.setPaint(Color.red);//color de la línea rojo
    }

    @Override
    public boolean representar(EntidadGeo entidad) {
        // Crear tipo de geometría  y asignar posición (x,y)        
        Rectangle cuadrado1 = new Rectangle(entidad.getX(),entidad.getY(), 10, 10);
        geometrias.add(cuadrado1);
        return true;
    }

    @Override
    public void generarGrafico() {
        //Por cada geometria operación draw en la coordenadas asinadas
        Iterator itGeometrias;
        itGeometrias = geometrias.iterator();
        while (itGeometrias.hasNext()) grafico2d.draw((Rectangle)itGeometrias.next());
        /*
        Rectangle cuadrado1 = new Rectangle(20,20, 20, 20);        
        grafico2d.draw(cuadrado1);
        */
    }
}
