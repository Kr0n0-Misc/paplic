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
    protected LinkedList<Line2D> llLineas; //Lineas
    protected LinkedList<Shape> llTiendas; //Tiendas
    protected Shape sCliente, sTienda; // Shapes
    
    public MapaVectorialVentas() {
        super();
        llLineas = new LinkedList<>();
        llTiendas = new LinkedList<>();
        //incializar contexto de dibujo
        //grafico2d.setPaint(Color.red);//color de la línea rojo
    }

    // Añadimos segunda entidad para representar ventas entre los dos puntos
    //  geometrias -> LinkedList<Shape> básica para Clientes
    //  llTiendas -> LinkedList<Shape> básica para Tiendas
    //  llLineas -> LinkedList<Line2D> básica para Lineas
    //  DEFINIMOS DOS LINKEDLIST DE SHAPE PARA PODER TRATARLOS DE MANERA DIFERENTE EN COLOR
    //
    // NOTA : geometrias es LinkedList<Shape>, por lo que los puntos no pueden
    // añadirse y es necesario crear una nueva
    @Override
    public boolean representar(EntidadGeo entidad, EntidadGeo entidad2) {
        // Crear tipo de geometría  y asignar posición (x,y)        
        // Rectangulos
        Rectangle rCliente = new Rectangle(entidad.getX(),entidad.getY(), 10, 10);
        Rectangle rTienda = new Rectangle(entidad2.getX(), entidad2.getY(), 10, 10);
        // Puntos
        Point2D punto1 = new Point2D.Float(entidad.getX(), entidad.getY());
        Point2D punto2 = new Point2D.Float(entidad2.getX(), entidad2.getY());
        // Linea entre puntos
        Line2D linea = new Line2D.Float(punto1,punto2);
        
        geometrias.add(rCliente);
        llTiendas.add(rTienda);
//        geometrias.add(punto1);
//        geometrias.add(punto2);
        llLineas.add(linea);
        
        return true;
    }

    @Override
    public void generarGrafico() {
        //Por cada geometria operación draw en la coordenadas asinadas
        Iterator itGeometrias, itTiendas, itLineas;
        itGeometrias = geometrias.iterator();
        itTiendas = llTiendas.iterator();
        itLineas = llLineas.iterator();    
        
        // Dibujamos las lineas primero (azul)
        grafico2d.setColor(Color.blue);
        while (itLineas.hasNext())
            grafico2d.draw((Line2D)itLineas.next());
        
        // Dibujamos los clientes despues (rojo con fill)
        grafico2d.setColor(Color.red);
        while (itGeometrias.hasNext()) {
            // Recogemos el objeto
            sCliente = (Shape)itGeometrias.next();
            // Dibujamos y rellenamos
            grafico2d.draw(sCliente);
            grafico2d.fill(sCliente);
        }
        
        // Dibujamos por ultimo las tiendas (verde con fill)
        grafico2d.setColor(Color.green);
        while (itTiendas.hasNext()) {
            // Recogemos el objeto
            sTienda = (Shape) itTiendas.next();
            // Dibujamos y rellenamos
            grafico2d.draw(sTienda);
            grafico2d.fill(sTienda);
        }
        

        /*
        Rectangle cuadrado1 = new Rectangle(20,20, 20, 20);        
        grafico2d.draw(cuadrado1);
        */
    }
}
