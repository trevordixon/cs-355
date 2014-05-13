package cs355.solution.draghandlers;

import cs355.GUIFunctions;
import cs355.shapes.Ellipse;
import cs355.solution.CS355Controller;

import java.awt.*;

public class EllipseHandler implements DragHandler {
    CS355Controller controller;

    Ellipse activeEllipse;
    Point start;

    public EllipseHandler(CS355Controller controller) {
        this.controller = controller;
    }

    @Override
    public void start(Point start) {
        activeEllipse = new Ellipse();
        activeEllipse.setColor(controller.getColor());

        controller.getModel().add(activeEllipse);

        this.start = start;

        activeEllipse.setCenter(start);
        activeEllipse.setWidth(0);
        activeEllipse.setHeight(0);
    }

    @Override
    public void drag(Point end) {
        int dx = end.x - start.x;
        int dy = end.y - start.y;

        int width = Math.abs(dx);
        int height = Math.abs(dy);

        Point center = new Point();

        if (dx >= 0) {
            center.x = start.x + width/2;
        } else {
            center.x = start.x - width/2;
        }

        if (dy >= 0) {
            center.y = start.y + height/2;
        } else {
            center.y = start.y - height/2;
        }

        activeEllipse.setCenter(center);
        activeEllipse.setWidth(width);
        activeEllipse.setHeight(height);

        GUIFunctions.refresh();
    }

    @Override
    public void end() {
        activeEllipse = null;
        start = null;

        GUIFunctions.refresh();
    }
}
