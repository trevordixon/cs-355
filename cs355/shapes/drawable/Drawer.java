package cs355.shapes.drawable;

import cs355.shapes.*;
import cs355.shapes.Shape;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

public class Drawer {
    private Graphics2D g;

    public void draw(Line line, boolean outline) {
        g.setColor(line.getColor());

        Point start = line.getStart();
        Point end = line.getEnd();

        if (outline) {
            g.setColor(Color.CYAN);
            g.fillOval((int) start.getX()-3, (int) start.getY()-3, 7, 7);
            g.fillOval((int) end.getX()-3, (int) end.getY()-3, 7, 7);
        } else {
            g.drawLine(start.x, start.y, end.x, end.y);
        }
    }

    public void draw(Circle circle, boolean outline) {
        g.setColor(circle.getColor());

        int radius = circle.getRadius();

        if (outline) {
            g.setColor(Color.CYAN);
            g.drawOval(-radius, -radius, radius * 2, radius * 2);
        } else {
            g.fillOval(-radius, -radius, radius * 2, radius * 2);
        }
    }

    public void draw(Ellipse ellipse, boolean outline) {
        g.setColor(ellipse.getColor());

        double width = ellipse.getWidth();
        double height = ellipse.getHeight();

        if (outline) {
            g.setColor(Color.CYAN);
            g.drawOval(
                    (int) (-width / 2),
                    (int) (-height / 2),
                    (int) width,
                    (int) height
            );
        } else {
            g.fillOval(
                (int) (-width / 2),
                (int) (-height / 2),
                (int) width,
                (int) height
            );
        }
    }

    public void draw(cs355.shapes.Rectangle rectangle, boolean outline) {
        g.setColor(rectangle.getColor());

        double width = rectangle.getWidth();
        double height = rectangle.getHeight();

        if (outline) {
            g.setColor(Color.CYAN);
            g.drawRect(
                    (int) (-width / 2),
                    (int) (-height / 2),
                    (int) width,
                    (int) height
            );
        } else {
            g.fillRect(
                (int) (-width / 2),
                (int) (-height / 2),
                (int) width,
                (int) height
            );
        }
    }

    public void draw(Square square, boolean outline) {
        g.setColor(square.getColor());

        double size = square.getSize();

        if (outline) {
            g.setColor(Color.CYAN);
            g.drawRect(
                    (int) (-size / 2),
                    (int) (-size / 2),
                    (int) size,
                    (int) size
            );
        } else {
            g.fillRect(
                (int) (-size / 2),
                (int) (-size / 2),
                (int) size,
                (int) size
            );
        }
    }

    public void draw(Triangle triangle, boolean outline) {
        g.setColor(triangle.getColor());

        Point2D c1 = triangle.getCorner1();
        Point2D c2 = triangle.getCorner2();
        Point2D c3 = triangle.getCorner3();

        int[] x = {
            (int) c1.getX(),
            (int) c2.getX(),
            (int) c3.getX()
        };

        int[] y = {
            (int) c1.getY(),
            (int) c2.getY(),
            (int) c3.getY()
        };

        if (outline) {
            g.setColor(Color.CYAN);
            g.drawPolygon(x, y, 3);
        } else {
            g.fillPolygon(x, y, 3);
        }
    }

    public void draw(Shape shape) {
        draw(shape, false);
    }

    public void drawSelectionOutlineAndHandles(Shape shape) {
        draw(shape, true);
        g.fillOval(-3, (int) (-shape.getHeight() / 2) - 20, 7, 7);
    }

    public void draw(cs355.shapes.Shape shape, boolean outline) {
        Point2D center = shape.getCenter();

        AffineTransform objToWorld = new AffineTransform();
        objToWorld.translate(center.getX(), center.getY());
        objToWorld.rotate(shape.getRotation());

        g.setTransform(objToWorld);

        if (shape instanceof Line) {
            draw((Line) shape, outline);
        } else if (shape instanceof Ellipse) {
            draw((Ellipse) shape, outline);
        } else if (shape instanceof Circle) {
            draw((Circle) shape, outline);
        } else if (shape instanceof cs355.shapes.Rectangle) {
            draw((cs355.shapes.Rectangle) shape, outline);
        } else if (shape instanceof Square) {
            draw((Square) shape, outline);
        } else if (shape instanceof Triangle) {
            draw((Triangle) shape, outline);
        }
    }

    public void setG(Graphics2D g) {
        this.g = g;
    }
}