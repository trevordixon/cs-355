package cs355.shapes;

import java.awt.*;

public class Square extends Shape {
    private Point corner;
    private int size;

    public Point getCorner() {
        return corner;
    }

    public void setCorner(Point corner) {
        this.corner = corner;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
