package Task1;

/**
 * Created by svetl on 14.11.2016.
 */
public class Circle {
    private int centerX;
    private int centerY;
    private int radius;

    /**
     * Constructor of the circle
     * @param x x-coordinate of the center
     * @param y y-coordinate of the center
     * @param r circle's radius
     */
    public Circle(int x, int y, int r) {
        this.centerX = x;
        this.centerY = y;
        this.radius = r;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public int getRadius() {
        return radius;
    }
}
