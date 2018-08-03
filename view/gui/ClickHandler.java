package view.gui;

import model.determineShapeStrategy;
import model.interfaces.IShape;
import model.interfaces.IShapeStrategy;
import model.persistence.ApplicationState;
import model.shapeList;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.security.PublicKey;
import java.text.AttributedCharacterIterator;
import java.util.Map;

public class ClickHandler extends MouseAdapter{
    private Point startPoint = new Point();
    private Point endPoint = new Point();
    private PaintCanvas canvas = null;
    private shapeList list = new shapeList();
    private GuiWindow window = null;
    private ApplicationState appState = null;

    public ClickHandler(PaintCanvas canvas, ApplicationState appState){

        this.canvas = canvas;
        this.appState = appState;
        list.setCanvas(canvas);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        startPoint = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        endPoint = e.getPoint();

//        canvas.setShape(startPoint, endPoint);
//        canvas.paint(null);

        addShapeToList(startPoint, endPoint, canvas, appState, list);
    }

    public void addShapeToList(Point start, Point end, PaintCanvas canvas, ApplicationState as, shapeList list){
        determineShapeStrategy findStrategy = new determineShapeStrategy(as);
        IShapeStrategy strategy = findStrategy.determineShape();
        IShape shape = strategy.getShapeStrategy(start, end, as);
        shape.addToList(list);
        list.drawShapes();

        System.out.println("A " + shape.toString() + "was just created. There are " + list.size() + "shapes in total");
    }

}
