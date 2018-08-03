package model;

import model.interfaces.IShape;
import view.gui.PaintCanvas;

import java.util.ArrayList;
import java.util.List;

public class shapeList extends ArrayList {
    private List<IShape> shapes = new ArrayList<>();

    private PaintCanvas canvas = null;

    public void setCanvas(PaintCanvas canvas){
        this.canvas = canvas;
    }


    public void drawShapes() {
        int i = 1;
        for (IShape shape : shapes) {
            canvas.setShape(shape);
            shape.draw(canvas);
        }

        for(i = 0; i < this.size(); i++) {
            IShape shape = (IShape) this.get(i);
            canvas.setShape(shape);
            shape.draw(canvas);
        }

    }


}