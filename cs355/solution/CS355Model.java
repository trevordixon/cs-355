package cs355.solution;

import cs355.shapes.Shape;

import java.util.ArrayList;
import java.util.Iterator;

public class CS355Model implements Iterable<Shape> {
    private ArrayList<Shape> shapes = new ArrayList<>();

    public void add(Shape shape) {
        shapes.add(shape);
    }

    @Override
    public Iterator<Shape> iterator() {
        return shapes.iterator();
    }
}
