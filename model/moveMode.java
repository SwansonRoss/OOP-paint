package model;

import model.interfaces.IClick;
import model.interfaces.IUndoable;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;

import java.awt.*;

public class moveMode implements IClick, IUndoable {
    private int width;
    private int height;
    private shapeList list = new shapeList();


    @Override
    public void run(Point start, Point end, PaintCanvas canvas, ApplicationState appState, shapeList list) {
        System.out.println("You are in move mode");

        this.list = list;

        //find delta width and delta height
        int dWidth = end.x - start.x;
        this.width = dWidth;

        int dHeight = end.y - start.y;
        this.height = dHeight;

        list.moveShapes(dWidth, dHeight);

        CommandHistory.add(this);

//        canvas.repaint();
//
//        list.drawShapes();
    }

    @Override
    public void undo() {
        list.moveShapes(width*-1, height*-1);
    }

    @Override
    public void redo() {
        list.moveShapes(width, height);
    }
}
