package model;

import model.interfaces.IUndoable;

import java.util.Stack;

public class CommandHistory {
    private static final Stack<IUndoable> undoStack = new Stack<>();
    private static final Stack<IUndoable> redoStack = new Stack<>();

    public static void add(IUndoable event){
        undoStack.push(event);
        redoStack.clear();
    }

    public static boolean undo() {
        boolean result = !undoStack.empty();
        if (result) {
            IUndoable undoEvent = undoStack.pop();
            redoStack.push(undoEvent);
            undoEvent.undo();
        }
        return result;
    }

    public static boolean redo() {
        boolean result = !redoStack.empty();
        if (result) {
            IUndoable redoEvent = redoStack.pop();
            undoStack.push(redoEvent);
            redoEvent.undo();
        }
        return result;
    }



}
