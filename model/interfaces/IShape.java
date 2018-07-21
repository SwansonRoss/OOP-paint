package model.interfaces;

import java.awt.*;
import java.util.ArrayList;

public interface IShape {
    void setStart();
    void setEnd();
    void setBodyColor();
    void setBorderColor();
    void addToList(ArrayList<IShape> list);

}
