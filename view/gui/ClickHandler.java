package view.gui;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Point;
import java.net.PortUnreachableException;

public class ClickHandler extends MouseAdapter{
    private Point startPoint = new Point();
    private Point endPoint = new Point();

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        System.out.println("clicked: "+ e.getPoint());
        startPoint = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        System.out.println("released: "+ e.getPoint());
        endPoint = e.getPoint();
    }

    public Point getStart() {
        return getStartPoint();
    }

    private Point getStartPoint() {
        return startPoint;
    }

    public Point getEnd() {
        return getEndPoint();
    }

    private Point getEndPoint() {
        return endPoint;
    }

}
