package cs355.view;

import cs355.GUIFunctions;
import cs355.HouseModel;
import cs355.ManualAffineTransform;
import cs355.WireFrame;
import cs355.controller.Camera;
import cs355.model.CS355Model;
import cs355.model.shapes.Shape;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;


public class ViewRefresher implements cs355.ViewRefresher {
    private CS355Model model;
    private Drawer drawer = new Drawer(this);

    public AffineTransform worldToView = new ManualAffineTransform();
    public AffineTransform viewToWorld = new ManualAffineTransform();
    double zoom = .25;

    double scrollX = 0;
    double scrollY = 0;

    double canvasWidth = 512;
    double canvasHeight = 512;

    public boolean draw3DHouse = true;
    public Camera camera = new Camera(0, 5, -20);

    public ViewRefresher(CS355Model model) {
        this.model = model;
        updateWorldToViewTransform();
    }

    public void zoomIn() {
        if (zoom >= 4) return;

        Point2D center = new Point2D.Double(canvasWidth/2, canvasHeight/2);
        viewToWorld.transform(center, center);

        zoom *= 2;
        updateScrollBars();
        updateWorldToViewTransform();

        GUIFunctions.setHScrollBarPosit((int) center.getX());
        GUIFunctions.setVScrollBarPosit((int) center.getY());

        GUIFunctions.refresh();
    }

    public void zoomOut() {
        if (zoom <= 0.25) return;

        Point2D center = new Point2D.Double(canvasWidth/2, canvasHeight/2);
        viewToWorld.transform(center, center);

        zoom *= 0.5;
        updateScrollBars();
        updateWorldToViewTransform();

        GUIFunctions.setHScrollBarPosit((int) center.getX());
        GUIFunctions.setVScrollBarPosit((int) center.getY());

        GUIFunctions.refresh();
    }

    public void updateScrollBars() {
        GUIFunctions.setHScrollBarMax((int) (zoom*canvasWidth));
        GUIFunctions.setHScrollBarKnob((int) canvasWidth);

        GUIFunctions.setVScrollBarMax((int) (zoom*canvasHeight));
        GUIFunctions.setVScrollBarKnob((int) canvasHeight);
    }

    public void updateWorldToViewTransform() {
        worldToView.setToIdentity();
        worldToView.translate(-scrollX, -scrollY);
        worldToView.scale(zoom, zoom);

        viewToWorld.setToIdentity();
        viewToWorld.scale(1/zoom, 1/zoom);
        viewToWorld.translate(scrollX, scrollY);
    }

    public void scrollHTo(int value) {
        scrollX = value;
        updateWorldToViewTransform();
        GUIFunctions.refresh();
    }

    public void scrollVTo(int value) {
        scrollY = value;
        updateWorldToViewTransform();
        GUIFunctions.refresh();
    }

    WireFrame house = new HouseModel();
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

        if (draw3DHouse) {
            drawer.drawWireFrame(house);
        }
    }
}
