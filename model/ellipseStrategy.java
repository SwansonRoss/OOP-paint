package model;

import model.interfaces.IFillType;
import model.interfaces.IShape;
import model.interfaces.IShapeStrategy;
import model.persistence.ApplicationState;

import java.awt.*;


public class ellipseStrategy implements IShapeStrategy {


    @Override
    public IShape getShapeStrategy(Point start, Point end, ApplicationState appState) {

        determineFillStrategy strategy = new determineFillStrategy(appState);
        IFillType fill = strategy.getFillStrategy();
        int fillKey = fill.returnDrawMode();

        Color primary =  (Color)ColorMapSingleton.instance.get(appState.getActivePrimaryColor());
        Color secondary = (Color)ColorMapSingleton.instance.get(appState.getActiveSecondaryColor());

        return ShapeFactory.createEllipse(start, end, primary, secondary, fillKey);
    }
}
