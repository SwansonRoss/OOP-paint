package view.interfaces;

import view.EventName;
import view.gui.ClickHandler;

import javax.swing.*;

public interface IGuiWindow{
    JButton getButton(EventName eventName);

}
