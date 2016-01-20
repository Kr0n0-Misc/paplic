package modelomvc;

// Entidades
import entidades.EntidadGeo;
// Swing, AWT y vistas
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
// Utilidades
import java.util.Iterator;
import java.util.LinkedList;
/* NO SON NECESARIAS
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.RenderingHints;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
*/

/**
 * MapaVectorialVentas
 * 
 * Clase que gestiona el Mapa Vectorial de Ventas, utilizando Asociacion
 * Hereda de MapaVectorialBase
 * Implementa Interfaz IMapaRepresentarAsociacion --- IMPORTANTE!!!
 * 
 * @author Kr0n0
 */
// NOTA Implementa IMapaRepresentarAsociacion para poder pasar como parametros entidad y entidad2!!
public class MapaVectorialVentas extends MapaVectorialBase implements IMapaRepresentarAsociacion {
    protected LinkedList<Line2D> llLineas; //Lineas
    protected LinkedList<Shape> llTiendas; //Tiendas
    protected Shape sCliente, sTienda; // Shapes
   
    // CONSTRUCTOR
    public MapaVectorialVentas() {
        super();
        llLineas = new LinkedList<>();
        llTiendas = new LinkedList<>();
    }

    // OVERRIDE A METODO REPRESENTAR DEL INTERFAZ IMapaRepresentarAsociacion
    // Añadimos segunda entidad para representar ventas entre los dos puntos
    //  geometrias -> LinkedList<Shape> básica para Clientes
    //  llTiendas -> LinkedList<Shape> básica para Tiendas
    //  llLineas -> LinkedList<Line2D> básica para Lineas
    //  DEFINIMOS DOS LINKEDLIST DE SHAPE PARA PODER TRATARLOS DE MANERA DIFERENTE (COLOR)
    //
    // NOTA : geometrias es LinkedList<Shape>, por lo que los puntos no pueden
    // añadirse y es necesario crear una nueva
    @Override
    public boolean representar(EntidadGeo entidad, EntidadGeo entidad2) {
        // Crear tipo de geometría  y asignar posición (x,y)        
        // Controlamos si los valores son devueltos por geolib con -1, si es asi no los mostramos
        if ((entidad.getX() != -1) || (entidad.getY() != -1) || (entidad2.getX() != -1) || (entidad2.getY() != -1)) {      
            // Rectangulos
            Rectangle rCliente = new Rectangle(entidad.getX(),entidad.getY(), 10, 10);
            Rectangle rTienda = new Rectangle(entidad2.getX(), entidad2.getY(), 10, 10);
            // Puntos
            Point2D punto1 = new Point2D.Float(entidad.getX(), entidad.getY());
            Point2D punto2 = new Point2D.Float(entidad2.getX(), entidad2.getY());
            // Linea entre puntos
            Line2D linea = new Line2D.Float(punto1,punto2);
            // Añadimos a cada LinkedList el correspondiente
            geometrias.add(rCliente);
            llTiendas.add(rTienda);
            llLineas.add(linea);
        }
        return true;
    }

    // OVERRIDE A METODO GENERARGRAFICO DE LA CLASE ABSTRACTA MapaVectorialBase
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
    }
}
