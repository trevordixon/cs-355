package cs355.shapes;

import java.awt.*;

public class Drawer {
    private Graphics2D g;

    public void draw(Line line) {
        g.setColor(line.getColor());

        Point start = line.getStart();
        Point end = line.getEnd();

        g.drawLine(start.x, start.y, end.x, end.y);
    }

    public void draw(Circle circle) {
        g.setColor(circle.getColor());

        int radius = circle.getRadius();
        Point center = circle.getCenter();
        Point start = new Point(center.x - radius, center.y - radius);

        g.fillOval(start.x, start.y, radius*2, radius*2);
    }

    public void draw(Ellipse ellipse) {
        g.setColor(ellipse.getColor());

        Point center = ellipse.getCenter();
        int width = ellipse.getWidth();
        int height = ellipse.getHeight();

        g.fillOval(center.x - width/2, center.y - height/2, width, height);
    }

    public void draw(Rectangle rectangle) {
        g.setColor(rectangle.getColor());

        Point corner = rectangle.getCorner();
        int width = rectangle.getWidth();
        int height = rectangle.getHeight();

        g.fillRect(corner.x, corner.y, width, height);
    }

    public void draw(Square square) {
        g.setColor(square.getColor());

        Point corner = square.getCorner();
        int size = square.getSize();

        g.fillRect(corner.x, corner.y, size, size);
    }

    public void draw(Triangle triangle) {
        g.setColor(triangle.getColor());

        Point c1 = triangle.getCorner1();
        Point c2 = triangle.getCorner2();
        Point c3 = triangle.getCorner3();

        int[] x = {c1.x, c2.x, c3.x};
        int[] y = {c1.y, c2.y, c3.y};

        g.fillPolygon(x, y, 3);
    }

    public void draw( Shape shape) {
        if (shape instanceof Line) {
            draw((Line) shape);
        } else if (shape instanceof Ellipse) {
            draw((Ellipse) shape);
        } else if (shape instanceof Circle) {
            draw((Circle) shape);
        } else if (shape instanceof Rectangle) {
            draw((Rectangle) shape);
        } else if (shape instanceof Square) {
            draw((Square) shape);
        } else if (shape instanceof Triangle) {
            draw((Triangle) shape);
        }
    }

    public void setG(Graphics2D g) {
        this.g = g;
    }
}