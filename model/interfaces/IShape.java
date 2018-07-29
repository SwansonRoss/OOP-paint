package model.interfaces;

import model.shapeList;

public interface IShape {
    void setStart();
    void setEnd();
    void setBodyColor();
    void setBorderColor();
    void addToList(shapeList list);
    //void draw();

}
