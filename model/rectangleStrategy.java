package model;

import model.interfaces.IFillType;
import model.interfaces.IShape;
import model.interfaces.IShapeStrategy;
import model.persistence.ApplicationState;

import java.awt.*;

public class rectangleStrategy implements IShapeStrategy {

    private ColorMapSingleton<ShapeColor, Color> colorMapSingleton = new ColorMapSingleton<ShapeColor, Color>(ShapeColor.class);

    @Override
    public IShape getShapeStrategy(Point start, Point end, ApplicationState appState) {

        Color primary = colorMapSingleton.get(appState.getActivePrimaryColor());
        Color secondary = colorMapSingleton.get(appState.getActiveSecondaryColor());

        determineFillStrategy strategy = new determineFillStrategy(appState);
        IFillType fill = strategy.getFillStrategy();
        int fillKey = fill.returnDrawMode();

        return ShapeFactory.createRectangle(start, end, primary, secondary, fillKey);
    }
}
