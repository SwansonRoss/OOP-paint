package model.interfaces;

import model.ShapeFactory;
import model.persistence.ApplicationState;

import java.awt.*;

public interface IShapeStrategy {
    IShape getShapeStrategy(Point start, Point end, ApplicationState appState);
}
