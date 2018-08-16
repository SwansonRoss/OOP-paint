package model;

import model.interfaces.IShape;
import view.gui.PaintCanvas;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class shapeList extends ArrayList {
    private List<IShape> shapes = new ArrayList<>();

    private PaintCanvas canvas = null;

    public void setCanvas(PaintCanvas canvas){
        this.canvas = canvas;
    }


    public void drawShapes() {
        int i = 0;
        IShape shape;
        for(i = 0; i < this.size(); i++) {
            shape = (IShape) this.get(i);
            canvas.setShape(shape);
            shape.draw(canvas);
        }

    }

    public void findCollisions(Point tl, Point br){
        int i;
        IShape shape;
        for(i = 0; i < this.size(); i++) {
            shape = (IShape) this.get(i);
            Point start = shape.getStart();
            Point end = shape.getEnd();

            System.out.println("Shape box range: " + start.x + ", " + start.y + " to " + end.x + ", " + end.y);

            if((br.x < start.x) || (tl.x > end.x) || (tl.y > end.y) || (br.y < start.y)){
                shape.setCollision(false);
            }
            else {
                shape.setCollision(true);
                System.out.println("There was a collision!");
            }


        }
    }

    public void moveShapes(int dWidth, int dHeight) {
        int i;
        IShape shape;
        int size = this.size();


        for (i = 0; i < size; i++) {
            shape = (IShape) this.get(i);
            if (shape.getCollision()) {
                shape.fakeDelete(canvas);

                Point newStart = new Point();
                Point newEnd = new Point();

                newStart = shape.getStart();
                newEnd = shape.getEnd();

                newStart.x = newStart.x + dWidth;
                newEnd.x = newEnd.x + dWidth;

                newStart.y = newStart.y + dHeight;
                newEnd.y = newEnd.y + dHeight;

                shape.moveShape(newStart, newEnd);

                this.set(i, shape);
            }

        }

        this.drawShapes();
    }

    public void deleteShapes(){
        int i;
        IShape shape;
        int size = this.size();


        for (i = 0; i < size; i++) {
            shape = (IShape) this.get(i);
            if (shape.getCollision()) {
                shape.fakeDelete(canvas);
                this.remove(i);
            }
        }
    }

    public shapeList copySelected(){
        shapeList copyList = new shapeList();

        int i;
        IShape shape;
        int size = this.size();

        for (i = 0; i < size; i++) {
            shape = (IShape) this.get(i);
            if (shape.getCollision()) {
                copyList.add(shape);
            }
        }

        System.out.println(copyList.size() + " were copied. Expected: " + i);

        return copyList;
    }


    public void paste(shapeList copyList) {
        int i;
        IShape shape;
        int size = copyList.size();

        Point center = new Point();
        center.x = 500;
        center.y = 500;

        Point newEnd = new Point();

        for (i = 0; i < size; i++) {
            shape = (IShape) copyList.get(i);
            newEnd.x = shape.getEnd().x - shape.getStart().x + 500;
            newEnd.y = shape.getEnd().y - shape.getStart().y + 500;
            shape.moveShape(center, newEnd);
            this.add(shape);
        }

        this.drawShapes();

        System.out.println(i + " should have been pasted.");

    }
}