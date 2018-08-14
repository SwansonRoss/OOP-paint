package model;

import model.interfaces.IClick;
import model.persistence.ApplicationState;

import java.security.InvalidParameterException;

public class determineClickStrategy {

    private ApplicationState appState;

    public determineClickStrategy(ApplicationState appState){
        this.appState = appState;
    }

    public IClick getClickStrategy(){
        switch (appState.getActiveStartAndEndPointMode()){
            case DRAW:
                return new drawMode();
            case SELECT:
                return new selectMode();
            case MOVE:
                return new moveMode();
        }
        throw(new InvalidParameterException("Invalid Click Type"));
    }
}
