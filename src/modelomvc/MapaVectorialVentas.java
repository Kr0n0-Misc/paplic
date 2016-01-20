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
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

// NOTA Implementa IMapaRepresentarAsociacion para poder pasar como parametros entidad y entidad2!!
public class MapaVectorialVentas extends MapaVectorialBase implements IMapaRepresentarAsociacion {

    public MapaVectorialVentas() {
        super();
        //incializar contexto de dibujo
       grafico2d.setPaint(Color.red);//color de la línea rojo
    }

    // Añadimos segunda entidad para representar ventas entre los dos puntos
    // NOTA : geometrias es LinkedList<Shape>, por lo que los puntos no pueden
    // añadirse
    @Override
    public boolean representar(EntidadGeo entidad, EntidadGeo entidad2) {
        // Crear tipo de geometría  y asignar posición (x,y)        
        // Rectangulos
        Rectangle cuadrado1 = new Rectangle(entidad.getX(),entidad.getY(), 10, 10);
        Rectangle cuadrado2 = new Rectangle(entidad2.getX(), entidad2.getY(), 10, 10);
        // Puntos
        Point2D punto1 = new Point2D.Float(entidad.getX(), entidad.getY());
        Point2D punto2 = new Point2D.Float(entidad2.getX(), entidad2.getY());
        // Linea entre puntos
        Line2D linea = new Line2D.Float(punto1,punto2);
        
        geometrias.add(cuadrado1);
        geometrias.add(cuadrado2);
       // geometrias.add(punto1);
       // geometrias.add(punto2);
        geometrias.add(linea);
        
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
