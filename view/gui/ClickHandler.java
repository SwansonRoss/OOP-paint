package view.gui;

import model.determineClickStrategy;
import model.determineShapeStrategy;
import model.interfaces.IClick;
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
        appState.setShapeList(list);
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

        determineClickStrategy findClickMode = new determineClickStrategy(appState);
        IClick clickMode = findClickMode.getClickStrategy();
        clickMode.run(startPoint, endPoint, canvas, appState, list);
    }
}
