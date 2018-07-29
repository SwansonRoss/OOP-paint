package model;

import model.interfaces.IShape;

import java.awt.*;
import view.gui.ClickHandler;

public class Ellipse implements IShape {

    //private ClickHandler ch = new ClickHandler();

    private Point startPoint;
    private Point endPoint;
    private ShapeColor bodyColor;
    private ShapeColor borderColor;

    Ellipse(Point start, Point end, ShapeColor body, ShapeColor border){
        this.startPoint = start;
        this.endPoint = end;
        this.bodyColor = body;
        this.borderColor = border;
        System.out.println("An ellipse has been made");
    }

    @Override
    public void setStart() {
        //startPoint = ch.getStart();
    }

    @Override
    public void setEnd() {
        //endPoint = ch.getEnd();
    }

        @Override
    public void setBodyColor() {
        bodyColor = ShapeColor.WHITE;

    }

    @Override
    public void setBorderColor() {
        borderColor = ShapeColor.BLACK;

    }

    @Override
    public void addToList(shapeList list) {
        list.add(this);
    }
}
