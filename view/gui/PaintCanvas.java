package view.gui;

import model.Ellipse;
import model.Rectangle;
import model.ShapeColor;
import model.Triangle;
import model.interfaces.IShape;

import javax.swing.JComponent;
import java.awt.*;

public class PaintCanvas extends JComponent {

    private IShape shapeToDraw = null;


    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }

    public void paint(Graphics g){
        if(shapeToDraw != null)
            shapeToDraw.draw(this);

    }

    public void setShape(IShape shape){
        this.shapeToDraw = shape;
    }
}
