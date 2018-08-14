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
    private Color bodyColor;
    private Color borderColor;
    private ShapeType type;
    private Point startPoint;
    private Point endPoint;
    private boolean collision = false;
    private int fillKey;

    public Triangle(Point start, Point end, Color body, Color border, int fillKey){
        //Find bounding box upper left (x,y) coordinate
        int startX = Math.min(start.x, end.x);
        int startY = Math.min(start.y, end.y);

        //Find bounding box lower right (x,y) coordinate
        int endX = Math.max(start.x, end.x);
        int endY = Math.max(start.y, end.y);

        //create new start and end points
        Point newStart = new Point();
        Point newEnd = new Point();

        //Reset start and end points
        newStart.setLocation(startX, startY);
        newEnd.setLocation(endX, endY);

        this.startPoint = newStart;
        this.endPoint = newEnd;

        this.xPoints[0] = start.x;
        this.xPoints[1] = start.x;
        this.xPoints[2] = end.x;

        this.yPoints[0] = end.y;
        this.yPoints[1] = start.y;
        this.yPoints[2] = end.y;

        this.bodyColor = body;
        this.borderColor = border;

        this.fillKey = fillKey;

        this.type = ShapeType.TRIANGLE;
    }

    @Override
    public void setStart(Point start) {
        //startPoint = ch.getStart();
        this.startPoint = start;
    }

    @Override
    public void setEnd(Point end) {
        //endPoint = ch.getEnd();
        this.endPoint = end;
    }

    @Override
    public void setBodyColor() {
    }

    @Override
    public void setBorderColor() {
    }

    @Override
    public void addToList(shapeList list) {
        list.add(this);
    }

    @Override
    public void draw(PaintCanvas canvas){
        Graphics2D g = canvas.getGraphics2D();

        switch (this.fillKey){
            case 0:
                g.setColor(borderColor);
                g.drawPolygon(xPoints, yPoints, TRIANGLE_POINTS);
                break;
            case 2:
                g.setColor(borderColor);
                g.drawPolygon(xPoints, yPoints, TRIANGLE_POINTS);
            case 1:
                g.setColor(bodyColor);
                g.fillPolygon(xPoints, yPoints, TRIANGLE_POINTS);
        }
    }

    @Override
    public void setCollision(Boolean set) {
        collision = set;
    }

    @Override
    public Boolean getCollision() {
        return this.collision;
    }

    @Override
    public Point getStart(){
        return startPoint;
    }

    @Override
    public Point getEnd(){
        return endPoint;
    }

    @Override
    public void moveShape(Point start, Point end) {
        setStart(start);
        setEnd(end);

        this.xPoints[0] = start.x;
        this.xPoints[1] = start.x;
        this.xPoints[2] = end.x;

        this.yPoints[0] = end.y;
        this.yPoints[1] = start.y;
        this.yPoints[2] = end.y;

    }

    @Override
    public void fakeDelete(PaintCanvas canvas) {
        Graphics2D g = canvas.getGraphics2D();
        g.setColor(Color.WHITE);
        g.drawPolygon(xPoints, yPoints, TRIANGLE_POINTS);
        g.fillPolygon(xPoints, yPoints, TRIANGLE_POINTS);

    }
}
