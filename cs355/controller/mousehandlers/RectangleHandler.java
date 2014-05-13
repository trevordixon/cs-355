package cs355.controller.mousehandlers;

import cs355.model.shapes.Rectangle;
import cs355.controller.CS355Controller;

import java.awt.*;

public class RectangleHandler extends CanvasMouseInteractionHandler {
    private Rectangle activeRectangle;
    private Point start;

    public RectangleHandler(CS355Controller controller) {
        super(controller);
    }

    @Override
    public void down(Point start) {
        activeRectangle = new Rectangle();
        activeRectangle.setColor(controller.getColor());

        controller.getModel().add(activeRectangle);

        this.start = start;

        activeRectangle.setCenter(start);
        activeRectangle.setWidth(0);
        activeRectangle.setHeight(0);
    }

    @Override
    public void drag(Point end) {
        int dx = end.x - start.x;
        int dy = end.y - start.y;

        int width = Math.abs(dx);
        int height = Math.abs(dy);

        double x = (start.getX() + end.getX()) / 2;
        double y = (start.getY() + end.getY()) / 2;

        activeRectangle.setCenter(x, y);
        activeRectangle.setWidth(width);
        activeRectangle.setHeight(height);

        refresh();
    }

    @Override
    public void up(Point p) {
        activeRectangle = null;
        start = null;

        refresh();
    }
}
