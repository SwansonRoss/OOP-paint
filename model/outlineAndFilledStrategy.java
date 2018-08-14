package model;

import model.interfaces.IFillType;

public class outlineAndFilledStrategy implements IFillType {

    private final int FILL_AND_OUTLINE_MODE = 2;

    @Override
    public int returnDrawMode(){
        return FILL_AND_OUTLINE_MODE;
    }
}
