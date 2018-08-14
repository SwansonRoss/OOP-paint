package model;

import model.interfaces.IFillType;
import model.persistence.ApplicationState;

import java.security.InvalidParameterException;

public class determineFillStrategy {

    private ApplicationState applicationState;

    public determineFillStrategy(ApplicationState applicationState){
       this.applicationState = applicationState;
    }

    public IFillType getFillStrategy(){
        switch (applicationState.getActiveShapeShadingType()){
            case FILLED_IN:
                return new filledInStrategy();

            case OUTLINE:
                return new outlineStrategy();

            case OUTLINE_AND_FILLED_IN:
                return new outlineAndFilledStrategy();

        }
        throw(new InvalidParameterException("Invalid Fill Type"));
    }
}
