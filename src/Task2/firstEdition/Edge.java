package firstEdition;

/**
 * Created by Михаил on 24.11.2016.
 */
public class Edge {

    Point start;
    Point end;
    boolean type;

    public Edge(int sx,int sy,int ex,int ey,boolean type){
        this.start = new Point(sx,sy);
        this.start = new Point(ex,ey);
        this.type = type;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public void setStart(Point start) {
        this.start = start;
    }
}
