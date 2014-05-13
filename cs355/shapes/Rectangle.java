package cs355.shapes;

import java.awt.*;

public class Rectangle extends Shape {
    private Point corner;
    private int height;
    private int width;

    public Point getCorner() {
        return corner;
    }

    public void setCorner(Point corner) {
        this.corner = corner;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
