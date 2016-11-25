package Task1;

/**
 * Created by innopolis on 16.11.2016.
 */
public class Gun {
    private static final double mnoj = 1/Math.sqrt(3);
    private double x1, x2, x3;
    private double y1, y2, y3;
    private String name;

    public Gun(double x, double y, String name) {
        this.name=name;
        double addlen = y * mnoj;
        x1 = x - addlen;
        y1 = 0;
        x2 = x;
        y2 = y;
        x3 = x + addlen;
        y3 = 0;
    }

    public double getX(){
        return x2;
    }

    public double getY(){
        return y2;
    }

    public String getName() {
        return name;
    }

    public boolean isDotInTriangle(double x, double y) {
        double a = (x1 - x) * (y2 - y1) - (x2 - x1) * (y1 - y);
        double b = (x2 - x) * (y3 - y2) - (x3 - x2) * (y2 - y);
        double c = (x3 - x) * (y1 - y3) - (x1 - x3) * (y3 - y);

        if ((a >= 0 && b >= 0 && c >= 0) || (a <= 0 && b <= 0 && c <= 0)) {
            return true;
        } else
            return false;
    }
}
