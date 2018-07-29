package model;

import model.interfaces.IShape;
import model.interfaces.IShapeStrategy;
import model.persistence.ApplicationState;

import java.awt.*;

public class rectangleStrategy implements IShapeStrategy {

    @Override
    public IShape getShapeStrategy(Point start, Point end, ApplicationState appState) {
        return ShapeFactory.createRectangle(start, end, appState.getActivePrimaryColor(), appState.getActiveSecondaryColor());
    }
}
