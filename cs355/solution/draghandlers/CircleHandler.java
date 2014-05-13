package cs355.solution.draghandlers;

import cs355.GUIFunctions;
import cs355.shapes.Circle;
import cs355.solution.CS355Controller;

import java.awt.*;

public class CircleHandler implements DragHandler {
    CS355Controller controller;

    Circle activeCircle;
    Point start;

    public CircleHandler(CS355Controller controller) {
        this.controller = controller;
    }

    @Override
    public void start(Point start) {
        activeCircle = new Circle();
        activeCircle.setColor(controller.getColor());

        controller.getModel().add(activeCircle);

        this.start = start;

        activeCircle.setCenter(start);
        activeCircle.setRadius(0);
    }

    @Override
    public void drag(Point end) {
        int dx = end.x - start.x;
        int dy = end.y - start.y;

        int width = Math.abs(dx);
        int height = Math.abs(dy);

        int diameter = Math.min(width, height);
        int radius = diameter/2;

        Point center = new Point();

        if (dx >= 0) {
            center.x = start.x + radius;
        } else {
            center.x = start.x - radius;
        }

        if (dy >= 0) {
            center.y = start.y + radius;
        } else {
            center.y = start.y - radius;
        }

        activeCircle.setCenter(center);
        activeCircle.setRadius(radius);

        GUIFunctions.refresh();
    }

    @Override
    public void end() {
        activeCircle = null;
        start = null;
        GUIFunctions.refresh();
    }
}
