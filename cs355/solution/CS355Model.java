package cs355.solution;

import cs355.shapes.Shape;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class CS355Model implements Iterable<Shape> {
    private Deque<Shape> shapes = new ArrayDeque<>();
    private Shape selection;

    public void add(Shape shape) {
        shapes.add(shape);
    }

    public Shape firstShapeUnderPoint(Point2D p) {
        for (Shape shape : this.reverse()) {
            Point2D center = shape.getCenter();

            AffineTransform worldToObj = new AffineTransform();
            worldToObj.rotate(-1 * shape.getRotation());
            worldToObj.translate(-1 * center.getX(), -1 * center.getY());

            Point2D objCoord = new Point2D.Double();
            worldToObj.transform(p, objCoord);

            if (shape.contains(objCoord)) {
                return shape;
            }
        }

        return null;
    }

    @Override
    public Iterator<Shape> iterator() {
        return shapes.iterator();
    }

    public Iterable<Shape> reverse() {
        return new Iterable<Shape>() {
            @Override
            public Iterator<Shape> iterator() {
                return shapes.descendingIterator();
            }
        };
    }

    public Shape getSelection() {
        return selection;
    }

    public void setSelection(Shape selection) {
        this.selection = selection;
    }

    public void clearSelection() {
        selection = null;
    }
}
