package cs355.controller;

import cs355.GUIFunctions;
import cs355.model.CS355Model;
import cs355.controller.mousehandlers.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Iterator;

public class CS355Controller implements cs355.CS355Controller {
    public MouseListener mouseListener;
    public MouseMotionListener mouseMotionListener;

    private CanvasMouseInteractionHandler mouseInteractionHandler = new CanvasMouseInteractionHandler(this);

    private CS355Model model;
    private Color color = Color.blue;

    public CS355Controller(CS355Model model) {
        this.model = model;

        createMouseListener();
        createMouseMotionListener();
    }

    public CS355Model getModel() {
        return model;
    }

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
        System.out.println("TODO: zoomInButtonHit");
    }

    @Override
    public void zoomOutButtonHit() {
        System.out.println("TODO: zoomOutButtonHit");
    }

    @Override
    public void hScrollbarChanged(int value) {
        System.out.println("TODO: hScrollbarChanged");
    }

    @Override
    public void vScrollbarChanged(int value) {
        System.out.println("TODO: vScrollbarChanged");
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
                mouseInteractionHandler.down(e.getPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mouseInteractionHandler.up(e.getPoint());
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                mouseInteractionHandler.click(e.getPoint());
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
                mouseInteractionHandler.drag(e.getPoint());
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                mouseInteractionHandler.move(e.getPoint());
            }
        };
    }

    public Color getColor() {
        return color;
    }
}