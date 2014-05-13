package cs355.solution.mousehandlers;

import cs355.GUIFunctions;
import cs355.shapes.Line;
import cs355.shapes.Triangle;
import cs355.solution.CS355Controller;
import cs355.shapes.Shape;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

public class SelectHandler extends CanvasMouseInteractionHandler {
    private Point last;
    private Handle clickedHandle;

    public SelectHandler(CS355Controller controller) {
        super(controller);
    }

    @Override
    public void down(Point p) {
        last = p;

        clickedHandle = handleAtPoint(p);
        if (clickedHandle == Handle.NONE) {
            Shape selected = model.firstShapeUnderPoint(p);
            model.setSelection(selected);

            if (selected != null) {
                GUIFunctions.changeSelectedColor(selected.getColor());
            } else {
                GUIFunctions.changeSelectedColor(controller.getColor());
            }

            refresh();
        }
    }

    @Override
    public void drag(Point p) {
        Shape selected = model.getSelection();
        if (selected == null) return;
        clickedHandle.handleDrag(p, last, selected);
        last = p;
    }

    private Handle handleAtPoint(Point p) {
        Shape shape = model.getSelection();
        if (shape == null) return Handle.NONE;

        if (shape instanceof Line) {
            return handleAtPoint(p, (Line) shape);
        }

        Point2D center = shape.getCenter();

        AffineTransform worldToObj = new AffineTransform();
        worldToObj.rotate(-1 * shape.getRotation());
        worldToObj.translate(-1 * center.getX(), -1 * center.getY());

        Point2D objCoord = new Point2D.Double();
        worldToObj.transform(p, objCoord);

        if (near(objCoord, new Point(0, (int) -shape.getHeight()/2 - 17))) {
            return Handle.ROTATE;
        }

        return Handle.NONE;
    }

    private Handle handleAtPoint(Point p, Line line) {
        if (near(p, line.getStart())) {
            return Handle.START;
        } else if (near(p, line.getEnd())) {
            return Handle.END;
        }

        return Handle.NONE;
    }

    private static boolean near(Point2D p1, Point2D p2) {
        return p1.distanceSq(p2) <= 16;
    }

    private enum Handle {
        START {
            @Override
            public void handleDrag(Point point, Point prevPoint, Shape shape) {
                Line line = (Line) shape;
                line.setStart(point);
                refresh();
            }
        }, END {
            @Override
            public void handleDrag(Point point, Point prevPoint, Shape shape) {
                Line line = (Line) shape;
                line.setEnd(point);
                refresh();
            }
        },
        ROTATE {
            @Override
            public void handleDrag(Point point, Point prevPoint, Shape shape) {
                Point2D center = shape.getCenter();
                double dx = point.getX() - center.getX();
                double dy = point.getY() - center.getY();
                double angle = Math.atan2(dx, dy) + Math.PI;
                shape.setRotation(-angle);
                refresh();
            }
        },
        NONE {
            @Override
            public void handleDrag(Point point, Point prevPoint, Shape shape) {
                Point2D center = shape.getCenter();
                double dx = point.getX() - prevPoint.getX(), dy = point.getY() - prevPoint.getY();
                shape.setCenter(center.getX() + dx, center.getY() + dy);
                refresh();
            }
        };

        public abstract void handleDrag(Point point, Point prevPoint, Shape shape);
    }

    @Override
    public void unload() {
        model.setSelection(null);
        GUIFunctions.changeSelectedColor(controller.getColor());
        refresh();
    }
}
