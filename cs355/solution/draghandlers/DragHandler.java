package cs355.solution.draghandlers;

import java.awt.*;

public interface DragHandler {
    public void start(Point start);
    public void drag(Point end);
    public void end();
}
