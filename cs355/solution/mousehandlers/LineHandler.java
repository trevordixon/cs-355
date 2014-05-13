package cs355.solution.mousehandlers;

import cs355.shapes.Line;
import cs355.solution.CS355Controller;

import java.awt.*;

public class LineHandler extends CanvasMouseInteractionHandler {
    Line activeLine;

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
