package cs355.model.shapes;

import cs355.Vector;

import java.awt.*;
import java.awt.geom.Point2D;

public class Line extends Shape {
    private Point start;

    @Override
    public void setCenter(Point2D p) {
        double x = start.getX() + p.getX();
        double y = start.getY() + p.getY();
        start.setLocation(x, y);

        x = end.getX() + p.getX();
        y = end.getY() + p.getY();
        end.setLocation(x, y);
    }

    @Override
    public void setCenter(double x, double y) {
        start.setLocation(start.getX() + x, start.getY() + y);
        end.setLocation(end.getX() + x, end.getY() + y);
    }

    private Point end;

    @Override
    public boolean contains(Point2D point) {
        Vector v = new Vector(start);
        Vector w = new Vector(end);
        Vector p = new Vector(point);

        Vector vw = w.minus(v);
        Vector vp = p.minus(v);

        double l2 = vw.magnitude();
        l2 = l2 * l2;

        double t = vp.dot(vw)/(l2);
        if (t < 0) return p.distanceTo(v) <= 4;
        if (t > 1) return p.distanceTo(w) <= 4;

        Vector proj = v.plus(vw.times(t));
        return p.distanceTo(proj) <= 4;
    }

    public Point getStart() {
        return start;
    }
    public Point getEnd() {
        return end;
    }
    public void setStart(Point start) {
        this.start = start;
    }
    public void setEnd(Point end) {
        this.end = end;
    }

    @Override
    public double getHeight() {
        return 0;
    }
}
