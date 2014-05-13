package cs355.shapes;

import java.awt.geom.Point2D;

public class Square extends Shape {
    private double size;

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public boolean contains(Point2D point) {
        double x = point.getX(), y = point.getY();
        return (x >= -1 * (size / 2)) &&
                (x <= size / 2) &&
                (y >= -1 * (size / 2)) &&
                (y <= size / 2);
    }

    @Override
    public double getHeight() {
        return size;
    }
}
