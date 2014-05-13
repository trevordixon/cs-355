package cs355.controller.mousehandlers;

import cs355.model.shapes.Square;
import cs355.controller.CS355Controller;

import java.awt.*;

public class SquareHandler extends CanvasMouseInteractionHandler {
    private Square activeSquare;
    private Point start;

    public SquareHandler(CS355Controller controller) {
        super(controller);
    }

    @Override
    public void down(Point start) {
        activeSquare = new Square();
        activeSquare.setColor(controller.getColor());

        controller.getModel().add(activeSquare);

        this.start = start;

        activeSquare.setCenter(start);
        activeSquare.setSize(0);
    }

    @Override
    public void drag(Point end) {
        int dx = end.x - start.x;
        int dy = end.y - start.y;

        int width = Math.abs(dx);
        int height = Math.abs(dy);

        double size = Math.min(width, height);

        double x, y;
        if (dx >= 0) {
            x = start.x + size/2;
        } else {
            x = start.x - size/2;
        }

        if (dy >= 0) {
            y = start.y + size/2;
        } else {
            y = start.y - size/2;
        }

        activeSquare.setCenter(x, y);
        activeSquare.setSize(size);

        refresh();
    }

    @Override
    public void up(Point p) {
        activeSquare = null;
        start = null;

        refresh();
    }
}
