package cs355.model.shapes;

import java.awt.geom.Point2D;

public class Circle extends Shape {
    private int radius;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public boolean contains(Point2D point) {
        double x = point.getX(), y = point.getY(), r2 = radius*radius;
        return (
                (x*x)/(r2) + (y*y)/(r2)
        ) <= 1;
    }

    @Override
    public double getHeight() {
        return radius*2;
    }
}
