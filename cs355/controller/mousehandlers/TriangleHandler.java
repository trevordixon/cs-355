package cs355.controller.mousehandlers;

import cs355.model.shapes.Triangle;
import cs355.controller.CS355Controller;

import java.awt.*;
import java.awt.geom.Point2D;

public class TriangleHandler extends CanvasMouseInteractionHandler {
    private Point2D c1;
    private Point2D c2;
    private Point2D c3;

    public TriangleHandler(CS355Controller controller) {
        super(controller);
    }

    @Override
    public void click(Point point) {
        if (c1 == null) {
            c1 = point;
            return;
        } else if (c2 == null) {
            c2 = point;
            return;
        } else if (c3 == null) {
            c3 = point;
        }

        double x = (c1.getX() + c2.getX() + c3.getX())/3;
        double y = (c1.getY() + c2.getY() + c3.getY())/3;

        c1.setLocation(c1.getX() - x, c1.getY() - y);
        c2.setLocation(c2.getX() - x, c2.getY() - y);
        c3.setLocation(c3.getX() - x, c3.getY() - y);

        Triangle t = new Triangle(new Point2D.Double(x, y), c1, c2, c3);
        t.setColor(controller.getColor());
        model.add(t);

        refresh();

        c1 = c2 = c3 = null;
    }
}
