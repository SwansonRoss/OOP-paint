package model;

import model.interfaces.IShape;

import java.util.ArrayList;
import java.util.List;

public class shapeList extends ArrayList {
    private List<IShape> shapes = new ArrayList<>();


    public void drawShapes() {
        int i = 1;
        for (IShape shape : shapes) {
            System.out.println("Drawing shape #" + i++);
        }
    }

}