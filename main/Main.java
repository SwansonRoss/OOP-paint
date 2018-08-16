package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.ColorMapSingleton;
import model.dialogs.DialogProvider;
import model.interfaces.IDialogProvider;
import model.persistence.ApplicationState;
import view.gui.ClickHandler;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

import java.awt.*;
import java.awt.event.MouseListener;

public class Main {
    public static void main(String[] args){
        IGuiWindow guiWindow = new GuiWindow(new PaintCanvas());
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        ((GuiWindow) guiWindow).setAppState(appState);
        IJPaintController controller = new JPaintController(uiModule, appState);
        controller.setup();
        MouseListener ml = new ClickHandler(((GuiWindow) guiWindow).getCanvas(), appState);
        ((GuiWindow) guiWindow).setMouseListener(ml);

    }
}
