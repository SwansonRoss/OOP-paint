package view.gui;

import model.Ellipse;
import model.Rectangle;
import model.ShapeColor;
import model.Triangle;
import model.interfaces.IShape;

import javax.swing.JComponent;
import java.awt.*;

public class PaintCanvas extends JComponent {

    private Point startPoint, endPoint;

    private IShape shapeToDraw;


    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }

    public void paint(Graphics g){
//        Rectangle r = new Rectangle(startPoint, endPoint, ShapeColor.BLACK, ShapeColor.WHITE);
//        r.draw(this);
//
//        Ellipse e = new Ellipse(startPoint, endPoint, ShapeColor.BLACK, ShapeColor.WHITE);
//        e.draw(this);
//
//        Triangle t = new Triangle(startPoint, endPoint, ShapeColor.BLACK, ShapeColor.WHITE);
//        t.draw(this);

        shapeToDraw.draw(this);

    }

    public void setShape(IShape shape){
        System.out.println("old start: " + shape.getStart().x + ", " + shape.getEnd().y);
        System.out.println("old end: " + shape.getEnd().x + ", " + shape.getEnd().y);

        //Find bounding box upper left (x,y) coordinate
        int startX = Math.min(shape.getStart().x, shape.getEnd().x);
        int startY = Math.min(shape.getStart().y, shape.getEnd().y);

        //Find bounding box lower right (x,y) coordinate
        int endX = Math.max(shape.getStart().x, shape.getEnd().x);
        int endY = Math.max(shape.getStart().y, shape.getEnd().y);

        //create new start and end points
        Point newStart = new Point();
        Point newEnd = new Point();

        //Reset start and end points
        newStart.setLocation(startX, startY);
        newEnd.setLocation(endX, endY);

        System.out.println("new start: " + newStart.x + ", " + newStart.y);
        System.out.println("new end: " + newEnd.x + ", " + newEnd.y);

        this.startPoint = newStart;
        this.endPoint = newEnd;
        this.shapeToDraw = shape;
    }
}
