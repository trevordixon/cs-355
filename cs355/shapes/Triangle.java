package cs355.shapes;

import java.awt.*;

public class Triangle extends Shape {
    private Point corner1;
    private Point corner2;
    private Point corner3;

    public Triangle(Point c1, Point c2, Point c3) {
        corner1 = c1;
        corner2 = c2;
        corner3 = c3;
    }

    public Point getCorner1() {
        return corner1;
    }

    public void setCorner1(Point corner1) {
        this.corner1 = corner1;
    }

    public Point getCorner2() {
        return corner2;
    }

    public void setCorner2(Point corner2) {
        this.corner2 = corner2;
    }

    public Point getCorner3() {
        return corner3;
    }

    public void setCorner3(Point corner3) {
        this.corner3 = corner3;
    }
}
