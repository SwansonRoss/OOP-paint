package model;

import java.awt.*;
import java.util.EnumMap;
import java.util.TreeMap;

public class ColorMapSingleton extends TreeMap {

    public static ColorMapSingleton instance = new ColorMapSingleton();

    private ColorMapSingleton(){
        this.put(ShapeColor.BLACK, java.awt.Color.BLACK);
        this.put(ShapeColor.BLUE, java.awt.Color.BLUE);
        this.put(ShapeColor.CYAN, java.awt.Color.CYAN);
        this.put(ShapeColor.DARK_GRAY, java.awt.Color.DARK_GRAY);
        this.put(ShapeColor.GRAY, java.awt.Color.GRAY);
        this.put(ShapeColor.GREEN, java.awt.Color.GREEN);
        this.put(ShapeColor.LIGHT_GRAY, java.awt.Color.LIGHT_GRAY);
        this.put(ShapeColor.MAGENTA, java.awt.Color.MAGENTA);
        this.put(ShapeColor.ORANGE, java.awt.Color.ORANGE);
        this.put(ShapeColor.PINK, java.awt.Color.PINK);
        this.put(ShapeColor.RED, java.awt.Color.RED);
        this.put(ShapeColor.WHITE, java.awt.Color.WHITE);
        this.put(ShapeColor.YELLOW, java.awt.Color.YELLOW);
    }

}
