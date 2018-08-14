package model.interfaces;

import model.shapeList;
import view.gui.PaintCanvas;

import java.awt.*;

public interface IShape {
    void setStart(Point start);
    void setEnd(Point end);
    void setBodyColor();
    void setBorderColor();
    void addToList(shapeList list);
    void draw(PaintCanvas canvas);
    void setCollision(Boolean set);
    Boolean getCollision();
    Point getStart();
    Point getEnd();
    void moveShape(Point start, Point end);
    void fakeDelete(PaintCanvas canvas);


}
