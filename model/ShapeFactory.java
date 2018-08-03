package model;

import model.interfaces.IShape;
import model.persistence.ApplicationState;

import java.awt.Point;

public class ShapeFactory {

    private ApplicationState appState;

    private ShapeFactory(ApplicationState as) {
        this.appState = as;
    }

    public static IShape createEllipse(Point start, Point end, ShapeColor body, ShapeColor border) {
        return new Ellipse(start, end, body, border);
    }

    public static IShape createRectangle(Point start, Point end, ShapeColor body, ShapeColor border) {
        return new Rectangle(start, end, body, border);
    }

    public static  IShape createTriangle(Point start, Point end, ShapeColor body, ShapeColor border) {
        return new Triangle(start, end, body, border);
    }
}
