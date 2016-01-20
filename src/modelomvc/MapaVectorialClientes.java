package modelomvc;

// Entidades
import entidades.EntidadGeo;
// Swing, AWT y vistas
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Shape;
// Utilidades
import java.util.Iterator;
/* NO SON NECESARIAS
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
*/

/**
 * MapaVectorialClientes
 * 
 * Clase que gestiona el Mapa Vectorial de Clientes
 * Hereda de MapaVectorialBase
 * Implementa Interfaz IMapaRepresentarEntidad
 * 
 * @author Kr0n0
 */
public class MapaVectorialClientes extends MapaVectorialBase implements IMapaRepresentarEntidad {
    Shape sCliente;
    
    // CONSTRUCTOR
    public MapaVectorialClientes() {
        super();
        //incializar contexto de dibujo
       grafico2d.setPaint(Color.red);//color de la línea rojo
    }

    // OVERRIDE A METODO REPRESENTAR DEL INTERFAZ IMapaRepresentarEntidad
    @Override
    public boolean representar(EntidadGeo entidad) {
        // Crear tipo de geometría  y asignar posición (x,y)
        // Controlamos si los valores son devueltos por geolib con -1, si es asi no los mostramos
        if ((entidad.getX() != -1) || (entidad.getY() != -1)) {
            Rectangle cuadrado1 = new Rectangle(entidad.getX(),entidad.getY(), 10, 10);
            geometrias.add(cuadrado1);
        }
        return true;
    }

    // OVERRIDE A METODO GENERARGRAFICO DE LA CLASE ABSTRACTA MapaVectorialBase
    @Override
    public void generarGrafico() {
        //Por cada geometria operación draw en la coordenadas asinadas
        Iterator itGeometrias;
        itGeometrias = geometrias.iterator();
       grafico2d.setColor(Color.red);
        while (itGeometrias.hasNext()) {
            // Recogemos el objeto
            sCliente = (Shape)itGeometrias.next();
            // Dibujamos y rellenamos
            grafico2d.draw(sCliente);
            grafico2d.fill(sCliente);
        }
    }
}
