package model;

import model.interfaces.IShape;
import model.interfaces.IShapeStrategy;
import model.persistence.ApplicationState;
import java.awt.Point;

public class triangleStrategy implements IShapeStrategy{
    @Override
    public IShape getShapeStrategy(Point start, Point end, ApplicationState appState) {
        return ShapeFactory.createTriangle(start, end, appState.getActivePrimaryColor(), appState.getActiveSecondaryColor());
    }
}
