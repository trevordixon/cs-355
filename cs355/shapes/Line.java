package cs355.shapes;

import java.awt.*;

public class Line extends Shape {
    private Point start;
    private Point end;

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
}
