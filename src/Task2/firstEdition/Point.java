package firstEdition;

/**
 * Created by Михаил on 24.11.2016.
 */
public class Point implements Comparable<Point> {
    int x;
    int y;
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public int compareTo(Point o) {
        return (this.x-o.x)+(this.y-o.y);
    }
}
