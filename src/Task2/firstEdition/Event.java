package firstEdition;

/**
 * Created by Михаил on 24.11.2016.
 */
public class Event implements Comparable<Event> {
    int type;
    int priority;
    Point point;

    public Event(int type, Point point) {
        this.type = type;
        this.priority = point.y;
        this.point = point;
    }

    public Event(int type, Point point, Voronovi.MyTree.Node arcPoint) {
        this.type = type;
        this.priority = point.y;
        this.point = point;
        this.arcPoint = arcPoint;
    }

    Voronovi.MyTree.Node arcPoint;

    @Override
    public int compareTo(Event o) {
        return this.priority - o.priority;
    }
}