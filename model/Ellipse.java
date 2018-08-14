package model;

import model.interfaces.IFillType;
import model.interfaces.IShape;

import java.awt.*;
import java.util.EnumMap;

import view.gui.ClickHandler;
import view.gui.PaintCanvas;

public class Ellipse implements IShape {

    //private ClickHandler ch = new ClickHandler();

    private Point startPoint;
    private Point endPoint;
    private int width;
    private int height;
    private Color bodyColor;
    private Color borderColor;
    private ShapeType type;
    private boolean collision = false;
    private int fillKey;

    public Ellipse(Point start, Point end, Color body, Color border, int fillKey){
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

        this.width = endPoint.x - startPoint.x;
        this.height = endPoint.y - startPoint.y;
        this.bodyColor = body;
        this.borderColor = border;
        this.type = ShapeType.ELLIPSE;
        this.fillKey = fillKey;
    }

    @Override
    public void setStart(Point start) {
        this.startPoint = start;
    }

    @Override
    public void setEnd(Point end) {
        this.endPoint = end;

    }

    @Override
    public void setBodyColor() {
        //bodyColor = ShapeColor.WHITE;

    }

    @Override
    public void setBorderColor() {
        //borderColor = ShapeColor.BLACK;

    }

    @Override
    public void addToList(shapeList list) {
        list.add(this);
    }

    @Override
    public void draw(PaintCanvas canvas){
        Graphics2D g = canvas.getGraphics2D();

        //Case 0: draw outline only.
        //Case 1: draw fill only
        //Case 2: draw outline and fill

        switch (this.fillKey){
            case 0:
                g.setColor(borderColor);
                g.drawOval(startPoint.x, startPoint.y, width, height);
                break;
            case 2:
                g.setColor(borderColor);
                g.drawOval(startPoint.x, startPoint.y, width, height);
            case 1:
                g.setColor(bodyColor);
                g.fillOval(startPoint.x,startPoint.y, width, height);
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

    }

    @Override
    public void fakeDelete(PaintCanvas canvas) {
        Graphics2D g = canvas.getGraphics2D();
        g.setColor(Color.WHITE);
        g.drawOval(startPoint.x, startPoint.y, width, height);
        g.fillOval(startPoint.x,startPoint.y, width, height);

    }
}
