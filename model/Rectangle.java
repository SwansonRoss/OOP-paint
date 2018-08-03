package model;

import model.interfaces.IShape;
import view.gui.ClickHandler;
import view.gui.PaintCanvas;

import java.awt.*;

public class Rectangle implements IShape {
    //private ClickHandler ch = new ClickHandler();

    private Point startPoint;
    private Point endPoint;
    private int width;
    private int height;
    private ShapeColor bodyColor;
    private ShapeColor borderColor;
    private ShapeType type;

    public Rectangle(Point start, Point end, ShapeColor body, ShapeColor border){
        this.startPoint = start;
        this.endPoint = end;
        this.width = endPoint.x - startPoint.x;
        this.height = endPoint.y - startPoint.y;
        this.bodyColor = body;
        this.borderColor = border;
        this.type = ShapeType.RECTANGLE;
    }


    @Override
    public void setStart() {
        //startPoint = ch.getStart();

    }

    @Override
    public void setEnd() {
        //endPoint = ch.getEnd();
    }

    @Override
    public void setBodyColor() {
        bodyColor = ShapeColor.WHITE;
    }

    @Override
    public void setBorderColor() {
        borderColor = ShapeColor.BLACK;
    }

    @Override
    public void addToList(shapeList list) {
        list.add(this);
    }

    @Override
    public void draw(PaintCanvas canvas) {
        Graphics2D g2 = canvas.getGraphics2D();
        g2.drawRect(startPoint.x, startPoint.y, width, height);
    }

    @Override
    public Point getStart(){
        return startPoint;
    }

    @Override
    public Point getEnd(){
        return endPoint;
    }
}
