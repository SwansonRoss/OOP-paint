package view.gui;

import javax.swing.JComponent;
import java.awt.*;

public class PaintCanvas extends JComponent {

    private int x, y, width, height;


    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }

    public void paint(Graphics g){
        Graphics2D g2 = this.getGraphics2D();
        g2.drawRect(x, y, width, height);
    }

    public void setShape(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
