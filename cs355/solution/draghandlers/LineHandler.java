package cs355.solution.draghandlers;

import cs355.GUIFunctions;
import cs355.shapes.Line;
import cs355.solution.CS355Controller;

import java.awt.*;

public class LineHandler implements DragHandler {
    CS355Controller controller;
    Line activeLine;

    public LineHandler(CS355Controller controller) {
        this.controller = controller;
    }

    @Override
    public void start(Point start) {
        activeLine = new Line();
        activeLine.setColor(controller.getColor());

        controller.getModel().add(activeLine);

        activeLine.setStart(start);
        activeLine.setEnd(start);
    }

    @Override
    public void drag(Point end) {
        activeLine.setEnd(end);
        GUIFunctions.refresh();
    }

    @Override
    public void end() {
        activeLine = null;
        GUIFunctions.refresh();
    }
}
