package Task1;

/**
 * Created by svetl on 14.11.2016.
 */
public class Tank {
    private double originX;
    private double originY;
    private double width;
    private double height;
    public String name;

    /**
     * Constructor of the rectangle
     * @param x x-coordinate of the rectangle
     * @param y y-coordinate of the rectangle
     * @param w rectangle's width
     * @param h rectangle's height
     */
    public Tank(double x, double y, double w, double h,String name) {
        this.originX = x;
        this.originY = y;
        this.width = w;
        this.height = h;
        this.name=name;
    }

    public double getOriginX() {
        return originX;
    }

    public double getOriginY() {
        return originY;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public Rectangle toRectangle(){
        return new Rectangle(originX, originY, width, height);
    }
}
