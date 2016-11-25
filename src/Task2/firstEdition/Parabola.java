package firstEdition;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Created by Михаил on 24.11.2016.
 */
public class Parabola {


    public static int Arc2Arc(Point focus1, Point focus2, int line, boolean type) {

        double p1 = 2 * (focus1.y - line);
        double p2 = 2 * (focus1.y - line); // is not 0.0, because line moved down
        // solving the equation
        double a1 = 1 / p1;
        double a2 = 1 / p2;
        double a = a2 - a1;
        double b1 = focus1.x / p1;
        double b2 = focus2.x / p2;
        double b = b2 - b1;
        double c1 = pow(focus1.x, 2) + pow(focus1.y, 2) - pow(line, 2) / p1;
        double c2 = pow(focus2.x, 2) + pow(focus2.y, 2) - pow(line, 2) / p1;
        double c = c2 - c1;
        double D = pow(b, 2) - 4 * a * c;

        double x1 = (-b - sqrt(D)) / (2 * a);
        double x2 = (-b + sqrt(D)) / (2 * a);
        double y1 = a1 * pow(x1, 2) + b1 * x1 + c1;
        double y2 = a1 * pow(x2, 2) + b1 * x2 + c1;

        if (type){//если правда то правая точка
            return (int) x2;
        }
        else {
            return (int) x1;
        }
    }

}