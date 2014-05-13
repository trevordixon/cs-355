package cs355.shapes;

import java.awt.*;

public abstract class Shape {
    private Color color;

    public Color getColor() {
        return color;
    }

    public Shape setColor(Color c) {
        color = c;
        return this;
    }
}
