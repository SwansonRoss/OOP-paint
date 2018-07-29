package model;

import model.interfaces.IShapeStrategy;
import model.persistence.ApplicationState;

import java.security.InvalidParameterException;

public class determineShapeStrategy {
    ApplicationState appState;

    public determineShapeStrategy() {
    }

//    public static IShapeStrategy determineShape(){
//        switch (appState.getActiveShapeType()) {
//            case ELLIPSE:
//                return new ellipseStrategy();
//            case RECTANGLE:
//                return new rectangleStrategy();
//            case TRIANGLE:
//                return new triangleStrategy();
//        }
//    throw(new InvalidParameterException("Invalid Shape Type"));
//    }
}
