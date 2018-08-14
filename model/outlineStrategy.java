package model;

import model.interfaces.IFillType;

public class outlineStrategy implements IFillType {

    private final int OUTLINE_MODE = 0;

    @Override
    public int returnDrawMode(){
        return OUTLINE_MODE;
    }
}
