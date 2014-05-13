package cs355.solution.draghandlers;

import cs355.GUIFunctions;
import cs355.shapes.Square;
import cs355.solution.CS355Controller;

import java.awt.*;

public class SquareHandler implements DragHandler {
    CS355Controller controller;

    Square activeSquare;
    Point start;

    public SquareHandler(CS355Controller controller) {
        this.controller = controller;
    }

    @Override
    public void start(Point start) {
        activeSquare = new Square();
        activeSquare.setColor(controller.getColor());

        controller.getModel().add(activeSquare);

        this.start = start;

        activeSquare.setCorner(start);
        activeSquare.setSize(0);
    }

    @Override
    public void drag(Point end) {
        int dx = end.x - start.x;
        int dy = end.y - start.y;

        int width = Math.abs(dx);
        int height = Math.abs(dy);

        int size = Math.min(width, height);

        Point tlCorner = new Point();

        if (dx >= 0) {
            tlCorner.x = start.x;
        } else {
            tlCorner.x = start.x - size;
        }

        if (dy >= 0) {
            tlCorner.y = start.y;
        } else {
            tlCorner.y = start.y - size;
        }

        activeSquare.setCorner(tlCorner);
        activeSquare.setSize(size);

        GUIFunctions.refresh();
    }

    @Override
    public void end() {
        activeSquare = null;
        start = null;

        GUIFunctions.refresh();
    }
}
