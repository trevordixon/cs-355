package cs355.controller.mousehandlers;

import cs355.model.shapes.Ellipse;
import cs355.controller.CS355Controller;

import java.awt.*;

public class EllipseHandler extends CanvasMouseInteractionHandler {
    private Ellipse activeEllipse;
    private Point start;

    public EllipseHandler(CS355Controller controller) {
        super(controller);
    }

    @Override
    public void down(Point start) {
        activeEllipse = new Ellipse();
        activeEllipse.setColor(controller.getColor());

        controller.getModel().add(activeEllipse);

        this.start = start;

        activeEllipse.setCenter(start);
    }

    @Override
    public void drag(Point end) {
        int dx = end.x - start.x;
        int dy = end.y - start.y;

        int width = Math.abs(dx);
        int height = Math.abs(dy);

        double x, y;
        if (dx >= 0) {
            x = start.x + width/2;
        } else {
            x = start.x - width/2;
        }

        if (dy >= 0) {
            y = start.y + height/2;
        } else {
            y = start.y - height/2;
        }

        activeEllipse.setCenter(x, y);
        activeEllipse.setWidth(width);
        activeEllipse.setHeight(height);

        refresh();
    }

    @Override
    public void up(Point p) {
        activeEllipse = null;
        start = null;

        refresh();
    }
}
