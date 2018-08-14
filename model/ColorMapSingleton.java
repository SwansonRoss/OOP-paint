package model;

import java.awt.*;
import java.util.EnumMap;


public class ColorMapSingleton<S, C> extends EnumMap<ShapeColor,Color> {

    public ColorMapSingleton(Class<ShapeColor> keyType) {
        super(keyType);

        this.put(ShapeColor.BLACK, Color.BLACK);
        this.put(ShapeColor.BLUE, Color.BLUE);
        this.put(ShapeColor.CYAN, Color.CYAN);
        this.put(ShapeColor.DARK_GRAY, Color.DARK_GRAY);
        this.put(ShapeColor.GRAY, Color.GRAY);
        this.put(ShapeColor.GREEN, Color.GREEN);
        this.put(ShapeColor.LIGHT_GRAY, Color.LIGHT_GRAY);
        this.put(ShapeColor.MAGENTA, Color.MAGENTA);
        this.put(ShapeColor.ORANGE, Color.ORANGE);
        this.put(ShapeColor.PINK, Color.PINK);
        this.put(ShapeColor.RED, Color.RED);
        this.put(ShapeColor.WHITE, Color.WHITE);
        this.put(ShapeColor.YELLOW, Color.YELLOW);
    }

}
