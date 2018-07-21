package model;

import model.interfaces.IShape;

import java.util.ArrayList;
import java.util.List;

public class shapeList {
    private List<IShape> shapes = new ArrayList<>();

    private void drawShapes() {
        for (IShape shape : shapes) {
            System.out.println(shape.toString());
        }
    }

}