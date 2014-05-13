package cs355.solution.mousehandlers;

import cs355.GUIFunctions;
import cs355.solution.CS355Controller;
import cs355.solution.CS355Model;

import java.awt.*;

public class CanvasMouseInteractionHandler {
    protected CS355Controller controller;
    protected CS355Model model;

    public CanvasMouseInteractionHandler(CS355Controller controller) {
        this.controller = controller;
        model = controller.getModel();
    }

    public void down(Point p) {}
    public void up(Point p) {}
    public void click(Point p) {}
    public void move(Point p) {}
    public void drag(Point p) {}

    public void unload() {}

    protected static void refresh() {
        GUIFunctions.refresh();
    }
}
