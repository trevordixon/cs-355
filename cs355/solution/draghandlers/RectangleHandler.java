package cs355.solution.draghandlers;

import cs355.GUIFunctions;
import cs355.shapes.Rectangle;
import cs355.solution.CS355Controller;

import java.awt.*;

public class RectangleHandler implements DragHandler {
    CS355Controller controller;

    Rectangle activeRectangle;
    Point start;

    public RectangleHandler(CS355Controller controller) {
        this.controller = controller;
    }

    @Override
    public void start(Point start) {
        activeRectangle = new Rectangle();
        activeRectangle.setColor(controller.getColor());

        controller.getModel().add(activeRectangle);

        this.start = start;

        activeRectangle.setCorner(start);
        activeRectangle.setWidth(0);
        activeRectangle.setHeight(0);
    }

    @Override
    public void drag(Point end) {
        int dx = end.x - start.x;
        int dy = end.y - start.y;

        int width = Math.abs(dx);
        int height = Math.abs(dy);

        Point tlCorner = new Point();

        if (dx >= 0) {
            tlCorner.x = start.x;
        } else {
            tlCorner.x = end.x;
        }

        if (dy >= 0) {
            tlCorner.y = start.y;
        } else {
            tlCorner.y = end.y;
        }

        activeRectangle.setCorner(tlCorner);
        activeRectangle.setWidth(width);
        activeRectangle.setHeight(height);

        GUIFunctions.refresh();
    }

    @Override
    public void end() {
        activeRectangle = null;
        start = null;

        GUIFunctions.refresh();
    }
}
