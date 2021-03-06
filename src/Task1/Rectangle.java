package Task1;

/**
 * Created by svetl on 14.11.2016.
 */
public class Rectangle {
    private double originX;
    private double originY;
    private double width;
    private double height;

    /**
     * Constructor of the rectangle
     * @param x x-coordinate of the rectangle
     * @param y y-coordinate of the rectangle
     * @param w rectangle's width
     * @param h rectangle's height
     */
    public Rectangle(double x, double y, double w, double h) {
        this.originX = x;
        this.originY = y;
        this.width = w;
        this.height = h;
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
}
