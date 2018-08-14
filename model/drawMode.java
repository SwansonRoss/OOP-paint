package model;

import model.interfaces.IClick;
import model.interfaces.IShape;
import model.interfaces.IShapeStrategy;
import model.interfaces.IUndoable;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;

import java.awt.*;

public class drawMode implements IClick, IUndoable {
    private shapeList list = new shapeList();
    private IShape shape = null;
    private PaintCanvas canvas = new PaintCanvas();

    @Override
    public void run(Point start, Point end, PaintCanvas canvas, ApplicationState appState, shapeList list) {
        this.list = list;
        this.canvas = canvas;
        System.out.println("You are in draw Mode!");
        determineShapeStrategy findStrategy = new determineShapeStrategy(appState);
        IShapeStrategy strategy = findStrategy.determineShape();
        IShape shape = strategy.getShapeStrategy(start, end, appState);
        this.shape = shape;
        shape.addToList(list);
        list.drawShapes();

        System.out.println("A " + shape.toString() + "was just created. There are " + list.size() + "shapes in total");
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        this.shape.fakeDelete(this.canvas);
    }

    @Override
    public void redo() {
        this.shape.addToList(this.list);
        this.list.drawShapes();
    }
}
