package firstEdition;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by Михаил on 24.11.2016.
 */
public class Voronovi {
    PriorityQueue<Event> events = new PriorityQueue<>();
    MyTree sweepLine = new MyTree();

    public static final int CIRCLE = 123;
    public static final int SITE = 132;

    private int[] masX;
    private int[] masY;
    private DoublyLinkedList<Edge> ans = new DoublyLinkedList<>();

    public Voronovi(int[] masX, int[] masY) {

        this.masX = masX;
        this.masY = masY;

    }

    public void doVoronovi() {
        setQueue();
        while (!events.isEmpty()) {
            Event event = events.remove();
            if (event.type == SITE) {
                siteEvent(event.point);
            } else {
                circleEvent(event.point);
            }
        }
    }


    private void setQueue() {
        for (int i = 0; i < masX.length; i++) {
            events.add(new Event(SITE, new Point(masX[i], masY[i])));
        }
    }

    private void siteEvent(Point point) {
        if (sweepLine.isEmpty()) {
            sweepLine.setFirst(point);
        } else {
            sweepLine.addSubTree(point);
        }
    }

    private void circleEvent(Point event) {

    }

    private static final int ARC = 1;
    private static final int BP = 2;
    private static final int BPO = 3;

    public class MyTree {

        int numArcs = 0;
        Node root = null;

        public boolean isEmpty() {
            return root == null;
        }

        public Point[] getArcs() {
            LinkedList<Point> ans = new LinkedList<>();
            getAllArct(ans, root);
            return (Point[]) ans.toArray();
        }

        private void getAllArct(LinkedList<Point> points, Node node) {
            if (node.type == ARC) {
                points.add(node.focus);
            } else {
                getAllArct(points, node.left);
                getAllArct(points, node.right);
            }
        }


        class Node {
            Node left;
            Node right;
            Edge edge;
            Node parent;
            int type;
            int param;
            Point focus;

            public Node() {

            }

        }


        public void setFirst(Point point) {
            root = new Node();
            root.focus = point;
            root.param = point.x;
            numArcs++;
        }

        public void addSubTree(Point point) {

            Node newN = new Node();
            Node arc = getArc(root, point);
            if (arc.parent.left == arc) {
                arc.parent.left = newN;

            } else {
                arc.parent.right = newN;
            }

            newN.left = new Node();
            newN.right = new Node();

            newN.right.right = arc;
            newN.right.left = new Node();
            numArcs++;
            newN.left.left = arc;
            numArcs++;
            newN.left.right = newN.right.left;
            numArcs++;

        }

        public Node getArc(Point point) {
            return getArc(root, point);
        }

        private Node getArc(Node node, Point point) {
            if (node.type == ARC) {
                return node;
            } else {
                node.param = Parabola.Arc2Arc(node.edge.start, node.edge.end, point.y, node.edge.type);
                if (point.x < node.param) {
                    return getArc(node.left, point);
                } else {
                    return getArc(node.right, point);
                }
            }
        }

    }

    public void addCircleEvent(Point point) {
        Point[] sweepLineArcs = sweepLine.getArcs();
        int i;
        for (i = 0; i < sweepLineArcs.length; i++) {
            if (sweepLineArcs[i].equals(point)) {
                break;
            }
        }

        for (int j = -2; i <= 0; i++) {
            if ((!sweepLineArcs[i + j].equals(sweepLineArcs[i + j + 1]) && !sweepLineArcs[i + j].equals(sweepLineArcs[i + j + 2]) &&
                    !(sweepLineArcs[i + j + 1].equals(sweepLineArcs[i + j + 2])))) {
                if (check(sweepLineArcs[i + j], sweepLineArcs[i + j + 1], sweepLineArcs[i + j + 2])) {
                    Point circle = getPointCircle(sweepLineArcs[i + j], sweepLineArcs[i + j + 1], sweepLineArcs[i + j + 2]);
                    MyTree.Node arc = sweepLine.getArc(sweepLineArcs[i + j + 1]);
                    events.add(new Event(CIRCLE, circle, arc));
                }
            }
        }
    }

    private Point getPointCircle(Point point1, Point point2, Point point3) {

        double Ma;
        double Mb;
        int y1 = point1.y;
        int x1 = point1.x;
        int y2 = point2.y;
        int x2 = point2.x;
        int y3 = point3.y;
        int x3 = point3.x;


        Ma = (y2 - y1) / (x2 - x1);
        Mb = (y3 - y2) / (x3 - x2);
        double x = (Ma * Mb * (y1 - y3) + Mb * (x1 + x2) - Ma * (x2 + x3)) / (2 * Mb - Ma);
        double y = -1 / Ma * (x - (x1 + x2) / 2) + ((y1 + y2) / 2);


        double r = (x - x1) * (x - x1) + (y - y1) * (y - y1);
        r = Math.sqrt((double) r);

        return new Point((int) x, (int) (y - r));
    }


    private boolean check(Point point1, Point point2, Point point3) {
        return true;
    }

}
