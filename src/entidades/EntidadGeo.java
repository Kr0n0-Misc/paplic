package entidades;

/**
 * Entidad Geo
 * 
 * Entidad abstracta Geo
 * 
 * Gestiona las coordenadas heredadas al resto de entidades
 * 
 */


public class EntidadGeo {
    private int x,y;

    public EntidadGeo(){
    x=y=0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
