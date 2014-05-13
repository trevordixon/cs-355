package cs355.solution;

import cs355.shapes.drawable.Drawer;
import cs355.shapes.Shape;

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
