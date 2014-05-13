package cs355.controller.mousehandlers;

import cs355.model.shapes.Circle;
import cs355.controller.CS355Controller;

import java.awt.*;

public class CircleHandler extends CanvasMouseInteractionHandler {
    private Circle activeCircle;
    private Point start;

    public CircleHandler(CS355Controller controller) {
        super(controller);
    }

    @Override
    public void down(Point start) {
        activeCircle = new Circle();
        activeCircle.setColor(controller.getColor());

        model.add(activeCircle);

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

        double x, y;

        if (dx >= 0) {
            x = start.x + radius;
        } else {
            x = start.x - radius;
        }

        if (dy >= 0) {
            y = start.y + radius;
        } else {
            y = start.y - radius;
        }

        activeCircle.setCenter(x, y);
        activeCircle.setRadius(radius);

        refresh();
    }

    @Override
    public void up(Point p) {
        activeCircle = null;
        start = null;
        refresh();
    }
}
