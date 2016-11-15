package Task1;

/**
 * Created by svetl on 14.11.2016.
 */
public class Rectangle {
    private int rightBottomX;
    private int rightBottomY;
    private int width;
    private int height;

    /**
     * Constructor of the rectangle
     * @param x x-coordinate of the rectangle
     * @param y y-coordinate of the rectangle
     * @param w rectangle's width
     * @param h rectangle's height
     */
    public Rectangle(int x, int y, int w, int h) {
        this.rightBottomX = x;
        this.rightBottomY = y;
        this.width = w;
        this.height = h;
    }

    public int getRightBottomX() {
        return rightBottomX;
    }

    public int getRightBottomY() {
        return rightBottomY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
