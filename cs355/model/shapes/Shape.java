package cs355.model.shapes;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Shape {
    protected Color color;
    protected Point2D center = new Point2D.Double();
    protected double rotation = 0;

    public Color getColor() {
        return color;
    }

    public Shape setColor(Color c) {
        color = c;
        return this;
    }

    public Point2D getCenter() {
        return center;
    }

    public void setCenter(Point2D p) {
        center.setLocation(p);
    }

    public void setCenter(double x, double y) {
        center.setLocation(x, y);
    }

    public double getRotation() {
        return rotation;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public boolean contains(Point2D point) { return false; }

    public abstract double getHeight();
}
