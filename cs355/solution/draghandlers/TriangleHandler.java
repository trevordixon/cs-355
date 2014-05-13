package cs355.solution.draghandlers;

import cs355.GUIFunctions;
import cs355.shapes.Triangle;
import cs355.solution.CS355Controller;

import java.awt.*;

public class TriangleHandler implements DragHandler {
    CS355Controller controller;
    Point corner1;
    Point corner2;
    Point corner3;

    public TriangleHandler(CS355Controller controller) {
        this.controller = controller;
    }

    @Override
    public void start(Point start) {
        if (corner1 == null) {
            corner1 = start;
        } else if (corner2 == null) {
            corner2 = start;
        } else if (corner3 == null) {
            corner3 = start;
        }
    }

    @Override
    public void end() {
        if (corner1 != null && corner2 != null && corner3 != null) {
            Triangle t = new Triangle(corner1, corner2, corner3);
            t.setColor(controller.getColor());
            controller.getModel().add(t);
            GUIFunctions.refresh();

            corner1 = corner2 = corner3 = null;
        }
    }

    @Override
    public void drag(Point end) {}
}
