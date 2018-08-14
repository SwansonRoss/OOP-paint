package model.interfaces;

import model.persistence.ApplicationState;
import model.shapeList;
import view.gui.PaintCanvas;

import java.awt.*;

public interface IClick {
    void run(Point start, Point end, PaintCanvas canvas, ApplicationState appState, shapeList list);
}
