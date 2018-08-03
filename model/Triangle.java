package model;

import model.interfaces.IShape;
import view.gui.ClickHandler;
import view.gui.PaintCanvas;

import java.awt.*;

public class Triangle implements IShape {

    //private ClickHandler ch = new ClickHandler();

    private int[] xPoints = new int[3];
    private int[] yPoints = new int[3];
    private final int TRIANGLE_POINTS = 3;
    private ShapeColor bodyColor;
    private ShapeColor borderColor;
    private ShapeType type;
    private Point startPoint;
    private Point endPoint;

    public Triangle(Point start, Point end, ShapeColor body, ShapeColor border){
        this.startPoint = start;
        this.endPoint = end;

        this.xPoints[0] = start.x;
        this.xPoints[1] = start.x;
        this.xPoints[2] = end.x;

        this.yPoints[0] = end.y;
        this.yPoints[1] = start.y;
        this.yPoints[2] = end.y;

        this.bodyColor = body;
        this.borderColor = border;

        this.type = ShapeType.TRIANGLE;
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
    public void draw(PaintCanvas canvas){
        Graphics2D g = canvas.getGraphics2D();
        g.drawPolygon(xPoints, yPoints, TRIANGLE_POINTS);
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
