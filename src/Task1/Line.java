package Task1;

/**
 * Created by svetl on 15.11.2016.
 */
public class Line {
    private double pointX1;
    private double pointY1;
    private double pointX2;
    private double pointY2;

    /**
     * Constructor of the line
     *
     * @param x1 - start x-coordinate of the line
     * @param y1 - start y-coordinate of the line
     * @param x2 - end x-coordinate of the line
     * @param y2 - end y-coordinate of the line
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.pointX1 = x1;
        this.pointY1 = y1;
        this.pointX2 = x2;
        this.pointY2 = y2;
    }

    /**
     * Check if line intersect given circle
     * @param circle
     * @return true if line intersect given circle
     */
    public boolean isIntersect(Circle circle) {
        /*We should find distance from the center of circle to the line,
          then we should compare found distance with the radius of the circle.
          If this distance less or equal than the radius, then return true.
         */
        double dist = Math.abs(((pointX2 - pointX1) * (circle.getCenterY() - pointY1) - (pointY2 - pointY1) * (circle.getCenterX() - pointX1)) / Math.sqrt((pointX2 - pointX1) * (pointX2 - pointX1) + (pointY2 - pointY1) * (pointY2 - pointY1)));
        return dist <= circle.getRadius();
    }

    /**
     * Check if given point (x3, y3) lies on the segment (x1, y1)(x2, y2)
     * @param x1 - start point x of the segment
     * @param y1 - start point y of the segment
     * @param x2 - end point x of the segment
     * @param y2 - end point y of the segment
     * @param x3 - x coordinate of given point
     * @param y3 - y coordinate of given point
     * @return true if given point belongs to the given segment
     */
    private boolean onSegment(double x1, double y1, double x2, double y2, double x3, double y3)
    {
        return x3 <= Math.max(x1, x2) && x3 >= Math.min(x1, x2) && y3 <= Math.max(y1, y2) && y3 >= Math.min(y1, y2);
    }

    /**
     * Returns the orientation of triplet of points
     *
     * @param x1 x-coordinate of the first point
     * @param y1 y-coordinate of the first point
     * @param x2 x-coordinate of the second point
     * @param y2 y-coordinate of the second point
     * @param x3 x-coordinate of the third point
     * @param y3 y-coordinate of the third point
     * @return code of the orientation (0 - collinear, 1 - clockwise, 2 - counterclockwise
     */
    private int orientation(double x1, double y1, double x2, double y2, double x3, double y3) {
        double val = (y2 - y1) * (x3 - x2) - (y3 - y2) * (x2 - x1);
        if (val == 0) {
            return 0;

        }
        return (val > 0) ? 1 : 2;
    }

    /**
     * Check if two lines are intersected
     *
     * @param line given line
     * @return true if two lines are intersected
     */
    private boolean isIntersect(Line line) {
        int o1 = orientation(this.pointX1, this.pointY1, this.pointX2, this.pointY2, line.pointX1, line.pointY1);
        int o2 = orientation(this.pointX1, this.pointY1, this.pointX2, this.pointY2, line.pointX2, line.pointY2);
        int o3 = orientation(line.pointX1, line.pointY1, line.pointX2, line.pointY2, this.pointX1, this.pointY1);
        int o4 = orientation(line.pointX1, line.pointY1, line.pointX2, line.pointY2, this.pointX2, this.pointY2);

        // General case
        if (o1 != o2 && o3 != o4) {
            return true;
        }

        // Special Cases
        if (o1 == 0 && onSegment(this.pointX1, this.pointY1, this.pointX2, this.pointY2, line.pointX1, line.pointY1)) {
            return true;
        }
        if (o2 == 0 && onSegment(this.pointX1, this.pointY1, this.pointX2, this.pointY2, line.pointX2, line.pointY2)) {
            return true;
        }
        if (o3 == 0 && onSegment(line.pointX1, line.pointY1, line.pointX2, line.pointY2, this.pointX1, this.pointY1)) {
            return true;
        }
        if (o4 == 0 && onSegment(line.pointX1, line.pointY1, line.pointX2, line.pointY2, this.pointX2, this.pointY2)) {
            return true;
        }

        return false;
    }

    /**
     * Check if line intersect top, left or right side of the rectangle (it's useless to check bottom side)
     *
     * @param rectangle given rectangle
     * @return true if line intersect top, left or right side of the rectangle
     */
    public boolean isIntersect(Rectangle rectangle) {
        double x = rectangle.getOriginX();
        double y = rectangle.getOriginY();
        double width = rectangle.getWidth();
        double height = rectangle.getHeight();
        Line lside = new Line(x, y, x, y + height);
        Line tside = new Line(x, y + height, x + width, y + height);
        Line rside = new Line(x + width, y, x + width, y + height);

        return isIntersect(lside) || isIntersect(tside) || isIntersect(rside);
    }
}
