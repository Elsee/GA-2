package Task1;

/**
 * Created by svetl on 14.11.2016.
 */
public class Circle {
    private double centerX;
    private double centerY;
    private double radius;

    /**
     * Constructor of the circle
     * @param x x-coordinate of the center
     * @param y y-coordinate of the center
     * @param r circle's radius
     */
    public Circle(double x, double y, double r) {
        this.centerX = x;
        this.centerY = y;
        this.radius = r;
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public double getRadius() {
        return radius;
    }
}
