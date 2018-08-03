package model.interfaces;

import model.shapeList;
import view.gui.PaintCanvas;

import java.awt.*;

public interface IShape {
    void setStart();
    void setEnd();
    void setBodyColor();
    void setBorderColor();
    void addToList(shapeList list);
    void draw(PaintCanvas canvas);
    Point getStart();
    Point getEnd();

}
