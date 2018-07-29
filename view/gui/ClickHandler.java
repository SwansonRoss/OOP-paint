package view.gui;

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

    public ClickHandler(PaintCanvas canvas){
        this.canvas = canvas;
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

        System.out.println("Old end point: " + endPoint);
        System.out.println("Old start point: "+ startPoint);

        Point end = getEnd();
        Point start = getStart();

        System.out.println("New end point: " + end);
        System.out.println("New start point: "+ start);

        canvas.setShape(start.x, start.y, end.x-start.x, end.y-start.y);
        canvas.paint(null);
    }

    public Point getStart() {
        return getStartPoint();
    }

    private Point getStartPoint() {
        int x = Math.min(startPoint.x, endPoint.x);
        int y = Math.min(startPoint.y, endPoint.y);
        Point start = new Point();
        start.setLocation(x, y);
        return start;
    }

    public Point getEnd() {
        return getEndPoint();
    }

    private Point getEndPoint() {
        Point end = new Point();
        int x = Math.max(startPoint.x, endPoint.x);
        int y = Math.max(startPoint.y, endPoint.y);
        end.setLocation(x, y);
        return end;
    }

}
