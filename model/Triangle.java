package model;

import model.interfaces.IShape;
import view.gui.ClickHandler;

import java.awt.*;

public class Triangle implements IShape {

    //private ClickHandler ch = new ClickHandler();

    private Point startPoint;
    private Point endPoint;
    private ShapeColor bodyColor;
    private ShapeColor borderColor;

    Triangle(Point start, Point end, ShapeColor body, ShapeColor border){
        this.startPoint = start;
        this.endPoint = end;
        this.bodyColor = body;
        this.borderColor = border;
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
