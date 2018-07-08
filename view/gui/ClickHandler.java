package view.gui;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClickHandler extends MouseAdapter{

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        System.out.println("clicked: "+ e.getX()+", "+e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        System.out.println("released: "+ e.getX()+", "+e.getY());
    }
}
