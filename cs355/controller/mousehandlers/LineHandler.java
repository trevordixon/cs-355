package cs355.controller.mousehandlers;

import cs355.model.shapes.Line;
import cs355.controller.CS355Controller;

import java.awt.*;

public class LineHandler extends CanvasMouseInteractionHandler {
    private Line activeLine;

    public LineHandler(CS355Controller controller) {
        super(controller);
    }

    @Override
    public void down(Point start) {
        activeLine = new Line();
        activeLine.setColor(controller.getColor());

        controller.getModel().add(activeLine);

        activeLine.setStart(start);
        activeLine.setEnd(start);
    }

    @Override
    public void drag(Point end) {
        activeLine.setEnd(end);
        refresh();
    }

    @Override
    public void up(Point p) {
        activeLine = null;
        refresh();
    }
}
