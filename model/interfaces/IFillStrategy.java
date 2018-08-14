package model.interfaces;

import model.persistence.ApplicationState;

public interface IFillStrategy {

    IFillType getFillType(ApplicationState applicationState);
}
