package model;

import model.interfaces.IClick;
import model.interfaces.IUndoable;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;

import java.awt.*;

public class selectMode implements IClick, IUndoable {

    shapeList list = new shapeList();
    Point tl = new Point();
    Point br = new Point();

    @Override
    public void run(Point start, Point end, PaintCanvas canvas, ApplicationState appState, shapeList list) {

        //Find bounding box
        Point topLeft = new Point();
        Point bottomRight = new Point();

        topLeft.x = Math.min(start.x, end.x);
        topLeft.y = Math.min(start.y, end.y);

        bottomRight.x = Math.max(start.x, end.x);
        bottomRight.y = Math.max(start.y, end.y);

        System.out.println("select box range: " + topLeft.x + ", " + topLeft.y + " to " + bottomRight.x + ", " + bottomRight.y);

        this.tl = topLeft;
        this.br = bottomRight;
        this.list = list;

        //Iterate over shape list, mark collisions
        list.findCollisions(topLeft, bottomRight);

        CommandHistory.add(this);


    }

    @Override
    public void undo() {
        Point top = new Point();
        Point bottom = new Point();

        top.x = -1; top.y = -1;
        bottom.x = -1; bottom.y = -1;

        this.list.findCollisions(top, bottom);

    }

    @Override
    public void redo() {
        this.list.findCollisions(tl, br);
    }
}
