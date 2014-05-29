package cs355.controller;

import cs355.GUIFunctions;
import cs355.model.CS355Model;
import cs355.controller.mousehandlers.*;
import cs355.view.ViewRefresher;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.Iterator;

public class CS355Controller implements cs355.CS355Controller {
    public MouseListener mouseListener;
    public MouseMotionListener mouseMotionListener;

    private CanvasMouseInteractionHandler mouseInteractionHandler = new CanvasMouseInteractionHandler(this);

    private CS355Model model;
    private ViewRefresher view;
    private Color color = Color.blue;

    public CS355Controller(CS355Model model, ViewRefresher view) {
        this.model = model;
        this.view = view;

        createMouseListener();
        createMouseMotionListener();
    }

    public CS355Model getModel() {
        return model;
    }
    public ViewRefresher getView() { return view; }

    public void setMouseInteractionHandler(CanvasMouseInteractionHandler mouseInteractionHandler) {
        if (this.mouseInteractionHandler != null) {
            this.mouseInteractionHandler.unload();
        }
        this.mouseInteractionHandler = mouseInteractionHandler;
    }

    @Override
    public void colorButtonHit(Color c) {
        color = c;
        GUIFunctions.changeSelectedColor(c);
        if (model.getSelection() != null) {
            model.getSelection().setColor(c);
            GUIFunctions.refresh();
        }
    }

    @Override
    public void lineButtonHit() {
        setMouseInteractionHandler(new LineHandler(this));
    }

    @Override
    public void triangleButtonHit() {
        setMouseInteractionHandler(new TriangleHandler(this));
    }

    @Override
    public void squareButtonHit() {
        setMouseInteractionHandler(new SquareHandler(this));
    }

    @Override
    public void rectangleButtonHit() {
        setMouseInteractionHandler(new RectangleHandler(this));
    }

    @Override
    public void circleButtonHit() {
        setMouseInteractionHandler(new CircleHandler(this));
    }

    @Override
    public void ellipseButtonHit() {
        setMouseInteractionHandler(new EllipseHandler(this));
    }

    @Override
    public void selectButtonHit() {
        setMouseInteractionHandler(new SelectHandler(this));
    }

    @Override
    public void zoomInButtonHit() {
        view.zoomIn();
    }

    @Override
    public void zoomOutButtonHit() {
        view.zoomOut();
    }

    @Override
    public void hScrollbarChanged(int value) {
        view.scrollHTo(value);
    }

    @Override
    public void vScrollbarChanged(int value) {
        view.scrollVTo(value);
    }

    @Override
    public void toggle3DModelDisplay() {
        System.out.println("TODO: toggle3DModelDisplay");
    }

    @Override
    public void keyPressed(Iterator<Integer> iterator) {}

    @Override
    public void doEdgeDetection() {
        System.out.println("TODO: doEdgeDetection");
    }

    @Override
    public void doSharpen() {
        System.out.println("TODO: doSharpen");
    }

    @Override
    public void doMedianBlur() {
        System.out.println("TODO: doMedianBlur");
    }

    @Override
    public void doUniformBlur() {
        System.out.println("TODO: doUniformBlur");
    }

    @Override
    public void doChangeContrast(int contrastAmountNum) {
        System.out.println("TODO: doChangeContrast");
    }

    @Override
    public void doChangeBrightness(int brightnessAmountNum) {
        System.out.println("TODO: doChangeBrightness");
    }

    @Override
    public void doLoadImage(BufferedImage openImage) {
        System.out.println("TODO: doLoadImage");
    }

    @Override
    public void toggleBackgroundDisplay() {
        System.out.println("TODO: toggleBackgroundDisplay");
    }

    private void createMouseListener() {
        mouseListener = new MouseListener() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point2D p = new Point2D.Double();
                p.setLocation(e.getPoint());
                view.viewToWorld.transform(p, p);
                mouseInteractionHandler.down(p);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Point2D p = new Point2D.Double();
                p.setLocation(e.getPoint());
                view.viewToWorld.transform(p, p);
                mouseInteractionHandler.up(p);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                Point2D p = new Point2D.Double();
                p.setLocation(e.getPoint());
                view.viewToWorld.transform(p, p);
                mouseInteractionHandler.click(p);
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
    }

    private void createMouseMotionListener() {
        mouseMotionListener = new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point2D p = new Point2D.Double();
                p.setLocation(e.getPoint());
                view.viewToWorld.transform(p, p);
                mouseInteractionHandler.drag(p);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                Point2D p = new Point2D.Double();
                p.setLocation(e.getPoint());
                view.viewToWorld.transform(p, p);
                mouseInteractionHandler.move(p);
            }
        };
    }

    public Color getColor() {
        return color;
    }
}
