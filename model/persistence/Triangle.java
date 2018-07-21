package model.persistence;

import model.ShapeColor;
import model.interfaces.IShape;
import view.gui.ClickHandler;

import java.awt.*;
import java.util.ArrayList;

public class Triangle implements IShape {

    private ClickHandler ch = new ClickHandler();

    private Point startPoint;
    private Point endPoint;
    private ShapeColor bodyColor;
    private ShapeColor borderColor;

    @Override
    public void setStart() {
        startPoint = ch.getStart();
    }

    @Override
    public void setEnd() {
        endPoint = ch.getEnd();
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
    public void addToList(ArrayList<IShape> list) {
        list.add(this);
    }
}
