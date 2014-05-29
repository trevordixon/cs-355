package cs355.view;

import cs355.GUIFunctions;
import cs355.ManualAffineTransform;
import cs355.model.CS355Model;
import cs355.model.shapes.Shape;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;


public class ViewRefresher implements cs355.ViewRefresher {
    private CS355Model model;
    private Drawer drawer = new Drawer(this);

    public AffineTransform worldToView = new ManualAffineTransform();
    public AffineTransform viewToWorld = new ManualAffineTransform();
    double zoom = 1;

    public ViewRefresher(CS355Model model) {
        this.model = model;
    }

    public void zoomIn() {
        if (zoom < 4) {
            zoom *= 2;
            updateWorldToViewTransform();
            GUIFunctions.refresh();
        }
    }

    public void zoomOut() {
        if (zoom > 0.25) {
            zoom *= 0.5;
            updateWorldToViewTransform();
            GUIFunctions.refresh();
        }
    }

    public void updateWorldToViewTransform() {
        worldToView.setToIdentity();
        worldToView.scale(zoom, zoom);

        try {
            viewToWorld = worldToView.createInverse();
        } catch (NoninvertibleTransformException e) {
            e.printStackTrace();
        }
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
