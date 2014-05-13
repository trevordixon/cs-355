package cs355.shapes;

import cs355.Vector;

import java.awt.geom.Point2D;

public class Triangle extends Shape {
    private Point2D c1;
    private Point2D c2;
    private Point2D c3;

    public Triangle(Point2D center, Point2D c1, Point2D c2, Point2D c3) {
        this.center.setLocation(center);
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
    }

    private static double sign(Point2D p1, Point2D p2, Point2D p3)
    {
        return (p1.getX() - p3.getX()) * (p2.getY() - p3.getY()) - (p2.getX() - p3.getX()) * (p1.getY() - p3.getY());
    }

    @Override
    public boolean contains(Point2D p) {
        Vector v1 = new Vector(c1);
        Vector v2 = new Vector(c2);
        Vector v3 = new Vector(c3);

        Vector _v1 = v1;
        v1 = v1.minus(v2);
        v2 = v2.minus(v3);
        v3 = v3.minus(_v1);

        boolean b1 = sign(p, v1, v2) < 0;
        boolean b2 = sign(p, v2, v3) < 0;
        boolean b3 = sign(p, v3, v1) < 0;

        return ((b1 == b2) && (b2 == b3));
    }

    @Override
    public double getHeight() {
        double min, max;
        min = max = c1.getY();

        if (c2.getY() < min) min = c2.getY();
        if (c2.getY() > max) max = c2.getY();

        if (c3.getY() < min) min = c3.getY();
        if (c3.getY() > max) max = c3.getY();

        return max - min;
    }

    public Point2D getCorner1() {
        return c1;
    }

    public void setCorner1(Point2D c1) {
        this.c1 = c1;
    }

    public Point2D getCorner2() {
        return c2;
    }

    public void setCorner2(Point2D c2) {
        this.c2 = c2;
    }

    public Point2D getCorner3() {
        return c3;
    }

    public void setCorner3(Point2D c3) {
        this.c3 = c3;
    }
}
