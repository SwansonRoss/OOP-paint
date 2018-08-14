package model;

import model.interfaces.IShape;
import model.persistence.ApplicationState;
import java.awt.Color;

import java.awt.Point;

public class ShapeFactory {

    private ApplicationState appState;

    private ShapeFactory(ApplicationState as) {
        this.appState = as;
    }

    public static IShape createEllipse(Point start, Point end, Color body, Color border, int fillKey) {
        return new Ellipse(start, end, body, border, fillKey);
    }

    public static IShape createRectangle(Point start, Point end, Color body, Color border, int fillKey) {
        return new Rectangle(start, end, body, border, fillKey);
    }

    public static  IShape createTriangle(Point start, Point end, Color body, Color border, int fillKey) {
        return new Triangle(start, end, body, border, fillKey);
    }
}
