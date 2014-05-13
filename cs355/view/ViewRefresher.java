package cs355.view;

import cs355.model.shapes.Shape;
import cs355.model.CS355Model;

import java.awt.*;


public class ViewRefresher implements cs355.ViewRefresher {
    private CS355Model model;
    private Drawer drawer = new Drawer();

    public ViewRefresher(CS355Model model) {
        this.model = model;
    }

    @Override
    public void refreshView(Graphics2D g2d) {
        drawer.setG(g2d);

        for (Shape shape : model) {
            drawer.draw(shape);
        }

        Shape selected = model.getSelection();
        if (selected != null) {
            drawer.drawSelectionOutlineAndHandles(selected);
        }
    }
}