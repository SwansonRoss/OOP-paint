package model;

import model.interfaces.IFillType;

public class filledInStrategy implements IFillType {

    private final int FILL_MODE = 1;

    @Override
    public int returnDrawMode(){
        return FILL_MODE;
    }
}
